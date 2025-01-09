package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class queconceptosusa extends GXProcedure
{
   public queconceptosusa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( queconceptosusa.class ), "" );
   }

   public queconceptosusa( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> executeUdp( int aP0 ,
                                                                               String aP1 ,
                                                                               boolean aP2 ,
                                                                               boolean aP3 )
   {
      queconceptosusa.this.aP4 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean aP3 ,
                        GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 ,
                             GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP4 )
   {
      queconceptosusa.this.AV8CliCod = aP0;
      queconceptosusa.this.AV10parm_ConCodigo = aP1;
      queconceptosusa.this.AV16indirectos = aP2;
      queconceptosusa.this.AV30incluirCalculosYVariables = aP3;
      queconceptosusa.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ConCodigo = GXutil.upper( AV10parm_ConCodigo) ;
      AV11sdt_conceptos.clear();
      GXt_char1 = AV14conceptoPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigoconcepto(remoteHandle, context).execute( AV8CliCod, true, GXv_char2) ;
      queconceptosusa.this.GXt_char1 = GXv_char2[0] ;
      AV14conceptoPalabra = GXt_char1 ;
      AV21i = (short)(0) ;
      if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&ConCodigo ", "")+AV9ConCodigo) ;
      }
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         /* Using cursor P00HI2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A26ConCodigo = P00HI2_A26ConCodigo[0] ;
            A3CliCod = P00HI2_A3CliCod[0] ;
            A148ConFormula = P00HI2_A148ConFormula[0] ;
            n148ConFormula = P00HI2_n148ConFormula[0] ;
            AV21i = (short)(AV21i+1) ;
            if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "loop &i ", "")+GXutil.trim( GXutil.str( AV21i, 4, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV9ConCodigo)) ;
            }
            GXt_objcol_SdtSDTOperandosFormula3 = AV12SDTOperandos ;
            GXv_objcol_SdtSDTOperandosFormula4[0] = GXt_objcol_SdtSDTOperandosFormula3 ;
            new web.obtoperandosformula2(remoteHandle, context).execute( A3CliCod, A26ConCodigo, A148ConFormula, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_objcol_SdtSDTOperandosFormula4) ;
            GXt_objcol_SdtSDTOperandosFormula3 = GXv_objcol_SdtSDTOperandosFormula4[0] ;
            AV12SDTOperandos = GXt_objcol_SdtSDTOperandosFormula3 ;
            if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "operandos ", "")+GXutil.trim( GXutil.str( AV12SDTOperandos.size(), 9, 0))) ;
            }
            AV35GXV1 = 1 ;
            while ( AV35GXV1 <= AV12SDTOperandos.size() )
            {
               AV13SDTOperandosItem = (web.SdtSDTOperandosFormula)((web.SdtSDTOperandosFormula)AV12SDTOperandos.elementAt(-1+AV35GXV1));
               if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "recorre operando ", "")+GXutil.upper( AV13SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal())+httpContext.getMessage( " &conceptoPalabra ", "")+GXutil.trim( AV14conceptoPalabra)) ;
               }
               GXv_char2[0] = "" ;
               GXv_char5[0] = AV26primeraPalabra ;
               new web.opeformulaapalabramayuscula(remoteHandle, context).execute( AV13SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal(), GXv_char2, GXv_char5) ;
               queconceptosusa.this.AV26primeraPalabra = GXv_char5[0] ;
               GXv_char5[0] = AV27Descripcion ;
               GXv_char2[0] = "" ;
               GXv_boolean6[0] = false ;
               GXv_char7[0] = "" ;
               GXv_char8[0] = "" ;
               GXv_char9[0] = AV28operandos ;
               GXv_char10[0] = "" ;
               GXv_boolean11[0] = false ;
               GXv_char12[0] = AV29OperandoTipo ;
               GXv_char13[0] = AV20ConceptoPar ;
               GXv_boolean14[0] = false ;
               GXv_char15[0] = "" ;
               new web.clasificaroperando(remoteHandle, context).execute( AV8CliCod, 0, AV10parm_ConCodigo, AV13SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal(), AV26primeraPalabra, GXutil.serverDate( context, remoteHandle, pr_default), true, GXv_char5, GXv_char2, GXv_boolean6, GXv_char7, GXv_char8, GXv_char9, GXv_char10, GXv_boolean11, GXv_char12, GXv_char13, GXv_boolean14, GXv_char15) ;
               queconceptosusa.this.AV27Descripcion = GXv_char5[0] ;
               queconceptosusa.this.AV28operandos = GXv_char9[0] ;
               queconceptosusa.this.AV29OperandoTipo = GXv_char12[0] ;
               queconceptosusa.this.AV20ConceptoPar = GXv_char13[0] ;
               if ( GXutil.strcmp(AV29OperandoTipo, "Concepto") == 0 )
               {
                  AV24agregar = true ;
               }
               else
               {
                  AV24agregar = AV30incluirCalculosYVariables ;
               }
               if ( AV24agregar )
               {
                  if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "tiene la palabra concepto", "")) ;
                  }
                  AV18yaEsta = false ;
                  AV36GXV2 = 1 ;
                  while ( AV36GXV2 <= AV11sdt_conceptos.size() )
                  {
                     AV15itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)((web.Sdtsdt_conceptos_sdt_conceptosItem)AV11sdt_conceptos.elementAt(-1+AV36GXV2));
                     if ( GXutil.strcmp(AV15itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo(), AV20ConceptoPar) == 0 )
                     {
                        AV18yaEsta = true ;
                        if (true) break;
                     }
                     AV36GXV2 = (int)(AV36GXV2+1) ;
                  }
                  if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&ConceptoPar ", "")+GXutil.trim( AV20ConceptoPar)+httpContext.getMessage( " &yaEsta", "")+GXutil.booltostr( AV18yaEsta)) ;
                  }
                  if ( ! AV18yaEsta && ! (GXutil.strcmp("", AV20ConceptoPar)==0) && ( GXutil.strcmp(AV20ConceptoPar, AV10parm_ConCodigo) != 0 ) )
                  {
                     AV15itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)new web.Sdtsdt_conceptos_sdt_conceptosItem(remoteHandle, context);
                     if ( (GXutil.strcmp("", AV27Descripcion)==0) )
                     {
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip( httpContext.getMessage( "(ERROR: CONCEPTO INEXISTENTE)", "") );
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo( " * "+GXutil.trim( AV20ConceptoPar)+" *" );
                     }
                     else
                     {
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip( AV27Descripcion );
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo( AV20ConceptoPar );
                        if ( ( GXutil.strSearch( AV20ConceptoPar, "{", 1) != 0 ) || ( GXutil.strSearch( AV20ConceptoPar, "[", 1) != 0 ) )
                        {
                           AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto( false );
                        }
                        else
                        {
                           AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto( true );
                        }
                     }
                     AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( false );
                     if ( AV21i == 1 )
                     {
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo( (short)(1) );
                     }
                     else
                     {
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Directo( (short)(0) );
                     }
                     if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "agrega ", "")+GXutil.trim( AV15itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo())) ;
                     }
                     AV11sdt_conceptos.add(AV15itemConcepto, 0);
                  }
               }
               AV35GXV1 = (int)(AV35GXV1+1) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&indirectos ", "")+GXutil.trim( GXutil.booltostr( AV16indirectos))) ;
         }
         if ( ! AV16indirectos )
         {
            if (true) break;
         }
         else
         {
            if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&sdt_conceptos ", "")+GXutil.trim( GXutil.str( AV11sdt_conceptos.size(), 9, 0))) ;
            }
            AV17cntYaRecorridos = (short)(0) ;
            AV9ConCodigo = "" ;
            if ( AV11sdt_conceptos.size() == 0 )
            {
               if (true) break;
            }
            else
            {
               AV37GXV3 = 1 ;
               while ( AV37GXV3 <= AV11sdt_conceptos.size() )
               {
                  AV15itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)((web.Sdtsdt_conceptos_sdt_conceptosItem)AV11sdt_conceptos.elementAt(-1+AV37GXV3));
                  if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&itemConcepto.yaRecorrido ", "")+GXutil.trim( GXutil.booltostr( AV15itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido()))+httpContext.getMessage( " &itemConcepto.concodigo ", "")+GXutil.trim( AV15itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo())) ;
                  }
                  if ( ! AV15itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido() )
                  {
                     if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "vacio? concodigo ", "")+GXutil.trim( AV9ConCodigo)) ;
                     }
                     if ( (GXutil.strcmp("", AV9ConCodigo)==0) )
                     {
                        AV9ConCodigo = AV15itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo() ;
                        if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "setea &ConCodigo ", "")+GXutil.trim( AV9ConCodigo)) ;
                        }
                        AV15itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( true );
                     }
                  }
                  else
                  {
                     AV17cntYaRecorridos = (short)(AV17cntYaRecorridos+1) ;
                  }
                  AV37GXV3 = (int)(AV37GXV3+1) ;
               }
               if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&cntYaRecorridos ", "")+GXutil.trim( GXutil.str( AV17cntYaRecorridos, 4, 0))+httpContext.getMessage( " &sdt_conceptos.Count ", "")+GXutil.trim( GXutil.str( AV11sdt_conceptos.size(), 9, 0))) ;
               }
               if ( AV17cntYaRecorridos == AV11sdt_conceptos.size() )
               {
                  if ( GXutil.strcmp(AV10parm_ConCodigo, httpContext.getMessage( "CAL063", "")) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "sale", "")) ;
                  }
                  if (true) break;
               }
            }
         }
      }
      new web.msgdebug4(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&parm_ConCodigo ", "")+GXutil.trim( AV10parm_ConCodigo)+httpContext.getMessage( " &sdt_conceptos ", "")+AV11sdt_conceptos.toJSonString(false)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = queconceptosusa.this.AV11sdt_conceptos;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      AV9ConCodigo = "" ;
      AV14conceptoPalabra = "" ;
      GXt_char1 = "" ;
      AV33Pgmname = "" ;
      scmdbuf = "" ;
      P00HI2_A26ConCodigo = new String[] {""} ;
      P00HI2_A3CliCod = new int[1] ;
      P00HI2_A148ConFormula = new String[] {""} ;
      P00HI2_n148ConFormula = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      AV12SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXt_objcol_SdtSDTOperandosFormula3 = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXv_objcol_SdtSDTOperandosFormula4 = new GXBaseCollection[1] ;
      AV13SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV26primeraPalabra = "" ;
      AV27Descripcion = "" ;
      GXv_char5 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_char7 = new String[1] ;
      GXv_char8 = new String[1] ;
      AV28operandos = "" ;
      GXv_char9 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_boolean11 = new boolean[1] ;
      AV29OperandoTipo = "" ;
      GXv_char12 = new String[1] ;
      AV20ConceptoPar = "" ;
      GXv_char13 = new String[1] ;
      GXv_boolean14 = new boolean[1] ;
      GXv_char15 = new String[1] ;
      AV15itemConcepto = new web.Sdtsdt_conceptos_sdt_conceptosItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.queconceptosusa__default(),
         new Object[] {
             new Object[] {
            P00HI2_A26ConCodigo, P00HI2_A3CliCod, P00HI2_A148ConFormula, P00HI2_n148ConFormula
            }
         }
      );
      AV33Pgmname = "queConceptosUsa" ;
      /* GeneXus formulas. */
      AV33Pgmname = "queConceptosUsa" ;
      Gx_err = (short)(0) ;
   }

   private short AV21i ;
   private short AV17cntYaRecorridos ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int AV35GXV1 ;
   private int AV36GXV2 ;
   private int AV37GXV3 ;
   private String AV10parm_ConCodigo ;
   private String AV9ConCodigo ;
   private String AV14conceptoPalabra ;
   private String GXt_char1 ;
   private String AV33Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV26primeraPalabra ;
   private String GXv_char5[] ;
   private String GXv_char2[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String AV28operandos ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String AV29OperandoTipo ;
   private String GXv_char12[] ;
   private String AV20ConceptoPar ;
   private String GXv_char13[] ;
   private String GXv_char15[] ;
   private boolean AV16indirectos ;
   private boolean AV30incluirCalculosYVariables ;
   private boolean gxexitloop ;
   private boolean n148ConFormula ;
   private boolean GXv_boolean6[] ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean14[] ;
   private boolean AV24agregar ;
   private boolean AV18yaEsta ;
   private String A148ConFormula ;
   private String AV27Descripcion ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00HI2_A26ConCodigo ;
   private int[] P00HI2_A3CliCod ;
   private String[] P00HI2_A148ConFormula ;
   private boolean[] P00HI2_n148ConFormula ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV11sdt_conceptos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV12SDTOperandos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXt_objcol_SdtSDTOperandosFormula3 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula4[] ;
   private web.Sdtsdt_conceptos_sdt_conceptosItem AV15itemConcepto ;
   private web.SdtSDTOperandosFormula AV13SDTOperandosItem ;
}

final  class queconceptosusa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00HI2", "SELECT ConCodigo, CliCod, ConFormula FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

