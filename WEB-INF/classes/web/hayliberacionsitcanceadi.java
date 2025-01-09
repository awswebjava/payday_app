package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionsitcanceadi extends GXProcedure
{
   public hayliberacionsitcanceadi( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionsitcanceadi.class ), "" );
   }

   public hayliberacionsitcanceadi( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionsitcanceadi.this.aP2 = new boolean[] {false};
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
      hayliberacionsitcanceadi.this.AV8CliCod = aP0;
      hayliberacionsitcanceadi.this.AV9CliRelSec = aP1;
      hayliberacionsitcanceadi.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1898ConveAdiSitCanRelSec = P01VU2_A1898ConveAdiSitCanRelSec[0] ;
         A3CliCod = P01VU2_A3CliCod[0] ;
         A1564CliPaiConve = P01VU2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01VU2_A1565CliConvenio[0] ;
         A996ConveAdicod = P01VU2_A996ConveAdicod[0] ;
         A1824ConveAdiSitCancela = P01VU2_A1824ConveAdiSitCancela[0] ;
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
      this.aP2[0] = hayliberacionsitcanceadi.this.AV10hay;
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
      P01VU2_A1898ConveAdiSitCanRelSec = new int[1] ;
      P01VU2_A3CliCod = new int[1] ;
      P01VU2_A1564CliPaiConve = new short[1] ;
      P01VU2_A1565CliConvenio = new String[] {""} ;
      P01VU2_A996ConveAdicod = new String[] {""} ;
      P01VU2_A1824ConveAdiSitCancela = new String[] {""} ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1824ConveAdiSitCancela = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionsitcanceadi__default(),
         new Object[] {
             new Object[] {
            P01VU2_A1898ConveAdiSitCanRelSec, P01VU2_A3CliCod, P01VU2_A1564CliPaiConve, P01VU2_A1565CliConvenio, P01VU2_A996ConveAdicod, P01VU2_A1824ConveAdiSitCancela
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A1898ConveAdiSitCanRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1824ConveAdiSitCancela ;
   private boolean AV10hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VU2_A1898ConveAdiSitCanRelSec ;
   private int[] P01VU2_A3CliCod ;
   private short[] P01VU2_A1564CliPaiConve ;
   private String[] P01VU2_A1565CliConvenio ;
   private String[] P01VU2_A996ConveAdicod ;
   private String[] P01VU2_A1824ConveAdiSitCancela ;
}

final  class hayliberacionsitcanceadi__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VU2", "SELECT ConveAdiSitCanRelSec, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE (CliCod = ?) AND (ConveAdiSitCanRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[5])[0] = rslt.getString(6, 4);
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

