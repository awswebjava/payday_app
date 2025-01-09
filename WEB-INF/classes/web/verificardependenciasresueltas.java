package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class verificardependenciasresueltas extends GXProcedure
{
   public verificardependenciasresueltas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verificardependenciasresueltas.class ), "" );
   }

   public verificardependenciasresueltas( int remoteHandle ,
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
                             String aP5 ,
                             String aP6 ,
                             String aP7 )
   {
      verificardependenciasresueltas.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 )
   {
      verificardependenciasresueltas.this.AV11CliCod = aP0;
      verificardependenciasresueltas.this.AV12EmpCod = aP1;
      verificardependenciasresueltas.this.AV13LiqNro = aP2;
      verificardependenciasresueltas.this.AV14LegNumero = aP3;
      verificardependenciasresueltas.this.AV8ConCodigo = aP4;
      verificardependenciasresueltas.this.AV16DConCodigo = aP5;
      verificardependenciasresueltas.this.AV9TipoConCod = aP6;
      verificardependenciasresueltas.this.AV15ProcesoLiquidacion = aP7;
      verificardependenciasresueltas.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, "1") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV16DConCodigo ,
                                           A394DConCodigo ,
                                           A464DTipoConCod ,
                                           AV9TipoConCod ,
                                           Byte.valueOf(A507LiqDCalculado) ,
                                           Short.valueOf(A763LiqDRecalculado) ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV12EmpCod) ,
                                           Integer.valueOf(AV13LiqNro) ,
                                           Integer.valueOf(AV14LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P020G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV14LegNumero), AV16DConCodigo, AV9TipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A763LiqDRecalculado = P020G2_A763LiqDRecalculado[0] ;
         A507LiqDCalculado = P020G2_A507LiqDCalculado[0] ;
         A464DTipoConCod = P020G2_A464DTipoConCod[0] ;
         A394DConCodigo = P020G2_A394DConCodigo[0] ;
         A6LegNumero = P020G2_A6LegNumero[0] ;
         A31LiqNro = P020G2_A31LiqNro[0] ;
         A1EmpCod = P020G2_A1EmpCod[0] ;
         A3CliCod = P020G2_A3CliCod[0] ;
         A393DConDescrip = P020G2_A393DConDescrip[0] ;
         A81LiqDSecuencial = P020G2_A81LiqDSecuencial[0] ;
         GXt_boolean1 = AV10ConRecalcular ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.conceptorecalcula(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, GXv_boolean2) ;
         verificardependenciasresueltas.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV10ConRecalcular = GXt_boolean1 ;
         if ( ( new web.dependenciaresuelta(remoteHandle, context).executeUdp( AV11CliCod, AV10ConRecalcular, AV15ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, A31LiqNro, AV13LiqNro, AV8ConCodigo, A394DConCodigo) == 0 ) && ( GXutil.strcmp(AV16DConCodigo, AV8ConCodigo) != 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A393DConDescrip) ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = verificardependenciasresueltas.this.AV19error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19error = "" ;
      AV22Pgmname = "" ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      P020G2_A763LiqDRecalculado = new short[1] ;
      P020G2_A507LiqDCalculado = new byte[1] ;
      P020G2_A464DTipoConCod = new String[] {""} ;
      P020G2_A394DConCodigo = new String[] {""} ;
      P020G2_A6LegNumero = new int[1] ;
      P020G2_A31LiqNro = new int[1] ;
      P020G2_A1EmpCod = new short[1] ;
      P020G2_A3CliCod = new int[1] ;
      P020G2_A393DConDescrip = new String[] {""} ;
      P020G2_A81LiqDSecuencial = new int[1] ;
      A393DConDescrip = "" ;
      GXv_boolean2 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.verificardependenciasresueltas__default(),
         new Object[] {
             new Object[] {
            P020G2_A763LiqDRecalculado, P020G2_A507LiqDCalculado, P020G2_A464DTipoConCod, P020G2_A394DConCodigo, P020G2_A6LegNumero, P020G2_A31LiqNro, P020G2_A1EmpCod, P020G2_A3CliCod, P020G2_A393DConDescrip, P020G2_A81LiqDSecuencial
            }
         }
      );
      AV22Pgmname = "verificarDependenciasResueltas" ;
      /* GeneXus formulas. */
      AV22Pgmname = "verificarDependenciasResueltas" ;
      Gx_err = (short)(0) ;
   }

   private byte A507LiqDCalculado ;
   private short AV12EmpCod ;
   private short A763LiqDRecalculado ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LiqNro ;
   private int AV14LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private String AV8ConCodigo ;
   private String AV16DConCodigo ;
   private String AV9TipoConCod ;
   private String AV15ProcesoLiquidacion ;
   private String AV22Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private boolean AV10ConRecalcular ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV19error ;
   private String A393DConDescrip ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private short[] P020G2_A763LiqDRecalculado ;
   private byte[] P020G2_A507LiqDCalculado ;
   private String[] P020G2_A464DTipoConCod ;
   private String[] P020G2_A394DConCodigo ;
   private int[] P020G2_A6LegNumero ;
   private int[] P020G2_A31LiqNro ;
   private short[] P020G2_A1EmpCod ;
   private int[] P020G2_A3CliCod ;
   private String[] P020G2_A393DConDescrip ;
   private int[] P020G2_A81LiqDSecuencial ;
}

final  class verificardependenciasresueltas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P020G2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV16DConCodigo ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV9TipoConCod ,
                                          byte A507LiqDCalculado ,
                                          short A763LiqDRecalculado ,
                                          int AV11CliCod ,
                                          short AV12EmpCod ,
                                          int AV13LiqNro ,
                                          int AV14LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[6];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT LiqDRecalculado, LiqDCalculado, DTipoConCod, DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, DConDescrip, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LiqDCalculado = 0 or LiqDRecalculado = 0)");
      if ( ! (GXutil.strcmp("", AV16DConCodigo)==0) )
      {
         addWhere(sWhereString, "(DConCodigo = ( ?))");
      }
      else
      {
         GXv_int3[4] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV16DConCodigo)==0) )
      {
         addWhere(sWhereString, "(DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int3[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P020G2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020G2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
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
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               return;
      }
   }

}

