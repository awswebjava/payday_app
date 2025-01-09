package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionconvenioimporte extends GXProcedure
{
   public hayliberacionconvenioimporte( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionconvenioimporte.class ), "" );
   }

   public hayliberacionconvenioimporte( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionconvenioimporte.this.aP2 = new boolean[] {false};
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
      hayliberacionconvenioimporte.this.AV8CliCod = aP0;
      hayliberacionconvenioimporte.this.AV9CliRelSec = aP1;
      hayliberacionconvenioimporte.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1896CliConveImpRelSec = P01VP2_A1896CliConveImpRelSec[0] ;
         A3CliCod = P01VP2_A3CliCod[0] ;
         A1564CliPaiConve = P01VP2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01VP2_A1565CliConvenio[0] ;
         A1587CliConveImpVig = P01VP2_A1587CliConveImpVig[0] ;
         A1588CliConveImpTipo = P01VP2_A1588CliConveImpTipo[0] ;
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
      this.aP2[0] = hayliberacionconvenioimporte.this.AV10hay;
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
      P01VP2_A1896CliConveImpRelSec = new int[1] ;
      P01VP2_A3CliCod = new int[1] ;
      P01VP2_A1564CliPaiConve = new short[1] ;
      P01VP2_A1565CliConvenio = new String[] {""} ;
      P01VP2_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01VP2_A1588CliConveImpTipo = new String[] {""} ;
      A1565CliConvenio = "" ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1588CliConveImpTipo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionconvenioimporte__default(),
         new Object[] {
             new Object[] {
            P01VP2_A1896CliConveImpRelSec, P01VP2_A3CliCod, P01VP2_A1564CliPaiConve, P01VP2_A1565CliConvenio, P01VP2_A1587CliConveImpVig, P01VP2_A1588CliConveImpTipo
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
   private int A1896CliConveImpRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A1588CliConveImpTipo ;
   private java.util.Date A1587CliConveImpVig ;
   private boolean AV10hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VP2_A1896CliConveImpRelSec ;
   private int[] P01VP2_A3CliCod ;
   private short[] P01VP2_A1564CliPaiConve ;
   private String[] P01VP2_A1565CliConvenio ;
   private java.util.Date[] P01VP2_A1587CliConveImpVig ;
   private String[] P01VP2_A1588CliConveImpTipo ;
}

final  class hayliberacionconvenioimporte__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VP2", "SELECT CliConveImpRelSec, CliCod, CliPaiConve, CliConvenio, CliConveImpVig, CliConveImpTipo FROM clienteConvenio_importes WHERE (CliCod = ?) AND (CliConveImpRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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

