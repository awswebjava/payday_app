package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvenio extends GXProcedure
{
   public getconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvenio.class ), "" );
   }

   public getconvenio( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getconvenio.this.aP3 = new boolean[] {false};
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
      getconvenio.this.AV11CliCod = aP0;
      getconvenio.this.AV10ConveCodigo = aP1;
      getconvenio.this.aP2 = aP2;
      getconvenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV12PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
      getconvenio.this.GXt_int1 = GXv_int2[0] ;
      AV12PaiCod = GXt_int1 ;
      /* Using cursor P00LZ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12PaiCod), AV10ConveCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A9ConveCodigo = P00LZ2_A9ConveCodigo[0] ;
         A46PaiCod = P00LZ2_A46PaiCod[0] ;
         A160ConveDescri = P00LZ2_A160ConveDescri[0] ;
         AV8ConveDescri = A160ConveDescri ;
         AV9existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconvenio.this.AV8ConveDescri;
      this.aP3[0] = getconvenio.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConveDescri = "" ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P00LZ2_A9ConveCodigo = new String[] {""} ;
      P00LZ2_A46PaiCod = new short[1] ;
      P00LZ2_A160ConveDescri = new String[] {""} ;
      A9ConveCodigo = "" ;
      A160ConveDescri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvenio__default(),
         new Object[] {
             new Object[] {
            P00LZ2_A9ConveCodigo, P00LZ2_A46PaiCod, P00LZ2_A160ConveDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV10ConveCodigo ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private boolean AV9existe ;
   private String AV8ConveDescri ;
   private String A160ConveDescri ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LZ2_A9ConveCodigo ;
   private short[] P00LZ2_A46PaiCod ;
   private String[] P00LZ2_A160ConveDescri ;
}

final  class getconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LZ2", "SELECT ConveCodigo, PaiCod, ConveDescri FROM Convenio WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

