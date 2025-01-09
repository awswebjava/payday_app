package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getvalorpropadi extends GXProcedure
{
   public getvalorpropadi( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getvalorpropadi.class ), "" );
   }

   public getvalorpropadi( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     String aP3 ,
                                     boolean[] aP4 ,
                                     java.math.BigDecimal[] aP5 ,
                                     String[] aP6 )
   {
      getvalorpropadi.this.aP7 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        boolean[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 ,
                        java.util.Date[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             boolean[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             java.util.Date[] aP7 )
   {
      getvalorpropadi.this.AV9CliCod = aP0;
      getvalorpropadi.this.AV8EmpCod = aP1;
      getvalorpropadi.this.AV10LegNumero = aP2;
      getvalorpropadi.this.AV11LegPropCod = aP3;
      getvalorpropadi.this.aP4 = aP4;
      getvalorpropadi.this.aP5 = aP5;
      getvalorpropadi.this.aP6 = aP6;
      getvalorpropadi.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P026D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11LegPropCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2230LegPropCod = P026D2_A2230LegPropCod[0] ;
         A6LegNumero = P026D2_A6LegNumero[0] ;
         A1EmpCod = P026D2_A1EmpCod[0] ;
         A3CliCod = P026D2_A3CliCod[0] ;
         A2232LegPropTD = P026D2_A2232LegPropTD[0] ;
         A2234LegPropValBool = P026D2_A2234LegPropValBool[0] ;
         A2233LegPropValNum = P026D2_A2233LegPropValNum[0] ;
         A2235LegPropValStr = P026D2_A2235LegPropValStr[0] ;
         A2236LegPropValDate = P026D2_A2236LegPropValDate[0] ;
         A2232LegPropTD = P026D2_A2232LegPropTD[0] ;
         if ( GXutil.strcmp(A2232LegPropTD, "BOOL") == 0 )
         {
            AV12ValorBoolean = A2234LegPropValBool ;
         }
         else if ( GXutil.strcmp(A2232LegPropTD, "NUM") == 0 )
         {
            AV13ValorImportes = A2233LegPropValNum ;
         }
         else if ( GXutil.strcmp(A2232LegPropTD, "STR") == 0 )
         {
            AV14ValorTexto = A2235LegPropValStr ;
         }
         else if ( GXutil.strcmp(A2232LegPropTD, "DATE") == 0 )
         {
            AV15ValorDate = A2236LegPropValDate ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getvalorpropadi.this.AV12ValorBoolean;
      this.aP5[0] = getvalorpropadi.this.AV13ValorImportes;
      this.aP6[0] = getvalorpropadi.this.AV14ValorTexto;
      this.aP7[0] = getvalorpropadi.this.AV15ValorDate;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ValorImportes = DecimalUtil.ZERO ;
      AV14ValorTexto = "" ;
      AV15ValorDate = GXutil.nullDate() ;
      scmdbuf = "" ;
      P026D2_A2230LegPropCod = new String[] {""} ;
      P026D2_A6LegNumero = new int[1] ;
      P026D2_A1EmpCod = new short[1] ;
      P026D2_A3CliCod = new int[1] ;
      P026D2_A2232LegPropTD = new String[] {""} ;
      P026D2_A2234LegPropValBool = new boolean[] {false} ;
      P026D2_A2233LegPropValNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026D2_A2235LegPropValStr = new String[] {""} ;
      P026D2_A2236LegPropValDate = new java.util.Date[] {GXutil.nullDate()} ;
      A2230LegPropCod = "" ;
      A2232LegPropTD = "" ;
      A2233LegPropValNum = DecimalUtil.ZERO ;
      A2235LegPropValStr = "" ;
      A2236LegPropValDate = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getvalorpropadi__default(),
         new Object[] {
             new Object[] {
            P026D2_A2230LegPropCod, P026D2_A6LegNumero, P026D2_A1EmpCod, P026D2_A3CliCod, P026D2_A2232LegPropTD, P026D2_A2234LegPropValBool, P026D2_A2233LegPropValNum, P026D2_A2235LegPropValStr, P026D2_A2236LegPropValDate
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV13ValorImportes ;
   private java.math.BigDecimal A2233LegPropValNum ;
   private String AV11LegPropCod ;
   private String scmdbuf ;
   private String A2230LegPropCod ;
   private String A2232LegPropTD ;
   private java.util.Date AV15ValorDate ;
   private java.util.Date A2236LegPropValDate ;
   private boolean AV12ValorBoolean ;
   private boolean A2234LegPropValBool ;
   private String AV14ValorTexto ;
   private String A2235LegPropValStr ;
   private java.util.Date[] aP7 ;
   private boolean[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P026D2_A2230LegPropCod ;
   private int[] P026D2_A6LegNumero ;
   private short[] P026D2_A1EmpCod ;
   private int[] P026D2_A3CliCod ;
   private String[] P026D2_A2232LegPropTD ;
   private boolean[] P026D2_A2234LegPropValBool ;
   private java.math.BigDecimal[] P026D2_A2233LegPropValNum ;
   private String[] P026D2_A2235LegPropValStr ;
   private java.util.Date[] P026D2_A2236LegPropValDate ;
}

final  class getvalorpropadi__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026D2", "SELECT T1.LegPropCod AS LegPropCod, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.propTipoDato AS LegPropTD, T1.LegPropValBool, T1.LegPropValNum, T1.LegPropValStr, T1.LegPropValDate FROM (LegajoPropiedades T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.LegPropCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LegPropCod = ( ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegPropCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
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
               return;
      }
   }

}

