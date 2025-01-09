package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getageimportedeliq extends GXProcedure
{
   public getageimportedeliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getageimportedeliq.class ), "" );
   }

   public getageimportedeliq( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           String aP3 ,
                                           int aP4 )
   {
      getageimportedeliq.this.aP5 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        int aP4 ,
                        java.math.BigDecimal[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             int aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      getageimportedeliq.this.AV8CliCod = aP0;
      getageimportedeliq.this.AV9EmpCod = aP1;
      getageimportedeliq.this.AV10LegNumero = aP2;
      getageimportedeliq.this.AV13ConCodigo = aP3;
      getageimportedeliq.this.AV12AgeLiqNro = aP4;
      getageimportedeliq.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02E32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV13ConCodigo, Integer.valueOf(AV12AgeLiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P02E32_A26ConCodigo[0] ;
         A1254AgeLiqNro = P02E32_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P02E32_n1254AgeLiqNro[0] ;
         A6LegNumero = P02E32_A6LegNumero[0] ;
         A1EmpCod = P02E32_A1EmpCod[0] ;
         A3CliCod = P02E32_A3CliCod[0] ;
         A113AgeImporte = P02E32_A113AgeImporte[0] ;
         n113AgeImporte = P02E32_n113AgeImporte[0] ;
         A25AgeOrden = P02E32_A25AgeOrden[0] ;
         AV11AgeImporte = A113AgeImporte ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getageimportedeliq.this.AV11AgeImporte;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11AgeImporte = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P02E32_A26ConCodigo = new String[] {""} ;
      P02E32_A1254AgeLiqNro = new int[1] ;
      P02E32_n1254AgeLiqNro = new boolean[] {false} ;
      P02E32_A6LegNumero = new int[1] ;
      P02E32_A1EmpCod = new short[1] ;
      P02E32_A3CliCod = new int[1] ;
      P02E32_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02E32_n113AgeImporte = new boolean[] {false} ;
      P02E32_A25AgeOrden = new short[1] ;
      A26ConCodigo = "" ;
      A113AgeImporte = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getageimportedeliq__default(),
         new Object[] {
             new Object[] {
            P02E32_A26ConCodigo, P02E32_A1254AgeLiqNro, P02E32_n1254AgeLiqNro, P02E32_A6LegNumero, P02E32_A1EmpCod, P02E32_A3CliCod, P02E32_A113AgeImporte, P02E32_n113AgeImporte, P02E32_A25AgeOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int AV12AgeLiqNro ;
   private int A1254AgeLiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV11AgeImporte ;
   private java.math.BigDecimal A113AgeImporte ;
   private String AV13ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean n1254AgeLiqNro ;
   private boolean n113AgeImporte ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P02E32_A26ConCodigo ;
   private int[] P02E32_A1254AgeLiqNro ;
   private boolean[] P02E32_n1254AgeLiqNro ;
   private int[] P02E32_A6LegNumero ;
   private short[] P02E32_A1EmpCod ;
   private int[] P02E32_A3CliCod ;
   private java.math.BigDecimal[] P02E32_A113AgeImporte ;
   private boolean[] P02E32_n113AgeImporte ;
   private short[] P02E32_A25AgeOrden ;
}

final  class getageimportedeliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02E32", "SELECT ConCodigo, AgeLiqNro, LegNumero, EmpCod, CliCod, AgeImporte, AgeOrden FROM AgendaNovedades WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and ConCodigo = ( ?)) AND (AgeLiqNro = ?) ORDER BY CliCod, EmpCod, LegNumero, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(7);
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

