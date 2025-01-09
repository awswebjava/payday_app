package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarwizardconceptosafip extends GXProcedure
{
   public validarwizardconceptosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarwizardconceptosafip.class ), "" );
   }

   public validarwizardconceptosafip( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 String aP1 )
   {
      validarwizardconceptosafip.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      validarwizardconceptosafip.this.AV8CliCod = aP0;
      validarwizardconceptosafip.this.AV9Code = aP1;
      validarwizardconceptosafip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14WizardSteps.fromJSonString(AV13websession.getValue(httpContext.getMessage( "&WizardSteps", "")), null);
      AV25GXV1 = 1 ;
      while ( AV25GXV1 <= AV14WizardSteps.size() )
      {
         AV12step = (web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)((web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)AV14WizardSteps.elementAt(-1+AV25GXV1));
         new web.msgdebug(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "step ", "")+AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code()) ;
         if ( ( GXutil.strcmp(AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "Inicio") != 0 ) && ( GXutil.strcmp(AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), "Completado") != 0 ) )
         {
            if ( ( GXutil.strcmp(AV9Code, AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code()) == 0 ) || (GXutil.strcmp("", AV9Code)==0) )
            {
               AV19json_sesion = AV13websession.getValue(httpContext.getMessage( "ConceptosAfipWizard_", "")+GXutil.trim( AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code())) ;
               if ( (GXutil.strcmp("", AV19json_sesion)==0) )
               {
                  GXv_SdtConceptosAfipWizardData1[0] = AV10ConceptosAfipWizardData;
                  new web.cargarpasowizardconcepto(remoteHandle, context).execute( AV8CliCod, AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), GXv_SdtConceptosAfipWizardData1) ;
                  AV10ConceptosAfipWizardData = GXv_SdtConceptosAfipWizardData1[0] ;
               }
               else
               {
                  AV10ConceptosAfipWizardData.fromJSonString(AV19json_sesion, null);
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "SIPA", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipaapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "SIPA", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsipacont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "INSSJYP", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "INSSJYP", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipinssjypcont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "OS", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasocapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "OS", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipobrasoccont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "FSR", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "FSR", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonsolredcont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "RENATEA", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateaapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "RENATEA", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiprenateacont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "AAFF", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipasigfamcont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "FNE", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipfonnacempcont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "CONTRIBUCION", ""), httpContext.getMessage( "LRT", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipleyrietrabcont())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "DIFERENCIALES", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregdifapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( new web.aplicaapoconafip(remoteHandle, context).executeUdp( httpContext.getMessage( "APORTE", ""), httpContext.getMessage( "ESPECIALES", ""), AV20ConAFIPTipo, AV21ConAfipSubT1) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipregespapo())==0) )
                  {
                     AV15incompleto = true ;
                  }
               }
               if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo())==0) )
               {
                  AV15incompleto = true ;
               }
               GXv_char2[0] = AV16ConDescrip ;
               GXv_char3[0] = AV18conceptotipo ;
               GXv_char4[0] = "" ;
               GXv_boolean5[0] = false ;
               GXv_boolean6[0] = false ;
               GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char8[0] = "" ;
               GXv_char9[0] = "" ;
               GXv_char10[0] = "" ;
               GXv_char11[0] = "" ;
               GXv_int12[0] = 0 ;
               GXv_int13[0] = 0 ;
               GXv_char14[0] = "" ;
               GXv_int15[0] = AV22ConVigencia ;
               GXv_boolean16[0] = false ;
               GXv_boolean17[0] = false ;
               new web.getdatosconcepto(remoteHandle, context).execute( AV8CliCod, AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code(), GXv_char2, GXv_char3, GXv_char4, GXv_boolean5, GXv_boolean6, GXv_decimal7, GXv_char8, GXv_char9, GXv_char10, GXv_char11, GXv_int12, GXv_int13, GXv_char14, GXv_int15, GXv_boolean16, GXv_boolean17) ;
               validarwizardconceptosafip.this.AV16ConDescrip = GXv_char2[0] ;
               validarwizardconceptosafip.this.AV18conceptotipo = GXv_char3[0] ;
               validarwizardconceptosafip.this.AV22ConVigencia = GXv_int15[0] ;
               new web.msgdebug(remoteHandle, context).execute( AV26Pgmname, AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto()+" "+AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre()) ;
               if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto())==0) && (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre())==0) )
               {
                  AV15incompleto = true ;
                  new web.msgdebug(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "incompleto", "")) ;
               }
               else
               {
                  if ( (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipconcepto())==0) && ! (GXutil.strcmp("", AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre())==0) )
                  {
                     GXv_char14[0] = AV17errorRango ;
                     new web.conafipvalidarrango(remoteHandle, context).execute( AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafiptipo(), AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Conafipsubt1(), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV10ConceptosAfipWizardData.getgxTv_SdtConceptosAfipWizardData_Concepto1().getgxTv_SdtConceptosAfipWizardData_Concepto1_Libre(), "."))), GXv_char14) ;
                     validarwizardconceptosafip.this.AV17errorRango = GXv_char14[0] ;
                     if ( ! (GXutil.strcmp("", AV17errorRango)==0) )
                     {
                        if ( ! (GXutil.strcmp("", AV9Code)==0) )
                        {
                           AV11error.add(AV17errorRango, 0);
                        }
                        else
                        {
                           AV11error.add(httpContext.getMessage( "Error de Rango en Concepto ", "")+GXutil.trim( AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code())+" - "+GXutil.trim( AV16ConDescrip), 0);
                        }
                     }
                  }
               }
               if ( AV15incompleto )
               {
                  if ( (GXutil.strcmp("", AV9Code)==0) )
                  {
                     AV11error.add(httpContext.getMessage( "Datos incompletos en Concepto ", "")+GXutil.trim( AV12step.getgxTv_SdtWizardSteps_WizardStepsItem_Code())+" - "+GXutil.trim( AV16ConDescrip), 0);
                  }
                  else
                  {
                     AV11error.add(httpContext.getMessage( "Debe completar todos los datos de configuración del concepto", ""), 0);
                  }
               }
            }
         }
         AV25GXV1 = (int)(AV25GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = validarwizardconceptosafip.this.AV11error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11error = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14WizardSteps = new GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "PayDay", remoteHandle);
      AV13websession = httpContext.getWebSession();
      AV12step = new web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV26Pgmname = "" ;
      AV19json_sesion = "" ;
      AV10ConceptosAfipWizardData = new web.SdtConceptosAfipWizardData(remoteHandle, context);
      GXv_SdtConceptosAfipWizardData1 = new web.SdtConceptosAfipWizardData[1] ;
      AV20ConAFIPTipo = "" ;
      AV21ConAfipSubT1 = "" ;
      AV16ConDescrip = "" ;
      GXv_char2 = new String[1] ;
      AV18conceptotipo = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_int12 = new int[1] ;
      GXv_int13 = new long[1] ;
      GXv_int15 = new byte[1] ;
      GXv_boolean16 = new boolean[1] ;
      GXv_boolean17 = new boolean[1] ;
      AV17errorRango = "" ;
      GXv_char14 = new String[1] ;
      AV26Pgmname = "validarWizardConceptosAfip" ;
      /* GeneXus formulas. */
      AV26Pgmname = "validarWizardConceptosAfip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22ConVigencia ;
   private byte GXv_int15[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV25GXV1 ;
   private int GXv_int12[] ;
   private long GXv_int13[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV9Code ;
   private String AV26Pgmname ;
   private String AV20ConAFIPTipo ;
   private String AV21ConAfipSubT1 ;
   private String GXv_char2[] ;
   private String AV18conceptotipo ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String GXv_char11[] ;
   private String GXv_char14[] ;
   private boolean Cond_result ;
   private boolean AV15incompleto ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean6[] ;
   private boolean GXv_boolean16[] ;
   private boolean GXv_boolean17[] ;
   private String AV19json_sesion ;
   private String AV16ConDescrip ;
   private String AV17errorRango ;
   private com.genexus.webpanels.WebSession AV13websession ;
   private GXSimpleCollection<String>[] aP2 ;
   private GXSimpleCollection<String> AV11error ;
   private GXBaseCollection<web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV14WizardSteps ;
   private web.SdtConceptosAfipWizardData AV10ConceptosAfipWizardData ;
   private web.SdtConceptosAfipWizardData GXv_SdtConceptosAfipWizardData1[] ;
   private web.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV12step ;
}

