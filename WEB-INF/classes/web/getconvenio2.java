package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvenio2 extends GXProcedure
{
   public getconvenio2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvenio2.class ), "" );
   }

   public getconvenio2( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 )
   {
      getconvenio2.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getconvenio2.this.AV12PaiCod = aP0;
      getconvenio2.this.AV10ConveCodigo = aP1;
      getconvenio2.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01TX2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12PaiCod), AV10ConveCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A9ConveCodigo = P01TX2_A9ConveCodigo[0] ;
         A46PaiCod = P01TX2_A46PaiCod[0] ;
         A160ConveDescri = P01TX2_A160ConveDescri[0] ;
         AV8ConveDescri = A160ConveDescri ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconvenio2.this.AV8ConveDescri;
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
      scmdbuf = "" ;
      P01TX2_A9ConveCodigo = new String[] {""} ;
      P01TX2_A46PaiCod = new short[1] ;
      P01TX2_A160ConveDescri = new String[] {""} ;
      A9ConveCodigo = "" ;
      A160ConveDescri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvenio2__default(),
         new Object[] {
             new Object[] {
            P01TX2_A9ConveCodigo, P01TX2_A46PaiCod, P01TX2_A160ConveDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV10ConveCodigo ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private String AV8ConveDescri ;
   private String A160ConveDescri ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01TX2_A9ConveCodigo ;
   private short[] P01TX2_A46PaiCod ;
   private String[] P01TX2_A160ConveDescri ;
}

final  class getconvenio2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TX2", "SELECT ConveCodigo, PaiCod, ConveDescri FROM Convenio WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

