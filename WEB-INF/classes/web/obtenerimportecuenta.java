package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerimportecuenta extends GXProcedure
{
   public obtenerimportecuenta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerimportecuenta.class ), "" );
   }

   public obtenerimportecuenta( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           short aP3 ,
                                           int aP4 ,
                                           String aP5 )
   {
      obtenerimportecuenta.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      obtenerimportecuenta.this.AV13CliCod = aP0;
      obtenerimportecuenta.this.AV12EmpCod = aP1;
      obtenerimportecuenta.this.AV14LiqNro = aP2;
      obtenerimportecuenta.this.AV11LiqLegConAnio = aP3;
      obtenerimportecuenta.this.AV10LegNumero = aP4;
      obtenerimportecuenta.this.AV9ConCodigo = aP5;
      obtenerimportecuenta.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV14LiqNro) ,
                                           Integer.valueOf(A1098LiqNuevaNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P00VE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV11LiqLegConAnio), Integer.valueOf(AV10LegNumero), AV9ConCodigo, Integer.valueOf(AV14LiqNro)});
      c868LiqLegConSaldo = P00VE2_A868LiqLegConSaldo[0] ;
      pr_default.close(0);
      AV8LiqLegConSaldo = AV8LiqLegConSaldo.add(c868LiqLegConSaldo) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = obtenerimportecuenta.this.AV8LiqLegConSaldo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LiqLegConSaldo = DecimalUtil.ZERO ;
      c868LiqLegConSaldo = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00VE2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtenerimportecuenta__default(),
         new Object[] {
             new Object[] {
            P00VE2_A868LiqLegConSaldo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV11LiqLegConAnio ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV14LiqNro ;
   private int AV10LegNumero ;
   private int A1098LiqNuevaNro ;
   private java.math.BigDecimal AV8LiqLegConSaldo ;
   private java.math.BigDecimal c868LiqLegConSaldo ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00VE2_A868LiqLegConSaldo ;
}

final  class obtenerimportecuenta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00VE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV14LiqNro ,
                                          int A1098LiqNuevaNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[6];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT SUM(LiqLegConSaldo) FROM LiqLegConceptoCuenta" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ? and ConCodigo = ( ?))");
      if ( ! (0==AV14LiqNro) )
      {
         addWhere(sWhereString, "(LiqNuevaNro = ?)");
      }
      else
      {
         GXv_int1[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00VE2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               return;
      }
   }

}

