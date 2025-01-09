package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoeshabitual extends GXProcedure
{
   public conceptoeshabitual( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoeshabitual.class ), "" );
   }

   public conceptoeshabitual( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 ,
                              java.math.BigDecimal aP6 )
   {
      conceptoeshabitual.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        java.math.BigDecimal aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal aP6 ,
                             boolean[] aP7 )
   {
      conceptoeshabitual.this.AV10CliCod = aP0;
      conceptoeshabitual.this.AV11EmpCod = aP1;
      conceptoeshabitual.this.AV12LegNumero = aP2;
      conceptoeshabitual.this.AV24ConCodigo = aP3;
      conceptoeshabitual.this.AV13desde_LiqPeriodo = aP4;
      conceptoeshabitual.this.AV9hasta_LiqPeriodo = aP5;
      conceptoeshabitual.this.AV20proporcionHabitualPorUnaje = aP6;
      conceptoeshabitual.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV21ParmValue ;
      GXt_char2 = AV21ParmValue ;
      GXv_char3[0] = GXt_char2 ;
      new web.forzados_habitual_param(remoteHandle, context).execute( GXv_char3) ;
      conceptoeshabitual.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      conceptoeshabitual.this.GXt_char1 = GXv_char4[0] ;
      AV21ParmValue = GXt_char1 ;
      AV22forzadosHabConCodigo.fromJSonString(AV21ParmValue, null);
      AV23i = (short)(1) ;
      while ( AV23i <= AV22forzadosHabConCodigo.size() )
      {
         if ( GXutil.strcmp(AV24ConCodigo, (String)AV22forzadosHabConCodigo.elementAt(-1+AV23i)) == 0 )
         {
            AV25habitualEs = true ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV23i = (short)(AV23i+1) ;
      }
      AV18cantidadDeVecesLiquidado = (short)(0) ;
      /* Using cursor P01L82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LegNumero), AV24ConCodigo, AV13desde_LiqPeriodo, AV9hasta_LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1L82 = false ;
         A397DLiqPeriodo = P01L82_A397DLiqPeriodo[0] ;
         A394DConCodigo = P01L82_A394DConCodigo[0] ;
         A6LegNumero = P01L82_A6LegNumero[0] ;
         A1EmpCod = P01L82_A1EmpCod[0] ;
         A3CliCod = P01L82_A3CliCod[0] ;
         A31LiqNro = P01L82_A31LiqNro[0] ;
         A81LiqDSecuencial = P01L82_A81LiqDSecuencial[0] ;
         while ( (pr_default.getStatus(0) != 101) && ( P01L82_A3CliCod[0] == A3CliCod ) && ( P01L82_A1EmpCod[0] == A1EmpCod ) && ( P01L82_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01L82_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            if ( ! ( GXutil.dateCompare(GXutil.resetTime(P01L82_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
            {
               if (true) break;
            }
            brk1L82 = false ;
            A31LiqNro = P01L82_A31LiqNro[0] ;
            A81LiqDSecuencial = P01L82_A81LiqDSecuencial[0] ;
            brk1L82 = true ;
            pr_default.readNext(0);
         }
         AV18cantidadDeVecesLiquidado = (short)(AV18cantidadDeVecesLiquidado+1) ;
         if ( ! brk1L82 )
         {
            brk1L82 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      if ( AV18cantidadDeVecesLiquidado > (DecimalUtil.doubleToDec(GXutil.month( AV9hasta_LiqPeriodo)).multiply(AV20proporcionHabitualPorUnaje)).doubleValue() )
      {
         AV25habitualEs = true ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = conceptoeshabitual.this.AV25habitualEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21ParmValue = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV22forzadosHabConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P01L82_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01L82_A394DConCodigo = new String[] {""} ;
      P01L82_A6LegNumero = new int[1] ;
      P01L82_A1EmpCod = new short[1] ;
      P01L82_A3CliCod = new int[1] ;
      P01L82_A31LiqNro = new int[1] ;
      P01L82_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoeshabitual__default(),
         new Object[] {
             new Object[] {
            P01L82_A397DLiqPeriodo, P01L82_A394DConCodigo, P01L82_A6LegNumero, P01L82_A1EmpCod, P01L82_A3CliCod, P01L82_A31LiqNro, P01L82_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV23i ;
   private short AV18cantidadDeVecesLiquidado ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV20proporcionHabitualPorUnaje ;
   private String AV24ConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private java.util.Date AV13desde_LiqPeriodo ;
   private java.util.Date AV9hasta_LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV25habitualEs ;
   private boolean returnInSub ;
   private boolean brk1L82 ;
   private String AV21ParmValue ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01L82_A397DLiqPeriodo ;
   private String[] P01L82_A394DConCodigo ;
   private int[] P01L82_A6LegNumero ;
   private short[] P01L82_A1EmpCod ;
   private int[] P01L82_A3CliCod ;
   private int[] P01L82_A31LiqNro ;
   private int[] P01L82_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV22forzadosHabConCodigo ;
}

final  class conceptoeshabitual__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01L82", "SELECT DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, LiqNro, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo >= ?) AND (DLiqPeriodo <= ?) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
      }
   }

}

