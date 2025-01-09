package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajotieneliquidacionoposterior extends GXProcedure
{
   public legajotieneliquidacionoposterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajotieneliquidacionoposterior.class ), "" );
   }

   public legajotieneliquidacionoposterior( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              String aP4 ,
                              boolean[] aP5 )
   {
      legajotieneliquidacionoposterior.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 )
   {
      legajotieneliquidacionoposterior.this.AV8CliCod = aP0;
      legajotieneliquidacionoposterior.this.AV9EmpCod = aP1;
      legajotieneliquidacionoposterior.this.AV10LegNumero = aP2;
      legajotieneliquidacionoposterior.this.AV11LiqPeriodo = aP3;
      legajotieneliquidacionoposterior.this.AV12TLiqCod = aP4;
      legajotieneliquidacionoposterior.this.aP5 = aP5;
      legajotieneliquidacionoposterior.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))) ;
      GXt_char1 = AV15quincenaTLiqCod ;
      GXt_char2 = AV15quincenaTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      legajotieneliquidacionoposterior.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      legajotieneliquidacionoposterior.this.GXt_char1 = GXv_char4[0] ;
      AV15quincenaTLiqCod = GXt_char1 ;
      if ( false )
      {
         new web.pendientescrearindices(remoteHandle, context).execute( ) ;
      }
      AV21GXLvl8 = (byte)(0) ;
      /* Using cursor P00WG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV12TLiqCod, AV11LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P00WG2_A32TLiqCod[0] ;
         n32TLiqCod = P00WG2_n32TLiqCod[0] ;
         A283LiqPeriodo = P00WG2_A283LiqPeriodo[0] ;
         A6LegNumero = P00WG2_A6LegNumero[0] ;
         A1EmpCod = P00WG2_A1EmpCod[0] ;
         A3CliCod = P00WG2_A3CliCod[0] ;
         A31LiqNro = P00WG2_A31LiqNro[0] ;
         AV21GXLvl8 = (byte)(1) ;
         AV13tiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( " tiene ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV21GXLvl8 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "no tiene ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV11LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &TLiqCod ", "")+GXutil.trim( AV12TLiqCod)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = legajotieneliquidacionoposterior.this.AV13tiene;
      this.aP6[0] = legajotieneliquidacionoposterior.this.AV17duplica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20Pgmname = "" ;
      AV15quincenaTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P00WG2_A32TLiqCod = new String[] {""} ;
      P00WG2_n32TLiqCod = new boolean[] {false} ;
      P00WG2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00WG2_A6LegNumero = new int[1] ;
      P00WG2_A1EmpCod = new short[1] ;
      P00WG2_A3CliCod = new int[1] ;
      P00WG2_A31LiqNro = new int[1] ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajotieneliquidacionoposterior__default(),
         new Object[] {
             new Object[] {
            P00WG2_A32TLiqCod, P00WG2_n32TLiqCod, P00WG2_A283LiqPeriodo, P00WG2_A6LegNumero, P00WG2_A1EmpCod, P00WG2_A3CliCod, P00WG2_A31LiqNro
            }
         }
      );
      AV20Pgmname = "legajoTieneLiquidacionOPosterior" ;
      /* GeneXus formulas. */
      AV20Pgmname = "legajoTieneLiquidacionOPosterior" ;
      Gx_err = (short)(0) ;
   }

   private byte AV21GXLvl8 ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV12TLiqCod ;
   private String AV20Pgmname ;
   private String AV15quincenaTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV13tiene ;
   private boolean AV17duplica ;
   private boolean n32TLiqCod ;
   private boolean[] aP6 ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P00WG2_A32TLiqCod ;
   private boolean[] P00WG2_n32TLiqCod ;
   private java.util.Date[] P00WG2_A283LiqPeriodo ;
   private int[] P00WG2_A6LegNumero ;
   private short[] P00WG2_A1EmpCod ;
   private int[] P00WG2_A3CliCod ;
   private int[] P00WG2_A31LiqNro ;
}

final  class legajotieneliquidacionoposterior__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00WG2", "SELECT TLiqCod, LiqPeriodo, LegNumero, EmpCod, CliCod, LiqNro FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and TLiqCod = ( ?) and LiqPeriodo >= ? ORDER BY CliCod, EmpCod, LegNumero, TLiqCod, LiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

