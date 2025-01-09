package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clasificaroperando extends GXProcedure
{
   public clasificaroperando( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clasificaroperando.class ), "" );
   }

   public clasificaroperando( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             boolean[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             boolean[] aP17 )
   {
      clasificaroperando.this.aP18 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        boolean aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        boolean[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        boolean[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 ,
                        boolean[] aP17 ,
                        String[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             boolean[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             boolean[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             boolean[] aP17 ,
                             String[] aP18 )
   {
      clasificaroperando.this.AV9CliCod = aP0;
      clasificaroperando.this.AV21LegNumero = aP1;
      clasificaroperando.this.AV23ConCodigo = aP2;
      clasificaroperando.this.AV31Operando = aP3;
      clasificaroperando.this.AV10OpeCliIdMay = aP4;
      clasificaroperando.this.AV15OpeCliVig = aP5;
      clasificaroperando.this.AV28devolverCodigo = aP6;
      clasificaroperando.this.aP7 = aP7;
      clasificaroperando.this.aP8 = aP8;
      clasificaroperando.this.aP9 = aP9;
      clasificaroperando.this.aP10 = aP10;
      clasificaroperando.this.aP11 = aP11;
      clasificaroperando.this.aP12 = aP12;
      clasificaroperando.this.aP13 = aP13;
      clasificaroperando.this.aP14 = aP14;
      clasificaroperando.this.aP15 = aP15;
      clasificaroperando.this.aP16 = aP16;
      clasificaroperando.this.aP17 = aP17;
      clasificaroperando.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV44GXLvl5 = (byte)(0) ;
      /* Using cursor P011H2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10OpeCliIdMay});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P011H2_A82OpeCliId[0] ;
         A3CliCod = P011H2_A3CliCod[0] ;
         A536OpeCliIdMay = P011H2_A536OpeCliIdMay[0] ;
         A534OpeCliDescrip = P011H2_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P011H2_A549OpeCliCodFormula[0] ;
         A931OpeCliEsCant = P011H2_A931OpeCliEsCant[0] ;
         A934OpeCliAliEs = P011H2_A934OpeCliAliEs[0] ;
         A2129VarActObl = P011H2_A2129VarActObl[0] ;
         AV44GXLvl5 = (byte)(1) ;
         AV11Descripcion = GXutil.trim( A534OpeCliDescrip) ;
         AV13Nombre = GXutil.trim( A549OpeCliCodFormula) ;
         AV14cantidadEs = A931OpeCliEsCant ;
         AV26OperandoTipo = "Variable" ;
         AV35alicuotaEs = A934OpeCliAliEs ;
         AV20OpeCliId = A82OpeCliId ;
         AV41VarActObl = A2129VarActObl ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15OpeCliVig)) )
         {
            AV45GXLvl18 = (byte)(0) ;
            /* Using cursor P011H3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, AV15OpeCliVig});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A754OpeCliVig = P011H3_A754OpeCliVig[0] ;
               A535OpeCliValor = P011H3_A535OpeCliValor[0] ;
               AV45GXLvl18 = (byte)(1) ;
               AV16OperandoNuevo = GXutil.trim( A535OpeCliValor) ;
               AV18OpeCliValorNumeric = CommonUtil.decimalVal( A535OpeCliValor, ".") ;
               AV17OperandoNuevo2 = localUtil.format( AV18OpeCliValorNumeric, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
               AV39ult_OpeCliVig = A754OpeCliVig ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               pr_default.readNext(1);
            }
            pr_default.close(1);
            if ( AV45GXLvl18 == 0 )
            {
               AV25error = httpContext.getMessage( "No hay valor vigente para variable \"", "") + GXutil.trim( AV13Nombre) + "\"" ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV41VarActObl )
            {
               GXv_boolean1[0] = AV40actualizadaEsta ;
               new web.variableactualizada(remoteHandle, context).execute( AV9CliCod, AV20OpeCliId, AV39ult_OpeCliVig, AV15OpeCliVig, GXv_boolean1) ;
               clasificaroperando.this.AV40actualizadaEsta = GXv_boolean1[0] ;
               if ( ! AV40actualizadaEsta )
               {
                  AV25error = httpContext.getMessage( "La variable ", "") + GXutil.trim( AV13Nombre) + httpContext.getMessage( " no está actualizada", "") ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV44GXLvl5 == 0 )
      {
         GXv_char2[0] = AV19idOperando ;
         GXv_char3[0] = AV11Descripcion ;
         GXv_char4[0] = AV13Nombre ;
         GXv_boolean1[0] = AV14cantidadEs ;
         GXv_boolean5[0] = AV35alicuotaEs ;
         new web.codigoopeformulaiddescyfor(remoteHandle, context).execute( AV9CliCod, AV10OpeCliIdMay, GXv_char2, GXv_char3, GXv_char4, GXv_boolean1, GXv_boolean5) ;
         clasificaroperando.this.AV19idOperando = GXv_char2[0] ;
         clasificaroperando.this.AV11Descripcion = GXv_char3[0] ;
         clasificaroperando.this.AV13Nombre = GXv_char4[0] ;
         clasificaroperando.this.AV14cantidadEs = GXv_boolean1[0] ;
         clasificaroperando.this.AV35alicuotaEs = GXv_boolean5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "calculo alicuotaes ", "")+GXutil.trim( GXutil.booltostr( AV35alicuotaEs))+httpContext.getMessage( " &idOperando ", "")+AV19idOperando) ;
         if ( ! (GXutil.strcmp("", AV19idOperando)==0) )
         {
            AV20OpeCliId = "" ;
            if ( (0==AV21LegNumero) )
            {
               AV16OperandoNuevo = "1" ;
               AV17OperandoNuevo2 = "1" ;
            }
            else
            {
               AV22doResuelveOperando = true ;
            }
         }
         else
         {
            GXt_char6 = AV24variableNoIdentificada ;
            GXv_char4[0] = GXt_char6 ;
            new web.wwpbaseobjects.gettextvariablenoidentificada(remoteHandle, context).execute( AV10OpeCliIdMay, GXv_char4) ;
            clasificaroperando.this.GXt_char6 = GXv_char4[0] ;
            AV24variableNoIdentificada = GXt_char6 ;
            AV16OperandoNuevo = AV46Pgmname + " " + AV24variableNoIdentificada + "\"" + AV10OpeCliIdMay + "\"" ;
            AV17OperandoNuevo2 = AV16OperandoNuevo ;
            AV25error = AV46Pgmname + " " + GXutil.trim( AV24variableNoIdentificada) ;
            new web.msgdebug7(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "no encontró nada", "")) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( ( AV28devolverCodigo ) && ( GXutil.strcmp(AV26OperandoTipo, "Variable") != 0 ) )
      {
         if ( ( GXutil.strcmp(AV19idOperando, "[remu_var]") == 0 ) || ( GXutil.strcmp(AV19idOperando, "{concepto}") == 0 ) || ( GXutil.strcmp(AV19idOperando, "[novedad_cantidad]") == 0 ) || ( GXutil.strcmp(AV19idOperando, "[novedad_importe]") == 0 ) )
         {
            AV26OperandoTipo = "Concepto" ;
            AV32concepto_str = AV31Operando ;
            GXv_char4[0] = AV32concepto_str ;
            new web.removercorchetes(remoteHandle, context).execute( GXv_char4) ;
            clasificaroperando.this.AV32concepto_str = GXv_char4[0] ;
            GXv_char4[0] = AV29Codigo ;
            GXv_char3[0] = AV25error ;
            new web.obtenerconceptodeformula(remoteHandle, context).execute( AV9CliCod, AV23ConCodigo, AV32concepto_str, AV19idOperando, GXv_char4, GXv_char3) ;
            clasificaroperando.this.AV29Codigo = GXv_char4[0] ;
            clasificaroperando.this.AV25error = GXv_char3[0] ;
            GXv_char4[0] = AV11Descripcion ;
            new web.conceptogetdescri(remoteHandle, context).execute( AV9CliCod, AV29Codigo, GXv_char4) ;
            clasificaroperando.this.AV11Descripcion = GXv_char4[0] ;
         }
         else
         {
            AV26OperandoTipo = "Calculo" ;
            AV29Codigo = AV13Nombre ;
         }
      }
      else
      {
         AV29Codigo = AV13Nombre ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = clasificaroperando.this.AV11Descripcion;
      this.aP8[0] = clasificaroperando.this.AV13Nombre;
      this.aP9[0] = clasificaroperando.this.AV14cantidadEs;
      this.aP10[0] = clasificaroperando.this.AV16OperandoNuevo;
      this.aP11[0] = clasificaroperando.this.AV17OperandoNuevo2;
      this.aP12[0] = clasificaroperando.this.AV19idOperando;
      this.aP13[0] = clasificaroperando.this.AV20OpeCliId;
      this.aP14[0] = clasificaroperando.this.AV22doResuelveOperando;
      this.aP15[0] = clasificaroperando.this.AV26OperandoTipo;
      this.aP16[0] = clasificaroperando.this.AV29Codigo;
      this.aP17[0] = clasificaroperando.this.AV35alicuotaEs;
      this.aP18[0] = clasificaroperando.this.AV25error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Descripcion = "" ;
      AV13Nombre = "" ;
      AV16OperandoNuevo = "" ;
      AV17OperandoNuevo2 = "" ;
      AV19idOperando = "" ;
      AV20OpeCliId = "" ;
      AV26OperandoTipo = "" ;
      AV29Codigo = "" ;
      AV25error = "" ;
      scmdbuf = "" ;
      P011H2_A82OpeCliId = new String[] {""} ;
      P011H2_A3CliCod = new int[1] ;
      P011H2_A536OpeCliIdMay = new String[] {""} ;
      P011H2_A534OpeCliDescrip = new String[] {""} ;
      P011H2_A549OpeCliCodFormula = new String[] {""} ;
      P011H2_A931OpeCliEsCant = new boolean[] {false} ;
      P011H2_A934OpeCliAliEs = new boolean[] {false} ;
      P011H2_A2129VarActObl = new boolean[] {false} ;
      A82OpeCliId = "" ;
      A536OpeCliIdMay = "" ;
      A534OpeCliDescrip = "" ;
      A549OpeCliCodFormula = "" ;
      P011H3_A3CliCod = new int[1] ;
      P011H3_A82OpeCliId = new String[] {""} ;
      P011H3_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P011H3_A535OpeCliValor = new String[] {""} ;
      A754OpeCliVig = GXutil.nullDate() ;
      A535OpeCliValor = "" ;
      AV18OpeCliValorNumeric = DecimalUtil.ZERO ;
      AV39ult_OpeCliVig = GXutil.nullDate() ;
      GXv_char2 = new String[1] ;
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV46Pgmname = "" ;
      AV24variableNoIdentificada = "" ;
      GXt_char6 = "" ;
      AV32concepto_str = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clasificaroperando__default(),
         new Object[] {
             new Object[] {
            P011H2_A82OpeCliId, P011H2_A3CliCod, P011H2_A536OpeCliIdMay, P011H2_A534OpeCliDescrip, P011H2_A549OpeCliCodFormula, P011H2_A931OpeCliEsCant, P011H2_A934OpeCliAliEs, P011H2_A2129VarActObl
            }
            , new Object[] {
            P011H3_A3CliCod, P011H3_A82OpeCliId, P011H3_A754OpeCliVig, P011H3_A535OpeCliValor
            }
         }
      );
      AV46Pgmname = "ClasificarOperando" ;
      /* GeneXus formulas. */
      AV46Pgmname = "ClasificarOperando" ;
      Gx_err = (short)(0) ;
   }

   private byte AV44GXLvl5 ;
   private byte AV45GXLvl18 ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV21LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV18OpeCliValorNumeric ;
   private String AV23ConCodigo ;
   private String AV10OpeCliIdMay ;
   private String AV19idOperando ;
   private String AV20OpeCliId ;
   private String AV26OperandoTipo ;
   private String AV29Codigo ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private String A536OpeCliIdMay ;
   private String A549OpeCliCodFormula ;
   private String GXv_char2[] ;
   private String AV46Pgmname ;
   private String GXt_char6 ;
   private String AV32concepto_str ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV15OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date AV39ult_OpeCliVig ;
   private boolean AV28devolverCodigo ;
   private boolean AV14cantidadEs ;
   private boolean AV22doResuelveOperando ;
   private boolean AV35alicuotaEs ;
   private boolean A931OpeCliEsCant ;
   private boolean A934OpeCliAliEs ;
   private boolean A2129VarActObl ;
   private boolean AV41VarActObl ;
   private boolean returnInSub ;
   private boolean AV40actualizadaEsta ;
   private boolean GXv_boolean1[] ;
   private boolean GXv_boolean5[] ;
   private String A535OpeCliValor ;
   private String AV31Operando ;
   private String AV11Descripcion ;
   private String AV13Nombre ;
   private String AV16OperandoNuevo ;
   private String AV17OperandoNuevo2 ;
   private String AV25error ;
   private String A534OpeCliDescrip ;
   private String AV24variableNoIdentificada ;
   private String[] aP18 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private boolean[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private boolean[] aP14 ;
   private String[] aP15 ;
   private String[] aP16 ;
   private boolean[] aP17 ;
   private IDataStoreProvider pr_default ;
   private String[] P011H2_A82OpeCliId ;
   private int[] P011H2_A3CliCod ;
   private String[] P011H2_A536OpeCliIdMay ;
   private String[] P011H2_A534OpeCliDescrip ;
   private String[] P011H2_A549OpeCliCodFormula ;
   private boolean[] P011H2_A931OpeCliEsCant ;
   private boolean[] P011H2_A934OpeCliAliEs ;
   private boolean[] P011H2_A2129VarActObl ;
   private int[] P011H3_A3CliCod ;
   private String[] P011H3_A82OpeCliId ;
   private java.util.Date[] P011H3_A754OpeCliVig ;
   private String[] P011H3_A535OpeCliValor ;
}

final  class clasificaroperando__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011H2", "SELECT OpeCliId, CliCod, OpeCliIdMay, OpeCliDescrip, OpeCliCodFormula, OpeCliEsCant, OpeCliAliEs, VarActObl FROM Variable WHERE CliCod = ? and OpeCliIdMay = ( ?) ORDER BY CliCod, OpeCliIdMay  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P011H3", "SELECT CliCod, OpeCliId, OpeCliVig, OpeCliValor FROM variable_valores WHERE CliCod = ? and OpeCliId = ( ?) and OpeCliVig <= ? ORDER BY CliCod, OpeCliId, OpeCliVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

