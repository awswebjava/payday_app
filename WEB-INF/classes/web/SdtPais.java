package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais extends GxSilentTrnSdt
{
   public SdtPais( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais.class));
   }

   public SdtPais( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle, context, "SdtPais");
      initialize( remoteHandle) ;
   }

   public SdtPais( int remoteHandle ,
                   StructSdtPais struct )
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

   public void Load( short AV46PaiCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV46PaiCod)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaiCod", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Pais");
      metadata.set("BT", "Pais");
      metadata.set("PK", "[ \"PaiCod\" ]");
      metadata.set("Levels", "[ \"Vacaciones\",\"base_calculo\",\"conceptos_horanormal_jornalizados\",\"conceptos_horanormal_mensualizados\",\"horasextras_pordia\",\"preaviso\",\"promedio_horanormal_mensualizados\",\"tipo_trabajo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ReligId\" ],\"FKMap\":[ \"PaiReligDefault-ReligId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod") )
            {
               gxTv_SdtPais_Paicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom") )
            {
               gxTv_SdtPais_Painom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNacMostrar") )
            {
               gxTv_SdtPais_Painacmostrar = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiDomMostrar") )
            {
               gxTv_SdtPais_Paidommostrar = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiReligDefault") )
            {
               gxTv_SdtPais_Paireligdefault = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMesHsPExt") )
            {
               gxTv_SdtPais_Paimeshspext = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiDiaHsPExt") )
            {
               gxTv_SdtPais_Paidiahspext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiFondoCese") )
            {
               gxTv_SdtPais_Paifondocese = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMaxHorNor") )
            {
               gxTv_SdtPais_Paimaxhornor = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPerVacDes") )
            {
               gxTv_SdtPais_Paipervacdes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPerVacHas") )
            {
               gxTv_SdtPais_Paipervachas = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiFracVacAnt") )
            {
               gxTv_SdtPais_Paifracvacant = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "preaviso") )
            {
               if ( gxTv_SdtPais_Preaviso == null )
               {
                  gxTv_SdtPais_Preaviso = new GXBCLevelCollection<web.SdtPais_preaviso>(web.SdtPais_preaviso.class, "Pais.preaviso", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Preaviso.readxml(oReader, "preaviso") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "preaviso") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "base_calculo") )
            {
               if ( gxTv_SdtPais_Base_calculo == null )
               {
                  gxTv_SdtPais_Base_calculo = new GXBCLevelCollection<web.SdtPais_base_calculo>(web.SdtPais_base_calculo.class, "Pais.base_calculo", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Base_calculo.readxml(oReader, "base_calculo") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "base_calculo") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "conceptos_horanormal_jornalizados") )
            {
               if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados == null )
               {
                  gxTv_SdtPais_Conceptos_horanormal_jornalizados = new GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados>(web.SdtPais_conceptos_horanormal_jornalizados.class, "Pais.conceptos_horanormal_jornalizados", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Conceptos_horanormal_jornalizados.readxml(oReader, "conceptos_horanormal_jornalizados") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "conceptos_horanormal_jornalizados") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "conceptos_horanormal_mensualizados") )
            {
               if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados == null )
               {
                  gxTv_SdtPais_Conceptos_horanormal_mensualizados = new GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados>(web.SdtPais_conceptos_horanormal_mensualizados.class, "Pais.conceptos_horanormal_mensualizados", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Conceptos_horanormal_mensualizados.readxml(oReader, "conceptos_horanormal_mensualizados") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "conceptos_horanormal_mensualizados") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromMeses") )
            {
               gxTv_SdtPais_Paiprommeses = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromMesTCnt") )
            {
               gxTv_SdtPais_Paiprommestcnt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromJorMeses") )
            {
               gxTv_SdtPais_Paipromjormeses = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromJorMesTCnt") )
            {
               gxTv_SdtPais_Paipromjormestcnt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "promedio_horanormal_mensualizados") )
            {
               if ( gxTv_SdtPais_Promedio_horanormal_mensualizados == null )
               {
                  gxTv_SdtPais_Promedio_horanormal_mensualizados = new GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados>(web.SdtPais_promedio_horanormal_mensualizados.class, "Pais.promedio_horanormal_mensualizados", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Promedio_horanormal_mensualizados.readxml(oReader, "promedio_horanormal_mensualizados") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "promedio_horanormal_mensualizados") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_trabajo") )
            {
               if ( gxTv_SdtPais_Tipo_trabajo == null )
               {
                  gxTv_SdtPais_Tipo_trabajo = new GXBCLevelCollection<web.SdtPais_tipo_trabajo>(web.SdtPais_tipo_trabajo.class, "Pais.tipo_trabajo", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Tipo_trabajo.readxml(oReader, "tipo_trabajo") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_trabajo") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "horasextras_pordia") )
            {
               if ( gxTv_SdtPais_Horasextras_pordia == null )
               {
                  gxTv_SdtPais_Horasextras_pordia = new GXBCLevelCollection<web.SdtPais_horasextras_pordia>(web.SdtPais_horasextras_pordia.class, "Pais.horasextras_pordia", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Horasextras_pordia.readxml(oReader, "horasextras_pordia") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "horasextras_pordia") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiGuarEdadMin") )
            {
               gxTv_SdtPais_Paiguaredadmin = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiGuarEdadMax") )
            {
               gxTv_SdtPais_Paiguaredadmax = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiExcVizzoti") )
            {
               gxTv_SdtPais_Paiexcvizzoti = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVizzoti") )
            {
               gxTv_SdtPais_Paivizzoti = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMinMesesVac") )
            {
               gxTv_SdtPais_Paiminmesesvac = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiInterDiasJor") )
            {
               gxTv_SdtPais_Paiinterdiasjor = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoExpDef") )
            {
               gxTv_SdtPais_Paitipoexpdef = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Vacaciones") )
            {
               if ( gxTv_SdtPais_Vacaciones == null )
               {
                  gxTv_SdtPais_Vacaciones = new GXBCLevelCollection<web.SdtPais_Vacaciones>(web.SdtPais_Vacaciones.class, "Pais.Vacaciones", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtPais_Vacaciones.readxml(oReader, "Vacaciones") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Vacaciones") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_Z") )
            {
               gxTv_SdtPais_Paicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom_Z") )
            {
               gxTv_SdtPais_Painom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNacMostrar_Z") )
            {
               gxTv_SdtPais_Painacmostrar_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiDomMostrar_Z") )
            {
               gxTv_SdtPais_Paidommostrar_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiReligDefault_Z") )
            {
               gxTv_SdtPais_Paireligdefault_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMesHsPExt_Z") )
            {
               gxTv_SdtPais_Paimeshspext_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiDiaHsPExt_Z") )
            {
               gxTv_SdtPais_Paidiahspext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiFondoCese_Z") )
            {
               gxTv_SdtPais_Paifondocese_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMaxHorNor_Z") )
            {
               gxTv_SdtPais_Paimaxhornor_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPerVacDes_Z") )
            {
               gxTv_SdtPais_Paipervacdes_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPerVacHas_Z") )
            {
               gxTv_SdtPais_Paipervachas_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiFracVacAnt_Z") )
            {
               gxTv_SdtPais_Paifracvacant_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromMeses_Z") )
            {
               gxTv_SdtPais_Paiprommeses_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromMesTCnt_Z") )
            {
               gxTv_SdtPais_Paiprommestcnt_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromJorMeses_Z") )
            {
               gxTv_SdtPais_Paipromjormeses_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromJorMesTCnt_Z") )
            {
               gxTv_SdtPais_Paipromjormestcnt_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiGuarEdadMin_Z") )
            {
               gxTv_SdtPais_Paiguaredadmin_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiGuarEdadMax_Z") )
            {
               gxTv_SdtPais_Paiguaredadmax_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiExcVizzoti_Z") )
            {
               gxTv_SdtPais_Paiexcvizzoti_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVizzoti_Z") )
            {
               gxTv_SdtPais_Paivizzoti_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMinMesesVac_Z") )
            {
               gxTv_SdtPais_Paiminmesesvac_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiInterDiasJor_Z") )
            {
               gxTv_SdtPais_Paiinterdiasjor_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoExpDef_Z") )
            {
               gxTv_SdtPais_Paitipoexpdef_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiReligDefault_N") )
            {
               gxTv_SdtPais_Paireligdefault_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Pais" ;
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
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.str( gxTv_SdtPais_Paicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiNom", gxTv_SdtPais_Painom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiNacMostrar", GXutil.booltostr( gxTv_SdtPais_Painacmostrar));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiDomMostrar", GXutil.booltostr( gxTv_SdtPais_Paidommostrar));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiReligDefault", gxTv_SdtPais_Paireligdefault);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiMesHsPExt", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paimeshspext, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiDiaHsPExt", gxTv_SdtPais_Paidiahspext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiFondoCese", GXutil.booltostr( gxTv_SdtPais_Paifondocese));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiMaxHorNor", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paimaxhornor, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPerVacDes", GXutil.trim( GXutil.str( gxTv_SdtPais_Paipervacdes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPerVacHas", GXutil.trim( GXutil.str( gxTv_SdtPais_Paipervachas, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiFracVacAnt", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paifracvacant, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtPais_Preaviso != null )
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
         gxTv_SdtPais_Preaviso.writexml(oWriter, "preaviso", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtPais_Base_calculo != null )
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
         gxTv_SdtPais_Base_calculo.writexml(oWriter, "base_calculo", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados != null )
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
         gxTv_SdtPais_Conceptos_horanormal_jornalizados.writexml(oWriter, "conceptos_horanormal_jornalizados", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados != null )
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
         gxTv_SdtPais_Conceptos_horanormal_mensualizados.writexml(oWriter, "conceptos_horanormal_mensualizados", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("PaiPromMeses", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiprommeses, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPromMesTCnt", gxTv_SdtPais_Paiprommestcnt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPromJorMeses", GXutil.trim( GXutil.str( gxTv_SdtPais_Paipromjormeses, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPromJorMesTCnt", gxTv_SdtPais_Paipromjormestcnt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtPais_Promedio_horanormal_mensualizados != null )
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
         gxTv_SdtPais_Promedio_horanormal_mensualizados.writexml(oWriter, "promedio_horanormal_mensualizados", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtPais_Tipo_trabajo != null )
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
         gxTv_SdtPais_Tipo_trabajo.writexml(oWriter, "tipo_trabajo", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtPais_Horasextras_pordia != null )
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
         gxTv_SdtPais_Horasextras_pordia.writexml(oWriter, "horasextras_pordia", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("PaiGuarEdadMin", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiguaredadmin, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiGuarEdadMax", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiguaredadmax, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiExcVizzoti", GXutil.booltostr( gxTv_SdtPais_Paiexcvizzoti));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiVizzoti", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paivizzoti, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiMinMesesVac", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiminmesesvac, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiInterDiasJor", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiinterdiasjor, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoExpDef", GXutil.trim( GXutil.str( gxTv_SdtPais_Paitipoexpdef, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtPais_Vacaciones != null )
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
         gxTv_SdtPais_Vacaciones.writexml(oWriter, "Vacaciones", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiNom_Z", gxTv_SdtPais_Painom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiNacMostrar_Z", GXutil.booltostr( gxTv_SdtPais_Painacmostrar_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiDomMostrar_Z", GXutil.booltostr( gxTv_SdtPais_Paidommostrar_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiReligDefault_Z", gxTv_SdtPais_Paireligdefault_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiMesHsPExt_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paimeshspext_Z, 5, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiDiaHsPExt_Z", gxTv_SdtPais_Paidiahspext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiFondoCese_Z", GXutil.booltostr( gxTv_SdtPais_Paifondocese_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiMaxHorNor_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paimaxhornor_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPerVacDes_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paipervacdes_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPerVacHas_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paipervachas_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiFracVacAnt_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paifracvacant_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPromMeses_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiprommeses_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPromMesTCnt_Z", gxTv_SdtPais_Paiprommestcnt_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPromJorMeses_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paipromjormeses_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPromJorMesTCnt_Z", gxTv_SdtPais_Paipromjormestcnt_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiGuarEdadMin_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiguaredadmin_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiGuarEdadMax_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiguaredadmax_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiExcVizzoti_Z", GXutil.booltostr( gxTv_SdtPais_Paiexcvizzoti_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiVizzoti_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_Paivizzoti_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiMinMesesVac_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiminmesesvac_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiInterDiasJor_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paiinterdiasjor_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoExpDef_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Paitipoexpdef_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiReligDefault_N", GXutil.trim( GXutil.str( gxTv_SdtPais_Paireligdefault_N, 1, 0)));
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
      AddObjectProperty("PaiCod", gxTv_SdtPais_Paicod, false, includeNonInitialized);
      AddObjectProperty("PaiNom", gxTv_SdtPais_Painom, false, includeNonInitialized);
      AddObjectProperty("PaiNacMostrar", gxTv_SdtPais_Painacmostrar, false, includeNonInitialized);
      AddObjectProperty("PaiDomMostrar", gxTv_SdtPais_Paidommostrar, false, includeNonInitialized);
      AddObjectProperty("PaiReligDefault", gxTv_SdtPais_Paireligdefault, false, includeNonInitialized);
      AddObjectProperty("PaiReligDefault_N", gxTv_SdtPais_Paireligdefault_N, false, includeNonInitialized);
      AddObjectProperty("PaiMesHsPExt", gxTv_SdtPais_Paimeshspext, false, includeNonInitialized);
      AddObjectProperty("PaiDiaHsPExt", gxTv_SdtPais_Paidiahspext, false, includeNonInitialized);
      AddObjectProperty("PaiFondoCese", gxTv_SdtPais_Paifondocese, false, includeNonInitialized);
      AddObjectProperty("PaiMaxHorNor", gxTv_SdtPais_Paimaxhornor, false, includeNonInitialized);
      AddObjectProperty("PaiPerVacDes", gxTv_SdtPais_Paipervacdes, false, includeNonInitialized);
      AddObjectProperty("PaiPerVacHas", gxTv_SdtPais_Paipervachas, false, includeNonInitialized);
      AddObjectProperty("PaiFracVacAnt", gxTv_SdtPais_Paifracvacant, false, includeNonInitialized);
      if ( gxTv_SdtPais_Preaviso != null )
      {
         AddObjectProperty("preaviso", gxTv_SdtPais_Preaviso, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtPais_Base_calculo != null )
      {
         AddObjectProperty("base_calculo", gxTv_SdtPais_Base_calculo, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados != null )
      {
         AddObjectProperty("conceptos_horanormal_jornalizados", gxTv_SdtPais_Conceptos_horanormal_jornalizados, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados != null )
      {
         AddObjectProperty("conceptos_horanormal_mensualizados", gxTv_SdtPais_Conceptos_horanormal_mensualizados, includeState, includeNonInitialized);
      }
      AddObjectProperty("PaiPromMeses", gxTv_SdtPais_Paiprommeses, false, includeNonInitialized);
      AddObjectProperty("PaiPromMesTCnt", gxTv_SdtPais_Paiprommestcnt, false, includeNonInitialized);
      AddObjectProperty("PaiPromJorMeses", gxTv_SdtPais_Paipromjormeses, false, includeNonInitialized);
      AddObjectProperty("PaiPromJorMesTCnt", gxTv_SdtPais_Paipromjormestcnt, false, includeNonInitialized);
      if ( gxTv_SdtPais_Promedio_horanormal_mensualizados != null )
      {
         AddObjectProperty("promedio_horanormal_mensualizados", gxTv_SdtPais_Promedio_horanormal_mensualizados, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtPais_Tipo_trabajo != null )
      {
         AddObjectProperty("tipo_trabajo", gxTv_SdtPais_Tipo_trabajo, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtPais_Horasextras_pordia != null )
      {
         AddObjectProperty("horasextras_pordia", gxTv_SdtPais_Horasextras_pordia, includeState, includeNonInitialized);
      }
      AddObjectProperty("PaiGuarEdadMin", gxTv_SdtPais_Paiguaredadmin, false, includeNonInitialized);
      AddObjectProperty("PaiGuarEdadMax", gxTv_SdtPais_Paiguaredadmax, false, includeNonInitialized);
      AddObjectProperty("PaiExcVizzoti", gxTv_SdtPais_Paiexcvizzoti, false, includeNonInitialized);
      AddObjectProperty("PaiVizzoti", gxTv_SdtPais_Paivizzoti, false, includeNonInitialized);
      AddObjectProperty("PaiMinMesesVac", gxTv_SdtPais_Paiminmesesvac, false, includeNonInitialized);
      AddObjectProperty("PaiInterDiasJor", gxTv_SdtPais_Paiinterdiasjor, false, includeNonInitialized);
      AddObjectProperty("PaiTipoExpDef", gxTv_SdtPais_Paitipoexpdef, false, includeNonInitialized);
      if ( gxTv_SdtPais_Vacaciones != null )
      {
         AddObjectProperty("Vacaciones", gxTv_SdtPais_Vacaciones, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiCod_Z", gxTv_SdtPais_Paicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiNom_Z", gxTv_SdtPais_Painom_Z, false, includeNonInitialized);
         AddObjectProperty("PaiNacMostrar_Z", gxTv_SdtPais_Painacmostrar_Z, false, includeNonInitialized);
         AddObjectProperty("PaiDomMostrar_Z", gxTv_SdtPais_Paidommostrar_Z, false, includeNonInitialized);
         AddObjectProperty("PaiReligDefault_Z", gxTv_SdtPais_Paireligdefault_Z, false, includeNonInitialized);
         AddObjectProperty("PaiMesHsPExt_Z", gxTv_SdtPais_Paimeshspext_Z, false, includeNonInitialized);
         AddObjectProperty("PaiDiaHsPExt_Z", gxTv_SdtPais_Paidiahspext_Z, false, includeNonInitialized);
         AddObjectProperty("PaiFondoCese_Z", gxTv_SdtPais_Paifondocese_Z, false, includeNonInitialized);
         AddObjectProperty("PaiMaxHorNor_Z", gxTv_SdtPais_Paimaxhornor_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPerVacDes_Z", gxTv_SdtPais_Paipervacdes_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPerVacHas_Z", gxTv_SdtPais_Paipervachas_Z, false, includeNonInitialized);
         AddObjectProperty("PaiFracVacAnt_Z", gxTv_SdtPais_Paifracvacant_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPromMeses_Z", gxTv_SdtPais_Paiprommeses_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPromMesTCnt_Z", gxTv_SdtPais_Paiprommestcnt_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPromJorMeses_Z", gxTv_SdtPais_Paipromjormeses_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPromJorMesTCnt_Z", gxTv_SdtPais_Paipromjormestcnt_Z, false, includeNonInitialized);
         AddObjectProperty("PaiGuarEdadMin_Z", gxTv_SdtPais_Paiguaredadmin_Z, false, includeNonInitialized);
         AddObjectProperty("PaiGuarEdadMax_Z", gxTv_SdtPais_Paiguaredadmax_Z, false, includeNonInitialized);
         AddObjectProperty("PaiExcVizzoti_Z", gxTv_SdtPais_Paiexcvizzoti_Z, false, includeNonInitialized);
         AddObjectProperty("PaiVizzoti_Z", gxTv_SdtPais_Paivizzoti_Z, false, includeNonInitialized);
         AddObjectProperty("PaiMinMesesVac_Z", gxTv_SdtPais_Paiminmesesvac_Z, false, includeNonInitialized);
         AddObjectProperty("PaiInterDiasJor_Z", gxTv_SdtPais_Paiinterdiasjor_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoExpDef_Z", gxTv_SdtPais_Paitipoexpdef_Z, false, includeNonInitialized);
         AddObjectProperty("PaiReligDefault_N", gxTv_SdtPais_Paireligdefault_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais sdt )
   {
      if ( sdt.IsDirty("PaiCod") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paicod = sdt.getgxTv_SdtPais_Paicod() ;
      }
      if ( sdt.IsDirty("PaiNom") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Painom = sdt.getgxTv_SdtPais_Painom() ;
      }
      if ( sdt.IsDirty("PaiNacMostrar") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Painacmostrar = sdt.getgxTv_SdtPais_Painacmostrar() ;
      }
      if ( sdt.IsDirty("PaiDomMostrar") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paidommostrar = sdt.getgxTv_SdtPais_Paidommostrar() ;
      }
      if ( sdt.IsDirty("PaiReligDefault") )
      {
         gxTv_SdtPais_Paireligdefault_N = sdt.getgxTv_SdtPais_Paireligdefault_N() ;
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paireligdefault = sdt.getgxTv_SdtPais_Paireligdefault() ;
      }
      if ( sdt.IsDirty("PaiMesHsPExt") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paimeshspext = sdt.getgxTv_SdtPais_Paimeshspext() ;
      }
      if ( sdt.IsDirty("PaiDiaHsPExt") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paidiahspext = sdt.getgxTv_SdtPais_Paidiahspext() ;
      }
      if ( sdt.IsDirty("PaiFondoCese") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paifondocese = sdt.getgxTv_SdtPais_Paifondocese() ;
      }
      if ( sdt.IsDirty("PaiMaxHorNor") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paimaxhornor = sdt.getgxTv_SdtPais_Paimaxhornor() ;
      }
      if ( sdt.IsDirty("PaiPerVacDes") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paipervacdes = sdt.getgxTv_SdtPais_Paipervacdes() ;
      }
      if ( sdt.IsDirty("PaiPerVacHas") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paipervachas = sdt.getgxTv_SdtPais_Paipervachas() ;
      }
      if ( sdt.IsDirty("PaiFracVacAnt") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paifracvacant = sdt.getgxTv_SdtPais_Paifracvacant() ;
      }
      if ( gxTv_SdtPais_Preaviso != null )
      {
         GXBCLevelCollection<web.SdtPais_preaviso> newCollectionPreaviso = sdt.getgxTv_SdtPais_Preaviso();
         web.SdtPais_preaviso currItemPreaviso;
         web.SdtPais_preaviso newItemPreaviso;
         short idx = 1;
         while ( idx <= newCollectionPreaviso.size() )
         {
            newItemPreaviso = (web.SdtPais_preaviso)((web.SdtPais_preaviso)newCollectionPreaviso.elementAt(-1+idx));
            currItemPreaviso = (web.SdtPais_preaviso)gxTv_SdtPais_Preaviso.getByKey(newItemPreaviso.getgxTv_SdtPais_preaviso_Paiantmaycant(), newItemPreaviso.getgxTv_SdtPais_preaviso_Paiantmaydur());
            if ( GXutil.strcmp(currItemPreaviso.getgxTv_SdtPais_preaviso_Mode(), "UPD") == 0 )
            {
               currItemPreaviso.updateDirties(newItemPreaviso);
               if ( GXutil.strcmp(newItemPreaviso.getgxTv_SdtPais_preaviso_Mode(), "DLT") == 0 )
               {
                  currItemPreaviso.setgxTv_SdtPais_preaviso_Mode( "DLT" );
               }
               currItemPreaviso.setgxTv_SdtPais_preaviso_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Preaviso.add(newItemPreaviso, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtPais_Base_calculo != null )
      {
         GXBCLevelCollection<web.SdtPais_base_calculo> newCollectionBase_calculo = sdt.getgxTv_SdtPais_Base_calculo();
         web.SdtPais_base_calculo currItemBase_calculo;
         web.SdtPais_base_calculo newItemBase_calculo;
         short idx = 1;
         while ( idx <= newCollectionBase_calculo.size() )
         {
            newItemBase_calculo = (web.SdtPais_base_calculo)((web.SdtPais_base_calculo)newCollectionBase_calculo.elementAt(-1+idx));
            currItemBase_calculo = (web.SdtPais_base_calculo)gxTv_SdtPais_Base_calculo.getByKey(newItemBase_calculo.getgxTv_SdtPais_base_calculo_Paibaseclaseleg(), newItemBase_calculo.getgxTv_SdtPais_base_calculo_Paibasetipo(), newItemBase_calculo.getgxTv_SdtPais_base_calculo_Paibasecod1(), newItemBase_calculo.getgxTv_SdtPais_base_calculo_Paibasecod2());
            if ( GXutil.strcmp(currItemBase_calculo.getgxTv_SdtPais_base_calculo_Mode(), "UPD") == 0 )
            {
               currItemBase_calculo.updateDirties(newItemBase_calculo);
               if ( GXutil.strcmp(newItemBase_calculo.getgxTv_SdtPais_base_calculo_Mode(), "DLT") == 0 )
               {
                  currItemBase_calculo.setgxTv_SdtPais_base_calculo_Mode( "DLT" );
               }
               currItemBase_calculo.setgxTv_SdtPais_base_calculo_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Base_calculo.add(newItemBase_calculo, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados != null )
      {
         GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> newCollectionConceptos_horanormal_jornalizados = sdt.getgxTv_SdtPais_Conceptos_horanormal_jornalizados();
         web.SdtPais_conceptos_horanormal_jornalizados currItemConceptos_horanormal_jornalizados;
         web.SdtPais_conceptos_horanormal_jornalizados newItemConceptos_horanormal_jornalizados;
         short idx = 1;
         while ( idx <= newCollectionConceptos_horanormal_jornalizados.size() )
         {
            newItemConceptos_horanormal_jornalizados = (web.SdtPais_conceptos_horanormal_jornalizados)((web.SdtPais_conceptos_horanormal_jornalizados)newCollectionConceptos_horanormal_jornalizados.elementAt(-1+idx));
            currItemConceptos_horanormal_jornalizados = (web.SdtPais_conceptos_horanormal_jornalizados)gxTv_SdtPais_Conceptos_horanormal_jornalizados.getByKey(newItemConceptos_horanormal_jornalizados.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod(), newItemConceptos_horanormal_jornalizados.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo());
            if ( GXutil.strcmp(currItemConceptos_horanormal_jornalizados.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode(), "UPD") == 0 )
            {
               currItemConceptos_horanormal_jornalizados.updateDirties(newItemConceptos_horanormal_jornalizados);
               if ( GXutil.strcmp(newItemConceptos_horanormal_jornalizados.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode(), "DLT") == 0 )
               {
                  currItemConceptos_horanormal_jornalizados.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode( "DLT" );
               }
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Conceptos_horanormal_jornalizados.add(newItemConceptos_horanormal_jornalizados, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados != null )
      {
         GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> newCollectionConceptos_horanormal_mensualizados = sdt.getgxTv_SdtPais_Conceptos_horanormal_mensualizados();
         web.SdtPais_conceptos_horanormal_mensualizados currItemConceptos_horanormal_mensualizados;
         web.SdtPais_conceptos_horanormal_mensualizados newItemConceptos_horanormal_mensualizados;
         short idx = 1;
         while ( idx <= newCollectionConceptos_horanormal_mensualizados.size() )
         {
            newItemConceptos_horanormal_mensualizados = (web.SdtPais_conceptos_horanormal_mensualizados)((web.SdtPais_conceptos_horanormal_mensualizados)newCollectionConceptos_horanormal_mensualizados.elementAt(-1+idx));
            currItemConceptos_horanormal_mensualizados = (web.SdtPais_conceptos_horanormal_mensualizados)gxTv_SdtPais_Conceptos_horanormal_mensualizados.getByKey(newItemConceptos_horanormal_mensualizados.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod(), newItemConceptos_horanormal_mensualizados.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo());
            if ( GXutil.strcmp(currItemConceptos_horanormal_mensualizados.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode(), "UPD") == 0 )
            {
               currItemConceptos_horanormal_mensualizados.updateDirties(newItemConceptos_horanormal_mensualizados);
               if ( GXutil.strcmp(newItemConceptos_horanormal_mensualizados.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode(), "DLT") == 0 )
               {
                  currItemConceptos_horanormal_mensualizados.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode( "DLT" );
               }
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Conceptos_horanormal_mensualizados.add(newItemConceptos_horanormal_mensualizados, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("PaiPromMeses") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiprommeses = sdt.getgxTv_SdtPais_Paiprommeses() ;
      }
      if ( sdt.IsDirty("PaiPromMesTCnt") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiprommestcnt = sdt.getgxTv_SdtPais_Paiprommestcnt() ;
      }
      if ( sdt.IsDirty("PaiPromJorMeses") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paipromjormeses = sdt.getgxTv_SdtPais_Paipromjormeses() ;
      }
      if ( sdt.IsDirty("PaiPromJorMesTCnt") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paipromjormestcnt = sdt.getgxTv_SdtPais_Paipromjormestcnt() ;
      }
      if ( gxTv_SdtPais_Promedio_horanormal_mensualizados != null )
      {
         GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> newCollectionPromedio_horanormal_mensualizados = sdt.getgxTv_SdtPais_Promedio_horanormal_mensualizados();
         web.SdtPais_promedio_horanormal_mensualizados currItemPromedio_horanormal_mensualizados;
         web.SdtPais_promedio_horanormal_mensualizados newItemPromedio_horanormal_mensualizados;
         short idx = 1;
         while ( idx <= newCollectionPromedio_horanormal_mensualizados.size() )
         {
            newItemPromedio_horanormal_mensualizados = (web.SdtPais_promedio_horanormal_mensualizados)((web.SdtPais_promedio_horanormal_mensualizados)newCollectionPromedio_horanormal_mensualizados.elementAt(-1+idx));
            currItemPromedio_horanormal_mensualizados = (web.SdtPais_promedio_horanormal_mensualizados)gxTv_SdtPais_Promedio_horanormal_mensualizados.getByKey(newItemPromedio_horanormal_mensualizados.getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod(), newItemPromedio_horanormal_mensualizados.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar());
            if ( GXutil.strcmp(currItemPromedio_horanormal_mensualizados.getgxTv_SdtPais_promedio_horanormal_mensualizados_Mode(), "UPD") == 0 )
            {
               currItemPromedio_horanormal_mensualizados.updateDirties(newItemPromedio_horanormal_mensualizados);
               if ( GXutil.strcmp(newItemPromedio_horanormal_mensualizados.getgxTv_SdtPais_promedio_horanormal_mensualizados_Mode(), "DLT") == 0 )
               {
                  currItemPromedio_horanormal_mensualizados.setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode( "DLT" );
               }
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Promedio_horanormal_mensualizados.add(newItemPromedio_horanormal_mensualizados, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtPais_Tipo_trabajo != null )
      {
         GXBCLevelCollection<web.SdtPais_tipo_trabajo> newCollectionTipo_trabajo = sdt.getgxTv_SdtPais_Tipo_trabajo();
         web.SdtPais_tipo_trabajo currItemTipo_trabajo;
         web.SdtPais_tipo_trabajo newItemTipo_trabajo;
         short idx = 1;
         while ( idx <= newCollectionTipo_trabajo.size() )
         {
            newItemTipo_trabajo = (web.SdtPais_tipo_trabajo)((web.SdtPais_tipo_trabajo)newCollectionTipo_trabajo.elementAt(-1+idx));
            currItemTipo_trabajo = (web.SdtPais_tipo_trabajo)gxTv_SdtPais_Tipo_trabajo.getByKey(newItemTipo_trabajo.getgxTv_SdtPais_tipo_trabajo_Paitipotraid());
            if ( GXutil.strcmp(currItemTipo_trabajo.getgxTv_SdtPais_tipo_trabajo_Mode(), "UPD") == 0 )
            {
               currItemTipo_trabajo.updateDirties(newItemTipo_trabajo);
               if ( GXutil.strcmp(newItemTipo_trabajo.getgxTv_SdtPais_tipo_trabajo_Mode(), "DLT") == 0 )
               {
                  currItemTipo_trabajo.setgxTv_SdtPais_tipo_trabajo_Mode( "DLT" );
               }
               currItemTipo_trabajo.setgxTv_SdtPais_tipo_trabajo_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Tipo_trabajo.add(newItemTipo_trabajo, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtPais_Horasextras_pordia != null )
      {
         GXBCLevelCollection<web.SdtPais_horasextras_pordia> newCollectionHorasextras_pordia = sdt.getgxTv_SdtPais_Horasextras_pordia();
         web.SdtPais_horasextras_pordia currItemHorasextras_pordia;
         web.SdtPais_horasextras_pordia newItemHorasextras_pordia;
         short idx = 1;
         while ( idx <= newCollectionHorasextras_pordia.size() )
         {
            newItemHorasextras_pordia = (web.SdtPais_horasextras_pordia)((web.SdtPais_horasextras_pordia)newCollectionHorasextras_pordia.elementAt(-1+idx));
            currItemHorasextras_pordia = (web.SdtPais_horasextras_pordia)gxTv_SdtPais_Horasextras_pordia.getByKey(newItemHorasextras_pordia.getgxTv_SdtPais_horasextras_pordia_Paihsexsec());
            if ( GXutil.strcmp(currItemHorasextras_pordia.getgxTv_SdtPais_horasextras_pordia_Mode(), "UPD") == 0 )
            {
               currItemHorasextras_pordia.updateDirties(newItemHorasextras_pordia);
               if ( GXutil.strcmp(newItemHorasextras_pordia.getgxTv_SdtPais_horasextras_pordia_Mode(), "DLT") == 0 )
               {
                  currItemHorasextras_pordia.setgxTv_SdtPais_horasextras_pordia_Mode( "DLT" );
               }
               currItemHorasextras_pordia.setgxTv_SdtPais_horasextras_pordia_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Horasextras_pordia.add(newItemHorasextras_pordia, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("PaiGuarEdadMin") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiguaredadmin = sdt.getgxTv_SdtPais_Paiguaredadmin() ;
      }
      if ( sdt.IsDirty("PaiGuarEdadMax") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiguaredadmax = sdt.getgxTv_SdtPais_Paiguaredadmax() ;
      }
      if ( sdt.IsDirty("PaiExcVizzoti") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiexcvizzoti = sdt.getgxTv_SdtPais_Paiexcvizzoti() ;
      }
      if ( sdt.IsDirty("PaiVizzoti") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paivizzoti = sdt.getgxTv_SdtPais_Paivizzoti() ;
      }
      if ( sdt.IsDirty("PaiMinMesesVac") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiminmesesvac = sdt.getgxTv_SdtPais_Paiminmesesvac() ;
      }
      if ( sdt.IsDirty("PaiInterDiasJor") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paiinterdiasjor = sdt.getgxTv_SdtPais_Paiinterdiasjor() ;
      }
      if ( sdt.IsDirty("PaiTipoExpDef") )
      {
         gxTv_SdtPais_N = (byte)(0) ;
         gxTv_SdtPais_Paitipoexpdef = sdt.getgxTv_SdtPais_Paitipoexpdef() ;
      }
      if ( gxTv_SdtPais_Vacaciones != null )
      {
         GXBCLevelCollection<web.SdtPais_Vacaciones> newCollectionVacaciones = sdt.getgxTv_SdtPais_Vacaciones();
         web.SdtPais_Vacaciones currItemVacaciones;
         web.SdtPais_Vacaciones newItemVacaciones;
         short idx = 1;
         while ( idx <= newCollectionVacaciones.size() )
         {
            newItemVacaciones = (web.SdtPais_Vacaciones)((web.SdtPais_Vacaciones)newCollectionVacaciones.elementAt(-1+idx));
            currItemVacaciones = (web.SdtPais_Vacaciones)gxTv_SdtPais_Vacaciones.getByKey(newItemVacaciones.getgxTv_SdtPais_Vacaciones_Paivacdesant());
            if ( GXutil.strcmp(currItemVacaciones.getgxTv_SdtPais_Vacaciones_Mode(), "UPD") == 0 )
            {
               currItemVacaciones.updateDirties(newItemVacaciones);
               if ( GXutil.strcmp(newItemVacaciones.getgxTv_SdtPais_Vacaciones_Mode(), "DLT") == 0 )
               {
                  currItemVacaciones.setgxTv_SdtPais_Vacaciones_Mode( "DLT" );
               }
               currItemVacaciones.setgxTv_SdtPais_Vacaciones_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtPais_Vacaciones.add(newItemVacaciones, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtPais_Paicod( )
   {
      return gxTv_SdtPais_Paicod ;
   }

   public void setgxTv_SdtPais_Paicod( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      if ( gxTv_SdtPais_Paicod != value )
      {
         gxTv_SdtPais_Mode = "INS" ;
         this.setgxTv_SdtPais_Paicod_Z_SetNull( );
         this.setgxTv_SdtPais_Painom_Z_SetNull( );
         this.setgxTv_SdtPais_Painacmostrar_Z_SetNull( );
         this.setgxTv_SdtPais_Paidommostrar_Z_SetNull( );
         this.setgxTv_SdtPais_Paireligdefault_Z_SetNull( );
         this.setgxTv_SdtPais_Paimeshspext_Z_SetNull( );
         this.setgxTv_SdtPais_Paidiahspext_Z_SetNull( );
         this.setgxTv_SdtPais_Paifondocese_Z_SetNull( );
         this.setgxTv_SdtPais_Paimaxhornor_Z_SetNull( );
         this.setgxTv_SdtPais_Paipervacdes_Z_SetNull( );
         this.setgxTv_SdtPais_Paipervachas_Z_SetNull( );
         this.setgxTv_SdtPais_Paifracvacant_Z_SetNull( );
         this.setgxTv_SdtPais_Paiprommeses_Z_SetNull( );
         this.setgxTv_SdtPais_Paiprommestcnt_Z_SetNull( );
         this.setgxTv_SdtPais_Paipromjormeses_Z_SetNull( );
         this.setgxTv_SdtPais_Paipromjormestcnt_Z_SetNull( );
         this.setgxTv_SdtPais_Paiguaredadmin_Z_SetNull( );
         this.setgxTv_SdtPais_Paiguaredadmax_Z_SetNull( );
         this.setgxTv_SdtPais_Paiexcvizzoti_Z_SetNull( );
         this.setgxTv_SdtPais_Paivizzoti_Z_SetNull( );
         this.setgxTv_SdtPais_Paiminmesesvac_Z_SetNull( );
         this.setgxTv_SdtPais_Paiinterdiasjor_Z_SetNull( );
         this.setgxTv_SdtPais_Paitipoexpdef_Z_SetNull( );
         if ( gxTv_SdtPais_Preaviso != null )
         {
            GXBCLevelCollection<web.SdtPais_preaviso> collectionPreaviso = gxTv_SdtPais_Preaviso;
            web.SdtPais_preaviso currItemPreaviso;
            short idx = 1;
            while ( idx <= collectionPreaviso.size() )
            {
               currItemPreaviso = (web.SdtPais_preaviso)((web.SdtPais_preaviso)collectionPreaviso.elementAt(-1+idx));
               currItemPreaviso.setgxTv_SdtPais_preaviso_Mode( "INS" );
               currItemPreaviso.setgxTv_SdtPais_preaviso_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Base_calculo != null )
         {
            GXBCLevelCollection<web.SdtPais_base_calculo> collectionBase_calculo = gxTv_SdtPais_Base_calculo;
            web.SdtPais_base_calculo currItemBase_calculo;
            short idx = 1;
            while ( idx <= collectionBase_calculo.size() )
            {
               currItemBase_calculo = (web.SdtPais_base_calculo)((web.SdtPais_base_calculo)collectionBase_calculo.elementAt(-1+idx));
               currItemBase_calculo.setgxTv_SdtPais_base_calculo_Mode( "INS" );
               currItemBase_calculo.setgxTv_SdtPais_base_calculo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados != null )
         {
            GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> collectionConceptos_horanormal_jornalizados = gxTv_SdtPais_Conceptos_horanormal_jornalizados;
            web.SdtPais_conceptos_horanormal_jornalizados currItemConceptos_horanormal_jornalizados;
            short idx = 1;
            while ( idx <= collectionConceptos_horanormal_jornalizados.size() )
            {
               currItemConceptos_horanormal_jornalizados = (web.SdtPais_conceptos_horanormal_jornalizados)((web.SdtPais_conceptos_horanormal_jornalizados)collectionConceptos_horanormal_jornalizados.elementAt(-1+idx));
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode( "INS" );
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados != null )
         {
            GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> collectionConceptos_horanormal_mensualizados = gxTv_SdtPais_Conceptos_horanormal_mensualizados;
            web.SdtPais_conceptos_horanormal_mensualizados currItemConceptos_horanormal_mensualizados;
            short idx = 1;
            while ( idx <= collectionConceptos_horanormal_mensualizados.size() )
            {
               currItemConceptos_horanormal_mensualizados = (web.SdtPais_conceptos_horanormal_mensualizados)((web.SdtPais_conceptos_horanormal_mensualizados)collectionConceptos_horanormal_mensualizados.elementAt(-1+idx));
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode( "INS" );
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Promedio_horanormal_mensualizados != null )
         {
            GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> collectionPromedio_horanormal_mensualizados = gxTv_SdtPais_Promedio_horanormal_mensualizados;
            web.SdtPais_promedio_horanormal_mensualizados currItemPromedio_horanormal_mensualizados;
            short idx = 1;
            while ( idx <= collectionPromedio_horanormal_mensualizados.size() )
            {
               currItemPromedio_horanormal_mensualizados = (web.SdtPais_promedio_horanormal_mensualizados)((web.SdtPais_promedio_horanormal_mensualizados)collectionPromedio_horanormal_mensualizados.elementAt(-1+idx));
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode( "INS" );
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Tipo_trabajo != null )
         {
            GXBCLevelCollection<web.SdtPais_tipo_trabajo> collectionTipo_trabajo = gxTv_SdtPais_Tipo_trabajo;
            web.SdtPais_tipo_trabajo currItemTipo_trabajo;
            short idx = 1;
            while ( idx <= collectionTipo_trabajo.size() )
            {
               currItemTipo_trabajo = (web.SdtPais_tipo_trabajo)((web.SdtPais_tipo_trabajo)collectionTipo_trabajo.elementAt(-1+idx));
               currItemTipo_trabajo.setgxTv_SdtPais_tipo_trabajo_Mode( "INS" );
               currItemTipo_trabajo.setgxTv_SdtPais_tipo_trabajo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Horasextras_pordia != null )
         {
            GXBCLevelCollection<web.SdtPais_horasextras_pordia> collectionHorasextras_pordia = gxTv_SdtPais_Horasextras_pordia;
            web.SdtPais_horasextras_pordia currItemHorasextras_pordia;
            short idx = 1;
            while ( idx <= collectionHorasextras_pordia.size() )
            {
               currItemHorasextras_pordia = (web.SdtPais_horasextras_pordia)((web.SdtPais_horasextras_pordia)collectionHorasextras_pordia.elementAt(-1+idx));
               currItemHorasextras_pordia.setgxTv_SdtPais_horasextras_pordia_Mode( "INS" );
               currItemHorasextras_pordia.setgxTv_SdtPais_horasextras_pordia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtPais_Vacaciones != null )
         {
            GXBCLevelCollection<web.SdtPais_Vacaciones> collectionVacaciones = gxTv_SdtPais_Vacaciones;
            web.SdtPais_Vacaciones currItemVacaciones;
            short idx = 1;
            while ( idx <= collectionVacaciones.size() )
            {
               currItemVacaciones = (web.SdtPais_Vacaciones)((web.SdtPais_Vacaciones)collectionVacaciones.elementAt(-1+idx));
               currItemVacaciones.setgxTv_SdtPais_Vacaciones_Mode( "INS" );
               currItemVacaciones.setgxTv_SdtPais_Vacaciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Paicod");
      gxTv_SdtPais_Paicod = value ;
   }

   public String getgxTv_SdtPais_Painom( )
   {
      return gxTv_SdtPais_Painom ;
   }

   public void setgxTv_SdtPais_Painom( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Painom");
      gxTv_SdtPais_Painom = value ;
   }

   public boolean getgxTv_SdtPais_Painacmostrar( )
   {
      return gxTv_SdtPais_Painacmostrar ;
   }

   public void setgxTv_SdtPais_Painacmostrar( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Painacmostrar");
      gxTv_SdtPais_Painacmostrar = value ;
   }

   public boolean getgxTv_SdtPais_Paidommostrar( )
   {
      return gxTv_SdtPais_Paidommostrar ;
   }

   public void setgxTv_SdtPais_Paidommostrar( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paidommostrar");
      gxTv_SdtPais_Paidommostrar = value ;
   }

   public String getgxTv_SdtPais_Paireligdefault( )
   {
      return gxTv_SdtPais_Paireligdefault ;
   }

   public void setgxTv_SdtPais_Paireligdefault( String value )
   {
      gxTv_SdtPais_Paireligdefault_N = (byte)(0) ;
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paireligdefault");
      gxTv_SdtPais_Paireligdefault = value ;
   }

   public void setgxTv_SdtPais_Paireligdefault_SetNull( )
   {
      gxTv_SdtPais_Paireligdefault_N = (byte)(1) ;
      gxTv_SdtPais_Paireligdefault = "" ;
      SetDirty("Paireligdefault");
   }

   public boolean getgxTv_SdtPais_Paireligdefault_IsNull( )
   {
      return (gxTv_SdtPais_Paireligdefault_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paimeshspext( )
   {
      return gxTv_SdtPais_Paimeshspext ;
   }

   public void setgxTv_SdtPais_Paimeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paimeshspext");
      gxTv_SdtPais_Paimeshspext = value ;
   }

   public String getgxTv_SdtPais_Paidiahspext( )
   {
      return gxTv_SdtPais_Paidiahspext ;
   }

   public void setgxTv_SdtPais_Paidiahspext( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paidiahspext");
      gxTv_SdtPais_Paidiahspext = value ;
   }

   public boolean getgxTv_SdtPais_Paifondocese( )
   {
      return gxTv_SdtPais_Paifondocese ;
   }

   public void setgxTv_SdtPais_Paifondocese( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paifondocese");
      gxTv_SdtPais_Paifondocese = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paimaxhornor( )
   {
      return gxTv_SdtPais_Paimaxhornor ;
   }

   public void setgxTv_SdtPais_Paimaxhornor( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paimaxhornor");
      gxTv_SdtPais_Paimaxhornor = value ;
   }

   public byte getgxTv_SdtPais_Paipervacdes( )
   {
      return gxTv_SdtPais_Paipervacdes ;
   }

   public void setgxTv_SdtPais_Paipervacdes( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipervacdes");
      gxTv_SdtPais_Paipervacdes = value ;
   }

   public byte getgxTv_SdtPais_Paipervachas( )
   {
      return gxTv_SdtPais_Paipervachas ;
   }

   public void setgxTv_SdtPais_Paipervachas( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipervachas");
      gxTv_SdtPais_Paipervachas = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paifracvacant( )
   {
      return gxTv_SdtPais_Paifracvacant ;
   }

   public void setgxTv_SdtPais_Paifracvacant( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paifracvacant");
      gxTv_SdtPais_Paifracvacant = value ;
   }

   public GXBCLevelCollection<web.SdtPais_preaviso> getgxTv_SdtPais_Preaviso( )
   {
      if ( gxTv_SdtPais_Preaviso == null )
      {
         gxTv_SdtPais_Preaviso = new GXBCLevelCollection<web.SdtPais_preaviso>(web.SdtPais_preaviso.class, "Pais.preaviso", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Preaviso ;
   }

   public void setgxTv_SdtPais_Preaviso( GXBCLevelCollection<web.SdtPais_preaviso> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Preaviso");
      gxTv_SdtPais_Preaviso = value ;
   }

   public void setgxTv_SdtPais_Preaviso_SetNull( )
   {
      gxTv_SdtPais_Preaviso = null ;
      SetDirty("Preaviso");
   }

   public boolean getgxTv_SdtPais_Preaviso_IsNull( )
   {
      if ( gxTv_SdtPais_Preaviso == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtPais_base_calculo> getgxTv_SdtPais_Base_calculo( )
   {
      if ( gxTv_SdtPais_Base_calculo == null )
      {
         gxTv_SdtPais_Base_calculo = new GXBCLevelCollection<web.SdtPais_base_calculo>(web.SdtPais_base_calculo.class, "Pais.base_calculo", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Base_calculo ;
   }

   public void setgxTv_SdtPais_Base_calculo( GXBCLevelCollection<web.SdtPais_base_calculo> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Base_calculo");
      gxTv_SdtPais_Base_calculo = value ;
   }

   public void setgxTv_SdtPais_Base_calculo_SetNull( )
   {
      gxTv_SdtPais_Base_calculo = null ;
      SetDirty("Base_calculo");
   }

   public boolean getgxTv_SdtPais_Base_calculo_IsNull( )
   {
      if ( gxTv_SdtPais_Base_calculo == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> getgxTv_SdtPais_Conceptos_horanormal_jornalizados( )
   {
      if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados == null )
      {
         gxTv_SdtPais_Conceptos_horanormal_jornalizados = new GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados>(web.SdtPais_conceptos_horanormal_jornalizados.class, "Pais.conceptos_horanormal_jornalizados", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Conceptos_horanormal_jornalizados ;
   }

   public void setgxTv_SdtPais_Conceptos_horanormal_jornalizados( GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Conceptos_horanormal_jornalizados");
      gxTv_SdtPais_Conceptos_horanormal_jornalizados = value ;
   }

   public void setgxTv_SdtPais_Conceptos_horanormal_jornalizados_SetNull( )
   {
      gxTv_SdtPais_Conceptos_horanormal_jornalizados = null ;
      SetDirty("Conceptos_horanormal_jornalizados");
   }

   public boolean getgxTv_SdtPais_Conceptos_horanormal_jornalizados_IsNull( )
   {
      if ( gxTv_SdtPais_Conceptos_horanormal_jornalizados == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> getgxTv_SdtPais_Conceptos_horanormal_mensualizados( )
   {
      if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados == null )
      {
         gxTv_SdtPais_Conceptos_horanormal_mensualizados = new GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados>(web.SdtPais_conceptos_horanormal_mensualizados.class, "Pais.conceptos_horanormal_mensualizados", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Conceptos_horanormal_mensualizados ;
   }

   public void setgxTv_SdtPais_Conceptos_horanormal_mensualizados( GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Conceptos_horanormal_mensualizados");
      gxTv_SdtPais_Conceptos_horanormal_mensualizados = value ;
   }

   public void setgxTv_SdtPais_Conceptos_horanormal_mensualizados_SetNull( )
   {
      gxTv_SdtPais_Conceptos_horanormal_mensualizados = null ;
      SetDirty("Conceptos_horanormal_mensualizados");
   }

   public boolean getgxTv_SdtPais_Conceptos_horanormal_mensualizados_IsNull( )
   {
      if ( gxTv_SdtPais_Conceptos_horanormal_mensualizados == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtPais_Paiprommeses( )
   {
      return gxTv_SdtPais_Paiprommeses ;
   }

   public void setgxTv_SdtPais_Paiprommeses( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiprommeses");
      gxTv_SdtPais_Paiprommeses = value ;
   }

   public String getgxTv_SdtPais_Paiprommestcnt( )
   {
      return gxTv_SdtPais_Paiprommestcnt ;
   }

   public void setgxTv_SdtPais_Paiprommestcnt( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiprommestcnt");
      gxTv_SdtPais_Paiprommestcnt = value ;
   }

   public byte getgxTv_SdtPais_Paipromjormeses( )
   {
      return gxTv_SdtPais_Paipromjormeses ;
   }

   public void setgxTv_SdtPais_Paipromjormeses( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipromjormeses");
      gxTv_SdtPais_Paipromjormeses = value ;
   }

   public String getgxTv_SdtPais_Paipromjormestcnt( )
   {
      return gxTv_SdtPais_Paipromjormestcnt ;
   }

   public void setgxTv_SdtPais_Paipromjormestcnt( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipromjormestcnt");
      gxTv_SdtPais_Paipromjormestcnt = value ;
   }

   public GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> getgxTv_SdtPais_Promedio_horanormal_mensualizados( )
   {
      if ( gxTv_SdtPais_Promedio_horanormal_mensualizados == null )
      {
         gxTv_SdtPais_Promedio_horanormal_mensualizados = new GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados>(web.SdtPais_promedio_horanormal_mensualizados.class, "Pais.promedio_horanormal_mensualizados", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Promedio_horanormal_mensualizados ;
   }

   public void setgxTv_SdtPais_Promedio_horanormal_mensualizados( GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Promedio_horanormal_mensualizados");
      gxTv_SdtPais_Promedio_horanormal_mensualizados = value ;
   }

   public void setgxTv_SdtPais_Promedio_horanormal_mensualizados_SetNull( )
   {
      gxTv_SdtPais_Promedio_horanormal_mensualizados = null ;
      SetDirty("Promedio_horanormal_mensualizados");
   }

   public boolean getgxTv_SdtPais_Promedio_horanormal_mensualizados_IsNull( )
   {
      if ( gxTv_SdtPais_Promedio_horanormal_mensualizados == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtPais_tipo_trabajo> getgxTv_SdtPais_Tipo_trabajo( )
   {
      if ( gxTv_SdtPais_Tipo_trabajo == null )
      {
         gxTv_SdtPais_Tipo_trabajo = new GXBCLevelCollection<web.SdtPais_tipo_trabajo>(web.SdtPais_tipo_trabajo.class, "Pais.tipo_trabajo", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Tipo_trabajo ;
   }

   public void setgxTv_SdtPais_Tipo_trabajo( GXBCLevelCollection<web.SdtPais_tipo_trabajo> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Tipo_trabajo");
      gxTv_SdtPais_Tipo_trabajo = value ;
   }

   public void setgxTv_SdtPais_Tipo_trabajo_SetNull( )
   {
      gxTv_SdtPais_Tipo_trabajo = null ;
      SetDirty("Tipo_trabajo");
   }

   public boolean getgxTv_SdtPais_Tipo_trabajo_IsNull( )
   {
      if ( gxTv_SdtPais_Tipo_trabajo == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtPais_horasextras_pordia> getgxTv_SdtPais_Horasextras_pordia( )
   {
      if ( gxTv_SdtPais_Horasextras_pordia == null )
      {
         gxTv_SdtPais_Horasextras_pordia = new GXBCLevelCollection<web.SdtPais_horasextras_pordia>(web.SdtPais_horasextras_pordia.class, "Pais.horasextras_pordia", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Horasextras_pordia ;
   }

   public void setgxTv_SdtPais_Horasextras_pordia( GXBCLevelCollection<web.SdtPais_horasextras_pordia> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Horasextras_pordia");
      gxTv_SdtPais_Horasextras_pordia = value ;
   }

   public void setgxTv_SdtPais_Horasextras_pordia_SetNull( )
   {
      gxTv_SdtPais_Horasextras_pordia = null ;
      SetDirty("Horasextras_pordia");
   }

   public boolean getgxTv_SdtPais_Horasextras_pordia_IsNull( )
   {
      if ( gxTv_SdtPais_Horasextras_pordia == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtPais_Paiguaredadmin( )
   {
      return gxTv_SdtPais_Paiguaredadmin ;
   }

   public void setgxTv_SdtPais_Paiguaredadmin( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiguaredadmin");
      gxTv_SdtPais_Paiguaredadmin = value ;
   }

   public byte getgxTv_SdtPais_Paiguaredadmax( )
   {
      return gxTv_SdtPais_Paiguaredadmax ;
   }

   public void setgxTv_SdtPais_Paiguaredadmax( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiguaredadmax");
      gxTv_SdtPais_Paiguaredadmax = value ;
   }

   public boolean getgxTv_SdtPais_Paiexcvizzoti( )
   {
      return gxTv_SdtPais_Paiexcvizzoti ;
   }

   public void setgxTv_SdtPais_Paiexcvizzoti( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiexcvizzoti");
      gxTv_SdtPais_Paiexcvizzoti = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paivizzoti( )
   {
      return gxTv_SdtPais_Paivizzoti ;
   }

   public void setgxTv_SdtPais_Paivizzoti( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paivizzoti");
      gxTv_SdtPais_Paivizzoti = value ;
   }

   public byte getgxTv_SdtPais_Paiminmesesvac( )
   {
      return gxTv_SdtPais_Paiminmesesvac ;
   }

   public void setgxTv_SdtPais_Paiminmesesvac( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiminmesesvac");
      gxTv_SdtPais_Paiminmesesvac = value ;
   }

   public short getgxTv_SdtPais_Paiinterdiasjor( )
   {
      return gxTv_SdtPais_Paiinterdiasjor ;
   }

   public void setgxTv_SdtPais_Paiinterdiasjor( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiinterdiasjor");
      gxTv_SdtPais_Paiinterdiasjor = value ;
   }

   public byte getgxTv_SdtPais_Paitipoexpdef( )
   {
      return gxTv_SdtPais_Paitipoexpdef ;
   }

   public void setgxTv_SdtPais_Paitipoexpdef( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paitipoexpdef");
      gxTv_SdtPais_Paitipoexpdef = value ;
   }

   public GXBCLevelCollection<web.SdtPais_Vacaciones> getgxTv_SdtPais_Vacaciones( )
   {
      if ( gxTv_SdtPais_Vacaciones == null )
      {
         gxTv_SdtPais_Vacaciones = new GXBCLevelCollection<web.SdtPais_Vacaciones>(web.SdtPais_Vacaciones.class, "Pais.Vacaciones", "PayDay", remoteHandle);
      }
      gxTv_SdtPais_N = (byte)(0) ;
      return gxTv_SdtPais_Vacaciones ;
   }

   public void setgxTv_SdtPais_Vacaciones( GXBCLevelCollection<web.SdtPais_Vacaciones> value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Vacaciones");
      gxTv_SdtPais_Vacaciones = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_SetNull( )
   {
      gxTv_SdtPais_Vacaciones = null ;
      SetDirty("Vacaciones");
   }

   public boolean getgxTv_SdtPais_Vacaciones_IsNull( )
   {
      if ( gxTv_SdtPais_Vacaciones == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtPais_Mode( )
   {
      return gxTv_SdtPais_Mode ;
   }

   public void setgxTv_SdtPais_Mode( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_Mode = value ;
   }

   public void setgxTv_SdtPais_Mode_SetNull( )
   {
      gxTv_SdtPais_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Initialized( )
   {
      return gxTv_SdtPais_Initialized ;
   }

   public void setgxTv_SdtPais_Initialized( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtPais_Initialized = value ;
   }

   public void setgxTv_SdtPais_Initialized_SetNull( )
   {
      gxTv_SdtPais_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Paicod_Z( )
   {
      return gxTv_SdtPais_Paicod_Z ;
   }

   public void setgxTv_SdtPais_Paicod_Z( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paicod_Z");
      gxTv_SdtPais_Paicod_Z = value ;
   }

   public void setgxTv_SdtPais_Paicod_Z_SetNull( )
   {
      gxTv_SdtPais_Paicod_Z = (short)(0) ;
      SetDirty("Paicod_Z");
   }

   public boolean getgxTv_SdtPais_Paicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Painom_Z( )
   {
      return gxTv_SdtPais_Painom_Z ;
   }

   public void setgxTv_SdtPais_Painom_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Painom_Z");
      gxTv_SdtPais_Painom_Z = value ;
   }

   public void setgxTv_SdtPais_Painom_Z_SetNull( )
   {
      gxTv_SdtPais_Painom_Z = "" ;
      SetDirty("Painom_Z");
   }

   public boolean getgxTv_SdtPais_Painom_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_Painacmostrar_Z( )
   {
      return gxTv_SdtPais_Painacmostrar_Z ;
   }

   public void setgxTv_SdtPais_Painacmostrar_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Painacmostrar_Z");
      gxTv_SdtPais_Painacmostrar_Z = value ;
   }

   public void setgxTv_SdtPais_Painacmostrar_Z_SetNull( )
   {
      gxTv_SdtPais_Painacmostrar_Z = false ;
      SetDirty("Painacmostrar_Z");
   }

   public boolean getgxTv_SdtPais_Painacmostrar_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_Paidommostrar_Z( )
   {
      return gxTv_SdtPais_Paidommostrar_Z ;
   }

   public void setgxTv_SdtPais_Paidommostrar_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paidommostrar_Z");
      gxTv_SdtPais_Paidommostrar_Z = value ;
   }

   public void setgxTv_SdtPais_Paidommostrar_Z_SetNull( )
   {
      gxTv_SdtPais_Paidommostrar_Z = false ;
      SetDirty("Paidommostrar_Z");
   }

   public boolean getgxTv_SdtPais_Paidommostrar_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paireligdefault_Z( )
   {
      return gxTv_SdtPais_Paireligdefault_Z ;
   }

   public void setgxTv_SdtPais_Paireligdefault_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paireligdefault_Z");
      gxTv_SdtPais_Paireligdefault_Z = value ;
   }

   public void setgxTv_SdtPais_Paireligdefault_Z_SetNull( )
   {
      gxTv_SdtPais_Paireligdefault_Z = "" ;
      SetDirty("Paireligdefault_Z");
   }

   public boolean getgxTv_SdtPais_Paireligdefault_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paimeshspext_Z( )
   {
      return gxTv_SdtPais_Paimeshspext_Z ;
   }

   public void setgxTv_SdtPais_Paimeshspext_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paimeshspext_Z");
      gxTv_SdtPais_Paimeshspext_Z = value ;
   }

   public void setgxTv_SdtPais_Paimeshspext_Z_SetNull( )
   {
      gxTv_SdtPais_Paimeshspext_Z = DecimalUtil.ZERO ;
      SetDirty("Paimeshspext_Z");
   }

   public boolean getgxTv_SdtPais_Paimeshspext_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paidiahspext_Z( )
   {
      return gxTv_SdtPais_Paidiahspext_Z ;
   }

   public void setgxTv_SdtPais_Paidiahspext_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paidiahspext_Z");
      gxTv_SdtPais_Paidiahspext_Z = value ;
   }

   public void setgxTv_SdtPais_Paidiahspext_Z_SetNull( )
   {
      gxTv_SdtPais_Paidiahspext_Z = "" ;
      SetDirty("Paidiahspext_Z");
   }

   public boolean getgxTv_SdtPais_Paidiahspext_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_Paifondocese_Z( )
   {
      return gxTv_SdtPais_Paifondocese_Z ;
   }

   public void setgxTv_SdtPais_Paifondocese_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paifondocese_Z");
      gxTv_SdtPais_Paifondocese_Z = value ;
   }

   public void setgxTv_SdtPais_Paifondocese_Z_SetNull( )
   {
      gxTv_SdtPais_Paifondocese_Z = false ;
      SetDirty("Paifondocese_Z");
   }

   public boolean getgxTv_SdtPais_Paifondocese_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paimaxhornor_Z( )
   {
      return gxTv_SdtPais_Paimaxhornor_Z ;
   }

   public void setgxTv_SdtPais_Paimaxhornor_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paimaxhornor_Z");
      gxTv_SdtPais_Paimaxhornor_Z = value ;
   }

   public void setgxTv_SdtPais_Paimaxhornor_Z_SetNull( )
   {
      gxTv_SdtPais_Paimaxhornor_Z = DecimalUtil.ZERO ;
      SetDirty("Paimaxhornor_Z");
   }

   public boolean getgxTv_SdtPais_Paimaxhornor_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paipervacdes_Z( )
   {
      return gxTv_SdtPais_Paipervacdes_Z ;
   }

   public void setgxTv_SdtPais_Paipervacdes_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipervacdes_Z");
      gxTv_SdtPais_Paipervacdes_Z = value ;
   }

   public void setgxTv_SdtPais_Paipervacdes_Z_SetNull( )
   {
      gxTv_SdtPais_Paipervacdes_Z = (byte)(0) ;
      SetDirty("Paipervacdes_Z");
   }

   public boolean getgxTv_SdtPais_Paipervacdes_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paipervachas_Z( )
   {
      return gxTv_SdtPais_Paipervachas_Z ;
   }

   public void setgxTv_SdtPais_Paipervachas_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipervachas_Z");
      gxTv_SdtPais_Paipervachas_Z = value ;
   }

   public void setgxTv_SdtPais_Paipervachas_Z_SetNull( )
   {
      gxTv_SdtPais_Paipervachas_Z = (byte)(0) ;
      SetDirty("Paipervachas_Z");
   }

   public boolean getgxTv_SdtPais_Paipervachas_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paifracvacant_Z( )
   {
      return gxTv_SdtPais_Paifracvacant_Z ;
   }

   public void setgxTv_SdtPais_Paifracvacant_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paifracvacant_Z");
      gxTv_SdtPais_Paifracvacant_Z = value ;
   }

   public void setgxTv_SdtPais_Paifracvacant_Z_SetNull( )
   {
      gxTv_SdtPais_Paifracvacant_Z = DecimalUtil.ZERO ;
      SetDirty("Paifracvacant_Z");
   }

   public boolean getgxTv_SdtPais_Paifracvacant_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paiprommeses_Z( )
   {
      return gxTv_SdtPais_Paiprommeses_Z ;
   }

   public void setgxTv_SdtPais_Paiprommeses_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiprommeses_Z");
      gxTv_SdtPais_Paiprommeses_Z = value ;
   }

   public void setgxTv_SdtPais_Paiprommeses_Z_SetNull( )
   {
      gxTv_SdtPais_Paiprommeses_Z = (byte)(0) ;
      SetDirty("Paiprommeses_Z");
   }

   public boolean getgxTv_SdtPais_Paiprommeses_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paiprommestcnt_Z( )
   {
      return gxTv_SdtPais_Paiprommestcnt_Z ;
   }

   public void setgxTv_SdtPais_Paiprommestcnt_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiprommestcnt_Z");
      gxTv_SdtPais_Paiprommestcnt_Z = value ;
   }

   public void setgxTv_SdtPais_Paiprommestcnt_Z_SetNull( )
   {
      gxTv_SdtPais_Paiprommestcnt_Z = "" ;
      SetDirty("Paiprommestcnt_Z");
   }

   public boolean getgxTv_SdtPais_Paiprommestcnt_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paipromjormeses_Z( )
   {
      return gxTv_SdtPais_Paipromjormeses_Z ;
   }

   public void setgxTv_SdtPais_Paipromjormeses_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipromjormeses_Z");
      gxTv_SdtPais_Paipromjormeses_Z = value ;
   }

   public void setgxTv_SdtPais_Paipromjormeses_Z_SetNull( )
   {
      gxTv_SdtPais_Paipromjormeses_Z = (byte)(0) ;
      SetDirty("Paipromjormeses_Z");
   }

   public boolean getgxTv_SdtPais_Paipromjormeses_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_Paipromjormestcnt_Z( )
   {
      return gxTv_SdtPais_Paipromjormestcnt_Z ;
   }

   public void setgxTv_SdtPais_Paipromjormestcnt_Z( String value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paipromjormestcnt_Z");
      gxTv_SdtPais_Paipromjormestcnt_Z = value ;
   }

   public void setgxTv_SdtPais_Paipromjormestcnt_Z_SetNull( )
   {
      gxTv_SdtPais_Paipromjormestcnt_Z = "" ;
      SetDirty("Paipromjormestcnt_Z");
   }

   public boolean getgxTv_SdtPais_Paipromjormestcnt_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paiguaredadmin_Z( )
   {
      return gxTv_SdtPais_Paiguaredadmin_Z ;
   }

   public void setgxTv_SdtPais_Paiguaredadmin_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiguaredadmin_Z");
      gxTv_SdtPais_Paiguaredadmin_Z = value ;
   }

   public void setgxTv_SdtPais_Paiguaredadmin_Z_SetNull( )
   {
      gxTv_SdtPais_Paiguaredadmin_Z = (byte)(0) ;
      SetDirty("Paiguaredadmin_Z");
   }

   public boolean getgxTv_SdtPais_Paiguaredadmin_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paiguaredadmax_Z( )
   {
      return gxTv_SdtPais_Paiguaredadmax_Z ;
   }

   public void setgxTv_SdtPais_Paiguaredadmax_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiguaredadmax_Z");
      gxTv_SdtPais_Paiguaredadmax_Z = value ;
   }

   public void setgxTv_SdtPais_Paiguaredadmax_Z_SetNull( )
   {
      gxTv_SdtPais_Paiguaredadmax_Z = (byte)(0) ;
      SetDirty("Paiguaredadmax_Z");
   }

   public boolean getgxTv_SdtPais_Paiguaredadmax_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_Paiexcvizzoti_Z( )
   {
      return gxTv_SdtPais_Paiexcvizzoti_Z ;
   }

   public void setgxTv_SdtPais_Paiexcvizzoti_Z( boolean value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiexcvizzoti_Z");
      gxTv_SdtPais_Paiexcvizzoti_Z = value ;
   }

   public void setgxTv_SdtPais_Paiexcvizzoti_Z_SetNull( )
   {
      gxTv_SdtPais_Paiexcvizzoti_Z = false ;
      SetDirty("Paiexcvizzoti_Z");
   }

   public boolean getgxTv_SdtPais_Paiexcvizzoti_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_Paivizzoti_Z( )
   {
      return gxTv_SdtPais_Paivizzoti_Z ;
   }

   public void setgxTv_SdtPais_Paivizzoti_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paivizzoti_Z");
      gxTv_SdtPais_Paivizzoti_Z = value ;
   }

   public void setgxTv_SdtPais_Paivizzoti_Z_SetNull( )
   {
      gxTv_SdtPais_Paivizzoti_Z = DecimalUtil.ZERO ;
      SetDirty("Paivizzoti_Z");
   }

   public boolean getgxTv_SdtPais_Paivizzoti_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paiminmesesvac_Z( )
   {
      return gxTv_SdtPais_Paiminmesesvac_Z ;
   }

   public void setgxTv_SdtPais_Paiminmesesvac_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiminmesesvac_Z");
      gxTv_SdtPais_Paiminmesesvac_Z = value ;
   }

   public void setgxTv_SdtPais_Paiminmesesvac_Z_SetNull( )
   {
      gxTv_SdtPais_Paiminmesesvac_Z = (byte)(0) ;
      SetDirty("Paiminmesesvac_Z");
   }

   public boolean getgxTv_SdtPais_Paiminmesesvac_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Paiinterdiasjor_Z( )
   {
      return gxTv_SdtPais_Paiinterdiasjor_Z ;
   }

   public void setgxTv_SdtPais_Paiinterdiasjor_Z( short value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paiinterdiasjor_Z");
      gxTv_SdtPais_Paiinterdiasjor_Z = value ;
   }

   public void setgxTv_SdtPais_Paiinterdiasjor_Z_SetNull( )
   {
      gxTv_SdtPais_Paiinterdiasjor_Z = (short)(0) ;
      SetDirty("Paiinterdiasjor_Z");
   }

   public boolean getgxTv_SdtPais_Paiinterdiasjor_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paitipoexpdef_Z( )
   {
      return gxTv_SdtPais_Paitipoexpdef_Z ;
   }

   public void setgxTv_SdtPais_Paitipoexpdef_Z( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paitipoexpdef_Z");
      gxTv_SdtPais_Paitipoexpdef_Z = value ;
   }

   public void setgxTv_SdtPais_Paitipoexpdef_Z_SetNull( )
   {
      gxTv_SdtPais_Paitipoexpdef_Z = (byte)(0) ;
      SetDirty("Paitipoexpdef_Z");
   }

   public boolean getgxTv_SdtPais_Paitipoexpdef_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Paireligdefault_N( )
   {
      return gxTv_SdtPais_Paireligdefault_N ;
   }

   public void setgxTv_SdtPais_Paireligdefault_N( byte value )
   {
      gxTv_SdtPais_N = (byte)(0) ;
      SetDirty("Paireligdefault_N");
      gxTv_SdtPais_Paireligdefault_N = value ;
   }

   public void setgxTv_SdtPais_Paireligdefault_N_SetNull( )
   {
      gxTv_SdtPais_Paireligdefault_N = (byte)(0) ;
      SetDirty("Paireligdefault_N");
   }

   public boolean getgxTv_SdtPais_Paireligdefault_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.pais_bc obj;
      obj = new web.pais_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtPais_N = (byte)(1) ;
      gxTv_SdtPais_Painom = "" ;
      gxTv_SdtPais_Paireligdefault = "" ;
      gxTv_SdtPais_Paimeshspext = DecimalUtil.ZERO ;
      gxTv_SdtPais_Paidiahspext = "" ;
      gxTv_SdtPais_Paimaxhornor = DecimalUtil.ZERO ;
      gxTv_SdtPais_Paifracvacant = DecimalUtil.ZERO ;
      gxTv_SdtPais_Paiprommestcnt = "" ;
      gxTv_SdtPais_Paipromjormestcnt = "" ;
      gxTv_SdtPais_Paivizzoti = DecimalUtil.ZERO ;
      gxTv_SdtPais_Mode = "" ;
      gxTv_SdtPais_Painom_Z = "" ;
      gxTv_SdtPais_Paireligdefault_Z = "" ;
      gxTv_SdtPais_Paimeshspext_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_Paidiahspext_Z = "" ;
      gxTv_SdtPais_Paimaxhornor_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_Paifracvacant_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_Paiprommestcnt_Z = "" ;
      gxTv_SdtPais_Paipromjormestcnt_Z = "" ;
      gxTv_SdtPais_Paivizzoti_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_N ;
   }

   public web.SdtPais Clone( )
   {
      web.SdtPais sdt;
      web.pais_bc obj;
      sdt = (web.SdtPais)(clone()) ;
      obj = (web.pais_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtPais struct )
   {
      setgxTv_SdtPais_Paicod(struct.getPaicod());
      setgxTv_SdtPais_Painom(struct.getPainom());
      setgxTv_SdtPais_Painacmostrar(struct.getPainacmostrar());
      setgxTv_SdtPais_Paidommostrar(struct.getPaidommostrar());
      setgxTv_SdtPais_Paireligdefault(struct.getPaireligdefault());
      setgxTv_SdtPais_Paimeshspext(struct.getPaimeshspext());
      setgxTv_SdtPais_Paidiahspext(struct.getPaidiahspext());
      setgxTv_SdtPais_Paifondocese(struct.getPaifondocese());
      setgxTv_SdtPais_Paimaxhornor(struct.getPaimaxhornor());
      setgxTv_SdtPais_Paipervacdes(struct.getPaipervacdes());
      setgxTv_SdtPais_Paipervachas(struct.getPaipervachas());
      setgxTv_SdtPais_Paifracvacant(struct.getPaifracvacant());
      GXBCLevelCollection<web.SdtPais_preaviso> gxTv_SdtPais_Preaviso_aux = new GXBCLevelCollection<web.SdtPais_preaviso>(web.SdtPais_preaviso.class, "Pais.preaviso", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_preaviso> gxTv_SdtPais_Preaviso_aux1 = struct.getPreaviso();
      if (gxTv_SdtPais_Preaviso_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Preaviso_aux1.size(); i++)
         {
            gxTv_SdtPais_Preaviso_aux.add(new web.SdtPais_preaviso(remoteHandle, gxTv_SdtPais_Preaviso_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Preaviso(gxTv_SdtPais_Preaviso_aux);
      GXBCLevelCollection<web.SdtPais_base_calculo> gxTv_SdtPais_Base_calculo_aux = new GXBCLevelCollection<web.SdtPais_base_calculo>(web.SdtPais_base_calculo.class, "Pais.base_calculo", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_base_calculo> gxTv_SdtPais_Base_calculo_aux1 = struct.getBase_calculo();
      if (gxTv_SdtPais_Base_calculo_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Base_calculo_aux1.size(); i++)
         {
            gxTv_SdtPais_Base_calculo_aux.add(new web.SdtPais_base_calculo(remoteHandle, gxTv_SdtPais_Base_calculo_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Base_calculo(gxTv_SdtPais_Base_calculo_aux);
      GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux = new GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados>(web.SdtPais_conceptos_horanormal_jornalizados.class, "Pais.conceptos_horanormal_jornalizados", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_conceptos_horanormal_jornalizados> gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux1 = struct.getConceptos_horanormal_jornalizados();
      if (gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux1.size(); i++)
         {
            gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux.add(new web.SdtPais_conceptos_horanormal_jornalizados(remoteHandle, gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Conceptos_horanormal_jornalizados(gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux);
      GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux = new GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados>(web.SdtPais_conceptos_horanormal_mensualizados.class, "Pais.conceptos_horanormal_mensualizados", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_conceptos_horanormal_mensualizados> gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux1 = struct.getConceptos_horanormal_mensualizados();
      if (gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux1.size(); i++)
         {
            gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux.add(new web.SdtPais_conceptos_horanormal_mensualizados(remoteHandle, gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Conceptos_horanormal_mensualizados(gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux);
      setgxTv_SdtPais_Paiprommeses(struct.getPaiprommeses());
      setgxTv_SdtPais_Paiprommestcnt(struct.getPaiprommestcnt());
      setgxTv_SdtPais_Paipromjormeses(struct.getPaipromjormeses());
      setgxTv_SdtPais_Paipromjormestcnt(struct.getPaipromjormestcnt());
      GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> gxTv_SdtPais_Promedio_horanormal_mensualizados_aux = new GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados>(web.SdtPais_promedio_horanormal_mensualizados.class, "Pais.promedio_horanormal_mensualizados", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_promedio_horanormal_mensualizados> gxTv_SdtPais_Promedio_horanormal_mensualizados_aux1 = struct.getPromedio_horanormal_mensualizados();
      if (gxTv_SdtPais_Promedio_horanormal_mensualizados_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Promedio_horanormal_mensualizados_aux1.size(); i++)
         {
            gxTv_SdtPais_Promedio_horanormal_mensualizados_aux.add(new web.SdtPais_promedio_horanormal_mensualizados(remoteHandle, gxTv_SdtPais_Promedio_horanormal_mensualizados_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Promedio_horanormal_mensualizados(gxTv_SdtPais_Promedio_horanormal_mensualizados_aux);
      GXBCLevelCollection<web.SdtPais_tipo_trabajo> gxTv_SdtPais_Tipo_trabajo_aux = new GXBCLevelCollection<web.SdtPais_tipo_trabajo>(web.SdtPais_tipo_trabajo.class, "Pais.tipo_trabajo", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_tipo_trabajo> gxTv_SdtPais_Tipo_trabajo_aux1 = struct.getTipo_trabajo();
      if (gxTv_SdtPais_Tipo_trabajo_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Tipo_trabajo_aux1.size(); i++)
         {
            gxTv_SdtPais_Tipo_trabajo_aux.add(new web.SdtPais_tipo_trabajo(remoteHandle, gxTv_SdtPais_Tipo_trabajo_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Tipo_trabajo(gxTv_SdtPais_Tipo_trabajo_aux);
      GXBCLevelCollection<web.SdtPais_horasextras_pordia> gxTv_SdtPais_Horasextras_pordia_aux = new GXBCLevelCollection<web.SdtPais_horasextras_pordia>(web.SdtPais_horasextras_pordia.class, "Pais.horasextras_pordia", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_horasextras_pordia> gxTv_SdtPais_Horasextras_pordia_aux1 = struct.getHorasextras_pordia();
      if (gxTv_SdtPais_Horasextras_pordia_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Horasextras_pordia_aux1.size(); i++)
         {
            gxTv_SdtPais_Horasextras_pordia_aux.add(new web.SdtPais_horasextras_pordia(remoteHandle, gxTv_SdtPais_Horasextras_pordia_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Horasextras_pordia(gxTv_SdtPais_Horasextras_pordia_aux);
      setgxTv_SdtPais_Paiguaredadmin(struct.getPaiguaredadmin());
      setgxTv_SdtPais_Paiguaredadmax(struct.getPaiguaredadmax());
      setgxTv_SdtPais_Paiexcvizzoti(struct.getPaiexcvizzoti());
      setgxTv_SdtPais_Paivizzoti(struct.getPaivizzoti());
      setgxTv_SdtPais_Paiminmesesvac(struct.getPaiminmesesvac());
      setgxTv_SdtPais_Paiinterdiasjor(struct.getPaiinterdiasjor());
      setgxTv_SdtPais_Paitipoexpdef(struct.getPaitipoexpdef());
      GXBCLevelCollection<web.SdtPais_Vacaciones> gxTv_SdtPais_Vacaciones_aux = new GXBCLevelCollection<web.SdtPais_Vacaciones>(web.SdtPais_Vacaciones.class, "Pais.Vacaciones", "PayDay", remoteHandle);
      Vector<web.StructSdtPais_Vacaciones> gxTv_SdtPais_Vacaciones_aux1 = struct.getVacaciones();
      if (gxTv_SdtPais_Vacaciones_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtPais_Vacaciones_aux1.size(); i++)
         {
            gxTv_SdtPais_Vacaciones_aux.add(new web.SdtPais_Vacaciones(remoteHandle, gxTv_SdtPais_Vacaciones_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtPais_Vacaciones(gxTv_SdtPais_Vacaciones_aux);
      setgxTv_SdtPais_Mode(struct.getMode());
      setgxTv_SdtPais_Initialized(struct.getInitialized());
      setgxTv_SdtPais_Paicod_Z(struct.getPaicod_Z());
      setgxTv_SdtPais_Painom_Z(struct.getPainom_Z());
      setgxTv_SdtPais_Painacmostrar_Z(struct.getPainacmostrar_Z());
      setgxTv_SdtPais_Paidommostrar_Z(struct.getPaidommostrar_Z());
      setgxTv_SdtPais_Paireligdefault_Z(struct.getPaireligdefault_Z());
      setgxTv_SdtPais_Paimeshspext_Z(struct.getPaimeshspext_Z());
      setgxTv_SdtPais_Paidiahspext_Z(struct.getPaidiahspext_Z());
      setgxTv_SdtPais_Paifondocese_Z(struct.getPaifondocese_Z());
      setgxTv_SdtPais_Paimaxhornor_Z(struct.getPaimaxhornor_Z());
      setgxTv_SdtPais_Paipervacdes_Z(struct.getPaipervacdes_Z());
      setgxTv_SdtPais_Paipervachas_Z(struct.getPaipervachas_Z());
      setgxTv_SdtPais_Paifracvacant_Z(struct.getPaifracvacant_Z());
      setgxTv_SdtPais_Paiprommeses_Z(struct.getPaiprommeses_Z());
      setgxTv_SdtPais_Paiprommestcnt_Z(struct.getPaiprommestcnt_Z());
      setgxTv_SdtPais_Paipromjormeses_Z(struct.getPaipromjormeses_Z());
      setgxTv_SdtPais_Paipromjormestcnt_Z(struct.getPaipromjormestcnt_Z());
      setgxTv_SdtPais_Paiguaredadmin_Z(struct.getPaiguaredadmin_Z());
      setgxTv_SdtPais_Paiguaredadmax_Z(struct.getPaiguaredadmax_Z());
      setgxTv_SdtPais_Paiexcvizzoti_Z(struct.getPaiexcvizzoti_Z());
      setgxTv_SdtPais_Paivizzoti_Z(struct.getPaivizzoti_Z());
      setgxTv_SdtPais_Paiminmesesvac_Z(struct.getPaiminmesesvac_Z());
      setgxTv_SdtPais_Paiinterdiasjor_Z(struct.getPaiinterdiasjor_Z());
      setgxTv_SdtPais_Paitipoexpdef_Z(struct.getPaitipoexpdef_Z());
      setgxTv_SdtPais_Paireligdefault_N(struct.getPaireligdefault_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais getStruct( )
   {
      web.StructSdtPais struct = new web.StructSdtPais ();
      struct.setPaicod(getgxTv_SdtPais_Paicod());
      struct.setPainom(getgxTv_SdtPais_Painom());
      struct.setPainacmostrar(getgxTv_SdtPais_Painacmostrar());
      struct.setPaidommostrar(getgxTv_SdtPais_Paidommostrar());
      struct.setPaireligdefault(getgxTv_SdtPais_Paireligdefault());
      struct.setPaimeshspext(getgxTv_SdtPais_Paimeshspext());
      struct.setPaidiahspext(getgxTv_SdtPais_Paidiahspext());
      struct.setPaifondocese(getgxTv_SdtPais_Paifondocese());
      struct.setPaimaxhornor(getgxTv_SdtPais_Paimaxhornor());
      struct.setPaipervacdes(getgxTv_SdtPais_Paipervacdes());
      struct.setPaipervachas(getgxTv_SdtPais_Paipervachas());
      struct.setPaifracvacant(getgxTv_SdtPais_Paifracvacant());
      struct.setPreaviso(getgxTv_SdtPais_Preaviso().getStruct());
      struct.setBase_calculo(getgxTv_SdtPais_Base_calculo().getStruct());
      struct.setConceptos_horanormal_jornalizados(getgxTv_SdtPais_Conceptos_horanormal_jornalizados().getStruct());
      struct.setConceptos_horanormal_mensualizados(getgxTv_SdtPais_Conceptos_horanormal_mensualizados().getStruct());
      struct.setPaiprommeses(getgxTv_SdtPais_Paiprommeses());
      struct.setPaiprommestcnt(getgxTv_SdtPais_Paiprommestcnt());
      struct.setPaipromjormeses(getgxTv_SdtPais_Paipromjormeses());
      struct.setPaipromjormestcnt(getgxTv_SdtPais_Paipromjormestcnt());
      struct.setPromedio_horanormal_mensualizados(getgxTv_SdtPais_Promedio_horanormal_mensualizados().getStruct());
      struct.setTipo_trabajo(getgxTv_SdtPais_Tipo_trabajo().getStruct());
      struct.setHorasextras_pordia(getgxTv_SdtPais_Horasextras_pordia().getStruct());
      struct.setPaiguaredadmin(getgxTv_SdtPais_Paiguaredadmin());
      struct.setPaiguaredadmax(getgxTv_SdtPais_Paiguaredadmax());
      struct.setPaiexcvizzoti(getgxTv_SdtPais_Paiexcvizzoti());
      struct.setPaivizzoti(getgxTv_SdtPais_Paivizzoti());
      struct.setPaiminmesesvac(getgxTv_SdtPais_Paiminmesesvac());
      struct.setPaiinterdiasjor(getgxTv_SdtPais_Paiinterdiasjor());
      struct.setPaitipoexpdef(getgxTv_SdtPais_Paitipoexpdef());
      struct.setVacaciones(getgxTv_SdtPais_Vacaciones().getStruct());
      struct.setMode(getgxTv_SdtPais_Mode());
      struct.setInitialized(getgxTv_SdtPais_Initialized());
      struct.setPaicod_Z(getgxTv_SdtPais_Paicod_Z());
      struct.setPainom_Z(getgxTv_SdtPais_Painom_Z());
      struct.setPainacmostrar_Z(getgxTv_SdtPais_Painacmostrar_Z());
      struct.setPaidommostrar_Z(getgxTv_SdtPais_Paidommostrar_Z());
      struct.setPaireligdefault_Z(getgxTv_SdtPais_Paireligdefault_Z());
      struct.setPaimeshspext_Z(getgxTv_SdtPais_Paimeshspext_Z());
      struct.setPaidiahspext_Z(getgxTv_SdtPais_Paidiahspext_Z());
      struct.setPaifondocese_Z(getgxTv_SdtPais_Paifondocese_Z());
      struct.setPaimaxhornor_Z(getgxTv_SdtPais_Paimaxhornor_Z());
      struct.setPaipervacdes_Z(getgxTv_SdtPais_Paipervacdes_Z());
      struct.setPaipervachas_Z(getgxTv_SdtPais_Paipervachas_Z());
      struct.setPaifracvacant_Z(getgxTv_SdtPais_Paifracvacant_Z());
      struct.setPaiprommeses_Z(getgxTv_SdtPais_Paiprommeses_Z());
      struct.setPaiprommestcnt_Z(getgxTv_SdtPais_Paiprommestcnt_Z());
      struct.setPaipromjormeses_Z(getgxTv_SdtPais_Paipromjormeses_Z());
      struct.setPaipromjormestcnt_Z(getgxTv_SdtPais_Paipromjormestcnt_Z());
      struct.setPaiguaredadmin_Z(getgxTv_SdtPais_Paiguaredadmin_Z());
      struct.setPaiguaredadmax_Z(getgxTv_SdtPais_Paiguaredadmax_Z());
      struct.setPaiexcvizzoti_Z(getgxTv_SdtPais_Paiexcvizzoti_Z());
      struct.setPaivizzoti_Z(getgxTv_SdtPais_Paivizzoti_Z());
      struct.setPaiminmesesvac_Z(getgxTv_SdtPais_Paiminmesesvac_Z());
      struct.setPaiinterdiasjor_Z(getgxTv_SdtPais_Paiinterdiasjor_Z());
      struct.setPaitipoexpdef_Z(getgxTv_SdtPais_Paitipoexpdef_Z());
      struct.setPaireligdefault_N(getgxTv_SdtPais_Paireligdefault_N());
      return struct ;
   }

   private byte gxTv_SdtPais_N ;
   private byte gxTv_SdtPais_Paipervacdes ;
   private byte gxTv_SdtPais_Paipervachas ;
   private byte gxTv_SdtPais_Paiprommeses ;
   private byte gxTv_SdtPais_Paipromjormeses ;
   private byte gxTv_SdtPais_Paiguaredadmin ;
   private byte gxTv_SdtPais_Paiguaredadmax ;
   private byte gxTv_SdtPais_Paiminmesesvac ;
   private byte gxTv_SdtPais_Paitipoexpdef ;
   private byte gxTv_SdtPais_Paipervacdes_Z ;
   private byte gxTv_SdtPais_Paipervachas_Z ;
   private byte gxTv_SdtPais_Paiprommeses_Z ;
   private byte gxTv_SdtPais_Paipromjormeses_Z ;
   private byte gxTv_SdtPais_Paiguaredadmin_Z ;
   private byte gxTv_SdtPais_Paiguaredadmax_Z ;
   private byte gxTv_SdtPais_Paiminmesesvac_Z ;
   private byte gxTv_SdtPais_Paitipoexpdef_Z ;
   private byte gxTv_SdtPais_Paireligdefault_N ;
   private short gxTv_SdtPais_Paicod ;
   private short gxTv_SdtPais_Paiinterdiasjor ;
   private short gxTv_SdtPais_Initialized ;
   private short gxTv_SdtPais_Paicod_Z ;
   private short gxTv_SdtPais_Paiinterdiasjor_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtPais_Paimeshspext ;
   private java.math.BigDecimal gxTv_SdtPais_Paimaxhornor ;
   private java.math.BigDecimal gxTv_SdtPais_Paifracvacant ;
   private java.math.BigDecimal gxTv_SdtPais_Paivizzoti ;
   private java.math.BigDecimal gxTv_SdtPais_Paimeshspext_Z ;
   private java.math.BigDecimal gxTv_SdtPais_Paimaxhornor_Z ;
   private java.math.BigDecimal gxTv_SdtPais_Paifracvacant_Z ;
   private java.math.BigDecimal gxTv_SdtPais_Paivizzoti_Z ;
   private String gxTv_SdtPais_Paireligdefault ;
   private String gxTv_SdtPais_Paidiahspext ;
   private String gxTv_SdtPais_Paiprommestcnt ;
   private String gxTv_SdtPais_Paipromjormestcnt ;
   private String gxTv_SdtPais_Mode ;
   private String gxTv_SdtPais_Paireligdefault_Z ;
   private String gxTv_SdtPais_Paidiahspext_Z ;
   private String gxTv_SdtPais_Paiprommestcnt_Z ;
   private String gxTv_SdtPais_Paipromjormestcnt_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_Painacmostrar ;
   private boolean gxTv_SdtPais_Paidommostrar ;
   private boolean gxTv_SdtPais_Paifondocese ;
   private boolean gxTv_SdtPais_Paiexcvizzoti ;
   private boolean gxTv_SdtPais_Painacmostrar_Z ;
   private boolean gxTv_SdtPais_Paidommostrar_Z ;
   private boolean gxTv_SdtPais_Paifondocese_Z ;
   private boolean gxTv_SdtPais_Paiexcvizzoti_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtPais_Painom ;
   private String gxTv_SdtPais_Painom_Z ;
   private GXBCLevelCollection<web.SdtPais_preaviso> gxTv_SdtPais_Preaviso_aux ;
   private GXBCLevelCollection<web.SdtPais_base_calculo> gxTv_SdtPais_Base_calculo_aux ;
   private GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> gxTv_SdtPais_Conceptos_horanormal_jornalizados_aux ;
   private GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> gxTv_SdtPais_Conceptos_horanormal_mensualizados_aux ;
   private GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> gxTv_SdtPais_Promedio_horanormal_mensualizados_aux ;
   private GXBCLevelCollection<web.SdtPais_tipo_trabajo> gxTv_SdtPais_Tipo_trabajo_aux ;
   private GXBCLevelCollection<web.SdtPais_horasextras_pordia> gxTv_SdtPais_Horasextras_pordia_aux ;
   private GXBCLevelCollection<web.SdtPais_Vacaciones> gxTv_SdtPais_Vacaciones_aux ;
   private GXBCLevelCollection<web.SdtPais_preaviso> gxTv_SdtPais_Preaviso=null ;
   private GXBCLevelCollection<web.SdtPais_base_calculo> gxTv_SdtPais_Base_calculo=null ;
   private GXBCLevelCollection<web.SdtPais_conceptos_horanormal_jornalizados> gxTv_SdtPais_Conceptos_horanormal_jornalizados=null ;
   private GXBCLevelCollection<web.SdtPais_conceptos_horanormal_mensualizados> gxTv_SdtPais_Conceptos_horanormal_mensualizados=null ;
   private GXBCLevelCollection<web.SdtPais_promedio_horanormal_mensualizados> gxTv_SdtPais_Promedio_horanormal_mensualizados=null ;
   private GXBCLevelCollection<web.SdtPais_tipo_trabajo> gxTv_SdtPais_Tipo_trabajo=null ;
   private GXBCLevelCollection<web.SdtPais_horasextras_pordia> gxTv_SdtPais_Horasextras_pordia=null ;
   private GXBCLevelCollection<web.SdtPais_Vacaciones> gxTv_SdtPais_Vacaciones=null ;
}

