package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mesesganancias extends GXProcedure
{
   public mesesganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mesesganancias.class ), "" );
   }

   public mesesganancias( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            java.util.Date aP4 )
   {
      mesesganancias.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short[] aP5 )
   {
      mesesganancias.this.AV10CliCod = aP0;
      mesesganancias.this.AV11EmpCod = aP1;
      mesesganancias.this.AV8LiqNro = aP2;
      mesesganancias.this.AV12LegNumero = aP3;
      mesesganancias.this.AV17LiqPeriodo = aP4;
      mesesganancias.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9egresoTLiqCod ;
      GXt_char2 = AV9egresoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      mesesganancias.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      mesesganancias.this.GXt_char1 = GXv_char4[0] ;
      AV9egresoTLiqCod = GXt_char1 ;
      /* Using cursor P00W92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV8LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00W92_A31LiqNro[0] ;
         A1EmpCod = P00W92_A1EmpCod[0] ;
         A3CliCod = P00W92_A3CliCod[0] ;
         A32TLiqCod = P00W92_A32TLiqCod[0] ;
         n32TLiqCod = P00W92_n32TLiqCod[0] ;
         A283LiqPeriodo = P00W92_A283LiqPeriodo[0] ;
         if ( GXutil.strcmp(A32TLiqCod, AV9egresoTLiqCod) == 0 )
         {
            GXv_char4[0] = AV13LegContinua ;
            new web.getlegajocontinuaotroempleo(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LegNumero, GXv_char4) ;
            mesesganancias.this.AV13LegContinua = GXv_char4[0] ;
            if ( GXutil.strcmp(AV13LegContinua, "SI") != 0 )
            {
               GXv_int5[0] = AV14meses ;
               new web.mesesanio(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LegNumero, A283LiqPeriodo, GXv_int5) ;
               mesesganancias.this.AV14meses = GXv_int5[0] ;
            }
            else
            {
               AV14meses = (short)(GXutil.month( A283LiqPeriodo)) ;
            }
         }
         else
         {
            AV14meses = (short)(GXutil.month( A283LiqPeriodo)) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = mesesganancias.this.AV14meses;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9egresoTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P00W92_A31LiqNro = new int[1] ;
      P00W92_A1EmpCod = new short[1] ;
      P00W92_A3CliCod = new int[1] ;
      P00W92_A32TLiqCod = new String[] {""} ;
      P00W92_n32TLiqCod = new boolean[] {false} ;
      P00W92_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      AV13LegContinua = "" ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.mesesganancias__default(),
         new Object[] {
             new Object[] {
            P00W92_A31LiqNro, P00W92_A1EmpCod, P00W92_A3CliCod, P00W92_A32TLiqCod, P00W92_n32TLiqCod, P00W92_A283LiqPeriodo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV14meses ;
   private short A1EmpCod ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LiqNro ;
   private int AV12LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV9egresoTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV13LegContinua ;
   private String GXv_char4[] ;
   private java.util.Date AV17LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean n32TLiqCod ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00W92_A31LiqNro ;
   private short[] P00W92_A1EmpCod ;
   private int[] P00W92_A3CliCod ;
   private String[] P00W92_A32TLiqCod ;
   private boolean[] P00W92_n32TLiqCod ;
   private java.util.Date[] P00W92_A283LiqPeriodo ;
}

final  class mesesganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00W92", "SELECT LiqNro, EmpCod, CliCod, TLiqCod, LiqPeriodo FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
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

