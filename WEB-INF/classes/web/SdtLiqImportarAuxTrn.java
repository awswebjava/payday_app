package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLiqImportarAuxTrn extends GxSilentTrnSdt
{
   public SdtLiqImportarAuxTrn( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLiqImportarAuxTrn.class));
   }

   public SdtLiqImportarAuxTrn( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtLiqImportarAuxTrn");
      initialize( remoteHandle) ;
   }

   public SdtLiqImportarAuxTrn( int remoteHandle ,
                                StructSdtLiqImportarAuxTrn struct )
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
      metadata.set("Name", "LiqImportarAuxTrn");
      metadata.set("BT", "Empresa");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\" ]");
      metadata.set("PKAssigned", "[ \"EmpCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"ActCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\",\"LocCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipEmpleCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ZonCod\" ],\"FKMap\":[ \"EmpZonCod-ZonCod\" ] } ]");
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
               gxTv_SdtLiqImportarAuxTrn_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCUIT") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcuit = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatIvaCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Cativacod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatIvaDesc") )
            {
               gxTv_SdtLiqImportarAuxTrn_Cativadesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDir") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empdir = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTel") )
            {
               gxTv_SdtLiqImportarAuxTrn_Emptel = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCP") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Paicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom") )
            {
               gxTv_SdtLiqImportarAuxTrn_Painom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Provcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvNom") )
            {
               gxTv_SdtLiqImportarAuxTrn_Provnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Loccod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocNom") )
            {
               gxTv_SdtLiqImportarAuxTrn_Locnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo") )
            {
               gxTv_SdtLiqImportarAuxTrn_Actcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActDescrip") )
            {
               gxTv_SdtLiqImportarAuxTrn_Actdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Tipemplecod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonCod") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empzoncod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonDescrip") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empzondescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReducc") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empreducc = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleDefIns") )
            {
               gxTv_SdtLiqImportarAuxTrn_Tipempledefins = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLiqImportarAuxTrn_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLiqImportarAuxTrn_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCUIT_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcuit_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatIvaCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Cativacod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatIvaDesc_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpDir_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empdir_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTel_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Emptel_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCP_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcp_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Paicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiNom_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Painom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Provcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvNom_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Provnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Loccod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocNom_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Locnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActDescrip_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonCod_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonDescrip_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReducc_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empreducc_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleDefIns_Z") )
            {
               gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatIvaCod_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Cativacod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatIvaDesc_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTel_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Emptel_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCP_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empcp_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Paicod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ProvCod_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Provcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LocCod_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Loccod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ActCodigo_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipEmpleCod_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpZonCod_N") )
            {
               gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "LiqImportarAuxTrn" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtLiqImportarAuxTrn_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCUIT", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Empcuit, 11, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatIvaCod", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Cativacod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatIvaDesc", gxTv_SdtLiqImportarAuxTrn_Cativadesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpDir", gxTv_SdtLiqImportarAuxTrn_Empdir);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTel", gxTv_SdtLiqImportarAuxTrn_Emptel);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCP", gxTv_SdtLiqImportarAuxTrn_Empcp);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Paicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiNom", gxTv_SdtLiqImportarAuxTrn_Painom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvCod", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Provcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ProvNom", gxTv_SdtLiqImportarAuxTrn_Provnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocCod", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Loccod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LocNom", gxTv_SdtLiqImportarAuxTrn_Locnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActCodigo", gxTv_SdtLiqImportarAuxTrn_Actcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ActDescrip", gxTv_SdtLiqImportarAuxTrn_Actdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipEmpleCod", gxTv_SdtLiqImportarAuxTrn_Tipemplecod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpZonCod", gxTv_SdtLiqImportarAuxTrn_Empzoncod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpZonDescrip", gxTv_SdtLiqImportarAuxTrn_Empzondescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpReducc", GXutil.booltostr( gxTv_SdtLiqImportarAuxTrn_Empreducc));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TipEmpleDefIns", gxTv_SdtLiqImportarAuxTrn_Tipempledefins);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLiqImportarAuxTrn_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtLiqImportarAuxTrn_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCUIT_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Empcuit_Z, 11, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatIvaCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Cativacod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatIvaDesc_Z", gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpDir_Z", gxTv_SdtLiqImportarAuxTrn_Empdir_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTel_Z", gxTv_SdtLiqImportarAuxTrn_Emptel_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCP_Z", gxTv_SdtLiqImportarAuxTrn_Empcp_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Paicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiNom_Z", gxTv_SdtLiqImportarAuxTrn_Painom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Provcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvNom_Z", gxTv_SdtLiqImportarAuxTrn_Provnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LocCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Loccod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LocNom_Z", gxTv_SdtLiqImportarAuxTrn_Locnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActCodigo_Z", gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActDescrip_Z", gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleCod_Z", gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpZonCod_Z", gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpZonDescrip_Z", gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpReducc_Z", GXutil.booltostr( gxTv_SdtLiqImportarAuxTrn_Empreducc_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleDefIns_Z", gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatIvaCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Cativacod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatIvaDesc_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Cativadesc_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTel_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Emptel_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCP_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Empcp_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Paicod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ProvCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Provcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LocCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Loccod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ActCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Actcodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipEmpleCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpZonCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiqImportarAuxTrn_Empzoncod_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtLiqImportarAuxTrn_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLiqImportarAuxTrn_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtLiqImportarAuxTrn_Empnom, false, includeNonInitialized);
      AddObjectProperty("EmpCUIT", gxTv_SdtLiqImportarAuxTrn_Empcuit, false, includeNonInitialized);
      AddObjectProperty("CatIvaCod", gxTv_SdtLiqImportarAuxTrn_Cativacod, false, includeNonInitialized);
      AddObjectProperty("CatIvaCod_N", gxTv_SdtLiqImportarAuxTrn_Cativacod_N, false, includeNonInitialized);
      AddObjectProperty("CatIvaDesc", gxTv_SdtLiqImportarAuxTrn_Cativadesc, false, includeNonInitialized);
      AddObjectProperty("CatIvaDesc_N", gxTv_SdtLiqImportarAuxTrn_Cativadesc_N, false, includeNonInitialized);
      AddObjectProperty("EmpDir", gxTv_SdtLiqImportarAuxTrn_Empdir, false, includeNonInitialized);
      AddObjectProperty("EmpTel", gxTv_SdtLiqImportarAuxTrn_Emptel, false, includeNonInitialized);
      AddObjectProperty("EmpTel_N", gxTv_SdtLiqImportarAuxTrn_Emptel_N, false, includeNonInitialized);
      AddObjectProperty("EmpCP", gxTv_SdtLiqImportarAuxTrn_Empcp, false, includeNonInitialized);
      AddObjectProperty("EmpCP_N", gxTv_SdtLiqImportarAuxTrn_Empcp_N, false, includeNonInitialized);
      AddObjectProperty("PaiCod", gxTv_SdtLiqImportarAuxTrn_Paicod, false, includeNonInitialized);
      AddObjectProperty("PaiCod_N", gxTv_SdtLiqImportarAuxTrn_Paicod_N, false, includeNonInitialized);
      AddObjectProperty("PaiNom", gxTv_SdtLiqImportarAuxTrn_Painom, false, includeNonInitialized);
      AddObjectProperty("ProvCod", gxTv_SdtLiqImportarAuxTrn_Provcod, false, includeNonInitialized);
      AddObjectProperty("ProvCod_N", gxTv_SdtLiqImportarAuxTrn_Provcod_N, false, includeNonInitialized);
      AddObjectProperty("ProvNom", gxTv_SdtLiqImportarAuxTrn_Provnom, false, includeNonInitialized);
      AddObjectProperty("LocCod", gxTv_SdtLiqImportarAuxTrn_Loccod, false, includeNonInitialized);
      AddObjectProperty("LocCod_N", gxTv_SdtLiqImportarAuxTrn_Loccod_N, false, includeNonInitialized);
      AddObjectProperty("LocNom", gxTv_SdtLiqImportarAuxTrn_Locnom, false, includeNonInitialized);
      AddObjectProperty("ActCodigo", gxTv_SdtLiqImportarAuxTrn_Actcodigo, false, includeNonInitialized);
      AddObjectProperty("ActCodigo_N", gxTv_SdtLiqImportarAuxTrn_Actcodigo_N, false, includeNonInitialized);
      AddObjectProperty("ActDescrip", gxTv_SdtLiqImportarAuxTrn_Actdescrip, false, includeNonInitialized);
      AddObjectProperty("TipEmpleCod", gxTv_SdtLiqImportarAuxTrn_Tipemplecod, false, includeNonInitialized);
      AddObjectProperty("TipEmpleCod_N", gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N, false, includeNonInitialized);
      AddObjectProperty("EmpZonCod", gxTv_SdtLiqImportarAuxTrn_Empzoncod, false, includeNonInitialized);
      AddObjectProperty("EmpZonCod_N", gxTv_SdtLiqImportarAuxTrn_Empzoncod_N, false, includeNonInitialized);
      AddObjectProperty("EmpZonDescrip", gxTv_SdtLiqImportarAuxTrn_Empzondescrip, false, includeNonInitialized);
      AddObjectProperty("EmpReducc", gxTv_SdtLiqImportarAuxTrn_Empreducc, false, includeNonInitialized);
      AddObjectProperty("TipEmpleDefIns", gxTv_SdtLiqImportarAuxTrn_Tipempledefins, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLiqImportarAuxTrn_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLiqImportarAuxTrn_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLiqImportarAuxTrn_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLiqImportarAuxTrn_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtLiqImportarAuxTrn_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCUIT_Z", gxTv_SdtLiqImportarAuxTrn_Empcuit_Z, false, includeNonInitialized);
         AddObjectProperty("CatIvaCod_Z", gxTv_SdtLiqImportarAuxTrn_Cativacod_Z, false, includeNonInitialized);
         AddObjectProperty("CatIvaDesc_Z", gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z, false, includeNonInitialized);
         AddObjectProperty("EmpDir_Z", gxTv_SdtLiqImportarAuxTrn_Empdir_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTel_Z", gxTv_SdtLiqImportarAuxTrn_Emptel_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCP_Z", gxTv_SdtLiqImportarAuxTrn_Empcp_Z, false, includeNonInitialized);
         AddObjectProperty("PaiCod_Z", gxTv_SdtLiqImportarAuxTrn_Paicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiNom_Z", gxTv_SdtLiqImportarAuxTrn_Painom_Z, false, includeNonInitialized);
         AddObjectProperty("ProvCod_Z", gxTv_SdtLiqImportarAuxTrn_Provcod_Z, false, includeNonInitialized);
         AddObjectProperty("ProvNom_Z", gxTv_SdtLiqImportarAuxTrn_Provnom_Z, false, includeNonInitialized);
         AddObjectProperty("LocCod_Z", gxTv_SdtLiqImportarAuxTrn_Loccod_Z, false, includeNonInitialized);
         AddObjectProperty("LocNom_Z", gxTv_SdtLiqImportarAuxTrn_Locnom_Z, false, includeNonInitialized);
         AddObjectProperty("ActCodigo_Z", gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ActDescrip_Z", gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("TipEmpleCod_Z", gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpZonCod_Z", gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpZonDescrip_Z", gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z, false, includeNonInitialized);
         AddObjectProperty("EmpReducc_Z", gxTv_SdtLiqImportarAuxTrn_Empreducc_Z, false, includeNonInitialized);
         AddObjectProperty("TipEmpleDefIns_Z", gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z, false, includeNonInitialized);
         AddObjectProperty("CatIvaCod_N", gxTv_SdtLiqImportarAuxTrn_Cativacod_N, false, includeNonInitialized);
         AddObjectProperty("CatIvaDesc_N", gxTv_SdtLiqImportarAuxTrn_Cativadesc_N, false, includeNonInitialized);
         AddObjectProperty("EmpTel_N", gxTv_SdtLiqImportarAuxTrn_Emptel_N, false, includeNonInitialized);
         AddObjectProperty("EmpCP_N", gxTv_SdtLiqImportarAuxTrn_Empcp_N, false, includeNonInitialized);
         AddObjectProperty("PaiCod_N", gxTv_SdtLiqImportarAuxTrn_Paicod_N, false, includeNonInitialized);
         AddObjectProperty("ProvCod_N", gxTv_SdtLiqImportarAuxTrn_Provcod_N, false, includeNonInitialized);
         AddObjectProperty("LocCod_N", gxTv_SdtLiqImportarAuxTrn_Loccod_N, false, includeNonInitialized);
         AddObjectProperty("ActCodigo_N", gxTv_SdtLiqImportarAuxTrn_Actcodigo_N, false, includeNonInitialized);
         AddObjectProperty("TipEmpleCod_N", gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N, false, includeNonInitialized);
         AddObjectProperty("EmpZonCod_N", gxTv_SdtLiqImportarAuxTrn_Empzoncod_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLiqImportarAuxTrn sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Clicod = sdt.getgxTv_SdtLiqImportarAuxTrn_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empcod = sdt.getgxTv_SdtLiqImportarAuxTrn_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empnom = sdt.getgxTv_SdtLiqImportarAuxTrn_Empnom() ;
      }
      if ( sdt.IsDirty("EmpCUIT") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empcuit = sdt.getgxTv_SdtLiqImportarAuxTrn_Empcuit() ;
      }
      if ( sdt.IsDirty("CatIvaCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_Cativacod_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Cativacod_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Cativacod = sdt.getgxTv_SdtLiqImportarAuxTrn_Cativacod() ;
      }
      if ( sdt.IsDirty("CatIvaDesc") )
      {
         gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Cativadesc_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Cativadesc = sdt.getgxTv_SdtLiqImportarAuxTrn_Cativadesc() ;
      }
      if ( sdt.IsDirty("EmpDir") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empdir = sdt.getgxTv_SdtLiqImportarAuxTrn_Empdir() ;
      }
      if ( sdt.IsDirty("EmpTel") )
      {
         gxTv_SdtLiqImportarAuxTrn_Emptel_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Emptel_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Emptel = sdt.getgxTv_SdtLiqImportarAuxTrn_Emptel() ;
      }
      if ( sdt.IsDirty("EmpCP") )
      {
         gxTv_SdtLiqImportarAuxTrn_Empcp_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Empcp_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empcp = sdt.getgxTv_SdtLiqImportarAuxTrn_Empcp() ;
      }
      if ( sdt.IsDirty("PaiCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_Paicod_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Paicod_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Paicod = sdt.getgxTv_SdtLiqImportarAuxTrn_Paicod() ;
      }
      if ( sdt.IsDirty("PaiNom") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Painom = sdt.getgxTv_SdtLiqImportarAuxTrn_Painom() ;
      }
      if ( sdt.IsDirty("ProvCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_Provcod_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Provcod_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Provcod = sdt.getgxTv_SdtLiqImportarAuxTrn_Provcod() ;
      }
      if ( sdt.IsDirty("ProvNom") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Provnom = sdt.getgxTv_SdtLiqImportarAuxTrn_Provnom() ;
      }
      if ( sdt.IsDirty("LocCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_Loccod_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Loccod_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Loccod = sdt.getgxTv_SdtLiqImportarAuxTrn_Loccod() ;
      }
      if ( sdt.IsDirty("LocNom") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Locnom = sdt.getgxTv_SdtLiqImportarAuxTrn_Locnom() ;
      }
      if ( sdt.IsDirty("ActCodigo") )
      {
         gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Actcodigo_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Actcodigo = sdt.getgxTv_SdtLiqImportarAuxTrn_Actcodigo() ;
      }
      if ( sdt.IsDirty("ActDescrip") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Actdescrip = sdt.getgxTv_SdtLiqImportarAuxTrn_Actdescrip() ;
      }
      if ( sdt.IsDirty("TipEmpleCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Tipemplecod = sdt.getgxTv_SdtLiqImportarAuxTrn_Tipemplecod() ;
      }
      if ( sdt.IsDirty("EmpZonCod") )
      {
         gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = sdt.getgxTv_SdtLiqImportarAuxTrn_Empzoncod_N() ;
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empzoncod = sdt.getgxTv_SdtLiqImportarAuxTrn_Empzoncod() ;
      }
      if ( sdt.IsDirty("EmpZonDescrip") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empzondescrip = sdt.getgxTv_SdtLiqImportarAuxTrn_Empzondescrip() ;
      }
      if ( sdt.IsDirty("EmpReducc") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Empreducc = sdt.getgxTv_SdtLiqImportarAuxTrn_Empreducc() ;
      }
      if ( sdt.IsDirty("TipEmpleDefIns") )
      {
         gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
         gxTv_SdtLiqImportarAuxTrn_Tipempledefins = sdt.getgxTv_SdtLiqImportarAuxTrn_Tipempledefins() ;
      }
   }

   public int getgxTv_SdtLiqImportarAuxTrn_Clicod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Clicod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Clicod( int value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      if ( gxTv_SdtLiqImportarAuxTrn_Clicod != value )
      {
         gxTv_SdtLiqImportarAuxTrn_Mode = "INS" ;
         this.setgxTv_SdtLiqImportarAuxTrn_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empcuit_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Cativacod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empdir_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Emptel_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empcp_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Paicod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Painom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Provcod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Provnom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Loccod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Locnom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empreducc_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtLiqImportarAuxTrn_Clicod = value ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Empcod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      if ( gxTv_SdtLiqImportarAuxTrn_Empcod != value )
      {
         gxTv_SdtLiqImportarAuxTrn_Mode = "INS" ;
         this.setgxTv_SdtLiqImportarAuxTrn_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empcuit_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Cativacod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empdir_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Emptel_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empcp_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Paicod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Painom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Provcod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Provnom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Loccod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Locnom_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Empreducc_Z_SetNull( );
         this.setgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtLiqImportarAuxTrn_Empcod = value ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empnom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empnom ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empnom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtLiqImportarAuxTrn_Empnom = value ;
   }

   public long getgxTv_SdtLiqImportarAuxTrn_Empcuit( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcuit ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcuit( long value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empcuit");
      gxTv_SdtLiqImportarAuxTrn_Empcuit = value ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Cativacod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativacod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativacod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Cativacod");
      gxTv_SdtLiqImportarAuxTrn_Cativacod = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativacod_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Cativacod = (short)(0) ;
      SetDirty("Cativacod");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Cativacod_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Cativacod_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Cativadesc( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativadesc ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativadesc( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Cativadesc");
      gxTv_SdtLiqImportarAuxTrn_Cativadesc = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativadesc_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc = "" ;
      SetDirty("Cativadesc");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Cativadesc_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Cativadesc_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empdir( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empdir ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empdir( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empdir");
      gxTv_SdtLiqImportarAuxTrn_Empdir = value ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Emptel( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Emptel ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Emptel( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Emptel");
      gxTv_SdtLiqImportarAuxTrn_Emptel = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Emptel_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Emptel = "" ;
      SetDirty("Emptel");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Emptel_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Emptel_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empcp( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcp ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcp( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empcp");
      gxTv_SdtLiqImportarAuxTrn_Empcp = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcp_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Empcp = "" ;
      SetDirty("Empcp");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empcp_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Empcp_N==1) ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Paicod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Paicod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Paicod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Paicod");
      gxTv_SdtLiqImportarAuxTrn_Paicod = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Paicod_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Paicod = (short)(0) ;
      SetDirty("Paicod");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Paicod_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Paicod_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Painom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Painom ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Painom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Painom");
      gxTv_SdtLiqImportarAuxTrn_Painom = value ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Provcod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provcod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provcod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Provcod");
      gxTv_SdtLiqImportarAuxTrn_Provcod = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provcod_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Provcod = (short)(0) ;
      SetDirty("Provcod");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Provcod_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Provcod_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Provnom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provnom ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provnom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Provnom");
      gxTv_SdtLiqImportarAuxTrn_Provnom = value ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Loccod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Loccod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Loccod( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Loccod");
      gxTv_SdtLiqImportarAuxTrn_Loccod = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Loccod_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Loccod = (short)(0) ;
      SetDirty("Loccod");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Loccod_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Loccod_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Locnom( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Locnom ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Locnom( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Locnom");
      gxTv_SdtLiqImportarAuxTrn_Locnom = value ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Actcodigo( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actcodigo ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actcodigo( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Actcodigo");
      gxTv_SdtLiqImportarAuxTrn_Actcodigo = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actcodigo_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo = "" ;
      SetDirty("Actcodigo");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Actcodigo_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Actcodigo_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Actdescrip( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actdescrip ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actdescrip( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Actdescrip");
      gxTv_SdtLiqImportarAuxTrn_Actdescrip = value ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Tipemplecod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipemplecod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipemplecod( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Tipemplecod");
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod = "" ;
      SetDirty("Tipemplecod");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empzoncod( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzoncod ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzoncod( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = (byte)(0) ;
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empzoncod");
      gxTv_SdtLiqImportarAuxTrn_Empzoncod = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzoncod_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod = "" ;
      SetDirty("Empzoncod");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empzoncod_IsNull( )
   {
      return (gxTv_SdtLiqImportarAuxTrn_Empzoncod_N==1) ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empzondescrip( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzondescrip ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzondescrip( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empzondescrip");
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip = value ;
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empreducc( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empreducc ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empreducc( boolean value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empreducc");
      gxTv_SdtLiqImportarAuxTrn_Empreducc = value ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Tipempledefins( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipempledefins ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipempledefins( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Tipempledefins");
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins = value ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Mode( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Mode ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Mode( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLiqImportarAuxTrn_Mode = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Mode_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Initialized( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Initialized ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Initialized( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLiqImportarAuxTrn_Initialized = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Initialized_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiqImportarAuxTrn_Clicod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Clicod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Clicod_Z( int value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLiqImportarAuxTrn_Clicod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Clicod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Empcod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLiqImportarAuxTrn_Empcod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empnom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empnom_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empnom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtLiqImportarAuxTrn_Empnom_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empnom_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtLiqImportarAuxTrn_Empcuit_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcuit_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcuit_Z( long value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empcuit_Z");
      gxTv_SdtLiqImportarAuxTrn_Empcuit_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcuit_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcuit_Z = 0 ;
      SetDirty("Empcuit_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empcuit_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Cativacod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativacod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativacod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Cativacod_Z");
      gxTv_SdtLiqImportarAuxTrn_Cativacod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativacod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativacod_Z = (short)(0) ;
      SetDirty("Cativacod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Cativacod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Cativadesc_Z");
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z = "" ;
      SetDirty("Cativadesc_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empdir_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empdir_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empdir_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empdir_Z");
      gxTv_SdtLiqImportarAuxTrn_Empdir_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empdir_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empdir_Z = "" ;
      SetDirty("Empdir_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empdir_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Emptel_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Emptel_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Emptel_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Emptel_Z");
      gxTv_SdtLiqImportarAuxTrn_Emptel_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Emptel_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Emptel_Z = "" ;
      SetDirty("Emptel_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Emptel_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empcp_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcp_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcp_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empcp_Z");
      gxTv_SdtLiqImportarAuxTrn_Empcp_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcp_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcp_Z = "" ;
      SetDirty("Empcp_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empcp_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Paicod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Paicod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Paicod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Paicod_Z");
      gxTv_SdtLiqImportarAuxTrn_Paicod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Paicod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Paicod_Z = (short)(0) ;
      SetDirty("Paicod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Paicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Painom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Painom_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Painom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Painom_Z");
      gxTv_SdtLiqImportarAuxTrn_Painom_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Painom_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Painom_Z = "" ;
      SetDirty("Painom_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Painom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Provcod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provcod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provcod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Provcod_Z");
      gxTv_SdtLiqImportarAuxTrn_Provcod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provcod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Provcod_Z = (short)(0) ;
      SetDirty("Provcod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Provcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Provnom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provnom_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provnom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Provnom_Z");
      gxTv_SdtLiqImportarAuxTrn_Provnom_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provnom_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Provnom_Z = "" ;
      SetDirty("Provnom_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Provnom_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiqImportarAuxTrn_Loccod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Loccod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Loccod_Z( short value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Loccod_Z");
      gxTv_SdtLiqImportarAuxTrn_Loccod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Loccod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Loccod_Z = (short)(0) ;
      SetDirty("Loccod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Loccod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Locnom_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Locnom_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Locnom_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Locnom_Z");
      gxTv_SdtLiqImportarAuxTrn_Locnom_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Locnom_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Locnom_Z = "" ;
      SetDirty("Locnom_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Locnom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Actcodigo_Z");
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z = "" ;
      SetDirty("Actcodigo_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Actdescrip_Z");
      gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z = "" ;
      SetDirty("Actdescrip_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Tipemplecod_Z");
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z = "" ;
      SetDirty("Tipemplecod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empzoncod_Z");
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z = "" ;
      SetDirty("Empzoncod_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empzondescrip_Z");
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z = "" ;
      SetDirty("Empzondescrip_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empreducc_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empreducc_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empreducc_Z( boolean value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empreducc_Z");
      gxTv_SdtLiqImportarAuxTrn_Empreducc_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empreducc_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empreducc_Z = false ;
      SetDirty("Empreducc_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empreducc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z( String value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Tipempledefins_Z");
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z = "" ;
      SetDirty("Tipempledefins_Z");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Cativacod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativacod_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativacod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Cativacod_N");
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativacod_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativacod_N = (byte)(0) ;
      SetDirty("Cativacod_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Cativacod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Cativadesc_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Cativadesc_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativadesc_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Cativadesc_N");
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Cativadesc_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_N = (byte)(0) ;
      SetDirty("Cativadesc_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Cativadesc_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Emptel_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Emptel_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Emptel_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Emptel_N");
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Emptel_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Emptel_N = (byte)(0) ;
      SetDirty("Emptel_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Emptel_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Empcp_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empcp_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcp_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empcp_N");
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empcp_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empcp_N = (byte)(0) ;
      SetDirty("Empcp_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empcp_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Paicod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Paicod_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Paicod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Paicod_N");
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Paicod_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Paicod_N = (byte)(0) ;
      SetDirty("Paicod_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Paicod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Provcod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Provcod_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provcod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Provcod_N");
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Provcod_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Provcod_N = (byte)(0) ;
      SetDirty("Provcod_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Provcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Loccod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Loccod_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Loccod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Loccod_N");
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Loccod_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Loccod_N = (byte)(0) ;
      SetDirty("Loccod_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Loccod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Actcodigo_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Actcodigo_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actcodigo_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Actcodigo_N");
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Actcodigo_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_N = (byte)(0) ;
      SetDirty("Actcodigo_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Actcodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Tipemplecod_N");
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N = (byte)(0) ;
      SetDirty("Tipemplecod_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiqImportarAuxTrn_Empzoncod_N( )
   {
      return gxTv_SdtLiqImportarAuxTrn_Empzoncod_N ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzoncod_N( byte value )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(0) ;
      SetDirty("Empzoncod_N");
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = value ;
   }

   public void setgxTv_SdtLiqImportarAuxTrn_Empzoncod_N_SetNull( )
   {
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_N = (byte)(0) ;
      SetDirty("Empzoncod_N");
   }

   public boolean getgxTv_SdtLiqImportarAuxTrn_Empzoncod_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.liqimportarauxtrn_bc obj;
      obj = new web.liqimportarauxtrn_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLiqImportarAuxTrn_N = (byte)(1) ;
      gxTv_SdtLiqImportarAuxTrn_Empnom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empdir = "" ;
      gxTv_SdtLiqImportarAuxTrn_Emptel = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empcp = "" ;
      gxTv_SdtLiqImportarAuxTrn_Painom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Provnom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Locnom = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actdescrip = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins = "" ;
      gxTv_SdtLiqImportarAuxTrn_Mode = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empnom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empdir_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Emptel_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empcp_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Painom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Provnom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Locnom_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z = "" ;
      gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLiqImportarAuxTrn_N ;
   }

   public web.SdtLiqImportarAuxTrn Clone( )
   {
      web.SdtLiqImportarAuxTrn sdt;
      web.liqimportarauxtrn_bc obj;
      sdt = (web.SdtLiqImportarAuxTrn)(clone()) ;
      obj = (web.liqimportarauxtrn_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLiqImportarAuxTrn struct )
   {
      setgxTv_SdtLiqImportarAuxTrn_Clicod(struct.getClicod());
      setgxTv_SdtLiqImportarAuxTrn_Empcod(struct.getEmpcod());
      setgxTv_SdtLiqImportarAuxTrn_Empnom(struct.getEmpnom());
      setgxTv_SdtLiqImportarAuxTrn_Empcuit(struct.getEmpcuit());
      setgxTv_SdtLiqImportarAuxTrn_Cativacod(struct.getCativacod());
      setgxTv_SdtLiqImportarAuxTrn_Cativadesc(struct.getCativadesc());
      setgxTv_SdtLiqImportarAuxTrn_Empdir(struct.getEmpdir());
      setgxTv_SdtLiqImportarAuxTrn_Emptel(struct.getEmptel());
      setgxTv_SdtLiqImportarAuxTrn_Empcp(struct.getEmpcp());
      setgxTv_SdtLiqImportarAuxTrn_Paicod(struct.getPaicod());
      setgxTv_SdtLiqImportarAuxTrn_Painom(struct.getPainom());
      setgxTv_SdtLiqImportarAuxTrn_Provcod(struct.getProvcod());
      setgxTv_SdtLiqImportarAuxTrn_Provnom(struct.getProvnom());
      setgxTv_SdtLiqImportarAuxTrn_Loccod(struct.getLoccod());
      setgxTv_SdtLiqImportarAuxTrn_Locnom(struct.getLocnom());
      setgxTv_SdtLiqImportarAuxTrn_Actcodigo(struct.getActcodigo());
      setgxTv_SdtLiqImportarAuxTrn_Actdescrip(struct.getActdescrip());
      setgxTv_SdtLiqImportarAuxTrn_Tipemplecod(struct.getTipemplecod());
      setgxTv_SdtLiqImportarAuxTrn_Empzoncod(struct.getEmpzoncod());
      setgxTv_SdtLiqImportarAuxTrn_Empzondescrip(struct.getEmpzondescrip());
      setgxTv_SdtLiqImportarAuxTrn_Empreducc(struct.getEmpreducc());
      setgxTv_SdtLiqImportarAuxTrn_Tipempledefins(struct.getTipempledefins());
      setgxTv_SdtLiqImportarAuxTrn_Mode(struct.getMode());
      setgxTv_SdtLiqImportarAuxTrn_Initialized(struct.getInitialized());
      setgxTv_SdtLiqImportarAuxTrn_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empcuit_Z(struct.getEmpcuit_Z());
      setgxTv_SdtLiqImportarAuxTrn_Cativacod_Z(struct.getCativacod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z(struct.getCativadesc_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empdir_Z(struct.getEmpdir_Z());
      setgxTv_SdtLiqImportarAuxTrn_Emptel_Z(struct.getEmptel_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empcp_Z(struct.getEmpcp_Z());
      setgxTv_SdtLiqImportarAuxTrn_Paicod_Z(struct.getPaicod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Painom_Z(struct.getPainom_Z());
      setgxTv_SdtLiqImportarAuxTrn_Provcod_Z(struct.getProvcod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Provnom_Z(struct.getProvnom_Z());
      setgxTv_SdtLiqImportarAuxTrn_Loccod_Z(struct.getLoccod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Locnom_Z(struct.getLocnom_Z());
      setgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z(struct.getActcodigo_Z());
      setgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z(struct.getActdescrip_Z());
      setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z(struct.getTipemplecod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z(struct.getEmpzoncod_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z(struct.getEmpzondescrip_Z());
      setgxTv_SdtLiqImportarAuxTrn_Empreducc_Z(struct.getEmpreducc_Z());
      setgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z(struct.getTipempledefins_Z());
      setgxTv_SdtLiqImportarAuxTrn_Cativacod_N(struct.getCativacod_N());
      setgxTv_SdtLiqImportarAuxTrn_Cativadesc_N(struct.getCativadesc_N());
      setgxTv_SdtLiqImportarAuxTrn_Emptel_N(struct.getEmptel_N());
      setgxTv_SdtLiqImportarAuxTrn_Empcp_N(struct.getEmpcp_N());
      setgxTv_SdtLiqImportarAuxTrn_Paicod_N(struct.getPaicod_N());
      setgxTv_SdtLiqImportarAuxTrn_Provcod_N(struct.getProvcod_N());
      setgxTv_SdtLiqImportarAuxTrn_Loccod_N(struct.getLoccod_N());
      setgxTv_SdtLiqImportarAuxTrn_Actcodigo_N(struct.getActcodigo_N());
      setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N(struct.getTipemplecod_N());
      setgxTv_SdtLiqImportarAuxTrn_Empzoncod_N(struct.getEmpzoncod_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLiqImportarAuxTrn getStruct( )
   {
      web.StructSdtLiqImportarAuxTrn struct = new web.StructSdtLiqImportarAuxTrn ();
      struct.setClicod(getgxTv_SdtLiqImportarAuxTrn_Clicod());
      struct.setEmpcod(getgxTv_SdtLiqImportarAuxTrn_Empcod());
      struct.setEmpnom(getgxTv_SdtLiqImportarAuxTrn_Empnom());
      struct.setEmpcuit(getgxTv_SdtLiqImportarAuxTrn_Empcuit());
      struct.setCativacod(getgxTv_SdtLiqImportarAuxTrn_Cativacod());
      struct.setCativadesc(getgxTv_SdtLiqImportarAuxTrn_Cativadesc());
      struct.setEmpdir(getgxTv_SdtLiqImportarAuxTrn_Empdir());
      struct.setEmptel(getgxTv_SdtLiqImportarAuxTrn_Emptel());
      struct.setEmpcp(getgxTv_SdtLiqImportarAuxTrn_Empcp());
      struct.setPaicod(getgxTv_SdtLiqImportarAuxTrn_Paicod());
      struct.setPainom(getgxTv_SdtLiqImportarAuxTrn_Painom());
      struct.setProvcod(getgxTv_SdtLiqImportarAuxTrn_Provcod());
      struct.setProvnom(getgxTv_SdtLiqImportarAuxTrn_Provnom());
      struct.setLoccod(getgxTv_SdtLiqImportarAuxTrn_Loccod());
      struct.setLocnom(getgxTv_SdtLiqImportarAuxTrn_Locnom());
      struct.setActcodigo(getgxTv_SdtLiqImportarAuxTrn_Actcodigo());
      struct.setActdescrip(getgxTv_SdtLiqImportarAuxTrn_Actdescrip());
      struct.setTipemplecod(getgxTv_SdtLiqImportarAuxTrn_Tipemplecod());
      struct.setEmpzoncod(getgxTv_SdtLiqImportarAuxTrn_Empzoncod());
      struct.setEmpzondescrip(getgxTv_SdtLiqImportarAuxTrn_Empzondescrip());
      struct.setEmpreducc(getgxTv_SdtLiqImportarAuxTrn_Empreducc());
      struct.setTipempledefins(getgxTv_SdtLiqImportarAuxTrn_Tipempledefins());
      struct.setMode(getgxTv_SdtLiqImportarAuxTrn_Mode());
      struct.setInitialized(getgxTv_SdtLiqImportarAuxTrn_Initialized());
      struct.setClicod_Z(getgxTv_SdtLiqImportarAuxTrn_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLiqImportarAuxTrn_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtLiqImportarAuxTrn_Empnom_Z());
      struct.setEmpcuit_Z(getgxTv_SdtLiqImportarAuxTrn_Empcuit_Z());
      struct.setCativacod_Z(getgxTv_SdtLiqImportarAuxTrn_Cativacod_Z());
      struct.setCativadesc_Z(getgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z());
      struct.setEmpdir_Z(getgxTv_SdtLiqImportarAuxTrn_Empdir_Z());
      struct.setEmptel_Z(getgxTv_SdtLiqImportarAuxTrn_Emptel_Z());
      struct.setEmpcp_Z(getgxTv_SdtLiqImportarAuxTrn_Empcp_Z());
      struct.setPaicod_Z(getgxTv_SdtLiqImportarAuxTrn_Paicod_Z());
      struct.setPainom_Z(getgxTv_SdtLiqImportarAuxTrn_Painom_Z());
      struct.setProvcod_Z(getgxTv_SdtLiqImportarAuxTrn_Provcod_Z());
      struct.setProvnom_Z(getgxTv_SdtLiqImportarAuxTrn_Provnom_Z());
      struct.setLoccod_Z(getgxTv_SdtLiqImportarAuxTrn_Loccod_Z());
      struct.setLocnom_Z(getgxTv_SdtLiqImportarAuxTrn_Locnom_Z());
      struct.setActcodigo_Z(getgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z());
      struct.setActdescrip_Z(getgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z());
      struct.setTipemplecod_Z(getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z());
      struct.setEmpzoncod_Z(getgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z());
      struct.setEmpzondescrip_Z(getgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z());
      struct.setEmpreducc_Z(getgxTv_SdtLiqImportarAuxTrn_Empreducc_Z());
      struct.setTipempledefins_Z(getgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z());
      struct.setCativacod_N(getgxTv_SdtLiqImportarAuxTrn_Cativacod_N());
      struct.setCativadesc_N(getgxTv_SdtLiqImportarAuxTrn_Cativadesc_N());
      struct.setEmptel_N(getgxTv_SdtLiqImportarAuxTrn_Emptel_N());
      struct.setEmpcp_N(getgxTv_SdtLiqImportarAuxTrn_Empcp_N());
      struct.setPaicod_N(getgxTv_SdtLiqImportarAuxTrn_Paicod_N());
      struct.setProvcod_N(getgxTv_SdtLiqImportarAuxTrn_Provcod_N());
      struct.setLoccod_N(getgxTv_SdtLiqImportarAuxTrn_Loccod_N());
      struct.setActcodigo_N(getgxTv_SdtLiqImportarAuxTrn_Actcodigo_N());
      struct.setTipemplecod_N(getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N());
      struct.setEmpzoncod_N(getgxTv_SdtLiqImportarAuxTrn_Empzoncod_N());
      return struct ;
   }

   private byte gxTv_SdtLiqImportarAuxTrn_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Cativacod_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Cativadesc_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Emptel_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Empcp_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Paicod_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Provcod_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Loccod_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Actcodigo_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Tipemplecod_N ;
   private byte gxTv_SdtLiqImportarAuxTrn_Empzoncod_N ;
   private short gxTv_SdtLiqImportarAuxTrn_Empcod ;
   private short gxTv_SdtLiqImportarAuxTrn_Cativacod ;
   private short gxTv_SdtLiqImportarAuxTrn_Paicod ;
   private short gxTv_SdtLiqImportarAuxTrn_Provcod ;
   private short gxTv_SdtLiqImportarAuxTrn_Loccod ;
   private short gxTv_SdtLiqImportarAuxTrn_Initialized ;
   private short gxTv_SdtLiqImportarAuxTrn_Empcod_Z ;
   private short gxTv_SdtLiqImportarAuxTrn_Cativacod_Z ;
   private short gxTv_SdtLiqImportarAuxTrn_Paicod_Z ;
   private short gxTv_SdtLiqImportarAuxTrn_Provcod_Z ;
   private short gxTv_SdtLiqImportarAuxTrn_Loccod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLiqImportarAuxTrn_Clicod ;
   private int gxTv_SdtLiqImportarAuxTrn_Clicod_Z ;
   private long gxTv_SdtLiqImportarAuxTrn_Empcuit ;
   private long gxTv_SdtLiqImportarAuxTrn_Empcuit_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Empcp ;
   private String gxTv_SdtLiqImportarAuxTrn_Actcodigo ;
   private String gxTv_SdtLiqImportarAuxTrn_Tipemplecod ;
   private String gxTv_SdtLiqImportarAuxTrn_Empzoncod ;
   private String gxTv_SdtLiqImportarAuxTrn_Tipempledefins ;
   private String gxTv_SdtLiqImportarAuxTrn_Mode ;
   private String gxTv_SdtLiqImportarAuxTrn_Empcp_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Actcodigo_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Empzoncod_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z ;
   private String sTagName ;
   private boolean gxTv_SdtLiqImportarAuxTrn_Empreducc ;
   private boolean gxTv_SdtLiqImportarAuxTrn_Empreducc_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLiqImportarAuxTrn_Empnom ;
   private String gxTv_SdtLiqImportarAuxTrn_Cativadesc ;
   private String gxTv_SdtLiqImportarAuxTrn_Empdir ;
   private String gxTv_SdtLiqImportarAuxTrn_Emptel ;
   private String gxTv_SdtLiqImportarAuxTrn_Painom ;
   private String gxTv_SdtLiqImportarAuxTrn_Provnom ;
   private String gxTv_SdtLiqImportarAuxTrn_Locnom ;
   private String gxTv_SdtLiqImportarAuxTrn_Actdescrip ;
   private String gxTv_SdtLiqImportarAuxTrn_Empzondescrip ;
   private String gxTv_SdtLiqImportarAuxTrn_Empnom_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Cativadesc_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Empdir_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Emptel_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Painom_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Provnom_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Locnom_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Actdescrip_Z ;
   private String gxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z ;
}

