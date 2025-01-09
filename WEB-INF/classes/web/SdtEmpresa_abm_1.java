package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1 extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1.class));
   }

   public SdtEmpresa_abm_1( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1( int remoteHandle ,
                            StructSdtEmpresa_abm_1 struct )
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
                     short AV1EmpCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Empresa_abm_1");
      metadata.set("BT", "Empresa");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\" ]");
      metadata.set("Levels", "[ \"base_calculo\",\"conceptos_horanormal_jornalizados\",\"conceptos_horanormal_mensualizados\",\"horasextras_pordia\",\"nolaborables_convenio\",\"nolaborables_origen\",\"nolaborables_religion\",\"promedio_horanormal_mensualizados\",\"tipo_trabajo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ARTSec\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ActCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ActComCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ActComCodigo\" ],\"FKMap\":[ \"EmpActComercial-ActComCodigo\" ] },{ \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"OsoCod\" ],\"FKMap\":[ \"EmpOsoCod-OsoCod\" ] },{ \"FK\":[ \"CondiCodigo\" ],\"FKMap\":[ \"EmpCondiCod-CondiCodigo\" ] },{ \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\",\"LocCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipEmpleCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ZonCod\" ],\"FKMap\":[ \"EmpZonCod-ZonCod\" ] } ]");
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
               gxTv_SdtEmpresa_abm_1_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtEmpresa_abm_1_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtEmpresa_abm_1_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCUIT") )
            {
               gxTv_SdtEmpresa_abm_1_Empcuit = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDir") )
            {
               gxTv_SdtEmpresa_abm_1_Empdir = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTel") )
            {
               gxTv_SdtEmpresa_abm_1_Emptel = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCP") )
            {
               gxTv_SdtEmpresa_abm_1_Empcp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod") )
            {
               gxTv_SdtEmpresa_abm_1_Paicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom") )
            {
               gxTv_SdtEmpresa_abm_1_Painom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod") )
            {
               gxTv_SdtEmpresa_abm_1_Provcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvNom") )
            {
               gxTv_SdtEmpresa_abm_1_Provnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPerVacDes") )
            {
               gxTv_SdtEmpresa_abm_1_Emppervacdes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPerVacHas") )
            {
               gxTv_SdtEmpresa_abm_1_Emppervachas = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod") )
            {
               gxTv_SdtEmpresa_abm_1_Loccod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocNom") )
            {
               gxTv_SdtEmpresa_abm_1_Locnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo") )
            {
               gxTv_SdtEmpresa_abm_1_Actcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActDescrip") )
            {
               gxTv_SdtEmpresa_abm_1_Actdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod") )
            {
               gxTv_SdtEmpresa_abm_1_Tipemplecod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpActComercial") )
            {
               gxTv_SdtEmpresa_abm_1_Empactcomercial = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonCod") )
            {
               gxTv_SdtEmpresa_abm_1_Empzoncod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonDescrip") )
            {
               gxTv_SdtEmpresa_abm_1_Empzondescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReducc") )
            {
               gxTv_SdtEmpresa_abm_1_Empreducc = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleDefIns") )
            {
               gxTv_SdtEmpresa_abm_1_Tipempledefins = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogo") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogo=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogoNom") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogonom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogoExt") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogoext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirma") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirma=GXutil.blobFromBase64( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirmaNom") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirmanom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "conceptos_horanormal_mensualizados") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados == null )
               {
                  gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados = new GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados>(web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados.class, "Empresa_abm_1.conceptos_horanormal_mensualizados", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados.readxml(oReader, "conceptos_horanormal_mensualizados") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirmaExt") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirmaext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "conceptos_horanormal_jornalizados") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados == null )
               {
                  gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados = new GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados>(web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados.class, "Empresa_abm_1.conceptos_horanormal_jornalizados", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados.readxml(oReader, "conceptos_horanormal_jornalizados") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpAntiguedad") )
            {
               gxTv_SdtEmpresa_abm_1_Empantiguedad = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "promedio_horanormal_mensualizados") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados == null )
               {
                  gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados = new GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados>(web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados.class, "Empresa_abm_1.promedio_horanormal_mensualizados", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados.readxml(oReader, "promedio_horanormal_mensualizados") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPresentismo") )
            {
               gxTv_SdtEmpresa_abm_1_Emppresentismo = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMesHsPExt") )
            {
               gxTv_SdtEmpresa_abm_1_Empmeshspext = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLiqFer") )
            {
               gxTv_SdtEmpresa_abm_1_Empliqfer = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLiqFerJor") )
            {
               gxTv_SdtEmpresa_abm_1_Empliqferjor = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDiaHsPExt") )
            {
               gxTv_SdtEmpresa_abm_1_Empdiahspext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ARTSec") )
            {
               gxTv_SdtEmpresa_abm_1_Artsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "base_calculo") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Base_calculo == null )
               {
                  gxTv_SdtEmpresa_abm_1_Base_calculo = new GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo>(web.SdtEmpresa_abm_1_base_calculo.class, "Empresa_abm_1.base_calculo", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Base_calculo.readxml(oReader, "base_calculo") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "horasextras_pordia") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia == null )
               {
                  gxTv_SdtEmpresa_abm_1_Horasextras_pordia = new GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia>(web.SdtEmpresa_abm_1_horasextras_pordia.class, "Empresa_abm_1.horasextras_pordia", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Horasextras_pordia.readxml(oReader, "horasextras_pordia") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo_trabajo") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo == null )
               {
                  gxTv_SdtEmpresa_abm_1_Tipo_trabajo = new GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo>(web.SdtEmpresa_abm_1_tipo_trabajo.class, "Empresa_abm_1.tipo_trabajo", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Tipo_trabajo.readxml(oReader, "tipo_trabajo") ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "nolaborables_convenio") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio == null )
               {
                  gxTv_SdtEmpresa_abm_1_Nolaborables_convenio = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio>(web.SdtEmpresa_abm_1_nolaborables_convenio.class, "Empresa_abm_1.nolaborables_convenio", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Nolaborables_convenio.readxml(oReader, "nolaborables_convenio") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "nolaborables_convenio") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nolaborables_origen") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen == null )
               {
                  gxTv_SdtEmpresa_abm_1_Nolaborables_origen = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen>(web.SdtEmpresa_abm_1_nolaborables_origen.class, "Empresa_abm_1.nolaborables_origen", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Nolaborables_origen.readxml(oReader, "nolaborables_origen") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "nolaborables_origen") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "nolaborables_religion") )
            {
               if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion == null )
               {
                  gxTv_SdtEmpresa_abm_1_Nolaborables_religion = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion>(web.SdtEmpresa_abm_1_nolaborables_religion.class, "Empresa_abm_1.nolaborables_religion", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtEmpresa_abm_1_Nolaborables_religion.readxml(oReader, "nolaborables_religion") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "nolaborables_religion") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpGuarEdadMin") )
            {
               gxTv_SdtEmpresa_abm_1_Empguaredadmin = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpGuarEdadMax") )
            {
               gxTv_SdtEmpresa_abm_1_Empguaredadmax = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLiqGan") )
            {
               gxTv_SdtEmpresa_abm_1_Empliqgan = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTipoExp") )
            {
               gxTv_SdtEmpresa_abm_1_Emptipoexp = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPromDesde") )
            {
               gxTv_SdtEmpresa_abm_1_Emppromdesde = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFracVacAnt") )
            {
               gxTv_SdtEmpresa_abm_1_Empfracvacant = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpVacExpLim") )
            {
               gxTv_SdtEmpresa_abm_1_Empvacexplim = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpVacExpTie") )
            {
               gxTv_SdtEmpresa_abm_1_Empvacexptie = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpVacDisMax") )
            {
               gxTv_SdtEmpresa_abm_1_Empvacdismax = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActComCodigo") )
            {
               gxTv_SdtEmpresa_abm_1_Actcomcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOsoCod") )
            {
               gxTv_SdtEmpresa_abm_1_Emposocod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCondiCod") )
            {
               gxTv_SdtEmpresa_abm_1_Empcondicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpModTra") )
            {
               gxTv_SdtEmpresa_abm_1_Empmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpModEmpl") )
            {
               gxTv_SdtEmpresa_abm_1_Empmodempl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpModAuto") )
            {
               gxTv_SdtEmpresa_abm_1_Empmodauto = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCUIT_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empcuit_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDir_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empdir_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTel_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emptel_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCP_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empcp_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Paicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Painom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Provcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvNom_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Provnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPerVacDes_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emppervacdes_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPerVacHas_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emppervachas_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Loccod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocNom_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Locnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Actcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActDescrip_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Actdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Tipemplecod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpActComercial_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empactcomercial_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empzoncod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonDescrip_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empzondescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReducc_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empreducc_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleDefIns_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Tipempledefins_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogoNom_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogonom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogoExt_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogoext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirmaNom_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirmanom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirmaExt_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirmaext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpAntiguedad_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empantiguedad_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPresentismo_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emppresentismo_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMesHsPExt_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empmeshspext_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLiqFer_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empliqfer_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLiqFerJor_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empliqferjor_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDiaHsPExt_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empdiahspext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ARTSec_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Artsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpGuarEdadMin_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpGuarEdadMax_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLiqGan_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empliqgan_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTipoExp_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emptipoexp_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPromDesde_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emppromdesde_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFracVacAnt_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empfracvacant_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpVacExpLim_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empvacexplim_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpVacExpTie_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empvacexptie_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpVacDisMax_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empvacdismax_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActComCodigo_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOsoCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Emposocod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCondiCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empcondicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpModTra_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empmodtra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpModEmpl_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empmodempl_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpModAuto_Z") )
            {
               gxTv_SdtEmpresa_abm_1_Empmodauto_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTel_N") )
            {
               gxTv_SdtEmpresa_abm_1_Emptel_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCP_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empcp_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_N") )
            {
               gxTv_SdtEmpresa_abm_1_Paicod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod_N") )
            {
               gxTv_SdtEmpresa_abm_1_Provcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod_N") )
            {
               gxTv_SdtEmpresa_abm_1_Loccod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo_N") )
            {
               gxTv_SdtEmpresa_abm_1_Actcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod_N") )
            {
               gxTv_SdtEmpresa_abm_1_Tipemplecod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonCod_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empzoncod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogo_N") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogoNom_N") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogonom_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLogoExt_N") )
            {
               gxTv_SdtEmpresa_abm_1_Emplogoext_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirma_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirma_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirmaNom_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirmanom_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpFirmaExt_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empfirmaext_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMesHsPExt_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empmeshspext_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDiaHsPExt_N") )
            {
               gxTv_SdtEmpresa_abm_1_Empdiahspext_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOsoCod_N") )
            {
               gxTv_SdtEmpresa_abm_1_Emposocod_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Empresa_abm_1" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtEmpresa_abm_1_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCUIT", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcuit, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpDir", gxTv_SdtEmpresa_abm_1_Empdir);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTel", gxTv_SdtEmpresa_abm_1_Emptel);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCP", gxTv_SdtEmpresa_abm_1_Empcp);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Paicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiNom", gxTv_SdtEmpresa_abm_1_Painom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Provcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvNom", gxTv_SdtEmpresa_abm_1_Provnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpPerVacDes", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emppervacdes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpPerVacHas", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emppervachas, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Loccod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocNom", gxTv_SdtEmpresa_abm_1_Locnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActCodigo", gxTv_SdtEmpresa_abm_1_Actcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActDescrip", gxTv_SdtEmpresa_abm_1_Actdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipEmpleCod", gxTv_SdtEmpresa_abm_1_Tipemplecod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpActComercial", gxTv_SdtEmpresa_abm_1_Empactcomercial);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpZonCod", gxTv_SdtEmpresa_abm_1_Empzoncod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpZonDescrip", gxTv_SdtEmpresa_abm_1_Empzondescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpReducc", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empreducc));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipEmpleDefIns", gxTv_SdtEmpresa_abm_1_Tipempledefins);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLogo", GXutil.blobToBase64( gxTv_SdtEmpresa_abm_1_Emplogo));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLogoNom", gxTv_SdtEmpresa_abm_1_Emplogonom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLogoExt", gxTv_SdtEmpresa_abm_1_Emplogoext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpFirma", GXutil.blobToBase64( gxTv_SdtEmpresa_abm_1_Empfirma));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpFirmaNom", gxTv_SdtEmpresa_abm_1_Empfirmanom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados != null )
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
         gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados.writexml(oWriter, "conceptos_horanormal_mensualizados", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("EmpFirmaExt", gxTv_SdtEmpresa_abm_1_Empfirmaext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados != null )
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
         gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados.writexml(oWriter, "conceptos_horanormal_jornalizados", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("EmpAntiguedad", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Empantiguedad, 14, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados != null )
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
         gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados.writexml(oWriter, "promedio_horanormal_mensualizados", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("EmpPresentismo", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Emppresentismo, 14, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpMesHsPExt", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Empmeshspext, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLiqFer", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empliqfer));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLiqFerJor", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empliqferjor));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpDiaHsPExt", gxTv_SdtEmpresa_abm_1_Empdiahspext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ARTSec", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Artsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtEmpresa_abm_1_Base_calculo != null )
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
         gxTv_SdtEmpresa_abm_1_Base_calculo.writexml(oWriter, "base_calculo", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia != null )
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
         gxTv_SdtEmpresa_abm_1_Horasextras_pordia.writexml(oWriter, "horasextras_pordia", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo != null )
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
         gxTv_SdtEmpresa_abm_1_Tipo_trabajo.writexml(oWriter, "tipo_trabajo", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio != null )
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
         gxTv_SdtEmpresa_abm_1_Nolaborables_convenio.writexml(oWriter, "nolaborables_convenio", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen != null )
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
         gxTv_SdtEmpresa_abm_1_Nolaborables_origen.writexml(oWriter, "nolaborables_origen", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion != null )
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
         gxTv_SdtEmpresa_abm_1_Nolaborables_religion.writexml(oWriter, "nolaborables_religion", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("EmpGuarEdadMin", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empguaredadmin, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpGuarEdadMax", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empguaredadmax, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLiqGan", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empliqgan));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTipoExp", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emptipoexp, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpPromDesde", gxTv_SdtEmpresa_abm_1_Emppromdesde);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpFracVacAnt", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Empfracvacant, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpVacExpLim", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empvacexplim));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpVacExpTie", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empvacexptie, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpVacDisMax", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empvacdismax, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActComCodigo", gxTv_SdtEmpresa_abm_1_Actcomcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpOsoCod", gxTv_SdtEmpresa_abm_1_Emposocod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCondiCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcondicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpModTra", gxTv_SdtEmpresa_abm_1_Empmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpModEmpl", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empmodempl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpModAuto", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empmodauto));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtEmpresa_abm_1_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCUIT_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcuit_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpDir_Z", gxTv_SdtEmpresa_abm_1_Empdir_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTel_Z", gxTv_SdtEmpresa_abm_1_Emptel_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCP_Z", gxTv_SdtEmpresa_abm_1_Empcp_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Paicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiNom_Z", gxTv_SdtEmpresa_abm_1_Painom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Provcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvNom_Z", gxTv_SdtEmpresa_abm_1_Provnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpPerVacDes_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emppervacdes_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpPerVacHas_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emppervachas_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LocCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Loccod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LocNom_Z", gxTv_SdtEmpresa_abm_1_Locnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActCodigo_Z", gxTv_SdtEmpresa_abm_1_Actcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActDescrip_Z", gxTv_SdtEmpresa_abm_1_Actdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleCod_Z", gxTv_SdtEmpresa_abm_1_Tipemplecod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpActComercial_Z", gxTv_SdtEmpresa_abm_1_Empactcomercial_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpZonCod_Z", gxTv_SdtEmpresa_abm_1_Empzoncod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpZonDescrip_Z", gxTv_SdtEmpresa_abm_1_Empzondescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpReducc_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empreducc_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleDefIns_Z", gxTv_SdtEmpresa_abm_1_Tipempledefins_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLogoNom_Z", gxTv_SdtEmpresa_abm_1_Emplogonom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLogoExt_Z", gxTv_SdtEmpresa_abm_1_Emplogoext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpFirmaNom_Z", gxTv_SdtEmpresa_abm_1_Empfirmanom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpFirmaExt_Z", gxTv_SdtEmpresa_abm_1_Empfirmaext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpAntiguedad_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Empantiguedad_Z, 14, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpPresentismo_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Emppresentismo_Z, 14, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpMesHsPExt_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Empmeshspext_Z, 5, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLiqFer_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empliqfer_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLiqFerJor_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empliqferjor_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpDiaHsPExt_Z", gxTv_SdtEmpresa_abm_1_Empdiahspext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ARTSec_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Artsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpGuarEdadMin_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpGuarEdadMax_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLiqGan_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empliqgan_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTipoExp_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emptipoexp_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpPromDesde_Z", gxTv_SdtEmpresa_abm_1_Emppromdesde_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpFracVacAnt_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_Empfracvacant_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpVacExpLim_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empvacexplim_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpVacExpTie_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empvacexptie_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpVacDisMax_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empvacdismax_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActComCodigo_Z", gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpOsoCod_Z", gxTv_SdtEmpresa_abm_1_Emposocod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCondiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcondicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpModTra_Z", gxTv_SdtEmpresa_abm_1_Empmodtra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpModEmpl_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empmodempl_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpModAuto_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_Empmodauto_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTel_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emptel_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCP_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empcp_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Paicod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvCod_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Provcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LocCod_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Loccod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Actcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleCod_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Tipemplecod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpZonCod_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empzoncod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLogo_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emplogo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLogoNom_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emplogonom_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLogoExt_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emplogoext_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpFirma_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empfirma_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpFirmaNom_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empfirmanom_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpFirmaExt_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empfirmaext_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpMesHsPExt_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empmeshspext_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpDiaHsPExt_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Empdiahspext_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpOsoCod_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_Emposocod_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtEmpresa_abm_1_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtEmpresa_abm_1_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtEmpresa_abm_1_Empnom, false, includeNonInitialized);
      AddObjectProperty("EmpCUIT", gxTv_SdtEmpresa_abm_1_Empcuit, false, includeNonInitialized);
      AddObjectProperty("EmpDir", gxTv_SdtEmpresa_abm_1_Empdir, false, includeNonInitialized);
      AddObjectProperty("EmpTel", gxTv_SdtEmpresa_abm_1_Emptel, false, includeNonInitialized);
      AddObjectProperty("EmpTel_N", gxTv_SdtEmpresa_abm_1_Emptel_N, false, includeNonInitialized);
      AddObjectProperty("EmpCP", gxTv_SdtEmpresa_abm_1_Empcp, false, includeNonInitialized);
      AddObjectProperty("EmpCP_N", gxTv_SdtEmpresa_abm_1_Empcp_N, false, includeNonInitialized);
      AddObjectProperty("PaiCod", gxTv_SdtEmpresa_abm_1_Paicod, false, includeNonInitialized);
      AddObjectProperty("PaiCod_N", gxTv_SdtEmpresa_abm_1_Paicod_N, false, includeNonInitialized);
      AddObjectProperty("PaiNom", gxTv_SdtEmpresa_abm_1_Painom, false, includeNonInitialized);
      AddObjectProperty("ProvCod", gxTv_SdtEmpresa_abm_1_Provcod, false, includeNonInitialized);
      AddObjectProperty("ProvCod_N", gxTv_SdtEmpresa_abm_1_Provcod_N, false, includeNonInitialized);
      AddObjectProperty("ProvNom", gxTv_SdtEmpresa_abm_1_Provnom, false, includeNonInitialized);
      AddObjectProperty("EmpPerVacDes", gxTv_SdtEmpresa_abm_1_Emppervacdes, false, includeNonInitialized);
      AddObjectProperty("EmpPerVacHas", gxTv_SdtEmpresa_abm_1_Emppervachas, false, includeNonInitialized);
      AddObjectProperty("LocCod", gxTv_SdtEmpresa_abm_1_Loccod, false, includeNonInitialized);
      AddObjectProperty("LocCod_N", gxTv_SdtEmpresa_abm_1_Loccod_N, false, includeNonInitialized);
      AddObjectProperty("LocNom", gxTv_SdtEmpresa_abm_1_Locnom, false, includeNonInitialized);
      AddObjectProperty("ActCodigo", gxTv_SdtEmpresa_abm_1_Actcodigo, false, includeNonInitialized);
      AddObjectProperty("ActCodigo_N", gxTv_SdtEmpresa_abm_1_Actcodigo_N, false, includeNonInitialized);
      AddObjectProperty("ActDescrip", gxTv_SdtEmpresa_abm_1_Actdescrip, false, includeNonInitialized);
      AddObjectProperty("TipEmpleCod", gxTv_SdtEmpresa_abm_1_Tipemplecod, false, includeNonInitialized);
      AddObjectProperty("TipEmpleCod_N", gxTv_SdtEmpresa_abm_1_Tipemplecod_N, false, includeNonInitialized);
      AddObjectProperty("EmpActComercial", gxTv_SdtEmpresa_abm_1_Empactcomercial, false, includeNonInitialized);
      AddObjectProperty("EmpZonCod", gxTv_SdtEmpresa_abm_1_Empzoncod, false, includeNonInitialized);
      AddObjectProperty("EmpZonCod_N", gxTv_SdtEmpresa_abm_1_Empzoncod_N, false, includeNonInitialized);
      AddObjectProperty("EmpZonDescrip", gxTv_SdtEmpresa_abm_1_Empzondescrip, false, includeNonInitialized);
      AddObjectProperty("EmpReducc", gxTv_SdtEmpresa_abm_1_Empreducc, false, includeNonInitialized);
      AddObjectProperty("TipEmpleDefIns", gxTv_SdtEmpresa_abm_1_Tipempledefins, false, includeNonInitialized);
      AddObjectProperty("EmpLogo", gxTv_SdtEmpresa_abm_1_Emplogo, false, includeNonInitialized);
      AddObjectProperty("EmpLogo_N", gxTv_SdtEmpresa_abm_1_Emplogo_N, false, includeNonInitialized);
      AddObjectProperty("EmpLogoNom", gxTv_SdtEmpresa_abm_1_Emplogonom, false, includeNonInitialized);
      AddObjectProperty("EmpLogoNom_N", gxTv_SdtEmpresa_abm_1_Emplogonom_N, false, includeNonInitialized);
      AddObjectProperty("EmpLogoExt", gxTv_SdtEmpresa_abm_1_Emplogoext, false, includeNonInitialized);
      AddObjectProperty("EmpLogoExt_N", gxTv_SdtEmpresa_abm_1_Emplogoext_N, false, includeNonInitialized);
      AddObjectProperty("EmpFirma", gxTv_SdtEmpresa_abm_1_Empfirma, false, includeNonInitialized);
      AddObjectProperty("EmpFirma_N", gxTv_SdtEmpresa_abm_1_Empfirma_N, false, includeNonInitialized);
      AddObjectProperty("EmpFirmaNom", gxTv_SdtEmpresa_abm_1_Empfirmanom, false, includeNonInitialized);
      AddObjectProperty("EmpFirmaNom_N", gxTv_SdtEmpresa_abm_1_Empfirmanom_N, false, includeNonInitialized);
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados != null )
      {
         AddObjectProperty("conceptos_horanormal_mensualizados", gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados, includeState, includeNonInitialized);
      }
      AddObjectProperty("EmpFirmaExt", gxTv_SdtEmpresa_abm_1_Empfirmaext, false, includeNonInitialized);
      AddObjectProperty("EmpFirmaExt_N", gxTv_SdtEmpresa_abm_1_Empfirmaext_N, false, includeNonInitialized);
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados != null )
      {
         AddObjectProperty("conceptos_horanormal_jornalizados", gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados, includeState, includeNonInitialized);
      }
      AddObjectProperty("EmpAntiguedad", gxTv_SdtEmpresa_abm_1_Empantiguedad, false, includeNonInitialized);
      if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados != null )
      {
         AddObjectProperty("promedio_horanormal_mensualizados", gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados, includeState, includeNonInitialized);
      }
      AddObjectProperty("EmpPresentismo", gxTv_SdtEmpresa_abm_1_Emppresentismo, false, includeNonInitialized);
      AddObjectProperty("EmpMesHsPExt", gxTv_SdtEmpresa_abm_1_Empmeshspext, false, includeNonInitialized);
      AddObjectProperty("EmpMesHsPExt_N", gxTv_SdtEmpresa_abm_1_Empmeshspext_N, false, includeNonInitialized);
      AddObjectProperty("EmpLiqFer", gxTv_SdtEmpresa_abm_1_Empliqfer, false, includeNonInitialized);
      AddObjectProperty("EmpLiqFerJor", gxTv_SdtEmpresa_abm_1_Empliqferjor, false, includeNonInitialized);
      AddObjectProperty("EmpDiaHsPExt", gxTv_SdtEmpresa_abm_1_Empdiahspext, false, includeNonInitialized);
      AddObjectProperty("EmpDiaHsPExt_N", gxTv_SdtEmpresa_abm_1_Empdiahspext_N, false, includeNonInitialized);
      AddObjectProperty("ARTSec", gxTv_SdtEmpresa_abm_1_Artsec, false, includeNonInitialized);
      if ( gxTv_SdtEmpresa_abm_1_Base_calculo != null )
      {
         AddObjectProperty("base_calculo", gxTv_SdtEmpresa_abm_1_Base_calculo, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia != null )
      {
         AddObjectProperty("horasextras_pordia", gxTv_SdtEmpresa_abm_1_Horasextras_pordia, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo != null )
      {
         AddObjectProperty("tipo_trabajo", gxTv_SdtEmpresa_abm_1_Tipo_trabajo, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio != null )
      {
         AddObjectProperty("nolaborables_convenio", gxTv_SdtEmpresa_abm_1_Nolaborables_convenio, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen != null )
      {
         AddObjectProperty("nolaborables_origen", gxTv_SdtEmpresa_abm_1_Nolaborables_origen, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion != null )
      {
         AddObjectProperty("nolaborables_religion", gxTv_SdtEmpresa_abm_1_Nolaborables_religion, includeState, includeNonInitialized);
      }
      AddObjectProperty("EmpGuarEdadMin", gxTv_SdtEmpresa_abm_1_Empguaredadmin, false, includeNonInitialized);
      AddObjectProperty("EmpGuarEdadMax", gxTv_SdtEmpresa_abm_1_Empguaredadmax, false, includeNonInitialized);
      AddObjectProperty("EmpLiqGan", gxTv_SdtEmpresa_abm_1_Empliqgan, false, includeNonInitialized);
      AddObjectProperty("EmpTipoExp", gxTv_SdtEmpresa_abm_1_Emptipoexp, false, includeNonInitialized);
      AddObjectProperty("EmpPromDesde", gxTv_SdtEmpresa_abm_1_Emppromdesde, false, includeNonInitialized);
      AddObjectProperty("EmpFracVacAnt", gxTv_SdtEmpresa_abm_1_Empfracvacant, false, includeNonInitialized);
      AddObjectProperty("EmpVacExpLim", gxTv_SdtEmpresa_abm_1_Empvacexplim, false, includeNonInitialized);
      AddObjectProperty("EmpVacExpTie", gxTv_SdtEmpresa_abm_1_Empvacexptie, false, includeNonInitialized);
      AddObjectProperty("EmpVacDisMax", gxTv_SdtEmpresa_abm_1_Empvacdismax, false, includeNonInitialized);
      AddObjectProperty("ActComCodigo", gxTv_SdtEmpresa_abm_1_Actcomcodigo, false, includeNonInitialized);
      AddObjectProperty("EmpOsoCod", gxTv_SdtEmpresa_abm_1_Emposocod, false, includeNonInitialized);
      AddObjectProperty("EmpOsoCod_N", gxTv_SdtEmpresa_abm_1_Emposocod_N, false, includeNonInitialized);
      AddObjectProperty("EmpCondiCod", gxTv_SdtEmpresa_abm_1_Empcondicod, false, includeNonInitialized);
      AddObjectProperty("EmpModTra", gxTv_SdtEmpresa_abm_1_Empmodtra, false, includeNonInitialized);
      AddObjectProperty("EmpModEmpl", gxTv_SdtEmpresa_abm_1_Empmodempl, false, includeNonInitialized);
      AddObjectProperty("EmpModAuto", gxTv_SdtEmpresa_abm_1_Empmodauto, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtEmpresa_abm_1_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtEmpresa_abm_1_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtEmpresa_abm_1_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCUIT_Z", gxTv_SdtEmpresa_abm_1_Empcuit_Z, false, includeNonInitialized);
         AddObjectProperty("EmpDir_Z", gxTv_SdtEmpresa_abm_1_Empdir_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTel_Z", gxTv_SdtEmpresa_abm_1_Emptel_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCP_Z", gxTv_SdtEmpresa_abm_1_Empcp_Z, false, includeNonInitialized);
         AddObjectProperty("PaiCod_Z", gxTv_SdtEmpresa_abm_1_Paicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiNom_Z", gxTv_SdtEmpresa_abm_1_Painom_Z, false, includeNonInitialized);
         AddObjectProperty("ProvCod_Z", gxTv_SdtEmpresa_abm_1_Provcod_Z, false, includeNonInitialized);
         AddObjectProperty("ProvNom_Z", gxTv_SdtEmpresa_abm_1_Provnom_Z, false, includeNonInitialized);
         AddObjectProperty("EmpPerVacDes_Z", gxTv_SdtEmpresa_abm_1_Emppervacdes_Z, false, includeNonInitialized);
         AddObjectProperty("EmpPerVacHas_Z", gxTv_SdtEmpresa_abm_1_Emppervachas_Z, false, includeNonInitialized);
         AddObjectProperty("LocCod_Z", gxTv_SdtEmpresa_abm_1_Loccod_Z, false, includeNonInitialized);
         AddObjectProperty("LocNom_Z", gxTv_SdtEmpresa_abm_1_Locnom_Z, false, includeNonInitialized);
         AddObjectProperty("ActCodigo_Z", gxTv_SdtEmpresa_abm_1_Actcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ActDescrip_Z", gxTv_SdtEmpresa_abm_1_Actdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("TipEmpleCod_Z", gxTv_SdtEmpresa_abm_1_Tipemplecod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpActComercial_Z", gxTv_SdtEmpresa_abm_1_Empactcomercial_Z, false, includeNonInitialized);
         AddObjectProperty("EmpZonCod_Z", gxTv_SdtEmpresa_abm_1_Empzoncod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpZonDescrip_Z", gxTv_SdtEmpresa_abm_1_Empzondescrip_Z, false, includeNonInitialized);
         AddObjectProperty("EmpReducc_Z", gxTv_SdtEmpresa_abm_1_Empreducc_Z, false, includeNonInitialized);
         AddObjectProperty("TipEmpleDefIns_Z", gxTv_SdtEmpresa_abm_1_Tipempledefins_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLogoNom_Z", gxTv_SdtEmpresa_abm_1_Emplogonom_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLogoExt_Z", gxTv_SdtEmpresa_abm_1_Emplogoext_Z, false, includeNonInitialized);
         AddObjectProperty("EmpFirmaNom_Z", gxTv_SdtEmpresa_abm_1_Empfirmanom_Z, false, includeNonInitialized);
         AddObjectProperty("EmpFirmaExt_Z", gxTv_SdtEmpresa_abm_1_Empfirmaext_Z, false, includeNonInitialized);
         AddObjectProperty("EmpAntiguedad_Z", gxTv_SdtEmpresa_abm_1_Empantiguedad_Z, false, includeNonInitialized);
         AddObjectProperty("EmpPresentismo_Z", gxTv_SdtEmpresa_abm_1_Emppresentismo_Z, false, includeNonInitialized);
         AddObjectProperty("EmpMesHsPExt_Z", gxTv_SdtEmpresa_abm_1_Empmeshspext_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLiqFer_Z", gxTv_SdtEmpresa_abm_1_Empliqfer_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLiqFerJor_Z", gxTv_SdtEmpresa_abm_1_Empliqferjor_Z, false, includeNonInitialized);
         AddObjectProperty("EmpDiaHsPExt_Z", gxTv_SdtEmpresa_abm_1_Empdiahspext_Z, false, includeNonInitialized);
         AddObjectProperty("ARTSec_Z", gxTv_SdtEmpresa_abm_1_Artsec_Z, false, includeNonInitialized);
         AddObjectProperty("EmpGuarEdadMin_Z", gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z, false, includeNonInitialized);
         AddObjectProperty("EmpGuarEdadMax_Z", gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLiqGan_Z", gxTv_SdtEmpresa_abm_1_Empliqgan_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTipoExp_Z", gxTv_SdtEmpresa_abm_1_Emptipoexp_Z, false, includeNonInitialized);
         AddObjectProperty("EmpPromDesde_Z", gxTv_SdtEmpresa_abm_1_Emppromdesde_Z, false, includeNonInitialized);
         AddObjectProperty("EmpFracVacAnt_Z", gxTv_SdtEmpresa_abm_1_Empfracvacant_Z, false, includeNonInitialized);
         AddObjectProperty("EmpVacExpLim_Z", gxTv_SdtEmpresa_abm_1_Empvacexplim_Z, false, includeNonInitialized);
         AddObjectProperty("EmpVacExpTie_Z", gxTv_SdtEmpresa_abm_1_Empvacexptie_Z, false, includeNonInitialized);
         AddObjectProperty("EmpVacDisMax_Z", gxTv_SdtEmpresa_abm_1_Empvacdismax_Z, false, includeNonInitialized);
         AddObjectProperty("ActComCodigo_Z", gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("EmpOsoCod_Z", gxTv_SdtEmpresa_abm_1_Emposocod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCondiCod_Z", gxTv_SdtEmpresa_abm_1_Empcondicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpModTra_Z", gxTv_SdtEmpresa_abm_1_Empmodtra_Z, false, includeNonInitialized);
         AddObjectProperty("EmpModEmpl_Z", gxTv_SdtEmpresa_abm_1_Empmodempl_Z, false, includeNonInitialized);
         AddObjectProperty("EmpModAuto_Z", gxTv_SdtEmpresa_abm_1_Empmodauto_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTel_N", gxTv_SdtEmpresa_abm_1_Emptel_N, false, includeNonInitialized);
         AddObjectProperty("EmpCP_N", gxTv_SdtEmpresa_abm_1_Empcp_N, false, includeNonInitialized);
         AddObjectProperty("PaiCod_N", gxTv_SdtEmpresa_abm_1_Paicod_N, false, includeNonInitialized);
         AddObjectProperty("ProvCod_N", gxTv_SdtEmpresa_abm_1_Provcod_N, false, includeNonInitialized);
         AddObjectProperty("LocCod_N", gxTv_SdtEmpresa_abm_1_Loccod_N, false, includeNonInitialized);
         AddObjectProperty("ActCodigo_N", gxTv_SdtEmpresa_abm_1_Actcodigo_N, false, includeNonInitialized);
         AddObjectProperty("TipEmpleCod_N", gxTv_SdtEmpresa_abm_1_Tipemplecod_N, false, includeNonInitialized);
         AddObjectProperty("EmpZonCod_N", gxTv_SdtEmpresa_abm_1_Empzoncod_N, false, includeNonInitialized);
         AddObjectProperty("EmpLogo_N", gxTv_SdtEmpresa_abm_1_Emplogo_N, false, includeNonInitialized);
         AddObjectProperty("EmpLogoNom_N", gxTv_SdtEmpresa_abm_1_Emplogonom_N, false, includeNonInitialized);
         AddObjectProperty("EmpLogoExt_N", gxTv_SdtEmpresa_abm_1_Emplogoext_N, false, includeNonInitialized);
         AddObjectProperty("EmpFirma_N", gxTv_SdtEmpresa_abm_1_Empfirma_N, false, includeNonInitialized);
         AddObjectProperty("EmpFirmaNom_N", gxTv_SdtEmpresa_abm_1_Empfirmanom_N, false, includeNonInitialized);
         AddObjectProperty("EmpFirmaExt_N", gxTv_SdtEmpresa_abm_1_Empfirmaext_N, false, includeNonInitialized);
         AddObjectProperty("EmpMesHsPExt_N", gxTv_SdtEmpresa_abm_1_Empmeshspext_N, false, includeNonInitialized);
         AddObjectProperty("EmpDiaHsPExt_N", gxTv_SdtEmpresa_abm_1_Empdiahspext_N, false, includeNonInitialized);
         AddObjectProperty("EmpOsoCod_N", gxTv_SdtEmpresa_abm_1_Emposocod_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1 sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Clicod = sdt.getgxTv_SdtEmpresa_abm_1_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empcod = sdt.getgxTv_SdtEmpresa_abm_1_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empnom = sdt.getgxTv_SdtEmpresa_abm_1_Empnom() ;
      }
      if ( sdt.IsDirty("EmpCUIT") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empcuit = sdt.getgxTv_SdtEmpresa_abm_1_Empcuit() ;
      }
      if ( sdt.IsDirty("EmpDir") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empdir = sdt.getgxTv_SdtEmpresa_abm_1_Empdir() ;
      }
      if ( sdt.IsDirty("EmpTel") )
      {
         gxTv_SdtEmpresa_abm_1_Emptel_N = sdt.getgxTv_SdtEmpresa_abm_1_Emptel_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emptel = sdt.getgxTv_SdtEmpresa_abm_1_Emptel() ;
      }
      if ( sdt.IsDirty("EmpCP") )
      {
         gxTv_SdtEmpresa_abm_1_Empcp_N = sdt.getgxTv_SdtEmpresa_abm_1_Empcp_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empcp = sdt.getgxTv_SdtEmpresa_abm_1_Empcp() ;
      }
      if ( sdt.IsDirty("PaiCod") )
      {
         gxTv_SdtEmpresa_abm_1_Paicod_N = sdt.getgxTv_SdtEmpresa_abm_1_Paicod_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Paicod = sdt.getgxTv_SdtEmpresa_abm_1_Paicod() ;
      }
      if ( sdt.IsDirty("PaiNom") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Painom = sdt.getgxTv_SdtEmpresa_abm_1_Painom() ;
      }
      if ( sdt.IsDirty("ProvCod") )
      {
         gxTv_SdtEmpresa_abm_1_Provcod_N = sdt.getgxTv_SdtEmpresa_abm_1_Provcod_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Provcod = sdt.getgxTv_SdtEmpresa_abm_1_Provcod() ;
      }
      if ( sdt.IsDirty("ProvNom") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Provnom = sdt.getgxTv_SdtEmpresa_abm_1_Provnom() ;
      }
      if ( sdt.IsDirty("EmpPerVacDes") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emppervacdes = sdt.getgxTv_SdtEmpresa_abm_1_Emppervacdes() ;
      }
      if ( sdt.IsDirty("EmpPerVacHas") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emppervachas = sdt.getgxTv_SdtEmpresa_abm_1_Emppervachas() ;
      }
      if ( sdt.IsDirty("LocCod") )
      {
         gxTv_SdtEmpresa_abm_1_Loccod_N = sdt.getgxTv_SdtEmpresa_abm_1_Loccod_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Loccod = sdt.getgxTv_SdtEmpresa_abm_1_Loccod() ;
      }
      if ( sdt.IsDirty("LocNom") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Locnom = sdt.getgxTv_SdtEmpresa_abm_1_Locnom() ;
      }
      if ( sdt.IsDirty("ActCodigo") )
      {
         gxTv_SdtEmpresa_abm_1_Actcodigo_N = sdt.getgxTv_SdtEmpresa_abm_1_Actcodigo_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Actcodigo = sdt.getgxTv_SdtEmpresa_abm_1_Actcodigo() ;
      }
      if ( sdt.IsDirty("ActDescrip") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Actdescrip = sdt.getgxTv_SdtEmpresa_abm_1_Actdescrip() ;
      }
      if ( sdt.IsDirty("TipEmpleCod") )
      {
         gxTv_SdtEmpresa_abm_1_Tipemplecod_N = sdt.getgxTv_SdtEmpresa_abm_1_Tipemplecod_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Tipemplecod = sdt.getgxTv_SdtEmpresa_abm_1_Tipemplecod() ;
      }
      if ( sdt.IsDirty("EmpActComercial") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empactcomercial = sdt.getgxTv_SdtEmpresa_abm_1_Empactcomercial() ;
      }
      if ( sdt.IsDirty("EmpZonCod") )
      {
         gxTv_SdtEmpresa_abm_1_Empzoncod_N = sdt.getgxTv_SdtEmpresa_abm_1_Empzoncod_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empzoncod = sdt.getgxTv_SdtEmpresa_abm_1_Empzoncod() ;
      }
      if ( sdt.IsDirty("EmpZonDescrip") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empzondescrip = sdt.getgxTv_SdtEmpresa_abm_1_Empzondescrip() ;
      }
      if ( sdt.IsDirty("EmpReducc") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empreducc = sdt.getgxTv_SdtEmpresa_abm_1_Empreducc() ;
      }
      if ( sdt.IsDirty("TipEmpleDefIns") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Tipempledefins = sdt.getgxTv_SdtEmpresa_abm_1_Tipempledefins() ;
      }
      if ( sdt.IsDirty("EmpLogo") )
      {
         gxTv_SdtEmpresa_abm_1_Emplogo_N = sdt.getgxTv_SdtEmpresa_abm_1_Emplogo_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emplogo = sdt.getgxTv_SdtEmpresa_abm_1_Emplogo() ;
      }
      if ( sdt.IsDirty("EmpLogoNom") )
      {
         gxTv_SdtEmpresa_abm_1_Emplogonom_N = sdt.getgxTv_SdtEmpresa_abm_1_Emplogonom_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emplogonom = sdt.getgxTv_SdtEmpresa_abm_1_Emplogonom() ;
      }
      if ( sdt.IsDirty("EmpLogoExt") )
      {
         gxTv_SdtEmpresa_abm_1_Emplogoext_N = sdt.getgxTv_SdtEmpresa_abm_1_Emplogoext_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emplogoext = sdt.getgxTv_SdtEmpresa_abm_1_Emplogoext() ;
      }
      if ( sdt.IsDirty("EmpFirma") )
      {
         gxTv_SdtEmpresa_abm_1_Empfirma_N = sdt.getgxTv_SdtEmpresa_abm_1_Empfirma_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empfirma = sdt.getgxTv_SdtEmpresa_abm_1_Empfirma() ;
      }
      if ( sdt.IsDirty("EmpFirmaNom") )
      {
         gxTv_SdtEmpresa_abm_1_Empfirmanom_N = sdt.getgxTv_SdtEmpresa_abm_1_Empfirmanom_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empfirmanom = sdt.getgxTv_SdtEmpresa_abm_1_Empfirmanom() ;
      }
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> newCollectionConceptos_horanormal_mensualizados = sdt.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados();
         web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados currItemConceptos_horanormal_mensualizados;
         web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados newItemConceptos_horanormal_mensualizados;
         short idx = 1;
         while ( idx <= newCollectionConceptos_horanormal_mensualizados.size() )
         {
            newItemConceptos_horanormal_mensualizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)newCollectionConceptos_horanormal_mensualizados.elementAt(-1+idx));
            currItemConceptos_horanormal_mensualizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados.getByKey(newItemConceptos_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo());
            if ( GXutil.strcmp(currItemConceptos_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode(), "UPD") == 0 )
            {
               currItemConceptos_horanormal_mensualizados.updateDirties(newItemConceptos_horanormal_mensualizados);
               if ( GXutil.strcmp(newItemConceptos_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode(), "DLT") == 0 )
               {
                  currItemConceptos_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( "DLT" );
               }
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados.add(newItemConceptos_horanormal_mensualizados, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("EmpFirmaExt") )
      {
         gxTv_SdtEmpresa_abm_1_Empfirmaext_N = sdt.getgxTv_SdtEmpresa_abm_1_Empfirmaext_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empfirmaext = sdt.getgxTv_SdtEmpresa_abm_1_Empfirmaext() ;
      }
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> newCollectionConceptos_horanormal_jornalizados = sdt.getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados();
         web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados currItemConceptos_horanormal_jornalizados;
         web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados newItemConceptos_horanormal_jornalizados;
         short idx = 1;
         while ( idx <= newCollectionConceptos_horanormal_jornalizados.size() )
         {
            newItemConceptos_horanormal_jornalizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)newCollectionConceptos_horanormal_jornalizados.elementAt(-1+idx));
            currItemConceptos_horanormal_jornalizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados.getByKey(newItemConceptos_horanormal_jornalizados.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo());
            if ( GXutil.strcmp(currItemConceptos_horanormal_jornalizados.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode(), "UPD") == 0 )
            {
               currItemConceptos_horanormal_jornalizados.updateDirties(newItemConceptos_horanormal_jornalizados);
               if ( GXutil.strcmp(newItemConceptos_horanormal_jornalizados.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode(), "DLT") == 0 )
               {
                  currItemConceptos_horanormal_jornalizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( "DLT" );
               }
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados.add(newItemConceptos_horanormal_jornalizados, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("EmpAntiguedad") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empantiguedad = sdt.getgxTv_SdtEmpresa_abm_1_Empantiguedad() ;
      }
      if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> newCollectionPromedio_horanormal_mensualizados = sdt.getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados();
         web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados currItemPromedio_horanormal_mensualizados;
         web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados newItemPromedio_horanormal_mensualizados;
         short idx = 1;
         while ( idx <= newCollectionPromedio_horanormal_mensualizados.size() )
         {
            newItemPromedio_horanormal_mensualizados = (web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)newCollectionPromedio_horanormal_mensualizados.elementAt(-1+idx));
            currItemPromedio_horanormal_mensualizados = (web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados.getByKey(newItemPromedio_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod(), newItemPromedio_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar());
            if ( GXutil.strcmp(currItemPromedio_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode(), "UPD") == 0 )
            {
               currItemPromedio_horanormal_mensualizados.updateDirties(newItemPromedio_horanormal_mensualizados);
               if ( GXutil.strcmp(newItemPromedio_horanormal_mensualizados.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode(), "DLT") == 0 )
               {
                  currItemPromedio_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( "DLT" );
               }
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados.add(newItemPromedio_horanormal_mensualizados, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("EmpPresentismo") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emppresentismo = sdt.getgxTv_SdtEmpresa_abm_1_Emppresentismo() ;
      }
      if ( sdt.IsDirty("EmpMesHsPExt") )
      {
         gxTv_SdtEmpresa_abm_1_Empmeshspext_N = sdt.getgxTv_SdtEmpresa_abm_1_Empmeshspext_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empmeshspext = sdt.getgxTv_SdtEmpresa_abm_1_Empmeshspext() ;
      }
      if ( sdt.IsDirty("EmpLiqFer") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empliqfer = sdt.getgxTv_SdtEmpresa_abm_1_Empliqfer() ;
      }
      if ( sdt.IsDirty("EmpLiqFerJor") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empliqferjor = sdt.getgxTv_SdtEmpresa_abm_1_Empliqferjor() ;
      }
      if ( sdt.IsDirty("EmpDiaHsPExt") )
      {
         gxTv_SdtEmpresa_abm_1_Empdiahspext_N = sdt.getgxTv_SdtEmpresa_abm_1_Empdiahspext_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empdiahspext = sdt.getgxTv_SdtEmpresa_abm_1_Empdiahspext() ;
      }
      if ( sdt.IsDirty("ARTSec") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Artsec = sdt.getgxTv_SdtEmpresa_abm_1_Artsec() ;
      }
      if ( gxTv_SdtEmpresa_abm_1_Base_calculo != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> newCollectionBase_calculo = sdt.getgxTv_SdtEmpresa_abm_1_Base_calculo();
         web.SdtEmpresa_abm_1_base_calculo currItemBase_calculo;
         web.SdtEmpresa_abm_1_base_calculo newItemBase_calculo;
         short idx = 1;
         while ( idx <= newCollectionBase_calculo.size() )
         {
            newItemBase_calculo = (web.SdtEmpresa_abm_1_base_calculo)((web.SdtEmpresa_abm_1_base_calculo)newCollectionBase_calculo.elementAt(-1+idx));
            currItemBase_calculo = (web.SdtEmpresa_abm_1_base_calculo)gxTv_SdtEmpresa_abm_1_Base_calculo.getByKey(newItemBase_calculo.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg(), newItemBase_calculo.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo(), newItemBase_calculo.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1(), newItemBase_calculo.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2());
            if ( GXutil.strcmp(currItemBase_calculo.getgxTv_SdtEmpresa_abm_1_base_calculo_Mode(), "UPD") == 0 )
            {
               currItemBase_calculo.updateDirties(newItemBase_calculo);
               if ( GXutil.strcmp(newItemBase_calculo.getgxTv_SdtEmpresa_abm_1_base_calculo_Mode(), "DLT") == 0 )
               {
                  currItemBase_calculo.setgxTv_SdtEmpresa_abm_1_base_calculo_Mode( "DLT" );
               }
               currItemBase_calculo.setgxTv_SdtEmpresa_abm_1_base_calculo_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Base_calculo.add(newItemBase_calculo, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> newCollectionHorasextras_pordia = sdt.getgxTv_SdtEmpresa_abm_1_Horasextras_pordia();
         web.SdtEmpresa_abm_1_horasextras_pordia currItemHorasextras_pordia;
         web.SdtEmpresa_abm_1_horasextras_pordia newItemHorasextras_pordia;
         short idx = 1;
         while ( idx <= newCollectionHorasextras_pordia.size() )
         {
            newItemHorasextras_pordia = (web.SdtEmpresa_abm_1_horasextras_pordia)((web.SdtEmpresa_abm_1_horasextras_pordia)newCollectionHorasextras_pordia.elementAt(-1+idx));
            currItemHorasextras_pordia = (web.SdtEmpresa_abm_1_horasextras_pordia)gxTv_SdtEmpresa_abm_1_Horasextras_pordia.getByKey(newItemHorasextras_pordia.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Emphsexsec());
            if ( GXutil.strcmp(currItemHorasextras_pordia.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode(), "UPD") == 0 )
            {
               currItemHorasextras_pordia.updateDirties(newItemHorasextras_pordia);
               if ( GXutil.strcmp(newItemHorasextras_pordia.getgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode(), "DLT") == 0 )
               {
                  currItemHorasextras_pordia.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode( "DLT" );
               }
               currItemHorasextras_pordia.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Horasextras_pordia.add(newItemHorasextras_pordia, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> newCollectionTipo_trabajo = sdt.getgxTv_SdtEmpresa_abm_1_Tipo_trabajo();
         web.SdtEmpresa_abm_1_tipo_trabajo currItemTipo_trabajo;
         web.SdtEmpresa_abm_1_tipo_trabajo newItemTipo_trabajo;
         short idx = 1;
         while ( idx <= newCollectionTipo_trabajo.size() )
         {
            newItemTipo_trabajo = (web.SdtEmpresa_abm_1_tipo_trabajo)((web.SdtEmpresa_abm_1_tipo_trabajo)newCollectionTipo_trabajo.elementAt(-1+idx));
            currItemTipo_trabajo = (web.SdtEmpresa_abm_1_tipo_trabajo)gxTv_SdtEmpresa_abm_1_Tipo_trabajo.getByKey(newItemTipo_trabajo.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Paitipotraid());
            if ( GXutil.strcmp(currItemTipo_trabajo.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode(), "UPD") == 0 )
            {
               currItemTipo_trabajo.updateDirties(newItemTipo_trabajo);
               if ( GXutil.strcmp(newItemTipo_trabajo.getgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode(), "DLT") == 0 )
               {
                  currItemTipo_trabajo.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode( "DLT" );
               }
               currItemTipo_trabajo.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Tipo_trabajo.add(newItemTipo_trabajo, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> newCollectionNolaborables_convenio = sdt.getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio();
         web.SdtEmpresa_abm_1_nolaborables_convenio currItemNolaborables_convenio;
         web.SdtEmpresa_abm_1_nolaborables_convenio newItemNolaborables_convenio;
         short idx = 1;
         while ( idx <= newCollectionNolaborables_convenio.size() )
         {
            newItemNolaborables_convenio = (web.SdtEmpresa_abm_1_nolaborables_convenio)((web.SdtEmpresa_abm_1_nolaborables_convenio)newCollectionNolaborables_convenio.elementAt(-1+idx));
            currItemNolaborables_convenio = (web.SdtEmpresa_abm_1_nolaborables_convenio)gxTv_SdtEmpresa_abm_1_Nolaborables_convenio.getByKey(newItemNolaborables_convenio.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio());
            if ( GXutil.strcmp(currItemNolaborables_convenio.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode(), "UPD") == 0 )
            {
               currItemNolaborables_convenio.updateDirties(newItemNolaborables_convenio);
               if ( GXutil.strcmp(newItemNolaborables_convenio.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode(), "DLT") == 0 )
               {
                  currItemNolaborables_convenio.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( "DLT" );
               }
               currItemNolaborables_convenio.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Nolaborables_convenio.add(newItemNolaborables_convenio, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> newCollectionNolaborables_origen = sdt.getgxTv_SdtEmpresa_abm_1_Nolaborables_origen();
         web.SdtEmpresa_abm_1_nolaborables_origen currItemNolaborables_origen;
         web.SdtEmpresa_abm_1_nolaborables_origen newItemNolaborables_origen;
         short idx = 1;
         while ( idx <= newCollectionNolaborables_origen.size() )
         {
            newItemNolaborables_origen = (web.SdtEmpresa_abm_1_nolaborables_origen)((web.SdtEmpresa_abm_1_nolaborables_origen)newCollectionNolaborables_origen.elementAt(-1+idx));
            currItemNolaborables_origen = (web.SdtEmpresa_abm_1_nolaborables_origen)gxTv_SdtEmpresa_abm_1_Nolaborables_origen.getByKey(newItemNolaborables_origen.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Emporigen());
            if ( GXutil.strcmp(currItemNolaborables_origen.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode(), "UPD") == 0 )
            {
               currItemNolaborables_origen.updateDirties(newItemNolaborables_origen);
               if ( GXutil.strcmp(newItemNolaborables_origen.getgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode(), "DLT") == 0 )
               {
                  currItemNolaborables_origen.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode( "DLT" );
               }
               currItemNolaborables_origen.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Nolaborables_origen.add(newItemNolaborables_origen, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion != null )
      {
         GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> newCollectionNolaborables_religion = sdt.getgxTv_SdtEmpresa_abm_1_Nolaborables_religion();
         web.SdtEmpresa_abm_1_nolaborables_religion currItemNolaborables_religion;
         web.SdtEmpresa_abm_1_nolaborables_religion newItemNolaborables_religion;
         short idx = 1;
         while ( idx <= newCollectionNolaborables_religion.size() )
         {
            newItemNolaborables_religion = (web.SdtEmpresa_abm_1_nolaborables_religion)((web.SdtEmpresa_abm_1_nolaborables_religion)newCollectionNolaborables_religion.elementAt(-1+idx));
            currItemNolaborables_religion = (web.SdtEmpresa_abm_1_nolaborables_religion)gxTv_SdtEmpresa_abm_1_Nolaborables_religion.getByKey(newItemNolaborables_religion.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion());
            if ( GXutil.strcmp(currItemNolaborables_religion.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode(), "UPD") == 0 )
            {
               currItemNolaborables_religion.updateDirties(newItemNolaborables_religion);
               if ( GXutil.strcmp(newItemNolaborables_religion.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode(), "DLT") == 0 )
               {
                  currItemNolaborables_religion.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( "DLT" );
               }
               currItemNolaborables_religion.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtEmpresa_abm_1_Nolaborables_religion.add(newItemNolaborables_religion, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( sdt.IsDirty("EmpGuarEdadMin") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empguaredadmin = sdt.getgxTv_SdtEmpresa_abm_1_Empguaredadmin() ;
      }
      if ( sdt.IsDirty("EmpGuarEdadMax") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empguaredadmax = sdt.getgxTv_SdtEmpresa_abm_1_Empguaredadmax() ;
      }
      if ( sdt.IsDirty("EmpLiqGan") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empliqgan = sdt.getgxTv_SdtEmpresa_abm_1_Empliqgan() ;
      }
      if ( sdt.IsDirty("EmpTipoExp") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emptipoexp = sdt.getgxTv_SdtEmpresa_abm_1_Emptipoexp() ;
      }
      if ( sdt.IsDirty("EmpPromDesde") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emppromdesde = sdt.getgxTv_SdtEmpresa_abm_1_Emppromdesde() ;
      }
      if ( sdt.IsDirty("EmpFracVacAnt") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empfracvacant = sdt.getgxTv_SdtEmpresa_abm_1_Empfracvacant() ;
      }
      if ( sdt.IsDirty("EmpVacExpLim") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empvacexplim = sdt.getgxTv_SdtEmpresa_abm_1_Empvacexplim() ;
      }
      if ( sdt.IsDirty("EmpVacExpTie") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empvacexptie = sdt.getgxTv_SdtEmpresa_abm_1_Empvacexptie() ;
      }
      if ( sdt.IsDirty("EmpVacDisMax") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empvacdismax = sdt.getgxTv_SdtEmpresa_abm_1_Empvacdismax() ;
      }
      if ( sdt.IsDirty("ActComCodigo") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Actcomcodigo = sdt.getgxTv_SdtEmpresa_abm_1_Actcomcodigo() ;
      }
      if ( sdt.IsDirty("EmpOsoCod") )
      {
         gxTv_SdtEmpresa_abm_1_Emposocod_N = sdt.getgxTv_SdtEmpresa_abm_1_Emposocod_N() ;
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Emposocod = sdt.getgxTv_SdtEmpresa_abm_1_Emposocod() ;
      }
      if ( sdt.IsDirty("EmpCondiCod") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empcondicod = sdt.getgxTv_SdtEmpresa_abm_1_Empcondicod() ;
      }
      if ( sdt.IsDirty("EmpModTra") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empmodtra = sdt.getgxTv_SdtEmpresa_abm_1_Empmodtra() ;
      }
      if ( sdt.IsDirty("EmpModEmpl") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empmodempl = sdt.getgxTv_SdtEmpresa_abm_1_Empmodempl() ;
      }
      if ( sdt.IsDirty("EmpModAuto") )
      {
         gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_Empmodauto = sdt.getgxTv_SdtEmpresa_abm_1_Empmodauto() ;
      }
   }

   public int getgxTv_SdtEmpresa_abm_1_Clicod( )
   {
      return gxTv_SdtEmpresa_abm_1_Clicod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Clicod( int value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      if ( gxTv_SdtEmpresa_abm_1_Clicod != value )
      {
         gxTv_SdtEmpresa_abm_1_Mode = "INS" ;
         this.setgxTv_SdtEmpresa_abm_1_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empnom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcuit_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empdir_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emptel_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcp_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Paicod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Painom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Provcod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Provnom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppervacdes_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppervachas_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Loccod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Locnom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Actcodigo_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Actdescrip_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empactcomercial_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empzoncod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empzondescrip_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empreducc_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Tipempledefins_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emplogonom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emplogoext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empfirmanom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empfirmaext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empantiguedad_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppresentismo_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmeshspext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empliqfer_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empliqferjor_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empdiahspext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Artsec_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empliqgan_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emptipoexp_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppromdesde_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empfracvacant_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empvacexplim_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empvacexptie_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empvacdismax_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emposocod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcondicod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmodtra_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmodempl_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmodauto_Z_SetNull( );
         if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> collectionConceptos_horanormal_mensualizados = gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados;
            web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados currItemConceptos_horanormal_mensualizados;
            short idx = 1;
            while ( idx <= collectionConceptos_horanormal_mensualizados.size() )
            {
               currItemConceptos_horanormal_mensualizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)collectionConceptos_horanormal_mensualizados.elementAt(-1+idx));
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( "INS" );
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> collectionConceptos_horanormal_jornalizados = gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados;
            web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados currItemConceptos_horanormal_jornalizados;
            short idx = 1;
            while ( idx <= collectionConceptos_horanormal_jornalizados.size() )
            {
               currItemConceptos_horanormal_jornalizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)collectionConceptos_horanormal_jornalizados.elementAt(-1+idx));
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( "INS" );
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> collectionPromedio_horanormal_mensualizados = gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados;
            web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados currItemPromedio_horanormal_mensualizados;
            short idx = 1;
            while ( idx <= collectionPromedio_horanormal_mensualizados.size() )
            {
               currItemPromedio_horanormal_mensualizados = (web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)collectionPromedio_horanormal_mensualizados.elementAt(-1+idx));
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( "INS" );
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Base_calculo != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> collectionBase_calculo = gxTv_SdtEmpresa_abm_1_Base_calculo;
            web.SdtEmpresa_abm_1_base_calculo currItemBase_calculo;
            short idx = 1;
            while ( idx <= collectionBase_calculo.size() )
            {
               currItemBase_calculo = (web.SdtEmpresa_abm_1_base_calculo)((web.SdtEmpresa_abm_1_base_calculo)collectionBase_calculo.elementAt(-1+idx));
               currItemBase_calculo.setgxTv_SdtEmpresa_abm_1_base_calculo_Mode( "INS" );
               currItemBase_calculo.setgxTv_SdtEmpresa_abm_1_base_calculo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> collectionHorasextras_pordia = gxTv_SdtEmpresa_abm_1_Horasextras_pordia;
            web.SdtEmpresa_abm_1_horasextras_pordia currItemHorasextras_pordia;
            short idx = 1;
            while ( idx <= collectionHorasextras_pordia.size() )
            {
               currItemHorasextras_pordia = (web.SdtEmpresa_abm_1_horasextras_pordia)((web.SdtEmpresa_abm_1_horasextras_pordia)collectionHorasextras_pordia.elementAt(-1+idx));
               currItemHorasextras_pordia.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode( "INS" );
               currItemHorasextras_pordia.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> collectionTipo_trabajo = gxTv_SdtEmpresa_abm_1_Tipo_trabajo;
            web.SdtEmpresa_abm_1_tipo_trabajo currItemTipo_trabajo;
            short idx = 1;
            while ( idx <= collectionTipo_trabajo.size() )
            {
               currItemTipo_trabajo = (web.SdtEmpresa_abm_1_tipo_trabajo)((web.SdtEmpresa_abm_1_tipo_trabajo)collectionTipo_trabajo.elementAt(-1+idx));
               currItemTipo_trabajo.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode( "INS" );
               currItemTipo_trabajo.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> collectionNolaborables_convenio = gxTv_SdtEmpresa_abm_1_Nolaborables_convenio;
            web.SdtEmpresa_abm_1_nolaborables_convenio currItemNolaborables_convenio;
            short idx = 1;
            while ( idx <= collectionNolaborables_convenio.size() )
            {
               currItemNolaborables_convenio = (web.SdtEmpresa_abm_1_nolaborables_convenio)((web.SdtEmpresa_abm_1_nolaborables_convenio)collectionNolaborables_convenio.elementAt(-1+idx));
               currItemNolaborables_convenio.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( "INS" );
               currItemNolaborables_convenio.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> collectionNolaborables_origen = gxTv_SdtEmpresa_abm_1_Nolaborables_origen;
            web.SdtEmpresa_abm_1_nolaborables_origen currItemNolaborables_origen;
            short idx = 1;
            while ( idx <= collectionNolaborables_origen.size() )
            {
               currItemNolaborables_origen = (web.SdtEmpresa_abm_1_nolaborables_origen)((web.SdtEmpresa_abm_1_nolaborables_origen)collectionNolaborables_origen.elementAt(-1+idx));
               currItemNolaborables_origen.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode( "INS" );
               currItemNolaborables_origen.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> collectionNolaborables_religion = gxTv_SdtEmpresa_abm_1_Nolaborables_religion;
            web.SdtEmpresa_abm_1_nolaborables_religion currItemNolaborables_religion;
            short idx = 1;
            while ( idx <= collectionNolaborables_religion.size() )
            {
               currItemNolaborables_religion = (web.SdtEmpresa_abm_1_nolaborables_religion)((web.SdtEmpresa_abm_1_nolaborables_religion)collectionNolaborables_religion.elementAt(-1+idx));
               currItemNolaborables_religion.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( "INS" );
               currItemNolaborables_religion.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtEmpresa_abm_1_Clicod = value ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Empcod( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcod( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      if ( gxTv_SdtEmpresa_abm_1_Empcod != value )
      {
         gxTv_SdtEmpresa_abm_1_Mode = "INS" ;
         this.setgxTv_SdtEmpresa_abm_1_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empnom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcuit_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empdir_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emptel_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcp_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Paicod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Painom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Provcod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Provnom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppervacdes_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppervachas_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Loccod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Locnom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Actcodigo_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Actdescrip_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empactcomercial_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empzoncod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empzondescrip_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empreducc_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Tipempledefins_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emplogonom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emplogoext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empfirmanom_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empfirmaext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empantiguedad_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppresentismo_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmeshspext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empliqfer_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empliqferjor_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empdiahspext_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Artsec_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empliqgan_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emptipoexp_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emppromdesde_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empfracvacant_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empvacexplim_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empvacexptie_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empvacdismax_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Emposocod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empcondicod_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmodtra_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmodempl_Z_SetNull( );
         this.setgxTv_SdtEmpresa_abm_1_Empmodauto_Z_SetNull( );
         if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> collectionConceptos_horanormal_mensualizados = gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados;
            web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados currItemConceptos_horanormal_mensualizados;
            short idx = 1;
            while ( idx <= collectionConceptos_horanormal_mensualizados.size() )
            {
               currItemConceptos_horanormal_mensualizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)((web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)collectionConceptos_horanormal_mensualizados.elementAt(-1+idx));
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( "INS" );
               currItemConceptos_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> collectionConceptos_horanormal_jornalizados = gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados;
            web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados currItemConceptos_horanormal_jornalizados;
            short idx = 1;
            while ( idx <= collectionConceptos_horanormal_jornalizados.size() )
            {
               currItemConceptos_horanormal_jornalizados = (web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)((web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)collectionConceptos_horanormal_jornalizados.elementAt(-1+idx));
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( "INS" );
               currItemConceptos_horanormal_jornalizados.setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> collectionPromedio_horanormal_mensualizados = gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados;
            web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados currItemPromedio_horanormal_mensualizados;
            short idx = 1;
            while ( idx <= collectionPromedio_horanormal_mensualizados.size() )
            {
               currItemPromedio_horanormal_mensualizados = (web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)((web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)collectionPromedio_horanormal_mensualizados.elementAt(-1+idx));
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( "INS" );
               currItemPromedio_horanormal_mensualizados.setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Base_calculo != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> collectionBase_calculo = gxTv_SdtEmpresa_abm_1_Base_calculo;
            web.SdtEmpresa_abm_1_base_calculo currItemBase_calculo;
            short idx = 1;
            while ( idx <= collectionBase_calculo.size() )
            {
               currItemBase_calculo = (web.SdtEmpresa_abm_1_base_calculo)((web.SdtEmpresa_abm_1_base_calculo)collectionBase_calculo.elementAt(-1+idx));
               currItemBase_calculo.setgxTv_SdtEmpresa_abm_1_base_calculo_Mode( "INS" );
               currItemBase_calculo.setgxTv_SdtEmpresa_abm_1_base_calculo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> collectionHorasextras_pordia = gxTv_SdtEmpresa_abm_1_Horasextras_pordia;
            web.SdtEmpresa_abm_1_horasextras_pordia currItemHorasextras_pordia;
            short idx = 1;
            while ( idx <= collectionHorasextras_pordia.size() )
            {
               currItemHorasextras_pordia = (web.SdtEmpresa_abm_1_horasextras_pordia)((web.SdtEmpresa_abm_1_horasextras_pordia)collectionHorasextras_pordia.elementAt(-1+idx));
               currItemHorasextras_pordia.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Mode( "INS" );
               currItemHorasextras_pordia.setgxTv_SdtEmpresa_abm_1_horasextras_pordia_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> collectionTipo_trabajo = gxTv_SdtEmpresa_abm_1_Tipo_trabajo;
            web.SdtEmpresa_abm_1_tipo_trabajo currItemTipo_trabajo;
            short idx = 1;
            while ( idx <= collectionTipo_trabajo.size() )
            {
               currItemTipo_trabajo = (web.SdtEmpresa_abm_1_tipo_trabajo)((web.SdtEmpresa_abm_1_tipo_trabajo)collectionTipo_trabajo.elementAt(-1+idx));
               currItemTipo_trabajo.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Mode( "INS" );
               currItemTipo_trabajo.setgxTv_SdtEmpresa_abm_1_tipo_trabajo_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> collectionNolaborables_convenio = gxTv_SdtEmpresa_abm_1_Nolaborables_convenio;
            web.SdtEmpresa_abm_1_nolaborables_convenio currItemNolaborables_convenio;
            short idx = 1;
            while ( idx <= collectionNolaborables_convenio.size() )
            {
               currItemNolaborables_convenio = (web.SdtEmpresa_abm_1_nolaborables_convenio)((web.SdtEmpresa_abm_1_nolaborables_convenio)collectionNolaborables_convenio.elementAt(-1+idx));
               currItemNolaborables_convenio.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( "INS" );
               currItemNolaborables_convenio.setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> collectionNolaborables_origen = gxTv_SdtEmpresa_abm_1_Nolaborables_origen;
            web.SdtEmpresa_abm_1_nolaborables_origen currItemNolaborables_origen;
            short idx = 1;
            while ( idx <= collectionNolaborables_origen.size() )
            {
               currItemNolaborables_origen = (web.SdtEmpresa_abm_1_nolaborables_origen)((web.SdtEmpresa_abm_1_nolaborables_origen)collectionNolaborables_origen.elementAt(-1+idx));
               currItemNolaborables_origen.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Mode( "INS" );
               currItemNolaborables_origen.setgxTv_SdtEmpresa_abm_1_nolaborables_origen_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion != null )
         {
            GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> collectionNolaborables_religion = gxTv_SdtEmpresa_abm_1_Nolaborables_religion;
            web.SdtEmpresa_abm_1_nolaborables_religion currItemNolaborables_religion;
            short idx = 1;
            while ( idx <= collectionNolaborables_religion.size() )
            {
               currItemNolaborables_religion = (web.SdtEmpresa_abm_1_nolaborables_religion)((web.SdtEmpresa_abm_1_nolaborables_religion)collectionNolaborables_religion.elementAt(-1+idx));
               currItemNolaborables_religion.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( "INS" );
               currItemNolaborables_religion.setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Empcod");
      gxTv_SdtEmpresa_abm_1_Empcod = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empnom( )
   {
      return gxTv_SdtEmpresa_abm_1_Empnom ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empnom( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtEmpresa_abm_1_Empnom = value ;
   }

   public long getgxTv_SdtEmpresa_abm_1_Empcuit( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcuit ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcuit( long value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcuit");
      gxTv_SdtEmpresa_abm_1_Empcuit = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empdir( )
   {
      return gxTv_SdtEmpresa_abm_1_Empdir ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdir( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empdir");
      gxTv_SdtEmpresa_abm_1_Empdir = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emptel( )
   {
      return gxTv_SdtEmpresa_abm_1_Emptel ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptel( String value )
   {
      gxTv_SdtEmpresa_abm_1_Emptel_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emptel");
      gxTv_SdtEmpresa_abm_1_Emptel = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptel_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emptel_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Emptel = "" ;
      SetDirty("Emptel");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emptel_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Emptel_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empcp( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcp ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcp( String value )
   {
      gxTv_SdtEmpresa_abm_1_Empcp_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcp");
      gxTv_SdtEmpresa_abm_1_Empcp = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcp_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empcp_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empcp = "" ;
      SetDirty("Empcp");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empcp_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empcp_N==1) ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Paicod( )
   {
      return gxTv_SdtEmpresa_abm_1_Paicod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Paicod( short value )
   {
      gxTv_SdtEmpresa_abm_1_Paicod_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Paicod");
      gxTv_SdtEmpresa_abm_1_Paicod = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Paicod_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Paicod_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Paicod = (short)(0) ;
      SetDirty("Paicod");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Paicod_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Paicod_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Painom( )
   {
      return gxTv_SdtEmpresa_abm_1_Painom ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Painom( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Painom");
      gxTv_SdtEmpresa_abm_1_Painom = value ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Provcod( )
   {
      return gxTv_SdtEmpresa_abm_1_Provcod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provcod( short value )
   {
      gxTv_SdtEmpresa_abm_1_Provcod_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Provcod");
      gxTv_SdtEmpresa_abm_1_Provcod = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provcod_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Provcod_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Provcod = (short)(0) ;
      SetDirty("Provcod");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Provcod_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Provcod_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Provnom( )
   {
      return gxTv_SdtEmpresa_abm_1_Provnom ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provnom( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Provnom");
      gxTv_SdtEmpresa_abm_1_Provnom = value ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emppervacdes( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppervacdes ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppervacdes( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppervacdes");
      gxTv_SdtEmpresa_abm_1_Emppervacdes = value ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emppervachas( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppervachas ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppervachas( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppervachas");
      gxTv_SdtEmpresa_abm_1_Emppervachas = value ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Loccod( )
   {
      return gxTv_SdtEmpresa_abm_1_Loccod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Loccod( short value )
   {
      gxTv_SdtEmpresa_abm_1_Loccod_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Loccod");
      gxTv_SdtEmpresa_abm_1_Loccod = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Loccod_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Loccod_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Loccod = (short)(0) ;
      SetDirty("Loccod");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Loccod_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Loccod_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Locnom( )
   {
      return gxTv_SdtEmpresa_abm_1_Locnom ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Locnom( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Locnom");
      gxTv_SdtEmpresa_abm_1_Locnom = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Actcodigo( )
   {
      return gxTv_SdtEmpresa_abm_1_Actcodigo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcodigo( String value )
   {
      gxTv_SdtEmpresa_abm_1_Actcodigo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actcodigo");
      gxTv_SdtEmpresa_abm_1_Actcodigo = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcodigo_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Actcodigo_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Actcodigo = "" ;
      SetDirty("Actcodigo");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Actcodigo_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Actcodigo_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Actdescrip( )
   {
      return gxTv_SdtEmpresa_abm_1_Actdescrip ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actdescrip( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actdescrip");
      gxTv_SdtEmpresa_abm_1_Actdescrip = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Tipemplecod( )
   {
      return gxTv_SdtEmpresa_abm_1_Tipemplecod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipemplecod( String value )
   {
      gxTv_SdtEmpresa_abm_1_Tipemplecod_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Tipemplecod");
      gxTv_SdtEmpresa_abm_1_Tipemplecod = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipemplecod_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Tipemplecod_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Tipemplecod = "" ;
      SetDirty("Tipemplecod");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Tipemplecod_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Tipemplecod_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empactcomercial( )
   {
      return gxTv_SdtEmpresa_abm_1_Empactcomercial ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empactcomercial( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empactcomercial");
      gxTv_SdtEmpresa_abm_1_Empactcomercial = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empzoncod( )
   {
      return gxTv_SdtEmpresa_abm_1_Empzoncod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzoncod( String value )
   {
      gxTv_SdtEmpresa_abm_1_Empzoncod_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empzoncod");
      gxTv_SdtEmpresa_abm_1_Empzoncod = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzoncod_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empzoncod_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empzoncod = "" ;
      SetDirty("Empzoncod");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empzoncod_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empzoncod_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empzondescrip( )
   {
      return gxTv_SdtEmpresa_abm_1_Empzondescrip ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzondescrip( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empzondescrip");
      gxTv_SdtEmpresa_abm_1_Empzondescrip = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empreducc( )
   {
      return gxTv_SdtEmpresa_abm_1_Empreducc ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empreducc( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empreducc");
      gxTv_SdtEmpresa_abm_1_Empreducc = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Tipempledefins( )
   {
      return gxTv_SdtEmpresa_abm_1_Tipempledefins ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipempledefins( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Tipempledefins");
      gxTv_SdtEmpresa_abm_1_Tipempledefins = value ;
   }

   @GxUpload
   public String getgxTv_SdtEmpresa_abm_1_Emplogo( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogo( String value )
   {
      gxTv_SdtEmpresa_abm_1_Emplogo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogo");
      gxTv_SdtEmpresa_abm_1_Emplogo = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogo_SetBlob( String blob ,
                                                         String fileName ,
                                                         String fileType )
   {
      gxTv_SdtEmpresa_abm_1_Emplogo = blob ;
      gxTv_SdtEmpresa_abm_1_Emplogonom = fileName ;
      gxTv_SdtEmpresa_abm_1_Emplogoext = fileType ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogo_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogo_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Emplogo = "" ;
      SetDirty("Emplogo");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogo_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Emplogo_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emplogonom( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogonom ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogonom( String value )
   {
      gxTv_SdtEmpresa_abm_1_Emplogonom_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogonom");
      gxTv_SdtEmpresa_abm_1_Emplogonom = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogonom_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogonom_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Emplogonom = "" ;
      SetDirty("Emplogonom");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogonom_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Emplogonom_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emplogoext( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogoext ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogoext( String value )
   {
      gxTv_SdtEmpresa_abm_1_Emplogoext_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogoext");
      gxTv_SdtEmpresa_abm_1_Emplogoext = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogoext_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogoext_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Emplogoext = "" ;
      SetDirty("Emplogoext");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogoext_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Emplogoext_N==1) ;
   }

   @GxUpload
   public String getgxTv_SdtEmpresa_abm_1_Empfirma( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirma ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirma( String value )
   {
      gxTv_SdtEmpresa_abm_1_Empfirma_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirma");
      gxTv_SdtEmpresa_abm_1_Empfirma = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirma_SetBlob( String blob ,
                                                          String fileName ,
                                                          String fileType )
   {
      gxTv_SdtEmpresa_abm_1_Empfirma = blob ;
      gxTv_SdtEmpresa_abm_1_Empfirmanom = fileName ;
      gxTv_SdtEmpresa_abm_1_Empfirmaext = fileType ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirma_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirma_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empfirma = "" ;
      SetDirty("Empfirma");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirma_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empfirma_N==1) ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empfirmanom( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirmanom ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmanom( String value )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmanom_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirmanom");
      gxTv_SdtEmpresa_abm_1_Empfirmanom = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmanom_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmanom_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empfirmanom = "" ;
      SetDirty("Empfirmanom");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirmanom_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empfirmanom_N==1) ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados == null )
      {
         gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados = new GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados>(web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados.class, "Empresa_abm_1.conceptos_horanormal_mensualizados", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados( GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Conceptos_horanormal_mensualizados");
      gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados = null ;
      SetDirty("Conceptos_horanormal_mensualizados");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empfirmaext( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirmaext ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmaext( String value )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmaext_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirmaext");
      gxTv_SdtEmpresa_abm_1_Empfirmaext = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmaext_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmaext_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empfirmaext = "" ;
      SetDirty("Empfirmaext");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirmaext_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empfirmaext_N==1) ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados == null )
      {
         gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados = new GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados>(web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados.class, "Empresa_abm_1.conceptos_horanormal_jornalizados", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados( GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Conceptos_horanormal_jornalizados");
      gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados = null ;
      SetDirty("Conceptos_horanormal_jornalizados");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados == null )
      {
         return true ;
      }
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Empantiguedad( )
   {
      return gxTv_SdtEmpresa_abm_1_Empantiguedad ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empantiguedad( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empantiguedad");
      gxTv_SdtEmpresa_abm_1_Empantiguedad = value ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados == null )
      {
         gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados = new GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados>(web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados.class, "Empresa_abm_1.promedio_horanormal_mensualizados", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados( GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Promedio_horanormal_mensualizados");
      gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados = null ;
      SetDirty("Promedio_horanormal_mensualizados");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados == null )
      {
         return true ;
      }
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Emppresentismo( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppresentismo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppresentismo( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppresentismo");
      gxTv_SdtEmpresa_abm_1_Emppresentismo = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Empmeshspext( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmeshspext ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_Empmeshspext_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmeshspext");
      gxTv_SdtEmpresa_abm_1_Empmeshspext = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmeshspext_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empmeshspext_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empmeshspext = DecimalUtil.ZERO ;
      SetDirty("Empmeshspext");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmeshspext_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empmeshspext_N==1) ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqfer( )
   {
      return gxTv_SdtEmpresa_abm_1_Empliqfer ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqfer( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empliqfer");
      gxTv_SdtEmpresa_abm_1_Empliqfer = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqferjor( )
   {
      return gxTv_SdtEmpresa_abm_1_Empliqferjor ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqferjor( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empliqferjor");
      gxTv_SdtEmpresa_abm_1_Empliqferjor = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empdiahspext( )
   {
      return gxTv_SdtEmpresa_abm_1_Empdiahspext ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdiahspext( String value )
   {
      gxTv_SdtEmpresa_abm_1_Empdiahspext_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empdiahspext");
      gxTv_SdtEmpresa_abm_1_Empdiahspext = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdiahspext_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empdiahspext_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empdiahspext = "" ;
      SetDirty("Empdiahspext");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empdiahspext_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Empdiahspext_N==1) ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Artsec( )
   {
      return gxTv_SdtEmpresa_abm_1_Artsec ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Artsec( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Artsec");
      gxTv_SdtEmpresa_abm_1_Artsec = value ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> getgxTv_SdtEmpresa_abm_1_Base_calculo( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Base_calculo == null )
      {
         gxTv_SdtEmpresa_abm_1_Base_calculo = new GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo>(web.SdtEmpresa_abm_1_base_calculo.class, "Empresa_abm_1.base_calculo", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Base_calculo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Base_calculo( GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Base_calculo");
      gxTv_SdtEmpresa_abm_1_Base_calculo = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Base_calculo_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Base_calculo = null ;
      SetDirty("Base_calculo");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Base_calculo_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Base_calculo == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> getgxTv_SdtEmpresa_abm_1_Horasextras_pordia( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia == null )
      {
         gxTv_SdtEmpresa_abm_1_Horasextras_pordia = new GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia>(web.SdtEmpresa_abm_1_horasextras_pordia.class, "Empresa_abm_1.horasextras_pordia", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Horasextras_pordia ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Horasextras_pordia( GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Horasextras_pordia");
      gxTv_SdtEmpresa_abm_1_Horasextras_pordia = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Horasextras_pordia_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Horasextras_pordia = null ;
      SetDirty("Horasextras_pordia");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Horasextras_pordia_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Horasextras_pordia == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> getgxTv_SdtEmpresa_abm_1_Tipo_trabajo( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo == null )
      {
         gxTv_SdtEmpresa_abm_1_Tipo_trabajo = new GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo>(web.SdtEmpresa_abm_1_tipo_trabajo.class, "Empresa_abm_1.tipo_trabajo", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Tipo_trabajo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipo_trabajo( GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Tipo_trabajo");
      gxTv_SdtEmpresa_abm_1_Tipo_trabajo = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipo_trabajo_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Tipo_trabajo = null ;
      SetDirty("Tipo_trabajo");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Tipo_trabajo_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Tipo_trabajo == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio == null )
      {
         gxTv_SdtEmpresa_abm_1_Nolaborables_convenio = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio>(web.SdtEmpresa_abm_1_nolaborables_convenio.class, "Empresa_abm_1.nolaborables_convenio", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Nolaborables_convenio ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Nolaborables_convenio( GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Nolaborables_convenio");
      gxTv_SdtEmpresa_abm_1_Nolaborables_convenio = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Nolaborables_convenio_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Nolaborables_convenio = null ;
      SetDirty("Nolaborables_convenio");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_convenio == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> getgxTv_SdtEmpresa_abm_1_Nolaborables_origen( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen == null )
      {
         gxTv_SdtEmpresa_abm_1_Nolaborables_origen = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen>(web.SdtEmpresa_abm_1_nolaborables_origen.class, "Empresa_abm_1.nolaborables_origen", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Nolaborables_origen ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Nolaborables_origen( GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Nolaborables_origen");
      gxTv_SdtEmpresa_abm_1_Nolaborables_origen = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Nolaborables_origen_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Nolaborables_origen = null ;
      SetDirty("Nolaborables_origen");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Nolaborables_origen_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_origen == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> getgxTv_SdtEmpresa_abm_1_Nolaborables_religion( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion == null )
      {
         gxTv_SdtEmpresa_abm_1_Nolaborables_religion = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion>(web.SdtEmpresa_abm_1_nolaborables_religion.class, "Empresa_abm_1.nolaborables_religion", "PayDay", remoteHandle);
      }
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      return gxTv_SdtEmpresa_abm_1_Nolaborables_religion ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Nolaborables_religion( GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Nolaborables_religion");
      gxTv_SdtEmpresa_abm_1_Nolaborables_religion = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Nolaborables_religion_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Nolaborables_religion = null ;
      SetDirty("Nolaborables_religion");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Nolaborables_religion_IsNull( )
   {
      if ( gxTv_SdtEmpresa_abm_1_Nolaborables_religion == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empguaredadmin( )
   {
      return gxTv_SdtEmpresa_abm_1_Empguaredadmin ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empguaredadmin( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empguaredadmin");
      gxTv_SdtEmpresa_abm_1_Empguaredadmin = value ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empguaredadmax( )
   {
      return gxTv_SdtEmpresa_abm_1_Empguaredadmax ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empguaredadmax( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empguaredadmax");
      gxTv_SdtEmpresa_abm_1_Empguaredadmax = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqgan( )
   {
      return gxTv_SdtEmpresa_abm_1_Empliqgan ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqgan( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empliqgan");
      gxTv_SdtEmpresa_abm_1_Empliqgan = value ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emptipoexp( )
   {
      return gxTv_SdtEmpresa_abm_1_Emptipoexp ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptipoexp( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emptipoexp");
      gxTv_SdtEmpresa_abm_1_Emptipoexp = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emppromdesde( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppromdesde ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppromdesde( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppromdesde");
      gxTv_SdtEmpresa_abm_1_Emppromdesde = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Empfracvacant( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfracvacant ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfracvacant( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfracvacant");
      gxTv_SdtEmpresa_abm_1_Empfracvacant = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empvacexplim( )
   {
      return gxTv_SdtEmpresa_abm_1_Empvacexplim ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacexplim( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empvacexplim");
      gxTv_SdtEmpresa_abm_1_Empvacexplim = value ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empvacexptie( )
   {
      return gxTv_SdtEmpresa_abm_1_Empvacexptie ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacexptie( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empvacexptie");
      gxTv_SdtEmpresa_abm_1_Empvacexptie = value ;
   }

   public int getgxTv_SdtEmpresa_abm_1_Empvacdismax( )
   {
      return gxTv_SdtEmpresa_abm_1_Empvacdismax ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacdismax( int value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empvacdismax");
      gxTv_SdtEmpresa_abm_1_Empvacdismax = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Actcomcodigo( )
   {
      return gxTv_SdtEmpresa_abm_1_Actcomcodigo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcomcodigo( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actcomcodigo");
      gxTv_SdtEmpresa_abm_1_Actcomcodigo = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emposocod( )
   {
      return gxTv_SdtEmpresa_abm_1_Emposocod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emposocod( String value )
   {
      gxTv_SdtEmpresa_abm_1_Emposocod_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emposocod");
      gxTv_SdtEmpresa_abm_1_Emposocod = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emposocod_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emposocod_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Emposocod = "" ;
      SetDirty("Emposocod");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emposocod_IsNull( )
   {
      return (gxTv_SdtEmpresa_abm_1_Emposocod_N==1) ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Empcondicod( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcondicod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcondicod( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcondicod");
      gxTv_SdtEmpresa_abm_1_Empcondicod = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empmodtra( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmodtra ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodtra( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmodtra");
      gxTv_SdtEmpresa_abm_1_Empmodtra = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodempl( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmodempl ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodempl( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmodempl");
      gxTv_SdtEmpresa_abm_1_Empmodempl = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodauto( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmodauto ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodauto( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmodauto");
      gxTv_SdtEmpresa_abm_1_Empmodauto = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEmpresa_abm_1_Clicod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Clicod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Clicod_Z( int value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtEmpresa_abm_1_Clicod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Clicod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Empcod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcod_Z( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtEmpresa_abm_1_Empcod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empnom_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empnom_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empnom_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtEmpresa_abm_1_Empnom_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empnom_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtEmpresa_abm_1_Empcuit_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcuit_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcuit_Z( long value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcuit_Z");
      gxTv_SdtEmpresa_abm_1_Empcuit_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcuit_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empcuit_Z = 0 ;
      SetDirty("Empcuit_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empcuit_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empdir_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empdir_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdir_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empdir_Z");
      gxTv_SdtEmpresa_abm_1_Empdir_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdir_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empdir_Z = "" ;
      SetDirty("Empdir_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empdir_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emptel_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emptel_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptel_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emptel_Z");
      gxTv_SdtEmpresa_abm_1_Emptel_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptel_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emptel_Z = "" ;
      SetDirty("Emptel_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emptel_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empcp_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcp_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcp_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcp_Z");
      gxTv_SdtEmpresa_abm_1_Empcp_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcp_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empcp_Z = "" ;
      SetDirty("Empcp_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empcp_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Paicod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Paicod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Paicod_Z( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Paicod_Z");
      gxTv_SdtEmpresa_abm_1_Paicod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Paicod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Paicod_Z = (short)(0) ;
      SetDirty("Paicod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Paicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Painom_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Painom_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Painom_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Painom_Z");
      gxTv_SdtEmpresa_abm_1_Painom_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Painom_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Painom_Z = "" ;
      SetDirty("Painom_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Painom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Provcod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Provcod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provcod_Z( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Provcod_Z");
      gxTv_SdtEmpresa_abm_1_Provcod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provcod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Provcod_Z = (short)(0) ;
      SetDirty("Provcod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Provcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Provnom_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Provnom_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provnom_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Provnom_Z");
      gxTv_SdtEmpresa_abm_1_Provnom_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provnom_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Provnom_Z = "" ;
      SetDirty("Provnom_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Provnom_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emppervacdes_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppervacdes_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppervacdes_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppervacdes_Z");
      gxTv_SdtEmpresa_abm_1_Emppervacdes_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppervacdes_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emppervacdes_Z = (byte)(0) ;
      SetDirty("Emppervacdes_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emppervacdes_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emppervachas_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppervachas_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppervachas_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppervachas_Z");
      gxTv_SdtEmpresa_abm_1_Emppervachas_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppervachas_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emppervachas_Z = (byte)(0) ;
      SetDirty("Emppervachas_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emppervachas_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Loccod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Loccod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Loccod_Z( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Loccod_Z");
      gxTv_SdtEmpresa_abm_1_Loccod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Loccod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Loccod_Z = (short)(0) ;
      SetDirty("Loccod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Loccod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Locnom_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Locnom_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Locnom_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Locnom_Z");
      gxTv_SdtEmpresa_abm_1_Locnom_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Locnom_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Locnom_Z = "" ;
      SetDirty("Locnom_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Locnom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Actcodigo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Actcodigo_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actcodigo_Z");
      gxTv_SdtEmpresa_abm_1_Actcodigo_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcodigo_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Actcodigo_Z = "" ;
      SetDirty("Actcodigo_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Actcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Actdescrip_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Actdescrip_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actdescrip_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actdescrip_Z");
      gxTv_SdtEmpresa_abm_1_Actdescrip_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actdescrip_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Actdescrip_Z = "" ;
      SetDirty("Actdescrip_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Actdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Tipemplecod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Tipemplecod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipemplecod_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Tipemplecod_Z");
      gxTv_SdtEmpresa_abm_1_Tipemplecod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipemplecod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Tipemplecod_Z = "" ;
      SetDirty("Tipemplecod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Tipemplecod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empactcomercial_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empactcomercial_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empactcomercial_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empactcomercial_Z");
      gxTv_SdtEmpresa_abm_1_Empactcomercial_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empactcomercial_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empactcomercial_Z = "" ;
      SetDirty("Empactcomercial_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empactcomercial_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empzoncod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empzoncod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzoncod_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empzoncod_Z");
      gxTv_SdtEmpresa_abm_1_Empzoncod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzoncod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empzoncod_Z = "" ;
      SetDirty("Empzoncod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empzoncod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empzondescrip_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empzondescrip_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzondescrip_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empzondescrip_Z");
      gxTv_SdtEmpresa_abm_1_Empzondescrip_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzondescrip_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empzondescrip_Z = "" ;
      SetDirty("Empzondescrip_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empzondescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empreducc_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empreducc_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empreducc_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empreducc_Z");
      gxTv_SdtEmpresa_abm_1_Empreducc_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empreducc_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empreducc_Z = false ;
      SetDirty("Empreducc_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empreducc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Tipempledefins_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Tipempledefins_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipempledefins_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Tipempledefins_Z");
      gxTv_SdtEmpresa_abm_1_Tipempledefins_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipempledefins_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Tipempledefins_Z = "" ;
      SetDirty("Tipempledefins_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Tipempledefins_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emplogonom_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogonom_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogonom_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogonom_Z");
      gxTv_SdtEmpresa_abm_1_Emplogonom_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogonom_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogonom_Z = "" ;
      SetDirty("Emplogonom_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogonom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emplogoext_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogoext_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogoext_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogoext_Z");
      gxTv_SdtEmpresa_abm_1_Emplogoext_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogoext_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogoext_Z = "" ;
      SetDirty("Emplogoext_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogoext_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empfirmanom_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirmanom_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmanom_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirmanom_Z");
      gxTv_SdtEmpresa_abm_1_Empfirmanom_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmanom_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmanom_Z = "" ;
      SetDirty("Empfirmanom_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirmanom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empfirmaext_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirmaext_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmaext_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirmaext_Z");
      gxTv_SdtEmpresa_abm_1_Empfirmaext_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmaext_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmaext_Z = "" ;
      SetDirty("Empfirmaext_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirmaext_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Empantiguedad_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empantiguedad_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empantiguedad_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empantiguedad_Z");
      gxTv_SdtEmpresa_abm_1_Empantiguedad_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empantiguedad_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empantiguedad_Z = DecimalUtil.ZERO ;
      SetDirty("Empantiguedad_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empantiguedad_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Emppresentismo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppresentismo_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppresentismo_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppresentismo_Z");
      gxTv_SdtEmpresa_abm_1_Emppresentismo_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppresentismo_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emppresentismo_Z = DecimalUtil.ZERO ;
      SetDirty("Emppresentismo_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emppresentismo_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Empmeshspext_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmeshspext_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmeshspext_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmeshspext_Z");
      gxTv_SdtEmpresa_abm_1_Empmeshspext_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmeshspext_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empmeshspext_Z = DecimalUtil.ZERO ;
      SetDirty("Empmeshspext_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmeshspext_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqfer_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empliqfer_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqfer_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empliqfer_Z");
      gxTv_SdtEmpresa_abm_1_Empliqfer_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqfer_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empliqfer_Z = false ;
      SetDirty("Empliqfer_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqfer_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqferjor_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empliqferjor_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqferjor_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empliqferjor_Z");
      gxTv_SdtEmpresa_abm_1_Empliqferjor_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqferjor_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empliqferjor_Z = false ;
      SetDirty("Empliqferjor_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqferjor_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empdiahspext_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empdiahspext_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdiahspext_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empdiahspext_Z");
      gxTv_SdtEmpresa_abm_1_Empdiahspext_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdiahspext_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empdiahspext_Z = "" ;
      SetDirty("Empdiahspext_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empdiahspext_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Artsec_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Artsec_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Artsec_Z( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Artsec_Z");
      gxTv_SdtEmpresa_abm_1_Artsec_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Artsec_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Artsec_Z = (short)(0) ;
      SetDirty("Artsec_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Artsec_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empguaredadmin_Z");
      gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z = (byte)(0) ;
      SetDirty("Empguaredadmin_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empguaredadmax_Z");
      gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z = (byte)(0) ;
      SetDirty("Empguaredadmax_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqgan_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empliqgan_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqgan_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empliqgan_Z");
      gxTv_SdtEmpresa_abm_1_Empliqgan_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empliqgan_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empliqgan_Z = false ;
      SetDirty("Empliqgan_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empliqgan_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emptipoexp_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emptipoexp_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptipoexp_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emptipoexp_Z");
      gxTv_SdtEmpresa_abm_1_Emptipoexp_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptipoexp_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emptipoexp_Z = (byte)(0) ;
      SetDirty("Emptipoexp_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emptipoexp_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emppromdesde_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emppromdesde_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppromdesde_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emppromdesde_Z");
      gxTv_SdtEmpresa_abm_1_Emppromdesde_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emppromdesde_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emppromdesde_Z = "" ;
      SetDirty("Emppromdesde_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emppromdesde_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_Empfracvacant_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfracvacant_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfracvacant_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfracvacant_Z");
      gxTv_SdtEmpresa_abm_1_Empfracvacant_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfracvacant_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfracvacant_Z = DecimalUtil.ZERO ;
      SetDirty("Empfracvacant_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfracvacant_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empvacexplim_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empvacexplim_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacexplim_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empvacexplim_Z");
      gxTv_SdtEmpresa_abm_1_Empvacexplim_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacexplim_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empvacexplim_Z = false ;
      SetDirty("Empvacexplim_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empvacexplim_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empvacexptie_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empvacexptie_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacexptie_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empvacexptie_Z");
      gxTv_SdtEmpresa_abm_1_Empvacexptie_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacexptie_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empvacexptie_Z = (byte)(0) ;
      SetDirty("Empvacexptie_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empvacexptie_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEmpresa_abm_1_Empvacdismax_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empvacdismax_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacdismax_Z( int value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empvacdismax_Z");
      gxTv_SdtEmpresa_abm_1_Empvacdismax_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empvacdismax_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empvacdismax_Z = 0 ;
      SetDirty("Empvacdismax_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empvacdismax_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actcomcodigo_Z");
      gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z = "" ;
      SetDirty("Actcomcodigo_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Emposocod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Emposocod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emposocod_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emposocod_Z");
      gxTv_SdtEmpresa_abm_1_Emposocod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emposocod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emposocod_Z = "" ;
      SetDirty("Emposocod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emposocod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_Empcondicod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcondicod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcondicod_Z( short value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcondicod_Z");
      gxTv_SdtEmpresa_abm_1_Empcondicod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcondicod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empcondicod_Z = (short)(0) ;
      SetDirty("Empcondicod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empcondicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_Empmodtra_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmodtra_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodtra_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmodtra_Z");
      gxTv_SdtEmpresa_abm_1_Empmodtra_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodtra_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empmodtra_Z = "" ;
      SetDirty("Empmodtra_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodtra_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodempl_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmodempl_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodempl_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmodempl_Z");
      gxTv_SdtEmpresa_abm_1_Empmodempl_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodempl_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empmodempl_Z = false ;
      SetDirty("Empmodempl_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodempl_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodauto_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmodauto_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodauto_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmodauto_Z");
      gxTv_SdtEmpresa_abm_1_Empmodauto_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmodauto_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empmodauto_Z = false ;
      SetDirty("Empmodauto_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmodauto_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emptel_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Emptel_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptel_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emptel_N");
      gxTv_SdtEmpresa_abm_1_Emptel_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emptel_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emptel_N = (byte)(0) ;
      SetDirty("Emptel_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emptel_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empcp_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empcp_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcp_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empcp_N");
      gxTv_SdtEmpresa_abm_1_Empcp_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empcp_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empcp_N = (byte)(0) ;
      SetDirty("Empcp_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empcp_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Paicod_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Paicod_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Paicod_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Paicod_N");
      gxTv_SdtEmpresa_abm_1_Paicod_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Paicod_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Paicod_N = (byte)(0) ;
      SetDirty("Paicod_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Paicod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Provcod_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Provcod_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provcod_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Provcod_N");
      gxTv_SdtEmpresa_abm_1_Provcod_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Provcod_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Provcod_N = (byte)(0) ;
      SetDirty("Provcod_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Provcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Loccod_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Loccod_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Loccod_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Loccod_N");
      gxTv_SdtEmpresa_abm_1_Loccod_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Loccod_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Loccod_N = (byte)(0) ;
      SetDirty("Loccod_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Loccod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Actcodigo_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Actcodigo_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcodigo_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Actcodigo_N");
      gxTv_SdtEmpresa_abm_1_Actcodigo_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Actcodigo_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Actcodigo_N = (byte)(0) ;
      SetDirty("Actcodigo_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Actcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Tipemplecod_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Tipemplecod_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipemplecod_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Tipemplecod_N");
      gxTv_SdtEmpresa_abm_1_Tipemplecod_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Tipemplecod_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Tipemplecod_N = (byte)(0) ;
      SetDirty("Tipemplecod_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Tipemplecod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empzoncod_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empzoncod_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzoncod_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empzoncod_N");
      gxTv_SdtEmpresa_abm_1_Empzoncod_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empzoncod_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empzoncod_N = (byte)(0) ;
      SetDirty("Empzoncod_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empzoncod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emplogo_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogo_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogo_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogo_N");
      gxTv_SdtEmpresa_abm_1_Emplogo_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogo_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogo_N = (byte)(0) ;
      SetDirty("Emplogo_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emplogonom_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogonom_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogonom_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogonom_N");
      gxTv_SdtEmpresa_abm_1_Emplogonom_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogonom_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogonom_N = (byte)(0) ;
      SetDirty("Emplogonom_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogonom_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emplogoext_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Emplogoext_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogoext_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emplogoext_N");
      gxTv_SdtEmpresa_abm_1_Emplogoext_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emplogoext_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emplogoext_N = (byte)(0) ;
      SetDirty("Emplogoext_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emplogoext_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empfirma_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirma_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirma_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirma_N");
      gxTv_SdtEmpresa_abm_1_Empfirma_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirma_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirma_N = (byte)(0) ;
      SetDirty("Empfirma_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirma_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empfirmanom_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirmanom_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmanom_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirmanom_N");
      gxTv_SdtEmpresa_abm_1_Empfirmanom_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmanom_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmanom_N = (byte)(0) ;
      SetDirty("Empfirmanom_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirmanom_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empfirmaext_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empfirmaext_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmaext_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empfirmaext_N");
      gxTv_SdtEmpresa_abm_1_Empfirmaext_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empfirmaext_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empfirmaext_N = (byte)(0) ;
      SetDirty("Empfirmaext_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empfirmaext_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empmeshspext_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empmeshspext_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmeshspext_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empmeshspext_N");
      gxTv_SdtEmpresa_abm_1_Empmeshspext_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empmeshspext_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empmeshspext_N = (byte)(0) ;
      SetDirty("Empmeshspext_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empmeshspext_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Empdiahspext_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Empdiahspext_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdiahspext_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Empdiahspext_N");
      gxTv_SdtEmpresa_abm_1_Empdiahspext_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Empdiahspext_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Empdiahspext_N = (byte)(0) ;
      SetDirty("Empdiahspext_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Empdiahspext_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_Emposocod_N( )
   {
      return gxTv_SdtEmpresa_abm_1_Emposocod_N ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emposocod_N( byte value )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(0) ;
      SetDirty("Emposocod_N");
      gxTv_SdtEmpresa_abm_1_Emposocod_N = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_Emposocod_N_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_Emposocod_N = (byte)(0) ;
      SetDirty("Emposocod_N");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_Emposocod_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.empresa_abm_1_bc obj;
      obj = new web.empresa_abm_1_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_Empnom = "" ;
      gxTv_SdtEmpresa_abm_1_Empdir = "" ;
      gxTv_SdtEmpresa_abm_1_Emptel = "" ;
      gxTv_SdtEmpresa_abm_1_Empcp = "" ;
      gxTv_SdtEmpresa_abm_1_Painom = "" ;
      gxTv_SdtEmpresa_abm_1_Provnom = "" ;
      gxTv_SdtEmpresa_abm_1_Locnom = "" ;
      gxTv_SdtEmpresa_abm_1_Actcodigo = "" ;
      gxTv_SdtEmpresa_abm_1_Actdescrip = "" ;
      gxTv_SdtEmpresa_abm_1_Tipemplecod = "" ;
      gxTv_SdtEmpresa_abm_1_Empactcomercial = "" ;
      gxTv_SdtEmpresa_abm_1_Empzoncod = "" ;
      gxTv_SdtEmpresa_abm_1_Empzondescrip = "" ;
      gxTv_SdtEmpresa_abm_1_Tipempledefins = "" ;
      gxTv_SdtEmpresa_abm_1_Emplogo = "" ;
      gxTv_SdtEmpresa_abm_1_Emplogonom = "" ;
      gxTv_SdtEmpresa_abm_1_Emplogoext = "" ;
      gxTv_SdtEmpresa_abm_1_Empfirma = "" ;
      gxTv_SdtEmpresa_abm_1_Empfirmanom = "" ;
      gxTv_SdtEmpresa_abm_1_Empfirmaext = "" ;
      gxTv_SdtEmpresa_abm_1_Empantiguedad = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Emppresentismo = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Empmeshspext = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Empdiahspext = "" ;
      gxTv_SdtEmpresa_abm_1_Emppromdesde = "" ;
      gxTv_SdtEmpresa_abm_1_Empfracvacant = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Actcomcodigo = "" ;
      gxTv_SdtEmpresa_abm_1_Emposocod = "" ;
      gxTv_SdtEmpresa_abm_1_Empmodtra = "" ;
      gxTv_SdtEmpresa_abm_1_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_Empnom_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empdir_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Emptel_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empcp_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Painom_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Provnom_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Locnom_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Actcodigo_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Actdescrip_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Tipemplecod_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empactcomercial_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empzoncod_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empzondescrip_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Tipempledefins_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Emplogonom_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Emplogoext_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empfirmanom_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empfirmaext_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empantiguedad_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Emppresentismo_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Empmeshspext_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Empdiahspext_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Emppromdesde_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empfracvacant_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Emposocod_Z = "" ;
      gxTv_SdtEmpresa_abm_1_Empmodtra_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_N ;
   }

   public web.SdtEmpresa_abm_1 Clone( )
   {
      web.SdtEmpresa_abm_1 sdt;
      web.empresa_abm_1_bc obj;
      sdt = (web.SdtEmpresa_abm_1)(clone()) ;
      obj = (web.empresa_abm_1_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1 struct )
   {
      setgxTv_SdtEmpresa_abm_1_Clicod(struct.getClicod());
      setgxTv_SdtEmpresa_abm_1_Empcod(struct.getEmpcod());
      setgxTv_SdtEmpresa_abm_1_Empnom(struct.getEmpnom());
      setgxTv_SdtEmpresa_abm_1_Empcuit(struct.getEmpcuit());
      setgxTv_SdtEmpresa_abm_1_Empdir(struct.getEmpdir());
      setgxTv_SdtEmpresa_abm_1_Emptel(struct.getEmptel());
      setgxTv_SdtEmpresa_abm_1_Empcp(struct.getEmpcp());
      setgxTv_SdtEmpresa_abm_1_Paicod(struct.getPaicod());
      setgxTv_SdtEmpresa_abm_1_Painom(struct.getPainom());
      setgxTv_SdtEmpresa_abm_1_Provcod(struct.getProvcod());
      setgxTv_SdtEmpresa_abm_1_Provnom(struct.getProvnom());
      setgxTv_SdtEmpresa_abm_1_Emppervacdes(struct.getEmppervacdes());
      setgxTv_SdtEmpresa_abm_1_Emppervachas(struct.getEmppervachas());
      setgxTv_SdtEmpresa_abm_1_Loccod(struct.getLoccod());
      setgxTv_SdtEmpresa_abm_1_Locnom(struct.getLocnom());
      setgxTv_SdtEmpresa_abm_1_Actcodigo(struct.getActcodigo());
      setgxTv_SdtEmpresa_abm_1_Actdescrip(struct.getActdescrip());
      setgxTv_SdtEmpresa_abm_1_Tipemplecod(struct.getTipemplecod());
      setgxTv_SdtEmpresa_abm_1_Empactcomercial(struct.getEmpactcomercial());
      setgxTv_SdtEmpresa_abm_1_Empzoncod(struct.getEmpzoncod());
      setgxTv_SdtEmpresa_abm_1_Empzondescrip(struct.getEmpzondescrip());
      setgxTv_SdtEmpresa_abm_1_Empreducc(struct.getEmpreducc());
      setgxTv_SdtEmpresa_abm_1_Tipempledefins(struct.getTipempledefins());
      setgxTv_SdtEmpresa_abm_1_Emplogo(struct.getEmplogo());
      setgxTv_SdtEmpresa_abm_1_Emplogonom(struct.getEmplogonom());
      setgxTv_SdtEmpresa_abm_1_Emplogoext(struct.getEmplogoext());
      setgxTv_SdtEmpresa_abm_1_Empfirma(struct.getEmpfirma());
      setgxTv_SdtEmpresa_abm_1_Empfirmanom(struct.getEmpfirmanom());
      GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados>(web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados.class, "Empresa_abm_1.conceptos_horanormal_mensualizados", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_conceptos_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux1 = struct.getConceptos_horanormal_mensualizados();
      if (gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux.add(new web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados(remoteHandle, gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados(gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux);
      setgxTv_SdtEmpresa_abm_1_Empfirmaext(struct.getEmpfirmaext());
      GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados>(web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados.class, "Empresa_abm_1.conceptos_horanormal_jornalizados", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_conceptos_horanormal_jornalizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux1 = struct.getConceptos_horanormal_jornalizados();
      if (gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux.add(new web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados(remoteHandle, gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados(gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux);
      setgxTv_SdtEmpresa_abm_1_Empantiguedad(struct.getEmpantiguedad());
      GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados>(web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados.class, "Empresa_abm_1.promedio_horanormal_mensualizados", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_promedio_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux1 = struct.getPromedio_horanormal_mensualizados();
      if (gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux.add(new web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados(remoteHandle, gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados(gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux);
      setgxTv_SdtEmpresa_abm_1_Emppresentismo(struct.getEmppresentismo());
      setgxTv_SdtEmpresa_abm_1_Empmeshspext(struct.getEmpmeshspext());
      setgxTv_SdtEmpresa_abm_1_Empliqfer(struct.getEmpliqfer());
      setgxTv_SdtEmpresa_abm_1_Empliqferjor(struct.getEmpliqferjor());
      setgxTv_SdtEmpresa_abm_1_Empdiahspext(struct.getEmpdiahspext());
      setgxTv_SdtEmpresa_abm_1_Artsec(struct.getArtsec());
      GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> gxTv_SdtEmpresa_abm_1_Base_calculo_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo>(web.SdtEmpresa_abm_1_base_calculo.class, "Empresa_abm_1.base_calculo", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_base_calculo> gxTv_SdtEmpresa_abm_1_Base_calculo_aux1 = struct.getBase_calculo();
      if (gxTv_SdtEmpresa_abm_1_Base_calculo_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Base_calculo_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Base_calculo_aux.add(new web.SdtEmpresa_abm_1_base_calculo(remoteHandle, gxTv_SdtEmpresa_abm_1_Base_calculo_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Base_calculo(gxTv_SdtEmpresa_abm_1_Base_calculo_aux);
      GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia>(web.SdtEmpresa_abm_1_horasextras_pordia.class, "Empresa_abm_1.horasextras_pordia", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_horasextras_pordia> gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux1 = struct.getHorasextras_pordia();
      if (gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux.add(new web.SdtEmpresa_abm_1_horasextras_pordia(remoteHandle, gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Horasextras_pordia(gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux);
      GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo>(web.SdtEmpresa_abm_1_tipo_trabajo.class, "Empresa_abm_1.tipo_trabajo", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_tipo_trabajo> gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux1 = struct.getTipo_trabajo();
      if (gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux.add(new web.SdtEmpresa_abm_1_tipo_trabajo(remoteHandle, gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Tipo_trabajo(gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux);
      GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio>(web.SdtEmpresa_abm_1_nolaborables_convenio.class, "Empresa_abm_1.nolaborables_convenio", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_nolaborables_convenio> gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux1 = struct.getNolaborables_convenio();
      if (gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux.add(new web.SdtEmpresa_abm_1_nolaborables_convenio(remoteHandle, gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Nolaborables_convenio(gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux);
      GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen>(web.SdtEmpresa_abm_1_nolaborables_origen.class, "Empresa_abm_1.nolaborables_origen", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_nolaborables_origen> gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux1 = struct.getNolaborables_origen();
      if (gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux.add(new web.SdtEmpresa_abm_1_nolaborables_origen(remoteHandle, gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Nolaborables_origen(gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux);
      GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux = new GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion>(web.SdtEmpresa_abm_1_nolaborables_religion.class, "Empresa_abm_1.nolaborables_religion", "PayDay", remoteHandle);
      Vector<web.StructSdtEmpresa_abm_1_nolaborables_religion> gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux1 = struct.getNolaborables_religion();
      if (gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux1.size(); i++)
         {
            gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux.add(new web.SdtEmpresa_abm_1_nolaborables_religion(remoteHandle, gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtEmpresa_abm_1_Nolaborables_religion(gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux);
      setgxTv_SdtEmpresa_abm_1_Empguaredadmin(struct.getEmpguaredadmin());
      setgxTv_SdtEmpresa_abm_1_Empguaredadmax(struct.getEmpguaredadmax());
      setgxTv_SdtEmpresa_abm_1_Empliqgan(struct.getEmpliqgan());
      setgxTv_SdtEmpresa_abm_1_Emptipoexp(struct.getEmptipoexp());
      setgxTv_SdtEmpresa_abm_1_Emppromdesde(struct.getEmppromdesde());
      setgxTv_SdtEmpresa_abm_1_Empfracvacant(struct.getEmpfracvacant());
      setgxTv_SdtEmpresa_abm_1_Empvacexplim(struct.getEmpvacexplim());
      setgxTv_SdtEmpresa_abm_1_Empvacexptie(struct.getEmpvacexptie());
      setgxTv_SdtEmpresa_abm_1_Empvacdismax(struct.getEmpvacdismax());
      setgxTv_SdtEmpresa_abm_1_Actcomcodigo(struct.getActcomcodigo());
      setgxTv_SdtEmpresa_abm_1_Emposocod(struct.getEmposocod());
      setgxTv_SdtEmpresa_abm_1_Empcondicod(struct.getEmpcondicod());
      setgxTv_SdtEmpresa_abm_1_Empmodtra(struct.getEmpmodtra());
      setgxTv_SdtEmpresa_abm_1_Empmodempl(struct.getEmpmodempl());
      setgxTv_SdtEmpresa_abm_1_Empmodauto(struct.getEmpmodauto());
      setgxTv_SdtEmpresa_abm_1_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtEmpresa_abm_1_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtEmpresa_abm_1_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtEmpresa_abm_1_Empcuit_Z(struct.getEmpcuit_Z());
      setgxTv_SdtEmpresa_abm_1_Empdir_Z(struct.getEmpdir_Z());
      setgxTv_SdtEmpresa_abm_1_Emptel_Z(struct.getEmptel_Z());
      setgxTv_SdtEmpresa_abm_1_Empcp_Z(struct.getEmpcp_Z());
      setgxTv_SdtEmpresa_abm_1_Paicod_Z(struct.getPaicod_Z());
      setgxTv_SdtEmpresa_abm_1_Painom_Z(struct.getPainom_Z());
      setgxTv_SdtEmpresa_abm_1_Provcod_Z(struct.getProvcod_Z());
      setgxTv_SdtEmpresa_abm_1_Provnom_Z(struct.getProvnom_Z());
      setgxTv_SdtEmpresa_abm_1_Emppervacdes_Z(struct.getEmppervacdes_Z());
      setgxTv_SdtEmpresa_abm_1_Emppervachas_Z(struct.getEmppervachas_Z());
      setgxTv_SdtEmpresa_abm_1_Loccod_Z(struct.getLoccod_Z());
      setgxTv_SdtEmpresa_abm_1_Locnom_Z(struct.getLocnom_Z());
      setgxTv_SdtEmpresa_abm_1_Actcodigo_Z(struct.getActcodigo_Z());
      setgxTv_SdtEmpresa_abm_1_Actdescrip_Z(struct.getActdescrip_Z());
      setgxTv_SdtEmpresa_abm_1_Tipemplecod_Z(struct.getTipemplecod_Z());
      setgxTv_SdtEmpresa_abm_1_Empactcomercial_Z(struct.getEmpactcomercial_Z());
      setgxTv_SdtEmpresa_abm_1_Empzoncod_Z(struct.getEmpzoncod_Z());
      setgxTv_SdtEmpresa_abm_1_Empzondescrip_Z(struct.getEmpzondescrip_Z());
      setgxTv_SdtEmpresa_abm_1_Empreducc_Z(struct.getEmpreducc_Z());
      setgxTv_SdtEmpresa_abm_1_Tipempledefins_Z(struct.getTipempledefins_Z());
      setgxTv_SdtEmpresa_abm_1_Emplogonom_Z(struct.getEmplogonom_Z());
      setgxTv_SdtEmpresa_abm_1_Emplogoext_Z(struct.getEmplogoext_Z());
      setgxTv_SdtEmpresa_abm_1_Empfirmanom_Z(struct.getEmpfirmanom_Z());
      setgxTv_SdtEmpresa_abm_1_Empfirmaext_Z(struct.getEmpfirmaext_Z());
      setgxTv_SdtEmpresa_abm_1_Empantiguedad_Z(struct.getEmpantiguedad_Z());
      setgxTv_SdtEmpresa_abm_1_Emppresentismo_Z(struct.getEmppresentismo_Z());
      setgxTv_SdtEmpresa_abm_1_Empmeshspext_Z(struct.getEmpmeshspext_Z());
      setgxTv_SdtEmpresa_abm_1_Empliqfer_Z(struct.getEmpliqfer_Z());
      setgxTv_SdtEmpresa_abm_1_Empliqferjor_Z(struct.getEmpliqferjor_Z());
      setgxTv_SdtEmpresa_abm_1_Empdiahspext_Z(struct.getEmpdiahspext_Z());
      setgxTv_SdtEmpresa_abm_1_Artsec_Z(struct.getArtsec_Z());
      setgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z(struct.getEmpguaredadmin_Z());
      setgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z(struct.getEmpguaredadmax_Z());
      setgxTv_SdtEmpresa_abm_1_Empliqgan_Z(struct.getEmpliqgan_Z());
      setgxTv_SdtEmpresa_abm_1_Emptipoexp_Z(struct.getEmptipoexp_Z());
      setgxTv_SdtEmpresa_abm_1_Emppromdesde_Z(struct.getEmppromdesde_Z());
      setgxTv_SdtEmpresa_abm_1_Empfracvacant_Z(struct.getEmpfracvacant_Z());
      setgxTv_SdtEmpresa_abm_1_Empvacexplim_Z(struct.getEmpvacexplim_Z());
      setgxTv_SdtEmpresa_abm_1_Empvacexptie_Z(struct.getEmpvacexptie_Z());
      setgxTv_SdtEmpresa_abm_1_Empvacdismax_Z(struct.getEmpvacdismax_Z());
      setgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z(struct.getActcomcodigo_Z());
      setgxTv_SdtEmpresa_abm_1_Emposocod_Z(struct.getEmposocod_Z());
      setgxTv_SdtEmpresa_abm_1_Empcondicod_Z(struct.getEmpcondicod_Z());
      setgxTv_SdtEmpresa_abm_1_Empmodtra_Z(struct.getEmpmodtra_Z());
      setgxTv_SdtEmpresa_abm_1_Empmodempl_Z(struct.getEmpmodempl_Z());
      setgxTv_SdtEmpresa_abm_1_Empmodauto_Z(struct.getEmpmodauto_Z());
      setgxTv_SdtEmpresa_abm_1_Emptel_N(struct.getEmptel_N());
      setgxTv_SdtEmpresa_abm_1_Empcp_N(struct.getEmpcp_N());
      setgxTv_SdtEmpresa_abm_1_Paicod_N(struct.getPaicod_N());
      setgxTv_SdtEmpresa_abm_1_Provcod_N(struct.getProvcod_N());
      setgxTv_SdtEmpresa_abm_1_Loccod_N(struct.getLoccod_N());
      setgxTv_SdtEmpresa_abm_1_Actcodigo_N(struct.getActcodigo_N());
      setgxTv_SdtEmpresa_abm_1_Tipemplecod_N(struct.getTipemplecod_N());
      setgxTv_SdtEmpresa_abm_1_Empzoncod_N(struct.getEmpzoncod_N());
      setgxTv_SdtEmpresa_abm_1_Emplogo_N(struct.getEmplogo_N());
      setgxTv_SdtEmpresa_abm_1_Emplogonom_N(struct.getEmplogonom_N());
      setgxTv_SdtEmpresa_abm_1_Emplogoext_N(struct.getEmplogoext_N());
      setgxTv_SdtEmpresa_abm_1_Empfirma_N(struct.getEmpfirma_N());
      setgxTv_SdtEmpresa_abm_1_Empfirmanom_N(struct.getEmpfirmanom_N());
      setgxTv_SdtEmpresa_abm_1_Empfirmaext_N(struct.getEmpfirmaext_N());
      setgxTv_SdtEmpresa_abm_1_Empmeshspext_N(struct.getEmpmeshspext_N());
      setgxTv_SdtEmpresa_abm_1_Empdiahspext_N(struct.getEmpdiahspext_N());
      setgxTv_SdtEmpresa_abm_1_Emposocod_N(struct.getEmposocod_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1 getStruct( )
   {
      web.StructSdtEmpresa_abm_1 struct = new web.StructSdtEmpresa_abm_1 ();
      struct.setClicod(getgxTv_SdtEmpresa_abm_1_Clicod());
      struct.setEmpcod(getgxTv_SdtEmpresa_abm_1_Empcod());
      struct.setEmpnom(getgxTv_SdtEmpresa_abm_1_Empnom());
      struct.setEmpcuit(getgxTv_SdtEmpresa_abm_1_Empcuit());
      struct.setEmpdir(getgxTv_SdtEmpresa_abm_1_Empdir());
      struct.setEmptel(getgxTv_SdtEmpresa_abm_1_Emptel());
      struct.setEmpcp(getgxTv_SdtEmpresa_abm_1_Empcp());
      struct.setPaicod(getgxTv_SdtEmpresa_abm_1_Paicod());
      struct.setPainom(getgxTv_SdtEmpresa_abm_1_Painom());
      struct.setProvcod(getgxTv_SdtEmpresa_abm_1_Provcod());
      struct.setProvnom(getgxTv_SdtEmpresa_abm_1_Provnom());
      struct.setEmppervacdes(getgxTv_SdtEmpresa_abm_1_Emppervacdes());
      struct.setEmppervachas(getgxTv_SdtEmpresa_abm_1_Emppervachas());
      struct.setLoccod(getgxTv_SdtEmpresa_abm_1_Loccod());
      struct.setLocnom(getgxTv_SdtEmpresa_abm_1_Locnom());
      struct.setActcodigo(getgxTv_SdtEmpresa_abm_1_Actcodigo());
      struct.setActdescrip(getgxTv_SdtEmpresa_abm_1_Actdescrip());
      struct.setTipemplecod(getgxTv_SdtEmpresa_abm_1_Tipemplecod());
      struct.setEmpactcomercial(getgxTv_SdtEmpresa_abm_1_Empactcomercial());
      struct.setEmpzoncod(getgxTv_SdtEmpresa_abm_1_Empzoncod());
      struct.setEmpzondescrip(getgxTv_SdtEmpresa_abm_1_Empzondescrip());
      struct.setEmpreducc(getgxTv_SdtEmpresa_abm_1_Empreducc());
      struct.setTipempledefins(getgxTv_SdtEmpresa_abm_1_Tipempledefins());
      struct.setEmplogo(getgxTv_SdtEmpresa_abm_1_Emplogo());
      struct.setEmplogonom(getgxTv_SdtEmpresa_abm_1_Emplogonom());
      struct.setEmplogoext(getgxTv_SdtEmpresa_abm_1_Emplogoext());
      struct.setEmpfirma(getgxTv_SdtEmpresa_abm_1_Empfirma());
      struct.setEmpfirmanom(getgxTv_SdtEmpresa_abm_1_Empfirmanom());
      struct.setConceptos_horanormal_mensualizados(getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados().getStruct());
      struct.setEmpfirmaext(getgxTv_SdtEmpresa_abm_1_Empfirmaext());
      struct.setConceptos_horanormal_jornalizados(getgxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados().getStruct());
      struct.setEmpantiguedad(getgxTv_SdtEmpresa_abm_1_Empantiguedad());
      struct.setPromedio_horanormal_mensualizados(getgxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados().getStruct());
      struct.setEmppresentismo(getgxTv_SdtEmpresa_abm_1_Emppresentismo());
      struct.setEmpmeshspext(getgxTv_SdtEmpresa_abm_1_Empmeshspext());
      struct.setEmpliqfer(getgxTv_SdtEmpresa_abm_1_Empliqfer());
      struct.setEmpliqferjor(getgxTv_SdtEmpresa_abm_1_Empliqferjor());
      struct.setEmpdiahspext(getgxTv_SdtEmpresa_abm_1_Empdiahspext());
      struct.setArtsec(getgxTv_SdtEmpresa_abm_1_Artsec());
      struct.setBase_calculo(getgxTv_SdtEmpresa_abm_1_Base_calculo().getStruct());
      struct.setHorasextras_pordia(getgxTv_SdtEmpresa_abm_1_Horasextras_pordia().getStruct());
      struct.setTipo_trabajo(getgxTv_SdtEmpresa_abm_1_Tipo_trabajo().getStruct());
      struct.setNolaborables_convenio(getgxTv_SdtEmpresa_abm_1_Nolaborables_convenio().getStruct());
      struct.setNolaborables_origen(getgxTv_SdtEmpresa_abm_1_Nolaborables_origen().getStruct());
      struct.setNolaborables_religion(getgxTv_SdtEmpresa_abm_1_Nolaborables_religion().getStruct());
      struct.setEmpguaredadmin(getgxTv_SdtEmpresa_abm_1_Empguaredadmin());
      struct.setEmpguaredadmax(getgxTv_SdtEmpresa_abm_1_Empguaredadmax());
      struct.setEmpliqgan(getgxTv_SdtEmpresa_abm_1_Empliqgan());
      struct.setEmptipoexp(getgxTv_SdtEmpresa_abm_1_Emptipoexp());
      struct.setEmppromdesde(getgxTv_SdtEmpresa_abm_1_Emppromdesde());
      struct.setEmpfracvacant(getgxTv_SdtEmpresa_abm_1_Empfracvacant());
      struct.setEmpvacexplim(getgxTv_SdtEmpresa_abm_1_Empvacexplim());
      struct.setEmpvacexptie(getgxTv_SdtEmpresa_abm_1_Empvacexptie());
      struct.setEmpvacdismax(getgxTv_SdtEmpresa_abm_1_Empvacdismax());
      struct.setActcomcodigo(getgxTv_SdtEmpresa_abm_1_Actcomcodigo());
      struct.setEmposocod(getgxTv_SdtEmpresa_abm_1_Emposocod());
      struct.setEmpcondicod(getgxTv_SdtEmpresa_abm_1_Empcondicod());
      struct.setEmpmodtra(getgxTv_SdtEmpresa_abm_1_Empmodtra());
      struct.setEmpmodempl(getgxTv_SdtEmpresa_abm_1_Empmodempl());
      struct.setEmpmodauto(getgxTv_SdtEmpresa_abm_1_Empmodauto());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_Mode());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_Initialized());
      struct.setClicod_Z(getgxTv_SdtEmpresa_abm_1_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtEmpresa_abm_1_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtEmpresa_abm_1_Empnom_Z());
      struct.setEmpcuit_Z(getgxTv_SdtEmpresa_abm_1_Empcuit_Z());
      struct.setEmpdir_Z(getgxTv_SdtEmpresa_abm_1_Empdir_Z());
      struct.setEmptel_Z(getgxTv_SdtEmpresa_abm_1_Emptel_Z());
      struct.setEmpcp_Z(getgxTv_SdtEmpresa_abm_1_Empcp_Z());
      struct.setPaicod_Z(getgxTv_SdtEmpresa_abm_1_Paicod_Z());
      struct.setPainom_Z(getgxTv_SdtEmpresa_abm_1_Painom_Z());
      struct.setProvcod_Z(getgxTv_SdtEmpresa_abm_1_Provcod_Z());
      struct.setProvnom_Z(getgxTv_SdtEmpresa_abm_1_Provnom_Z());
      struct.setEmppervacdes_Z(getgxTv_SdtEmpresa_abm_1_Emppervacdes_Z());
      struct.setEmppervachas_Z(getgxTv_SdtEmpresa_abm_1_Emppervachas_Z());
      struct.setLoccod_Z(getgxTv_SdtEmpresa_abm_1_Loccod_Z());
      struct.setLocnom_Z(getgxTv_SdtEmpresa_abm_1_Locnom_Z());
      struct.setActcodigo_Z(getgxTv_SdtEmpresa_abm_1_Actcodigo_Z());
      struct.setActdescrip_Z(getgxTv_SdtEmpresa_abm_1_Actdescrip_Z());
      struct.setTipemplecod_Z(getgxTv_SdtEmpresa_abm_1_Tipemplecod_Z());
      struct.setEmpactcomercial_Z(getgxTv_SdtEmpresa_abm_1_Empactcomercial_Z());
      struct.setEmpzoncod_Z(getgxTv_SdtEmpresa_abm_1_Empzoncod_Z());
      struct.setEmpzondescrip_Z(getgxTv_SdtEmpresa_abm_1_Empzondescrip_Z());
      struct.setEmpreducc_Z(getgxTv_SdtEmpresa_abm_1_Empreducc_Z());
      struct.setTipempledefins_Z(getgxTv_SdtEmpresa_abm_1_Tipempledefins_Z());
      struct.setEmplogonom_Z(getgxTv_SdtEmpresa_abm_1_Emplogonom_Z());
      struct.setEmplogoext_Z(getgxTv_SdtEmpresa_abm_1_Emplogoext_Z());
      struct.setEmpfirmanom_Z(getgxTv_SdtEmpresa_abm_1_Empfirmanom_Z());
      struct.setEmpfirmaext_Z(getgxTv_SdtEmpresa_abm_1_Empfirmaext_Z());
      struct.setEmpantiguedad_Z(getgxTv_SdtEmpresa_abm_1_Empantiguedad_Z());
      struct.setEmppresentismo_Z(getgxTv_SdtEmpresa_abm_1_Emppresentismo_Z());
      struct.setEmpmeshspext_Z(getgxTv_SdtEmpresa_abm_1_Empmeshspext_Z());
      struct.setEmpliqfer_Z(getgxTv_SdtEmpresa_abm_1_Empliqfer_Z());
      struct.setEmpliqferjor_Z(getgxTv_SdtEmpresa_abm_1_Empliqferjor_Z());
      struct.setEmpdiahspext_Z(getgxTv_SdtEmpresa_abm_1_Empdiahspext_Z());
      struct.setArtsec_Z(getgxTv_SdtEmpresa_abm_1_Artsec_Z());
      struct.setEmpguaredadmin_Z(getgxTv_SdtEmpresa_abm_1_Empguaredadmin_Z());
      struct.setEmpguaredadmax_Z(getgxTv_SdtEmpresa_abm_1_Empguaredadmax_Z());
      struct.setEmpliqgan_Z(getgxTv_SdtEmpresa_abm_1_Empliqgan_Z());
      struct.setEmptipoexp_Z(getgxTv_SdtEmpresa_abm_1_Emptipoexp_Z());
      struct.setEmppromdesde_Z(getgxTv_SdtEmpresa_abm_1_Emppromdesde_Z());
      struct.setEmpfracvacant_Z(getgxTv_SdtEmpresa_abm_1_Empfracvacant_Z());
      struct.setEmpvacexplim_Z(getgxTv_SdtEmpresa_abm_1_Empvacexplim_Z());
      struct.setEmpvacexptie_Z(getgxTv_SdtEmpresa_abm_1_Empvacexptie_Z());
      struct.setEmpvacdismax_Z(getgxTv_SdtEmpresa_abm_1_Empvacdismax_Z());
      struct.setActcomcodigo_Z(getgxTv_SdtEmpresa_abm_1_Actcomcodigo_Z());
      struct.setEmposocod_Z(getgxTv_SdtEmpresa_abm_1_Emposocod_Z());
      struct.setEmpcondicod_Z(getgxTv_SdtEmpresa_abm_1_Empcondicod_Z());
      struct.setEmpmodtra_Z(getgxTv_SdtEmpresa_abm_1_Empmodtra_Z());
      struct.setEmpmodempl_Z(getgxTv_SdtEmpresa_abm_1_Empmodempl_Z());
      struct.setEmpmodauto_Z(getgxTv_SdtEmpresa_abm_1_Empmodauto_Z());
      struct.setEmptel_N(getgxTv_SdtEmpresa_abm_1_Emptel_N());
      struct.setEmpcp_N(getgxTv_SdtEmpresa_abm_1_Empcp_N());
      struct.setPaicod_N(getgxTv_SdtEmpresa_abm_1_Paicod_N());
      struct.setProvcod_N(getgxTv_SdtEmpresa_abm_1_Provcod_N());
      struct.setLoccod_N(getgxTv_SdtEmpresa_abm_1_Loccod_N());
      struct.setActcodigo_N(getgxTv_SdtEmpresa_abm_1_Actcodigo_N());
      struct.setTipemplecod_N(getgxTv_SdtEmpresa_abm_1_Tipemplecod_N());
      struct.setEmpzoncod_N(getgxTv_SdtEmpresa_abm_1_Empzoncod_N());
      struct.setEmplogo_N(getgxTv_SdtEmpresa_abm_1_Emplogo_N());
      struct.setEmplogonom_N(getgxTv_SdtEmpresa_abm_1_Emplogonom_N());
      struct.setEmplogoext_N(getgxTv_SdtEmpresa_abm_1_Emplogoext_N());
      struct.setEmpfirma_N(getgxTv_SdtEmpresa_abm_1_Empfirma_N());
      struct.setEmpfirmanom_N(getgxTv_SdtEmpresa_abm_1_Empfirmanom_N());
      struct.setEmpfirmaext_N(getgxTv_SdtEmpresa_abm_1_Empfirmaext_N());
      struct.setEmpmeshspext_N(getgxTv_SdtEmpresa_abm_1_Empmeshspext_N());
      struct.setEmpdiahspext_N(getgxTv_SdtEmpresa_abm_1_Empdiahspext_N());
      struct.setEmposocod_N(getgxTv_SdtEmpresa_abm_1_Emposocod_N());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_N ;
   private byte gxTv_SdtEmpresa_abm_1_Emppervacdes ;
   private byte gxTv_SdtEmpresa_abm_1_Emppervachas ;
   private byte gxTv_SdtEmpresa_abm_1_Empguaredadmin ;
   private byte gxTv_SdtEmpresa_abm_1_Empguaredadmax ;
   private byte gxTv_SdtEmpresa_abm_1_Emptipoexp ;
   private byte gxTv_SdtEmpresa_abm_1_Empvacexptie ;
   private byte gxTv_SdtEmpresa_abm_1_Emppervacdes_Z ;
   private byte gxTv_SdtEmpresa_abm_1_Emppervachas_Z ;
   private byte gxTv_SdtEmpresa_abm_1_Empguaredadmin_Z ;
   private byte gxTv_SdtEmpresa_abm_1_Empguaredadmax_Z ;
   private byte gxTv_SdtEmpresa_abm_1_Emptipoexp_Z ;
   private byte gxTv_SdtEmpresa_abm_1_Empvacexptie_Z ;
   private byte gxTv_SdtEmpresa_abm_1_Emptel_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empcp_N ;
   private byte gxTv_SdtEmpresa_abm_1_Paicod_N ;
   private byte gxTv_SdtEmpresa_abm_1_Provcod_N ;
   private byte gxTv_SdtEmpresa_abm_1_Loccod_N ;
   private byte gxTv_SdtEmpresa_abm_1_Actcodigo_N ;
   private byte gxTv_SdtEmpresa_abm_1_Tipemplecod_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empzoncod_N ;
   private byte gxTv_SdtEmpresa_abm_1_Emplogo_N ;
   private byte gxTv_SdtEmpresa_abm_1_Emplogonom_N ;
   private byte gxTv_SdtEmpresa_abm_1_Emplogoext_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empfirma_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empfirmanom_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empfirmaext_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empmeshspext_N ;
   private byte gxTv_SdtEmpresa_abm_1_Empdiahspext_N ;
   private byte gxTv_SdtEmpresa_abm_1_Emposocod_N ;
   private short gxTv_SdtEmpresa_abm_1_Empcod ;
   private short gxTv_SdtEmpresa_abm_1_Paicod ;
   private short gxTv_SdtEmpresa_abm_1_Provcod ;
   private short gxTv_SdtEmpresa_abm_1_Loccod ;
   private short gxTv_SdtEmpresa_abm_1_Artsec ;
   private short gxTv_SdtEmpresa_abm_1_Empcondicod ;
   private short gxTv_SdtEmpresa_abm_1_Initialized ;
   private short gxTv_SdtEmpresa_abm_1_Empcod_Z ;
   private short gxTv_SdtEmpresa_abm_1_Paicod_Z ;
   private short gxTv_SdtEmpresa_abm_1_Provcod_Z ;
   private short gxTv_SdtEmpresa_abm_1_Loccod_Z ;
   private short gxTv_SdtEmpresa_abm_1_Artsec_Z ;
   private short gxTv_SdtEmpresa_abm_1_Empcondicod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEmpresa_abm_1_Clicod ;
   private int gxTv_SdtEmpresa_abm_1_Empvacdismax ;
   private int gxTv_SdtEmpresa_abm_1_Clicod_Z ;
   private int gxTv_SdtEmpresa_abm_1_Empvacdismax_Z ;
   private long gxTv_SdtEmpresa_abm_1_Empcuit ;
   private long gxTv_SdtEmpresa_abm_1_Empcuit_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Empantiguedad ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Emppresentismo ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Empmeshspext ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Empfracvacant ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Empantiguedad_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Emppresentismo_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Empmeshspext_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_Empfracvacant_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empcp ;
   private String gxTv_SdtEmpresa_abm_1_Actcodigo ;
   private String gxTv_SdtEmpresa_abm_1_Tipemplecod ;
   private String gxTv_SdtEmpresa_abm_1_Empactcomercial ;
   private String gxTv_SdtEmpresa_abm_1_Empzoncod ;
   private String gxTv_SdtEmpresa_abm_1_Tipempledefins ;
   private String gxTv_SdtEmpresa_abm_1_Emplogoext ;
   private String gxTv_SdtEmpresa_abm_1_Empfirmaext ;
   private String gxTv_SdtEmpresa_abm_1_Empdiahspext ;
   private String gxTv_SdtEmpresa_abm_1_Emppromdesde ;
   private String gxTv_SdtEmpresa_abm_1_Actcomcodigo ;
   private String gxTv_SdtEmpresa_abm_1_Emposocod ;
   private String gxTv_SdtEmpresa_abm_1_Empmodtra ;
   private String gxTv_SdtEmpresa_abm_1_Mode ;
   private String gxTv_SdtEmpresa_abm_1_Empcp_Z ;
   private String gxTv_SdtEmpresa_abm_1_Actcodigo_Z ;
   private String gxTv_SdtEmpresa_abm_1_Tipemplecod_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empactcomercial_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empzoncod_Z ;
   private String gxTv_SdtEmpresa_abm_1_Tipempledefins_Z ;
   private String gxTv_SdtEmpresa_abm_1_Emplogoext_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empfirmaext_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empdiahspext_Z ;
   private String gxTv_SdtEmpresa_abm_1_Emppromdesde_Z ;
   private String gxTv_SdtEmpresa_abm_1_Actcomcodigo_Z ;
   private String gxTv_SdtEmpresa_abm_1_Emposocod_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empmodtra_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEmpresa_abm_1_Empreducc ;
   private boolean gxTv_SdtEmpresa_abm_1_Empliqfer ;
   private boolean gxTv_SdtEmpresa_abm_1_Empliqferjor ;
   private boolean gxTv_SdtEmpresa_abm_1_Empliqgan ;
   private boolean gxTv_SdtEmpresa_abm_1_Empvacexplim ;
   private boolean gxTv_SdtEmpresa_abm_1_Empmodempl ;
   private boolean gxTv_SdtEmpresa_abm_1_Empmodauto ;
   private boolean gxTv_SdtEmpresa_abm_1_Empreducc_Z ;
   private boolean gxTv_SdtEmpresa_abm_1_Empliqfer_Z ;
   private boolean gxTv_SdtEmpresa_abm_1_Empliqferjor_Z ;
   private boolean gxTv_SdtEmpresa_abm_1_Empliqgan_Z ;
   private boolean gxTv_SdtEmpresa_abm_1_Empvacexplim_Z ;
   private boolean gxTv_SdtEmpresa_abm_1_Empmodempl_Z ;
   private boolean gxTv_SdtEmpresa_abm_1_Empmodauto_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEmpresa_abm_1_Emplogo ;
   private String gxTv_SdtEmpresa_abm_1_Empfirma ;
   private String gxTv_SdtEmpresa_abm_1_Empnom ;
   private String gxTv_SdtEmpresa_abm_1_Empdir ;
   private String gxTv_SdtEmpresa_abm_1_Emptel ;
   private String gxTv_SdtEmpresa_abm_1_Painom ;
   private String gxTv_SdtEmpresa_abm_1_Provnom ;
   private String gxTv_SdtEmpresa_abm_1_Locnom ;
   private String gxTv_SdtEmpresa_abm_1_Actdescrip ;
   private String gxTv_SdtEmpresa_abm_1_Empzondescrip ;
   private String gxTv_SdtEmpresa_abm_1_Emplogonom ;
   private String gxTv_SdtEmpresa_abm_1_Empfirmanom ;
   private String gxTv_SdtEmpresa_abm_1_Empnom_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empdir_Z ;
   private String gxTv_SdtEmpresa_abm_1_Emptel_Z ;
   private String gxTv_SdtEmpresa_abm_1_Painom_Z ;
   private String gxTv_SdtEmpresa_abm_1_Provnom_Z ;
   private String gxTv_SdtEmpresa_abm_1_Locnom_Z ;
   private String gxTv_SdtEmpresa_abm_1_Actdescrip_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empzondescrip_Z ;
   private String gxTv_SdtEmpresa_abm_1_Emplogonom_Z ;
   private String gxTv_SdtEmpresa_abm_1_Empfirmanom_Z ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> gxTv_SdtEmpresa_abm_1_Base_calculo_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> gxTv_SdtEmpresa_abm_1_Horasextras_pordia_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> gxTv_SdtEmpresa_abm_1_Tipo_trabajo_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> gxTv_SdtEmpresa_abm_1_Nolaborables_convenio_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> gxTv_SdtEmpresa_abm_1_Nolaborables_origen_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> gxTv_SdtEmpresa_abm_1_Nolaborables_religion_aux ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_mensualizados=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados> gxTv_SdtEmpresa_abm_1_Conceptos_horanormal_jornalizados=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados> gxTv_SdtEmpresa_abm_1_Promedio_horanormal_mensualizados=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_base_calculo> gxTv_SdtEmpresa_abm_1_Base_calculo=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_horasextras_pordia> gxTv_SdtEmpresa_abm_1_Horasextras_pordia=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_tipo_trabajo> gxTv_SdtEmpresa_abm_1_Tipo_trabajo=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_convenio> gxTv_SdtEmpresa_abm_1_Nolaborables_convenio=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_origen> gxTv_SdtEmpresa_abm_1_Nolaborables_origen=null ;
   private GXBCLevelCollection<web.SdtEmpresa_abm_1_nolaborables_religion> gxTv_SdtEmpresa_abm_1_Nolaborables_religion=null ;
}

