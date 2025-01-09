package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionadicionalopcion extends GXProcedure
{
   public hayliberacionadicionalopcion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionadicionalopcion.class ), "" );
   }

   public hayliberacionadicionalopcion( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionadicionalopcion.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             boolean[] aP2 )
   {
      hayliberacionadicionalopcion.this.AV8CliCod = aP0;
      hayliberacionadicionalopcion.this.AV9CliRelSec = aP1;
      hayliberacionadicionalopcion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1900ConveAdiOpcRelSec = P01VS2_A1900ConveAdiOpcRelSec[0] ;
         A3CliCod = P01VS2_A3CliCod[0] ;
         A1564CliPaiConve = P01VS2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01VS2_A1565CliConvenio[0] ;
         A996ConveAdicod = P01VS2_A996ConveAdicod[0] ;
         A1011ConveAdiOpcCod = P01VS2_A1011ConveAdiOpcCod[0] ;
         AV10hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = hayliberacionadicionalopcion.this.AV10hay;
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
      P01VS2_A1900ConveAdiOpcRelSec = new int[1] ;
      P01VS2_A3CliCod = new int[1] ;
      P01VS2_A1564CliPaiConve = new short[1] ;
      P01VS2_A1565CliConvenio = new String[] {""} ;
      P01VS2_A996ConveAdicod = new String[] {""} ;
      P01VS2_A1011ConveAdiOpcCod = new short[1] ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionadicionalopcion__default(),
         new Object[] {
             new Object[] {
            P01VS2_A1900ConveAdiOpcRelSec, P01VS2_A3CliCod, P01VS2_A1564CliPaiConve, P01VS2_A1565CliConvenio, P01VS2_A996ConveAdicod, P01VS2_A1011ConveAdiOpcCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1564CliPaiConve ;
   private short A1011ConveAdiOpcCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A1900ConveAdiOpcRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private boolean AV10hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VS2_A1900ConveAdiOpcRelSec ;
   private int[] P01VS2_A3CliCod ;
   private short[] P01VS2_A1564CliPaiConve ;
   private String[] P01VS2_A1565CliConvenio ;
   private String[] P01VS2_A996ConveAdicod ;
   private short[] P01VS2_A1011ConveAdiOpcCod ;
}

final  class hayliberacionadicionalopcion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VS2", "SELECT ConveAdiOpcRelSec, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod FROM convenio_adicionalalicuotas WHERE (CliCod = ?) AND (ConveAdiOpcRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

