package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deduceconyuge extends GXProcedure
{
   public deduceconyuge( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deduceconyuge.class ), "" );
   }

   public deduceconyuge( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      deduceconyuge.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      deduceconyuge.this.AV12CliCod = aP0;
      deduceconyuge.this.AV11EmpCod = aP1;
      deduceconyuge.this.AV8LegNumero = aP2;
      deduceconyuge.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl5 = (byte)(0) ;
      /* Using cursor P00QG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A30ParCod = P00QG2_A30ParCod[0] ;
         A2274ParenTipo = P00QG2_A2274ParenTipo[0] ;
         A6LegNumero = P00QG2_A6LegNumero[0] ;
         A1EmpCod = P00QG2_A1EmpCod[0] ;
         A3CliCod = P00QG2_A3CliCod[0] ;
         A220FamTomaDeducImpGan = P00QG2_A220FamTomaDeducImpGan[0] ;
         A29LegOrden = P00QG2_A29LegOrden[0] ;
         A2274ParenTipo = P00QG2_A2274ParenTipo[0] ;
         AV15GXLvl5 = (byte)(1) ;
         AV10deduceConyuge = GXutil.trim( GXutil.str( A220FamTomaDeducImpGan, 6, 4)) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl5 == 0 )
      {
         AV10deduceConyuge = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = deduceconyuge.this.AV10deduceConyuge;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10deduceConyuge = "" ;
      scmdbuf = "" ;
      P00QG2_A30ParCod = new String[] {""} ;
      P00QG2_A2274ParenTipo = new String[] {""} ;
      P00QG2_A6LegNumero = new int[1] ;
      P00QG2_A1EmpCod = new short[1] ;
      P00QG2_A3CliCod = new int[1] ;
      P00QG2_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QG2_A29LegOrden = new short[1] ;
      A30ParCod = "" ;
      A2274ParenTipo = "" ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deduceconyuge__default(),
         new Object[] {
             new Object[] {
            P00QG2_A30ParCod, P00QG2_A2274ParenTipo, P00QG2_A6LegNumero, P00QG2_A1EmpCod, P00QG2_A3CliCod, P00QG2_A220FamTomaDeducImpGan, P00QG2_A29LegOrden
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl5 ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short A29LegOrden ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private String AV10deduceConyuge ;
   private String scmdbuf ;
   private String A30ParCod ;
   private String A2274ParenTipo ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00QG2_A30ParCod ;
   private String[] P00QG2_A2274ParenTipo ;
   private int[] P00QG2_A6LegNumero ;
   private short[] P00QG2_A1EmpCod ;
   private int[] P00QG2_A3CliCod ;
   private java.math.BigDecimal[] P00QG2_A220FamTomaDeducImpGan ;
   private short[] P00QG2_A29LegOrden ;
}

final  class deduceconyuge__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QG2", "SELECT T1.ParCod, T2.ParenTipo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.FamTomaDeducImpGan, T1.LegOrden FROM (LegajoFamilia T1 INNER JOIN Parentesco T2 ON T2.CliCod = T1.CliCod AND T2.ParCod = T1.ParCod) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T2.ParenTipo = ( '1')) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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

