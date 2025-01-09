package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayactualizacionpendiente extends GXProcedure
{
   public hayactualizacionpendiente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayactualizacionpendiente.class ), "" );
   }

   public hayactualizacionpendiente( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      hayactualizacionpendiente.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      hayactualizacionpendiente.this.AV9CliCod = aP0;
      hayactualizacionpendiente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV8Ahora ;
      new web.getahora(remoteHandle, context).execute( AV9CliCod, GXv_dtime1) ;
      hayactualizacionpendiente.this.AV8Ahora = GXv_dtime1[0] ;
      /* Using cursor P020J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8Ahora});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1881CliUpdCliCod = P020J2_A1881CliUpdCliCod[0] ;
         A1887CliUpdRelSec = P020J2_A1887CliUpdRelSec[0] ;
         A1964CliUpdRelHab = P020J2_A1964CliUpdRelHab[0] ;
         A1962CliUpdFecRel = P020J2_A1962CliUpdFecRel[0] ;
         A1883CliUpdDTApl = P020J2_A1883CliUpdDTApl[0] ;
         A3CliCod = P020J2_A3CliCod[0] ;
         A1964CliUpdRelHab = P020J2_A1964CliUpdRelHab[0] ;
         AV10hay = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = hayactualizacionpendiente.this.AV10hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Ahora = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      scmdbuf = "" ;
      P020J2_A1881CliUpdCliCod = new int[1] ;
      P020J2_A1887CliUpdRelSec = new int[1] ;
      P020J2_A1964CliUpdRelHab = new boolean[] {false} ;
      P020J2_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      P020J2_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      P020J2_A3CliCod = new int[1] ;
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayactualizacionpendiente__default(),
         new Object[] {
             new Object[] {
            P020J2_A1881CliUpdCliCod, P020J2_A1887CliUpdRelSec, P020J2_A1964CliUpdRelHab, P020J2_A1962CliUpdFecRel, P020J2_A1883CliUpdDTApl, P020J2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A1881CliUpdCliCod ;
   private int A1887CliUpdRelSec ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV8Ahora ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A1962CliUpdFecRel ;
   private java.util.Date A1883CliUpdDTApl ;
   private boolean AV10hay ;
   private boolean A1964CliUpdRelHab ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P020J2_A1881CliUpdCliCod ;
   private int[] P020J2_A1887CliUpdRelSec ;
   private boolean[] P020J2_A1964CliUpdRelHab ;
   private java.util.Date[] P020J2_A1962CliUpdFecRel ;
   private java.util.Date[] P020J2_A1883CliUpdDTApl ;
   private int[] P020J2_A3CliCod ;
}

final  class hayactualizacionpendiente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020J2", "SELECT T1.CliUpdCliCod AS CliUpdCliCod, T1.CliUpdRelSec AS CliUpdRelSec, T2.CliReHabilitado AS CliUpdRelHab, T1.CliUpdFecRel AS CliUpdFecRel, T1.CliUpdDTApl, T1.CliCod FROM (Cliente_Update T1 INNER JOIN Cliente_Release T2 ON T2.CliCod = T1.CliUpdCliCod AND T2.CliRelSec = T1.CliUpdRelSec) WHERE (T1.CliCod = ?) AND ((T1.CliUpdDTApl = DATE '00010101')) AND (T1.CliUpdFecRel < ?) AND (T2.CliReHabilitado = TRUE) ORDER BY T1.CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setDateTime(2, (java.util.Date)parms[1], false, true);
               return;
      }
   }

}

