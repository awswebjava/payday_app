package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrbasico extends GXProcedure
{
   public getmigrbasico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrbasico.class ), "" );
   }

   public getmigrbasico( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      getmigrbasico.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      getmigrbasico.this.AV10CliCod = aP0;
      getmigrbasico.this.AV8EmpCod = aP1;
      getmigrbasico.this.AV9MigrLegNumero = aP2;
      getmigrbasico.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00M12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P00M12_A87MigrLegNumero[0] ;
         A1EmpCod = P00M12_A1EmpCod[0] ;
         A3CliCod = P00M12_A3CliCod[0] ;
         A608MigrLegBasico = P00M12_A608MigrLegBasico[0] ;
         AV11MigrLegBasico = A608MigrLegBasico ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrbasico.this.AV11MigrLegBasico;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11MigrLegBasico = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00M12_A87MigrLegNumero = new int[1] ;
      P00M12_A1EmpCod = new short[1] ;
      P00M12_A3CliCod = new int[1] ;
      P00M12_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrbasico__default(),
         new Object[] {
             new Object[] {
            P00M12_A87MigrLegNumero, P00M12_A1EmpCod, P00M12_A3CliCod, P00M12_A608MigrLegBasico
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11MigrLegBasico ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00M12_A87MigrLegNumero ;
   private short[] P00M12_A1EmpCod ;
   private int[] P00M12_A3CliCod ;
   private java.math.BigDecimal[] P00M12_A608MigrLegBasico ;
}

final  class getmigrbasico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00M12", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegBasico FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

