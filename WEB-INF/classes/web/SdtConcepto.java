package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConcepto extends GxSilentTrnSdt
{
   public SdtConcepto( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConcepto.class));
   }

   public SdtConcepto( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtConcepto");
      initialize( remoteHandle) ;
   }

   public SdtConcepto( int remoteHandle ,
                       StructSdtConcepto struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     String AV26ConCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV26ConCodigo});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"ConCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Concepto");
      metadata.set("BT", "Concepto");
      metadata.set("PK", "[ \"CliCod\",\"ConCodigo\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"MotivosEgreso\",\"TipoLiquidacion\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"AplIIGG\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"AplIIGG\" ],\"FKMap\":[ \"CliPadre-CliCod\" ] },{ \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"CliPadre-CliCod\",\"ConPadre-ConCodigo\" ] },{ \"FK\":[ \"ConCondicion\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ConveCodigo\" ],\"FKMap\":[ \"ConceptoPais-PaiCod\",\"ConceptoConveCodigo-ConveCodigo\" ] },{ \"FK\":[ \"TipoConCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoConCod\",\"SubTipoConCod1\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoConCod\",\"SubTipoConCod1\",\"SubTipoConCod2\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtConcepto_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo") )
            {
               gxTv_SdtConcepto_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip") )
            {
               gxTv_SdtConcepto_Condescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConHabilitado") )
            {
               gxTv_SdtConcepto_Conhabilitado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrden") )
            {
               gxTv_SdtConcepto_Conorden = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCanti") )
            {
               gxTv_SdtConcepto_Concanti = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValUni") )
            {
               gxTv_SdtConcepto_Convaluni = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImporte") )
            {
               gxTv_SdtConcepto_Conimporte = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConVigencia") )
            {
               gxTv_SdtConcepto_Convigencia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConLiqBasica") )
            {
               gxTv_SdtConcepto_Conliqbasica = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormula") )
            {
               gxTv_SdtConcepto_Conformula = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaPreResuelta") )
            {
               gxTv_SdtConcepto_Conformulapreresuelta = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValorGen") )
            {
               gxTv_SdtConcepto_Convalorgen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqGanancias") )
            {
               gxTv_SdtConcepto_Contipoliqganancias = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObservacion") )
            {
               gxTv_SdtConcepto_Conobservacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConVariable") )
            {
               gxTv_SdtConcepto_Convariable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConHisFormula") )
            {
               gxTv_SdtConcepto_Conhisformula = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConUsuModFor") )
            {
               gxTv_SdtConcepto_Conusumodfor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFchModFor") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtConcepto_Confchmodfor = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtConcepto_Confchmodfor = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaAbr") )
            {
               gxTv_SdtConcepto_Conformulaabr = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodYDesc") )
            {
               gxTv_SdtConcepto_Concodydesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoConCod") )
            {
               gxTv_SdtConcepto_Tipoconcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod1") )
            {
               gxTv_SdtConcepto_Subtipoconcod1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod2") )
            {
               gxTv_SdtConcepto_Subtipoconcod2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipo") )
            {
               gxTv_SdtConcepto_Contipo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodOld") )
            {
               gxTv_SdtConcepto_Concodold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCuenDebe") )
            {
               gxTv_SdtConcepto_Concuendebe = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCuenHaber") )
            {
               gxTv_SdtConcepto_Concuenhaber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqAux") )
            {
               gxTv_SdtConcepto_Contipoliqaux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConConveAux") )
            {
               gxTv_SdtConcepto_Conconveaux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConClasifAux") )
            {
               gxTv_SdtConcepto_Conclasifaux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrdEjec") )
            {
               gxTv_SdtConcepto_Conordejec = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaExpl") )
            {
               gxTv_SdtConcepto_Conformulaexpl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaObs2") )
            {
               gxTv_SdtConcepto_Conformulaobs2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRetGanPropor") )
            {
               gxTv_SdtConcepto_Conretganpropor = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAplicGan") )
            {
               gxTv_SdtConcepto_Conaplicgan = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRecalcular") )
            {
               gxTv_SdtConcepto_Conrecalcular = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImportado") )
            {
               gxTv_SdtConcepto_Conimportado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoOrden") )
            {
               gxTv_SdtConcepto_Contipoorden = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConEdiEnRec") )
            {
               gxTv_SdtConcepto_Conedienrec = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRangoCant") )
            {
               gxTv_SdtConcepto_Conrangocant = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoLiquidacion") )
            {
               if ( gxTv_SdtConcepto_Tipoliquidacion == null )
               {
                  gxTv_SdtConcepto_Tipoliquidacion = new GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion>(web.SdtConcepto_TipoLiquidacion.class, "Concepto.TipoLiquidacion", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtConcepto_Tipoliquidacion.readxml(oReader, "TipoLiquidacion") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "TipoLiquidacion") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConUsado") )
            {
               gxTv_SdtConcepto_Conusado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObliga") )
            {
               gxTv_SdtConcepto_Conobliga = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObligaSiSac") )
            {
               gxTv_SdtConcepto_Conobligasisac = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondicion") )
            {
               gxTv_SdtConcepto_Concondicion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondCodigo") )
            {
               gxTv_SdtConcepto_Concondcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPreReq") )
            {
               gxTv_SdtConcepto_Conprereq = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMostrarPos") )
            {
               gxTv_SdtConcepto_Conmostrarpos = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAdelDescu") )
            {
               gxTv_SdtConcepto_Conadeldescu = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AplIIGG") )
            {
               gxTv_SdtConcepto_Apliigg = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSegunPla") )
            {
               gxTv_SdtConcepto_Consegunpla = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConNumero") )
            {
               gxTv_SdtConcepto_Connumero = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSIPAApo") )
            {
               gxTv_SdtConcepto_Consipaapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSIPACont") )
            {
               gxTv_SdtConcepto_Consipacont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConINSSJyPApo") )
            {
               gxTv_SdtConcepto_Coninssjypapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConINSSJyPCont") )
            {
               gxTv_SdtConcepto_Coninssjypcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObraSocApo") )
            {
               gxTv_SdtConcepto_Conobrasocapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObraSocCont") )
            {
               gxTv_SdtConcepto_Conobrasoccont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MotivosEgreso") )
            {
               if ( gxTv_SdtConcepto_Motivosegreso == null )
               {
                  gxTv_SdtConcepto_Motivosegreso = new GXBCLevelCollection<web.SdtConcepto_MotivosEgreso>(web.SdtConcepto_MotivosEgreso.class, "Concepto.MotivosEgreso", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtConcepto_Motivosegreso.readxml(oReader, "MotivosEgreso") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "MotivosEgreso") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonSolRedApo") )
            {
               gxTv_SdtConcepto_Confonsolredapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonSolRedCont") )
            {
               gxTv_SdtConcepto_Confonsolredcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRenateaApo") )
            {
               gxTv_SdtConcepto_Conrenateaapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRenateaCont") )
            {
               gxTv_SdtConcepto_Conrenateacont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAsigFamCont") )
            {
               gxTv_SdtConcepto_Conasigfamcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonNacEmpCont") )
            {
               gxTv_SdtConcepto_Confonnacempcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConLeyRieTrabCont") )
            {
               gxTv_SdtConcepto_Conleyrietrabcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRegDifApo") )
            {
               gxTv_SdtConcepto_Conregdifapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRegEspApo") )
            {
               gxTv_SdtConcepto_Conregespapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSacDeven") )
            {
               gxTv_SdtConcepto_Consacdeven = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLic") )
            {
               gxTv_SdtConcepto_Conbaselic = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLicProm") )
            {
               gxTv_SdtConcepto_Conbaselicprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFer") )
            {
               gxTv_SdtConcepto_Conbasefer = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFerProm") )
            {
               gxTv_SdtConcepto_Conbaseferprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExt") )
            {
               gxTv_SdtConcepto_Conbasehorext = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExtProm") )
            {
               gxTv_SdtConcepto_Conbasehorextprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBasePres") )
            {
               gxTv_SdtConcepto_Conbasepres = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAnt") )
            {
               gxTv_SdtConcepto_Conbaseant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseOSDif") )
            {
               gxTv_SdtConcepto_Conbaseosdif = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAus") )
            {
               gxTv_SdtConcepto_Conbaseaus = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAusProm") )
            {
               gxTv_SdtConcepto_Conbaseausprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoPais") )
            {
               gxTv_SdtConcepto_Conceptopais = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoConveCodigo") )
            {
               gxTv_SdtConcepto_Conceptoconvecodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodAfip") )
            {
               gxTv_SdtConcepto_Concodafip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCntPa") )
            {
               gxTv_SdtConcepto_Concntpa = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConErrorSiCero") )
            {
               gxTv_SdtConcepto_Conerrorsicero = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPadre") )
            {
               gxTv_SdtConcepto_Clipadre = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPadre") )
            {
               gxTv_SdtConcepto_Conpadre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPueNov") )
            {
               gxTv_SdtConcepto_Conpuenov = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelSec") )
            {
               gxTv_SdtConcepto_Conrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelSecCli") )
            {
               gxTv_SdtConcepto_Conrelseccli = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOldValues") )
            {
               gxTv_SdtConcepto_Conoldvalues = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelRef") )
            {
               gxTv_SdtConcepto_Conrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescripSinAc") )
            {
               gxTv_SdtConcepto_Condescripsinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOblPalabra") )
            {
               gxTv_SdtConcepto_Conoblpalabra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConcepto_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConcepto_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtConcepto_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo_Z") )
            {
               gxTv_SdtConcepto_Concodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip_Z") )
            {
               gxTv_SdtConcepto_Condescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConHabilitado_Z") )
            {
               gxTv_SdtConcepto_Conhabilitado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrden_Z") )
            {
               gxTv_SdtConcepto_Conorden_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCanti_Z") )
            {
               gxTv_SdtConcepto_Concanti_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValUni_Z") )
            {
               gxTv_SdtConcepto_Convaluni_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImporte_Z") )
            {
               gxTv_SdtConcepto_Conimporte_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConVigencia_Z") )
            {
               gxTv_SdtConcepto_Convigencia_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConLiqBasica_Z") )
            {
               gxTv_SdtConcepto_Conliqbasica_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValorGen_Z") )
            {
               gxTv_SdtConcepto_Convalorgen_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqGanancias_Z") )
            {
               gxTv_SdtConcepto_Contipoliqganancias_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConVariable_Z") )
            {
               gxTv_SdtConcepto_Convariable_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConUsuModFor_Z") )
            {
               gxTv_SdtConcepto_Conusumodfor_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFchModFor_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtConcepto_Confchmodfor_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtConcepto_Confchmodfor_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaAbr_Z") )
            {
               gxTv_SdtConcepto_Conformulaabr_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodYDesc_Z") )
            {
               gxTv_SdtConcepto_Concodydesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoConCod_Z") )
            {
               gxTv_SdtConcepto_Tipoconcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod1_Z") )
            {
               gxTv_SdtConcepto_Subtipoconcod1_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod2_Z") )
            {
               gxTv_SdtConcepto_Subtipoconcod2_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipo_Z") )
            {
               gxTv_SdtConcepto_Contipo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodOld_Z") )
            {
               gxTv_SdtConcepto_Concodold_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCuenDebe_Z") )
            {
               gxTv_SdtConcepto_Concuendebe_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCuenHaber_Z") )
            {
               gxTv_SdtConcepto_Concuenhaber_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqAux_Z") )
            {
               gxTv_SdtConcepto_Contipoliqaux_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConConveAux_Z") )
            {
               gxTv_SdtConcepto_Conconveaux_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConClasifAux_Z") )
            {
               gxTv_SdtConcepto_Conclasifaux_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrdEjec_Z") )
            {
               gxTv_SdtConcepto_Conordejec_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRetGanPropor_Z") )
            {
               gxTv_SdtConcepto_Conretganpropor_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAplicGan_Z") )
            {
               gxTv_SdtConcepto_Conaplicgan_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRecalcular_Z") )
            {
               gxTv_SdtConcepto_Conrecalcular_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImportado_Z") )
            {
               gxTv_SdtConcepto_Conimportado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoOrden_Z") )
            {
               gxTv_SdtConcepto_Contipoorden_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConEdiEnRec_Z") )
            {
               gxTv_SdtConcepto_Conedienrec_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRangoCant_Z") )
            {
               gxTv_SdtConcepto_Conrangocant_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConUsado_Z") )
            {
               gxTv_SdtConcepto_Conusado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObliga_Z") )
            {
               gxTv_SdtConcepto_Conobliga_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObligaSiSac_Z") )
            {
               gxTv_SdtConcepto_Conobligasisac_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondicion_Z") )
            {
               gxTv_SdtConcepto_Concondicion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondCodigo_Z") )
            {
               gxTv_SdtConcepto_Concondcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPreReq_Z") )
            {
               gxTv_SdtConcepto_Conprereq_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMostrarPos_Z") )
            {
               gxTv_SdtConcepto_Conmostrarpos_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAdelDescu_Z") )
            {
               gxTv_SdtConcepto_Conadeldescu_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AplIIGG_Z") )
            {
               gxTv_SdtConcepto_Apliigg_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSegunPla_Z") )
            {
               gxTv_SdtConcepto_Consegunpla_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConNumero_Z") )
            {
               gxTv_SdtConcepto_Connumero_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSIPAApo_Z") )
            {
               gxTv_SdtConcepto_Consipaapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSIPACont_Z") )
            {
               gxTv_SdtConcepto_Consipacont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConINSSJyPApo_Z") )
            {
               gxTv_SdtConcepto_Coninssjypapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConINSSJyPCont_Z") )
            {
               gxTv_SdtConcepto_Coninssjypcont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObraSocApo_Z") )
            {
               gxTv_SdtConcepto_Conobrasocapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObraSocCont_Z") )
            {
               gxTv_SdtConcepto_Conobrasoccont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonSolRedApo_Z") )
            {
               gxTv_SdtConcepto_Confonsolredapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonSolRedCont_Z") )
            {
               gxTv_SdtConcepto_Confonsolredcont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRenateaApo_Z") )
            {
               gxTv_SdtConcepto_Conrenateaapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRenateaCont_Z") )
            {
               gxTv_SdtConcepto_Conrenateacont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAsigFamCont_Z") )
            {
               gxTv_SdtConcepto_Conasigfamcont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonNacEmpCont_Z") )
            {
               gxTv_SdtConcepto_Confonnacempcont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConLeyRieTrabCont_Z") )
            {
               gxTv_SdtConcepto_Conleyrietrabcont_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRegDifApo_Z") )
            {
               gxTv_SdtConcepto_Conregdifapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRegEspApo_Z") )
            {
               gxTv_SdtConcepto_Conregespapo_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSacDeven_Z") )
            {
               gxTv_SdtConcepto_Consacdeven_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLic_Z") )
            {
               gxTv_SdtConcepto_Conbaselic_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLicProm_Z") )
            {
               gxTv_SdtConcepto_Conbaselicprom_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFer_Z") )
            {
               gxTv_SdtConcepto_Conbasefer_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFerProm_Z") )
            {
               gxTv_SdtConcepto_Conbaseferprom_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExt_Z") )
            {
               gxTv_SdtConcepto_Conbasehorext_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExtProm_Z") )
            {
               gxTv_SdtConcepto_Conbasehorextprom_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBasePres_Z") )
            {
               gxTv_SdtConcepto_Conbasepres_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAnt_Z") )
            {
               gxTv_SdtConcepto_Conbaseant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseOSDif_Z") )
            {
               gxTv_SdtConcepto_Conbaseosdif_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAus_Z") )
            {
               gxTv_SdtConcepto_Conbaseaus_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAusProm_Z") )
            {
               gxTv_SdtConcepto_Conbaseausprom_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoPais_Z") )
            {
               gxTv_SdtConcepto_Conceptopais_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoConveCodigo_Z") )
            {
               gxTv_SdtConcepto_Conceptoconvecodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodAfip_Z") )
            {
               gxTv_SdtConcepto_Concodafip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCntPa_Z") )
            {
               gxTv_SdtConcepto_Concntpa_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConErrorSiCero_Z") )
            {
               gxTv_SdtConcepto_Conerrorsicero_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPadre_Z") )
            {
               gxTv_SdtConcepto_Clipadre_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPadre_Z") )
            {
               gxTv_SdtConcepto_Conpadre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPueNov_Z") )
            {
               gxTv_SdtConcepto_Conpuenov_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelSec_Z") )
            {
               gxTv_SdtConcepto_Conrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelSecCli_Z") )
            {
               gxTv_SdtConcepto_Conrelseccli_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelRef_Z") )
            {
               gxTv_SdtConcepto_Conrelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescripSinAc_Z") )
            {
               gxTv_SdtConcepto_Condescripsinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOblPalabra_Z") )
            {
               gxTv_SdtConcepto_Conoblpalabra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormula_N") )
            {
               gxTv_SdtConcepto_Conformula_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValorGen_N") )
            {
               gxTv_SdtConcepto_Convalorgen_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqGanancias_N") )
            {
               gxTv_SdtConcepto_Contipoliqganancias_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConHisFormula_N") )
            {
               gxTv_SdtConcepto_Conhisformula_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConUsuModFor_N") )
            {
               gxTv_SdtConcepto_Conusumodfor_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFchModFor_N") )
            {
               gxTv_SdtConcepto_Confchmodfor_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodYDesc_N") )
            {
               gxTv_SdtConcepto_Concodydesc_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod1_N") )
            {
               gxTv_SdtConcepto_Subtipoconcod1_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod2_N") )
            {
               gxTv_SdtConcepto_Subtipoconcod2_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCuenDebe_N") )
            {
               gxTv_SdtConcepto_Concuendebe_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCuenHaber_N") )
            {
               gxTv_SdtConcepto_Concuenhaber_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqAux_N") )
            {
               gxTv_SdtConcepto_Contipoliqaux_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConConveAux_N") )
            {
               gxTv_SdtConcepto_Conconveaux_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConClasifAux_N") )
            {
               gxTv_SdtConcepto_Conclasifaux_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAplicGan_N") )
            {
               gxTv_SdtConcepto_Conaplicgan_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObliga_N") )
            {
               gxTv_SdtConcepto_Conobliga_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObligaSiSac_N") )
            {
               gxTv_SdtConcepto_Conobligasisac_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondicion_N") )
            {
               gxTv_SdtConcepto_Concondicion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPreReq_N") )
            {
               gxTv_SdtConcepto_Conprereq_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAdelDescu_N") )
            {
               gxTv_SdtConcepto_Conadeldescu_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AplIIGG_N") )
            {
               gxTv_SdtConcepto_Apliigg_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoPais_N") )
            {
               gxTv_SdtConcepto_Conceptopais_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoConveCodigo_N") )
            {
               gxTv_SdtConcepto_Conceptoconvecodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPadre_N") )
            {
               gxTv_SdtConcepto_Clipadre_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPadre_N") )
            {
               gxTv_SdtConcepto_Conpadre_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOblPalabra_N") )
            {
               gxTv_SdtConcepto_Conoblpalabra_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Concepto" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodigo", gxTv_SdtConcepto_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescrip", gxTv_SdtConcepto_Condescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConHabilitado", GXutil.booltostr( gxTv_SdtConcepto_Conhabilitado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrden", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conorden, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCanti", GXutil.booltostr( gxTv_SdtConcepto_Concanti));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConValUni", GXutil.booltostr( gxTv_SdtConcepto_Convaluni));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConImporte", GXutil.booltostr( gxTv_SdtConcepto_Conimporte));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConVigencia", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Convigencia, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConLiqBasica", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conliqbasica, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormula", gxTv_SdtConcepto_Conformula);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaPreResuelta", gxTv_SdtConcepto_Conformulapreresuelta);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConValorGen", GXutil.trim( GXutil.strNoRound( gxTv_SdtConcepto_Convalorgen, 14, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipoLiqGanancias", gxTv_SdtConcepto_Contipoliqganancias);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObservacion", gxTv_SdtConcepto_Conobservacion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConVariable", GXutil.booltostr( gxTv_SdtConcepto_Convariable));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConHisFormula", gxTv_SdtConcepto_Conhisformula);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConUsuModFor", gxTv_SdtConcepto_Conusumodfor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConcepto_Confchmodfor), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConcepto_Confchmodfor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConcepto_Confchmodfor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtConcepto_Confchmodfor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtConcepto_Confchmodfor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtConcepto_Confchmodfor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("ConFchModFor", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaAbr", gxTv_SdtConcepto_Conformulaabr);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodYDesc", gxTv_SdtConcepto_Concodydesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipoConCod", gxTv_SdtConcepto_Tipoconcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SubTipoConCod1", gxTv_SdtConcepto_Subtipoconcod1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SubTipoConCod2", gxTv_SdtConcepto_Subtipoconcod2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Contipo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodOld", gxTv_SdtConcepto_Concodold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCuenDebe", gxTv_SdtConcepto_Concuendebe);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCuenHaber", gxTv_SdtConcepto_Concuenhaber);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipoLiqAux", gxTv_SdtConcepto_Contipoliqaux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConConveAux", gxTv_SdtConcepto_Conconveaux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConClasifAux", gxTv_SdtConcepto_Conclasifaux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrdEjec", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conordejec, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaExpl", gxTv_SdtConcepto_Conformulaexpl);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaObs2", gxTv_SdtConcepto_Conformulaobs2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRetGanPropor", GXutil.booltostr( gxTv_SdtConcepto_Conretganpropor));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAplicGan", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conaplicgan, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRecalcular", GXutil.booltostr( gxTv_SdtConcepto_Conrecalcular));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConImportado", GXutil.booltostr( gxTv_SdtConcepto_Conimportado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipoOrden", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Contipoorden, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConEdiEnRec", GXutil.booltostr( gxTv_SdtConcepto_Conedienrec));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRangoCant", gxTv_SdtConcepto_Conrangocant);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtConcepto_Tipoliquidacion != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtConcepto_Tipoliquidacion.writexml(oWriter, "TipoLiquidacion", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("ConUsado", GXutil.booltostr( gxTv_SdtConcepto_Conusado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObliga", GXutil.booltostr( gxTv_SdtConcepto_Conobliga));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObligaSiSac", GXutil.booltostr( gxTv_SdtConcepto_Conobligasisac));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCondicion", gxTv_SdtConcepto_Concondicion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCondCodigo", gxTv_SdtConcepto_Concondcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConPreReq", gxTv_SdtConcepto_Conprereq);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMostrarPos", GXutil.booltostr( gxTv_SdtConcepto_Conmostrarpos));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAdelDescu", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conadeldescu, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AplIIGG", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Apliigg, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSegunPla", GXutil.booltostr( gxTv_SdtConcepto_Consegunpla));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConNumero", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Connumero, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSIPAApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Consipaapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSIPACont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Consipacont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConINSSJyPApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Coninssjypapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConINSSJyPCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Coninssjypcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObraSocApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conobrasocapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObraSocCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conobrasoccont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtConcepto_Motivosegreso != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtConcepto_Motivosegreso.writexml(oWriter, "MotivosEgreso", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("ConFonSolRedApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confonsolredapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFonSolRedCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confonsolredcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRenateaApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrenateaapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRenateaCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrenateacont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAsigFamCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conasigfamcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFonNacEmpCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confonnacempcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConLeyRieTrabCont", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conleyrietrabcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRegDifApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conregdifapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRegEspApo", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conregespapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSacDeven", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Consacdeven, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseLic", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaselic, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseLicProm", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaselicprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseFer", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasefer, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseFerProm", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseferprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseHorExt", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasehorext, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseHorExtProm", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasehorextprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBasePres", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasepres, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAnt", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseant, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseOSDif", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseosdif, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAus", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseaus, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAusProm", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseausprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConceptoPais", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conceptopais, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConceptoConveCodigo", gxTv_SdtConcepto_Conceptoconvecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodAfip", gxTv_SdtConcepto_Concodafip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCntPa", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Concntpa, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConErrorSiCero", GXutil.booltostr( gxTv_SdtConcepto_Conerrorsicero));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliPadre", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Clipadre, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConPadre", gxTv_SdtConcepto_Conpadre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConPueNov", GXutil.booltostr( gxTv_SdtConcepto_Conpuenov));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRelSec", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRelSecCli", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrelseccli, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOldValues", gxTv_SdtConcepto_Conoldvalues);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRelRef", gxTv_SdtConcepto_Conrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescripSinAc", gxTv_SdtConcepto_Condescripsinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOblPalabra", gxTv_SdtConcepto_Conoblpalabra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtConcepto_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodigo_Z", gxTv_SdtConcepto_Concodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConDescrip_Z", gxTv_SdtConcepto_Condescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConHabilitado_Z", GXutil.booltostr( gxTv_SdtConcepto_Conhabilitado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConOrden_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conorden_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCanti_Z", GXutil.booltostr( gxTv_SdtConcepto_Concanti_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConValUni_Z", GXutil.booltostr( gxTv_SdtConcepto_Convaluni_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConImporte_Z", GXutil.booltostr( gxTv_SdtConcepto_Conimporte_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConVigencia_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Convigencia_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConLiqBasica_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conliqbasica_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConValorGen_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtConcepto_Convalorgen_Z, 14, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTipoLiqGanancias_Z", gxTv_SdtConcepto_Contipoliqganancias_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConVariable_Z", GXutil.booltostr( gxTv_SdtConcepto_Convariable_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConUsuModFor_Z", gxTv_SdtConcepto_Conusumodfor_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtConcepto_Confchmodfor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtConcepto_Confchmodfor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtConcepto_Confchmodfor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtConcepto_Confchmodfor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtConcepto_Confchmodfor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtConcepto_Confchmodfor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("ConFchModFor_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConFormulaAbr_Z", gxTv_SdtConcepto_Conformulaabr_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodYDesc_Z", gxTv_SdtConcepto_Concodydesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoConCod_Z", gxTv_SdtConcepto_Tipoconcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SubTipoConCod1_Z", gxTv_SdtConcepto_Subtipoconcod1_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SubTipoConCod2_Z", gxTv_SdtConcepto_Subtipoconcod2_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTipo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Contipo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodOld_Z", gxTv_SdtConcepto_Concodold_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCuenDebe_Z", gxTv_SdtConcepto_Concuendebe_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCuenHaber_Z", gxTv_SdtConcepto_Concuenhaber_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTipoLiqAux_Z", gxTv_SdtConcepto_Contipoliqaux_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConConveAux_Z", gxTv_SdtConcepto_Conconveaux_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConClasifAux_Z", gxTv_SdtConcepto_Conclasifaux_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConOrdEjec_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conordejec_Z, 12, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRetGanPropor_Z", GXutil.booltostr( gxTv_SdtConcepto_Conretganpropor_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAplicGan_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conaplicgan_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRecalcular_Z", GXutil.booltostr( gxTv_SdtConcepto_Conrecalcular_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConImportado_Z", GXutil.booltostr( gxTv_SdtConcepto_Conimportado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTipoOrden_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Contipoorden_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConEdiEnRec_Z", GXutil.booltostr( gxTv_SdtConcepto_Conedienrec_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRangoCant_Z", gxTv_SdtConcepto_Conrangocant_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConUsado_Z", GXutil.booltostr( gxTv_SdtConcepto_Conusado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConObliga_Z", GXutil.booltostr( gxTv_SdtConcepto_Conobliga_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConObligaSiSac_Z", GXutil.booltostr( gxTv_SdtConcepto_Conobligasisac_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCondicion_Z", gxTv_SdtConcepto_Concondicion_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCondCodigo_Z", gxTv_SdtConcepto_Concondcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConPreReq_Z", gxTv_SdtConcepto_Conprereq_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConMostrarPos_Z", GXutil.booltostr( gxTv_SdtConcepto_Conmostrarpos_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAdelDescu_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conadeldescu_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AplIIGG_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Apliigg_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConSegunPla_Z", GXutil.booltostr( gxTv_SdtConcepto_Consegunpla_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Connumero_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConSIPAApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Consipaapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConSIPACont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Consipacont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConINSSJyPApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Coninssjypapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConINSSJyPCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Coninssjypcont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConObraSocApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conobrasocapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConObraSocCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conobrasoccont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConFonSolRedApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confonsolredapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConFonSolRedCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confonsolredcont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRenateaApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrenateaapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRenateaCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrenateacont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAsigFamCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conasigfamcont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConFonNacEmpCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confonnacempcont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConLeyRieTrabCont_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conleyrietrabcont_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRegDifApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conregdifapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRegEspApo_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conregespapo_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConSacDeven_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Consacdeven_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseLic_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaselic_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseLicProm_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaselicprom_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseFer_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasefer_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseFerProm_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseferprom_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseHorExt_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasehorext_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseHorExtProm_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasehorextprom_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBasePres_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbasepres_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseAnt_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseant_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseOSDif_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseosdif_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseAus_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseaus_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConBaseAusProm_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conbaseausprom_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConceptoPais_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conceptopais_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConceptoConveCodigo_Z", gxTv_SdtConcepto_Conceptoconvecodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodAfip_Z", gxTv_SdtConcepto_Concodafip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCntPa_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Concntpa_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConErrorSiCero_Z", GXutil.booltostr( gxTv_SdtConcepto_Conerrorsicero_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliPadre_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Clipadre_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConPadre_Z", gxTv_SdtConcepto_Conpadre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConPueNov_Z", GXutil.booltostr( gxTv_SdtConcepto_Conpuenov_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRelSecCli_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conrelseccli_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConRelRef_Z", gxTv_SdtConcepto_Conrelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConDescripSinAc_Z", gxTv_SdtConcepto_Condescripsinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConOblPalabra_Z", gxTv_SdtConcepto_Conoblpalabra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConFormula_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conformula_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConValorGen_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Convalorgen_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTipoLiqGanancias_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Contipoliqganancias_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConHisFormula_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conhisformula_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConUsuModFor_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conusumodfor_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConFchModFor_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Confchmodfor_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCodYDesc_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Concodydesc_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SubTipoConCod1_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Subtipoconcod1_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SubTipoConCod2_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Subtipoconcod2_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCuenDebe_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Concuendebe_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCuenHaber_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Concuenhaber_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTipoLiqAux_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Contipoliqaux_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConConveAux_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conconveaux_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConClasifAux_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conclasifaux_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAplicGan_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conaplicgan_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConObliga_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conobliga_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConObligaSiSac_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conobligasisac_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConCondicion_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Concondicion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConPreReq_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conprereq_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConAdelDescu_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conadeldescu_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("AplIIGG_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Apliigg_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConceptoPais_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conceptopais_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConceptoConveCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conceptoconvecodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliPadre_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Clipadre_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConPadre_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conpadre_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConOblPalabra_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_Conoblpalabra_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtConcepto_Clicod, false, includeNonInitialized);
      AddObjectProperty("ConCodigo", gxTv_SdtConcepto_Concodigo, false, includeNonInitialized);
      AddObjectProperty("ConDescrip", gxTv_SdtConcepto_Condescrip, false, includeNonInitialized);
      AddObjectProperty("ConHabilitado", gxTv_SdtConcepto_Conhabilitado, false, includeNonInitialized);
      AddObjectProperty("ConOrden", gxTv_SdtConcepto_Conorden, false, includeNonInitialized);
      AddObjectProperty("ConCanti", gxTv_SdtConcepto_Concanti, false, includeNonInitialized);
      AddObjectProperty("ConValUni", gxTv_SdtConcepto_Convaluni, false, includeNonInitialized);
      AddObjectProperty("ConImporte", gxTv_SdtConcepto_Conimporte, false, includeNonInitialized);
      AddObjectProperty("ConVigencia", gxTv_SdtConcepto_Convigencia, false, includeNonInitialized);
      AddObjectProperty("ConLiqBasica", gxTv_SdtConcepto_Conliqbasica, false, includeNonInitialized);
      AddObjectProperty("ConFormula", gxTv_SdtConcepto_Conformula, false, includeNonInitialized);
      AddObjectProperty("ConFormula_N", gxTv_SdtConcepto_Conformula_N, false, includeNonInitialized);
      AddObjectProperty("ConFormulaPreResuelta", gxTv_SdtConcepto_Conformulapreresuelta, false, includeNonInitialized);
      AddObjectProperty("ConValorGen", gxTv_SdtConcepto_Convalorgen, false, includeNonInitialized);
      AddObjectProperty("ConValorGen_N", gxTv_SdtConcepto_Convalorgen_N, false, includeNonInitialized);
      AddObjectProperty("ConTipoLiqGanancias", gxTv_SdtConcepto_Contipoliqganancias, false, includeNonInitialized);
      AddObjectProperty("ConTipoLiqGanancias_N", gxTv_SdtConcepto_Contipoliqganancias_N, false, includeNonInitialized);
      AddObjectProperty("ConObservacion", gxTv_SdtConcepto_Conobservacion, false, includeNonInitialized);
      AddObjectProperty("ConVariable", gxTv_SdtConcepto_Convariable, false, includeNonInitialized);
      AddObjectProperty("ConHisFormula", gxTv_SdtConcepto_Conhisformula, false, includeNonInitialized);
      AddObjectProperty("ConHisFormula_N", gxTv_SdtConcepto_Conhisformula_N, false, includeNonInitialized);
      AddObjectProperty("ConUsuModFor", gxTv_SdtConcepto_Conusumodfor, false, includeNonInitialized);
      AddObjectProperty("ConUsuModFor_N", gxTv_SdtConcepto_Conusumodfor_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtConcepto_Confchmodfor ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("ConFchModFor", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ConFchModFor_N", gxTv_SdtConcepto_Confchmodfor_N, false, includeNonInitialized);
      AddObjectProperty("ConFormulaAbr", gxTv_SdtConcepto_Conformulaabr, false, includeNonInitialized);
      AddObjectProperty("ConCodYDesc", gxTv_SdtConcepto_Concodydesc, false, includeNonInitialized);
      AddObjectProperty("ConCodYDesc_N", gxTv_SdtConcepto_Concodydesc_N, false, includeNonInitialized);
      AddObjectProperty("TipoConCod", gxTv_SdtConcepto_Tipoconcod, false, includeNonInitialized);
      AddObjectProperty("SubTipoConCod1", gxTv_SdtConcepto_Subtipoconcod1, false, includeNonInitialized);
      AddObjectProperty("SubTipoConCod1_N", gxTv_SdtConcepto_Subtipoconcod1_N, false, includeNonInitialized);
      AddObjectProperty("SubTipoConCod2", gxTv_SdtConcepto_Subtipoconcod2, false, includeNonInitialized);
      AddObjectProperty("SubTipoConCod2_N", gxTv_SdtConcepto_Subtipoconcod2_N, false, includeNonInitialized);
      AddObjectProperty("ConTipo", gxTv_SdtConcepto_Contipo, false, includeNonInitialized);
      AddObjectProperty("ConCodOld", gxTv_SdtConcepto_Concodold, false, includeNonInitialized);
      AddObjectProperty("ConCuenDebe", gxTv_SdtConcepto_Concuendebe, false, includeNonInitialized);
      AddObjectProperty("ConCuenDebe_N", gxTv_SdtConcepto_Concuendebe_N, false, includeNonInitialized);
      AddObjectProperty("ConCuenHaber", gxTv_SdtConcepto_Concuenhaber, false, includeNonInitialized);
      AddObjectProperty("ConCuenHaber_N", gxTv_SdtConcepto_Concuenhaber_N, false, includeNonInitialized);
      AddObjectProperty("ConTipoLiqAux", gxTv_SdtConcepto_Contipoliqaux, false, includeNonInitialized);
      AddObjectProperty("ConTipoLiqAux_N", gxTv_SdtConcepto_Contipoliqaux_N, false, includeNonInitialized);
      AddObjectProperty("ConConveAux", gxTv_SdtConcepto_Conconveaux, false, includeNonInitialized);
      AddObjectProperty("ConConveAux_N", gxTv_SdtConcepto_Conconveaux_N, false, includeNonInitialized);
      AddObjectProperty("ConClasifAux", gxTv_SdtConcepto_Conclasifaux, false, includeNonInitialized);
      AddObjectProperty("ConClasifAux_N", gxTv_SdtConcepto_Conclasifaux_N, false, includeNonInitialized);
      AddObjectProperty("ConOrdEjec", gxTv_SdtConcepto_Conordejec, false, includeNonInitialized);
      AddObjectProperty("ConFormulaExpl", gxTv_SdtConcepto_Conformulaexpl, false, includeNonInitialized);
      AddObjectProperty("ConFormulaObs2", gxTv_SdtConcepto_Conformulaobs2, false, includeNonInitialized);
      AddObjectProperty("ConRetGanPropor", gxTv_SdtConcepto_Conretganpropor, false, includeNonInitialized);
      AddObjectProperty("ConAplicGan", gxTv_SdtConcepto_Conaplicgan, false, includeNonInitialized);
      AddObjectProperty("ConAplicGan_N", gxTv_SdtConcepto_Conaplicgan_N, false, includeNonInitialized);
      AddObjectProperty("ConRecalcular", gxTv_SdtConcepto_Conrecalcular, false, includeNonInitialized);
      AddObjectProperty("ConImportado", gxTv_SdtConcepto_Conimportado, false, includeNonInitialized);
      AddObjectProperty("ConTipoOrden", gxTv_SdtConcepto_Contipoorden, false, includeNonInitialized);
      AddObjectProperty("ConEdiEnRec", gxTv_SdtConcepto_Conedienrec, false, includeNonInitialized);
      AddObjectProperty("ConRangoCant", gxTv_SdtConcepto_Conrangocant, false, includeNonInitialized);
      if ( gxTv_SdtConcepto_Tipoliquidacion != null )
      {
         AddObjectProperty("TipoLiquidacion", gxTv_SdtConcepto_Tipoliquidacion, includeState, includeNonInitialized);
      }
      AddObjectProperty("ConUsado", gxTv_SdtConcepto_Conusado, false, includeNonInitialized);
      AddObjectProperty("ConObliga", gxTv_SdtConcepto_Conobliga, false, includeNonInitialized);
      AddObjectProperty("ConObliga_N", gxTv_SdtConcepto_Conobliga_N, false, includeNonInitialized);
      AddObjectProperty("ConObligaSiSac", gxTv_SdtConcepto_Conobligasisac, false, includeNonInitialized);
      AddObjectProperty("ConObligaSiSac_N", gxTv_SdtConcepto_Conobligasisac_N, false, includeNonInitialized);
      AddObjectProperty("ConCondicion", gxTv_SdtConcepto_Concondicion, false, includeNonInitialized);
      AddObjectProperty("ConCondicion_N", gxTv_SdtConcepto_Concondicion_N, false, includeNonInitialized);
      AddObjectProperty("ConCondCodigo", gxTv_SdtConcepto_Concondcodigo, false, includeNonInitialized);
      AddObjectProperty("ConPreReq", gxTv_SdtConcepto_Conprereq, false, includeNonInitialized);
      AddObjectProperty("ConPreReq_N", gxTv_SdtConcepto_Conprereq_N, false, includeNonInitialized);
      AddObjectProperty("ConMostrarPos", gxTv_SdtConcepto_Conmostrarpos, false, includeNonInitialized);
      AddObjectProperty("ConAdelDescu", gxTv_SdtConcepto_Conadeldescu, false, includeNonInitialized);
      AddObjectProperty("ConAdelDescu_N", gxTv_SdtConcepto_Conadeldescu_N, false, includeNonInitialized);
      AddObjectProperty("AplIIGG", gxTv_SdtConcepto_Apliigg, false, includeNonInitialized);
      AddObjectProperty("AplIIGG_N", gxTv_SdtConcepto_Apliigg_N, false, includeNonInitialized);
      AddObjectProperty("ConSegunPla", gxTv_SdtConcepto_Consegunpla, false, includeNonInitialized);
      AddObjectProperty("ConNumero", gxTv_SdtConcepto_Connumero, false, includeNonInitialized);
      AddObjectProperty("ConSIPAApo", gxTv_SdtConcepto_Consipaapo, false, includeNonInitialized);
      AddObjectProperty("ConSIPACont", gxTv_SdtConcepto_Consipacont, false, includeNonInitialized);
      AddObjectProperty("ConINSSJyPApo", gxTv_SdtConcepto_Coninssjypapo, false, includeNonInitialized);
      AddObjectProperty("ConINSSJyPCont", gxTv_SdtConcepto_Coninssjypcont, false, includeNonInitialized);
      AddObjectProperty("ConObraSocApo", gxTv_SdtConcepto_Conobrasocapo, false, includeNonInitialized);
      AddObjectProperty("ConObraSocCont", gxTv_SdtConcepto_Conobrasoccont, false, includeNonInitialized);
      if ( gxTv_SdtConcepto_Motivosegreso != null )
      {
         AddObjectProperty("MotivosEgreso", gxTv_SdtConcepto_Motivosegreso, includeState, includeNonInitialized);
      }
      AddObjectProperty("ConFonSolRedApo", gxTv_SdtConcepto_Confonsolredapo, false, includeNonInitialized);
      AddObjectProperty("ConFonSolRedCont", gxTv_SdtConcepto_Confonsolredcont, false, includeNonInitialized);
      AddObjectProperty("ConRenateaApo", gxTv_SdtConcepto_Conrenateaapo, false, includeNonInitialized);
      AddObjectProperty("ConRenateaCont", gxTv_SdtConcepto_Conrenateacont, false, includeNonInitialized);
      AddObjectProperty("ConAsigFamCont", gxTv_SdtConcepto_Conasigfamcont, false, includeNonInitialized);
      AddObjectProperty("ConFonNacEmpCont", gxTv_SdtConcepto_Confonnacempcont, false, includeNonInitialized);
      AddObjectProperty("ConLeyRieTrabCont", gxTv_SdtConcepto_Conleyrietrabcont, false, includeNonInitialized);
      AddObjectProperty("ConRegDifApo", gxTv_SdtConcepto_Conregdifapo, false, includeNonInitialized);
      AddObjectProperty("ConRegEspApo", gxTv_SdtConcepto_Conregespapo, false, includeNonInitialized);
      AddObjectProperty("ConSacDeven", gxTv_SdtConcepto_Consacdeven, false, includeNonInitialized);
      AddObjectProperty("ConBaseLic", gxTv_SdtConcepto_Conbaselic, false, includeNonInitialized);
      AddObjectProperty("ConBaseLicProm", gxTv_SdtConcepto_Conbaselicprom, false, includeNonInitialized);
      AddObjectProperty("ConBaseFer", gxTv_SdtConcepto_Conbasefer, false, includeNonInitialized);
      AddObjectProperty("ConBaseFerProm", gxTv_SdtConcepto_Conbaseferprom, false, includeNonInitialized);
      AddObjectProperty("ConBaseHorExt", gxTv_SdtConcepto_Conbasehorext, false, includeNonInitialized);
      AddObjectProperty("ConBaseHorExtProm", gxTv_SdtConcepto_Conbasehorextprom, false, includeNonInitialized);
      AddObjectProperty("ConBasePres", gxTv_SdtConcepto_Conbasepres, false, includeNonInitialized);
      AddObjectProperty("ConBaseAnt", gxTv_SdtConcepto_Conbaseant, false, includeNonInitialized);
      AddObjectProperty("ConBaseOSDif", gxTv_SdtConcepto_Conbaseosdif, false, includeNonInitialized);
      AddObjectProperty("ConBaseAus", gxTv_SdtConcepto_Conbaseaus, false, includeNonInitialized);
      AddObjectProperty("ConBaseAusProm", gxTv_SdtConcepto_Conbaseausprom, false, includeNonInitialized);
      AddObjectProperty("ConceptoPais", gxTv_SdtConcepto_Conceptopais, false, includeNonInitialized);
      AddObjectProperty("ConceptoPais_N", gxTv_SdtConcepto_Conceptopais_N, false, includeNonInitialized);
      AddObjectProperty("ConceptoConveCodigo", gxTv_SdtConcepto_Conceptoconvecodigo, false, includeNonInitialized);
      AddObjectProperty("ConceptoConveCodigo_N", gxTv_SdtConcepto_Conceptoconvecodigo_N, false, includeNonInitialized);
      AddObjectProperty("ConCodAfip", gxTv_SdtConcepto_Concodafip, false, includeNonInitialized);
      AddObjectProperty("ConCntPa", gxTv_SdtConcepto_Concntpa, false, includeNonInitialized);
      AddObjectProperty("ConErrorSiCero", gxTv_SdtConcepto_Conerrorsicero, false, includeNonInitialized);
      AddObjectProperty("CliPadre", gxTv_SdtConcepto_Clipadre, false, includeNonInitialized);
      AddObjectProperty("CliPadre_N", gxTv_SdtConcepto_Clipadre_N, false, includeNonInitialized);
      AddObjectProperty("ConPadre", gxTv_SdtConcepto_Conpadre, false, includeNonInitialized);
      AddObjectProperty("ConPadre_N", gxTv_SdtConcepto_Conpadre_N, false, includeNonInitialized);
      AddObjectProperty("ConPueNov", gxTv_SdtConcepto_Conpuenov, false, includeNonInitialized);
      AddObjectProperty("ConRelSec", gxTv_SdtConcepto_Conrelsec, false, includeNonInitialized);
      AddObjectProperty("ConRelSecCli", gxTv_SdtConcepto_Conrelseccli, false, includeNonInitialized);
      AddObjectProperty("ConOldValues", gxTv_SdtConcepto_Conoldvalues, false, includeNonInitialized);
      AddObjectProperty("ConRelRef", gxTv_SdtConcepto_Conrelref, false, includeNonInitialized);
      AddObjectProperty("ConDescripSinAc", gxTv_SdtConcepto_Condescripsinac, false, includeNonInitialized);
      AddObjectProperty("ConOblPalabra", gxTv_SdtConcepto_Conoblpalabra, false, includeNonInitialized);
      AddObjectProperty("ConOblPalabra_N", gxTv_SdtConcepto_Conoblpalabra_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConcepto_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConcepto_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtConcepto_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodigo_Z", gxTv_SdtConcepto_Concodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConDescrip_Z", gxTv_SdtConcepto_Condescrip_Z, false, includeNonInitialized);
         AddObjectProperty("ConHabilitado_Z", gxTv_SdtConcepto_Conhabilitado_Z, false, includeNonInitialized);
         AddObjectProperty("ConOrden_Z", gxTv_SdtConcepto_Conorden_Z, false, includeNonInitialized);
         AddObjectProperty("ConCanti_Z", gxTv_SdtConcepto_Concanti_Z, false, includeNonInitialized);
         AddObjectProperty("ConValUni_Z", gxTv_SdtConcepto_Convaluni_Z, false, includeNonInitialized);
         AddObjectProperty("ConImporte_Z", gxTv_SdtConcepto_Conimporte_Z, false, includeNonInitialized);
         AddObjectProperty("ConVigencia_Z", gxTv_SdtConcepto_Convigencia_Z, false, includeNonInitialized);
         AddObjectProperty("ConLiqBasica_Z", gxTv_SdtConcepto_Conliqbasica_Z, false, includeNonInitialized);
         AddObjectProperty("ConValorGen_Z", gxTv_SdtConcepto_Convalorgen_Z, false, includeNonInitialized);
         AddObjectProperty("ConTipoLiqGanancias_Z", gxTv_SdtConcepto_Contipoliqganancias_Z, false, includeNonInitialized);
         AddObjectProperty("ConVariable_Z", gxTv_SdtConcepto_Convariable_Z, false, includeNonInitialized);
         AddObjectProperty("ConUsuModFor_Z", gxTv_SdtConcepto_Conusumodfor_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtConcepto_Confchmodfor_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("ConFchModFor_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ConFormulaAbr_Z", gxTv_SdtConcepto_Conformulaabr_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodYDesc_Z", gxTv_SdtConcepto_Concodydesc_Z, false, includeNonInitialized);
         AddObjectProperty("TipoConCod_Z", gxTv_SdtConcepto_Tipoconcod_Z, false, includeNonInitialized);
         AddObjectProperty("SubTipoConCod1_Z", gxTv_SdtConcepto_Subtipoconcod1_Z, false, includeNonInitialized);
         AddObjectProperty("SubTipoConCod2_Z", gxTv_SdtConcepto_Subtipoconcod2_Z, false, includeNonInitialized);
         AddObjectProperty("ConTipo_Z", gxTv_SdtConcepto_Contipo_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodOld_Z", gxTv_SdtConcepto_Concodold_Z, false, includeNonInitialized);
         AddObjectProperty("ConCuenDebe_Z", gxTv_SdtConcepto_Concuendebe_Z, false, includeNonInitialized);
         AddObjectProperty("ConCuenHaber_Z", gxTv_SdtConcepto_Concuenhaber_Z, false, includeNonInitialized);
         AddObjectProperty("ConTipoLiqAux_Z", gxTv_SdtConcepto_Contipoliqaux_Z, false, includeNonInitialized);
         AddObjectProperty("ConConveAux_Z", gxTv_SdtConcepto_Conconveaux_Z, false, includeNonInitialized);
         AddObjectProperty("ConClasifAux_Z", gxTv_SdtConcepto_Conclasifaux_Z, false, includeNonInitialized);
         AddObjectProperty("ConOrdEjec_Z", gxTv_SdtConcepto_Conordejec_Z, false, includeNonInitialized);
         AddObjectProperty("ConRetGanPropor_Z", gxTv_SdtConcepto_Conretganpropor_Z, false, includeNonInitialized);
         AddObjectProperty("ConAplicGan_Z", gxTv_SdtConcepto_Conaplicgan_Z, false, includeNonInitialized);
         AddObjectProperty("ConRecalcular_Z", gxTv_SdtConcepto_Conrecalcular_Z, false, includeNonInitialized);
         AddObjectProperty("ConImportado_Z", gxTv_SdtConcepto_Conimportado_Z, false, includeNonInitialized);
         AddObjectProperty("ConTipoOrden_Z", gxTv_SdtConcepto_Contipoorden_Z, false, includeNonInitialized);
         AddObjectProperty("ConEdiEnRec_Z", gxTv_SdtConcepto_Conedienrec_Z, false, includeNonInitialized);
         AddObjectProperty("ConRangoCant_Z", gxTv_SdtConcepto_Conrangocant_Z, false, includeNonInitialized);
         AddObjectProperty("ConUsado_Z", gxTv_SdtConcepto_Conusado_Z, false, includeNonInitialized);
         AddObjectProperty("ConObliga_Z", gxTv_SdtConcepto_Conobliga_Z, false, includeNonInitialized);
         AddObjectProperty("ConObligaSiSac_Z", gxTv_SdtConcepto_Conobligasisac_Z, false, includeNonInitialized);
         AddObjectProperty("ConCondicion_Z", gxTv_SdtConcepto_Concondicion_Z, false, includeNonInitialized);
         AddObjectProperty("ConCondCodigo_Z", gxTv_SdtConcepto_Concondcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConPreReq_Z", gxTv_SdtConcepto_Conprereq_Z, false, includeNonInitialized);
         AddObjectProperty("ConMostrarPos_Z", gxTv_SdtConcepto_Conmostrarpos_Z, false, includeNonInitialized);
         AddObjectProperty("ConAdelDescu_Z", gxTv_SdtConcepto_Conadeldescu_Z, false, includeNonInitialized);
         AddObjectProperty("AplIIGG_Z", gxTv_SdtConcepto_Apliigg_Z, false, includeNonInitialized);
         AddObjectProperty("ConSegunPla_Z", gxTv_SdtConcepto_Consegunpla_Z, false, includeNonInitialized);
         AddObjectProperty("ConNumero_Z", gxTv_SdtConcepto_Connumero_Z, false, includeNonInitialized);
         AddObjectProperty("ConSIPAApo_Z", gxTv_SdtConcepto_Consipaapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConSIPACont_Z", gxTv_SdtConcepto_Consipacont_Z, false, includeNonInitialized);
         AddObjectProperty("ConINSSJyPApo_Z", gxTv_SdtConcepto_Coninssjypapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConINSSJyPCont_Z", gxTv_SdtConcepto_Coninssjypcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConObraSocApo_Z", gxTv_SdtConcepto_Conobrasocapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConObraSocCont_Z", gxTv_SdtConcepto_Conobrasoccont_Z, false, includeNonInitialized);
         AddObjectProperty("ConFonSolRedApo_Z", gxTv_SdtConcepto_Confonsolredapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConFonSolRedCont_Z", gxTv_SdtConcepto_Confonsolredcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConRenateaApo_Z", gxTv_SdtConcepto_Conrenateaapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConRenateaCont_Z", gxTv_SdtConcepto_Conrenateacont_Z, false, includeNonInitialized);
         AddObjectProperty("ConAsigFamCont_Z", gxTv_SdtConcepto_Conasigfamcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConFonNacEmpCont_Z", gxTv_SdtConcepto_Confonnacempcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConLeyRieTrabCont_Z", gxTv_SdtConcepto_Conleyrietrabcont_Z, false, includeNonInitialized);
         AddObjectProperty("ConRegDifApo_Z", gxTv_SdtConcepto_Conregdifapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConRegEspApo_Z", gxTv_SdtConcepto_Conregespapo_Z, false, includeNonInitialized);
         AddObjectProperty("ConSacDeven_Z", gxTv_SdtConcepto_Consacdeven_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseLic_Z", gxTv_SdtConcepto_Conbaselic_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseLicProm_Z", gxTv_SdtConcepto_Conbaselicprom_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseFer_Z", gxTv_SdtConcepto_Conbasefer_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseFerProm_Z", gxTv_SdtConcepto_Conbaseferprom_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseHorExt_Z", gxTv_SdtConcepto_Conbasehorext_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseHorExtProm_Z", gxTv_SdtConcepto_Conbasehorextprom_Z, false, includeNonInitialized);
         AddObjectProperty("ConBasePres_Z", gxTv_SdtConcepto_Conbasepres_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseAnt_Z", gxTv_SdtConcepto_Conbaseant_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseOSDif_Z", gxTv_SdtConcepto_Conbaseosdif_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseAus_Z", gxTv_SdtConcepto_Conbaseaus_Z, false, includeNonInitialized);
         AddObjectProperty("ConBaseAusProm_Z", gxTv_SdtConcepto_Conbaseausprom_Z, false, includeNonInitialized);
         AddObjectProperty("ConceptoPais_Z", gxTv_SdtConcepto_Conceptopais_Z, false, includeNonInitialized);
         AddObjectProperty("ConceptoConveCodigo_Z", gxTv_SdtConcepto_Conceptoconvecodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConCodAfip_Z", gxTv_SdtConcepto_Concodafip_Z, false, includeNonInitialized);
         AddObjectProperty("ConCntPa_Z", gxTv_SdtConcepto_Concntpa_Z, false, includeNonInitialized);
         AddObjectProperty("ConErrorSiCero_Z", gxTv_SdtConcepto_Conerrorsicero_Z, false, includeNonInitialized);
         AddObjectProperty("CliPadre_Z", gxTv_SdtConcepto_Clipadre_Z, false, includeNonInitialized);
         AddObjectProperty("ConPadre_Z", gxTv_SdtConcepto_Conpadre_Z, false, includeNonInitialized);
         AddObjectProperty("ConPueNov_Z", gxTv_SdtConcepto_Conpuenov_Z, false, includeNonInitialized);
         AddObjectProperty("ConRelSec_Z", gxTv_SdtConcepto_Conrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("ConRelSecCli_Z", gxTv_SdtConcepto_Conrelseccli_Z, false, includeNonInitialized);
         AddObjectProperty("ConRelRef_Z", gxTv_SdtConcepto_Conrelref_Z, false, includeNonInitialized);
         AddObjectProperty("ConDescripSinAc_Z", gxTv_SdtConcepto_Condescripsinac_Z, false, includeNonInitialized);
         AddObjectProperty("ConOblPalabra_Z", gxTv_SdtConcepto_Conoblpalabra_Z, false, includeNonInitialized);
         AddObjectProperty("ConFormula_N", gxTv_SdtConcepto_Conformula_N, false, includeNonInitialized);
         AddObjectProperty("ConValorGen_N", gxTv_SdtConcepto_Convalorgen_N, false, includeNonInitialized);
         AddObjectProperty("ConTipoLiqGanancias_N", gxTv_SdtConcepto_Contipoliqganancias_N, false, includeNonInitialized);
         AddObjectProperty("ConHisFormula_N", gxTv_SdtConcepto_Conhisformula_N, false, includeNonInitialized);
         AddObjectProperty("ConUsuModFor_N", gxTv_SdtConcepto_Conusumodfor_N, false, includeNonInitialized);
         AddObjectProperty("ConFchModFor_N", gxTv_SdtConcepto_Confchmodfor_N, false, includeNonInitialized);
         AddObjectProperty("ConCodYDesc_N", gxTv_SdtConcepto_Concodydesc_N, false, includeNonInitialized);
         AddObjectProperty("SubTipoConCod1_N", gxTv_SdtConcepto_Subtipoconcod1_N, false, includeNonInitialized);
         AddObjectProperty("SubTipoConCod2_N", gxTv_SdtConcepto_Subtipoconcod2_N, false, includeNonInitialized);
         AddObjectProperty("ConCuenDebe_N", gxTv_SdtConcepto_Concuendebe_N, false, includeNonInitialized);
         AddObjectProperty("ConCuenHaber_N", gxTv_SdtConcepto_Concuenhaber_N, false, includeNonInitialized);
         AddObjectProperty("ConTipoLiqAux_N", gxTv_SdtConcepto_Contipoliqaux_N, false, includeNonInitialized);
         AddObjectProperty("ConConveAux_N", gxTv_SdtConcepto_Conconveaux_N, false, includeNonInitialized);
         AddObjectProperty("ConClasifAux_N", gxTv_SdtConcepto_Conclasifaux_N, false, includeNonInitialized);
         AddObjectProperty("ConAplicGan_N", gxTv_SdtConcepto_Conaplicgan_N, false, includeNonInitialized);
         AddObjectProperty("ConObliga_N", gxTv_SdtConcepto_Conobliga_N, false, includeNonInitialized);
         AddObjectProperty("ConObligaSiSac_N", gxTv_SdtConcepto_Conobligasisac_N, false, includeNonInitialized);
         AddObjectProperty("ConCondicion_N", gxTv_SdtConcepto_Concondicion_N, false, includeNonInitialized);
         AddObjectProperty("ConPreReq_N", gxTv_SdtConcepto_Conprereq_N, false, includeNonInitialized);
         AddObjectProperty("ConAdelDescu_N", gxTv_SdtConcepto_Conadeldescu_N, false, includeNonInitialized);
         AddObjectProperty("AplIIGG_N", gxTv_SdtConcepto_Apliigg_N, false, includeNonInitialized);
         AddObjectProperty("ConceptoPais_N", gxTv_SdtConcepto_Conceptopais_N, false, includeNonInitialized);
         AddObjectProperty("ConceptoConveCodigo_N", gxTv_SdtConcepto_Conceptoconvecodigo_N, false, includeNonInitialized);
         AddObjectProperty("CliPadre_N", gxTv_SdtConcepto_Clipadre_N, false, includeNonInitialized);
         AddObjectProperty("ConPadre_N", gxTv_SdtConcepto_Conpadre_N, false, includeNonInitialized);
         AddObjectProperty("ConOblPalabra_N", gxTv_SdtConcepto_Conoblpalabra_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtConcepto sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Clicod = sdt.getgxTv_SdtConcepto_Clicod() ;
      }
      if ( sdt.IsDirty("ConCodigo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concodigo = sdt.getgxTv_SdtConcepto_Concodigo() ;
      }
      if ( sdt.IsDirty("ConDescrip") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Condescrip = sdt.getgxTv_SdtConcepto_Condescrip() ;
      }
      if ( sdt.IsDirty("ConHabilitado") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conhabilitado = sdt.getgxTv_SdtConcepto_Conhabilitado() ;
      }
      if ( sdt.IsDirty("ConOrden") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conorden = sdt.getgxTv_SdtConcepto_Conorden() ;
      }
      if ( sdt.IsDirty("ConCanti") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concanti = sdt.getgxTv_SdtConcepto_Concanti() ;
      }
      if ( sdt.IsDirty("ConValUni") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Convaluni = sdt.getgxTv_SdtConcepto_Convaluni() ;
      }
      if ( sdt.IsDirty("ConImporte") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conimporte = sdt.getgxTv_SdtConcepto_Conimporte() ;
      }
      if ( sdt.IsDirty("ConVigencia") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Convigencia = sdt.getgxTv_SdtConcepto_Convigencia() ;
      }
      if ( sdt.IsDirty("ConLiqBasica") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conliqbasica = sdt.getgxTv_SdtConcepto_Conliqbasica() ;
      }
      if ( sdt.IsDirty("ConFormula") )
      {
         gxTv_SdtConcepto_Conformula_N = sdt.getgxTv_SdtConcepto_Conformula_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conformula = sdt.getgxTv_SdtConcepto_Conformula() ;
      }
      if ( sdt.IsDirty("ConFormulaPreResuelta") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conformulapreresuelta = sdt.getgxTv_SdtConcepto_Conformulapreresuelta() ;
      }
      if ( sdt.IsDirty("ConValorGen") )
      {
         gxTv_SdtConcepto_Convalorgen_N = sdt.getgxTv_SdtConcepto_Convalorgen_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Convalorgen = sdt.getgxTv_SdtConcepto_Convalorgen() ;
      }
      if ( sdt.IsDirty("ConTipoLiqGanancias") )
      {
         gxTv_SdtConcepto_Contipoliqganancias_N = sdt.getgxTv_SdtConcepto_Contipoliqganancias_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Contipoliqganancias = sdt.getgxTv_SdtConcepto_Contipoliqganancias() ;
      }
      if ( sdt.IsDirty("ConObservacion") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conobservacion = sdt.getgxTv_SdtConcepto_Conobservacion() ;
      }
      if ( sdt.IsDirty("ConVariable") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Convariable = sdt.getgxTv_SdtConcepto_Convariable() ;
      }
      if ( sdt.IsDirty("ConHisFormula") )
      {
         gxTv_SdtConcepto_Conhisformula_N = sdt.getgxTv_SdtConcepto_Conhisformula_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conhisformula = sdt.getgxTv_SdtConcepto_Conhisformula() ;
      }
      if ( sdt.IsDirty("ConUsuModFor") )
      {
         gxTv_SdtConcepto_Conusumodfor_N = sdt.getgxTv_SdtConcepto_Conusumodfor_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conusumodfor = sdt.getgxTv_SdtConcepto_Conusumodfor() ;
      }
      if ( sdt.IsDirty("ConFchModFor") )
      {
         gxTv_SdtConcepto_Confchmodfor_N = sdt.getgxTv_SdtConcepto_Confchmodfor_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Confchmodfor = sdt.getgxTv_SdtConcepto_Confchmodfor() ;
      }
      if ( sdt.IsDirty("ConFormulaAbr") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conformulaabr = sdt.getgxTv_SdtConcepto_Conformulaabr() ;
      }
      if ( sdt.IsDirty("ConCodYDesc") )
      {
         gxTv_SdtConcepto_Concodydesc_N = sdt.getgxTv_SdtConcepto_Concodydesc_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concodydesc = sdt.getgxTv_SdtConcepto_Concodydesc() ;
      }
      if ( sdt.IsDirty("TipoConCod") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Tipoconcod = sdt.getgxTv_SdtConcepto_Tipoconcod() ;
      }
      if ( sdt.IsDirty("SubTipoConCod1") )
      {
         gxTv_SdtConcepto_Subtipoconcod1_N = sdt.getgxTv_SdtConcepto_Subtipoconcod1_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Subtipoconcod1 = sdt.getgxTv_SdtConcepto_Subtipoconcod1() ;
      }
      if ( sdt.IsDirty("SubTipoConCod2") )
      {
         gxTv_SdtConcepto_Subtipoconcod2_N = sdt.getgxTv_SdtConcepto_Subtipoconcod2_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Subtipoconcod2 = sdt.getgxTv_SdtConcepto_Subtipoconcod2() ;
      }
      if ( sdt.IsDirty("ConTipo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Contipo = sdt.getgxTv_SdtConcepto_Contipo() ;
      }
      if ( sdt.IsDirty("ConCodOld") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concodold = sdt.getgxTv_SdtConcepto_Concodold() ;
      }
      if ( sdt.IsDirty("ConCuenDebe") )
      {
         gxTv_SdtConcepto_Concuendebe_N = sdt.getgxTv_SdtConcepto_Concuendebe_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concuendebe = sdt.getgxTv_SdtConcepto_Concuendebe() ;
      }
      if ( sdt.IsDirty("ConCuenHaber") )
      {
         gxTv_SdtConcepto_Concuenhaber_N = sdt.getgxTv_SdtConcepto_Concuenhaber_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concuenhaber = sdt.getgxTv_SdtConcepto_Concuenhaber() ;
      }
      if ( sdt.IsDirty("ConTipoLiqAux") )
      {
         gxTv_SdtConcepto_Contipoliqaux_N = sdt.getgxTv_SdtConcepto_Contipoliqaux_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Contipoliqaux = sdt.getgxTv_SdtConcepto_Contipoliqaux() ;
      }
      if ( sdt.IsDirty("ConConveAux") )
      {
         gxTv_SdtConcepto_Conconveaux_N = sdt.getgxTv_SdtConcepto_Conconveaux_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conconveaux = sdt.getgxTv_SdtConcepto_Conconveaux() ;
      }
      if ( sdt.IsDirty("ConClasifAux") )
      {
         gxTv_SdtConcepto_Conclasifaux_N = sdt.getgxTv_SdtConcepto_Conclasifaux_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conclasifaux = sdt.getgxTv_SdtConcepto_Conclasifaux() ;
      }
      if ( sdt.IsDirty("ConOrdEjec") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conordejec = sdt.getgxTv_SdtConcepto_Conordejec() ;
      }
      if ( sdt.IsDirty("ConFormulaExpl") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conformulaexpl = sdt.getgxTv_SdtConcepto_Conformulaexpl() ;
      }
      if ( sdt.IsDirty("ConFormulaObs2") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conformulaobs2 = sdt.getgxTv_SdtConcepto_Conformulaobs2() ;
      }
      if ( sdt.IsDirty("ConRetGanPropor") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conretganpropor = sdt.getgxTv_SdtConcepto_Conretganpropor() ;
      }
      if ( sdt.IsDirty("ConAplicGan") )
      {
         gxTv_SdtConcepto_Conaplicgan_N = sdt.getgxTv_SdtConcepto_Conaplicgan_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conaplicgan = sdt.getgxTv_SdtConcepto_Conaplicgan() ;
      }
      if ( sdt.IsDirty("ConRecalcular") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrecalcular = sdt.getgxTv_SdtConcepto_Conrecalcular() ;
      }
      if ( sdt.IsDirty("ConImportado") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conimportado = sdt.getgxTv_SdtConcepto_Conimportado() ;
      }
      if ( sdt.IsDirty("ConTipoOrden") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Contipoorden = sdt.getgxTv_SdtConcepto_Contipoorden() ;
      }
      if ( sdt.IsDirty("ConEdiEnRec") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conedienrec = sdt.getgxTv_SdtConcepto_Conedienrec() ;
      }
      if ( sdt.IsDirty("ConRangoCant") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrangocant = sdt.getgxTv_SdtConcepto_Conrangocant() ;
      }
      if ( gxTv_SdtConcepto_Tipoliquidacion != null )
      {
         GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> newCollectionTipoliquidacion = sdt.getgxTv_SdtConcepto_Tipoliquidacion();
         web.SdtConcepto_TipoLiquidacion currItemTipoliquidacion;
         web.SdtConcepto_TipoLiquidacion newItemTipoliquidacion;
         short idx = 1;
         while ( idx <= newCollectionTipoliquidacion.size() )
         {
            newItemTipoliquidacion = (web.SdtConcepto_TipoLiquidacion)((web.SdtConcepto_TipoLiquidacion)newCollectionTipoliquidacion.elementAt(-1+idx));
            currItemTipoliquidacion = (web.SdtConcepto_TipoLiquidacion)gxTv_SdtConcepto_Tipoliquidacion.getByKey(newItemTipoliquidacion.getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod());
            if ( GXutil.strcmp(currItemTipoliquidacion.getgxTv_SdtConcepto_TipoLiquidacion_Mode(), "UPD") == 0 )
            {
               currItemTipoliquidacion.updateDirties(newItemTipoliquidacion);
               if ( GXutil.strcmp(newItemTipoliquidacion.getgxTv_SdtConcepto_TipoLiquidacion_Mode(), "DLT") == 0 )
               {
                  currItemTipoliquidacion.setgxTv_SdtConcepto_TipoLiquidacion_Mode( "DLT" );
               }
               currItemTipoliquidacion.setgxTv_SdtConcepto_TipoLiquidacion_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtConcepto_Tipoliquidacion.add(newItemTipoliquidacion, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("ConUsado") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conusado = sdt.getgxTv_SdtConcepto_Conusado() ;
      }
      if ( sdt.IsDirty("ConObliga") )
      {
         gxTv_SdtConcepto_Conobliga_N = sdt.getgxTv_SdtConcepto_Conobliga_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conobliga = sdt.getgxTv_SdtConcepto_Conobliga() ;
      }
      if ( sdt.IsDirty("ConObligaSiSac") )
      {
         gxTv_SdtConcepto_Conobligasisac_N = sdt.getgxTv_SdtConcepto_Conobligasisac_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conobligasisac = sdt.getgxTv_SdtConcepto_Conobligasisac() ;
      }
      if ( sdt.IsDirty("ConCondicion") )
      {
         gxTv_SdtConcepto_Concondicion_N = sdt.getgxTv_SdtConcepto_Concondicion_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concondicion = sdt.getgxTv_SdtConcepto_Concondicion() ;
      }
      if ( sdt.IsDirty("ConCondCodigo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concondcodigo = sdt.getgxTv_SdtConcepto_Concondcodigo() ;
      }
      if ( sdt.IsDirty("ConPreReq") )
      {
         gxTv_SdtConcepto_Conprereq_N = sdt.getgxTv_SdtConcepto_Conprereq_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conprereq = sdt.getgxTv_SdtConcepto_Conprereq() ;
      }
      if ( sdt.IsDirty("ConMostrarPos") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conmostrarpos = sdt.getgxTv_SdtConcepto_Conmostrarpos() ;
      }
      if ( sdt.IsDirty("ConAdelDescu") )
      {
         gxTv_SdtConcepto_Conadeldescu_N = sdt.getgxTv_SdtConcepto_Conadeldescu_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conadeldescu = sdt.getgxTv_SdtConcepto_Conadeldescu() ;
      }
      if ( sdt.IsDirty("AplIIGG") )
      {
         gxTv_SdtConcepto_Apliigg_N = sdt.getgxTv_SdtConcepto_Apliigg_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Apliigg = sdt.getgxTv_SdtConcepto_Apliigg() ;
      }
      if ( sdt.IsDirty("ConSegunPla") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Consegunpla = sdt.getgxTv_SdtConcepto_Consegunpla() ;
      }
      if ( sdt.IsDirty("ConNumero") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Connumero = sdt.getgxTv_SdtConcepto_Connumero() ;
      }
      if ( sdt.IsDirty("ConSIPAApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Consipaapo = sdt.getgxTv_SdtConcepto_Consipaapo() ;
      }
      if ( sdt.IsDirty("ConSIPACont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Consipacont = sdt.getgxTv_SdtConcepto_Consipacont() ;
      }
      if ( sdt.IsDirty("ConINSSJyPApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Coninssjypapo = sdt.getgxTv_SdtConcepto_Coninssjypapo() ;
      }
      if ( sdt.IsDirty("ConINSSJyPCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Coninssjypcont = sdt.getgxTv_SdtConcepto_Coninssjypcont() ;
      }
      if ( sdt.IsDirty("ConObraSocApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conobrasocapo = sdt.getgxTv_SdtConcepto_Conobrasocapo() ;
      }
      if ( sdt.IsDirty("ConObraSocCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conobrasoccont = sdt.getgxTv_SdtConcepto_Conobrasoccont() ;
      }
      if ( gxTv_SdtConcepto_Motivosegreso != null )
      {
         GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> newCollectionMotivosegreso = sdt.getgxTv_SdtConcepto_Motivosegreso();
         web.SdtConcepto_MotivosEgreso currItemMotivosegreso;
         web.SdtConcepto_MotivosEgreso newItemMotivosegreso;
         short idx = 1;
         while ( idx <= newCollectionMotivosegreso.size() )
         {
            newItemMotivosegreso = (web.SdtConcepto_MotivosEgreso)((web.SdtConcepto_MotivosEgreso)newCollectionMotivosegreso.elementAt(-1+idx));
            currItemMotivosegreso = (web.SdtConcepto_MotivosEgreso)gxTv_SdtConcepto_Motivosegreso.getByKey(newItemMotivosegreso.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo(), newItemMotivosegreso.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec());
            if ( GXutil.strcmp(currItemMotivosegreso.getgxTv_SdtConcepto_MotivosEgreso_Mode(), "UPD") == 0 )
            {
               currItemMotivosegreso.updateDirties(newItemMotivosegreso);
               if ( GXutil.strcmp(newItemMotivosegreso.getgxTv_SdtConcepto_MotivosEgreso_Mode(), "DLT") == 0 )
               {
                  currItemMotivosegreso.setgxTv_SdtConcepto_MotivosEgreso_Mode( "DLT" );
               }
               currItemMotivosegreso.setgxTv_SdtConcepto_MotivosEgreso_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtConcepto_Motivosegreso.add(newItemMotivosegreso, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("ConFonSolRedApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Confonsolredapo = sdt.getgxTv_SdtConcepto_Confonsolredapo() ;
      }
      if ( sdt.IsDirty("ConFonSolRedCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Confonsolredcont = sdt.getgxTv_SdtConcepto_Confonsolredcont() ;
      }
      if ( sdt.IsDirty("ConRenateaApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrenateaapo = sdt.getgxTv_SdtConcepto_Conrenateaapo() ;
      }
      if ( sdt.IsDirty("ConRenateaCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrenateacont = sdt.getgxTv_SdtConcepto_Conrenateacont() ;
      }
      if ( sdt.IsDirty("ConAsigFamCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conasigfamcont = sdt.getgxTv_SdtConcepto_Conasigfamcont() ;
      }
      if ( sdt.IsDirty("ConFonNacEmpCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Confonnacempcont = sdt.getgxTv_SdtConcepto_Confonnacempcont() ;
      }
      if ( sdt.IsDirty("ConLeyRieTrabCont") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conleyrietrabcont = sdt.getgxTv_SdtConcepto_Conleyrietrabcont() ;
      }
      if ( sdt.IsDirty("ConRegDifApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conregdifapo = sdt.getgxTv_SdtConcepto_Conregdifapo() ;
      }
      if ( sdt.IsDirty("ConRegEspApo") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conregespapo = sdt.getgxTv_SdtConcepto_Conregespapo() ;
      }
      if ( sdt.IsDirty("ConSacDeven") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Consacdeven = sdt.getgxTv_SdtConcepto_Consacdeven() ;
      }
      if ( sdt.IsDirty("ConBaseLic") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaselic = sdt.getgxTv_SdtConcepto_Conbaselic() ;
      }
      if ( sdt.IsDirty("ConBaseLicProm") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaselicprom = sdt.getgxTv_SdtConcepto_Conbaselicprom() ;
      }
      if ( sdt.IsDirty("ConBaseFer") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbasefer = sdt.getgxTv_SdtConcepto_Conbasefer() ;
      }
      if ( sdt.IsDirty("ConBaseFerProm") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaseferprom = sdt.getgxTv_SdtConcepto_Conbaseferprom() ;
      }
      if ( sdt.IsDirty("ConBaseHorExt") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbasehorext = sdt.getgxTv_SdtConcepto_Conbasehorext() ;
      }
      if ( sdt.IsDirty("ConBaseHorExtProm") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbasehorextprom = sdt.getgxTv_SdtConcepto_Conbasehorextprom() ;
      }
      if ( sdt.IsDirty("ConBasePres") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbasepres = sdt.getgxTv_SdtConcepto_Conbasepres() ;
      }
      if ( sdt.IsDirty("ConBaseAnt") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaseant = sdt.getgxTv_SdtConcepto_Conbaseant() ;
      }
      if ( sdt.IsDirty("ConBaseOSDif") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaseosdif = sdt.getgxTv_SdtConcepto_Conbaseosdif() ;
      }
      if ( sdt.IsDirty("ConBaseAus") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaseaus = sdt.getgxTv_SdtConcepto_Conbaseaus() ;
      }
      if ( sdt.IsDirty("ConBaseAusProm") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conbaseausprom = sdt.getgxTv_SdtConcepto_Conbaseausprom() ;
      }
      if ( sdt.IsDirty("ConceptoPais") )
      {
         gxTv_SdtConcepto_Conceptopais_N = sdt.getgxTv_SdtConcepto_Conceptopais_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conceptopais = sdt.getgxTv_SdtConcepto_Conceptopais() ;
      }
      if ( sdt.IsDirty("ConceptoConveCodigo") )
      {
         gxTv_SdtConcepto_Conceptoconvecodigo_N = sdt.getgxTv_SdtConcepto_Conceptoconvecodigo_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conceptoconvecodigo = sdt.getgxTv_SdtConcepto_Conceptoconvecodigo() ;
      }
      if ( sdt.IsDirty("ConCodAfip") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concodafip = sdt.getgxTv_SdtConcepto_Concodafip() ;
      }
      if ( sdt.IsDirty("ConCntPa") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Concntpa = sdt.getgxTv_SdtConcepto_Concntpa() ;
      }
      if ( sdt.IsDirty("ConErrorSiCero") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conerrorsicero = sdt.getgxTv_SdtConcepto_Conerrorsicero() ;
      }
      if ( sdt.IsDirty("CliPadre") )
      {
         gxTv_SdtConcepto_Clipadre_N = sdt.getgxTv_SdtConcepto_Clipadre_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Clipadre = sdt.getgxTv_SdtConcepto_Clipadre() ;
      }
      if ( sdt.IsDirty("ConPadre") )
      {
         gxTv_SdtConcepto_Conpadre_N = sdt.getgxTv_SdtConcepto_Conpadre_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conpadre = sdt.getgxTv_SdtConcepto_Conpadre() ;
      }
      if ( sdt.IsDirty("ConPueNov") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conpuenov = sdt.getgxTv_SdtConcepto_Conpuenov() ;
      }
      if ( sdt.IsDirty("ConRelSec") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrelsec = sdt.getgxTv_SdtConcepto_Conrelsec() ;
      }
      if ( sdt.IsDirty("ConRelSecCli") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrelseccli = sdt.getgxTv_SdtConcepto_Conrelseccli() ;
      }
      if ( sdt.IsDirty("ConOldValues") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conoldvalues = sdt.getgxTv_SdtConcepto_Conoldvalues() ;
      }
      if ( sdt.IsDirty("ConRelRef") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conrelref = sdt.getgxTv_SdtConcepto_Conrelref() ;
      }
      if ( sdt.IsDirty("ConDescripSinAc") )
      {
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Condescripsinac = sdt.getgxTv_SdtConcepto_Condescripsinac() ;
      }
      if ( sdt.IsDirty("ConOblPalabra") )
      {
         gxTv_SdtConcepto_Conoblpalabra_N = sdt.getgxTv_SdtConcepto_Conoblpalabra_N() ;
         gxTv_SdtConcepto_N = (byte)(0) ;
         gxTv_SdtConcepto_Conoblpalabra = sdt.getgxTv_SdtConcepto_Conoblpalabra() ;
      }
   }

   public int getgxTv_SdtConcepto_Clicod( )
   {
      return gxTv_SdtConcepto_Clicod ;
   }

   public void setgxTv_SdtConcepto_Clicod( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      if ( gxTv_SdtConcepto_Clicod != value )
      {
         gxTv_SdtConcepto_Mode = "INS" ;
         this.setgxTv_SdtConcepto_Clicod_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodigo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Condescrip_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conhabilitado_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conorden_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concanti_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convaluni_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conimporte_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convigencia_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conliqbasica_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convalorgen_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipoliqganancias_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convariable_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conusumodfor_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confchmodfor_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conformulaabr_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodydesc_Z_SetNull( );
         this.setgxTv_SdtConcepto_Tipoconcod_Z_SetNull( );
         this.setgxTv_SdtConcepto_Subtipoconcod1_Z_SetNull( );
         this.setgxTv_SdtConcepto_Subtipoconcod2_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodold_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concuendebe_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concuenhaber_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipoliqaux_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conconveaux_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conclasifaux_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conordejec_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conretganpropor_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conaplicgan_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrecalcular_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conimportado_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipoorden_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conedienrec_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrangocant_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conusado_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobliga_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobligasisac_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concondicion_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concondcodigo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conprereq_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conmostrarpos_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conadeldescu_Z_SetNull( );
         this.setgxTv_SdtConcepto_Apliigg_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consegunpla_Z_SetNull( );
         this.setgxTv_SdtConcepto_Connumero_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consipaapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consipacont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Coninssjypapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Coninssjypcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobrasocapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobrasoccont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confonsolredapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confonsolredcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrenateaapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrenateacont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conasigfamcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confonnacempcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conleyrietrabcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conregdifapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conregespapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consacdeven_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaselic_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaselicprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasefer_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseferprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasehorext_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasehorextprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasepres_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseant_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseosdif_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseaus_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseausprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conceptopais_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conceptoconvecodigo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodafip_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concntpa_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conerrorsicero_Z_SetNull( );
         this.setgxTv_SdtConcepto_Clipadre_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conpadre_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conpuenov_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrelsec_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrelseccli_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrelref_Z_SetNull( );
         this.setgxTv_SdtConcepto_Condescripsinac_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conoblpalabra_Z_SetNull( );
         if ( gxTv_SdtConcepto_Tipoliquidacion != null )
         {
            GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> collectionTipoliquidacion = gxTv_SdtConcepto_Tipoliquidacion;
            web.SdtConcepto_TipoLiquidacion currItemTipoliquidacion;
            short idx = 1;
            while ( idx <= collectionTipoliquidacion.size() )
            {
               currItemTipoliquidacion = (web.SdtConcepto_TipoLiquidacion)((web.SdtConcepto_TipoLiquidacion)collectionTipoliquidacion.elementAt(-1+idx));
               currItemTipoliquidacion.setgxTv_SdtConcepto_TipoLiquidacion_Mode( "INS" );
               currItemTipoliquidacion.setgxTv_SdtConcepto_TipoLiquidacion_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtConcepto_Motivosegreso != null )
         {
            GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> collectionMotivosegreso = gxTv_SdtConcepto_Motivosegreso;
            web.SdtConcepto_MotivosEgreso currItemMotivosegreso;
            short idx = 1;
            while ( idx <= collectionMotivosegreso.size() )
            {
               currItemMotivosegreso = (web.SdtConcepto_MotivosEgreso)((web.SdtConcepto_MotivosEgreso)collectionMotivosegreso.elementAt(-1+idx));
               currItemMotivosegreso.setgxTv_SdtConcepto_MotivosEgreso_Mode( "INS" );
               currItemMotivosegreso.setgxTv_SdtConcepto_MotivosEgreso_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtConcepto_Clicod = value ;
   }

   public String getgxTv_SdtConcepto_Concodigo( )
   {
      return gxTv_SdtConcepto_Concodigo ;
   }

   public void setgxTv_SdtConcepto_Concodigo( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtConcepto_Concodigo, value) != 0 )
      {
         gxTv_SdtConcepto_Mode = "INS" ;
         this.setgxTv_SdtConcepto_Clicod_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodigo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Condescrip_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conhabilitado_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conorden_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concanti_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convaluni_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conimporte_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convigencia_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conliqbasica_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convalorgen_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipoliqganancias_Z_SetNull( );
         this.setgxTv_SdtConcepto_Convariable_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conusumodfor_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confchmodfor_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conformulaabr_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodydesc_Z_SetNull( );
         this.setgxTv_SdtConcepto_Tipoconcod_Z_SetNull( );
         this.setgxTv_SdtConcepto_Subtipoconcod1_Z_SetNull( );
         this.setgxTv_SdtConcepto_Subtipoconcod2_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodold_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concuendebe_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concuenhaber_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipoliqaux_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conconveaux_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conclasifaux_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conordejec_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conretganpropor_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conaplicgan_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrecalcular_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conimportado_Z_SetNull( );
         this.setgxTv_SdtConcepto_Contipoorden_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conedienrec_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrangocant_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conusado_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobliga_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobligasisac_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concondicion_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concondcodigo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conprereq_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conmostrarpos_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conadeldescu_Z_SetNull( );
         this.setgxTv_SdtConcepto_Apliigg_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consegunpla_Z_SetNull( );
         this.setgxTv_SdtConcepto_Connumero_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consipaapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consipacont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Coninssjypapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Coninssjypcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobrasocapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conobrasoccont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confonsolredapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confonsolredcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrenateaapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrenateacont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conasigfamcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Confonnacempcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conleyrietrabcont_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conregdifapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conregespapo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Consacdeven_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaselic_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaselicprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasefer_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseferprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasehorext_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasehorextprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbasepres_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseant_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseosdif_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseaus_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conbaseausprom_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conceptopais_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conceptoconvecodigo_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concodafip_Z_SetNull( );
         this.setgxTv_SdtConcepto_Concntpa_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conerrorsicero_Z_SetNull( );
         this.setgxTv_SdtConcepto_Clipadre_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conpadre_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conpuenov_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrelsec_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrelseccli_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conrelref_Z_SetNull( );
         this.setgxTv_SdtConcepto_Condescripsinac_Z_SetNull( );
         this.setgxTv_SdtConcepto_Conoblpalabra_Z_SetNull( );
         if ( gxTv_SdtConcepto_Tipoliquidacion != null )
         {
            GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> collectionTipoliquidacion = gxTv_SdtConcepto_Tipoliquidacion;
            web.SdtConcepto_TipoLiquidacion currItemTipoliquidacion;
            short idx = 1;
            while ( idx <= collectionTipoliquidacion.size() )
            {
               currItemTipoliquidacion = (web.SdtConcepto_TipoLiquidacion)((web.SdtConcepto_TipoLiquidacion)collectionTipoliquidacion.elementAt(-1+idx));
               currItemTipoliquidacion.setgxTv_SdtConcepto_TipoLiquidacion_Mode( "INS" );
               currItemTipoliquidacion.setgxTv_SdtConcepto_TipoLiquidacion_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtConcepto_Motivosegreso != null )
         {
            GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> collectionMotivosegreso = gxTv_SdtConcepto_Motivosegreso;
            web.SdtConcepto_MotivosEgreso currItemMotivosegreso;
            short idx = 1;
            while ( idx <= collectionMotivosegreso.size() )
            {
               currItemMotivosegreso = (web.SdtConcepto_MotivosEgreso)((web.SdtConcepto_MotivosEgreso)collectionMotivosegreso.elementAt(-1+idx));
               currItemMotivosegreso.setgxTv_SdtConcepto_MotivosEgreso_Mode( "INS" );
               currItemMotivosegreso.setgxTv_SdtConcepto_MotivosEgreso_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Concodigo");
      gxTv_SdtConcepto_Concodigo = value ;
   }

   public String getgxTv_SdtConcepto_Condescrip( )
   {
      return gxTv_SdtConcepto_Condescrip ;
   }

   public void setgxTv_SdtConcepto_Condescrip( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Condescrip");
      gxTv_SdtConcepto_Condescrip = value ;
   }

   public boolean getgxTv_SdtConcepto_Conhabilitado( )
   {
      return gxTv_SdtConcepto_Conhabilitado ;
   }

   public void setgxTv_SdtConcepto_Conhabilitado( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conhabilitado");
      gxTv_SdtConcepto_Conhabilitado = value ;
   }

   public int getgxTv_SdtConcepto_Conorden( )
   {
      return gxTv_SdtConcepto_Conorden ;
   }

   public void setgxTv_SdtConcepto_Conorden( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conorden");
      gxTv_SdtConcepto_Conorden = value ;
   }

   public boolean getgxTv_SdtConcepto_Concanti( )
   {
      return gxTv_SdtConcepto_Concanti ;
   }

   public void setgxTv_SdtConcepto_Concanti( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concanti");
      gxTv_SdtConcepto_Concanti = value ;
   }

   public boolean getgxTv_SdtConcepto_Convaluni( )
   {
      return gxTv_SdtConcepto_Convaluni ;
   }

   public void setgxTv_SdtConcepto_Convaluni( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convaluni");
      gxTv_SdtConcepto_Convaluni = value ;
   }

   public boolean getgxTv_SdtConcepto_Conimporte( )
   {
      return gxTv_SdtConcepto_Conimporte ;
   }

   public void setgxTv_SdtConcepto_Conimporte( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conimporte");
      gxTv_SdtConcepto_Conimporte = value ;
   }

   public byte getgxTv_SdtConcepto_Convigencia( )
   {
      return gxTv_SdtConcepto_Convigencia ;
   }

   public void setgxTv_SdtConcepto_Convigencia( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convigencia");
      gxTv_SdtConcepto_Convigencia = value ;
   }

   public byte getgxTv_SdtConcepto_Conliqbasica( )
   {
      return gxTv_SdtConcepto_Conliqbasica ;
   }

   public void setgxTv_SdtConcepto_Conliqbasica( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conliqbasica");
      gxTv_SdtConcepto_Conliqbasica = value ;
   }

   public String getgxTv_SdtConcepto_Conformula( )
   {
      return gxTv_SdtConcepto_Conformula ;
   }

   public void setgxTv_SdtConcepto_Conformula( String value )
   {
      gxTv_SdtConcepto_Conformula_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformula");
      gxTv_SdtConcepto_Conformula = value ;
   }

   public void setgxTv_SdtConcepto_Conformula_SetNull( )
   {
      gxTv_SdtConcepto_Conformula_N = (byte)(1) ;
      gxTv_SdtConcepto_Conformula = "" ;
      SetDirty("Conformula");
   }

   public boolean getgxTv_SdtConcepto_Conformula_IsNull( )
   {
      return (gxTv_SdtConcepto_Conformula_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conformulapreresuelta( )
   {
      return gxTv_SdtConcepto_Conformulapreresuelta ;
   }

   public void setgxTv_SdtConcepto_Conformulapreresuelta( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformulapreresuelta");
      gxTv_SdtConcepto_Conformulapreresuelta = value ;
   }

   public java.math.BigDecimal getgxTv_SdtConcepto_Convalorgen( )
   {
      return gxTv_SdtConcepto_Convalorgen ;
   }

   public void setgxTv_SdtConcepto_Convalorgen( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_Convalorgen_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convalorgen");
      gxTv_SdtConcepto_Convalorgen = value ;
   }

   public void setgxTv_SdtConcepto_Convalorgen_SetNull( )
   {
      gxTv_SdtConcepto_Convalorgen_N = (byte)(1) ;
      gxTv_SdtConcepto_Convalorgen = DecimalUtil.ZERO ;
      SetDirty("Convalorgen");
   }

   public boolean getgxTv_SdtConcepto_Convalorgen_IsNull( )
   {
      return (gxTv_SdtConcepto_Convalorgen_N==1) ;
   }

   public String getgxTv_SdtConcepto_Contipoliqganancias( )
   {
      return gxTv_SdtConcepto_Contipoliqganancias ;
   }

   public void setgxTv_SdtConcepto_Contipoliqganancias( String value )
   {
      gxTv_SdtConcepto_Contipoliqganancias_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoliqganancias");
      gxTv_SdtConcepto_Contipoliqganancias = value ;
   }

   public void setgxTv_SdtConcepto_Contipoliqganancias_SetNull( )
   {
      gxTv_SdtConcepto_Contipoliqganancias_N = (byte)(1) ;
      gxTv_SdtConcepto_Contipoliqganancias = "" ;
      SetDirty("Contipoliqganancias");
   }

   public boolean getgxTv_SdtConcepto_Contipoliqganancias_IsNull( )
   {
      return (gxTv_SdtConcepto_Contipoliqganancias_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conobservacion( )
   {
      return gxTv_SdtConcepto_Conobservacion ;
   }

   public void setgxTv_SdtConcepto_Conobservacion( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobservacion");
      gxTv_SdtConcepto_Conobservacion = value ;
   }

   public boolean getgxTv_SdtConcepto_Convariable( )
   {
      return gxTv_SdtConcepto_Convariable ;
   }

   public void setgxTv_SdtConcepto_Convariable( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convariable");
      gxTv_SdtConcepto_Convariable = value ;
   }

   public String getgxTv_SdtConcepto_Conhisformula( )
   {
      return gxTv_SdtConcepto_Conhisformula ;
   }

   public void setgxTv_SdtConcepto_Conhisformula( String value )
   {
      gxTv_SdtConcepto_Conhisformula_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conhisformula");
      gxTv_SdtConcepto_Conhisformula = value ;
   }

   public void setgxTv_SdtConcepto_Conhisformula_SetNull( )
   {
      gxTv_SdtConcepto_Conhisformula_N = (byte)(1) ;
      gxTv_SdtConcepto_Conhisformula = "" ;
      SetDirty("Conhisformula");
   }

   public boolean getgxTv_SdtConcepto_Conhisformula_IsNull( )
   {
      return (gxTv_SdtConcepto_Conhisformula_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conusumodfor( )
   {
      return gxTv_SdtConcepto_Conusumodfor ;
   }

   public void setgxTv_SdtConcepto_Conusumodfor( String value )
   {
      gxTv_SdtConcepto_Conusumodfor_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conusumodfor");
      gxTv_SdtConcepto_Conusumodfor = value ;
   }

   public void setgxTv_SdtConcepto_Conusumodfor_SetNull( )
   {
      gxTv_SdtConcepto_Conusumodfor_N = (byte)(1) ;
      gxTv_SdtConcepto_Conusumodfor = "" ;
      SetDirty("Conusumodfor");
   }

   public boolean getgxTv_SdtConcepto_Conusumodfor_IsNull( )
   {
      return (gxTv_SdtConcepto_Conusumodfor_N==1) ;
   }

   public java.util.Date getgxTv_SdtConcepto_Confchmodfor( )
   {
      return gxTv_SdtConcepto_Confchmodfor ;
   }

   public void setgxTv_SdtConcepto_Confchmodfor( java.util.Date value )
   {
      gxTv_SdtConcepto_Confchmodfor_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confchmodfor");
      gxTv_SdtConcepto_Confchmodfor = value ;
   }

   public void setgxTv_SdtConcepto_Confchmodfor_SetNull( )
   {
      gxTv_SdtConcepto_Confchmodfor_N = (byte)(1) ;
      gxTv_SdtConcepto_Confchmodfor = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Confchmodfor");
   }

   public boolean getgxTv_SdtConcepto_Confchmodfor_IsNull( )
   {
      return (gxTv_SdtConcepto_Confchmodfor_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conformulaabr( )
   {
      return gxTv_SdtConcepto_Conformulaabr ;
   }

   public void setgxTv_SdtConcepto_Conformulaabr( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformulaabr");
      gxTv_SdtConcepto_Conformulaabr = value ;
   }

   public void setgxTv_SdtConcepto_Conformulaabr_SetNull( )
   {
      gxTv_SdtConcepto_Conformulaabr = "" ;
      SetDirty("Conformulaabr");
   }

   public boolean getgxTv_SdtConcepto_Conformulaabr_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concodydesc( )
   {
      return gxTv_SdtConcepto_Concodydesc ;
   }

   public void setgxTv_SdtConcepto_Concodydesc( String value )
   {
      gxTv_SdtConcepto_Concodydesc_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodydesc");
      gxTv_SdtConcepto_Concodydesc = value ;
   }

   public void setgxTv_SdtConcepto_Concodydesc_SetNull( )
   {
      gxTv_SdtConcepto_Concodydesc_N = (byte)(1) ;
      gxTv_SdtConcepto_Concodydesc = "" ;
      SetDirty("Concodydesc");
   }

   public boolean getgxTv_SdtConcepto_Concodydesc_IsNull( )
   {
      return (gxTv_SdtConcepto_Concodydesc_N==1) ;
   }

   public String getgxTv_SdtConcepto_Tipoconcod( )
   {
      return gxTv_SdtConcepto_Tipoconcod ;
   }

   public void setgxTv_SdtConcepto_Tipoconcod( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Tipoconcod");
      gxTv_SdtConcepto_Tipoconcod = value ;
   }

   public String getgxTv_SdtConcepto_Subtipoconcod1( )
   {
      return gxTv_SdtConcepto_Subtipoconcod1 ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod1( String value )
   {
      gxTv_SdtConcepto_Subtipoconcod1_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Subtipoconcod1");
      gxTv_SdtConcepto_Subtipoconcod1 = value ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod1_SetNull( )
   {
      gxTv_SdtConcepto_Subtipoconcod1_N = (byte)(1) ;
      gxTv_SdtConcepto_Subtipoconcod1 = "" ;
      SetDirty("Subtipoconcod1");
   }

   public boolean getgxTv_SdtConcepto_Subtipoconcod1_IsNull( )
   {
      return (gxTv_SdtConcepto_Subtipoconcod1_N==1) ;
   }

   public String getgxTv_SdtConcepto_Subtipoconcod2( )
   {
      return gxTv_SdtConcepto_Subtipoconcod2 ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod2( String value )
   {
      gxTv_SdtConcepto_Subtipoconcod2_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Subtipoconcod2");
      gxTv_SdtConcepto_Subtipoconcod2 = value ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod2_SetNull( )
   {
      gxTv_SdtConcepto_Subtipoconcod2_N = (byte)(1) ;
      gxTv_SdtConcepto_Subtipoconcod2 = "" ;
      SetDirty("Subtipoconcod2");
   }

   public boolean getgxTv_SdtConcepto_Subtipoconcod2_IsNull( )
   {
      return (gxTv_SdtConcepto_Subtipoconcod2_N==1) ;
   }

   public byte getgxTv_SdtConcepto_Contipo( )
   {
      return gxTv_SdtConcepto_Contipo ;
   }

   public void setgxTv_SdtConcepto_Contipo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipo");
      gxTv_SdtConcepto_Contipo = value ;
   }

   public String getgxTv_SdtConcepto_Concodold( )
   {
      return gxTv_SdtConcepto_Concodold ;
   }

   public void setgxTv_SdtConcepto_Concodold( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodold");
      gxTv_SdtConcepto_Concodold = value ;
   }

   public String getgxTv_SdtConcepto_Concuendebe( )
   {
      return gxTv_SdtConcepto_Concuendebe ;
   }

   public void setgxTv_SdtConcepto_Concuendebe( String value )
   {
      gxTv_SdtConcepto_Concuendebe_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concuendebe");
      gxTv_SdtConcepto_Concuendebe = value ;
   }

   public void setgxTv_SdtConcepto_Concuendebe_SetNull( )
   {
      gxTv_SdtConcepto_Concuendebe_N = (byte)(1) ;
      gxTv_SdtConcepto_Concuendebe = "" ;
      SetDirty("Concuendebe");
   }

   public boolean getgxTv_SdtConcepto_Concuendebe_IsNull( )
   {
      return (gxTv_SdtConcepto_Concuendebe_N==1) ;
   }

   public String getgxTv_SdtConcepto_Concuenhaber( )
   {
      return gxTv_SdtConcepto_Concuenhaber ;
   }

   public void setgxTv_SdtConcepto_Concuenhaber( String value )
   {
      gxTv_SdtConcepto_Concuenhaber_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concuenhaber");
      gxTv_SdtConcepto_Concuenhaber = value ;
   }

   public void setgxTv_SdtConcepto_Concuenhaber_SetNull( )
   {
      gxTv_SdtConcepto_Concuenhaber_N = (byte)(1) ;
      gxTv_SdtConcepto_Concuenhaber = "" ;
      SetDirty("Concuenhaber");
   }

   public boolean getgxTv_SdtConcepto_Concuenhaber_IsNull( )
   {
      return (gxTv_SdtConcepto_Concuenhaber_N==1) ;
   }

   public String getgxTv_SdtConcepto_Contipoliqaux( )
   {
      return gxTv_SdtConcepto_Contipoliqaux ;
   }

   public void setgxTv_SdtConcepto_Contipoliqaux( String value )
   {
      gxTv_SdtConcepto_Contipoliqaux_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoliqaux");
      gxTv_SdtConcepto_Contipoliqaux = value ;
   }

   public void setgxTv_SdtConcepto_Contipoliqaux_SetNull( )
   {
      gxTv_SdtConcepto_Contipoliqaux_N = (byte)(1) ;
      gxTv_SdtConcepto_Contipoliqaux = "" ;
      SetDirty("Contipoliqaux");
   }

   public boolean getgxTv_SdtConcepto_Contipoliqaux_IsNull( )
   {
      return (gxTv_SdtConcepto_Contipoliqaux_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conconveaux( )
   {
      return gxTv_SdtConcepto_Conconveaux ;
   }

   public void setgxTv_SdtConcepto_Conconveaux( String value )
   {
      gxTv_SdtConcepto_Conconveaux_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conconveaux");
      gxTv_SdtConcepto_Conconveaux = value ;
   }

   public void setgxTv_SdtConcepto_Conconveaux_SetNull( )
   {
      gxTv_SdtConcepto_Conconveaux_N = (byte)(1) ;
      gxTv_SdtConcepto_Conconveaux = "" ;
      SetDirty("Conconveaux");
   }

   public boolean getgxTv_SdtConcepto_Conconveaux_IsNull( )
   {
      return (gxTv_SdtConcepto_Conconveaux_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conclasifaux( )
   {
      return gxTv_SdtConcepto_Conclasifaux ;
   }

   public void setgxTv_SdtConcepto_Conclasifaux( String value )
   {
      gxTv_SdtConcepto_Conclasifaux_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conclasifaux");
      gxTv_SdtConcepto_Conclasifaux = value ;
   }

   public void setgxTv_SdtConcepto_Conclasifaux_SetNull( )
   {
      gxTv_SdtConcepto_Conclasifaux_N = (byte)(1) ;
      gxTv_SdtConcepto_Conclasifaux = "" ;
      SetDirty("Conclasifaux");
   }

   public boolean getgxTv_SdtConcepto_Conclasifaux_IsNull( )
   {
      return (gxTv_SdtConcepto_Conclasifaux_N==1) ;
   }

   public long getgxTv_SdtConcepto_Conordejec( )
   {
      return gxTv_SdtConcepto_Conordejec ;
   }

   public void setgxTv_SdtConcepto_Conordejec( long value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conordejec");
      gxTv_SdtConcepto_Conordejec = value ;
   }

   public String getgxTv_SdtConcepto_Conformulaexpl( )
   {
      return gxTv_SdtConcepto_Conformulaexpl ;
   }

   public void setgxTv_SdtConcepto_Conformulaexpl( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformulaexpl");
      gxTv_SdtConcepto_Conformulaexpl = value ;
   }

   public String getgxTv_SdtConcepto_Conformulaobs2( )
   {
      return gxTv_SdtConcepto_Conformulaobs2 ;
   }

   public void setgxTv_SdtConcepto_Conformulaobs2( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformulaobs2");
      gxTv_SdtConcepto_Conformulaobs2 = value ;
   }

   public boolean getgxTv_SdtConcepto_Conretganpropor( )
   {
      return gxTv_SdtConcepto_Conretganpropor ;
   }

   public void setgxTv_SdtConcepto_Conretganpropor( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conretganpropor");
      gxTv_SdtConcepto_Conretganpropor = value ;
   }

   public byte getgxTv_SdtConcepto_Conaplicgan( )
   {
      return gxTv_SdtConcepto_Conaplicgan ;
   }

   public void setgxTv_SdtConcepto_Conaplicgan( byte value )
   {
      gxTv_SdtConcepto_Conaplicgan_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conaplicgan");
      gxTv_SdtConcepto_Conaplicgan = value ;
   }

   public void setgxTv_SdtConcepto_Conaplicgan_SetNull( )
   {
      gxTv_SdtConcepto_Conaplicgan_N = (byte)(1) ;
      gxTv_SdtConcepto_Conaplicgan = (byte)(0) ;
      SetDirty("Conaplicgan");
   }

   public boolean getgxTv_SdtConcepto_Conaplicgan_IsNull( )
   {
      return (gxTv_SdtConcepto_Conaplicgan_N==1) ;
   }

   public boolean getgxTv_SdtConcepto_Conrecalcular( )
   {
      return gxTv_SdtConcepto_Conrecalcular ;
   }

   public void setgxTv_SdtConcepto_Conrecalcular( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrecalcular");
      gxTv_SdtConcepto_Conrecalcular = value ;
   }

   public boolean getgxTv_SdtConcepto_Conimportado( )
   {
      return gxTv_SdtConcepto_Conimportado ;
   }

   public void setgxTv_SdtConcepto_Conimportado( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conimportado");
      gxTv_SdtConcepto_Conimportado = value ;
   }

   public short getgxTv_SdtConcepto_Contipoorden( )
   {
      return gxTv_SdtConcepto_Contipoorden ;
   }

   public void setgxTv_SdtConcepto_Contipoorden( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoorden");
      gxTv_SdtConcepto_Contipoorden = value ;
   }

   public boolean getgxTv_SdtConcepto_Conedienrec( )
   {
      return gxTv_SdtConcepto_Conedienrec ;
   }

   public void setgxTv_SdtConcepto_Conedienrec( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conedienrec");
      gxTv_SdtConcepto_Conedienrec = value ;
   }

   public String getgxTv_SdtConcepto_Conrangocant( )
   {
      return gxTv_SdtConcepto_Conrangocant ;
   }

   public void setgxTv_SdtConcepto_Conrangocant( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrangocant");
      gxTv_SdtConcepto_Conrangocant = value ;
   }

   public GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> getgxTv_SdtConcepto_Tipoliquidacion( )
   {
      if ( gxTv_SdtConcepto_Tipoliquidacion == null )
      {
         gxTv_SdtConcepto_Tipoliquidacion = new GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion>(web.SdtConcepto_TipoLiquidacion.class, "Concepto.TipoLiquidacion", "PayDay", remoteHandle);
      }
      gxTv_SdtConcepto_N = (byte)(0) ;
      return gxTv_SdtConcepto_Tipoliquidacion ;
   }

   public void setgxTv_SdtConcepto_Tipoliquidacion( GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Tipoliquidacion");
      gxTv_SdtConcepto_Tipoliquidacion = value ;
   }

   public void setgxTv_SdtConcepto_Tipoliquidacion_SetNull( )
   {
      gxTv_SdtConcepto_Tipoliquidacion = null ;
      SetDirty("Tipoliquidacion");
   }

   public boolean getgxTv_SdtConcepto_Tipoliquidacion_IsNull( )
   {
      if ( gxTv_SdtConcepto_Tipoliquidacion == null )
      {
         return true ;
      }
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conusado( )
   {
      return gxTv_SdtConcepto_Conusado ;
   }

   public void setgxTv_SdtConcepto_Conusado( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conusado");
      gxTv_SdtConcepto_Conusado = value ;
   }

   public boolean getgxTv_SdtConcepto_Conobliga( )
   {
      return gxTv_SdtConcepto_Conobliga ;
   }

   public void setgxTv_SdtConcepto_Conobliga( boolean value )
   {
      gxTv_SdtConcepto_Conobliga_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobliga");
      gxTv_SdtConcepto_Conobliga = value ;
   }

   public void setgxTv_SdtConcepto_Conobliga_SetNull( )
   {
      gxTv_SdtConcepto_Conobliga_N = (byte)(1) ;
      gxTv_SdtConcepto_Conobliga = false ;
      SetDirty("Conobliga");
   }

   public boolean getgxTv_SdtConcepto_Conobliga_IsNull( )
   {
      return (gxTv_SdtConcepto_Conobliga_N==1) ;
   }

   public boolean getgxTv_SdtConcepto_Conobligasisac( )
   {
      return gxTv_SdtConcepto_Conobligasisac ;
   }

   public void setgxTv_SdtConcepto_Conobligasisac( boolean value )
   {
      gxTv_SdtConcepto_Conobligasisac_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobligasisac");
      gxTv_SdtConcepto_Conobligasisac = value ;
   }

   public void setgxTv_SdtConcepto_Conobligasisac_SetNull( )
   {
      gxTv_SdtConcepto_Conobligasisac_N = (byte)(1) ;
      gxTv_SdtConcepto_Conobligasisac = false ;
      SetDirty("Conobligasisac");
   }

   public boolean getgxTv_SdtConcepto_Conobligasisac_IsNull( )
   {
      return (gxTv_SdtConcepto_Conobligasisac_N==1) ;
   }

   public String getgxTv_SdtConcepto_Concondicion( )
   {
      return gxTv_SdtConcepto_Concondicion ;
   }

   public void setgxTv_SdtConcepto_Concondicion( String value )
   {
      gxTv_SdtConcepto_Concondicion_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concondicion");
      gxTv_SdtConcepto_Concondicion = value ;
   }

   public void setgxTv_SdtConcepto_Concondicion_SetNull( )
   {
      gxTv_SdtConcepto_Concondicion_N = (byte)(1) ;
      gxTv_SdtConcepto_Concondicion = "" ;
      SetDirty("Concondicion");
   }

   public boolean getgxTv_SdtConcepto_Concondicion_IsNull( )
   {
      return (gxTv_SdtConcepto_Concondicion_N==1) ;
   }

   public String getgxTv_SdtConcepto_Concondcodigo( )
   {
      return gxTv_SdtConcepto_Concondcodigo ;
   }

   public void setgxTv_SdtConcepto_Concondcodigo( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concondcodigo");
      gxTv_SdtConcepto_Concondcodigo = value ;
   }

   public String getgxTv_SdtConcepto_Conprereq( )
   {
      return gxTv_SdtConcepto_Conprereq ;
   }

   public void setgxTv_SdtConcepto_Conprereq( String value )
   {
      gxTv_SdtConcepto_Conprereq_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conprereq");
      gxTv_SdtConcepto_Conprereq = value ;
   }

   public void setgxTv_SdtConcepto_Conprereq_SetNull( )
   {
      gxTv_SdtConcepto_Conprereq_N = (byte)(1) ;
      gxTv_SdtConcepto_Conprereq = "" ;
      SetDirty("Conprereq");
   }

   public boolean getgxTv_SdtConcepto_Conprereq_IsNull( )
   {
      return (gxTv_SdtConcepto_Conprereq_N==1) ;
   }

   public boolean getgxTv_SdtConcepto_Conmostrarpos( )
   {
      return gxTv_SdtConcepto_Conmostrarpos ;
   }

   public void setgxTv_SdtConcepto_Conmostrarpos( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conmostrarpos");
      gxTv_SdtConcepto_Conmostrarpos = value ;
   }

   public byte getgxTv_SdtConcepto_Conadeldescu( )
   {
      return gxTv_SdtConcepto_Conadeldescu ;
   }

   public void setgxTv_SdtConcepto_Conadeldescu( byte value )
   {
      gxTv_SdtConcepto_Conadeldescu_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conadeldescu");
      gxTv_SdtConcepto_Conadeldescu = value ;
   }

   public void setgxTv_SdtConcepto_Conadeldescu_SetNull( )
   {
      gxTv_SdtConcepto_Conadeldescu_N = (byte)(1) ;
      gxTv_SdtConcepto_Conadeldescu = (byte)(0) ;
      SetDirty("Conadeldescu");
   }

   public boolean getgxTv_SdtConcepto_Conadeldescu_IsNull( )
   {
      return (gxTv_SdtConcepto_Conadeldescu_N==1) ;
   }

   public short getgxTv_SdtConcepto_Apliigg( )
   {
      return gxTv_SdtConcepto_Apliigg ;
   }

   public void setgxTv_SdtConcepto_Apliigg( short value )
   {
      gxTv_SdtConcepto_Apliigg_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Apliigg");
      gxTv_SdtConcepto_Apliigg = value ;
   }

   public void setgxTv_SdtConcepto_Apliigg_SetNull( )
   {
      gxTv_SdtConcepto_Apliigg_N = (byte)(1) ;
      gxTv_SdtConcepto_Apliigg = (short)(0) ;
      SetDirty("Apliigg");
   }

   public boolean getgxTv_SdtConcepto_Apliigg_IsNull( )
   {
      return (gxTv_SdtConcepto_Apliigg_N==1) ;
   }

   public boolean getgxTv_SdtConcepto_Consegunpla( )
   {
      return gxTv_SdtConcepto_Consegunpla ;
   }

   public void setgxTv_SdtConcepto_Consegunpla( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consegunpla");
      gxTv_SdtConcepto_Consegunpla = value ;
   }

   public byte getgxTv_SdtConcepto_Connumero( )
   {
      return gxTv_SdtConcepto_Connumero ;
   }

   public void setgxTv_SdtConcepto_Connumero( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Connumero");
      gxTv_SdtConcepto_Connumero = value ;
   }

   public byte getgxTv_SdtConcepto_Consipaapo( )
   {
      return gxTv_SdtConcepto_Consipaapo ;
   }

   public void setgxTv_SdtConcepto_Consipaapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consipaapo");
      gxTv_SdtConcepto_Consipaapo = value ;
   }

   public byte getgxTv_SdtConcepto_Consipacont( )
   {
      return gxTv_SdtConcepto_Consipacont ;
   }

   public void setgxTv_SdtConcepto_Consipacont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consipacont");
      gxTv_SdtConcepto_Consipacont = value ;
   }

   public byte getgxTv_SdtConcepto_Coninssjypapo( )
   {
      return gxTv_SdtConcepto_Coninssjypapo ;
   }

   public void setgxTv_SdtConcepto_Coninssjypapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Coninssjypapo");
      gxTv_SdtConcepto_Coninssjypapo = value ;
   }

   public byte getgxTv_SdtConcepto_Coninssjypcont( )
   {
      return gxTv_SdtConcepto_Coninssjypcont ;
   }

   public void setgxTv_SdtConcepto_Coninssjypcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Coninssjypcont");
      gxTv_SdtConcepto_Coninssjypcont = value ;
   }

   public byte getgxTv_SdtConcepto_Conobrasocapo( )
   {
      return gxTv_SdtConcepto_Conobrasocapo ;
   }

   public void setgxTv_SdtConcepto_Conobrasocapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobrasocapo");
      gxTv_SdtConcepto_Conobrasocapo = value ;
   }

   public byte getgxTv_SdtConcepto_Conobrasoccont( )
   {
      return gxTv_SdtConcepto_Conobrasoccont ;
   }

   public void setgxTv_SdtConcepto_Conobrasoccont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobrasoccont");
      gxTv_SdtConcepto_Conobrasoccont = value ;
   }

   public GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> getgxTv_SdtConcepto_Motivosegreso( )
   {
      if ( gxTv_SdtConcepto_Motivosegreso == null )
      {
         gxTv_SdtConcepto_Motivosegreso = new GXBCLevelCollection<web.SdtConcepto_MotivosEgreso>(web.SdtConcepto_MotivosEgreso.class, "Concepto.MotivosEgreso", "PayDay", remoteHandle);
      }
      gxTv_SdtConcepto_N = (byte)(0) ;
      return gxTv_SdtConcepto_Motivosegreso ;
   }

   public void setgxTv_SdtConcepto_Motivosegreso( GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Motivosegreso");
      gxTv_SdtConcepto_Motivosegreso = value ;
   }

   public void setgxTv_SdtConcepto_Motivosegreso_SetNull( )
   {
      gxTv_SdtConcepto_Motivosegreso = null ;
      SetDirty("Motivosegreso");
   }

   public boolean getgxTv_SdtConcepto_Motivosegreso_IsNull( )
   {
      if ( gxTv_SdtConcepto_Motivosegreso == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtConcepto_Confonsolredapo( )
   {
      return gxTv_SdtConcepto_Confonsolredapo ;
   }

   public void setgxTv_SdtConcepto_Confonsolredapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confonsolredapo");
      gxTv_SdtConcepto_Confonsolredapo = value ;
   }

   public byte getgxTv_SdtConcepto_Confonsolredcont( )
   {
      return gxTv_SdtConcepto_Confonsolredcont ;
   }

   public void setgxTv_SdtConcepto_Confonsolredcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confonsolredcont");
      gxTv_SdtConcepto_Confonsolredcont = value ;
   }

   public byte getgxTv_SdtConcepto_Conrenateaapo( )
   {
      return gxTv_SdtConcepto_Conrenateaapo ;
   }

   public void setgxTv_SdtConcepto_Conrenateaapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrenateaapo");
      gxTv_SdtConcepto_Conrenateaapo = value ;
   }

   public byte getgxTv_SdtConcepto_Conrenateacont( )
   {
      return gxTv_SdtConcepto_Conrenateacont ;
   }

   public void setgxTv_SdtConcepto_Conrenateacont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrenateacont");
      gxTv_SdtConcepto_Conrenateacont = value ;
   }

   public byte getgxTv_SdtConcepto_Conasigfamcont( )
   {
      return gxTv_SdtConcepto_Conasigfamcont ;
   }

   public void setgxTv_SdtConcepto_Conasigfamcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conasigfamcont");
      gxTv_SdtConcepto_Conasigfamcont = value ;
   }

   public byte getgxTv_SdtConcepto_Confonnacempcont( )
   {
      return gxTv_SdtConcepto_Confonnacempcont ;
   }

   public void setgxTv_SdtConcepto_Confonnacempcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confonnacempcont");
      gxTv_SdtConcepto_Confonnacempcont = value ;
   }

   public byte getgxTv_SdtConcepto_Conleyrietrabcont( )
   {
      return gxTv_SdtConcepto_Conleyrietrabcont ;
   }

   public void setgxTv_SdtConcepto_Conleyrietrabcont( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conleyrietrabcont");
      gxTv_SdtConcepto_Conleyrietrabcont = value ;
   }

   public byte getgxTv_SdtConcepto_Conregdifapo( )
   {
      return gxTv_SdtConcepto_Conregdifapo ;
   }

   public void setgxTv_SdtConcepto_Conregdifapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conregdifapo");
      gxTv_SdtConcepto_Conregdifapo = value ;
   }

   public byte getgxTv_SdtConcepto_Conregespapo( )
   {
      return gxTv_SdtConcepto_Conregespapo ;
   }

   public void setgxTv_SdtConcepto_Conregespapo( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conregespapo");
      gxTv_SdtConcepto_Conregespapo = value ;
   }

   public byte getgxTv_SdtConcepto_Consacdeven( )
   {
      return gxTv_SdtConcepto_Consacdeven ;
   }

   public void setgxTv_SdtConcepto_Consacdeven( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consacdeven");
      gxTv_SdtConcepto_Consacdeven = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaselic( )
   {
      return gxTv_SdtConcepto_Conbaselic ;
   }

   public void setgxTv_SdtConcepto_Conbaselic( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaselic");
      gxTv_SdtConcepto_Conbaselic = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaselicprom( )
   {
      return gxTv_SdtConcepto_Conbaselicprom ;
   }

   public void setgxTv_SdtConcepto_Conbaselicprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaselicprom");
      gxTv_SdtConcepto_Conbaselicprom = value ;
   }

   public byte getgxTv_SdtConcepto_Conbasefer( )
   {
      return gxTv_SdtConcepto_Conbasefer ;
   }

   public void setgxTv_SdtConcepto_Conbasefer( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasefer");
      gxTv_SdtConcepto_Conbasefer = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaseferprom( )
   {
      return gxTv_SdtConcepto_Conbaseferprom ;
   }

   public void setgxTv_SdtConcepto_Conbaseferprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseferprom");
      gxTv_SdtConcepto_Conbaseferprom = value ;
   }

   public byte getgxTv_SdtConcepto_Conbasehorext( )
   {
      return gxTv_SdtConcepto_Conbasehorext ;
   }

   public void setgxTv_SdtConcepto_Conbasehorext( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasehorext");
      gxTv_SdtConcepto_Conbasehorext = value ;
   }

   public byte getgxTv_SdtConcepto_Conbasehorextprom( )
   {
      return gxTv_SdtConcepto_Conbasehorextprom ;
   }

   public void setgxTv_SdtConcepto_Conbasehorextprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasehorextprom");
      gxTv_SdtConcepto_Conbasehorextprom = value ;
   }

   public byte getgxTv_SdtConcepto_Conbasepres( )
   {
      return gxTv_SdtConcepto_Conbasepres ;
   }

   public void setgxTv_SdtConcepto_Conbasepres( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasepres");
      gxTv_SdtConcepto_Conbasepres = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaseant( )
   {
      return gxTv_SdtConcepto_Conbaseant ;
   }

   public void setgxTv_SdtConcepto_Conbaseant( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseant");
      gxTv_SdtConcepto_Conbaseant = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaseosdif( )
   {
      return gxTv_SdtConcepto_Conbaseosdif ;
   }

   public void setgxTv_SdtConcepto_Conbaseosdif( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseosdif");
      gxTv_SdtConcepto_Conbaseosdif = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaseaus( )
   {
      return gxTv_SdtConcepto_Conbaseaus ;
   }

   public void setgxTv_SdtConcepto_Conbaseaus( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseaus");
      gxTv_SdtConcepto_Conbaseaus = value ;
   }

   public byte getgxTv_SdtConcepto_Conbaseausprom( )
   {
      return gxTv_SdtConcepto_Conbaseausprom ;
   }

   public void setgxTv_SdtConcepto_Conbaseausprom( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseausprom");
      gxTv_SdtConcepto_Conbaseausprom = value ;
   }

   public short getgxTv_SdtConcepto_Conceptopais( )
   {
      return gxTv_SdtConcepto_Conceptopais ;
   }

   public void setgxTv_SdtConcepto_Conceptopais( short value )
   {
      gxTv_SdtConcepto_Conceptopais_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conceptopais");
      gxTv_SdtConcepto_Conceptopais = value ;
   }

   public void setgxTv_SdtConcepto_Conceptopais_SetNull( )
   {
      gxTv_SdtConcepto_Conceptopais_N = (byte)(1) ;
      gxTv_SdtConcepto_Conceptopais = (short)(0) ;
      SetDirty("Conceptopais");
   }

   public boolean getgxTv_SdtConcepto_Conceptopais_IsNull( )
   {
      return (gxTv_SdtConcepto_Conceptopais_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conceptoconvecodigo( )
   {
      return gxTv_SdtConcepto_Conceptoconvecodigo ;
   }

   public void setgxTv_SdtConcepto_Conceptoconvecodigo( String value )
   {
      gxTv_SdtConcepto_Conceptoconvecodigo_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conceptoconvecodigo");
      gxTv_SdtConcepto_Conceptoconvecodigo = value ;
   }

   public void setgxTv_SdtConcepto_Conceptoconvecodigo_SetNull( )
   {
      gxTv_SdtConcepto_Conceptoconvecodigo_N = (byte)(1) ;
      gxTv_SdtConcepto_Conceptoconvecodigo = "" ;
      SetDirty("Conceptoconvecodigo");
   }

   public boolean getgxTv_SdtConcepto_Conceptoconvecodigo_IsNull( )
   {
      return (gxTv_SdtConcepto_Conceptoconvecodigo_N==1) ;
   }

   public String getgxTv_SdtConcepto_Concodafip( )
   {
      return gxTv_SdtConcepto_Concodafip ;
   }

   public void setgxTv_SdtConcepto_Concodafip( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodafip");
      gxTv_SdtConcepto_Concodafip = value ;
   }

   public byte getgxTv_SdtConcepto_Concntpa( )
   {
      return gxTv_SdtConcepto_Concntpa ;
   }

   public void setgxTv_SdtConcepto_Concntpa( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concntpa");
      gxTv_SdtConcepto_Concntpa = value ;
   }

   public boolean getgxTv_SdtConcepto_Conerrorsicero( )
   {
      return gxTv_SdtConcepto_Conerrorsicero ;
   }

   public void setgxTv_SdtConcepto_Conerrorsicero( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conerrorsicero");
      gxTv_SdtConcepto_Conerrorsicero = value ;
   }

   public int getgxTv_SdtConcepto_Clipadre( )
   {
      return gxTv_SdtConcepto_Clipadre ;
   }

   public void setgxTv_SdtConcepto_Clipadre( int value )
   {
      gxTv_SdtConcepto_Clipadre_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Clipadre");
      gxTv_SdtConcepto_Clipadre = value ;
   }

   public void setgxTv_SdtConcepto_Clipadre_SetNull( )
   {
      gxTv_SdtConcepto_Clipadre_N = (byte)(1) ;
      gxTv_SdtConcepto_Clipadre = 0 ;
      SetDirty("Clipadre");
   }

   public boolean getgxTv_SdtConcepto_Clipadre_IsNull( )
   {
      return (gxTv_SdtConcepto_Clipadre_N==1) ;
   }

   public String getgxTv_SdtConcepto_Conpadre( )
   {
      return gxTv_SdtConcepto_Conpadre ;
   }

   public void setgxTv_SdtConcepto_Conpadre( String value )
   {
      gxTv_SdtConcepto_Conpadre_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conpadre");
      gxTv_SdtConcepto_Conpadre = value ;
   }

   public void setgxTv_SdtConcepto_Conpadre_SetNull( )
   {
      gxTv_SdtConcepto_Conpadre_N = (byte)(1) ;
      gxTv_SdtConcepto_Conpadre = "" ;
      SetDirty("Conpadre");
   }

   public boolean getgxTv_SdtConcepto_Conpadre_IsNull( )
   {
      return (gxTv_SdtConcepto_Conpadre_N==1) ;
   }

   public boolean getgxTv_SdtConcepto_Conpuenov( )
   {
      return gxTv_SdtConcepto_Conpuenov ;
   }

   public void setgxTv_SdtConcepto_Conpuenov( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conpuenov");
      gxTv_SdtConcepto_Conpuenov = value ;
   }

   public int getgxTv_SdtConcepto_Conrelsec( )
   {
      return gxTv_SdtConcepto_Conrelsec ;
   }

   public void setgxTv_SdtConcepto_Conrelsec( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrelsec");
      gxTv_SdtConcepto_Conrelsec = value ;
   }

   public int getgxTv_SdtConcepto_Conrelseccli( )
   {
      return gxTv_SdtConcepto_Conrelseccli ;
   }

   public void setgxTv_SdtConcepto_Conrelseccli( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrelseccli");
      gxTv_SdtConcepto_Conrelseccli = value ;
   }

   public String getgxTv_SdtConcepto_Conoldvalues( )
   {
      return gxTv_SdtConcepto_Conoldvalues ;
   }

   public void setgxTv_SdtConcepto_Conoldvalues( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conoldvalues");
      gxTv_SdtConcepto_Conoldvalues = value ;
   }

   public String getgxTv_SdtConcepto_Conrelref( )
   {
      return gxTv_SdtConcepto_Conrelref ;
   }

   public void setgxTv_SdtConcepto_Conrelref( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrelref");
      gxTv_SdtConcepto_Conrelref = value ;
   }

   public String getgxTv_SdtConcepto_Condescripsinac( )
   {
      return gxTv_SdtConcepto_Condescripsinac ;
   }

   public void setgxTv_SdtConcepto_Condescripsinac( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Condescripsinac");
      gxTv_SdtConcepto_Condescripsinac = value ;
   }

   public String getgxTv_SdtConcepto_Conoblpalabra( )
   {
      return gxTv_SdtConcepto_Conoblpalabra ;
   }

   public void setgxTv_SdtConcepto_Conoblpalabra( String value )
   {
      gxTv_SdtConcepto_Conoblpalabra_N = (byte)(0) ;
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conoblpalabra");
      gxTv_SdtConcepto_Conoblpalabra = value ;
   }

   public void setgxTv_SdtConcepto_Conoblpalabra_SetNull( )
   {
      gxTv_SdtConcepto_Conoblpalabra_N = (byte)(1) ;
      gxTv_SdtConcepto_Conoblpalabra = "" ;
      SetDirty("Conoblpalabra");
   }

   public boolean getgxTv_SdtConcepto_Conoblpalabra_IsNull( )
   {
      return (gxTv_SdtConcepto_Conoblpalabra_N==1) ;
   }

   public String getgxTv_SdtConcepto_Mode( )
   {
      return gxTv_SdtConcepto_Mode ;
   }

   public void setgxTv_SdtConcepto_Mode( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConcepto_Mode = value ;
   }

   public void setgxTv_SdtConcepto_Mode_SetNull( )
   {
      gxTv_SdtConcepto_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtConcepto_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_Initialized( )
   {
      return gxTv_SdtConcepto_Initialized ;
   }

   public void setgxTv_SdtConcepto_Initialized( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtConcepto_Initialized = value ;
   }

   public void setgxTv_SdtConcepto_Initialized_SetNull( )
   {
      gxTv_SdtConcepto_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtConcepto_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConcepto_Clicod_Z( )
   {
      return gxTv_SdtConcepto_Clicod_Z ;
   }

   public void setgxTv_SdtConcepto_Clicod_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtConcepto_Clicod_Z = value ;
   }

   public void setgxTv_SdtConcepto_Clicod_Z_SetNull( )
   {
      gxTv_SdtConcepto_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtConcepto_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concodigo_Z( )
   {
      return gxTv_SdtConcepto_Concodigo_Z ;
   }

   public void setgxTv_SdtConcepto_Concodigo_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodigo_Z");
      gxTv_SdtConcepto_Concodigo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concodigo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concodigo_Z = "" ;
      SetDirty("Concodigo_Z");
   }

   public boolean getgxTv_SdtConcepto_Concodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Condescrip_Z( )
   {
      return gxTv_SdtConcepto_Condescrip_Z ;
   }

   public void setgxTv_SdtConcepto_Condescrip_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Condescrip_Z");
      gxTv_SdtConcepto_Condescrip_Z = value ;
   }

   public void setgxTv_SdtConcepto_Condescrip_Z_SetNull( )
   {
      gxTv_SdtConcepto_Condescrip_Z = "" ;
      SetDirty("Condescrip_Z");
   }

   public boolean getgxTv_SdtConcepto_Condescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conhabilitado_Z( )
   {
      return gxTv_SdtConcepto_Conhabilitado_Z ;
   }

   public void setgxTv_SdtConcepto_Conhabilitado_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conhabilitado_Z");
      gxTv_SdtConcepto_Conhabilitado_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conhabilitado_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conhabilitado_Z = false ;
      SetDirty("Conhabilitado_Z");
   }

   public boolean getgxTv_SdtConcepto_Conhabilitado_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConcepto_Conorden_Z( )
   {
      return gxTv_SdtConcepto_Conorden_Z ;
   }

   public void setgxTv_SdtConcepto_Conorden_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conorden_Z");
      gxTv_SdtConcepto_Conorden_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conorden_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conorden_Z = 0 ;
      SetDirty("Conorden_Z");
   }

   public boolean getgxTv_SdtConcepto_Conorden_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Concanti_Z( )
   {
      return gxTv_SdtConcepto_Concanti_Z ;
   }

   public void setgxTv_SdtConcepto_Concanti_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concanti_Z");
      gxTv_SdtConcepto_Concanti_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concanti_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concanti_Z = false ;
      SetDirty("Concanti_Z");
   }

   public boolean getgxTv_SdtConcepto_Concanti_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Convaluni_Z( )
   {
      return gxTv_SdtConcepto_Convaluni_Z ;
   }

   public void setgxTv_SdtConcepto_Convaluni_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convaluni_Z");
      gxTv_SdtConcepto_Convaluni_Z = value ;
   }

   public void setgxTv_SdtConcepto_Convaluni_Z_SetNull( )
   {
      gxTv_SdtConcepto_Convaluni_Z = false ;
      SetDirty("Convaluni_Z");
   }

   public boolean getgxTv_SdtConcepto_Convaluni_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conimporte_Z( )
   {
      return gxTv_SdtConcepto_Conimporte_Z ;
   }

   public void setgxTv_SdtConcepto_Conimporte_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conimporte_Z");
      gxTv_SdtConcepto_Conimporte_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conimporte_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conimporte_Z = false ;
      SetDirty("Conimporte_Z");
   }

   public boolean getgxTv_SdtConcepto_Conimporte_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Convigencia_Z( )
   {
      return gxTv_SdtConcepto_Convigencia_Z ;
   }

   public void setgxTv_SdtConcepto_Convigencia_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convigencia_Z");
      gxTv_SdtConcepto_Convigencia_Z = value ;
   }

   public void setgxTv_SdtConcepto_Convigencia_Z_SetNull( )
   {
      gxTv_SdtConcepto_Convigencia_Z = (byte)(0) ;
      SetDirty("Convigencia_Z");
   }

   public boolean getgxTv_SdtConcepto_Convigencia_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conliqbasica_Z( )
   {
      return gxTv_SdtConcepto_Conliqbasica_Z ;
   }

   public void setgxTv_SdtConcepto_Conliqbasica_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conliqbasica_Z");
      gxTv_SdtConcepto_Conliqbasica_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conliqbasica_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conliqbasica_Z = (byte)(0) ;
      SetDirty("Conliqbasica_Z");
   }

   public boolean getgxTv_SdtConcepto_Conliqbasica_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtConcepto_Convalorgen_Z( )
   {
      return gxTv_SdtConcepto_Convalorgen_Z ;
   }

   public void setgxTv_SdtConcepto_Convalorgen_Z( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convalorgen_Z");
      gxTv_SdtConcepto_Convalorgen_Z = value ;
   }

   public void setgxTv_SdtConcepto_Convalorgen_Z_SetNull( )
   {
      gxTv_SdtConcepto_Convalorgen_Z = DecimalUtil.ZERO ;
      SetDirty("Convalorgen_Z");
   }

   public boolean getgxTv_SdtConcepto_Convalorgen_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Contipoliqganancias_Z( )
   {
      return gxTv_SdtConcepto_Contipoliqganancias_Z ;
   }

   public void setgxTv_SdtConcepto_Contipoliqganancias_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoliqganancias_Z");
      gxTv_SdtConcepto_Contipoliqganancias_Z = value ;
   }

   public void setgxTv_SdtConcepto_Contipoliqganancias_Z_SetNull( )
   {
      gxTv_SdtConcepto_Contipoliqganancias_Z = "" ;
      SetDirty("Contipoliqganancias_Z");
   }

   public boolean getgxTv_SdtConcepto_Contipoliqganancias_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Convariable_Z( )
   {
      return gxTv_SdtConcepto_Convariable_Z ;
   }

   public void setgxTv_SdtConcepto_Convariable_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convariable_Z");
      gxTv_SdtConcepto_Convariable_Z = value ;
   }

   public void setgxTv_SdtConcepto_Convariable_Z_SetNull( )
   {
      gxTv_SdtConcepto_Convariable_Z = false ;
      SetDirty("Convariable_Z");
   }

   public boolean getgxTv_SdtConcepto_Convariable_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conusumodfor_Z( )
   {
      return gxTv_SdtConcepto_Conusumodfor_Z ;
   }

   public void setgxTv_SdtConcepto_Conusumodfor_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conusumodfor_Z");
      gxTv_SdtConcepto_Conusumodfor_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conusumodfor_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conusumodfor_Z = "" ;
      SetDirty("Conusumodfor_Z");
   }

   public boolean getgxTv_SdtConcepto_Conusumodfor_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtConcepto_Confchmodfor_Z( )
   {
      return gxTv_SdtConcepto_Confchmodfor_Z ;
   }

   public void setgxTv_SdtConcepto_Confchmodfor_Z( java.util.Date value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confchmodfor_Z");
      gxTv_SdtConcepto_Confchmodfor_Z = value ;
   }

   public void setgxTv_SdtConcepto_Confchmodfor_Z_SetNull( )
   {
      gxTv_SdtConcepto_Confchmodfor_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Confchmodfor_Z");
   }

   public boolean getgxTv_SdtConcepto_Confchmodfor_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conformulaabr_Z( )
   {
      return gxTv_SdtConcepto_Conformulaabr_Z ;
   }

   public void setgxTv_SdtConcepto_Conformulaabr_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformulaabr_Z");
      gxTv_SdtConcepto_Conformulaabr_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conformulaabr_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conformulaabr_Z = "" ;
      SetDirty("Conformulaabr_Z");
   }

   public boolean getgxTv_SdtConcepto_Conformulaabr_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concodydesc_Z( )
   {
      return gxTv_SdtConcepto_Concodydesc_Z ;
   }

   public void setgxTv_SdtConcepto_Concodydesc_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodydesc_Z");
      gxTv_SdtConcepto_Concodydesc_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concodydesc_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concodydesc_Z = "" ;
      SetDirty("Concodydesc_Z");
   }

   public boolean getgxTv_SdtConcepto_Concodydesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Tipoconcod_Z( )
   {
      return gxTv_SdtConcepto_Tipoconcod_Z ;
   }

   public void setgxTv_SdtConcepto_Tipoconcod_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Tipoconcod_Z");
      gxTv_SdtConcepto_Tipoconcod_Z = value ;
   }

   public void setgxTv_SdtConcepto_Tipoconcod_Z_SetNull( )
   {
      gxTv_SdtConcepto_Tipoconcod_Z = "" ;
      SetDirty("Tipoconcod_Z");
   }

   public boolean getgxTv_SdtConcepto_Tipoconcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Subtipoconcod1_Z( )
   {
      return gxTv_SdtConcepto_Subtipoconcod1_Z ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod1_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Subtipoconcod1_Z");
      gxTv_SdtConcepto_Subtipoconcod1_Z = value ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod1_Z_SetNull( )
   {
      gxTv_SdtConcepto_Subtipoconcod1_Z = "" ;
      SetDirty("Subtipoconcod1_Z");
   }

   public boolean getgxTv_SdtConcepto_Subtipoconcod1_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Subtipoconcod2_Z( )
   {
      return gxTv_SdtConcepto_Subtipoconcod2_Z ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod2_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Subtipoconcod2_Z");
      gxTv_SdtConcepto_Subtipoconcod2_Z = value ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod2_Z_SetNull( )
   {
      gxTv_SdtConcepto_Subtipoconcod2_Z = "" ;
      SetDirty("Subtipoconcod2_Z");
   }

   public boolean getgxTv_SdtConcepto_Subtipoconcod2_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Contipo_Z( )
   {
      return gxTv_SdtConcepto_Contipo_Z ;
   }

   public void setgxTv_SdtConcepto_Contipo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipo_Z");
      gxTv_SdtConcepto_Contipo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Contipo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Contipo_Z = (byte)(0) ;
      SetDirty("Contipo_Z");
   }

   public boolean getgxTv_SdtConcepto_Contipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concodold_Z( )
   {
      return gxTv_SdtConcepto_Concodold_Z ;
   }

   public void setgxTv_SdtConcepto_Concodold_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodold_Z");
      gxTv_SdtConcepto_Concodold_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concodold_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concodold_Z = "" ;
      SetDirty("Concodold_Z");
   }

   public boolean getgxTv_SdtConcepto_Concodold_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concuendebe_Z( )
   {
      return gxTv_SdtConcepto_Concuendebe_Z ;
   }

   public void setgxTv_SdtConcepto_Concuendebe_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concuendebe_Z");
      gxTv_SdtConcepto_Concuendebe_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concuendebe_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concuendebe_Z = "" ;
      SetDirty("Concuendebe_Z");
   }

   public boolean getgxTv_SdtConcepto_Concuendebe_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concuenhaber_Z( )
   {
      return gxTv_SdtConcepto_Concuenhaber_Z ;
   }

   public void setgxTv_SdtConcepto_Concuenhaber_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concuenhaber_Z");
      gxTv_SdtConcepto_Concuenhaber_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concuenhaber_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concuenhaber_Z = "" ;
      SetDirty("Concuenhaber_Z");
   }

   public boolean getgxTv_SdtConcepto_Concuenhaber_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Contipoliqaux_Z( )
   {
      return gxTv_SdtConcepto_Contipoliqaux_Z ;
   }

   public void setgxTv_SdtConcepto_Contipoliqaux_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoliqaux_Z");
      gxTv_SdtConcepto_Contipoliqaux_Z = value ;
   }

   public void setgxTv_SdtConcepto_Contipoliqaux_Z_SetNull( )
   {
      gxTv_SdtConcepto_Contipoliqaux_Z = "" ;
      SetDirty("Contipoliqaux_Z");
   }

   public boolean getgxTv_SdtConcepto_Contipoliqaux_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conconveaux_Z( )
   {
      return gxTv_SdtConcepto_Conconveaux_Z ;
   }

   public void setgxTv_SdtConcepto_Conconveaux_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conconveaux_Z");
      gxTv_SdtConcepto_Conconveaux_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conconveaux_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conconveaux_Z = "" ;
      SetDirty("Conconveaux_Z");
   }

   public boolean getgxTv_SdtConcepto_Conconveaux_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conclasifaux_Z( )
   {
      return gxTv_SdtConcepto_Conclasifaux_Z ;
   }

   public void setgxTv_SdtConcepto_Conclasifaux_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conclasifaux_Z");
      gxTv_SdtConcepto_Conclasifaux_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conclasifaux_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conclasifaux_Z = "" ;
      SetDirty("Conclasifaux_Z");
   }

   public boolean getgxTv_SdtConcepto_Conclasifaux_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtConcepto_Conordejec_Z( )
   {
      return gxTv_SdtConcepto_Conordejec_Z ;
   }

   public void setgxTv_SdtConcepto_Conordejec_Z( long value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conordejec_Z");
      gxTv_SdtConcepto_Conordejec_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conordejec_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conordejec_Z = 0 ;
      SetDirty("Conordejec_Z");
   }

   public boolean getgxTv_SdtConcepto_Conordejec_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conretganpropor_Z( )
   {
      return gxTv_SdtConcepto_Conretganpropor_Z ;
   }

   public void setgxTv_SdtConcepto_Conretganpropor_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conretganpropor_Z");
      gxTv_SdtConcepto_Conretganpropor_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conretganpropor_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conretganpropor_Z = false ;
      SetDirty("Conretganpropor_Z");
   }

   public boolean getgxTv_SdtConcepto_Conretganpropor_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conaplicgan_Z( )
   {
      return gxTv_SdtConcepto_Conaplicgan_Z ;
   }

   public void setgxTv_SdtConcepto_Conaplicgan_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conaplicgan_Z");
      gxTv_SdtConcepto_Conaplicgan_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conaplicgan_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conaplicgan_Z = (byte)(0) ;
      SetDirty("Conaplicgan_Z");
   }

   public boolean getgxTv_SdtConcepto_Conaplicgan_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conrecalcular_Z( )
   {
      return gxTv_SdtConcepto_Conrecalcular_Z ;
   }

   public void setgxTv_SdtConcepto_Conrecalcular_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrecalcular_Z");
      gxTv_SdtConcepto_Conrecalcular_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrecalcular_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrecalcular_Z = false ;
      SetDirty("Conrecalcular_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrecalcular_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conimportado_Z( )
   {
      return gxTv_SdtConcepto_Conimportado_Z ;
   }

   public void setgxTv_SdtConcepto_Conimportado_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conimportado_Z");
      gxTv_SdtConcepto_Conimportado_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conimportado_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conimportado_Z = false ;
      SetDirty("Conimportado_Z");
   }

   public boolean getgxTv_SdtConcepto_Conimportado_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_Contipoorden_Z( )
   {
      return gxTv_SdtConcepto_Contipoorden_Z ;
   }

   public void setgxTv_SdtConcepto_Contipoorden_Z( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoorden_Z");
      gxTv_SdtConcepto_Contipoorden_Z = value ;
   }

   public void setgxTv_SdtConcepto_Contipoorden_Z_SetNull( )
   {
      gxTv_SdtConcepto_Contipoorden_Z = (short)(0) ;
      SetDirty("Contipoorden_Z");
   }

   public boolean getgxTv_SdtConcepto_Contipoorden_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conedienrec_Z( )
   {
      return gxTv_SdtConcepto_Conedienrec_Z ;
   }

   public void setgxTv_SdtConcepto_Conedienrec_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conedienrec_Z");
      gxTv_SdtConcepto_Conedienrec_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conedienrec_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conedienrec_Z = false ;
      SetDirty("Conedienrec_Z");
   }

   public boolean getgxTv_SdtConcepto_Conedienrec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conrangocant_Z( )
   {
      return gxTv_SdtConcepto_Conrangocant_Z ;
   }

   public void setgxTv_SdtConcepto_Conrangocant_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrangocant_Z");
      gxTv_SdtConcepto_Conrangocant_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrangocant_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrangocant_Z = "" ;
      SetDirty("Conrangocant_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrangocant_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conusado_Z( )
   {
      return gxTv_SdtConcepto_Conusado_Z ;
   }

   public void setgxTv_SdtConcepto_Conusado_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conusado_Z");
      gxTv_SdtConcepto_Conusado_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conusado_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conusado_Z = false ;
      SetDirty("Conusado_Z");
   }

   public boolean getgxTv_SdtConcepto_Conusado_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conobliga_Z( )
   {
      return gxTv_SdtConcepto_Conobliga_Z ;
   }

   public void setgxTv_SdtConcepto_Conobliga_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobliga_Z");
      gxTv_SdtConcepto_Conobliga_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conobliga_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conobliga_Z = false ;
      SetDirty("Conobliga_Z");
   }

   public boolean getgxTv_SdtConcepto_Conobliga_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conobligasisac_Z( )
   {
      return gxTv_SdtConcepto_Conobligasisac_Z ;
   }

   public void setgxTv_SdtConcepto_Conobligasisac_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobligasisac_Z");
      gxTv_SdtConcepto_Conobligasisac_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conobligasisac_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conobligasisac_Z = false ;
      SetDirty("Conobligasisac_Z");
   }

   public boolean getgxTv_SdtConcepto_Conobligasisac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concondicion_Z( )
   {
      return gxTv_SdtConcepto_Concondicion_Z ;
   }

   public void setgxTv_SdtConcepto_Concondicion_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concondicion_Z");
      gxTv_SdtConcepto_Concondicion_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concondicion_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concondicion_Z = "" ;
      SetDirty("Concondicion_Z");
   }

   public boolean getgxTv_SdtConcepto_Concondicion_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concondcodigo_Z( )
   {
      return gxTv_SdtConcepto_Concondcodigo_Z ;
   }

   public void setgxTv_SdtConcepto_Concondcodigo_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concondcodigo_Z");
      gxTv_SdtConcepto_Concondcodigo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concondcodigo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concondcodigo_Z = "" ;
      SetDirty("Concondcodigo_Z");
   }

   public boolean getgxTv_SdtConcepto_Concondcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conprereq_Z( )
   {
      return gxTv_SdtConcepto_Conprereq_Z ;
   }

   public void setgxTv_SdtConcepto_Conprereq_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conprereq_Z");
      gxTv_SdtConcepto_Conprereq_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conprereq_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conprereq_Z = "" ;
      SetDirty("Conprereq_Z");
   }

   public boolean getgxTv_SdtConcepto_Conprereq_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conmostrarpos_Z( )
   {
      return gxTv_SdtConcepto_Conmostrarpos_Z ;
   }

   public void setgxTv_SdtConcepto_Conmostrarpos_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conmostrarpos_Z");
      gxTv_SdtConcepto_Conmostrarpos_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conmostrarpos_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conmostrarpos_Z = false ;
      SetDirty("Conmostrarpos_Z");
   }

   public boolean getgxTv_SdtConcepto_Conmostrarpos_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conadeldescu_Z( )
   {
      return gxTv_SdtConcepto_Conadeldescu_Z ;
   }

   public void setgxTv_SdtConcepto_Conadeldescu_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conadeldescu_Z");
      gxTv_SdtConcepto_Conadeldescu_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conadeldescu_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conadeldescu_Z = (byte)(0) ;
      SetDirty("Conadeldescu_Z");
   }

   public boolean getgxTv_SdtConcepto_Conadeldescu_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_Apliigg_Z( )
   {
      return gxTv_SdtConcepto_Apliigg_Z ;
   }

   public void setgxTv_SdtConcepto_Apliigg_Z( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Apliigg_Z");
      gxTv_SdtConcepto_Apliigg_Z = value ;
   }

   public void setgxTv_SdtConcepto_Apliigg_Z_SetNull( )
   {
      gxTv_SdtConcepto_Apliigg_Z = (short)(0) ;
      SetDirty("Apliigg_Z");
   }

   public boolean getgxTv_SdtConcepto_Apliigg_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Consegunpla_Z( )
   {
      return gxTv_SdtConcepto_Consegunpla_Z ;
   }

   public void setgxTv_SdtConcepto_Consegunpla_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consegunpla_Z");
      gxTv_SdtConcepto_Consegunpla_Z = value ;
   }

   public void setgxTv_SdtConcepto_Consegunpla_Z_SetNull( )
   {
      gxTv_SdtConcepto_Consegunpla_Z = false ;
      SetDirty("Consegunpla_Z");
   }

   public boolean getgxTv_SdtConcepto_Consegunpla_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Connumero_Z( )
   {
      return gxTv_SdtConcepto_Connumero_Z ;
   }

   public void setgxTv_SdtConcepto_Connumero_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Connumero_Z");
      gxTv_SdtConcepto_Connumero_Z = value ;
   }

   public void setgxTv_SdtConcepto_Connumero_Z_SetNull( )
   {
      gxTv_SdtConcepto_Connumero_Z = (byte)(0) ;
      SetDirty("Connumero_Z");
   }

   public boolean getgxTv_SdtConcepto_Connumero_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Consipaapo_Z( )
   {
      return gxTv_SdtConcepto_Consipaapo_Z ;
   }

   public void setgxTv_SdtConcepto_Consipaapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consipaapo_Z");
      gxTv_SdtConcepto_Consipaapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Consipaapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Consipaapo_Z = (byte)(0) ;
      SetDirty("Consipaapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Consipaapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Consipacont_Z( )
   {
      return gxTv_SdtConcepto_Consipacont_Z ;
   }

   public void setgxTv_SdtConcepto_Consipacont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consipacont_Z");
      gxTv_SdtConcepto_Consipacont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Consipacont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Consipacont_Z = (byte)(0) ;
      SetDirty("Consipacont_Z");
   }

   public boolean getgxTv_SdtConcepto_Consipacont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Coninssjypapo_Z( )
   {
      return gxTv_SdtConcepto_Coninssjypapo_Z ;
   }

   public void setgxTv_SdtConcepto_Coninssjypapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Coninssjypapo_Z");
      gxTv_SdtConcepto_Coninssjypapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Coninssjypapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Coninssjypapo_Z = (byte)(0) ;
      SetDirty("Coninssjypapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Coninssjypapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Coninssjypcont_Z( )
   {
      return gxTv_SdtConcepto_Coninssjypcont_Z ;
   }

   public void setgxTv_SdtConcepto_Coninssjypcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Coninssjypcont_Z");
      gxTv_SdtConcepto_Coninssjypcont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Coninssjypcont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Coninssjypcont_Z = (byte)(0) ;
      SetDirty("Coninssjypcont_Z");
   }

   public boolean getgxTv_SdtConcepto_Coninssjypcont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conobrasocapo_Z( )
   {
      return gxTv_SdtConcepto_Conobrasocapo_Z ;
   }

   public void setgxTv_SdtConcepto_Conobrasocapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobrasocapo_Z");
      gxTv_SdtConcepto_Conobrasocapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conobrasocapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conobrasocapo_Z = (byte)(0) ;
      SetDirty("Conobrasocapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Conobrasocapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conobrasoccont_Z( )
   {
      return gxTv_SdtConcepto_Conobrasoccont_Z ;
   }

   public void setgxTv_SdtConcepto_Conobrasoccont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobrasoccont_Z");
      gxTv_SdtConcepto_Conobrasoccont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conobrasoccont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conobrasoccont_Z = (byte)(0) ;
      SetDirty("Conobrasoccont_Z");
   }

   public boolean getgxTv_SdtConcepto_Conobrasoccont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Confonsolredapo_Z( )
   {
      return gxTv_SdtConcepto_Confonsolredapo_Z ;
   }

   public void setgxTv_SdtConcepto_Confonsolredapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confonsolredapo_Z");
      gxTv_SdtConcepto_Confonsolredapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Confonsolredapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Confonsolredapo_Z = (byte)(0) ;
      SetDirty("Confonsolredapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Confonsolredapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Confonsolredcont_Z( )
   {
      return gxTv_SdtConcepto_Confonsolredcont_Z ;
   }

   public void setgxTv_SdtConcepto_Confonsolredcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confonsolredcont_Z");
      gxTv_SdtConcepto_Confonsolredcont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Confonsolredcont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Confonsolredcont_Z = (byte)(0) ;
      SetDirty("Confonsolredcont_Z");
   }

   public boolean getgxTv_SdtConcepto_Confonsolredcont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conrenateaapo_Z( )
   {
      return gxTv_SdtConcepto_Conrenateaapo_Z ;
   }

   public void setgxTv_SdtConcepto_Conrenateaapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrenateaapo_Z");
      gxTv_SdtConcepto_Conrenateaapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrenateaapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrenateaapo_Z = (byte)(0) ;
      SetDirty("Conrenateaapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrenateaapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conrenateacont_Z( )
   {
      return gxTv_SdtConcepto_Conrenateacont_Z ;
   }

   public void setgxTv_SdtConcepto_Conrenateacont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrenateacont_Z");
      gxTv_SdtConcepto_Conrenateacont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrenateacont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrenateacont_Z = (byte)(0) ;
      SetDirty("Conrenateacont_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrenateacont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conasigfamcont_Z( )
   {
      return gxTv_SdtConcepto_Conasigfamcont_Z ;
   }

   public void setgxTv_SdtConcepto_Conasigfamcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conasigfamcont_Z");
      gxTv_SdtConcepto_Conasigfamcont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conasigfamcont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conasigfamcont_Z = (byte)(0) ;
      SetDirty("Conasigfamcont_Z");
   }

   public boolean getgxTv_SdtConcepto_Conasigfamcont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Confonnacempcont_Z( )
   {
      return gxTv_SdtConcepto_Confonnacempcont_Z ;
   }

   public void setgxTv_SdtConcepto_Confonnacempcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confonnacempcont_Z");
      gxTv_SdtConcepto_Confonnacempcont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Confonnacempcont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Confonnacempcont_Z = (byte)(0) ;
      SetDirty("Confonnacempcont_Z");
   }

   public boolean getgxTv_SdtConcepto_Confonnacempcont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conleyrietrabcont_Z( )
   {
      return gxTv_SdtConcepto_Conleyrietrabcont_Z ;
   }

   public void setgxTv_SdtConcepto_Conleyrietrabcont_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conleyrietrabcont_Z");
      gxTv_SdtConcepto_Conleyrietrabcont_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conleyrietrabcont_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conleyrietrabcont_Z = (byte)(0) ;
      SetDirty("Conleyrietrabcont_Z");
   }

   public boolean getgxTv_SdtConcepto_Conleyrietrabcont_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conregdifapo_Z( )
   {
      return gxTv_SdtConcepto_Conregdifapo_Z ;
   }

   public void setgxTv_SdtConcepto_Conregdifapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conregdifapo_Z");
      gxTv_SdtConcepto_Conregdifapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conregdifapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conregdifapo_Z = (byte)(0) ;
      SetDirty("Conregdifapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Conregdifapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conregespapo_Z( )
   {
      return gxTv_SdtConcepto_Conregespapo_Z ;
   }

   public void setgxTv_SdtConcepto_Conregespapo_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conregespapo_Z");
      gxTv_SdtConcepto_Conregespapo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conregespapo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conregespapo_Z = (byte)(0) ;
      SetDirty("Conregespapo_Z");
   }

   public boolean getgxTv_SdtConcepto_Conregespapo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Consacdeven_Z( )
   {
      return gxTv_SdtConcepto_Consacdeven_Z ;
   }

   public void setgxTv_SdtConcepto_Consacdeven_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Consacdeven_Z");
      gxTv_SdtConcepto_Consacdeven_Z = value ;
   }

   public void setgxTv_SdtConcepto_Consacdeven_Z_SetNull( )
   {
      gxTv_SdtConcepto_Consacdeven_Z = (byte)(0) ;
      SetDirty("Consacdeven_Z");
   }

   public boolean getgxTv_SdtConcepto_Consacdeven_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaselic_Z( )
   {
      return gxTv_SdtConcepto_Conbaselic_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaselic_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaselic_Z");
      gxTv_SdtConcepto_Conbaselic_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaselic_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaselic_Z = (byte)(0) ;
      SetDirty("Conbaselic_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaselic_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaselicprom_Z( )
   {
      return gxTv_SdtConcepto_Conbaselicprom_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaselicprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaselicprom_Z");
      gxTv_SdtConcepto_Conbaselicprom_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaselicprom_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaselicprom_Z = (byte)(0) ;
      SetDirty("Conbaselicprom_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaselicprom_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbasefer_Z( )
   {
      return gxTv_SdtConcepto_Conbasefer_Z ;
   }

   public void setgxTv_SdtConcepto_Conbasefer_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasefer_Z");
      gxTv_SdtConcepto_Conbasefer_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbasefer_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbasefer_Z = (byte)(0) ;
      SetDirty("Conbasefer_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbasefer_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaseferprom_Z( )
   {
      return gxTv_SdtConcepto_Conbaseferprom_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaseferprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseferprom_Z");
      gxTv_SdtConcepto_Conbaseferprom_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaseferprom_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaseferprom_Z = (byte)(0) ;
      SetDirty("Conbaseferprom_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaseferprom_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbasehorext_Z( )
   {
      return gxTv_SdtConcepto_Conbasehorext_Z ;
   }

   public void setgxTv_SdtConcepto_Conbasehorext_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasehorext_Z");
      gxTv_SdtConcepto_Conbasehorext_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbasehorext_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbasehorext_Z = (byte)(0) ;
      SetDirty("Conbasehorext_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbasehorext_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbasehorextprom_Z( )
   {
      return gxTv_SdtConcepto_Conbasehorextprom_Z ;
   }

   public void setgxTv_SdtConcepto_Conbasehorextprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasehorextprom_Z");
      gxTv_SdtConcepto_Conbasehorextprom_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbasehorextprom_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbasehorextprom_Z = (byte)(0) ;
      SetDirty("Conbasehorextprom_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbasehorextprom_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbasepres_Z( )
   {
      return gxTv_SdtConcepto_Conbasepres_Z ;
   }

   public void setgxTv_SdtConcepto_Conbasepres_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbasepres_Z");
      gxTv_SdtConcepto_Conbasepres_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbasepres_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbasepres_Z = (byte)(0) ;
      SetDirty("Conbasepres_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbasepres_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaseant_Z( )
   {
      return gxTv_SdtConcepto_Conbaseant_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaseant_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseant_Z");
      gxTv_SdtConcepto_Conbaseant_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaseant_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaseant_Z = (byte)(0) ;
      SetDirty("Conbaseant_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaseant_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaseosdif_Z( )
   {
      return gxTv_SdtConcepto_Conbaseosdif_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaseosdif_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseosdif_Z");
      gxTv_SdtConcepto_Conbaseosdif_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaseosdif_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaseosdif_Z = (byte)(0) ;
      SetDirty("Conbaseosdif_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaseosdif_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaseaus_Z( )
   {
      return gxTv_SdtConcepto_Conbaseaus_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaseaus_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseaus_Z");
      gxTv_SdtConcepto_Conbaseaus_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaseaus_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaseaus_Z = (byte)(0) ;
      SetDirty("Conbaseaus_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaseaus_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conbaseausprom_Z( )
   {
      return gxTv_SdtConcepto_Conbaseausprom_Z ;
   }

   public void setgxTv_SdtConcepto_Conbaseausprom_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conbaseausprom_Z");
      gxTv_SdtConcepto_Conbaseausprom_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conbaseausprom_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conbaseausprom_Z = (byte)(0) ;
      SetDirty("Conbaseausprom_Z");
   }

   public boolean getgxTv_SdtConcepto_Conbaseausprom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_Conceptopais_Z( )
   {
      return gxTv_SdtConcepto_Conceptopais_Z ;
   }

   public void setgxTv_SdtConcepto_Conceptopais_Z( short value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conceptopais_Z");
      gxTv_SdtConcepto_Conceptopais_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conceptopais_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conceptopais_Z = (short)(0) ;
      SetDirty("Conceptopais_Z");
   }

   public boolean getgxTv_SdtConcepto_Conceptopais_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conceptoconvecodigo_Z( )
   {
      return gxTv_SdtConcepto_Conceptoconvecodigo_Z ;
   }

   public void setgxTv_SdtConcepto_Conceptoconvecodigo_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conceptoconvecodigo_Z");
      gxTv_SdtConcepto_Conceptoconvecodigo_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conceptoconvecodigo_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conceptoconvecodigo_Z = "" ;
      SetDirty("Conceptoconvecodigo_Z");
   }

   public boolean getgxTv_SdtConcepto_Conceptoconvecodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Concodafip_Z( )
   {
      return gxTv_SdtConcepto_Concodafip_Z ;
   }

   public void setgxTv_SdtConcepto_Concodafip_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodafip_Z");
      gxTv_SdtConcepto_Concodafip_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concodafip_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concodafip_Z = "" ;
      SetDirty("Concodafip_Z");
   }

   public boolean getgxTv_SdtConcepto_Concodafip_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Concntpa_Z( )
   {
      return gxTv_SdtConcepto_Concntpa_Z ;
   }

   public void setgxTv_SdtConcepto_Concntpa_Z( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concntpa_Z");
      gxTv_SdtConcepto_Concntpa_Z = value ;
   }

   public void setgxTv_SdtConcepto_Concntpa_Z_SetNull( )
   {
      gxTv_SdtConcepto_Concntpa_Z = (byte)(0) ;
      SetDirty("Concntpa_Z");
   }

   public boolean getgxTv_SdtConcepto_Concntpa_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conerrorsicero_Z( )
   {
      return gxTv_SdtConcepto_Conerrorsicero_Z ;
   }

   public void setgxTv_SdtConcepto_Conerrorsicero_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conerrorsicero_Z");
      gxTv_SdtConcepto_Conerrorsicero_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conerrorsicero_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conerrorsicero_Z = false ;
      SetDirty("Conerrorsicero_Z");
   }

   public boolean getgxTv_SdtConcepto_Conerrorsicero_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConcepto_Clipadre_Z( )
   {
      return gxTv_SdtConcepto_Clipadre_Z ;
   }

   public void setgxTv_SdtConcepto_Clipadre_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Clipadre_Z");
      gxTv_SdtConcepto_Clipadre_Z = value ;
   }

   public void setgxTv_SdtConcepto_Clipadre_Z_SetNull( )
   {
      gxTv_SdtConcepto_Clipadre_Z = 0 ;
      SetDirty("Clipadre_Z");
   }

   public boolean getgxTv_SdtConcepto_Clipadre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conpadre_Z( )
   {
      return gxTv_SdtConcepto_Conpadre_Z ;
   }

   public void setgxTv_SdtConcepto_Conpadre_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conpadre_Z");
      gxTv_SdtConcepto_Conpadre_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conpadre_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conpadre_Z = "" ;
      SetDirty("Conpadre_Z");
   }

   public boolean getgxTv_SdtConcepto_Conpadre_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_Conpuenov_Z( )
   {
      return gxTv_SdtConcepto_Conpuenov_Z ;
   }

   public void setgxTv_SdtConcepto_Conpuenov_Z( boolean value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conpuenov_Z");
      gxTv_SdtConcepto_Conpuenov_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conpuenov_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conpuenov_Z = false ;
      SetDirty("Conpuenov_Z");
   }

   public boolean getgxTv_SdtConcepto_Conpuenov_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConcepto_Conrelsec_Z( )
   {
      return gxTv_SdtConcepto_Conrelsec_Z ;
   }

   public void setgxTv_SdtConcepto_Conrelsec_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrelsec_Z");
      gxTv_SdtConcepto_Conrelsec_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrelsec_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrelsec_Z = 0 ;
      SetDirty("Conrelsec_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrelsec_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtConcepto_Conrelseccli_Z( )
   {
      return gxTv_SdtConcepto_Conrelseccli_Z ;
   }

   public void setgxTv_SdtConcepto_Conrelseccli_Z( int value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrelseccli_Z");
      gxTv_SdtConcepto_Conrelseccli_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrelseccli_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrelseccli_Z = 0 ;
      SetDirty("Conrelseccli_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrelseccli_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conrelref_Z( )
   {
      return gxTv_SdtConcepto_Conrelref_Z ;
   }

   public void setgxTv_SdtConcepto_Conrelref_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conrelref_Z");
      gxTv_SdtConcepto_Conrelref_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conrelref_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conrelref_Z = "" ;
      SetDirty("Conrelref_Z");
   }

   public boolean getgxTv_SdtConcepto_Conrelref_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Condescripsinac_Z( )
   {
      return gxTv_SdtConcepto_Condescripsinac_Z ;
   }

   public void setgxTv_SdtConcepto_Condescripsinac_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Condescripsinac_Z");
      gxTv_SdtConcepto_Condescripsinac_Z = value ;
   }

   public void setgxTv_SdtConcepto_Condescripsinac_Z_SetNull( )
   {
      gxTv_SdtConcepto_Condescripsinac_Z = "" ;
      SetDirty("Condescripsinac_Z");
   }

   public boolean getgxTv_SdtConcepto_Condescripsinac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_Conoblpalabra_Z( )
   {
      return gxTv_SdtConcepto_Conoblpalabra_Z ;
   }

   public void setgxTv_SdtConcepto_Conoblpalabra_Z( String value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conoblpalabra_Z");
      gxTv_SdtConcepto_Conoblpalabra_Z = value ;
   }

   public void setgxTv_SdtConcepto_Conoblpalabra_Z_SetNull( )
   {
      gxTv_SdtConcepto_Conoblpalabra_Z = "" ;
      SetDirty("Conoblpalabra_Z");
   }

   public boolean getgxTv_SdtConcepto_Conoblpalabra_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conformula_N( )
   {
      return gxTv_SdtConcepto_Conformula_N ;
   }

   public void setgxTv_SdtConcepto_Conformula_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conformula_N");
      gxTv_SdtConcepto_Conformula_N = value ;
   }

   public void setgxTv_SdtConcepto_Conformula_N_SetNull( )
   {
      gxTv_SdtConcepto_Conformula_N = (byte)(0) ;
      SetDirty("Conformula_N");
   }

   public boolean getgxTv_SdtConcepto_Conformula_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Convalorgen_N( )
   {
      return gxTv_SdtConcepto_Convalorgen_N ;
   }

   public void setgxTv_SdtConcepto_Convalorgen_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Convalorgen_N");
      gxTv_SdtConcepto_Convalorgen_N = value ;
   }

   public void setgxTv_SdtConcepto_Convalorgen_N_SetNull( )
   {
      gxTv_SdtConcepto_Convalorgen_N = (byte)(0) ;
      SetDirty("Convalorgen_N");
   }

   public boolean getgxTv_SdtConcepto_Convalorgen_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Contipoliqganancias_N( )
   {
      return gxTv_SdtConcepto_Contipoliqganancias_N ;
   }

   public void setgxTv_SdtConcepto_Contipoliqganancias_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoliqganancias_N");
      gxTv_SdtConcepto_Contipoliqganancias_N = value ;
   }

   public void setgxTv_SdtConcepto_Contipoliqganancias_N_SetNull( )
   {
      gxTv_SdtConcepto_Contipoliqganancias_N = (byte)(0) ;
      SetDirty("Contipoliqganancias_N");
   }

   public boolean getgxTv_SdtConcepto_Contipoliqganancias_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conhisformula_N( )
   {
      return gxTv_SdtConcepto_Conhisformula_N ;
   }

   public void setgxTv_SdtConcepto_Conhisformula_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conhisformula_N");
      gxTv_SdtConcepto_Conhisformula_N = value ;
   }

   public void setgxTv_SdtConcepto_Conhisformula_N_SetNull( )
   {
      gxTv_SdtConcepto_Conhisformula_N = (byte)(0) ;
      SetDirty("Conhisformula_N");
   }

   public boolean getgxTv_SdtConcepto_Conhisformula_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conusumodfor_N( )
   {
      return gxTv_SdtConcepto_Conusumodfor_N ;
   }

   public void setgxTv_SdtConcepto_Conusumodfor_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conusumodfor_N");
      gxTv_SdtConcepto_Conusumodfor_N = value ;
   }

   public void setgxTv_SdtConcepto_Conusumodfor_N_SetNull( )
   {
      gxTv_SdtConcepto_Conusumodfor_N = (byte)(0) ;
      SetDirty("Conusumodfor_N");
   }

   public boolean getgxTv_SdtConcepto_Conusumodfor_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Confchmodfor_N( )
   {
      return gxTv_SdtConcepto_Confchmodfor_N ;
   }

   public void setgxTv_SdtConcepto_Confchmodfor_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Confchmodfor_N");
      gxTv_SdtConcepto_Confchmodfor_N = value ;
   }

   public void setgxTv_SdtConcepto_Confchmodfor_N_SetNull( )
   {
      gxTv_SdtConcepto_Confchmodfor_N = (byte)(0) ;
      SetDirty("Confchmodfor_N");
   }

   public boolean getgxTv_SdtConcepto_Confchmodfor_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Concodydesc_N( )
   {
      return gxTv_SdtConcepto_Concodydesc_N ;
   }

   public void setgxTv_SdtConcepto_Concodydesc_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concodydesc_N");
      gxTv_SdtConcepto_Concodydesc_N = value ;
   }

   public void setgxTv_SdtConcepto_Concodydesc_N_SetNull( )
   {
      gxTv_SdtConcepto_Concodydesc_N = (byte)(0) ;
      SetDirty("Concodydesc_N");
   }

   public boolean getgxTv_SdtConcepto_Concodydesc_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Subtipoconcod1_N( )
   {
      return gxTv_SdtConcepto_Subtipoconcod1_N ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod1_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Subtipoconcod1_N");
      gxTv_SdtConcepto_Subtipoconcod1_N = value ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod1_N_SetNull( )
   {
      gxTv_SdtConcepto_Subtipoconcod1_N = (byte)(0) ;
      SetDirty("Subtipoconcod1_N");
   }

   public boolean getgxTv_SdtConcepto_Subtipoconcod1_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Subtipoconcod2_N( )
   {
      return gxTv_SdtConcepto_Subtipoconcod2_N ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod2_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Subtipoconcod2_N");
      gxTv_SdtConcepto_Subtipoconcod2_N = value ;
   }

   public void setgxTv_SdtConcepto_Subtipoconcod2_N_SetNull( )
   {
      gxTv_SdtConcepto_Subtipoconcod2_N = (byte)(0) ;
      SetDirty("Subtipoconcod2_N");
   }

   public boolean getgxTv_SdtConcepto_Subtipoconcod2_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Concuendebe_N( )
   {
      return gxTv_SdtConcepto_Concuendebe_N ;
   }

   public void setgxTv_SdtConcepto_Concuendebe_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concuendebe_N");
      gxTv_SdtConcepto_Concuendebe_N = value ;
   }

   public void setgxTv_SdtConcepto_Concuendebe_N_SetNull( )
   {
      gxTv_SdtConcepto_Concuendebe_N = (byte)(0) ;
      SetDirty("Concuendebe_N");
   }

   public boolean getgxTv_SdtConcepto_Concuendebe_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Concuenhaber_N( )
   {
      return gxTv_SdtConcepto_Concuenhaber_N ;
   }

   public void setgxTv_SdtConcepto_Concuenhaber_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concuenhaber_N");
      gxTv_SdtConcepto_Concuenhaber_N = value ;
   }

   public void setgxTv_SdtConcepto_Concuenhaber_N_SetNull( )
   {
      gxTv_SdtConcepto_Concuenhaber_N = (byte)(0) ;
      SetDirty("Concuenhaber_N");
   }

   public boolean getgxTv_SdtConcepto_Concuenhaber_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Contipoliqaux_N( )
   {
      return gxTv_SdtConcepto_Contipoliqaux_N ;
   }

   public void setgxTv_SdtConcepto_Contipoliqaux_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Contipoliqaux_N");
      gxTv_SdtConcepto_Contipoliqaux_N = value ;
   }

   public void setgxTv_SdtConcepto_Contipoliqaux_N_SetNull( )
   {
      gxTv_SdtConcepto_Contipoliqaux_N = (byte)(0) ;
      SetDirty("Contipoliqaux_N");
   }

   public boolean getgxTv_SdtConcepto_Contipoliqaux_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conconveaux_N( )
   {
      return gxTv_SdtConcepto_Conconveaux_N ;
   }

   public void setgxTv_SdtConcepto_Conconveaux_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conconveaux_N");
      gxTv_SdtConcepto_Conconveaux_N = value ;
   }

   public void setgxTv_SdtConcepto_Conconveaux_N_SetNull( )
   {
      gxTv_SdtConcepto_Conconveaux_N = (byte)(0) ;
      SetDirty("Conconveaux_N");
   }

   public boolean getgxTv_SdtConcepto_Conconveaux_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conclasifaux_N( )
   {
      return gxTv_SdtConcepto_Conclasifaux_N ;
   }

   public void setgxTv_SdtConcepto_Conclasifaux_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conclasifaux_N");
      gxTv_SdtConcepto_Conclasifaux_N = value ;
   }

   public void setgxTv_SdtConcepto_Conclasifaux_N_SetNull( )
   {
      gxTv_SdtConcepto_Conclasifaux_N = (byte)(0) ;
      SetDirty("Conclasifaux_N");
   }

   public boolean getgxTv_SdtConcepto_Conclasifaux_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conaplicgan_N( )
   {
      return gxTv_SdtConcepto_Conaplicgan_N ;
   }

   public void setgxTv_SdtConcepto_Conaplicgan_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conaplicgan_N");
      gxTv_SdtConcepto_Conaplicgan_N = value ;
   }

   public void setgxTv_SdtConcepto_Conaplicgan_N_SetNull( )
   {
      gxTv_SdtConcepto_Conaplicgan_N = (byte)(0) ;
      SetDirty("Conaplicgan_N");
   }

   public boolean getgxTv_SdtConcepto_Conaplicgan_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conobliga_N( )
   {
      return gxTv_SdtConcepto_Conobliga_N ;
   }

   public void setgxTv_SdtConcepto_Conobliga_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobliga_N");
      gxTv_SdtConcepto_Conobliga_N = value ;
   }

   public void setgxTv_SdtConcepto_Conobliga_N_SetNull( )
   {
      gxTv_SdtConcepto_Conobliga_N = (byte)(0) ;
      SetDirty("Conobliga_N");
   }

   public boolean getgxTv_SdtConcepto_Conobliga_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conobligasisac_N( )
   {
      return gxTv_SdtConcepto_Conobligasisac_N ;
   }

   public void setgxTv_SdtConcepto_Conobligasisac_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conobligasisac_N");
      gxTv_SdtConcepto_Conobligasisac_N = value ;
   }

   public void setgxTv_SdtConcepto_Conobligasisac_N_SetNull( )
   {
      gxTv_SdtConcepto_Conobligasisac_N = (byte)(0) ;
      SetDirty("Conobligasisac_N");
   }

   public boolean getgxTv_SdtConcepto_Conobligasisac_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Concondicion_N( )
   {
      return gxTv_SdtConcepto_Concondicion_N ;
   }

   public void setgxTv_SdtConcepto_Concondicion_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Concondicion_N");
      gxTv_SdtConcepto_Concondicion_N = value ;
   }

   public void setgxTv_SdtConcepto_Concondicion_N_SetNull( )
   {
      gxTv_SdtConcepto_Concondicion_N = (byte)(0) ;
      SetDirty("Concondicion_N");
   }

   public boolean getgxTv_SdtConcepto_Concondicion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conprereq_N( )
   {
      return gxTv_SdtConcepto_Conprereq_N ;
   }

   public void setgxTv_SdtConcepto_Conprereq_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conprereq_N");
      gxTv_SdtConcepto_Conprereq_N = value ;
   }

   public void setgxTv_SdtConcepto_Conprereq_N_SetNull( )
   {
      gxTv_SdtConcepto_Conprereq_N = (byte)(0) ;
      SetDirty("Conprereq_N");
   }

   public boolean getgxTv_SdtConcepto_Conprereq_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conadeldescu_N( )
   {
      return gxTv_SdtConcepto_Conadeldescu_N ;
   }

   public void setgxTv_SdtConcepto_Conadeldescu_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conadeldescu_N");
      gxTv_SdtConcepto_Conadeldescu_N = value ;
   }

   public void setgxTv_SdtConcepto_Conadeldescu_N_SetNull( )
   {
      gxTv_SdtConcepto_Conadeldescu_N = (byte)(0) ;
      SetDirty("Conadeldescu_N");
   }

   public boolean getgxTv_SdtConcepto_Conadeldescu_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Apliigg_N( )
   {
      return gxTv_SdtConcepto_Apliigg_N ;
   }

   public void setgxTv_SdtConcepto_Apliigg_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Apliigg_N");
      gxTv_SdtConcepto_Apliigg_N = value ;
   }

   public void setgxTv_SdtConcepto_Apliigg_N_SetNull( )
   {
      gxTv_SdtConcepto_Apliigg_N = (byte)(0) ;
      SetDirty("Apliigg_N");
   }

   public boolean getgxTv_SdtConcepto_Apliigg_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conceptopais_N( )
   {
      return gxTv_SdtConcepto_Conceptopais_N ;
   }

   public void setgxTv_SdtConcepto_Conceptopais_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conceptopais_N");
      gxTv_SdtConcepto_Conceptopais_N = value ;
   }

   public void setgxTv_SdtConcepto_Conceptopais_N_SetNull( )
   {
      gxTv_SdtConcepto_Conceptopais_N = (byte)(0) ;
      SetDirty("Conceptopais_N");
   }

   public boolean getgxTv_SdtConcepto_Conceptopais_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conceptoconvecodigo_N( )
   {
      return gxTv_SdtConcepto_Conceptoconvecodigo_N ;
   }

   public void setgxTv_SdtConcepto_Conceptoconvecodigo_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conceptoconvecodigo_N");
      gxTv_SdtConcepto_Conceptoconvecodigo_N = value ;
   }

   public void setgxTv_SdtConcepto_Conceptoconvecodigo_N_SetNull( )
   {
      gxTv_SdtConcepto_Conceptoconvecodigo_N = (byte)(0) ;
      SetDirty("Conceptoconvecodigo_N");
   }

   public boolean getgxTv_SdtConcepto_Conceptoconvecodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Clipadre_N( )
   {
      return gxTv_SdtConcepto_Clipadre_N ;
   }

   public void setgxTv_SdtConcepto_Clipadre_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Clipadre_N");
      gxTv_SdtConcepto_Clipadre_N = value ;
   }

   public void setgxTv_SdtConcepto_Clipadre_N_SetNull( )
   {
      gxTv_SdtConcepto_Clipadre_N = (byte)(0) ;
      SetDirty("Clipadre_N");
   }

   public boolean getgxTv_SdtConcepto_Clipadre_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conpadre_N( )
   {
      return gxTv_SdtConcepto_Conpadre_N ;
   }

   public void setgxTv_SdtConcepto_Conpadre_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conpadre_N");
      gxTv_SdtConcepto_Conpadre_N = value ;
   }

   public void setgxTv_SdtConcepto_Conpadre_N_SetNull( )
   {
      gxTv_SdtConcepto_Conpadre_N = (byte)(0) ;
      SetDirty("Conpadre_N");
   }

   public boolean getgxTv_SdtConcepto_Conpadre_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_Conoblpalabra_N( )
   {
      return gxTv_SdtConcepto_Conoblpalabra_N ;
   }

   public void setgxTv_SdtConcepto_Conoblpalabra_N( byte value )
   {
      gxTv_SdtConcepto_N = (byte)(0) ;
      SetDirty("Conoblpalabra_N");
      gxTv_SdtConcepto_Conoblpalabra_N = value ;
   }

   public void setgxTv_SdtConcepto_Conoblpalabra_N_SetNull( )
   {
      gxTv_SdtConcepto_Conoblpalabra_N = (byte)(0) ;
      SetDirty("Conoblpalabra_N");
   }

   public boolean getgxTv_SdtConcepto_Conoblpalabra_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.concepto_bc obj;
      obj = new web.concepto_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtConcepto_N = (byte)(1) ;
      gxTv_SdtConcepto_Concodigo = "" ;
      gxTv_SdtConcepto_Condescrip = "" ;
      gxTv_SdtConcepto_Conformula = "" ;
      gxTv_SdtConcepto_Conformulapreresuelta = "" ;
      gxTv_SdtConcepto_Convalorgen = DecimalUtil.ZERO ;
      gxTv_SdtConcepto_Contipoliqganancias = "" ;
      gxTv_SdtConcepto_Conobservacion = "" ;
      gxTv_SdtConcepto_Conhisformula = "" ;
      gxTv_SdtConcepto_Conusumodfor = "" ;
      gxTv_SdtConcepto_Confchmodfor = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtConcepto_Conformulaabr = "" ;
      gxTv_SdtConcepto_Concodydesc = "" ;
      gxTv_SdtConcepto_Tipoconcod = "" ;
      gxTv_SdtConcepto_Subtipoconcod1 = "" ;
      gxTv_SdtConcepto_Subtipoconcod2 = "" ;
      gxTv_SdtConcepto_Concodold = "" ;
      gxTv_SdtConcepto_Concuendebe = "" ;
      gxTv_SdtConcepto_Concuenhaber = "" ;
      gxTv_SdtConcepto_Contipoliqaux = "" ;
      gxTv_SdtConcepto_Conconveaux = "" ;
      gxTv_SdtConcepto_Conclasifaux = "" ;
      gxTv_SdtConcepto_Conformulaexpl = "" ;
      gxTv_SdtConcepto_Conformulaobs2 = "" ;
      gxTv_SdtConcepto_Conrangocant = "" ;
      gxTv_SdtConcepto_Concondicion = "" ;
      gxTv_SdtConcepto_Concondcodigo = "" ;
      gxTv_SdtConcepto_Conprereq = "" ;
      gxTv_SdtConcepto_Conceptoconvecodigo = "" ;
      gxTv_SdtConcepto_Concodafip = "" ;
      gxTv_SdtConcepto_Conpadre = "" ;
      gxTv_SdtConcepto_Conoldvalues = "" ;
      gxTv_SdtConcepto_Conrelref = "" ;
      gxTv_SdtConcepto_Condescripsinac = "" ;
      gxTv_SdtConcepto_Conoblpalabra = "" ;
      gxTv_SdtConcepto_Mode = "" ;
      gxTv_SdtConcepto_Concodigo_Z = "" ;
      gxTv_SdtConcepto_Condescrip_Z = "" ;
      gxTv_SdtConcepto_Convalorgen_Z = DecimalUtil.ZERO ;
      gxTv_SdtConcepto_Contipoliqganancias_Z = "" ;
      gxTv_SdtConcepto_Conusumodfor_Z = "" ;
      gxTv_SdtConcepto_Confchmodfor_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtConcepto_Conformulaabr_Z = "" ;
      gxTv_SdtConcepto_Concodydesc_Z = "" ;
      gxTv_SdtConcepto_Tipoconcod_Z = "" ;
      gxTv_SdtConcepto_Subtipoconcod1_Z = "" ;
      gxTv_SdtConcepto_Subtipoconcod2_Z = "" ;
      gxTv_SdtConcepto_Concodold_Z = "" ;
      gxTv_SdtConcepto_Concuendebe_Z = "" ;
      gxTv_SdtConcepto_Concuenhaber_Z = "" ;
      gxTv_SdtConcepto_Contipoliqaux_Z = "" ;
      gxTv_SdtConcepto_Conconveaux_Z = "" ;
      gxTv_SdtConcepto_Conclasifaux_Z = "" ;
      gxTv_SdtConcepto_Conrangocant_Z = "" ;
      gxTv_SdtConcepto_Concondicion_Z = "" ;
      gxTv_SdtConcepto_Concondcodigo_Z = "" ;
      gxTv_SdtConcepto_Conprereq_Z = "" ;
      gxTv_SdtConcepto_Conceptoconvecodigo_Z = "" ;
      gxTv_SdtConcepto_Concodafip_Z = "" ;
      gxTv_SdtConcepto_Conpadre_Z = "" ;
      gxTv_SdtConcepto_Conrelref_Z = "" ;
      gxTv_SdtConcepto_Condescripsinac_Z = "" ;
      gxTv_SdtConcepto_Conoblpalabra_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtConcepto_N ;
   }

   public web.SdtConcepto Clone( )
   {
      web.SdtConcepto sdt;
      web.concepto_bc obj;
      sdt = (web.SdtConcepto)(clone()) ;
      obj = (web.concepto_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtConcepto struct )
   {
      setgxTv_SdtConcepto_Clicod(struct.getClicod());
      setgxTv_SdtConcepto_Concodigo(struct.getConcodigo());
      setgxTv_SdtConcepto_Condescrip(struct.getCondescrip());
      setgxTv_SdtConcepto_Conhabilitado(struct.getConhabilitado());
      setgxTv_SdtConcepto_Conorden(struct.getConorden());
      setgxTv_SdtConcepto_Concanti(struct.getConcanti());
      setgxTv_SdtConcepto_Convaluni(struct.getConvaluni());
      setgxTv_SdtConcepto_Conimporte(struct.getConimporte());
      setgxTv_SdtConcepto_Convigencia(struct.getConvigencia());
      setgxTv_SdtConcepto_Conliqbasica(struct.getConliqbasica());
      setgxTv_SdtConcepto_Conformula(struct.getConformula());
      setgxTv_SdtConcepto_Conformulapreresuelta(struct.getConformulapreresuelta());
      setgxTv_SdtConcepto_Convalorgen(struct.getConvalorgen());
      setgxTv_SdtConcepto_Contipoliqganancias(struct.getContipoliqganancias());
      setgxTv_SdtConcepto_Conobservacion(struct.getConobservacion());
      setgxTv_SdtConcepto_Convariable(struct.getConvariable());
      setgxTv_SdtConcepto_Conhisformula(struct.getConhisformula());
      setgxTv_SdtConcepto_Conusumodfor(struct.getConusumodfor());
      setgxTv_SdtConcepto_Confchmodfor(struct.getConfchmodfor());
      setgxTv_SdtConcepto_Conformulaabr(struct.getConformulaabr());
      setgxTv_SdtConcepto_Concodydesc(struct.getConcodydesc());
      setgxTv_SdtConcepto_Tipoconcod(struct.getTipoconcod());
      setgxTv_SdtConcepto_Subtipoconcod1(struct.getSubtipoconcod1());
      setgxTv_SdtConcepto_Subtipoconcod2(struct.getSubtipoconcod2());
      setgxTv_SdtConcepto_Contipo(struct.getContipo());
      setgxTv_SdtConcepto_Concodold(struct.getConcodold());
      setgxTv_SdtConcepto_Concuendebe(struct.getConcuendebe());
      setgxTv_SdtConcepto_Concuenhaber(struct.getConcuenhaber());
      setgxTv_SdtConcepto_Contipoliqaux(struct.getContipoliqaux());
      setgxTv_SdtConcepto_Conconveaux(struct.getConconveaux());
      setgxTv_SdtConcepto_Conclasifaux(struct.getConclasifaux());
      setgxTv_SdtConcepto_Conordejec(struct.getConordejec());
      setgxTv_SdtConcepto_Conformulaexpl(struct.getConformulaexpl());
      setgxTv_SdtConcepto_Conformulaobs2(struct.getConformulaobs2());
      setgxTv_SdtConcepto_Conretganpropor(struct.getConretganpropor());
      setgxTv_SdtConcepto_Conaplicgan(struct.getConaplicgan());
      setgxTv_SdtConcepto_Conrecalcular(struct.getConrecalcular());
      setgxTv_SdtConcepto_Conimportado(struct.getConimportado());
      setgxTv_SdtConcepto_Contipoorden(struct.getContipoorden());
      setgxTv_SdtConcepto_Conedienrec(struct.getConedienrec());
      setgxTv_SdtConcepto_Conrangocant(struct.getConrangocant());
      GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> gxTv_SdtConcepto_Tipoliquidacion_aux = new GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion>(web.SdtConcepto_TipoLiquidacion.class, "Concepto.TipoLiquidacion", "PayDay", remoteHandle);
      Vector<web.StructSdtConcepto_TipoLiquidacion> gxTv_SdtConcepto_Tipoliquidacion_aux1 = struct.getTipoliquidacion();
      if (gxTv_SdtConcepto_Tipoliquidacion_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtConcepto_Tipoliquidacion_aux1.size(); i++)
         {
            gxTv_SdtConcepto_Tipoliquidacion_aux.add(new web.SdtConcepto_TipoLiquidacion(remoteHandle, gxTv_SdtConcepto_Tipoliquidacion_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtConcepto_Tipoliquidacion(gxTv_SdtConcepto_Tipoliquidacion_aux);
      setgxTv_SdtConcepto_Conusado(struct.getConusado());
      setgxTv_SdtConcepto_Conobliga(struct.getConobliga());
      setgxTv_SdtConcepto_Conobligasisac(struct.getConobligasisac());
      setgxTv_SdtConcepto_Concondicion(struct.getConcondicion());
      setgxTv_SdtConcepto_Concondcodigo(struct.getConcondcodigo());
      setgxTv_SdtConcepto_Conprereq(struct.getConprereq());
      setgxTv_SdtConcepto_Conmostrarpos(struct.getConmostrarpos());
      setgxTv_SdtConcepto_Conadeldescu(struct.getConadeldescu());
      setgxTv_SdtConcepto_Apliigg(struct.getApliigg());
      setgxTv_SdtConcepto_Consegunpla(struct.getConsegunpla());
      setgxTv_SdtConcepto_Connumero(struct.getConnumero());
      setgxTv_SdtConcepto_Consipaapo(struct.getConsipaapo());
      setgxTv_SdtConcepto_Consipacont(struct.getConsipacont());
      setgxTv_SdtConcepto_Coninssjypapo(struct.getConinssjypapo());
      setgxTv_SdtConcepto_Coninssjypcont(struct.getConinssjypcont());
      setgxTv_SdtConcepto_Conobrasocapo(struct.getConobrasocapo());
      setgxTv_SdtConcepto_Conobrasoccont(struct.getConobrasoccont());
      GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> gxTv_SdtConcepto_Motivosegreso_aux = new GXBCLevelCollection<web.SdtConcepto_MotivosEgreso>(web.SdtConcepto_MotivosEgreso.class, "Concepto.MotivosEgreso", "PayDay", remoteHandle);
      Vector<web.StructSdtConcepto_MotivosEgreso> gxTv_SdtConcepto_Motivosegreso_aux1 = struct.getMotivosegreso();
      if (gxTv_SdtConcepto_Motivosegreso_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtConcepto_Motivosegreso_aux1.size(); i++)
         {
            gxTv_SdtConcepto_Motivosegreso_aux.add(new web.SdtConcepto_MotivosEgreso(remoteHandle, gxTv_SdtConcepto_Motivosegreso_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtConcepto_Motivosegreso(gxTv_SdtConcepto_Motivosegreso_aux);
      setgxTv_SdtConcepto_Confonsolredapo(struct.getConfonsolredapo());
      setgxTv_SdtConcepto_Confonsolredcont(struct.getConfonsolredcont());
      setgxTv_SdtConcepto_Conrenateaapo(struct.getConrenateaapo());
      setgxTv_SdtConcepto_Conrenateacont(struct.getConrenateacont());
      setgxTv_SdtConcepto_Conasigfamcont(struct.getConasigfamcont());
      setgxTv_SdtConcepto_Confonnacempcont(struct.getConfonnacempcont());
      setgxTv_SdtConcepto_Conleyrietrabcont(struct.getConleyrietrabcont());
      setgxTv_SdtConcepto_Conregdifapo(struct.getConregdifapo());
      setgxTv_SdtConcepto_Conregespapo(struct.getConregespapo());
      setgxTv_SdtConcepto_Consacdeven(struct.getConsacdeven());
      setgxTv_SdtConcepto_Conbaselic(struct.getConbaselic());
      setgxTv_SdtConcepto_Conbaselicprom(struct.getConbaselicprom());
      setgxTv_SdtConcepto_Conbasefer(struct.getConbasefer());
      setgxTv_SdtConcepto_Conbaseferprom(struct.getConbaseferprom());
      setgxTv_SdtConcepto_Conbasehorext(struct.getConbasehorext());
      setgxTv_SdtConcepto_Conbasehorextprom(struct.getConbasehorextprom());
      setgxTv_SdtConcepto_Conbasepres(struct.getConbasepres());
      setgxTv_SdtConcepto_Conbaseant(struct.getConbaseant());
      setgxTv_SdtConcepto_Conbaseosdif(struct.getConbaseosdif());
      setgxTv_SdtConcepto_Conbaseaus(struct.getConbaseaus());
      setgxTv_SdtConcepto_Conbaseausprom(struct.getConbaseausprom());
      setgxTv_SdtConcepto_Conceptopais(struct.getConceptopais());
      setgxTv_SdtConcepto_Conceptoconvecodigo(struct.getConceptoconvecodigo());
      setgxTv_SdtConcepto_Concodafip(struct.getConcodafip());
      setgxTv_SdtConcepto_Concntpa(struct.getConcntpa());
      setgxTv_SdtConcepto_Conerrorsicero(struct.getConerrorsicero());
      setgxTv_SdtConcepto_Clipadre(struct.getClipadre());
      setgxTv_SdtConcepto_Conpadre(struct.getConpadre());
      setgxTv_SdtConcepto_Conpuenov(struct.getConpuenov());
      setgxTv_SdtConcepto_Conrelsec(struct.getConrelsec());
      setgxTv_SdtConcepto_Conrelseccli(struct.getConrelseccli());
      setgxTv_SdtConcepto_Conoldvalues(struct.getConoldvalues());
      setgxTv_SdtConcepto_Conrelref(struct.getConrelref());
      setgxTv_SdtConcepto_Condescripsinac(struct.getCondescripsinac());
      setgxTv_SdtConcepto_Conoblpalabra(struct.getConoblpalabra());
      setgxTv_SdtConcepto_Mode(struct.getMode());
      setgxTv_SdtConcepto_Initialized(struct.getInitialized());
      setgxTv_SdtConcepto_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtConcepto_Concodigo_Z(struct.getConcodigo_Z());
      setgxTv_SdtConcepto_Condescrip_Z(struct.getCondescrip_Z());
      setgxTv_SdtConcepto_Conhabilitado_Z(struct.getConhabilitado_Z());
      setgxTv_SdtConcepto_Conorden_Z(struct.getConorden_Z());
      setgxTv_SdtConcepto_Concanti_Z(struct.getConcanti_Z());
      setgxTv_SdtConcepto_Convaluni_Z(struct.getConvaluni_Z());
      setgxTv_SdtConcepto_Conimporte_Z(struct.getConimporte_Z());
      setgxTv_SdtConcepto_Convigencia_Z(struct.getConvigencia_Z());
      setgxTv_SdtConcepto_Conliqbasica_Z(struct.getConliqbasica_Z());
      setgxTv_SdtConcepto_Convalorgen_Z(struct.getConvalorgen_Z());
      setgxTv_SdtConcepto_Contipoliqganancias_Z(struct.getContipoliqganancias_Z());
      setgxTv_SdtConcepto_Convariable_Z(struct.getConvariable_Z());
      setgxTv_SdtConcepto_Conusumodfor_Z(struct.getConusumodfor_Z());
      setgxTv_SdtConcepto_Confchmodfor_Z(struct.getConfchmodfor_Z());
      setgxTv_SdtConcepto_Conformulaabr_Z(struct.getConformulaabr_Z());
      setgxTv_SdtConcepto_Concodydesc_Z(struct.getConcodydesc_Z());
      setgxTv_SdtConcepto_Tipoconcod_Z(struct.getTipoconcod_Z());
      setgxTv_SdtConcepto_Subtipoconcod1_Z(struct.getSubtipoconcod1_Z());
      setgxTv_SdtConcepto_Subtipoconcod2_Z(struct.getSubtipoconcod2_Z());
      setgxTv_SdtConcepto_Contipo_Z(struct.getContipo_Z());
      setgxTv_SdtConcepto_Concodold_Z(struct.getConcodold_Z());
      setgxTv_SdtConcepto_Concuendebe_Z(struct.getConcuendebe_Z());
      setgxTv_SdtConcepto_Concuenhaber_Z(struct.getConcuenhaber_Z());
      setgxTv_SdtConcepto_Contipoliqaux_Z(struct.getContipoliqaux_Z());
      setgxTv_SdtConcepto_Conconveaux_Z(struct.getConconveaux_Z());
      setgxTv_SdtConcepto_Conclasifaux_Z(struct.getConclasifaux_Z());
      setgxTv_SdtConcepto_Conordejec_Z(struct.getConordejec_Z());
      setgxTv_SdtConcepto_Conretganpropor_Z(struct.getConretganpropor_Z());
      setgxTv_SdtConcepto_Conaplicgan_Z(struct.getConaplicgan_Z());
      setgxTv_SdtConcepto_Conrecalcular_Z(struct.getConrecalcular_Z());
      setgxTv_SdtConcepto_Conimportado_Z(struct.getConimportado_Z());
      setgxTv_SdtConcepto_Contipoorden_Z(struct.getContipoorden_Z());
      setgxTv_SdtConcepto_Conedienrec_Z(struct.getConedienrec_Z());
      setgxTv_SdtConcepto_Conrangocant_Z(struct.getConrangocant_Z());
      setgxTv_SdtConcepto_Conusado_Z(struct.getConusado_Z());
      setgxTv_SdtConcepto_Conobliga_Z(struct.getConobliga_Z());
      setgxTv_SdtConcepto_Conobligasisac_Z(struct.getConobligasisac_Z());
      setgxTv_SdtConcepto_Concondicion_Z(struct.getConcondicion_Z());
      setgxTv_SdtConcepto_Concondcodigo_Z(struct.getConcondcodigo_Z());
      setgxTv_SdtConcepto_Conprereq_Z(struct.getConprereq_Z());
      setgxTv_SdtConcepto_Conmostrarpos_Z(struct.getConmostrarpos_Z());
      setgxTv_SdtConcepto_Conadeldescu_Z(struct.getConadeldescu_Z());
      setgxTv_SdtConcepto_Apliigg_Z(struct.getApliigg_Z());
      setgxTv_SdtConcepto_Consegunpla_Z(struct.getConsegunpla_Z());
      setgxTv_SdtConcepto_Connumero_Z(struct.getConnumero_Z());
      setgxTv_SdtConcepto_Consipaapo_Z(struct.getConsipaapo_Z());
      setgxTv_SdtConcepto_Consipacont_Z(struct.getConsipacont_Z());
      setgxTv_SdtConcepto_Coninssjypapo_Z(struct.getConinssjypapo_Z());
      setgxTv_SdtConcepto_Coninssjypcont_Z(struct.getConinssjypcont_Z());
      setgxTv_SdtConcepto_Conobrasocapo_Z(struct.getConobrasocapo_Z());
      setgxTv_SdtConcepto_Conobrasoccont_Z(struct.getConobrasoccont_Z());
      setgxTv_SdtConcepto_Confonsolredapo_Z(struct.getConfonsolredapo_Z());
      setgxTv_SdtConcepto_Confonsolredcont_Z(struct.getConfonsolredcont_Z());
      setgxTv_SdtConcepto_Conrenateaapo_Z(struct.getConrenateaapo_Z());
      setgxTv_SdtConcepto_Conrenateacont_Z(struct.getConrenateacont_Z());
      setgxTv_SdtConcepto_Conasigfamcont_Z(struct.getConasigfamcont_Z());
      setgxTv_SdtConcepto_Confonnacempcont_Z(struct.getConfonnacempcont_Z());
      setgxTv_SdtConcepto_Conleyrietrabcont_Z(struct.getConleyrietrabcont_Z());
      setgxTv_SdtConcepto_Conregdifapo_Z(struct.getConregdifapo_Z());
      setgxTv_SdtConcepto_Conregespapo_Z(struct.getConregespapo_Z());
      setgxTv_SdtConcepto_Consacdeven_Z(struct.getConsacdeven_Z());
      setgxTv_SdtConcepto_Conbaselic_Z(struct.getConbaselic_Z());
      setgxTv_SdtConcepto_Conbaselicprom_Z(struct.getConbaselicprom_Z());
      setgxTv_SdtConcepto_Conbasefer_Z(struct.getConbasefer_Z());
      setgxTv_SdtConcepto_Conbaseferprom_Z(struct.getConbaseferprom_Z());
      setgxTv_SdtConcepto_Conbasehorext_Z(struct.getConbasehorext_Z());
      setgxTv_SdtConcepto_Conbasehorextprom_Z(struct.getConbasehorextprom_Z());
      setgxTv_SdtConcepto_Conbasepres_Z(struct.getConbasepres_Z());
      setgxTv_SdtConcepto_Conbaseant_Z(struct.getConbaseant_Z());
      setgxTv_SdtConcepto_Conbaseosdif_Z(struct.getConbaseosdif_Z());
      setgxTv_SdtConcepto_Conbaseaus_Z(struct.getConbaseaus_Z());
      setgxTv_SdtConcepto_Conbaseausprom_Z(struct.getConbaseausprom_Z());
      setgxTv_SdtConcepto_Conceptopais_Z(struct.getConceptopais_Z());
      setgxTv_SdtConcepto_Conceptoconvecodigo_Z(struct.getConceptoconvecodigo_Z());
      setgxTv_SdtConcepto_Concodafip_Z(struct.getConcodafip_Z());
      setgxTv_SdtConcepto_Concntpa_Z(struct.getConcntpa_Z());
      setgxTv_SdtConcepto_Conerrorsicero_Z(struct.getConerrorsicero_Z());
      setgxTv_SdtConcepto_Clipadre_Z(struct.getClipadre_Z());
      setgxTv_SdtConcepto_Conpadre_Z(struct.getConpadre_Z());
      setgxTv_SdtConcepto_Conpuenov_Z(struct.getConpuenov_Z());
      setgxTv_SdtConcepto_Conrelsec_Z(struct.getConrelsec_Z());
      setgxTv_SdtConcepto_Conrelseccli_Z(struct.getConrelseccli_Z());
      setgxTv_SdtConcepto_Conrelref_Z(struct.getConrelref_Z());
      setgxTv_SdtConcepto_Condescripsinac_Z(struct.getCondescripsinac_Z());
      setgxTv_SdtConcepto_Conoblpalabra_Z(struct.getConoblpalabra_Z());
      setgxTv_SdtConcepto_Conformula_N(struct.getConformula_N());
      setgxTv_SdtConcepto_Convalorgen_N(struct.getConvalorgen_N());
      setgxTv_SdtConcepto_Contipoliqganancias_N(struct.getContipoliqganancias_N());
      setgxTv_SdtConcepto_Conhisformula_N(struct.getConhisformula_N());
      setgxTv_SdtConcepto_Conusumodfor_N(struct.getConusumodfor_N());
      setgxTv_SdtConcepto_Confchmodfor_N(struct.getConfchmodfor_N());
      setgxTv_SdtConcepto_Concodydesc_N(struct.getConcodydesc_N());
      setgxTv_SdtConcepto_Subtipoconcod1_N(struct.getSubtipoconcod1_N());
      setgxTv_SdtConcepto_Subtipoconcod2_N(struct.getSubtipoconcod2_N());
      setgxTv_SdtConcepto_Concuendebe_N(struct.getConcuendebe_N());
      setgxTv_SdtConcepto_Concuenhaber_N(struct.getConcuenhaber_N());
      setgxTv_SdtConcepto_Contipoliqaux_N(struct.getContipoliqaux_N());
      setgxTv_SdtConcepto_Conconveaux_N(struct.getConconveaux_N());
      setgxTv_SdtConcepto_Conclasifaux_N(struct.getConclasifaux_N());
      setgxTv_SdtConcepto_Conaplicgan_N(struct.getConaplicgan_N());
      setgxTv_SdtConcepto_Conobliga_N(struct.getConobliga_N());
      setgxTv_SdtConcepto_Conobligasisac_N(struct.getConobligasisac_N());
      setgxTv_SdtConcepto_Concondicion_N(struct.getConcondicion_N());
      setgxTv_SdtConcepto_Conprereq_N(struct.getConprereq_N());
      setgxTv_SdtConcepto_Conadeldescu_N(struct.getConadeldescu_N());
      setgxTv_SdtConcepto_Apliigg_N(struct.getApliigg_N());
      setgxTv_SdtConcepto_Conceptopais_N(struct.getConceptopais_N());
      setgxTv_SdtConcepto_Conceptoconvecodigo_N(struct.getConceptoconvecodigo_N());
      setgxTv_SdtConcepto_Clipadre_N(struct.getClipadre_N());
      setgxTv_SdtConcepto_Conpadre_N(struct.getConpadre_N());
      setgxTv_SdtConcepto_Conoblpalabra_N(struct.getConoblpalabra_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConcepto getStruct( )
   {
      web.StructSdtConcepto struct = new web.StructSdtConcepto ();
      struct.setClicod(getgxTv_SdtConcepto_Clicod());
      struct.setConcodigo(getgxTv_SdtConcepto_Concodigo());
      struct.setCondescrip(getgxTv_SdtConcepto_Condescrip());
      struct.setConhabilitado(getgxTv_SdtConcepto_Conhabilitado());
      struct.setConorden(getgxTv_SdtConcepto_Conorden());
      struct.setConcanti(getgxTv_SdtConcepto_Concanti());
      struct.setConvaluni(getgxTv_SdtConcepto_Convaluni());
      struct.setConimporte(getgxTv_SdtConcepto_Conimporte());
      struct.setConvigencia(getgxTv_SdtConcepto_Convigencia());
      struct.setConliqbasica(getgxTv_SdtConcepto_Conliqbasica());
      struct.setConformula(getgxTv_SdtConcepto_Conformula());
      struct.setConformulapreresuelta(getgxTv_SdtConcepto_Conformulapreresuelta());
      struct.setConvalorgen(getgxTv_SdtConcepto_Convalorgen());
      struct.setContipoliqganancias(getgxTv_SdtConcepto_Contipoliqganancias());
      struct.setConobservacion(getgxTv_SdtConcepto_Conobservacion());
      struct.setConvariable(getgxTv_SdtConcepto_Convariable());
      struct.setConhisformula(getgxTv_SdtConcepto_Conhisformula());
      struct.setConusumodfor(getgxTv_SdtConcepto_Conusumodfor());
      struct.setConfchmodfor(getgxTv_SdtConcepto_Confchmodfor());
      struct.setConformulaabr(getgxTv_SdtConcepto_Conformulaabr());
      struct.setConcodydesc(getgxTv_SdtConcepto_Concodydesc());
      struct.setTipoconcod(getgxTv_SdtConcepto_Tipoconcod());
      struct.setSubtipoconcod1(getgxTv_SdtConcepto_Subtipoconcod1());
      struct.setSubtipoconcod2(getgxTv_SdtConcepto_Subtipoconcod2());
      struct.setContipo(getgxTv_SdtConcepto_Contipo());
      struct.setConcodold(getgxTv_SdtConcepto_Concodold());
      struct.setConcuendebe(getgxTv_SdtConcepto_Concuendebe());
      struct.setConcuenhaber(getgxTv_SdtConcepto_Concuenhaber());
      struct.setContipoliqaux(getgxTv_SdtConcepto_Contipoliqaux());
      struct.setConconveaux(getgxTv_SdtConcepto_Conconveaux());
      struct.setConclasifaux(getgxTv_SdtConcepto_Conclasifaux());
      struct.setConordejec(getgxTv_SdtConcepto_Conordejec());
      struct.setConformulaexpl(getgxTv_SdtConcepto_Conformulaexpl());
      struct.setConformulaobs2(getgxTv_SdtConcepto_Conformulaobs2());
      struct.setConretganpropor(getgxTv_SdtConcepto_Conretganpropor());
      struct.setConaplicgan(getgxTv_SdtConcepto_Conaplicgan());
      struct.setConrecalcular(getgxTv_SdtConcepto_Conrecalcular());
      struct.setConimportado(getgxTv_SdtConcepto_Conimportado());
      struct.setContipoorden(getgxTv_SdtConcepto_Contipoorden());
      struct.setConedienrec(getgxTv_SdtConcepto_Conedienrec());
      struct.setConrangocant(getgxTv_SdtConcepto_Conrangocant());
      struct.setTipoliquidacion(getgxTv_SdtConcepto_Tipoliquidacion().getStruct());
      struct.setConusado(getgxTv_SdtConcepto_Conusado());
      struct.setConobliga(getgxTv_SdtConcepto_Conobliga());
      struct.setConobligasisac(getgxTv_SdtConcepto_Conobligasisac());
      struct.setConcondicion(getgxTv_SdtConcepto_Concondicion());
      struct.setConcondcodigo(getgxTv_SdtConcepto_Concondcodigo());
      struct.setConprereq(getgxTv_SdtConcepto_Conprereq());
      struct.setConmostrarpos(getgxTv_SdtConcepto_Conmostrarpos());
      struct.setConadeldescu(getgxTv_SdtConcepto_Conadeldescu());
      struct.setApliigg(getgxTv_SdtConcepto_Apliigg());
      struct.setConsegunpla(getgxTv_SdtConcepto_Consegunpla());
      struct.setConnumero(getgxTv_SdtConcepto_Connumero());
      struct.setConsipaapo(getgxTv_SdtConcepto_Consipaapo());
      struct.setConsipacont(getgxTv_SdtConcepto_Consipacont());
      struct.setConinssjypapo(getgxTv_SdtConcepto_Coninssjypapo());
      struct.setConinssjypcont(getgxTv_SdtConcepto_Coninssjypcont());
      struct.setConobrasocapo(getgxTv_SdtConcepto_Conobrasocapo());
      struct.setConobrasoccont(getgxTv_SdtConcepto_Conobrasoccont());
      struct.setMotivosegreso(getgxTv_SdtConcepto_Motivosegreso().getStruct());
      struct.setConfonsolredapo(getgxTv_SdtConcepto_Confonsolredapo());
      struct.setConfonsolredcont(getgxTv_SdtConcepto_Confonsolredcont());
      struct.setConrenateaapo(getgxTv_SdtConcepto_Conrenateaapo());
      struct.setConrenateacont(getgxTv_SdtConcepto_Conrenateacont());
      struct.setConasigfamcont(getgxTv_SdtConcepto_Conasigfamcont());
      struct.setConfonnacempcont(getgxTv_SdtConcepto_Confonnacempcont());
      struct.setConleyrietrabcont(getgxTv_SdtConcepto_Conleyrietrabcont());
      struct.setConregdifapo(getgxTv_SdtConcepto_Conregdifapo());
      struct.setConregespapo(getgxTv_SdtConcepto_Conregespapo());
      struct.setConsacdeven(getgxTv_SdtConcepto_Consacdeven());
      struct.setConbaselic(getgxTv_SdtConcepto_Conbaselic());
      struct.setConbaselicprom(getgxTv_SdtConcepto_Conbaselicprom());
      struct.setConbasefer(getgxTv_SdtConcepto_Conbasefer());
      struct.setConbaseferprom(getgxTv_SdtConcepto_Conbaseferprom());
      struct.setConbasehorext(getgxTv_SdtConcepto_Conbasehorext());
      struct.setConbasehorextprom(getgxTv_SdtConcepto_Conbasehorextprom());
      struct.setConbasepres(getgxTv_SdtConcepto_Conbasepres());
      struct.setConbaseant(getgxTv_SdtConcepto_Conbaseant());
      struct.setConbaseosdif(getgxTv_SdtConcepto_Conbaseosdif());
      struct.setConbaseaus(getgxTv_SdtConcepto_Conbaseaus());
      struct.setConbaseausprom(getgxTv_SdtConcepto_Conbaseausprom());
      struct.setConceptopais(getgxTv_SdtConcepto_Conceptopais());
      struct.setConceptoconvecodigo(getgxTv_SdtConcepto_Conceptoconvecodigo());
      struct.setConcodafip(getgxTv_SdtConcepto_Concodafip());
      struct.setConcntpa(getgxTv_SdtConcepto_Concntpa());
      struct.setConerrorsicero(getgxTv_SdtConcepto_Conerrorsicero());
      struct.setClipadre(getgxTv_SdtConcepto_Clipadre());
      struct.setConpadre(getgxTv_SdtConcepto_Conpadre());
      struct.setConpuenov(getgxTv_SdtConcepto_Conpuenov());
      struct.setConrelsec(getgxTv_SdtConcepto_Conrelsec());
      struct.setConrelseccli(getgxTv_SdtConcepto_Conrelseccli());
      struct.setConoldvalues(getgxTv_SdtConcepto_Conoldvalues());
      struct.setConrelref(getgxTv_SdtConcepto_Conrelref());
      struct.setCondescripsinac(getgxTv_SdtConcepto_Condescripsinac());
      struct.setConoblpalabra(getgxTv_SdtConcepto_Conoblpalabra());
      struct.setMode(getgxTv_SdtConcepto_Mode());
      struct.setInitialized(getgxTv_SdtConcepto_Initialized());
      struct.setClicod_Z(getgxTv_SdtConcepto_Clicod_Z());
      struct.setConcodigo_Z(getgxTv_SdtConcepto_Concodigo_Z());
      struct.setCondescrip_Z(getgxTv_SdtConcepto_Condescrip_Z());
      struct.setConhabilitado_Z(getgxTv_SdtConcepto_Conhabilitado_Z());
      struct.setConorden_Z(getgxTv_SdtConcepto_Conorden_Z());
      struct.setConcanti_Z(getgxTv_SdtConcepto_Concanti_Z());
      struct.setConvaluni_Z(getgxTv_SdtConcepto_Convaluni_Z());
      struct.setConimporte_Z(getgxTv_SdtConcepto_Conimporte_Z());
      struct.setConvigencia_Z(getgxTv_SdtConcepto_Convigencia_Z());
      struct.setConliqbasica_Z(getgxTv_SdtConcepto_Conliqbasica_Z());
      struct.setConvalorgen_Z(getgxTv_SdtConcepto_Convalorgen_Z());
      struct.setContipoliqganancias_Z(getgxTv_SdtConcepto_Contipoliqganancias_Z());
      struct.setConvariable_Z(getgxTv_SdtConcepto_Convariable_Z());
      struct.setConusumodfor_Z(getgxTv_SdtConcepto_Conusumodfor_Z());
      struct.setConfchmodfor_Z(getgxTv_SdtConcepto_Confchmodfor_Z());
      struct.setConformulaabr_Z(getgxTv_SdtConcepto_Conformulaabr_Z());
      struct.setConcodydesc_Z(getgxTv_SdtConcepto_Concodydesc_Z());
      struct.setTipoconcod_Z(getgxTv_SdtConcepto_Tipoconcod_Z());
      struct.setSubtipoconcod1_Z(getgxTv_SdtConcepto_Subtipoconcod1_Z());
      struct.setSubtipoconcod2_Z(getgxTv_SdtConcepto_Subtipoconcod2_Z());
      struct.setContipo_Z(getgxTv_SdtConcepto_Contipo_Z());
      struct.setConcodold_Z(getgxTv_SdtConcepto_Concodold_Z());
      struct.setConcuendebe_Z(getgxTv_SdtConcepto_Concuendebe_Z());
      struct.setConcuenhaber_Z(getgxTv_SdtConcepto_Concuenhaber_Z());
      struct.setContipoliqaux_Z(getgxTv_SdtConcepto_Contipoliqaux_Z());
      struct.setConconveaux_Z(getgxTv_SdtConcepto_Conconveaux_Z());
      struct.setConclasifaux_Z(getgxTv_SdtConcepto_Conclasifaux_Z());
      struct.setConordejec_Z(getgxTv_SdtConcepto_Conordejec_Z());
      struct.setConretganpropor_Z(getgxTv_SdtConcepto_Conretganpropor_Z());
      struct.setConaplicgan_Z(getgxTv_SdtConcepto_Conaplicgan_Z());
      struct.setConrecalcular_Z(getgxTv_SdtConcepto_Conrecalcular_Z());
      struct.setConimportado_Z(getgxTv_SdtConcepto_Conimportado_Z());
      struct.setContipoorden_Z(getgxTv_SdtConcepto_Contipoorden_Z());
      struct.setConedienrec_Z(getgxTv_SdtConcepto_Conedienrec_Z());
      struct.setConrangocant_Z(getgxTv_SdtConcepto_Conrangocant_Z());
      struct.setConusado_Z(getgxTv_SdtConcepto_Conusado_Z());
      struct.setConobliga_Z(getgxTv_SdtConcepto_Conobliga_Z());
      struct.setConobligasisac_Z(getgxTv_SdtConcepto_Conobligasisac_Z());
      struct.setConcondicion_Z(getgxTv_SdtConcepto_Concondicion_Z());
      struct.setConcondcodigo_Z(getgxTv_SdtConcepto_Concondcodigo_Z());
      struct.setConprereq_Z(getgxTv_SdtConcepto_Conprereq_Z());
      struct.setConmostrarpos_Z(getgxTv_SdtConcepto_Conmostrarpos_Z());
      struct.setConadeldescu_Z(getgxTv_SdtConcepto_Conadeldescu_Z());
      struct.setApliigg_Z(getgxTv_SdtConcepto_Apliigg_Z());
      struct.setConsegunpla_Z(getgxTv_SdtConcepto_Consegunpla_Z());
      struct.setConnumero_Z(getgxTv_SdtConcepto_Connumero_Z());
      struct.setConsipaapo_Z(getgxTv_SdtConcepto_Consipaapo_Z());
      struct.setConsipacont_Z(getgxTv_SdtConcepto_Consipacont_Z());
      struct.setConinssjypapo_Z(getgxTv_SdtConcepto_Coninssjypapo_Z());
      struct.setConinssjypcont_Z(getgxTv_SdtConcepto_Coninssjypcont_Z());
      struct.setConobrasocapo_Z(getgxTv_SdtConcepto_Conobrasocapo_Z());
      struct.setConobrasoccont_Z(getgxTv_SdtConcepto_Conobrasoccont_Z());
      struct.setConfonsolredapo_Z(getgxTv_SdtConcepto_Confonsolredapo_Z());
      struct.setConfonsolredcont_Z(getgxTv_SdtConcepto_Confonsolredcont_Z());
      struct.setConrenateaapo_Z(getgxTv_SdtConcepto_Conrenateaapo_Z());
      struct.setConrenateacont_Z(getgxTv_SdtConcepto_Conrenateacont_Z());
      struct.setConasigfamcont_Z(getgxTv_SdtConcepto_Conasigfamcont_Z());
      struct.setConfonnacempcont_Z(getgxTv_SdtConcepto_Confonnacempcont_Z());
      struct.setConleyrietrabcont_Z(getgxTv_SdtConcepto_Conleyrietrabcont_Z());
      struct.setConregdifapo_Z(getgxTv_SdtConcepto_Conregdifapo_Z());
      struct.setConregespapo_Z(getgxTv_SdtConcepto_Conregespapo_Z());
      struct.setConsacdeven_Z(getgxTv_SdtConcepto_Consacdeven_Z());
      struct.setConbaselic_Z(getgxTv_SdtConcepto_Conbaselic_Z());
      struct.setConbaselicprom_Z(getgxTv_SdtConcepto_Conbaselicprom_Z());
      struct.setConbasefer_Z(getgxTv_SdtConcepto_Conbasefer_Z());
      struct.setConbaseferprom_Z(getgxTv_SdtConcepto_Conbaseferprom_Z());
      struct.setConbasehorext_Z(getgxTv_SdtConcepto_Conbasehorext_Z());
      struct.setConbasehorextprom_Z(getgxTv_SdtConcepto_Conbasehorextprom_Z());
      struct.setConbasepres_Z(getgxTv_SdtConcepto_Conbasepres_Z());
      struct.setConbaseant_Z(getgxTv_SdtConcepto_Conbaseant_Z());
      struct.setConbaseosdif_Z(getgxTv_SdtConcepto_Conbaseosdif_Z());
      struct.setConbaseaus_Z(getgxTv_SdtConcepto_Conbaseaus_Z());
      struct.setConbaseausprom_Z(getgxTv_SdtConcepto_Conbaseausprom_Z());
      struct.setConceptopais_Z(getgxTv_SdtConcepto_Conceptopais_Z());
      struct.setConceptoconvecodigo_Z(getgxTv_SdtConcepto_Conceptoconvecodigo_Z());
      struct.setConcodafip_Z(getgxTv_SdtConcepto_Concodafip_Z());
      struct.setConcntpa_Z(getgxTv_SdtConcepto_Concntpa_Z());
      struct.setConerrorsicero_Z(getgxTv_SdtConcepto_Conerrorsicero_Z());
      struct.setClipadre_Z(getgxTv_SdtConcepto_Clipadre_Z());
      struct.setConpadre_Z(getgxTv_SdtConcepto_Conpadre_Z());
      struct.setConpuenov_Z(getgxTv_SdtConcepto_Conpuenov_Z());
      struct.setConrelsec_Z(getgxTv_SdtConcepto_Conrelsec_Z());
      struct.setConrelseccli_Z(getgxTv_SdtConcepto_Conrelseccli_Z());
      struct.setConrelref_Z(getgxTv_SdtConcepto_Conrelref_Z());
      struct.setCondescripsinac_Z(getgxTv_SdtConcepto_Condescripsinac_Z());
      struct.setConoblpalabra_Z(getgxTv_SdtConcepto_Conoblpalabra_Z());
      struct.setConformula_N(getgxTv_SdtConcepto_Conformula_N());
      struct.setConvalorgen_N(getgxTv_SdtConcepto_Convalorgen_N());
      struct.setContipoliqganancias_N(getgxTv_SdtConcepto_Contipoliqganancias_N());
      struct.setConhisformula_N(getgxTv_SdtConcepto_Conhisformula_N());
      struct.setConusumodfor_N(getgxTv_SdtConcepto_Conusumodfor_N());
      struct.setConfchmodfor_N(getgxTv_SdtConcepto_Confchmodfor_N());
      struct.setConcodydesc_N(getgxTv_SdtConcepto_Concodydesc_N());
      struct.setSubtipoconcod1_N(getgxTv_SdtConcepto_Subtipoconcod1_N());
      struct.setSubtipoconcod2_N(getgxTv_SdtConcepto_Subtipoconcod2_N());
      struct.setConcuendebe_N(getgxTv_SdtConcepto_Concuendebe_N());
      struct.setConcuenhaber_N(getgxTv_SdtConcepto_Concuenhaber_N());
      struct.setContipoliqaux_N(getgxTv_SdtConcepto_Contipoliqaux_N());
      struct.setConconveaux_N(getgxTv_SdtConcepto_Conconveaux_N());
      struct.setConclasifaux_N(getgxTv_SdtConcepto_Conclasifaux_N());
      struct.setConaplicgan_N(getgxTv_SdtConcepto_Conaplicgan_N());
      struct.setConobliga_N(getgxTv_SdtConcepto_Conobliga_N());
      struct.setConobligasisac_N(getgxTv_SdtConcepto_Conobligasisac_N());
      struct.setConcondicion_N(getgxTv_SdtConcepto_Concondicion_N());
      struct.setConprereq_N(getgxTv_SdtConcepto_Conprereq_N());
      struct.setConadeldescu_N(getgxTv_SdtConcepto_Conadeldescu_N());
      struct.setApliigg_N(getgxTv_SdtConcepto_Apliigg_N());
      struct.setConceptopais_N(getgxTv_SdtConcepto_Conceptopais_N());
      struct.setConceptoconvecodigo_N(getgxTv_SdtConcepto_Conceptoconvecodigo_N());
      struct.setClipadre_N(getgxTv_SdtConcepto_Clipadre_N());
      struct.setConpadre_N(getgxTv_SdtConcepto_Conpadre_N());
      struct.setConoblpalabra_N(getgxTv_SdtConcepto_Conoblpalabra_N());
      return struct ;
   }

   private byte gxTv_SdtConcepto_N ;
   private byte gxTv_SdtConcepto_Convigencia ;
   private byte gxTv_SdtConcepto_Conliqbasica ;
   private byte gxTv_SdtConcepto_Contipo ;
   private byte gxTv_SdtConcepto_Conaplicgan ;
   private byte gxTv_SdtConcepto_Conadeldescu ;
   private byte gxTv_SdtConcepto_Connumero ;
   private byte gxTv_SdtConcepto_Consipaapo ;
   private byte gxTv_SdtConcepto_Consipacont ;
   private byte gxTv_SdtConcepto_Coninssjypapo ;
   private byte gxTv_SdtConcepto_Coninssjypcont ;
   private byte gxTv_SdtConcepto_Conobrasocapo ;
   private byte gxTv_SdtConcepto_Conobrasoccont ;
   private byte gxTv_SdtConcepto_Confonsolredapo ;
   private byte gxTv_SdtConcepto_Confonsolredcont ;
   private byte gxTv_SdtConcepto_Conrenateaapo ;
   private byte gxTv_SdtConcepto_Conrenateacont ;
   private byte gxTv_SdtConcepto_Conasigfamcont ;
   private byte gxTv_SdtConcepto_Confonnacempcont ;
   private byte gxTv_SdtConcepto_Conleyrietrabcont ;
   private byte gxTv_SdtConcepto_Conregdifapo ;
   private byte gxTv_SdtConcepto_Conregespapo ;
   private byte gxTv_SdtConcepto_Consacdeven ;
   private byte gxTv_SdtConcepto_Conbaselic ;
   private byte gxTv_SdtConcepto_Conbaselicprom ;
   private byte gxTv_SdtConcepto_Conbasefer ;
   private byte gxTv_SdtConcepto_Conbaseferprom ;
   private byte gxTv_SdtConcepto_Conbasehorext ;
   private byte gxTv_SdtConcepto_Conbasehorextprom ;
   private byte gxTv_SdtConcepto_Conbasepres ;
   private byte gxTv_SdtConcepto_Conbaseant ;
   private byte gxTv_SdtConcepto_Conbaseosdif ;
   private byte gxTv_SdtConcepto_Conbaseaus ;
   private byte gxTv_SdtConcepto_Conbaseausprom ;
   private byte gxTv_SdtConcepto_Concntpa ;
   private byte gxTv_SdtConcepto_Convigencia_Z ;
   private byte gxTv_SdtConcepto_Conliqbasica_Z ;
   private byte gxTv_SdtConcepto_Contipo_Z ;
   private byte gxTv_SdtConcepto_Conaplicgan_Z ;
   private byte gxTv_SdtConcepto_Conadeldescu_Z ;
   private byte gxTv_SdtConcepto_Connumero_Z ;
   private byte gxTv_SdtConcepto_Consipaapo_Z ;
   private byte gxTv_SdtConcepto_Consipacont_Z ;
   private byte gxTv_SdtConcepto_Coninssjypapo_Z ;
   private byte gxTv_SdtConcepto_Coninssjypcont_Z ;
   private byte gxTv_SdtConcepto_Conobrasocapo_Z ;
   private byte gxTv_SdtConcepto_Conobrasoccont_Z ;
   private byte gxTv_SdtConcepto_Confonsolredapo_Z ;
   private byte gxTv_SdtConcepto_Confonsolredcont_Z ;
   private byte gxTv_SdtConcepto_Conrenateaapo_Z ;
   private byte gxTv_SdtConcepto_Conrenateacont_Z ;
   private byte gxTv_SdtConcepto_Conasigfamcont_Z ;
   private byte gxTv_SdtConcepto_Confonnacempcont_Z ;
   private byte gxTv_SdtConcepto_Conleyrietrabcont_Z ;
   private byte gxTv_SdtConcepto_Conregdifapo_Z ;
   private byte gxTv_SdtConcepto_Conregespapo_Z ;
   private byte gxTv_SdtConcepto_Consacdeven_Z ;
   private byte gxTv_SdtConcepto_Conbaselic_Z ;
   private byte gxTv_SdtConcepto_Conbaselicprom_Z ;
   private byte gxTv_SdtConcepto_Conbasefer_Z ;
   private byte gxTv_SdtConcepto_Conbaseferprom_Z ;
   private byte gxTv_SdtConcepto_Conbasehorext_Z ;
   private byte gxTv_SdtConcepto_Conbasehorextprom_Z ;
   private byte gxTv_SdtConcepto_Conbasepres_Z ;
   private byte gxTv_SdtConcepto_Conbaseant_Z ;
   private byte gxTv_SdtConcepto_Conbaseosdif_Z ;
   private byte gxTv_SdtConcepto_Conbaseaus_Z ;
   private byte gxTv_SdtConcepto_Conbaseausprom_Z ;
   private byte gxTv_SdtConcepto_Concntpa_Z ;
   private byte gxTv_SdtConcepto_Conformula_N ;
   private byte gxTv_SdtConcepto_Convalorgen_N ;
   private byte gxTv_SdtConcepto_Contipoliqganancias_N ;
   private byte gxTv_SdtConcepto_Conhisformula_N ;
   private byte gxTv_SdtConcepto_Conusumodfor_N ;
   private byte gxTv_SdtConcepto_Confchmodfor_N ;
   private byte gxTv_SdtConcepto_Concodydesc_N ;
   private byte gxTv_SdtConcepto_Subtipoconcod1_N ;
   private byte gxTv_SdtConcepto_Subtipoconcod2_N ;
   private byte gxTv_SdtConcepto_Concuendebe_N ;
   private byte gxTv_SdtConcepto_Concuenhaber_N ;
   private byte gxTv_SdtConcepto_Contipoliqaux_N ;
   private byte gxTv_SdtConcepto_Conconveaux_N ;
   private byte gxTv_SdtConcepto_Conclasifaux_N ;
   private byte gxTv_SdtConcepto_Conaplicgan_N ;
   private byte gxTv_SdtConcepto_Conobliga_N ;
   private byte gxTv_SdtConcepto_Conobligasisac_N ;
   private byte gxTv_SdtConcepto_Concondicion_N ;
   private byte gxTv_SdtConcepto_Conprereq_N ;
   private byte gxTv_SdtConcepto_Conadeldescu_N ;
   private byte gxTv_SdtConcepto_Apliigg_N ;
   private byte gxTv_SdtConcepto_Conceptopais_N ;
   private byte gxTv_SdtConcepto_Conceptoconvecodigo_N ;
   private byte gxTv_SdtConcepto_Clipadre_N ;
   private byte gxTv_SdtConcepto_Conpadre_N ;
   private byte gxTv_SdtConcepto_Conoblpalabra_N ;
   private short gxTv_SdtConcepto_Contipoorden ;
   private short gxTv_SdtConcepto_Apliigg ;
   private short gxTv_SdtConcepto_Conceptopais ;
   private short gxTv_SdtConcepto_Initialized ;
   private short gxTv_SdtConcepto_Contipoorden_Z ;
   private short gxTv_SdtConcepto_Apliigg_Z ;
   private short gxTv_SdtConcepto_Conceptopais_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtConcepto_Clicod ;
   private int gxTv_SdtConcepto_Conorden ;
   private int gxTv_SdtConcepto_Clipadre ;
   private int gxTv_SdtConcepto_Conrelsec ;
   private int gxTv_SdtConcepto_Conrelseccli ;
   private int gxTv_SdtConcepto_Clicod_Z ;
   private int gxTv_SdtConcepto_Conorden_Z ;
   private int gxTv_SdtConcepto_Clipadre_Z ;
   private int gxTv_SdtConcepto_Conrelsec_Z ;
   private int gxTv_SdtConcepto_Conrelseccli_Z ;
   private long gxTv_SdtConcepto_Conordejec ;
   private long gxTv_SdtConcepto_Conordejec_Z ;
   private java.math.BigDecimal gxTv_SdtConcepto_Convalorgen ;
   private java.math.BigDecimal gxTv_SdtConcepto_Convalorgen_Z ;
   private String gxTv_SdtConcepto_Concodigo ;
   private String gxTv_SdtConcepto_Contipoliqganancias ;
   private String gxTv_SdtConcepto_Conusumodfor ;
   private String gxTv_SdtConcepto_Conformulaabr ;
   private String gxTv_SdtConcepto_Tipoconcod ;
   private String gxTv_SdtConcepto_Subtipoconcod1 ;
   private String gxTv_SdtConcepto_Subtipoconcod2 ;
   private String gxTv_SdtConcepto_Concodold ;
   private String gxTv_SdtConcepto_Concuendebe ;
   private String gxTv_SdtConcepto_Concuenhaber ;
   private String gxTv_SdtConcepto_Concondicion ;
   private String gxTv_SdtConcepto_Concondcodigo ;
   private String gxTv_SdtConcepto_Conprereq ;
   private String gxTv_SdtConcepto_Conceptoconvecodigo ;
   private String gxTv_SdtConcepto_Concodafip ;
   private String gxTv_SdtConcepto_Conpadre ;
   private String gxTv_SdtConcepto_Conoblpalabra ;
   private String gxTv_SdtConcepto_Mode ;
   private String gxTv_SdtConcepto_Concodigo_Z ;
   private String gxTv_SdtConcepto_Contipoliqganancias_Z ;
   private String gxTv_SdtConcepto_Conusumodfor_Z ;
   private String gxTv_SdtConcepto_Conformulaabr_Z ;
   private String gxTv_SdtConcepto_Tipoconcod_Z ;
   private String gxTv_SdtConcepto_Subtipoconcod1_Z ;
   private String gxTv_SdtConcepto_Subtipoconcod2_Z ;
   private String gxTv_SdtConcepto_Concodold_Z ;
   private String gxTv_SdtConcepto_Concuendebe_Z ;
   private String gxTv_SdtConcepto_Concuenhaber_Z ;
   private String gxTv_SdtConcepto_Concondicion_Z ;
   private String gxTv_SdtConcepto_Concondcodigo_Z ;
   private String gxTv_SdtConcepto_Conprereq_Z ;
   private String gxTv_SdtConcepto_Conceptoconvecodigo_Z ;
   private String gxTv_SdtConcepto_Concodafip_Z ;
   private String gxTv_SdtConcepto_Conpadre_Z ;
   private String gxTv_SdtConcepto_Conoblpalabra_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtConcepto_Confchmodfor ;
   private java.util.Date gxTv_SdtConcepto_Confchmodfor_Z ;
   private java.util.Date datetime_STZ ;
   private boolean gxTv_SdtConcepto_Conhabilitado ;
   private boolean gxTv_SdtConcepto_Concanti ;
   private boolean gxTv_SdtConcepto_Convaluni ;
   private boolean gxTv_SdtConcepto_Conimporte ;
   private boolean gxTv_SdtConcepto_Convariable ;
   private boolean gxTv_SdtConcepto_Conretganpropor ;
   private boolean gxTv_SdtConcepto_Conrecalcular ;
   private boolean gxTv_SdtConcepto_Conimportado ;
   private boolean gxTv_SdtConcepto_Conedienrec ;
   private boolean gxTv_SdtConcepto_Conusado ;
   private boolean gxTv_SdtConcepto_Conobliga ;
   private boolean gxTv_SdtConcepto_Conobligasisac ;
   private boolean gxTv_SdtConcepto_Conmostrarpos ;
   private boolean gxTv_SdtConcepto_Consegunpla ;
   private boolean gxTv_SdtConcepto_Conerrorsicero ;
   private boolean gxTv_SdtConcepto_Conpuenov ;
   private boolean gxTv_SdtConcepto_Conhabilitado_Z ;
   private boolean gxTv_SdtConcepto_Concanti_Z ;
   private boolean gxTv_SdtConcepto_Convaluni_Z ;
   private boolean gxTv_SdtConcepto_Conimporte_Z ;
   private boolean gxTv_SdtConcepto_Convariable_Z ;
   private boolean gxTv_SdtConcepto_Conretganpropor_Z ;
   private boolean gxTv_SdtConcepto_Conrecalcular_Z ;
   private boolean gxTv_SdtConcepto_Conimportado_Z ;
   private boolean gxTv_SdtConcepto_Conedienrec_Z ;
   private boolean gxTv_SdtConcepto_Conusado_Z ;
   private boolean gxTv_SdtConcepto_Conobliga_Z ;
   private boolean gxTv_SdtConcepto_Conobligasisac_Z ;
   private boolean gxTv_SdtConcepto_Conmostrarpos_Z ;
   private boolean gxTv_SdtConcepto_Consegunpla_Z ;
   private boolean gxTv_SdtConcepto_Conerrorsicero_Z ;
   private boolean gxTv_SdtConcepto_Conpuenov_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtConcepto_Conformula ;
   private String gxTv_SdtConcepto_Conformulapreresuelta ;
   private String gxTv_SdtConcepto_Conobservacion ;
   private String gxTv_SdtConcepto_Conhisformula ;
   private String gxTv_SdtConcepto_Conformulaexpl ;
   private String gxTv_SdtConcepto_Conformulaobs2 ;
   private String gxTv_SdtConcepto_Conoldvalues ;
   private String gxTv_SdtConcepto_Condescrip ;
   private String gxTv_SdtConcepto_Concodydesc ;
   private String gxTv_SdtConcepto_Contipoliqaux ;
   private String gxTv_SdtConcepto_Conconveaux ;
   private String gxTv_SdtConcepto_Conclasifaux ;
   private String gxTv_SdtConcepto_Conrangocant ;
   private String gxTv_SdtConcepto_Conrelref ;
   private String gxTv_SdtConcepto_Condescripsinac ;
   private String gxTv_SdtConcepto_Condescrip_Z ;
   private String gxTv_SdtConcepto_Concodydesc_Z ;
   private String gxTv_SdtConcepto_Contipoliqaux_Z ;
   private String gxTv_SdtConcepto_Conconveaux_Z ;
   private String gxTv_SdtConcepto_Conclasifaux_Z ;
   private String gxTv_SdtConcepto_Conrangocant_Z ;
   private String gxTv_SdtConcepto_Conrelref_Z ;
   private String gxTv_SdtConcepto_Condescripsinac_Z ;
   private GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> gxTv_SdtConcepto_Tipoliquidacion_aux ;
   private GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> gxTv_SdtConcepto_Motivosegreso_aux ;
   private GXBCLevelCollection<web.SdtConcepto_TipoLiquidacion> gxTv_SdtConcepto_Tipoliquidacion=null ;
   private GXBCLevelCollection<web.SdtConcepto_MotivosEgreso> gxTv_SdtConcepto_Motivosegreso=null ;
}

