package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextconvhsexsec extends GXProcedure
{
   public getnextconvhsexsec( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextconvhsexsec.class ), "" );
   }

   public getnextconvhsexsec( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            String aP2 )
   {
      getnextconvhsexsec.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             short[] aP3 )
   {
      getnextconvhsexsec.this.AV9CliCod = aP0;
      getnextconvhsexsec.this.AV10CliPaiConve = aP1;
      getnextconvhsexsec.this.AV11CliConvenio = aP2;
      getnextconvhsexsec.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02M62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10CliPaiConve), AV11CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02M62_A3CliCod[0] ;
         A1564CliPaiConve = P02M62_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02M62_A1565CliConvenio[0] ;
         A1327ConveHsExSec = P02M62_A1327ConveHsExSec[0] ;
         AV8ConveHsExSec = A1327ConveHsExSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV8ConveHsExSec = (short)(AV8ConveHsExSec+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getnextconvhsexsec.this.AV8ConveHsExSec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02M62_A3CliCod = new int[1] ;
      P02M62_A1564CliPaiConve = new short[1] ;
      P02M62_A1565CliConvenio = new String[] {""} ;
      P02M62_A1327ConveHsExSec = new short[1] ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextconvhsexsec__default(),
         new Object[] {
             new Object[] {
            P02M62_A3CliCod, P02M62_A1564CliPaiConve, P02M62_A1565CliConvenio, P02M62_A1327ConveHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short AV8ConveHsExSec ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV11CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02M62_A3CliCod ;
   private short[] P02M62_A1564CliPaiConve ;
   private String[] P02M62_A1565CliConvenio ;
   private short[] P02M62_A1327ConveHsExSec ;
}

final  class getnextconvhsexsec__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02M62", "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsExSec FROM Convenio_horasextras_porDia WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

