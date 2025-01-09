package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_liquidacion_detalle extends GxSilentTrnSdt
{
   public Sdtimportacion_liquidacion_detalle( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtimportacion_liquidacion_detalle.class));
   }

   public Sdtimportacion_liquidacion_detalle( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_liquidacion_detalle");
      initialize( remoteHandle) ;
   }

   public Sdtimportacion_liquidacion_detalle( int remoteHandle ,
                                              StructSdtimportacion_liquidacion_detalle struct )
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
                     short AV88ImpLiqSec ,
                     short AV90ImpLiqDetSec )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Short.valueOf(AV88ImpLiqSec),Short.valueOf(AV90ImpLiqDetSec)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"ImpLiqSec", short.class}, new Object[]{"ImpLiqDetSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "importacion_liquidacion_detalle");
      metadata.set("BT", "importacion_liquidacion_detalle");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\",\"ImpLiqDetSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"ImpLiqSec\" ],\"FKMap\":[  ] } ]");
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
               gxTv_Sdtimportacion_liquidacion_detalle_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSec") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetPer") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLiqN") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCUIL") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLegId") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCBU") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConCod") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConYDes") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCant") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetUni") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetImp") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSigno") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConyu") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetHijos") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCCT") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSCVO") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetError") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLegSis") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConSis") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConSisYDes") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCantNum") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetImpNum") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLiqClase") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetTipoCon") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqSec_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSec_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetPer_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLiqN_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCUIL_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLegId_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCBU_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConCod_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConYDes_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCant_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetUni_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetImp_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSigno_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConyu_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetHijos_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCCT_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetSCVO_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetError_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLegSis_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConSis_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetConSisYDes_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetCantNum_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetImpNum_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetLiqClase_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetTipoCon_Z") )
            {
               gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z = oReader.getValue() ;
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
         sName = "importacion_liquidacion_detalle" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetSec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetPer", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetLiqN", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetCUIL", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetLegId", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetCBU", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetConCod", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetConYDes", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetCant", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetUni", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetImp", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetSigno", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetConyu", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetHijos", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetCCT", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetSCVO", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetError", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetLegSis", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetConSis", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetConSisYDes", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetCantNum", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum, 6, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetImpNum", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetLiqClase", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ImpLiqDetTipoCon", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtimportacion_liquidacion_detalle_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetPer_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetLiqN_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetCUIL_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetLegId_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetCBU_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetConCod_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetConYDes_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetCant_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetUni_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetImp_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetSigno_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetConyu_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetHijos_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetCCT_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetSCVO_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetError_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetLegSis_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetConSis_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetConSisYDes_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetCantNum_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z, 6, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetImpNum_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z, 16, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetLiqClase_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ImpLiqDetTipoCon_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z);
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
      AddObjectProperty("CliCod", gxTv_Sdtimportacion_liquidacion_detalle_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_Sdtimportacion_liquidacion_detalle_Empcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqSec", gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetSec", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetPer", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetLiqN", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetCUIL", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetLegId", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetCBU", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetConCod", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetConYDes", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetCant", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetUni", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetImp", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetSigno", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetConyu", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetHijos", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetCCT", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetSCVO", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetError", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetLegSis", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetConSis", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetConSisYDes", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetCantNum", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetImpNum", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum, 16, 2)), false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetLiqClase", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase, false, includeNonInitialized);
      AddObjectProperty("ImpLiqDetTipoCon", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtimportacion_liquidacion_detalle_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtimportacion_liquidacion_detalle_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqSec_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetSec_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetPer_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetLiqN_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetCUIL_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetLegId_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetCBU_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetConCod_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetConYDes_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetCant_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetUni_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetImp_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetSigno_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetConyu_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetHijos_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetCCT_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetSCVO_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetError_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetLegSis_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetConSis_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetConSisYDes_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetCantNum_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetImpNum_Z", GXutil.ltrim( GXutil.strNoRound( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z, 16, 2)), false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetLiqClase_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z, false, includeNonInitialized);
         AddObjectProperty("ImpLiqDetTipoCon_Z", gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtimportacion_liquidacion_detalle sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Clicod = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Empcod = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Empcod() ;
      }
      if ( sdt.IsDirty("ImpLiqSec") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec() ;
      }
      if ( sdt.IsDirty("ImpLiqDetSec") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec() ;
      }
      if ( sdt.IsDirty("ImpLiqDetPer") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper() ;
      }
      if ( sdt.IsDirty("ImpLiqDetLiqN") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn() ;
      }
      if ( sdt.IsDirty("ImpLiqDetCUIL") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil() ;
      }
      if ( sdt.IsDirty("ImpLiqDetLegId") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid() ;
      }
      if ( sdt.IsDirty("ImpLiqDetCBU") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu() ;
      }
      if ( sdt.IsDirty("ImpLiqDetConCod") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod() ;
      }
      if ( sdt.IsDirty("ImpLiqDetConYDes") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes() ;
      }
      if ( sdt.IsDirty("ImpLiqDetCant") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant() ;
      }
      if ( sdt.IsDirty("ImpLiqDetUni") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni() ;
      }
      if ( sdt.IsDirty("ImpLiqDetImp") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp() ;
      }
      if ( sdt.IsDirty("ImpLiqDetSigno") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno() ;
      }
      if ( sdt.IsDirty("ImpLiqDetConyu") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu() ;
      }
      if ( sdt.IsDirty("ImpLiqDetHijos") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos() ;
      }
      if ( sdt.IsDirty("ImpLiqDetCCT") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct() ;
      }
      if ( sdt.IsDirty("ImpLiqDetSCVO") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo() ;
      }
      if ( sdt.IsDirty("ImpLiqDetError") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror() ;
      }
      if ( sdt.IsDirty("ImpLiqDetLegSis") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis() ;
      }
      if ( sdt.IsDirty("ImpLiqDetConSis") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis() ;
      }
      if ( sdt.IsDirty("ImpLiqDetConSisYDes") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes() ;
      }
      if ( sdt.IsDirty("ImpLiqDetCantNum") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum() ;
      }
      if ( sdt.IsDirty("ImpLiqDetImpNum") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum() ;
      }
      if ( sdt.IsDirty("ImpLiqDetLiqClase") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase() ;
      }
      if ( sdt.IsDirty("ImpLiqDetTipoCon") )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
         gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon = sdt.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon() ;
      }
   }

   public int getgxTv_Sdtimportacion_liquidacion_detalle_Clicod( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Clicod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Clicod( int value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_detalle_Clicod != value )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_Sdtimportacion_liquidacion_detalle_Clicod = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Empcod( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Empcod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Empcod( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_detalle_Empcod != value )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_Sdtimportacion_liquidacion_detalle_Empcod = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec != value )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z_SetNull( );
      }
      SetDirty("Impliqsec");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec = value ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      if ( gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec != value )
      {
         gxTv_Sdtimportacion_liquidacion_detalle_Mode = "INS" ;
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z_SetNull( );
         this.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z_SetNull( );
      }
      SetDirty("Impliqdetsec");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetper");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetliqn");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcuil");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetlegid");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcbu");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconcod");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconydes");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcant");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetuni");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetimp");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetsigno");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconyu");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdethijos");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcct");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetscvo");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdeterror");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetlegsis");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconsis");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconsisydes");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcantnum");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetimpnum");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetliqclase");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdettipocon");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon = value ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Mode( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Mode ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Mode( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtimportacion_liquidacion_detalle_Mode = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Mode_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Initialized( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Initialized ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Initialized( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtimportacion_liquidacion_detalle_Initialized = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Initialized_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z( int value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqsec_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z = (short)(0) ;
      SetDirty("Impliqsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z( short value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetsec_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z = (short)(0) ;
      SetDirty("Impliqdetsec_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetper_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z = "" ;
      SetDirty("Impliqdetper_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetliqn_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z = "" ;
      SetDirty("Impliqdetliqn_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcuil_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z = "" ;
      SetDirty("Impliqdetcuil_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetlegid_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z = "" ;
      SetDirty("Impliqdetlegid_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcbu_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z = "" ;
      SetDirty("Impliqdetcbu_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconcod_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z = "" ;
      SetDirty("Impliqdetconcod_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconydes_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z = "" ;
      SetDirty("Impliqdetconydes_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcant_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z = "" ;
      SetDirty("Impliqdetcant_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetuni_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z = "" ;
      SetDirty("Impliqdetuni_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetimp_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z = "" ;
      SetDirty("Impliqdetimp_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetsigno_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z = "" ;
      SetDirty("Impliqdetsigno_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconyu_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z = "" ;
      SetDirty("Impliqdetconyu_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdethijos_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z = "" ;
      SetDirty("Impliqdethijos_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcct_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z = "" ;
      SetDirty("Impliqdetcct_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetscvo_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z = "" ;
      SetDirty("Impliqdetscvo_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdeterror_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z = "" ;
      SetDirty("Impliqdeterror_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetlegsis_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z = "" ;
      SetDirty("Impliqdetlegsis_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconsis_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z = "" ;
      SetDirty("Impliqdetconsis_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetconsisydes_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z = "" ;
      SetDirty("Impliqdetconsisydes_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetcantnum_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z = DecimalUtil.ZERO ;
      SetDirty("Impliqdetcantnum_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetimpnum_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z = DecimalUtil.ZERO ;
      SetDirty("Impliqdetimpnum_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdetliqclase_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z = "" ;
      SetDirty("Impliqdetliqclase_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z( String value )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(0) ;
      SetDirty("Impliqdettipocon_Z");
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z = value ;
   }

   public void setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z_SetNull( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z = "" ;
      SetDirty("Impliqdettipocon_Z");
   }

   public boolean getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.importacion_liquidacion_detalle_bc obj;
      obj = new web.importacion_liquidacion_detalle_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_liquidacion_detalle_N = (byte)(1) ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Mode = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z = "" ;
      gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_liquidacion_detalle_N ;
   }

   public web.Sdtimportacion_liquidacion_detalle Clone( )
   {
      web.Sdtimportacion_liquidacion_detalle sdt;
      web.importacion_liquidacion_detalle_bc obj;
      sdt = (web.Sdtimportacion_liquidacion_detalle)(clone()) ;
      obj = (web.importacion_liquidacion_detalle_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtimportacion_liquidacion_detalle struct )
   {
      setgxTv_Sdtimportacion_liquidacion_detalle_Clicod(struct.getClicod());
      setgxTv_Sdtimportacion_liquidacion_detalle_Empcod(struct.getEmpcod());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec(struct.getImpliqsec());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec(struct.getImpliqdetsec());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper(struct.getImpliqdetper());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn(struct.getImpliqdetliqn());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil(struct.getImpliqdetcuil());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid(struct.getImpliqdetlegid());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu(struct.getImpliqdetcbu());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod(struct.getImpliqdetconcod());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes(struct.getImpliqdetconydes());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant(struct.getImpliqdetcant());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni(struct.getImpliqdetuni());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp(struct.getImpliqdetimp());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno(struct.getImpliqdetsigno());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu(struct.getImpliqdetconyu());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos(struct.getImpliqdethijos());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct(struct.getImpliqdetcct());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo(struct.getImpliqdetscvo());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror(struct.getImpliqdeterror());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis(struct.getImpliqdetlegsis());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis(struct.getImpliqdetconsis());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes(struct.getImpliqdetconsisydes());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum(struct.getImpliqdetcantnum());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum(struct.getImpliqdetimpnum());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase(struct.getImpliqdetliqclase());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon(struct.getImpliqdettipocon());
      setgxTv_Sdtimportacion_liquidacion_detalle_Mode(struct.getMode());
      setgxTv_Sdtimportacion_liquidacion_detalle_Initialized(struct.getInitialized());
      setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z(struct.getImpliqsec_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z(struct.getImpliqdetsec_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z(struct.getImpliqdetper_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z(struct.getImpliqdetliqn_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z(struct.getImpliqdetcuil_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z(struct.getImpliqdetlegid_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z(struct.getImpliqdetcbu_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z(struct.getImpliqdetconcod_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z(struct.getImpliqdetconydes_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z(struct.getImpliqdetcant_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z(struct.getImpliqdetuni_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z(struct.getImpliqdetimp_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z(struct.getImpliqdetsigno_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z(struct.getImpliqdetconyu_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z(struct.getImpliqdethijos_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z(struct.getImpliqdetcct_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z(struct.getImpliqdetscvo_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z(struct.getImpliqdeterror_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z(struct.getImpliqdetlegsis_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z(struct.getImpliqdetconsis_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z(struct.getImpliqdetconsisydes_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z(struct.getImpliqdetcantnum_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z(struct.getImpliqdetimpnum_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z(struct.getImpliqdetliqclase_Z());
      setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z(struct.getImpliqdettipocon_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_liquidacion_detalle getStruct( )
   {
      web.StructSdtimportacion_liquidacion_detalle struct = new web.StructSdtimportacion_liquidacion_detalle ();
      struct.setClicod(getgxTv_Sdtimportacion_liquidacion_detalle_Clicod());
      struct.setEmpcod(getgxTv_Sdtimportacion_liquidacion_detalle_Empcod());
      struct.setImpliqsec(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec());
      struct.setImpliqdetsec(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec());
      struct.setImpliqdetper(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper());
      struct.setImpliqdetliqn(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn());
      struct.setImpliqdetcuil(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil());
      struct.setImpliqdetlegid(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid());
      struct.setImpliqdetcbu(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu());
      struct.setImpliqdetconcod(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod());
      struct.setImpliqdetconydes(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes());
      struct.setImpliqdetcant(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant());
      struct.setImpliqdetuni(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni());
      struct.setImpliqdetimp(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp());
      struct.setImpliqdetsigno(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno());
      struct.setImpliqdetconyu(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu());
      struct.setImpliqdethijos(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos());
      struct.setImpliqdetcct(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct());
      struct.setImpliqdetscvo(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo());
      struct.setImpliqdeterror(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror());
      struct.setImpliqdetlegsis(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis());
      struct.setImpliqdetconsis(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis());
      struct.setImpliqdetconsisydes(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes());
      struct.setImpliqdetcantnum(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum());
      struct.setImpliqdetimpnum(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum());
      struct.setImpliqdetliqclase(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase());
      struct.setImpliqdettipocon(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon());
      struct.setMode(getgxTv_Sdtimportacion_liquidacion_detalle_Mode());
      struct.setInitialized(getgxTv_Sdtimportacion_liquidacion_detalle_Initialized());
      struct.setClicod_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z());
      struct.setImpliqsec_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z());
      struct.setImpliqdetsec_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z());
      struct.setImpliqdetper_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z());
      struct.setImpliqdetliqn_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z());
      struct.setImpliqdetcuil_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z());
      struct.setImpliqdetlegid_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z());
      struct.setImpliqdetcbu_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z());
      struct.setImpliqdetconcod_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z());
      struct.setImpliqdetconydes_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z());
      struct.setImpliqdetcant_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z());
      struct.setImpliqdetuni_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z());
      struct.setImpliqdetimp_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z());
      struct.setImpliqdetsigno_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z());
      struct.setImpliqdetconyu_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z());
      struct.setImpliqdethijos_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z());
      struct.setImpliqdetcct_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z());
      struct.setImpliqdetscvo_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z());
      struct.setImpliqdeterror_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z());
      struct.setImpliqdetlegsis_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z());
      struct.setImpliqdetconsis_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z());
      struct.setImpliqdetconsisydes_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z());
      struct.setImpliqdetcantnum_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z());
      struct.setImpliqdetimpnum_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z());
      struct.setImpliqdetliqclase_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z());
      struct.setImpliqdettipocon_Z(getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z());
      return struct ;
   }

   private byte gxTv_Sdtimportacion_liquidacion_detalle_N ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Empcod ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Initialized ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z ;
   private short gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtimportacion_liquidacion_detalle_Clicod ;
   private int gxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z ;
   private java.math.BigDecimal gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum ;
   private java.math.BigDecimal gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum ;
   private java.math.BigDecimal gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z ;
   private java.math.BigDecimal gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Mode ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z ;
   private String gxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z ;
}

