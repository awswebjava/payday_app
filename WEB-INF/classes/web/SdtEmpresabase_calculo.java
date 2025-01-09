package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresabase_calculo extends GxSilentTrnSdt
{
   public SdtEmpresabase_calculo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresabase_calculo.class));
   }

   public SdtEmpresabase_calculo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresabase_calculo");
      initialize( remoteHandle) ;
   }

   public SdtEmpresabase_calculo( int remoteHandle ,
                                  StructSdtEmpresabase_calculo struct )
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
                     short AV1EmpCod ,
                     byte AV1427EmpBaseClaseLeg ,
                     String AV1429EmpBaseTipo ,
                     String AV1430EmpBaseCod1 ,
                     String AV1431EmpBaseCod2 )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Byte.valueOf(AV1427EmpBaseClaseLeg),AV1429EmpBaseTipo,AV1430EmpBaseCod1,AV1431EmpBaseCod2});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"EmpBaseClaseLeg", byte.class}, new Object[]{"EmpBaseTipo", String.class}, new Object[]{"EmpBaseCod1", String.class}, new Object[]{"EmpBaseCod2", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Empresabase_calculo");
      metadata.set("BT", "Empresabase_calculo");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"EmpBaseClaseLeg\",\"EmpBaseTipo\",\"EmpBaseCod1\",\"EmpBaseCod2\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtEmpresabase_calculo_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtEmpresabase_calculo_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseClaseLeg") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseclaseleg = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseTipo") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasetipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod1") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasecod1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseC1Txt") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasec1txt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod2") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasecod2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseC2Txt") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasec2txt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePlus") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseplus = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDMin") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdmin = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDLim") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdlim = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDSeman") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdseman = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDMes") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdmes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDSemes") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdsemes = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDAnual") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdanual = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicAdju") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicadju = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicAdjuObl") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicadjuobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicNecAut") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicnecaut = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicIngMot") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicingmot = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicMotObl") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicmotobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseOrd") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseord = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePromCnt1") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePromCnt2") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePromTCnt") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasepromtcnt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseRelSec") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaserelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresabase_calculo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresabase_calculo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseClaseLeg_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseTipo_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasetipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod1_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasecod1_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseC1Txt_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod2_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasecod2_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseC2Txt_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePlus_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseplus_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDMin_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdmin_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDLim_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdlim_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDSeman_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdseman_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDMes_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdmes_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDSemes_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDAnual_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdanual_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicAdju_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicadju_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicAdjuObl_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicNecAut_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicIngMot_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicingmot_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicMotObl_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseOrd_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseord_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePromCnt1_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePromCnt2_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePromTCnt_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseRelSec_Z") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDMin_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdmin_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDLim_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdlim_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDSeman_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdseman_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDMes_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdmes_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDSemes_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicDAnual_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicdanual_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicAdju_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicadju_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicAdjuObl_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicNecAut_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicIngMot_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicingmot_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpLicMotObl_N") )
            {
               gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseOrd_N") )
            {
               gxTv_SdtEmpresabase_calculo_Empbaseord_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Empresabase_calculo" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseClaseLeg", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaseclaseleg, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseTipo", gxTv_SdtEmpresabase_calculo_Empbasetipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseCod1", gxTv_SdtEmpresabase_calculo_Empbasecod1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseC1Txt", gxTv_SdtEmpresabase_calculo_Empbasec1txt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseCod2", gxTv_SdtEmpresabase_calculo_Empbasecod2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseC2Txt", gxTv_SdtEmpresabase_calculo_Empbasec2txt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBasePlus", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresabase_calculo_Empbaseplus, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicDMin", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdmin, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicDLim", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdlim, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicDSeman", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdseman, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicDMes", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdmes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicDSemes", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdsemes, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicDAnual", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdanual, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicAdju", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicadju));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicAdjuObl", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicadjuobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicNecAut", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicnecaut));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicIngMot", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicingmot));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpLicMotObl", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicmotobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseOrd", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaseord, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBasePromCnt1", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbasepromcnt1, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBasePromCnt2", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbasepromcnt2, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBasePromTCnt", gxTv_SdtEmpresabase_calculo_Empbasepromtcnt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseRelSec", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaserelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresabase_calculo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseClaseLeg_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseTipo_Z", gxTv_SdtEmpresabase_calculo_Empbasetipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseCod1_Z", gxTv_SdtEmpresabase_calculo_Empbasecod1_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseC1Txt_Z", gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseCod2_Z", gxTv_SdtEmpresabase_calculo_Empbasecod2_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseC2Txt_Z", gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBasePlus_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresabase_calculo_Empbaseplus_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDMin_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdmin_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDLim_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdlim_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDSeman_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdseman_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDMes_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdmes_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDSemes_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDAnual_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdanual_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicAdju_Z", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicadju_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicAdjuObl_Z", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicNecAut_Z", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicIngMot_Z", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicingmot_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicMotObl_Z", GXutil.booltostr( gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseOrd_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaseord_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBasePromCnt1_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBasePromCnt2_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBasePromTCnt_Z", gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDMin_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdmin_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDLim_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdlim_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDSeman_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdseman_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDMes_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdmes_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDSemes_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdsemes_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicDAnual_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicdanual_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicAdju_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicadju_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicAdjuObl_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicNecAut_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicnecaut_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicIngMot_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicingmot_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpLicMotObl_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Emplicmotobl_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseOrd_N", GXutil.trim( GXutil.str( gxTv_SdtEmpresabase_calculo_Empbaseord_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtEmpresabase_calculo_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtEmpresabase_calculo_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpBaseClaseLeg", gxTv_SdtEmpresabase_calculo_Empbaseclaseleg, false, includeNonInitialized);
      AddObjectProperty("EmpBaseTipo", gxTv_SdtEmpresabase_calculo_Empbasetipo, false, includeNonInitialized);
      AddObjectProperty("EmpBaseCod1", gxTv_SdtEmpresabase_calculo_Empbasecod1, false, includeNonInitialized);
      AddObjectProperty("EmpBaseC1Txt", gxTv_SdtEmpresabase_calculo_Empbasec1txt, false, includeNonInitialized);
      AddObjectProperty("EmpBaseCod2", gxTv_SdtEmpresabase_calculo_Empbasecod2, false, includeNonInitialized);
      AddObjectProperty("EmpBaseC2Txt", gxTv_SdtEmpresabase_calculo_Empbasec2txt, false, includeNonInitialized);
      AddObjectProperty("EmpBasePlus", gxTv_SdtEmpresabase_calculo_Empbaseplus, false, includeNonInitialized);
      AddObjectProperty("EmpLicDMin", gxTv_SdtEmpresabase_calculo_Emplicdmin, false, includeNonInitialized);
      AddObjectProperty("EmpLicDMin_N", gxTv_SdtEmpresabase_calculo_Emplicdmin_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicDLim", gxTv_SdtEmpresabase_calculo_Emplicdlim, false, includeNonInitialized);
      AddObjectProperty("EmpLicDLim_N", gxTv_SdtEmpresabase_calculo_Emplicdlim_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicDSeman", gxTv_SdtEmpresabase_calculo_Emplicdseman, false, includeNonInitialized);
      AddObjectProperty("EmpLicDSeman_N", gxTv_SdtEmpresabase_calculo_Emplicdseman_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicDMes", gxTv_SdtEmpresabase_calculo_Emplicdmes, false, includeNonInitialized);
      AddObjectProperty("EmpLicDMes_N", gxTv_SdtEmpresabase_calculo_Emplicdmes_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicDSemes", gxTv_SdtEmpresabase_calculo_Emplicdsemes, false, includeNonInitialized);
      AddObjectProperty("EmpLicDSemes_N", gxTv_SdtEmpresabase_calculo_Emplicdsemes_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicDAnual", gxTv_SdtEmpresabase_calculo_Emplicdanual, false, includeNonInitialized);
      AddObjectProperty("EmpLicDAnual_N", gxTv_SdtEmpresabase_calculo_Emplicdanual_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicAdju", gxTv_SdtEmpresabase_calculo_Emplicadju, false, includeNonInitialized);
      AddObjectProperty("EmpLicAdju_N", gxTv_SdtEmpresabase_calculo_Emplicadju_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicAdjuObl", gxTv_SdtEmpresabase_calculo_Emplicadjuobl, false, includeNonInitialized);
      AddObjectProperty("EmpLicAdjuObl_N", gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicNecAut", gxTv_SdtEmpresabase_calculo_Emplicnecaut, false, includeNonInitialized);
      AddObjectProperty("EmpLicNecAut_N", gxTv_SdtEmpresabase_calculo_Emplicnecaut_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicIngMot", gxTv_SdtEmpresabase_calculo_Emplicingmot, false, includeNonInitialized);
      AddObjectProperty("EmpLicIngMot_N", gxTv_SdtEmpresabase_calculo_Emplicingmot_N, false, includeNonInitialized);
      AddObjectProperty("EmpLicMotObl", gxTv_SdtEmpresabase_calculo_Emplicmotobl, false, includeNonInitialized);
      AddObjectProperty("EmpLicMotObl_N", gxTv_SdtEmpresabase_calculo_Emplicmotobl_N, false, includeNonInitialized);
      AddObjectProperty("EmpBaseOrd", gxTv_SdtEmpresabase_calculo_Empbaseord, false, includeNonInitialized);
      AddObjectProperty("EmpBaseOrd_N", gxTv_SdtEmpresabase_calculo_Empbaseord_N, false, includeNonInitialized);
      AddObjectProperty("EmpBasePromCnt1", gxTv_SdtEmpresabase_calculo_Empbasepromcnt1, false, includeNonInitialized);
      AddObjectProperty("EmpBasePromCnt2", gxTv_SdtEmpresabase_calculo_Empbasepromcnt2, false, includeNonInitialized);
      AddObjectProperty("EmpBasePromTCnt", gxTv_SdtEmpresabase_calculo_Empbasepromtcnt, false, includeNonInitialized);
      AddObjectProperty("EmpBaseRelSec", gxTv_SdtEmpresabase_calculo_Empbaserelsec, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresabase_calculo_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresabase_calculo_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtEmpresabase_calculo_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtEmpresabase_calculo_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseClaseLeg_Z", gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseTipo_Z", gxTv_SdtEmpresabase_calculo_Empbasetipo_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseCod1_Z", gxTv_SdtEmpresabase_calculo_Empbasecod1_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseC1Txt_Z", gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseCod2_Z", gxTv_SdtEmpresabase_calculo_Empbasecod2_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseC2Txt_Z", gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBasePlus_Z", gxTv_SdtEmpresabase_calculo_Empbaseplus_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDMin_Z", gxTv_SdtEmpresabase_calculo_Emplicdmin_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDLim_Z", gxTv_SdtEmpresabase_calculo_Emplicdlim_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDSeman_Z", gxTv_SdtEmpresabase_calculo_Emplicdseman_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDMes_Z", gxTv_SdtEmpresabase_calculo_Emplicdmes_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDSemes_Z", gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDAnual_Z", gxTv_SdtEmpresabase_calculo_Emplicdanual_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicAdju_Z", gxTv_SdtEmpresabase_calculo_Emplicadju_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicAdjuObl_Z", gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicNecAut_Z", gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicIngMot_Z", gxTv_SdtEmpresabase_calculo_Emplicingmot_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicMotObl_Z", gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseOrd_Z", gxTv_SdtEmpresabase_calculo_Empbaseord_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBasePromCnt1_Z", gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBasePromCnt2_Z", gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBasePromTCnt_Z", gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseRelSec_Z", gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z, false, includeNonInitialized);
         AddObjectProperty("EmpLicDMin_N", gxTv_SdtEmpresabase_calculo_Emplicdmin_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicDLim_N", gxTv_SdtEmpresabase_calculo_Emplicdlim_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicDSeman_N", gxTv_SdtEmpresabase_calculo_Emplicdseman_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicDMes_N", gxTv_SdtEmpresabase_calculo_Emplicdmes_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicDSemes_N", gxTv_SdtEmpresabase_calculo_Emplicdsemes_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicDAnual_N", gxTv_SdtEmpresabase_calculo_Emplicdanual_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicAdju_N", gxTv_SdtEmpresabase_calculo_Emplicadju_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicAdjuObl_N", gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicNecAut_N", gxTv_SdtEmpresabase_calculo_Emplicnecaut_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicIngMot_N", gxTv_SdtEmpresabase_calculo_Emplicingmot_N, false, includeNonInitialized);
         AddObjectProperty("EmpLicMotObl_N", gxTv_SdtEmpresabase_calculo_Emplicmotobl_N, false, includeNonInitialized);
         AddObjectProperty("EmpBaseOrd_N", gxTv_SdtEmpresabase_calculo_Empbaseord_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresabase_calculo sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Clicod = sdt.getgxTv_SdtEmpresabase_calculo_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empcod = sdt.getgxTv_SdtEmpresabase_calculo_Empcod() ;
      }
      if ( sdt.IsDirty("EmpBaseClaseLeg") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbaseclaseleg = sdt.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg() ;
      }
      if ( sdt.IsDirty("EmpBaseTipo") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasetipo = sdt.getgxTv_SdtEmpresabase_calculo_Empbasetipo() ;
      }
      if ( sdt.IsDirty("EmpBaseCod1") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasecod1 = sdt.getgxTv_SdtEmpresabase_calculo_Empbasecod1() ;
      }
      if ( sdt.IsDirty("EmpBaseC1Txt") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasec1txt = sdt.getgxTv_SdtEmpresabase_calculo_Empbasec1txt() ;
      }
      if ( sdt.IsDirty("EmpBaseCod2") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasecod2 = sdt.getgxTv_SdtEmpresabase_calculo_Empbasecod2() ;
      }
      if ( sdt.IsDirty("EmpBaseC2Txt") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasec2txt = sdt.getgxTv_SdtEmpresabase_calculo_Empbasec2txt() ;
      }
      if ( sdt.IsDirty("EmpBasePlus") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbaseplus = sdt.getgxTv_SdtEmpresabase_calculo_Empbaseplus() ;
      }
      if ( sdt.IsDirty("EmpLicDMin") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicdmin_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdmin_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicdmin = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdmin() ;
      }
      if ( sdt.IsDirty("EmpLicDLim") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicdlim_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdlim_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicdlim = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdlim() ;
      }
      if ( sdt.IsDirty("EmpLicDSeman") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicdseman_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdseman_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicdseman = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdseman() ;
      }
      if ( sdt.IsDirty("EmpLicDMes") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicdmes_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdmes_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicdmes = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdmes() ;
      }
      if ( sdt.IsDirty("EmpLicDSemes") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdsemes_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicdsemes = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdsemes() ;
      }
      if ( sdt.IsDirty("EmpLicDAnual") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicdanual_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdanual_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicdanual = sdt.getgxTv_SdtEmpresabase_calculo_Emplicdanual() ;
      }
      if ( sdt.IsDirty("EmpLicAdju") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicadju_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicadju_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicadju = sdt.getgxTv_SdtEmpresabase_calculo_Emplicadju() ;
      }
      if ( sdt.IsDirty("EmpLicAdjuObl") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicadjuobl = sdt.getgxTv_SdtEmpresabase_calculo_Emplicadjuobl() ;
      }
      if ( sdt.IsDirty("EmpLicNecAut") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicnecaut_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicnecaut = sdt.getgxTv_SdtEmpresabase_calculo_Emplicnecaut() ;
      }
      if ( sdt.IsDirty("EmpLicIngMot") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicingmot_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicingmot_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicingmot = sdt.getgxTv_SdtEmpresabase_calculo_Emplicingmot() ;
      }
      if ( sdt.IsDirty("EmpLicMotObl") )
      {
         gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = sdt.getgxTv_SdtEmpresabase_calculo_Emplicmotobl_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Emplicmotobl = sdt.getgxTv_SdtEmpresabase_calculo_Emplicmotobl() ;
      }
      if ( sdt.IsDirty("EmpBaseOrd") )
      {
         gxTv_SdtEmpresabase_calculo_Empbaseord_N = sdt.getgxTv_SdtEmpresabase_calculo_Empbaseord_N() ;
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbaseord = sdt.getgxTv_SdtEmpresabase_calculo_Empbaseord() ;
      }
      if ( sdt.IsDirty("EmpBasePromCnt1") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 = sdt.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1() ;
      }
      if ( sdt.IsDirty("EmpBasePromCnt2") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 = sdt.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2() ;
      }
      if ( sdt.IsDirty("EmpBasePromTCnt") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbasepromtcnt = sdt.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt() ;
      }
      if ( sdt.IsDirty("EmpBaseRelSec") )
      {
         gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresabase_calculo_Empbaserelsec = sdt.getgxTv_SdtEmpresabase_calculo_Empbaserelsec() ;
      }
   }

   public int getgxTv_SdtEmpresabase_calculo_Clicod( )
   {
      return gxTv_SdtEmpresabase_calculo_Clicod ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Clicod( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      if ( gxTv_SdtEmpresabase_calculo_Clicod != value )
      {
         gxTv_SdtEmpresabase_calculo_Mode = "INS" ;
         this.setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtEmpresabase_calculo_Clicod = value ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empcod( )
   {
      return gxTv_SdtEmpresabase_calculo_Empcod ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empcod( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      if ( gxTv_SdtEmpresabase_calculo_Empcod != value )
      {
         gxTv_SdtEmpresabase_calculo_Mode = "INS" ;
         this.setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtEmpresabase_calculo_Empcod = value ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseclaseleg ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      if ( gxTv_SdtEmpresabase_calculo_Empbaseclaseleg != value )
      {
         gxTv_SdtEmpresabase_calculo_Mode = "INS" ;
         this.setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( );
      }
      SetDirty("Empbaseclaseleg");
      gxTv_SdtEmpresabase_calculo_Empbaseclaseleg = value ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasetipo( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasetipo ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasetipo( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEmpresabase_calculo_Empbasetipo, value) != 0 )
      {
         gxTv_SdtEmpresabase_calculo_Mode = "INS" ;
         this.setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( );
      }
      SetDirty("Empbasetipo");
      gxTv_SdtEmpresabase_calculo_Empbasetipo = value ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasecod1( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod1 ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasecod1( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEmpresabase_calculo_Empbasecod1, value) != 0 )
      {
         gxTv_SdtEmpresabase_calculo_Mode = "INS" ;
         this.setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( );
      }
      SetDirty("Empbasecod1");
      gxTv_SdtEmpresabase_calculo_Empbasecod1 = value ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasec1txt( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec1txt ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec1txt( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasec1txt");
      gxTv_SdtEmpresabase_calculo_Empbasec1txt = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec1txt_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasec1txt = "" ;
      SetDirty("Empbasec1txt");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasec1txt_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasecod2( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod2 ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasecod2( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEmpresabase_calculo_Empbasecod2, value) != 0 )
      {
         gxTv_SdtEmpresabase_calculo_Mode = "INS" ;
         this.setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( );
         this.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( );
      }
      SetDirty("Empbasecod2");
      gxTv_SdtEmpresabase_calculo_Empbasecod2 = value ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasec2txt( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec2txt ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec2txt( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasec2txt");
      gxTv_SdtEmpresabase_calculo_Empbasec2txt = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec2txt_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasec2txt = "" ;
      SetDirty("Empbasec2txt");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasec2txt_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresabase_calculo_Empbaseplus( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseplus ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaseplus");
      gxTv_SdtEmpresabase_calculo_Empbaseplus = value ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdmin( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmin ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmin( byte value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdmin");
      gxTv_SdtEmpresabase_calculo_Emplicdmin = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmin_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmin = (byte)(0) ;
      SetDirty("Emplicdmin");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdmin_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicdmin_N==1) ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Emplicdlim( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdlim ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdlim( short value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdlim");
      gxTv_SdtEmpresabase_calculo_Emplicdlim = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdlim_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdlim = (short)(0) ;
      SetDirty("Emplicdlim");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdlim_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicdlim_N==1) ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdseman( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdseman ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdseman( byte value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdseman");
      gxTv_SdtEmpresabase_calculo_Emplicdseman = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdseman_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdseman = (byte)(0) ;
      SetDirty("Emplicdseman");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdseman_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicdseman_N==1) ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdmes( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmes ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmes( byte value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdmes");
      gxTv_SdtEmpresabase_calculo_Emplicdmes = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmes_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdmes = (byte)(0) ;
      SetDirty("Emplicdmes");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdmes_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicdmes_N==1) ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Emplicdsemes( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdsemes ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdsemes( short value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdsemes");
      gxTv_SdtEmpresabase_calculo_Emplicdsemes = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdsemes_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdsemes = (short)(0) ;
      SetDirty("Emplicdsemes");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdsemes_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicdsemes_N==1) ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Emplicdanual( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdanual ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdanual( short value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdanual");
      gxTv_SdtEmpresabase_calculo_Emplicdanual = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdanual_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicdanual = (short)(0) ;
      SetDirty("Emplicdanual");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdanual_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicdanual_N==1) ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadju( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadju ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadju( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicadju");
      gxTv_SdtEmpresabase_calculo_Emplicadju = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadju_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicadju = false ;
      SetDirty("Emplicadju");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadju_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicadju_N==1) ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadjuobl( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadjuobl ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadjuobl( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicadjuobl");
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl = false ;
      SetDirty("Emplicadjuobl");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N==1) ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicnecaut( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicnecaut ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicnecaut( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicnecaut");
      gxTv_SdtEmpresabase_calculo_Emplicnecaut = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicnecaut_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicnecaut = false ;
      SetDirty("Emplicnecaut");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicnecaut_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicnecaut_N==1) ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicingmot( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicingmot ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicingmot( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicingmot");
      gxTv_SdtEmpresabase_calculo_Emplicingmot = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicingmot_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicingmot = false ;
      SetDirty("Emplicingmot");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicingmot_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicingmot_N==1) ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicmotobl( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicmotobl ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicmotobl( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicmotobl");
      gxTv_SdtEmpresabase_calculo_Emplicmotobl = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicmotobl_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Emplicmotobl = false ;
      SetDirty("Emplicmotobl");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicmotobl_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Emplicmotobl_N==1) ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empbaseord( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseord ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseord( short value )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = (byte)(0) ;
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaseord");
      gxTv_SdtEmpresabase_calculo_Empbaseord = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseord_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Empbaseord = (short)(0) ;
      SetDirty("Empbaseord");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbaseord_IsNull( )
   {
      return (gxTv_SdtEmpresabase_calculo_Empbaseord_N==1) ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasepromcnt1");
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 = value ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasepromcnt2");
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 = value ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromtcnt ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasepromtcnt");
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt = value ;
   }

   public int getgxTv_SdtEmpresabase_calculo_Empbaserelsec( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaserelsec ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaserelsec( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaserelsec");
      gxTv_SdtEmpresabase_calculo_Empbaserelsec = value ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Mode( )
   {
      return gxTv_SdtEmpresabase_calculo_Mode ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Mode( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresabase_calculo_Mode = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Mode_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Initialized( )
   {
      return gxTv_SdtEmpresabase_calculo_Initialized ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Initialized( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresabase_calculo_Initialized = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Initialized_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEmpresabase_calculo_Clicod_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Clicod_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Clicod_Z( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtEmpresabase_calculo_Clicod_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Clicod_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empcod_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empcod_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empcod_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtEmpresabase_calculo_Empcod_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empcod_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaseclaseleg_Z");
      gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z = (byte)(0) ;
      SetDirty("Empbaseclaseleg_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasetipo_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasetipo_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasetipo_Z");
      gxTv_SdtEmpresabase_calculo_Empbasetipo_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasetipo_Z = "" ;
      SetDirty("Empbasetipo_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasetipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasecod1_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod1_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasecod1_Z");
      gxTv_SdtEmpresabase_calculo_Empbasecod1_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasecod1_Z = "" ;
      SetDirty("Empbasecod1_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasecod1_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasec1txt_Z");
      gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z = "" ;
      SetDirty("Empbasec1txt_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasecod2_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasecod2_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasecod2_Z");
      gxTv_SdtEmpresabase_calculo_Empbasecod2_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasecod2_Z = "" ;
      SetDirty("Empbasecod2_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasecod2_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasec2txt_Z");
      gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z = "" ;
      SetDirty("Empbasec2txt_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresabase_calculo_Empbaseplus_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseplus_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaseplus_Z");
      gxTv_SdtEmpresabase_calculo_Empbaseplus_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseplus_Z = DecimalUtil.ZERO ;
      SetDirty("Empbaseplus_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbaseplus_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdmin_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmin_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdmin_Z");
      gxTv_SdtEmpresabase_calculo_Emplicdmin_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmin_Z = (byte)(0) ;
      SetDirty("Emplicdmin_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdmin_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Emplicdlim_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdlim_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdlim_Z");
      gxTv_SdtEmpresabase_calculo_Emplicdlim_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdlim_Z = (short)(0) ;
      SetDirty("Emplicdlim_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdlim_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdseman_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdseman_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdseman_Z");
      gxTv_SdtEmpresabase_calculo_Emplicdseman_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdseman_Z = (byte)(0) ;
      SetDirty("Emplicdseman_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdseman_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdmes_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmes_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdmes_Z");
      gxTv_SdtEmpresabase_calculo_Emplicdmes_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmes_Z = (byte)(0) ;
      SetDirty("Emplicdmes_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdmes_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdsemes_Z");
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z = (short)(0) ;
      SetDirty("Emplicdsemes_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Emplicdanual_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdanual_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdanual_Z");
      gxTv_SdtEmpresabase_calculo_Emplicdanual_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdanual_Z = (short)(0) ;
      SetDirty("Emplicdanual_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdanual_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadju_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadju_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadju_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicadju_Z");
      gxTv_SdtEmpresabase_calculo_Emplicadju_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadju_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadju_Z = false ;
      SetDirty("Emplicadju_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadju_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicadjuobl_Z");
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z = false ;
      SetDirty("Emplicadjuobl_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicnecaut_Z");
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z = false ;
      SetDirty("Emplicnecaut_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicingmot_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicingmot_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicingmot_Z");
      gxTv_SdtEmpresabase_calculo_Emplicingmot_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicingmot_Z = false ;
      SetDirty("Emplicingmot_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicingmot_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z( boolean value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicmotobl_Z");
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z = false ;
      SetDirty("Emplicmotobl_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empbaseord_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseord_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseord_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaseord_Z");
      gxTv_SdtEmpresabase_calculo_Empbaseord_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseord_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseord_Z = (short)(0) ;
      SetDirty("Empbaseord_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbaseord_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasepromcnt1_Z");
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z = (short)(0) ;
      SetDirty("Empbasepromcnt1_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z( short value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasepromcnt2_Z");
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z = (short)(0) ;
      SetDirty("Empbasepromcnt2_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z( String value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbasepromtcnt_Z");
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z = "" ;
      SetDirty("Empbasepromtcnt_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z( int value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaserelsec_Z");
      gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z = 0 ;
      SetDirty("Empbaserelsec_Z");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdmin_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmin_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmin_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdmin_N");
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmin_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmin_N = (byte)(0) ;
      SetDirty("Emplicdmin_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdmin_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdlim_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdlim_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdlim_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdlim_N");
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdlim_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdlim_N = (byte)(0) ;
      SetDirty("Emplicdlim_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdlim_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdseman_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdseman_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdseman_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdseman_N");
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdseman_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdseman_N = (byte)(0) ;
      SetDirty("Emplicdseman_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdseman_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdmes_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdmes_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmes_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdmes_N");
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdmes_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdmes_N = (byte)(0) ;
      SetDirty("Emplicdmes_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdmes_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdsemes_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdsemes_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdsemes_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdsemes_N");
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdsemes_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdsemes_N = (byte)(0) ;
      SetDirty("Emplicdsemes_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdsemes_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicdanual_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicdanual_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdanual_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicdanual_N");
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicdanual_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicdanual_N = (byte)(0) ;
      SetDirty("Emplicdanual_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicdanual_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicadju_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadju_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadju_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicadju_N");
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadju_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadju_N = (byte)(0) ;
      SetDirty("Emplicadju_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadju_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicadjuobl_N");
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N = (byte)(0) ;
      SetDirty("Emplicadjuobl_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicnecaut_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicnecaut_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicnecaut_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicnecaut_N");
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicnecaut_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicnecaut_N = (byte)(0) ;
      SetDirty("Emplicnecaut_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicnecaut_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicingmot_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicingmot_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicingmot_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicingmot_N");
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicingmot_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicingmot_N = (byte)(0) ;
      SetDirty("Emplicingmot_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicingmot_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Emplicmotobl_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Emplicmotobl_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicmotobl_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Emplicmotobl_N");
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Emplicmotobl_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Emplicmotobl_N = (byte)(0) ;
      SetDirty("Emplicmotobl_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Emplicmotobl_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresabase_calculo_Empbaseord_N( )
   {
      return gxTv_SdtEmpresabase_calculo_Empbaseord_N ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseord_N( byte value )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(0) ;
      SetDirty("Empbaseord_N");
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = value ;
   }

   public void setgxTv_SdtEmpresabase_calculo_Empbaseord_N_SetNull( )
   {
      gxTv_SdtEmpresabase_calculo_Empbaseord_N = (byte)(0) ;
      SetDirty("Empbaseord_N");
   }

   public boolean getgxTv_SdtEmpresabase_calculo_Empbaseord_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.empresabase_calculo_bc obj;
      obj = new web.empresabase_calculo_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEmpresabase_calculo_N = (byte)(1) ;
      gxTv_SdtEmpresabase_calculo_Empbasetipo = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod1 = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec1txt = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod2 = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec2txt = "" ;
      gxTv_SdtEmpresabase_calculo_Empbaseplus = DecimalUtil.ZERO ;
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt = "" ;
      gxTv_SdtEmpresabase_calculo_Mode = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasetipo_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod1_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasecod2_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z = "" ;
      gxTv_SdtEmpresabase_calculo_Empbaseplus_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresabase_calculo_N ;
   }

   public web.SdtEmpresabase_calculo Clone( )
   {
      web.SdtEmpresabase_calculo sdt;
      web.empresabase_calculo_bc obj;
      sdt = (web.SdtEmpresabase_calculo)(clone()) ;
      obj = (web.empresabase_calculo_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtEmpresabase_calculo struct )
   {
      setgxTv_SdtEmpresabase_calculo_Clicod(struct.getClicod());
      setgxTv_SdtEmpresabase_calculo_Empcod(struct.getEmpcod());
      setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg(struct.getEmpbaseclaseleg());
      setgxTv_SdtEmpresabase_calculo_Empbasetipo(struct.getEmpbasetipo());
      setgxTv_SdtEmpresabase_calculo_Empbasecod1(struct.getEmpbasecod1());
      setgxTv_SdtEmpresabase_calculo_Empbasec1txt(struct.getEmpbasec1txt());
      setgxTv_SdtEmpresabase_calculo_Empbasecod2(struct.getEmpbasecod2());
      setgxTv_SdtEmpresabase_calculo_Empbasec2txt(struct.getEmpbasec2txt());
      setgxTv_SdtEmpresabase_calculo_Empbaseplus(struct.getEmpbaseplus());
      setgxTv_SdtEmpresabase_calculo_Emplicdmin(struct.getEmplicdmin());
      setgxTv_SdtEmpresabase_calculo_Emplicdlim(struct.getEmplicdlim());
      setgxTv_SdtEmpresabase_calculo_Emplicdseman(struct.getEmplicdseman());
      setgxTv_SdtEmpresabase_calculo_Emplicdmes(struct.getEmplicdmes());
      setgxTv_SdtEmpresabase_calculo_Emplicdsemes(struct.getEmplicdsemes());
      setgxTv_SdtEmpresabase_calculo_Emplicdanual(struct.getEmplicdanual());
      setgxTv_SdtEmpresabase_calculo_Emplicadju(struct.getEmplicadju());
      setgxTv_SdtEmpresabase_calculo_Emplicadjuobl(struct.getEmplicadjuobl());
      setgxTv_SdtEmpresabase_calculo_Emplicnecaut(struct.getEmplicnecaut());
      setgxTv_SdtEmpresabase_calculo_Emplicingmot(struct.getEmplicingmot());
      setgxTv_SdtEmpresabase_calculo_Emplicmotobl(struct.getEmplicmotobl());
      setgxTv_SdtEmpresabase_calculo_Empbaseord(struct.getEmpbaseord());
      setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1(struct.getEmpbasepromcnt1());
      setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2(struct.getEmpbasepromcnt2());
      setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt(struct.getEmpbasepromtcnt());
      setgxTv_SdtEmpresabase_calculo_Empbaserelsec(struct.getEmpbaserelsec());
      setgxTv_SdtEmpresabase_calculo_Mode(struct.getMode());
      setgxTv_SdtEmpresabase_calculo_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresabase_calculo_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtEmpresabase_calculo_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z(struct.getEmpbaseclaseleg_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z(struct.getEmpbasetipo_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z(struct.getEmpbasecod1_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z(struct.getEmpbasec1txt_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z(struct.getEmpbasecod2_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z(struct.getEmpbasec2txt_Z());
      setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z(struct.getEmpbaseplus_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z(struct.getEmplicdmin_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z(struct.getEmplicdlim_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z(struct.getEmplicdseman_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z(struct.getEmplicdmes_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z(struct.getEmplicdsemes_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z(struct.getEmplicdanual_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicadju_Z(struct.getEmplicadju_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z(struct.getEmplicadjuobl_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z(struct.getEmplicnecaut_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z(struct.getEmplicingmot_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z(struct.getEmplicmotobl_Z());
      setgxTv_SdtEmpresabase_calculo_Empbaseord_Z(struct.getEmpbaseord_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z(struct.getEmpbasepromcnt1_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z(struct.getEmpbasepromcnt2_Z());
      setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z(struct.getEmpbasepromtcnt_Z());
      setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z(struct.getEmpbaserelsec_Z());
      setgxTv_SdtEmpresabase_calculo_Emplicdmin_N(struct.getEmplicdmin_N());
      setgxTv_SdtEmpresabase_calculo_Emplicdlim_N(struct.getEmplicdlim_N());
      setgxTv_SdtEmpresabase_calculo_Emplicdseman_N(struct.getEmplicdseman_N());
      setgxTv_SdtEmpresabase_calculo_Emplicdmes_N(struct.getEmplicdmes_N());
      setgxTv_SdtEmpresabase_calculo_Emplicdsemes_N(struct.getEmplicdsemes_N());
      setgxTv_SdtEmpresabase_calculo_Emplicdanual_N(struct.getEmplicdanual_N());
      setgxTv_SdtEmpresabase_calculo_Emplicadju_N(struct.getEmplicadju_N());
      setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N(struct.getEmplicadjuobl_N());
      setgxTv_SdtEmpresabase_calculo_Emplicnecaut_N(struct.getEmplicnecaut_N());
      setgxTv_SdtEmpresabase_calculo_Emplicingmot_N(struct.getEmplicingmot_N());
      setgxTv_SdtEmpresabase_calculo_Emplicmotobl_N(struct.getEmplicmotobl_N());
      setgxTv_SdtEmpresabase_calculo_Empbaseord_N(struct.getEmpbaseord_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresabase_calculo getStruct( )
   {
      web.StructSdtEmpresabase_calculo struct = new web.StructSdtEmpresabase_calculo ();
      struct.setClicod(getgxTv_SdtEmpresabase_calculo_Clicod());
      struct.setEmpcod(getgxTv_SdtEmpresabase_calculo_Empcod());
      struct.setEmpbaseclaseleg(getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg());
      struct.setEmpbasetipo(getgxTv_SdtEmpresabase_calculo_Empbasetipo());
      struct.setEmpbasecod1(getgxTv_SdtEmpresabase_calculo_Empbasecod1());
      struct.setEmpbasec1txt(getgxTv_SdtEmpresabase_calculo_Empbasec1txt());
      struct.setEmpbasecod2(getgxTv_SdtEmpresabase_calculo_Empbasecod2());
      struct.setEmpbasec2txt(getgxTv_SdtEmpresabase_calculo_Empbasec2txt());
      struct.setEmpbaseplus(getgxTv_SdtEmpresabase_calculo_Empbaseplus());
      struct.setEmplicdmin(getgxTv_SdtEmpresabase_calculo_Emplicdmin());
      struct.setEmplicdlim(getgxTv_SdtEmpresabase_calculo_Emplicdlim());
      struct.setEmplicdseman(getgxTv_SdtEmpresabase_calculo_Emplicdseman());
      struct.setEmplicdmes(getgxTv_SdtEmpresabase_calculo_Emplicdmes());
      struct.setEmplicdsemes(getgxTv_SdtEmpresabase_calculo_Emplicdsemes());
      struct.setEmplicdanual(getgxTv_SdtEmpresabase_calculo_Emplicdanual());
      struct.setEmplicadju(getgxTv_SdtEmpresabase_calculo_Emplicadju());
      struct.setEmplicadjuobl(getgxTv_SdtEmpresabase_calculo_Emplicadjuobl());
      struct.setEmplicnecaut(getgxTv_SdtEmpresabase_calculo_Emplicnecaut());
      struct.setEmplicingmot(getgxTv_SdtEmpresabase_calculo_Emplicingmot());
      struct.setEmplicmotobl(getgxTv_SdtEmpresabase_calculo_Emplicmotobl());
      struct.setEmpbaseord(getgxTv_SdtEmpresabase_calculo_Empbaseord());
      struct.setEmpbasepromcnt1(getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1());
      struct.setEmpbasepromcnt2(getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2());
      struct.setEmpbasepromtcnt(getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt());
      struct.setEmpbaserelsec(getgxTv_SdtEmpresabase_calculo_Empbaserelsec());
      struct.setMode(getgxTv_SdtEmpresabase_calculo_Mode());
      struct.setInitialized(getgxTv_SdtEmpresabase_calculo_Initialized());
      struct.setClicod_Z(getgxTv_SdtEmpresabase_calculo_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtEmpresabase_calculo_Empcod_Z());
      struct.setEmpbaseclaseleg_Z(getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z());
      struct.setEmpbasetipo_Z(getgxTv_SdtEmpresabase_calculo_Empbasetipo_Z());
      struct.setEmpbasecod1_Z(getgxTv_SdtEmpresabase_calculo_Empbasecod1_Z());
      struct.setEmpbasec1txt_Z(getgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z());
      struct.setEmpbasecod2_Z(getgxTv_SdtEmpresabase_calculo_Empbasecod2_Z());
      struct.setEmpbasec2txt_Z(getgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z());
      struct.setEmpbaseplus_Z(getgxTv_SdtEmpresabase_calculo_Empbaseplus_Z());
      struct.setEmplicdmin_Z(getgxTv_SdtEmpresabase_calculo_Emplicdmin_Z());
      struct.setEmplicdlim_Z(getgxTv_SdtEmpresabase_calculo_Emplicdlim_Z());
      struct.setEmplicdseman_Z(getgxTv_SdtEmpresabase_calculo_Emplicdseman_Z());
      struct.setEmplicdmes_Z(getgxTv_SdtEmpresabase_calculo_Emplicdmes_Z());
      struct.setEmplicdsemes_Z(getgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z());
      struct.setEmplicdanual_Z(getgxTv_SdtEmpresabase_calculo_Emplicdanual_Z());
      struct.setEmplicadju_Z(getgxTv_SdtEmpresabase_calculo_Emplicadju_Z());
      struct.setEmplicadjuobl_Z(getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z());
      struct.setEmplicnecaut_Z(getgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z());
      struct.setEmplicingmot_Z(getgxTv_SdtEmpresabase_calculo_Emplicingmot_Z());
      struct.setEmplicmotobl_Z(getgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z());
      struct.setEmpbaseord_Z(getgxTv_SdtEmpresabase_calculo_Empbaseord_Z());
      struct.setEmpbasepromcnt1_Z(getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z());
      struct.setEmpbasepromcnt2_Z(getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z());
      struct.setEmpbasepromtcnt_Z(getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z());
      struct.setEmpbaserelsec_Z(getgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z());
      struct.setEmplicdmin_N(getgxTv_SdtEmpresabase_calculo_Emplicdmin_N());
      struct.setEmplicdlim_N(getgxTv_SdtEmpresabase_calculo_Emplicdlim_N());
      struct.setEmplicdseman_N(getgxTv_SdtEmpresabase_calculo_Emplicdseman_N());
      struct.setEmplicdmes_N(getgxTv_SdtEmpresabase_calculo_Emplicdmes_N());
      struct.setEmplicdsemes_N(getgxTv_SdtEmpresabase_calculo_Emplicdsemes_N());
      struct.setEmplicdanual_N(getgxTv_SdtEmpresabase_calculo_Emplicdanual_N());
      struct.setEmplicadju_N(getgxTv_SdtEmpresabase_calculo_Emplicadju_N());
      struct.setEmplicadjuobl_N(getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N());
      struct.setEmplicnecaut_N(getgxTv_SdtEmpresabase_calculo_Emplicnecaut_N());
      struct.setEmplicingmot_N(getgxTv_SdtEmpresabase_calculo_Emplicingmot_N());
      struct.setEmplicmotobl_N(getgxTv_SdtEmpresabase_calculo_Emplicmotobl_N());
      struct.setEmpbaseord_N(getgxTv_SdtEmpresabase_calculo_Empbaseord_N());
      return struct ;
   }

   private byte gxTv_SdtEmpresabase_calculo_N ;
   private byte gxTv_SdtEmpresabase_calculo_Empbaseclaseleg ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdmin ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdseman ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdmes ;
   private byte gxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdmin_Z ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdseman_Z ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdmes_Z ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdmin_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdlim_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdseman_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdmes_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdsemes_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicdanual_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicadju_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicadjuobl_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicnecaut_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicingmot_N ;
   private byte gxTv_SdtEmpresabase_calculo_Emplicmotobl_N ;
   private byte gxTv_SdtEmpresabase_calculo_Empbaseord_N ;
   private short gxTv_SdtEmpresabase_calculo_Empcod ;
   private short gxTv_SdtEmpresabase_calculo_Emplicdlim ;
   private short gxTv_SdtEmpresabase_calculo_Emplicdsemes ;
   private short gxTv_SdtEmpresabase_calculo_Emplicdanual ;
   private short gxTv_SdtEmpresabase_calculo_Empbaseord ;
   private short gxTv_SdtEmpresabase_calculo_Empbasepromcnt1 ;
   private short gxTv_SdtEmpresabase_calculo_Empbasepromcnt2 ;
   private short gxTv_SdtEmpresabase_calculo_Initialized ;
   private short gxTv_SdtEmpresabase_calculo_Empcod_Z ;
   private short gxTv_SdtEmpresabase_calculo_Emplicdlim_Z ;
   private short gxTv_SdtEmpresabase_calculo_Emplicdsemes_Z ;
   private short gxTv_SdtEmpresabase_calculo_Emplicdanual_Z ;
   private short gxTv_SdtEmpresabase_calculo_Empbaseord_Z ;
   private short gxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z ;
   private short gxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEmpresabase_calculo_Clicod ;
   private int gxTv_SdtEmpresabase_calculo_Empbaserelsec ;
   private int gxTv_SdtEmpresabase_calculo_Clicod_Z ;
   private int gxTv_SdtEmpresabase_calculo_Empbaserelsec_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresabase_calculo_Empbaseplus ;
   private java.math.BigDecimal gxTv_SdtEmpresabase_calculo_Empbaseplus_Z ;
   private String gxTv_SdtEmpresabase_calculo_Empbasetipo ;
   private String gxTv_SdtEmpresabase_calculo_Empbasecod1 ;
   private String gxTv_SdtEmpresabase_calculo_Empbasecod2 ;
   private String gxTv_SdtEmpresabase_calculo_Empbasepromtcnt ;
   private String gxTv_SdtEmpresabase_calculo_Mode ;
   private String gxTv_SdtEmpresabase_calculo_Empbasetipo_Z ;
   private String gxTv_SdtEmpresabase_calculo_Empbasecod1_Z ;
   private String gxTv_SdtEmpresabase_calculo_Empbasecod2_Z ;
   private String gxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicadju ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicadjuobl ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicnecaut ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicingmot ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicmotobl ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicadju_Z ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicnecaut_Z ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicingmot_Z ;
   private boolean gxTv_SdtEmpresabase_calculo_Emplicmotobl_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEmpresabase_calculo_Empbasec1txt ;
   private String gxTv_SdtEmpresabase_calculo_Empbasec2txt ;
   private String gxTv_SdtEmpresabase_calculo_Empbasec1txt_Z ;
   private String gxTv_SdtEmpresabase_calculo_Empbasec2txt_Z ;
}

