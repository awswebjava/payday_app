package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconveniolikedescrip extends GXProcedure
{
   public getconveniolikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconveniolikedescrip.class ), "" );
   }

   public getconveniolikedescrip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getconveniolikedescrip.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getconveniolikedescrip.this.AV11CliCod = aP0;
      getconveniolikedescrip.this.AV8ConveDescri = aP1;
      getconveniolikedescrip.this.aP2 = aP2;
      getconveniolikedescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV12PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int1) ;
      getconveniolikedescrip.this.AV12PaiCod = GXv_int1[0] ;
      lV8ConveDescri = GXutil.concat( GXutil.rtrim( AV8ConveDescri), "%", "") ;
      /* Using cursor P00MF2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12PaiCod), lV8ConveDescri, AV8ConveDescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A687ConveDescriSinAc = P00MF2_A687ConveDescriSinAc[0] ;
         A46PaiCod = P00MF2_A46PaiCod[0] ;
         A9ConveCodigo = P00MF2_A9ConveCodigo[0] ;
         AV10ConveCodigo = A9ConveCodigo ;
         AV9existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconveniolikedescrip.this.AV10ConveCodigo;
      this.aP3[0] = getconveniolikedescrip.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConveCodigo = "" ;
      GXv_int1 = new short[1] ;
      lV8ConveDescri = "" ;
      scmdbuf = "" ;
      P00MF2_A687ConveDescriSinAc = new String[] {""} ;
      P00MF2_A46PaiCod = new short[1] ;
      P00MF2_A9ConveCodigo = new String[] {""} ;
      A687ConveDescriSinAc = "" ;
      A9ConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconveniolikedescrip__default(),
         new Object[] {
             new Object[] {
            P00MF2_A687ConveDescriSinAc, P00MF2_A46PaiCod, P00MF2_A9ConveCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short GXv_int1[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV10ConveCodigo ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private boolean AV9existe ;
   private String AV8ConveDescri ;
   private String lV8ConveDescri ;
   private String A687ConveDescriSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00MF2_A687ConveDescriSinAc ;
   private short[] P00MF2_A46PaiCod ;
   private String[] P00MF2_A9ConveCodigo ;
}

final  class getconveniolikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MF2", "SELECT ConveDescriSinAc, PaiCod, ConveCodigo FROM Convenio WHERE (PaiCod = ?) AND (ConveDescriSinAc like '%' || ?) AND (ConveDescriSinAc <> ( ?)) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400);
               stmt.setVarchar(3, (String)parms[2], 400);
               return;
      }
   }

}

