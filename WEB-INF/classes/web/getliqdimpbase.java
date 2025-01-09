package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpbase extends GXProcedure
{
   public getliqdimpbase( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpbase.class ), "" );
   }

   public getliqdimpbase( int remoteHandle ,
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
                           java.math.BigDecimal[] aP6 ,
                           boolean[] aP7 )
   {
      getliqdimpbase.this.aP8 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        boolean[] aP7 ,
                        byte[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             boolean[] aP7 ,
                             byte[] aP8 )
   {
      getliqdimpbase.this.AV13CliCod = aP0;
      getliqdimpbase.this.AV8EmpCod = aP1;
      getliqdimpbase.this.AV9LiqNro = aP2;
      getliqdimpbase.this.AV10LegNumero = aP3;
      getliqdimpbase.this.AV11ConCodigo = aP4;
      getliqdimpbase.this.AV19ProcesoLiquidacion = aP5;
      getliqdimpbase.this.aP6 = aP6;
      getliqdimpbase.this.aP7 = aP7;
      getliqdimpbase.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "CONCODIGO ", "")+GXutil.trim( AV11ConCodigo)+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))) ;
      AV26GXLvl4 = (byte)(0) ;
      /* Using cursor P01M52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV11ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P01M52_A394DConCodigo[0] ;
         A6LegNumero = P01M52_A6LegNumero[0] ;
         A31LiqNro = P01M52_A31LiqNro[0] ;
         A1EmpCod = P01M52_A1EmpCod[0] ;
         A3CliCod = P01M52_A3CliCod[0] ;
         A277LiqDValUni = P01M52_A277LiqDValUni[0] ;
         n277LiqDValUni = P01M52_n277LiqDValUni[0] ;
         A507LiqDCalculado = P01M52_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01M52_A763LiqDRecalculado[0] ;
         A764LiqDImpReCalcu = P01M52_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P01M52_A81LiqDSecuencial[0] ;
         AV26GXLvl4 = (byte)(1) ;
         AV14existe = true ;
         AV22LiqDValUni = A277LiqDValUni ;
         GXv_int1[0] = AV15LiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, AV19ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int1) ;
         getliqdimpbase.this.AV15LiqDCalculado = GXv_int1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "encuentra ... &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " &ProcesoLiquidacion ", "")+GXutil.trim( AV19ProcesoLiquidacion)+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV26GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV25Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getliqdimpbase.this.AV22LiqDValUni;
      this.aP7[0] = getliqdimpbase.this.AV14existe;
      this.aP8[0] = getliqdimpbase.this.AV15LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22LiqDValUni = DecimalUtil.ZERO ;
      AV25Pgmname = "" ;
      scmdbuf = "" ;
      P01M52_A394DConCodigo = new String[] {""} ;
      P01M52_A6LegNumero = new int[1] ;
      P01M52_A31LiqNro = new int[1] ;
      P01M52_A1EmpCod = new short[1] ;
      P01M52_A3CliCod = new int[1] ;
      P01M52_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M52_n277LiqDValUni = new boolean[] {false} ;
      P01M52_A507LiqDCalculado = new byte[1] ;
      P01M52_A763LiqDRecalculado = new short[1] ;
      P01M52_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M52_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_int1 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpbase__default(),
         new Object[] {
             new Object[] {
            P01M52_A394DConCodigo, P01M52_A6LegNumero, P01M52_A31LiqNro, P01M52_A1EmpCod, P01M52_A3CliCod, P01M52_A277LiqDValUni, P01M52_n277LiqDValUni, P01M52_A507LiqDCalculado, P01M52_A763LiqDRecalculado, P01M52_A764LiqDImpReCalcu,
            P01M52_A81LiqDSecuencial
            }
         }
      );
      AV25Pgmname = "getLiqDImpBase" ;
      /* GeneXus formulas. */
      AV25Pgmname = "getLiqDImpBase" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV26GXLvl4 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV22LiqDValUni ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV11ConCodigo ;
   private String AV19ProcesoLiquidacion ;
   private String AV25Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV14existe ;
   private boolean n277LiqDValUni ;
   private byte[] aP8 ;
   private java.math.BigDecimal[] aP6 ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P01M52_A394DConCodigo ;
   private int[] P01M52_A6LegNumero ;
   private int[] P01M52_A31LiqNro ;
   private short[] P01M52_A1EmpCod ;
   private int[] P01M52_A3CliCod ;
   private java.math.BigDecimal[] P01M52_A277LiqDValUni ;
   private boolean[] P01M52_n277LiqDValUni ;
   private byte[] P01M52_A507LiqDCalculado ;
   private short[] P01M52_A763LiqDRecalculado ;
   private java.math.BigDecimal[] P01M52_A764LiqDImpReCalcu ;
   private int[] P01M52_A81LiqDSecuencial ;
}

final  class getliqdimpbase__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01M52", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDValUni, LiqDCalculado, LiqDRecalculado, LiqDImpReCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

