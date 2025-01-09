package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliberacionconveniovacaciones extends GXProcedure
{
   public hayliberacionconveniovacaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliberacionconveniovacaciones.class ), "" );
   }

   public hayliberacionconveniovacaciones( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      hayliberacionconveniovacaciones.this.aP2 = new boolean[] {false};
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
      hayliberacionconveniovacaciones.this.AV8CliCod = aP0;
      hayliberacionconveniovacaciones.this.AV9CliRelSec = aP1;
      hayliberacionconveniovacaciones.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01VW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Integer.valueOf(AV9CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1902ConveVacRelSec = P01VW2_A1902ConveVacRelSec[0] ;
         A3CliCod = P01VW2_A3CliCod[0] ;
         A1564CliPaiConve = P01VW2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01VW2_A1565CliConvenio[0] ;
         A1575CliConveVig = P01VW2_A1575CliConveVig[0] ;
         A1761CliConveVacDesAnt = P01VW2_A1761CliConveVacDesAnt[0] ;
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
      this.aP2[0] = hayliberacionconveniovacaciones.this.AV10hay;
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
      P01VW2_A1902ConveVacRelSec = new int[1] ;
      P01VW2_A3CliCod = new int[1] ;
      P01VW2_A1564CliPaiConve = new short[1] ;
      P01VW2_A1565CliConvenio = new String[] {""} ;
      P01VW2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01VW2_A1761CliConveVacDesAnt = new byte[1] ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliberacionconveniovacaciones__default(),
         new Object[] {
             new Object[] {
            P01VW2_A1902ConveVacRelSec, P01VW2_A3CliCod, P01VW2_A1564CliPaiConve, P01VW2_A1565CliConvenio, P01VW2_A1575CliConveVig, P01VW2_A1761CliConveVacDesAnt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1761CliConveVacDesAnt ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9CliRelSec ;
   private int A1902ConveVacRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV10hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01VW2_A1902ConveVacRelSec ;
   private int[] P01VW2_A3CliCod ;
   private short[] P01VW2_A1564CliPaiConve ;
   private String[] P01VW2_A1565CliConvenio ;
   private java.util.Date[] P01VW2_A1575CliConveVig ;
   private byte[] P01VW2_A1761CliConveVacDesAnt ;
}

final  class hayliberacionconveniovacaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01VW2", "SELECT ConveVacRelSec, CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE (CliCod = ?) AND (ConveVacRelSec = ?) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[5])[0] = rslt.getByte(6);
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

