package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ajustar extends GXProcedure
{
   public ajustar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustar.class ), "" );
   }

   public ajustar( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      ajustar.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 )
   {
      ajustar.this.AV13CliCod = aP0;
      ajustar.this.AV12EmpCod = aP1;
      ajustar.this.AV11LiqNro = aP2;
      ajustar.this.AV10LegNumero = aP3;
      ajustar.this.AV14LiqAjuConcepto = aP4;
      ajustar.this.AV8LiqAjuImporte = aP5[0];
      this.aP5 = aP5;
      ajustar.this.AV9LiqAjuCant = aP6[0];
      this.aP6 = aP6;
      ajustar.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01GA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero), AV14LiqAjuConcepto});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1540LiqAjuConcepto = P01GA2_A1540LiqAjuConcepto[0] ;
         A6LegNumero = P01GA2_A6LegNumero[0] ;
         A31LiqNro = P01GA2_A31LiqNro[0] ;
         A1EmpCod = P01GA2_A1EmpCod[0] ;
         A3CliCod = P01GA2_A3CliCod[0] ;
         A1544LiqAjuImporte = P01GA2_A1544LiqAjuImporte[0] ;
         A1545LiqAjuCant = P01GA2_A1545LiqAjuCant[0] ;
         A1541LiqAjuNro = P01GA2_A1541LiqAjuNro[0] ;
         A1543LiqAjuSec = P01GA2_A1543LiqAjuSec[0] ;
         AV8LiqAjuImporte = AV8LiqAjuImporte.add(A1544LiqAjuImporte) ;
         AV9LiqAjuCant = AV9LiqAjuCant.add(A1545LiqAjuCant) ;
         if ( A1544LiqAjuImporte.doubleValue() > 0 )
         {
            AV15LiqDLog += httpContext.getMessage( ". Ajuste de + ", "") ;
         }
         else
         {
            AV15LiqDLog += httpContext.getMessage( ". Ajuste de ", "") ;
         }
         AV15LiqDLog += GXutil.trim( GXutil.str( A1544LiqAjuImporte, 14, 2)) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = ajustar.this.AV8LiqAjuImporte;
      this.aP6[0] = ajustar.this.AV9LiqAjuCant;
      this.aP7[0] = ajustar.this.AV15LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15LiqDLog = "" ;
      scmdbuf = "" ;
      P01GA2_A1540LiqAjuConcepto = new String[] {""} ;
      P01GA2_A6LegNumero = new int[1] ;
      P01GA2_A31LiqNro = new int[1] ;
      P01GA2_A1EmpCod = new short[1] ;
      P01GA2_A3CliCod = new int[1] ;
      P01GA2_A1544LiqAjuImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GA2_A1545LiqAjuCant = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GA2_A1541LiqAjuNro = new short[1] ;
      P01GA2_A1543LiqAjuSec = new short[1] ;
      A1540LiqAjuConcepto = "" ;
      A1544LiqAjuImporte = DecimalUtil.ZERO ;
      A1545LiqAjuCant = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustar__default(),
         new Object[] {
             new Object[] {
            P01GA2_A1540LiqAjuConcepto, P01GA2_A6LegNumero, P01GA2_A31LiqNro, P01GA2_A1EmpCod, P01GA2_A3CliCod, P01GA2_A1544LiqAjuImporte, P01GA2_A1545LiqAjuCant, P01GA2_A1541LiqAjuNro, P01GA2_A1543LiqAjuSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short A1541LiqAjuNro ;
   private short A1543LiqAjuSec ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8LiqAjuImporte ;
   private java.math.BigDecimal AV9LiqAjuCant ;
   private java.math.BigDecimal A1544LiqAjuImporte ;
   private java.math.BigDecimal A1545LiqAjuCant ;
   private String AV14LiqAjuConcepto ;
   private String scmdbuf ;
   private String A1540LiqAjuConcepto ;
   private String AV15LiqDLog ;
   private String[] aP7 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GA2_A1540LiqAjuConcepto ;
   private int[] P01GA2_A6LegNumero ;
   private int[] P01GA2_A31LiqNro ;
   private short[] P01GA2_A1EmpCod ;
   private int[] P01GA2_A3CliCod ;
   private java.math.BigDecimal[] P01GA2_A1544LiqAjuImporte ;
   private java.math.BigDecimal[] P01GA2_A1545LiqAjuCant ;
   private short[] P01GA2_A1541LiqAjuNro ;
   private short[] P01GA2_A1543LiqAjuSec ;
}

final  class ajustar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GA2", "SELECT LiqAjuConcepto, LegNumero, LiqNro, EmpCod, CliCod, LiqAjuImporte, LiqAjuCant, LiqAjuNro, LiqAjuSec FROM LiquidacionAjustedetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqAjuConcepto = ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
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

