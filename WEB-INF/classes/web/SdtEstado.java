package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEstado extends GxSilentTrnSdt
{
   public SdtEstado( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEstado.class));
   }

   public SdtEstado( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle, context, "SdtEstado");
      initialize( remoteHandle) ;
   }

   public SdtEstado( int remoteHandle ,
                     StructSdtEstado struct )
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

   public void Load( String AV16SitCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV16SitCodigo});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"SitCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Estado");
      metadata.set("BT", "Estado");
      metadata.set("PK", "[ \"SitCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[ \"SitPaiCod-PaiCod\" ] },{ \"FK\":[ \"SinieCodigo\" ],\"FKMap\":[ \"EstadoSiniestro-SinieCodigo\" ] },{ \"FK\":[ \"SitRevCodigo\" ],\"FKMap\":[ \"EstadoSitRevista-SitRevCodigo\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitCodigo") )
            {
               gxTv_SdtEstado_Sitcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDescrip") )
            {
               gxTv_SdtEstado_Sitdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDescripSinAc") )
            {
               gxTv_SdtEstado_Sitdescripsinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsLicencia") )
            {
               gxTv_SdtEstado_Siteslicencia = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicCuentaTrab") )
            {
               gxTv_SdtEstado_Sitliccuentatrab = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicMesesProm") )
            {
               gxTv_SdtEstado_Sitlicmesesprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicMesesProm2") )
            {
               gxTv_SdtEstado_Sitlicmesesprom2 = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sItDescAbrev") )
            {
               gxTv_SdtEstado_Sitdescabrev = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDiasDivision") )
            {
               gxTv_SdtEstado_Sitdiasdivision = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsAusencia") )
            {
               gxTv_SdtEstado_Sitesausencia = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitAplicaPlus") )
            {
               gxTv_SdtEstado_Sitaplicaplus = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitAbsorbeFer") )
            {
               gxTv_SdtEstado_Sitabsorbefer = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicLimiteDef") )
            {
               gxTv_SdtEstado_Sitliclimitedef = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicAdjunDef") )
            {
               gxTv_SdtEstado_Sitlicadjundef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicAdjOblDef") )
            {
               gxTv_SdtEstado_Sitlicadjobldef = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicNecApr") )
            {
               gxTv_SdtEstado_Sitlicnecapr = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLIcIngMot") )
            {
               gxTv_SdtEstado_Sitlicingmot = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicOblIngMot") )
            {
               gxTv_SdtEstado_Sitlicoblingmot = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitPaiCod") )
            {
               gxTv_SdtEstado_Sitpaicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoSitRevista") )
            {
               gxTv_SdtEstado_Estadositrevista = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoSiniestro") )
            {
               gxTv_SdtEstado_Estadosiniestro = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoCanPresen") )
            {
               gxTv_SdtEstado_Estadocanpresen = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoRemCorr") )
            {
               gxTv_SdtEstado_Estadoremcorr = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEstado_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEstado_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitCodigo_Z") )
            {
               gxTv_SdtEstado_Sitcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDescrip_Z") )
            {
               gxTv_SdtEstado_Sitdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDescripSinAc_Z") )
            {
               gxTv_SdtEstado_Sitdescripsinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsLicencia_Z") )
            {
               gxTv_SdtEstado_Siteslicencia_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicCuentaTrab_Z") )
            {
               gxTv_SdtEstado_Sitliccuentatrab_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicMesesProm_Z") )
            {
               gxTv_SdtEstado_Sitlicmesesprom_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicMesesProm2_Z") )
            {
               gxTv_SdtEstado_Sitlicmesesprom2_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "sItDescAbrev_Z") )
            {
               gxTv_SdtEstado_Sitdescabrev_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitDiasDivision_Z") )
            {
               gxTv_SdtEstado_Sitdiasdivision_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitEsAusencia_Z") )
            {
               gxTv_SdtEstado_Sitesausencia_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitAplicaPlus_Z") )
            {
               gxTv_SdtEstado_Sitaplicaplus_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitAbsorbeFer_Z") )
            {
               gxTv_SdtEstado_Sitabsorbefer_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicLimiteDef_Z") )
            {
               gxTv_SdtEstado_Sitliclimitedef_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicAdjunDef_Z") )
            {
               gxTv_SdtEstado_Sitlicadjundef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicAdjOblDef_Z") )
            {
               gxTv_SdtEstado_Sitlicadjobldef_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicNecApr_Z") )
            {
               gxTv_SdtEstado_Sitlicnecapr_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLIcIngMot_Z") )
            {
               gxTv_SdtEstado_Sitlicingmot_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitLicOblIngMot_Z") )
            {
               gxTv_SdtEstado_Sitlicoblingmot_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitPaiCod_Z") )
            {
               gxTv_SdtEstado_Sitpaicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoSitRevista_Z") )
            {
               gxTv_SdtEstado_Estadositrevista_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoSiniestro_Z") )
            {
               gxTv_SdtEstado_Estadosiniestro_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoCanPresen_Z") )
            {
               gxTv_SdtEstado_Estadocanpresen_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoRemCorr_Z") )
            {
               gxTv_SdtEstado_Estadoremcorr_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SitPaiCod_N") )
            {
               gxTv_SdtEstado_Sitpaicod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoSitRevista_N") )
            {
               gxTv_SdtEstado_Estadositrevista_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EstadoSiniestro_N") )
            {
               gxTv_SdtEstado_Estadosiniestro_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Estado" ;
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
      oWriter.writeElement("SitCodigo", gxTv_SdtEstado_Sitcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitDescrip", gxTv_SdtEstado_Sitdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitDescripSinAc", gxTv_SdtEstado_Sitdescripsinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitEsLicencia", GXutil.booltostr( gxTv_SdtEstado_Siteslicencia));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicCuentaTrab", GXutil.booltostr( gxTv_SdtEstado_Sitliccuentatrab));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicMesesProm", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitlicmesesprom, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicMesesProm2", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitlicmesesprom2, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("sItDescAbrev", gxTv_SdtEstado_Sitdescabrev);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitDiasDivision", GXutil.trim( GXutil.strNoRound( gxTv_SdtEstado_Sitdiasdivision, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitEsAusencia", GXutil.booltostr( gxTv_SdtEstado_Sitesausencia));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitAplicaPlus", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitaplicaplus, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitAbsorbeFer", GXutil.booltostr( gxTv_SdtEstado_Sitabsorbefer));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicLimiteDef", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitliclimitedef, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicAdjunDef", GXutil.booltostr( gxTv_SdtEstado_Sitlicadjundef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicAdjOblDef", GXutil.booltostr( gxTv_SdtEstado_Sitlicadjobldef));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicNecApr", GXutil.booltostr( gxTv_SdtEstado_Sitlicnecapr));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLIcIngMot", GXutil.booltostr( gxTv_SdtEstado_Sitlicingmot));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitLicOblIngMot", GXutil.booltostr( gxTv_SdtEstado_Sitlicoblingmot));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SitPaiCod", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitpaicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EstadoSitRevista", GXutil.trim( GXutil.str( gxTv_SdtEstado_Estadositrevista, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EstadoSiniestro", gxTv_SdtEstado_Estadosiniestro);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EstadoCanPresen", GXutil.booltostr( gxTv_SdtEstado_Estadocanpresen));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EstadoRemCorr", GXutil.booltostr( gxTv_SdtEstado_Estadoremcorr));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEstado_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEstado_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitCodigo_Z", gxTv_SdtEstado_Sitcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitDescrip_Z", gxTv_SdtEstado_Sitdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitDescripSinAc_Z", gxTv_SdtEstado_Sitdescripsinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitEsLicencia_Z", GXutil.booltostr( gxTv_SdtEstado_Siteslicencia_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicCuentaTrab_Z", GXutil.booltostr( gxTv_SdtEstado_Sitliccuentatrab_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicMesesProm_Z", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitlicmesesprom_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicMesesProm2_Z", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitlicmesesprom2_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("sItDescAbrev_Z", gxTv_SdtEstado_Sitdescabrev_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitDiasDivision_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEstado_Sitdiasdivision_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitEsAusencia_Z", GXutil.booltostr( gxTv_SdtEstado_Sitesausencia_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitAplicaPlus_Z", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitaplicaplus_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitAbsorbeFer_Z", GXutil.booltostr( gxTv_SdtEstado_Sitabsorbefer_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicLimiteDef_Z", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitliclimitedef_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicAdjunDef_Z", GXutil.booltostr( gxTv_SdtEstado_Sitlicadjundef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicAdjOblDef_Z", GXutil.booltostr( gxTv_SdtEstado_Sitlicadjobldef_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicNecApr_Z", GXutil.booltostr( gxTv_SdtEstado_Sitlicnecapr_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLIcIngMot_Z", GXutil.booltostr( gxTv_SdtEstado_Sitlicingmot_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitLicOblIngMot_Z", GXutil.booltostr( gxTv_SdtEstado_Sitlicoblingmot_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitPaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitpaicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EstadoSitRevista_Z", GXutil.trim( GXutil.str( gxTv_SdtEstado_Estadositrevista_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EstadoSiniestro_Z", gxTv_SdtEstado_Estadosiniestro_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EstadoCanPresen_Z", GXutil.booltostr( gxTv_SdtEstado_Estadocanpresen_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EstadoRemCorr_Z", GXutil.booltostr( gxTv_SdtEstado_Estadoremcorr_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("SitPaiCod_N", GXutil.trim( GXutil.str( gxTv_SdtEstado_Sitpaicod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EstadoSitRevista_N", GXutil.trim( GXutil.str( gxTv_SdtEstado_Estadositrevista_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EstadoSiniestro_N", GXutil.trim( GXutil.str( gxTv_SdtEstado_Estadosiniestro_N, 1, 0)));
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
      AddObjectProperty("SitCodigo", gxTv_SdtEstado_Sitcodigo, false, includeNonInitialized);
      AddObjectProperty("SitDescrip", gxTv_SdtEstado_Sitdescrip, false, includeNonInitialized);
      AddObjectProperty("SitDescripSinAc", gxTv_SdtEstado_Sitdescripsinac, false, includeNonInitialized);
      AddObjectProperty("SitEsLicencia", gxTv_SdtEstado_Siteslicencia, false, includeNonInitialized);
      AddObjectProperty("SitLicCuentaTrab", gxTv_SdtEstado_Sitliccuentatrab, false, includeNonInitialized);
      AddObjectProperty("SitLicMesesProm", gxTv_SdtEstado_Sitlicmesesprom, false, includeNonInitialized);
      AddObjectProperty("SitLicMesesProm2", gxTv_SdtEstado_Sitlicmesesprom2, false, includeNonInitialized);
      AddObjectProperty("sItDescAbrev", gxTv_SdtEstado_Sitdescabrev, false, includeNonInitialized);
      AddObjectProperty("SitDiasDivision", gxTv_SdtEstado_Sitdiasdivision, false, includeNonInitialized);
      AddObjectProperty("SitEsAusencia", gxTv_SdtEstado_Sitesausencia, false, includeNonInitialized);
      AddObjectProperty("SitAplicaPlus", gxTv_SdtEstado_Sitaplicaplus, false, includeNonInitialized);
      AddObjectProperty("SitAbsorbeFer", gxTv_SdtEstado_Sitabsorbefer, false, includeNonInitialized);
      AddObjectProperty("SitLicLimiteDef", gxTv_SdtEstado_Sitliclimitedef, false, includeNonInitialized);
      AddObjectProperty("SitLicAdjunDef", gxTv_SdtEstado_Sitlicadjundef, false, includeNonInitialized);
      AddObjectProperty("SitLicAdjOblDef", gxTv_SdtEstado_Sitlicadjobldef, false, includeNonInitialized);
      AddObjectProperty("SitLicNecApr", gxTv_SdtEstado_Sitlicnecapr, false, includeNonInitialized);
      AddObjectProperty("SitLIcIngMot", gxTv_SdtEstado_Sitlicingmot, false, includeNonInitialized);
      AddObjectProperty("SitLicOblIngMot", gxTv_SdtEstado_Sitlicoblingmot, false, includeNonInitialized);
      AddObjectProperty("SitPaiCod", gxTv_SdtEstado_Sitpaicod, false, includeNonInitialized);
      AddObjectProperty("SitPaiCod_N", gxTv_SdtEstado_Sitpaicod_N, false, includeNonInitialized);
      AddObjectProperty("EstadoSitRevista", gxTv_SdtEstado_Estadositrevista, false, includeNonInitialized);
      AddObjectProperty("EstadoSitRevista_N", gxTv_SdtEstado_Estadositrevista_N, false, includeNonInitialized);
      AddObjectProperty("EstadoSiniestro", gxTv_SdtEstado_Estadosiniestro, false, includeNonInitialized);
      AddObjectProperty("EstadoSiniestro_N", gxTv_SdtEstado_Estadosiniestro_N, false, includeNonInitialized);
      AddObjectProperty("EstadoCanPresen", gxTv_SdtEstado_Estadocanpresen, false, includeNonInitialized);
      AddObjectProperty("EstadoRemCorr", gxTv_SdtEstado_Estadoremcorr, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEstado_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEstado_Initialized, false, includeNonInitialized);
         AddObjectProperty("SitCodigo_Z", gxTv_SdtEstado_Sitcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("SitDescrip_Z", gxTv_SdtEstado_Sitdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("SitDescripSinAc_Z", gxTv_SdtEstado_Sitdescripsinac_Z, false, includeNonInitialized);
         AddObjectProperty("SitEsLicencia_Z", gxTv_SdtEstado_Siteslicencia_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicCuentaTrab_Z", gxTv_SdtEstado_Sitliccuentatrab_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicMesesProm_Z", gxTv_SdtEstado_Sitlicmesesprom_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicMesesProm2_Z", gxTv_SdtEstado_Sitlicmesesprom2_Z, false, includeNonInitialized);
         AddObjectProperty("sItDescAbrev_Z", gxTv_SdtEstado_Sitdescabrev_Z, false, includeNonInitialized);
         AddObjectProperty("SitDiasDivision_Z", gxTv_SdtEstado_Sitdiasdivision_Z, false, includeNonInitialized);
         AddObjectProperty("SitEsAusencia_Z", gxTv_SdtEstado_Sitesausencia_Z, false, includeNonInitialized);
         AddObjectProperty("SitAplicaPlus_Z", gxTv_SdtEstado_Sitaplicaplus_Z, false, includeNonInitialized);
         AddObjectProperty("SitAbsorbeFer_Z", gxTv_SdtEstado_Sitabsorbefer_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicLimiteDef_Z", gxTv_SdtEstado_Sitliclimitedef_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicAdjunDef_Z", gxTv_SdtEstado_Sitlicadjundef_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicAdjOblDef_Z", gxTv_SdtEstado_Sitlicadjobldef_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicNecApr_Z", gxTv_SdtEstado_Sitlicnecapr_Z, false, includeNonInitialized);
         AddObjectProperty("SitLIcIngMot_Z", gxTv_SdtEstado_Sitlicingmot_Z, false, includeNonInitialized);
         AddObjectProperty("SitLicOblIngMot_Z", gxTv_SdtEstado_Sitlicoblingmot_Z, false, includeNonInitialized);
         AddObjectProperty("SitPaiCod_Z", gxTv_SdtEstado_Sitpaicod_Z, false, includeNonInitialized);
         AddObjectProperty("EstadoSitRevista_Z", gxTv_SdtEstado_Estadositrevista_Z, false, includeNonInitialized);
         AddObjectProperty("EstadoSiniestro_Z", gxTv_SdtEstado_Estadosiniestro_Z, false, includeNonInitialized);
         AddObjectProperty("EstadoCanPresen_Z", gxTv_SdtEstado_Estadocanpresen_Z, false, includeNonInitialized);
         AddObjectProperty("EstadoRemCorr_Z", gxTv_SdtEstado_Estadoremcorr_Z, false, includeNonInitialized);
         AddObjectProperty("SitPaiCod_N", gxTv_SdtEstado_Sitpaicod_N, false, includeNonInitialized);
         AddObjectProperty("EstadoSitRevista_N", gxTv_SdtEstado_Estadositrevista_N, false, includeNonInitialized);
         AddObjectProperty("EstadoSiniestro_N", gxTv_SdtEstado_Estadosiniestro_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEstado sdt )
   {
      if ( sdt.IsDirty("SitCodigo") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitcodigo = sdt.getgxTv_SdtEstado_Sitcodigo() ;
      }
      if ( sdt.IsDirty("SitDescrip") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitdescrip = sdt.getgxTv_SdtEstado_Sitdescrip() ;
      }
      if ( sdt.IsDirty("SitDescripSinAc") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitdescripsinac = sdt.getgxTv_SdtEstado_Sitdescripsinac() ;
      }
      if ( sdt.IsDirty("SitEsLicencia") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Siteslicencia = sdt.getgxTv_SdtEstado_Siteslicencia() ;
      }
      if ( sdt.IsDirty("SitLicCuentaTrab") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitliccuentatrab = sdt.getgxTv_SdtEstado_Sitliccuentatrab() ;
      }
      if ( sdt.IsDirty("SitLicMesesProm") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicmesesprom = sdt.getgxTv_SdtEstado_Sitlicmesesprom() ;
      }
      if ( sdt.IsDirty("SitLicMesesProm2") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicmesesprom2 = sdt.getgxTv_SdtEstado_Sitlicmesesprom2() ;
      }
      if ( sdt.IsDirty("sItDescAbrev") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitdescabrev = sdt.getgxTv_SdtEstado_Sitdescabrev() ;
      }
      if ( sdt.IsDirty("SitDiasDivision") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitdiasdivision = sdt.getgxTv_SdtEstado_Sitdiasdivision() ;
      }
      if ( sdt.IsDirty("SitEsAusencia") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitesausencia = sdt.getgxTv_SdtEstado_Sitesausencia() ;
      }
      if ( sdt.IsDirty("SitAplicaPlus") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitaplicaplus = sdt.getgxTv_SdtEstado_Sitaplicaplus() ;
      }
      if ( sdt.IsDirty("SitAbsorbeFer") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitabsorbefer = sdt.getgxTv_SdtEstado_Sitabsorbefer() ;
      }
      if ( sdt.IsDirty("SitLicLimiteDef") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitliclimitedef = sdt.getgxTv_SdtEstado_Sitliclimitedef() ;
      }
      if ( sdt.IsDirty("SitLicAdjunDef") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicadjundef = sdt.getgxTv_SdtEstado_Sitlicadjundef() ;
      }
      if ( sdt.IsDirty("SitLicAdjOblDef") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicadjobldef = sdt.getgxTv_SdtEstado_Sitlicadjobldef() ;
      }
      if ( sdt.IsDirty("SitLicNecApr") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicnecapr = sdt.getgxTv_SdtEstado_Sitlicnecapr() ;
      }
      if ( sdt.IsDirty("SitLIcIngMot") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicingmot = sdt.getgxTv_SdtEstado_Sitlicingmot() ;
      }
      if ( sdt.IsDirty("SitLicOblIngMot") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitlicoblingmot = sdt.getgxTv_SdtEstado_Sitlicoblingmot() ;
      }
      if ( sdt.IsDirty("SitPaiCod") )
      {
         gxTv_SdtEstado_Sitpaicod_N = sdt.getgxTv_SdtEstado_Sitpaicod_N() ;
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Sitpaicod = sdt.getgxTv_SdtEstado_Sitpaicod() ;
      }
      if ( sdt.IsDirty("EstadoSitRevista") )
      {
         gxTv_SdtEstado_Estadositrevista_N = sdt.getgxTv_SdtEstado_Estadositrevista_N() ;
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Estadositrevista = sdt.getgxTv_SdtEstado_Estadositrevista() ;
      }
      if ( sdt.IsDirty("EstadoSiniestro") )
      {
         gxTv_SdtEstado_Estadosiniestro_N = sdt.getgxTv_SdtEstado_Estadosiniestro_N() ;
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Estadosiniestro = sdt.getgxTv_SdtEstado_Estadosiniestro() ;
      }
      if ( sdt.IsDirty("EstadoCanPresen") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Estadocanpresen = sdt.getgxTv_SdtEstado_Estadocanpresen() ;
      }
      if ( sdt.IsDirty("EstadoRemCorr") )
      {
         gxTv_SdtEstado_N = (byte)(0) ;
         gxTv_SdtEstado_Estadoremcorr = sdt.getgxTv_SdtEstado_Estadoremcorr() ;
      }
   }

   public String getgxTv_SdtEstado_Sitcodigo( )
   {
      return gxTv_SdtEstado_Sitcodigo ;
   }

   public void setgxTv_SdtEstado_Sitcodigo( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEstado_Sitcodigo, value) != 0 )
      {
         gxTv_SdtEstado_Mode = "INS" ;
         this.setgxTv_SdtEstado_Sitcodigo_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitdescrip_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitdescripsinac_Z_SetNull( );
         this.setgxTv_SdtEstado_Siteslicencia_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitliccuentatrab_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicmesesprom_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicmesesprom2_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitdescabrev_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitdiasdivision_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitesausencia_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitaplicaplus_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitabsorbefer_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitliclimitedef_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicadjundef_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicadjobldef_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicnecapr_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicingmot_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitlicoblingmot_Z_SetNull( );
         this.setgxTv_SdtEstado_Sitpaicod_Z_SetNull( );
         this.setgxTv_SdtEstado_Estadositrevista_Z_SetNull( );
         this.setgxTv_SdtEstado_Estadosiniestro_Z_SetNull( );
         this.setgxTv_SdtEstado_Estadocanpresen_Z_SetNull( );
         this.setgxTv_SdtEstado_Estadoremcorr_Z_SetNull( );
      }
      SetDirty("Sitcodigo");
      gxTv_SdtEstado_Sitcodigo = value ;
   }

   public String getgxTv_SdtEstado_Sitdescrip( )
   {
      return gxTv_SdtEstado_Sitdescrip ;
   }

   public void setgxTv_SdtEstado_Sitdescrip( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdescrip");
      gxTv_SdtEstado_Sitdescrip = value ;
   }

   public String getgxTv_SdtEstado_Sitdescripsinac( )
   {
      return gxTv_SdtEstado_Sitdescripsinac ;
   }

   public void setgxTv_SdtEstado_Sitdescripsinac( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdescripsinac");
      gxTv_SdtEstado_Sitdescripsinac = value ;
   }

   public boolean getgxTv_SdtEstado_Siteslicencia( )
   {
      return gxTv_SdtEstado_Siteslicencia ;
   }

   public void setgxTv_SdtEstado_Siteslicencia( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Siteslicencia");
      gxTv_SdtEstado_Siteslicencia = value ;
   }

   public boolean getgxTv_SdtEstado_Sitliccuentatrab( )
   {
      return gxTv_SdtEstado_Sitliccuentatrab ;
   }

   public void setgxTv_SdtEstado_Sitliccuentatrab( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitliccuentatrab");
      gxTv_SdtEstado_Sitliccuentatrab = value ;
   }

   public byte getgxTv_SdtEstado_Sitlicmesesprom( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom ;
   }

   public void setgxTv_SdtEstado_Sitlicmesesprom( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicmesesprom");
      gxTv_SdtEstado_Sitlicmesesprom = value ;
   }

   public byte getgxTv_SdtEstado_Sitlicmesesprom2( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom2 ;
   }

   public void setgxTv_SdtEstado_Sitlicmesesprom2( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicmesesprom2");
      gxTv_SdtEstado_Sitlicmesesprom2 = value ;
   }

   public String getgxTv_SdtEstado_Sitdescabrev( )
   {
      return gxTv_SdtEstado_Sitdescabrev ;
   }

   public void setgxTv_SdtEstado_Sitdescabrev( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdescabrev");
      gxTv_SdtEstado_Sitdescabrev = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEstado_Sitdiasdivision( )
   {
      return gxTv_SdtEstado_Sitdiasdivision ;
   }

   public void setgxTv_SdtEstado_Sitdiasdivision( java.math.BigDecimal value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdiasdivision");
      gxTv_SdtEstado_Sitdiasdivision = value ;
   }

   public boolean getgxTv_SdtEstado_Sitesausencia( )
   {
      return gxTv_SdtEstado_Sitesausencia ;
   }

   public void setgxTv_SdtEstado_Sitesausencia( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitesausencia");
      gxTv_SdtEstado_Sitesausencia = value ;
   }

   public byte getgxTv_SdtEstado_Sitaplicaplus( )
   {
      return gxTv_SdtEstado_Sitaplicaplus ;
   }

   public void setgxTv_SdtEstado_Sitaplicaplus( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitaplicaplus");
      gxTv_SdtEstado_Sitaplicaplus = value ;
   }

   public boolean getgxTv_SdtEstado_Sitabsorbefer( )
   {
      return gxTv_SdtEstado_Sitabsorbefer ;
   }

   public void setgxTv_SdtEstado_Sitabsorbefer( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitabsorbefer");
      gxTv_SdtEstado_Sitabsorbefer = value ;
   }

   public short getgxTv_SdtEstado_Sitliclimitedef( )
   {
      return gxTv_SdtEstado_Sitliclimitedef ;
   }

   public void setgxTv_SdtEstado_Sitliclimitedef( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitliclimitedef");
      gxTv_SdtEstado_Sitliclimitedef = value ;
   }

   public boolean getgxTv_SdtEstado_Sitlicadjundef( )
   {
      return gxTv_SdtEstado_Sitlicadjundef ;
   }

   public void setgxTv_SdtEstado_Sitlicadjundef( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicadjundef");
      gxTv_SdtEstado_Sitlicadjundef = value ;
   }

   public boolean getgxTv_SdtEstado_Sitlicadjobldef( )
   {
      return gxTv_SdtEstado_Sitlicadjobldef ;
   }

   public void setgxTv_SdtEstado_Sitlicadjobldef( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicadjobldef");
      gxTv_SdtEstado_Sitlicadjobldef = value ;
   }

   public boolean getgxTv_SdtEstado_Sitlicnecapr( )
   {
      return gxTv_SdtEstado_Sitlicnecapr ;
   }

   public void setgxTv_SdtEstado_Sitlicnecapr( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicnecapr");
      gxTv_SdtEstado_Sitlicnecapr = value ;
   }

   public boolean getgxTv_SdtEstado_Sitlicingmot( )
   {
      return gxTv_SdtEstado_Sitlicingmot ;
   }

   public void setgxTv_SdtEstado_Sitlicingmot( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicingmot");
      gxTv_SdtEstado_Sitlicingmot = value ;
   }

   public boolean getgxTv_SdtEstado_Sitlicoblingmot( )
   {
      return gxTv_SdtEstado_Sitlicoblingmot ;
   }

   public void setgxTv_SdtEstado_Sitlicoblingmot( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicoblingmot");
      gxTv_SdtEstado_Sitlicoblingmot = value ;
   }

   public short getgxTv_SdtEstado_Sitpaicod( )
   {
      return gxTv_SdtEstado_Sitpaicod ;
   }

   public void setgxTv_SdtEstado_Sitpaicod( short value )
   {
      gxTv_SdtEstado_Sitpaicod_N = (byte)(0) ;
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitpaicod");
      gxTv_SdtEstado_Sitpaicod = value ;
   }

   public void setgxTv_SdtEstado_Sitpaicod_SetNull( )
   {
      gxTv_SdtEstado_Sitpaicod_N = (byte)(1) ;
      gxTv_SdtEstado_Sitpaicod = (short)(0) ;
      SetDirty("Sitpaicod");
   }

   public boolean getgxTv_SdtEstado_Sitpaicod_IsNull( )
   {
      return (gxTv_SdtEstado_Sitpaicod_N==1) ;
   }

   public short getgxTv_SdtEstado_Estadositrevista( )
   {
      return gxTv_SdtEstado_Estadositrevista ;
   }

   public void setgxTv_SdtEstado_Estadositrevista( short value )
   {
      gxTv_SdtEstado_Estadositrevista_N = (byte)(0) ;
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadositrevista");
      gxTv_SdtEstado_Estadositrevista = value ;
   }

   public void setgxTv_SdtEstado_Estadositrevista_SetNull( )
   {
      gxTv_SdtEstado_Estadositrevista_N = (byte)(1) ;
      gxTv_SdtEstado_Estadositrevista = (short)(0) ;
      SetDirty("Estadositrevista");
   }

   public boolean getgxTv_SdtEstado_Estadositrevista_IsNull( )
   {
      return (gxTv_SdtEstado_Estadositrevista_N==1) ;
   }

   public String getgxTv_SdtEstado_Estadosiniestro( )
   {
      return gxTv_SdtEstado_Estadosiniestro ;
   }

   public void setgxTv_SdtEstado_Estadosiniestro( String value )
   {
      gxTv_SdtEstado_Estadosiniestro_N = (byte)(0) ;
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadosiniestro");
      gxTv_SdtEstado_Estadosiniestro = value ;
   }

   public void setgxTv_SdtEstado_Estadosiniestro_SetNull( )
   {
      gxTv_SdtEstado_Estadosiniestro_N = (byte)(1) ;
      gxTv_SdtEstado_Estadosiniestro = "" ;
      SetDirty("Estadosiniestro");
   }

   public boolean getgxTv_SdtEstado_Estadosiniestro_IsNull( )
   {
      return (gxTv_SdtEstado_Estadosiniestro_N==1) ;
   }

   public boolean getgxTv_SdtEstado_Estadocanpresen( )
   {
      return gxTv_SdtEstado_Estadocanpresen ;
   }

   public void setgxTv_SdtEstado_Estadocanpresen( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadocanpresen");
      gxTv_SdtEstado_Estadocanpresen = value ;
   }

   public boolean getgxTv_SdtEstado_Estadoremcorr( )
   {
      return gxTv_SdtEstado_Estadoremcorr ;
   }

   public void setgxTv_SdtEstado_Estadoremcorr( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadoremcorr");
      gxTv_SdtEstado_Estadoremcorr = value ;
   }

   public String getgxTv_SdtEstado_Mode( )
   {
      return gxTv_SdtEstado_Mode ;
   }

   public void setgxTv_SdtEstado_Mode( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEstado_Mode = value ;
   }

   public void setgxTv_SdtEstado_Mode_SetNull( )
   {
      gxTv_SdtEstado_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEstado_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEstado_Initialized( )
   {
      return gxTv_SdtEstado_Initialized ;
   }

   public void setgxTv_SdtEstado_Initialized( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEstado_Initialized = value ;
   }

   public void setgxTv_SdtEstado_Initialized_SetNull( )
   {
      gxTv_SdtEstado_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEstado_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEstado_Sitcodigo_Z( )
   {
      return gxTv_SdtEstado_Sitcodigo_Z ;
   }

   public void setgxTv_SdtEstado_Sitcodigo_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitcodigo_Z");
      gxTv_SdtEstado_Sitcodigo_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitcodigo_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitcodigo_Z = "" ;
      SetDirty("Sitcodigo_Z");
   }

   public boolean getgxTv_SdtEstado_Sitcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEstado_Sitdescrip_Z( )
   {
      return gxTv_SdtEstado_Sitdescrip_Z ;
   }

   public void setgxTv_SdtEstado_Sitdescrip_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdescrip_Z");
      gxTv_SdtEstado_Sitdescrip_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitdescrip_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitdescrip_Z = "" ;
      SetDirty("Sitdescrip_Z");
   }

   public boolean getgxTv_SdtEstado_Sitdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEstado_Sitdescripsinac_Z( )
   {
      return gxTv_SdtEstado_Sitdescripsinac_Z ;
   }

   public void setgxTv_SdtEstado_Sitdescripsinac_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdescripsinac_Z");
      gxTv_SdtEstado_Sitdescripsinac_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitdescripsinac_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitdescripsinac_Z = "" ;
      SetDirty("Sitdescripsinac_Z");
   }

   public boolean getgxTv_SdtEstado_Sitdescripsinac_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Siteslicencia_Z( )
   {
      return gxTv_SdtEstado_Siteslicencia_Z ;
   }

   public void setgxTv_SdtEstado_Siteslicencia_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Siteslicencia_Z");
      gxTv_SdtEstado_Siteslicencia_Z = value ;
   }

   public void setgxTv_SdtEstado_Siteslicencia_Z_SetNull( )
   {
      gxTv_SdtEstado_Siteslicencia_Z = false ;
      SetDirty("Siteslicencia_Z");
   }

   public boolean getgxTv_SdtEstado_Siteslicencia_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitliccuentatrab_Z( )
   {
      return gxTv_SdtEstado_Sitliccuentatrab_Z ;
   }

   public void setgxTv_SdtEstado_Sitliccuentatrab_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitliccuentatrab_Z");
      gxTv_SdtEstado_Sitliccuentatrab_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitliccuentatrab_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitliccuentatrab_Z = false ;
      SetDirty("Sitliccuentatrab_Z");
   }

   public boolean getgxTv_SdtEstado_Sitliccuentatrab_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEstado_Sitlicmesesprom_Z( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicmesesprom_Z( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicmesesprom_Z");
      gxTv_SdtEstado_Sitlicmesesprom_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicmesesprom_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicmesesprom_Z = (byte)(0) ;
      SetDirty("Sitlicmesesprom_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicmesesprom_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEstado_Sitlicmesesprom2_Z( )
   {
      return gxTv_SdtEstado_Sitlicmesesprom2_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicmesesprom2_Z( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicmesesprom2_Z");
      gxTv_SdtEstado_Sitlicmesesprom2_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicmesesprom2_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicmesesprom2_Z = (byte)(0) ;
      SetDirty("Sitlicmesesprom2_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicmesesprom2_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEstado_Sitdescabrev_Z( )
   {
      return gxTv_SdtEstado_Sitdescabrev_Z ;
   }

   public void setgxTv_SdtEstado_Sitdescabrev_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdescabrev_Z");
      gxTv_SdtEstado_Sitdescabrev_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitdescabrev_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitdescabrev_Z = "" ;
      SetDirty("Sitdescabrev_Z");
   }

   public boolean getgxTv_SdtEstado_Sitdescabrev_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEstado_Sitdiasdivision_Z( )
   {
      return gxTv_SdtEstado_Sitdiasdivision_Z ;
   }

   public void setgxTv_SdtEstado_Sitdiasdivision_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitdiasdivision_Z");
      gxTv_SdtEstado_Sitdiasdivision_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitdiasdivision_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitdiasdivision_Z = DecimalUtil.ZERO ;
      SetDirty("Sitdiasdivision_Z");
   }

   public boolean getgxTv_SdtEstado_Sitdiasdivision_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitesausencia_Z( )
   {
      return gxTv_SdtEstado_Sitesausencia_Z ;
   }

   public void setgxTv_SdtEstado_Sitesausencia_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitesausencia_Z");
      gxTv_SdtEstado_Sitesausencia_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitesausencia_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitesausencia_Z = false ;
      SetDirty("Sitesausencia_Z");
   }

   public boolean getgxTv_SdtEstado_Sitesausencia_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEstado_Sitaplicaplus_Z( )
   {
      return gxTv_SdtEstado_Sitaplicaplus_Z ;
   }

   public void setgxTv_SdtEstado_Sitaplicaplus_Z( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitaplicaplus_Z");
      gxTv_SdtEstado_Sitaplicaplus_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitaplicaplus_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitaplicaplus_Z = (byte)(0) ;
      SetDirty("Sitaplicaplus_Z");
   }

   public boolean getgxTv_SdtEstado_Sitaplicaplus_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitabsorbefer_Z( )
   {
      return gxTv_SdtEstado_Sitabsorbefer_Z ;
   }

   public void setgxTv_SdtEstado_Sitabsorbefer_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitabsorbefer_Z");
      gxTv_SdtEstado_Sitabsorbefer_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitabsorbefer_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitabsorbefer_Z = false ;
      SetDirty("Sitabsorbefer_Z");
   }

   public boolean getgxTv_SdtEstado_Sitabsorbefer_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEstado_Sitliclimitedef_Z( )
   {
      return gxTv_SdtEstado_Sitliclimitedef_Z ;
   }

   public void setgxTv_SdtEstado_Sitliclimitedef_Z( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitliclimitedef_Z");
      gxTv_SdtEstado_Sitliclimitedef_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitliclimitedef_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitliclimitedef_Z = (short)(0) ;
      SetDirty("Sitliclimitedef_Z");
   }

   public boolean getgxTv_SdtEstado_Sitliclimitedef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitlicadjundef_Z( )
   {
      return gxTv_SdtEstado_Sitlicadjundef_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicadjundef_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicadjundef_Z");
      gxTv_SdtEstado_Sitlicadjundef_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicadjundef_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicadjundef_Z = false ;
      SetDirty("Sitlicadjundef_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicadjundef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitlicadjobldef_Z( )
   {
      return gxTv_SdtEstado_Sitlicadjobldef_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicadjobldef_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicadjobldef_Z");
      gxTv_SdtEstado_Sitlicadjobldef_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicadjobldef_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicadjobldef_Z = false ;
      SetDirty("Sitlicadjobldef_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicadjobldef_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitlicnecapr_Z( )
   {
      return gxTv_SdtEstado_Sitlicnecapr_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicnecapr_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicnecapr_Z");
      gxTv_SdtEstado_Sitlicnecapr_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicnecapr_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicnecapr_Z = false ;
      SetDirty("Sitlicnecapr_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicnecapr_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitlicingmot_Z( )
   {
      return gxTv_SdtEstado_Sitlicingmot_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicingmot_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicingmot_Z");
      gxTv_SdtEstado_Sitlicingmot_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicingmot_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicingmot_Z = false ;
      SetDirty("Sitlicingmot_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicingmot_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Sitlicoblingmot_Z( )
   {
      return gxTv_SdtEstado_Sitlicoblingmot_Z ;
   }

   public void setgxTv_SdtEstado_Sitlicoblingmot_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitlicoblingmot_Z");
      gxTv_SdtEstado_Sitlicoblingmot_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitlicoblingmot_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitlicoblingmot_Z = false ;
      SetDirty("Sitlicoblingmot_Z");
   }

   public boolean getgxTv_SdtEstado_Sitlicoblingmot_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEstado_Sitpaicod_Z( )
   {
      return gxTv_SdtEstado_Sitpaicod_Z ;
   }

   public void setgxTv_SdtEstado_Sitpaicod_Z( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitpaicod_Z");
      gxTv_SdtEstado_Sitpaicod_Z = value ;
   }

   public void setgxTv_SdtEstado_Sitpaicod_Z_SetNull( )
   {
      gxTv_SdtEstado_Sitpaicod_Z = (short)(0) ;
      SetDirty("Sitpaicod_Z");
   }

   public boolean getgxTv_SdtEstado_Sitpaicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEstado_Estadositrevista_Z( )
   {
      return gxTv_SdtEstado_Estadositrevista_Z ;
   }

   public void setgxTv_SdtEstado_Estadositrevista_Z( short value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadositrevista_Z");
      gxTv_SdtEstado_Estadositrevista_Z = value ;
   }

   public void setgxTv_SdtEstado_Estadositrevista_Z_SetNull( )
   {
      gxTv_SdtEstado_Estadositrevista_Z = (short)(0) ;
      SetDirty("Estadositrevista_Z");
   }

   public boolean getgxTv_SdtEstado_Estadositrevista_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEstado_Estadosiniestro_Z( )
   {
      return gxTv_SdtEstado_Estadosiniestro_Z ;
   }

   public void setgxTv_SdtEstado_Estadosiniestro_Z( String value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadosiniestro_Z");
      gxTv_SdtEstado_Estadosiniestro_Z = value ;
   }

   public void setgxTv_SdtEstado_Estadosiniestro_Z_SetNull( )
   {
      gxTv_SdtEstado_Estadosiniestro_Z = "" ;
      SetDirty("Estadosiniestro_Z");
   }

   public boolean getgxTv_SdtEstado_Estadosiniestro_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Estadocanpresen_Z( )
   {
      return gxTv_SdtEstado_Estadocanpresen_Z ;
   }

   public void setgxTv_SdtEstado_Estadocanpresen_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadocanpresen_Z");
      gxTv_SdtEstado_Estadocanpresen_Z = value ;
   }

   public void setgxTv_SdtEstado_Estadocanpresen_Z_SetNull( )
   {
      gxTv_SdtEstado_Estadocanpresen_Z = false ;
      SetDirty("Estadocanpresen_Z");
   }

   public boolean getgxTv_SdtEstado_Estadocanpresen_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEstado_Estadoremcorr_Z( )
   {
      return gxTv_SdtEstado_Estadoremcorr_Z ;
   }

   public void setgxTv_SdtEstado_Estadoremcorr_Z( boolean value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadoremcorr_Z");
      gxTv_SdtEstado_Estadoremcorr_Z = value ;
   }

   public void setgxTv_SdtEstado_Estadoremcorr_Z_SetNull( )
   {
      gxTv_SdtEstado_Estadoremcorr_Z = false ;
      SetDirty("Estadoremcorr_Z");
   }

   public boolean getgxTv_SdtEstado_Estadoremcorr_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEstado_Sitpaicod_N( )
   {
      return gxTv_SdtEstado_Sitpaicod_N ;
   }

   public void setgxTv_SdtEstado_Sitpaicod_N( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Sitpaicod_N");
      gxTv_SdtEstado_Sitpaicod_N = value ;
   }

   public void setgxTv_SdtEstado_Sitpaicod_N_SetNull( )
   {
      gxTv_SdtEstado_Sitpaicod_N = (byte)(0) ;
      SetDirty("Sitpaicod_N");
   }

   public boolean getgxTv_SdtEstado_Sitpaicod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEstado_Estadositrevista_N( )
   {
      return gxTv_SdtEstado_Estadositrevista_N ;
   }

   public void setgxTv_SdtEstado_Estadositrevista_N( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadositrevista_N");
      gxTv_SdtEstado_Estadositrevista_N = value ;
   }

   public void setgxTv_SdtEstado_Estadositrevista_N_SetNull( )
   {
      gxTv_SdtEstado_Estadositrevista_N = (byte)(0) ;
      SetDirty("Estadositrevista_N");
   }

   public boolean getgxTv_SdtEstado_Estadositrevista_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEstado_Estadosiniestro_N( )
   {
      return gxTv_SdtEstado_Estadosiniestro_N ;
   }

   public void setgxTv_SdtEstado_Estadosiniestro_N( byte value )
   {
      gxTv_SdtEstado_N = (byte)(0) ;
      SetDirty("Estadosiniestro_N");
      gxTv_SdtEstado_Estadosiniestro_N = value ;
   }

   public void setgxTv_SdtEstado_Estadosiniestro_N_SetNull( )
   {
      gxTv_SdtEstado_Estadosiniestro_N = (byte)(0) ;
      SetDirty("Estadosiniestro_N");
   }

   public boolean getgxTv_SdtEstado_Estadosiniestro_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.estado_bc obj;
      obj = new web.estado_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEstado_Sitcodigo = "" ;
      gxTv_SdtEstado_N = (byte)(1) ;
      gxTv_SdtEstado_Sitdescrip = "" ;
      gxTv_SdtEstado_Sitdescripsinac = "" ;
      gxTv_SdtEstado_Sitdescabrev = "" ;
      gxTv_SdtEstado_Sitdiasdivision = DecimalUtil.ZERO ;
      gxTv_SdtEstado_Estadosiniestro = "" ;
      gxTv_SdtEstado_Mode = "" ;
      gxTv_SdtEstado_Sitcodigo_Z = "" ;
      gxTv_SdtEstado_Sitdescrip_Z = "" ;
      gxTv_SdtEstado_Sitdescripsinac_Z = "" ;
      gxTv_SdtEstado_Sitdescabrev_Z = "" ;
      gxTv_SdtEstado_Sitdiasdivision_Z = DecimalUtil.ZERO ;
      gxTv_SdtEstado_Estadosiniestro_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEstado_N ;
   }

   public web.SdtEstado Clone( )
   {
      web.SdtEstado sdt;
      web.estado_bc obj;
      sdt = (web.SdtEstado)(clone()) ;
      obj = (web.estado_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtEstado struct )
   {
      setgxTv_SdtEstado_Sitcodigo(struct.getSitcodigo());
      setgxTv_SdtEstado_Sitdescrip(struct.getSitdescrip());
      setgxTv_SdtEstado_Sitdescripsinac(struct.getSitdescripsinac());
      setgxTv_SdtEstado_Siteslicencia(struct.getSiteslicencia());
      setgxTv_SdtEstado_Sitliccuentatrab(struct.getSitliccuentatrab());
      setgxTv_SdtEstado_Sitlicmesesprom(struct.getSitlicmesesprom());
      setgxTv_SdtEstado_Sitlicmesesprom2(struct.getSitlicmesesprom2());
      setgxTv_SdtEstado_Sitdescabrev(struct.getSitdescabrev());
      setgxTv_SdtEstado_Sitdiasdivision(struct.getSitdiasdivision());
      setgxTv_SdtEstado_Sitesausencia(struct.getSitesausencia());
      setgxTv_SdtEstado_Sitaplicaplus(struct.getSitaplicaplus());
      setgxTv_SdtEstado_Sitabsorbefer(struct.getSitabsorbefer());
      setgxTv_SdtEstado_Sitliclimitedef(struct.getSitliclimitedef());
      setgxTv_SdtEstado_Sitlicadjundef(struct.getSitlicadjundef());
      setgxTv_SdtEstado_Sitlicadjobldef(struct.getSitlicadjobldef());
      setgxTv_SdtEstado_Sitlicnecapr(struct.getSitlicnecapr());
      setgxTv_SdtEstado_Sitlicingmot(struct.getSitlicingmot());
      setgxTv_SdtEstado_Sitlicoblingmot(struct.getSitlicoblingmot());
      setgxTv_SdtEstado_Sitpaicod(struct.getSitpaicod());
      setgxTv_SdtEstado_Estadositrevista(struct.getEstadositrevista());
      setgxTv_SdtEstado_Estadosiniestro(struct.getEstadosiniestro());
      setgxTv_SdtEstado_Estadocanpresen(struct.getEstadocanpresen());
      setgxTv_SdtEstado_Estadoremcorr(struct.getEstadoremcorr());
      setgxTv_SdtEstado_Mode(struct.getMode());
      setgxTv_SdtEstado_Initialized(struct.getInitialized());
      setgxTv_SdtEstado_Sitcodigo_Z(struct.getSitcodigo_Z());
      setgxTv_SdtEstado_Sitdescrip_Z(struct.getSitdescrip_Z());
      setgxTv_SdtEstado_Sitdescripsinac_Z(struct.getSitdescripsinac_Z());
      setgxTv_SdtEstado_Siteslicencia_Z(struct.getSiteslicencia_Z());
      setgxTv_SdtEstado_Sitliccuentatrab_Z(struct.getSitliccuentatrab_Z());
      setgxTv_SdtEstado_Sitlicmesesprom_Z(struct.getSitlicmesesprom_Z());
      setgxTv_SdtEstado_Sitlicmesesprom2_Z(struct.getSitlicmesesprom2_Z());
      setgxTv_SdtEstado_Sitdescabrev_Z(struct.getSitdescabrev_Z());
      setgxTv_SdtEstado_Sitdiasdivision_Z(struct.getSitdiasdivision_Z());
      setgxTv_SdtEstado_Sitesausencia_Z(struct.getSitesausencia_Z());
      setgxTv_SdtEstado_Sitaplicaplus_Z(struct.getSitaplicaplus_Z());
      setgxTv_SdtEstado_Sitabsorbefer_Z(struct.getSitabsorbefer_Z());
      setgxTv_SdtEstado_Sitliclimitedef_Z(struct.getSitliclimitedef_Z());
      setgxTv_SdtEstado_Sitlicadjundef_Z(struct.getSitlicadjundef_Z());
      setgxTv_SdtEstado_Sitlicadjobldef_Z(struct.getSitlicadjobldef_Z());
      setgxTv_SdtEstado_Sitlicnecapr_Z(struct.getSitlicnecapr_Z());
      setgxTv_SdtEstado_Sitlicingmot_Z(struct.getSitlicingmot_Z());
      setgxTv_SdtEstado_Sitlicoblingmot_Z(struct.getSitlicoblingmot_Z());
      setgxTv_SdtEstado_Sitpaicod_Z(struct.getSitpaicod_Z());
      setgxTv_SdtEstado_Estadositrevista_Z(struct.getEstadositrevista_Z());
      setgxTv_SdtEstado_Estadosiniestro_Z(struct.getEstadosiniestro_Z());
      setgxTv_SdtEstado_Estadocanpresen_Z(struct.getEstadocanpresen_Z());
      setgxTv_SdtEstado_Estadoremcorr_Z(struct.getEstadoremcorr_Z());
      setgxTv_SdtEstado_Sitpaicod_N(struct.getSitpaicod_N());
      setgxTv_SdtEstado_Estadositrevista_N(struct.getEstadositrevista_N());
      setgxTv_SdtEstado_Estadosiniestro_N(struct.getEstadosiniestro_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEstado getStruct( )
   {
      web.StructSdtEstado struct = new web.StructSdtEstado ();
      struct.setSitcodigo(getgxTv_SdtEstado_Sitcodigo());
      struct.setSitdescrip(getgxTv_SdtEstado_Sitdescrip());
      struct.setSitdescripsinac(getgxTv_SdtEstado_Sitdescripsinac());
      struct.setSiteslicencia(getgxTv_SdtEstado_Siteslicencia());
      struct.setSitliccuentatrab(getgxTv_SdtEstado_Sitliccuentatrab());
      struct.setSitlicmesesprom(getgxTv_SdtEstado_Sitlicmesesprom());
      struct.setSitlicmesesprom2(getgxTv_SdtEstado_Sitlicmesesprom2());
      struct.setSitdescabrev(getgxTv_SdtEstado_Sitdescabrev());
      struct.setSitdiasdivision(getgxTv_SdtEstado_Sitdiasdivision());
      struct.setSitesausencia(getgxTv_SdtEstado_Sitesausencia());
      struct.setSitaplicaplus(getgxTv_SdtEstado_Sitaplicaplus());
      struct.setSitabsorbefer(getgxTv_SdtEstado_Sitabsorbefer());
      struct.setSitliclimitedef(getgxTv_SdtEstado_Sitliclimitedef());
      struct.setSitlicadjundef(getgxTv_SdtEstado_Sitlicadjundef());
      struct.setSitlicadjobldef(getgxTv_SdtEstado_Sitlicadjobldef());
      struct.setSitlicnecapr(getgxTv_SdtEstado_Sitlicnecapr());
      struct.setSitlicingmot(getgxTv_SdtEstado_Sitlicingmot());
      struct.setSitlicoblingmot(getgxTv_SdtEstado_Sitlicoblingmot());
      struct.setSitpaicod(getgxTv_SdtEstado_Sitpaicod());
      struct.setEstadositrevista(getgxTv_SdtEstado_Estadositrevista());
      struct.setEstadosiniestro(getgxTv_SdtEstado_Estadosiniestro());
      struct.setEstadocanpresen(getgxTv_SdtEstado_Estadocanpresen());
      struct.setEstadoremcorr(getgxTv_SdtEstado_Estadoremcorr());
      struct.setMode(getgxTv_SdtEstado_Mode());
      struct.setInitialized(getgxTv_SdtEstado_Initialized());
      struct.setSitcodigo_Z(getgxTv_SdtEstado_Sitcodigo_Z());
      struct.setSitdescrip_Z(getgxTv_SdtEstado_Sitdescrip_Z());
      struct.setSitdescripsinac_Z(getgxTv_SdtEstado_Sitdescripsinac_Z());
      struct.setSiteslicencia_Z(getgxTv_SdtEstado_Siteslicencia_Z());
      struct.setSitliccuentatrab_Z(getgxTv_SdtEstado_Sitliccuentatrab_Z());
      struct.setSitlicmesesprom_Z(getgxTv_SdtEstado_Sitlicmesesprom_Z());
      struct.setSitlicmesesprom2_Z(getgxTv_SdtEstado_Sitlicmesesprom2_Z());
      struct.setSitdescabrev_Z(getgxTv_SdtEstado_Sitdescabrev_Z());
      struct.setSitdiasdivision_Z(getgxTv_SdtEstado_Sitdiasdivision_Z());
      struct.setSitesausencia_Z(getgxTv_SdtEstado_Sitesausencia_Z());
      struct.setSitaplicaplus_Z(getgxTv_SdtEstado_Sitaplicaplus_Z());
      struct.setSitabsorbefer_Z(getgxTv_SdtEstado_Sitabsorbefer_Z());
      struct.setSitliclimitedef_Z(getgxTv_SdtEstado_Sitliclimitedef_Z());
      struct.setSitlicadjundef_Z(getgxTv_SdtEstado_Sitlicadjundef_Z());
      struct.setSitlicadjobldef_Z(getgxTv_SdtEstado_Sitlicadjobldef_Z());
      struct.setSitlicnecapr_Z(getgxTv_SdtEstado_Sitlicnecapr_Z());
      struct.setSitlicingmot_Z(getgxTv_SdtEstado_Sitlicingmot_Z());
      struct.setSitlicoblingmot_Z(getgxTv_SdtEstado_Sitlicoblingmot_Z());
      struct.setSitpaicod_Z(getgxTv_SdtEstado_Sitpaicod_Z());
      struct.setEstadositrevista_Z(getgxTv_SdtEstado_Estadositrevista_Z());
      struct.setEstadosiniestro_Z(getgxTv_SdtEstado_Estadosiniestro_Z());
      struct.setEstadocanpresen_Z(getgxTv_SdtEstado_Estadocanpresen_Z());
      struct.setEstadoremcorr_Z(getgxTv_SdtEstado_Estadoremcorr_Z());
      struct.setSitpaicod_N(getgxTv_SdtEstado_Sitpaicod_N());
      struct.setEstadositrevista_N(getgxTv_SdtEstado_Estadositrevista_N());
      struct.setEstadosiniestro_N(getgxTv_SdtEstado_Estadosiniestro_N());
      return struct ;
   }

   private byte gxTv_SdtEstado_N ;
   private byte gxTv_SdtEstado_Sitlicmesesprom ;
   private byte gxTv_SdtEstado_Sitlicmesesprom2 ;
   private byte gxTv_SdtEstado_Sitaplicaplus ;
   private byte gxTv_SdtEstado_Sitlicmesesprom_Z ;
   private byte gxTv_SdtEstado_Sitlicmesesprom2_Z ;
   private byte gxTv_SdtEstado_Sitaplicaplus_Z ;
   private byte gxTv_SdtEstado_Sitpaicod_N ;
   private byte gxTv_SdtEstado_Estadositrevista_N ;
   private byte gxTv_SdtEstado_Estadosiniestro_N ;
   private short gxTv_SdtEstado_Sitliclimitedef ;
   private short gxTv_SdtEstado_Sitpaicod ;
   private short gxTv_SdtEstado_Estadositrevista ;
   private short gxTv_SdtEstado_Initialized ;
   private short gxTv_SdtEstado_Sitliclimitedef_Z ;
   private short gxTv_SdtEstado_Sitpaicod_Z ;
   private short gxTv_SdtEstado_Estadositrevista_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtEstado_Sitdiasdivision ;
   private java.math.BigDecimal gxTv_SdtEstado_Sitdiasdivision_Z ;
   private String gxTv_SdtEstado_Sitcodigo ;
   private String gxTv_SdtEstado_Estadosiniestro ;
   private String gxTv_SdtEstado_Mode ;
   private String gxTv_SdtEstado_Sitcodigo_Z ;
   private String gxTv_SdtEstado_Estadosiniestro_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEstado_Siteslicencia ;
   private boolean gxTv_SdtEstado_Sitliccuentatrab ;
   private boolean gxTv_SdtEstado_Sitesausencia ;
   private boolean gxTv_SdtEstado_Sitabsorbefer ;
   private boolean gxTv_SdtEstado_Sitlicadjundef ;
   private boolean gxTv_SdtEstado_Sitlicadjobldef ;
   private boolean gxTv_SdtEstado_Sitlicnecapr ;
   private boolean gxTv_SdtEstado_Sitlicingmot ;
   private boolean gxTv_SdtEstado_Sitlicoblingmot ;
   private boolean gxTv_SdtEstado_Estadocanpresen ;
   private boolean gxTv_SdtEstado_Estadoremcorr ;
   private boolean gxTv_SdtEstado_Siteslicencia_Z ;
   private boolean gxTv_SdtEstado_Sitliccuentatrab_Z ;
   private boolean gxTv_SdtEstado_Sitesausencia_Z ;
   private boolean gxTv_SdtEstado_Sitabsorbefer_Z ;
   private boolean gxTv_SdtEstado_Sitlicadjundef_Z ;
   private boolean gxTv_SdtEstado_Sitlicadjobldef_Z ;
   private boolean gxTv_SdtEstado_Sitlicnecapr_Z ;
   private boolean gxTv_SdtEstado_Sitlicingmot_Z ;
   private boolean gxTv_SdtEstado_Sitlicoblingmot_Z ;
   private boolean gxTv_SdtEstado_Estadocanpresen_Z ;
   private boolean gxTv_SdtEstado_Estadoremcorr_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEstado_Sitdescrip ;
   private String gxTv_SdtEstado_Sitdescripsinac ;
   private String gxTv_SdtEstado_Sitdescabrev ;
   private String gxTv_SdtEstado_Sitdescrip_Z ;
   private String gxTv_SdtEstado_Sitdescripsinac_Z ;
   private String gxTv_SdtEstado_Sitdescabrev_Z ;
}

