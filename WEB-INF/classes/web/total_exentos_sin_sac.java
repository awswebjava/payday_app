package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class total_exentos_sin_sac extends GXProcedure
{
   public total_exentos_sin_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( total_exentos_sin_sac.class ), "" );
   }

   public total_exentos_sin_sac( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           String aP4 ,
                           String aP5 ,
                           boolean aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           String[] aP8 )
   {
      total_exentos_sin_sac.this.aP9 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        byte[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 )
   {
      total_exentos_sin_sac.this.AV9CliCod = aP0;
      total_exentos_sin_sac.this.AV10EmpCod = aP1;
      total_exentos_sin_sac.this.AV11LiqNro = aP2;
      total_exentos_sin_sac.this.AV12LegNumero = aP3;
      total_exentos_sin_sac.this.AV14ConCodigo = aP4;
      total_exentos_sin_sac.this.AV22ProcesoLiquidacion = aP5;
      total_exentos_sin_sac.this.AV23insertandoConceptos = aP6;
      total_exentos_sin_sac.this.aP7 = aP7;
      total_exentos_sin_sac.this.aP8 = aP8;
      total_exentos_sin_sac.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV25exentosAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg_totalmenteexenta(remoteHandle, context).execute( AV9CliCod, GXv_int2) ;
      total_exentos_sin_sac.this.GXt_int1 = GXv_int2[0] ;
      AV25exentosAplIIGG = GXt_int1 ;
      AV16LiqDCalculado = (byte)(1) ;
      /* Using cursor P016O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1121AplIIGGPrrtear = P016O2_A1121AplIIGGPrrtear[0] ;
         A1117AplIIGGExenCon = P016O2_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P016O2_n1117AplIIGGExenCon[0] ;
         A3CliCod = P016O2_A3CliCod[0] ;
         A1112AplIIGG = P016O2_A1112AplIIGG[0] ;
         AV30exentosF1357ConCodigo.add(GXutil.trim( A1117AplIIGGExenCon), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&exentosF1357ConCodigo ", "")+GXutil.trim( AV30exentosF1357ConCodigo.toJSonString(false))) ;
      GXt_char3 = AV28sac_DSubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2gananciassac(remoteHandle, context).execute( GXv_char4) ;
      total_exentos_sin_sac.this.GXt_char3 = GXv_char4[0] ;
      AV28sac_DSubTipoConCod2 = GXt_char3 ;
      AV37GXLvl17 = (byte)(0) ;
      /* Using cursor P016O3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV12LegNumero), AV28sac_DSubTipoConCod2, Short.valueOf(AV25exentosAplIIGG)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A732DSubTipoConCod2 = P016O3_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P016O3_n732DSubTipoConCod2[0] ;
         A1122DAplIIGG = P016O3_A1122DAplIIGG[0] ;
         n1122DAplIIGG = P016O3_n1122DAplIIGG[0] ;
         A6LegNumero = P016O3_A6LegNumero[0] ;
         A31LiqNro = P016O3_A31LiqNro[0] ;
         A1EmpCod = P016O3_A1EmpCod[0] ;
         A3CliCod = P016O3_A3CliCod[0] ;
         A394DConCodigo = P016O3_A394DConCodigo[0] ;
         A764LiqDImpReCalcu = P016O3_A764LiqDImpReCalcu[0] ;
         A507LiqDCalculado = P016O3_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P016O3_A763LiqDRecalculado[0] ;
         A81LiqDSecuencial = P016O3_A81LiqDSecuencial[0] ;
         AV37GXLvl17 = (byte)(1) ;
         AV32i = (short)(1) ;
         AV31estaExluido = false ;
         while ( AV32i <= AV30exentosF1357ConCodigo.size() )
         {
            if ( GXutil.strcmp(GXutil.trim( A394DConCodigo), GXutil.trim( (String)AV30exentosF1357ConCodigo.elementAt(-1+AV32i))) == 0 )
            {
               AV31estaExluido = true ;
               if (true) break;
            }
            AV32i = (short)(AV32i+1) ;
         }
         if ( ! AV31estaExluido )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "DConCodigo ", "")+GXutil.trim( A394DConCodigo)) ;
            AV17Importe = AV17Importe.add(A764LiqDImpReCalcu) ;
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            if ( ( new web.dependenciaresuelta2(remoteHandle, context).executeUdp( AV9CliCod, A394DConCodigo, AV22ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado) == ( 0 )) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV16LiqDCalculado = (byte)(0) ;
               AV21error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A394DConCodigo) ;
               pr_default.close(1);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV19collection_ConCodigo.add(GXutil.trim( A394DConCodigo), 0);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV37GXLvl17 == 0 )
      {
         AV16LiqDCalculado = (byte)(0) ;
         AV21error = httpContext.getMessage( "Sin registros", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = total_exentos_sin_sac.this.AV17Importe;
      this.aP8[0] = total_exentos_sin_sac.this.AV21error;
      this.aP9[0] = total_exentos_sin_sac.this.AV16LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Importe = DecimalUtil.ZERO ;
      AV21error = "" ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P016O2_A1121AplIIGGPrrtear = new String[] {""} ;
      P016O2_A1117AplIIGGExenCon = new String[] {""} ;
      P016O2_n1117AplIIGGExenCon = new boolean[] {false} ;
      P016O2_A3CliCod = new int[1] ;
      P016O2_A1112AplIIGG = new short[1] ;
      A1121AplIIGGPrrtear = "" ;
      A1117AplIIGGExenCon = "" ;
      AV30exentosF1357ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36Pgmname = "" ;
      AV28sac_DSubTipoConCod2 = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      P016O3_A732DSubTipoConCod2 = new String[] {""} ;
      P016O3_n732DSubTipoConCod2 = new boolean[] {false} ;
      P016O3_A1122DAplIIGG = new short[1] ;
      P016O3_n1122DAplIIGG = new boolean[] {false} ;
      P016O3_A6LegNumero = new int[1] ;
      P016O3_A31LiqNro = new int[1] ;
      P016O3_A1EmpCod = new short[1] ;
      P016O3_A3CliCod = new int[1] ;
      P016O3_A394DConCodigo = new String[] {""} ;
      P016O3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P016O3_A507LiqDCalculado = new byte[1] ;
      P016O3_A763LiqDRecalculado = new short[1] ;
      P016O3_A81LiqDSecuencial = new int[1] ;
      A732DSubTipoConCod2 = "" ;
      A394DConCodigo = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV19collection_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.total_exentos_sin_sac__default(),
         new Object[] {
             new Object[] {
            P016O2_A1121AplIIGGPrrtear, P016O2_A1117AplIIGGExenCon, P016O2_n1117AplIIGGExenCon, P016O2_A3CliCod, P016O2_A1112AplIIGG
            }
            , new Object[] {
            P016O3_A732DSubTipoConCod2, P016O3_n732DSubTipoConCod2, P016O3_A1122DAplIIGG, P016O3_n1122DAplIIGG, P016O3_A6LegNumero, P016O3_A31LiqNro, P016O3_A1EmpCod, P016O3_A3CliCod, P016O3_A394DConCodigo, P016O3_A764LiqDImpReCalcu,
            P016O3_A507LiqDCalculado, P016O3_A763LiqDRecalculado, P016O3_A81LiqDSecuencial
            }
         }
      );
      AV36Pgmname = "total_exentos_sin_sac" ;
      /* GeneXus formulas. */
      AV36Pgmname = "total_exentos_sin_sac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqDCalculado ;
   private byte AV37GXLvl17 ;
   private byte A507LiqDCalculado ;
   private short AV10EmpCod ;
   private short AV25exentosAplIIGG ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1112AplIIGG ;
   private short A1122DAplIIGG ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV32i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV12LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV17Importe ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV14ConCodigo ;
   private String AV22ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A1121AplIIGGPrrtear ;
   private String A1117AplIIGGExenCon ;
   private String AV36Pgmname ;
   private String AV28sac_DSubTipoConCod2 ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String A732DSubTipoConCod2 ;
   private String A394DConCodigo ;
   private boolean AV23insertandoConceptos ;
   private boolean n1117AplIIGGExenCon ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n1122DAplIIGG ;
   private boolean AV31estaExluido ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV21error ;
   private byte[] aP9 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P016O2_A1121AplIIGGPrrtear ;
   private String[] P016O2_A1117AplIIGGExenCon ;
   private boolean[] P016O2_n1117AplIIGGExenCon ;
   private int[] P016O2_A3CliCod ;
   private short[] P016O2_A1112AplIIGG ;
   private String[] P016O3_A732DSubTipoConCod2 ;
   private boolean[] P016O3_n732DSubTipoConCod2 ;
   private short[] P016O3_A1122DAplIIGG ;
   private boolean[] P016O3_n1122DAplIIGG ;
   private int[] P016O3_A6LegNumero ;
   private int[] P016O3_A31LiqNro ;
   private short[] P016O3_A1EmpCod ;
   private int[] P016O3_A3CliCod ;
   private String[] P016O3_A394DConCodigo ;
   private java.math.BigDecimal[] P016O3_A764LiqDImpReCalcu ;
   private byte[] P016O3_A507LiqDCalculado ;
   private short[] P016O3_A763LiqDRecalculado ;
   private int[] P016O3_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV30exentosF1357ConCodigo ;
   private GXSimpleCollection<String> AV19collection_ConCodigo ;
}

final  class total_exentos_sin_sac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P016O2", "SELECT AplIIGGPrrtear, AplIIGGExenCon, CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE (CliCod = ?) AND (Not (char_length(trim(trailing ' ' from AplIIGGExenCon))=0)) AND (AplIIGGPrrtear = ( 'FIJA')) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P016O3", "SELECT DSubTipoConCod2, DAplIIGG, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDImpReCalcu, LiqDCalculado, LiqDRecalculado, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DSubTipoConCod2 <> ( ?)) AND (DAplIIGG = ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((byte[]) buf[10])[0] = rslt.getByte(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((int[]) buf[12])[0] = rslt.getInt(11);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

