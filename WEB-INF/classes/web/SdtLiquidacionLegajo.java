package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLiquidacionLegajo extends GxSilentTrnSdt
{
   public SdtLiquidacionLegajo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLiquidacionLegajo.class));
   }

   public SdtLiquidacionLegajo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtLiquidacionLegajo");
      initialize( remoteHandle) ;
   }

   public SdtLiquidacionLegajo( int remoteHandle ,
                                StructSdtLiquidacionLegajo struct )
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
                     int AV31LiqNro ,
                     int AV6LegNumero )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV31LiqNro),Integer.valueOf(AV6LegNumero)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LiqNro", int.class}, new Object[]{"LegNumero", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "LiquidacionLegajo");
      metadata.set("BT", "LiquidacionLegajo");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LiqNro\",\"LegNumero\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LiqNro\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"SecCodigo\" ],\"FKMap\":[ \"LiqSecCodigo-SecCodigo\" ] } ]");
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
               gxTv_SdtLiquidacionLegajo_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLiquidacionLegajo_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtLiquidacionLegajo_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_SdtLiquidacionLegajo_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_SdtLiquidacionLegajo_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotal") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSecCodigo") )
            {
               gxTv_SdtLiquidacionLegajo_Liqseccodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSecDescrip") )
            {
               gxTv_SdtLiquidacionLegajo_Liqsecdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegReciboNro") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegrecibonro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId") )
            {
               gxTv_SdtLiquidacionLegajo_Legid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLiqDatosHis") )
            {
               gxTv_SdtLiquidacionLegajo_Legliqdatoshis = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotBruto") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotBruSinSAC") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegCntConc") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegcntconc = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotRemu") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotremu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotNoRemu") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotDescu") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpContr") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpcontr = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpCosto") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpcosto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpOtrDescu") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpDescuNeg") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotRetGan") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpPagosACuen") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotBruProm") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpBasico") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpbasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegGNSI") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleggnsi = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDF") )
            {
               gxTv_SdtLiquidacionLegajo_Liqrutapdf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFVertical") )
            {
               gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LIqLegIteraciones") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegiteraciones = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegSegundos") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegsegundos = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegSegIns") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegsegins = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LieqLegSegUpd") )
            {
               gxTv_SdtLiquidacionLegajo_Lieqlegsegupd = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegError") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegerror = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPeriodo") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqperiodo = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombrePDF") )
            {
               gxTv_SdtLiquidacionLegajo_Liqnombrepdf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombrePDFVertical") )
            {
               gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_SdtLiquidacionLegajo_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegHorasSem") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleghorassem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegAuxEstado") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegauxestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegErrorAux") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegerroraux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegFecEgr") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecegr = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecegr = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegFecIng") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecing = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecing = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegCatCodigo") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegConvenio") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegSueldo") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegsueldo = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegPDFEstado") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegProcesado") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegprocesado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegNivLiq") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegnivliq = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegHtml") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleghtml = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegLSD") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleglsd = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegDaemonUUID") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegFecHor") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfechor = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfechor = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLiquidacionLegajo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLiquidacionLegajo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Legnumero_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotal_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSecCodigo_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSecDescrip_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegReciboNro_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Legid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegLiqDatosHis_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotBruto_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotBruSinSAC_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegCntConc_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotRemu_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotNoRemu_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotDescu_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpContr_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpCosto_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpOtrDescu_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpDescuNeg_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotRetGan_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpPagosACuen_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotBruProm_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpBasico_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegGNSI_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDF_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFVertical_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LIqLegIteraciones_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegSegundos_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegSegIns_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LieqLegSegUpd_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegError_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegerror_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPeriodo_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombrePDF_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombrePDFVertical_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Tliqcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegHorasSem_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegAuxEstado_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegErrorAux_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegFecEgr_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegFecIng_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegCatCodigo_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegConvenio_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegSueldo_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegPDFEstado_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegProcesado_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegNivLiq_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegLSD_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqleglsd_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegDaemonUUID_Z") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegFecHor_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSecCodigo_N") )
            {
               gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId_N") )
            {
               gxTv_SdtLiquidacionLegajo_Legid_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_N") )
            {
               gxTv_SdtLiquidacionLegajo_Tliqcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegPDFEstado_N") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegDaemonUUID_N") )
            {
               gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "LiquidacionLegajo" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtLiquidacionLegajo_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotal", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotal, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSecCodigo", gxTv_SdtLiquidacionLegajo_Liqseccodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSecDescrip", gxTv_SdtLiquidacionLegajo_Liqsecdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegReciboNro", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegrecibonro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegId", gxTv_SdtLiquidacionLegajo_Legid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegLiqDatosHis", gxTv_SdtLiquidacionLegajo_Legliqdatoshis);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotBruto", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotBruSinSAC", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegCntConc", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegcntconc, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotRemu", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotremu, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotNoRemu", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotDescu", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpContr", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpcontr, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpCosto", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpcosto, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpOtrDescu", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpDescuNeg", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotRetGan", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpPagosACuen", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotBruProm", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpBasico", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpbasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegGNSI", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqleggnsi, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRutaPDF", gxTv_SdtLiquidacionLegajo_Liqrutapdf);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRutaPDFVertical", gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LIqLegIteraciones", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegiteraciones, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegSegundos", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegsegundos, 10, 6)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegSegIns", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegsegins, 10, 6)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LieqLegSegUpd", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Lieqlegsegupd, 10, 6)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegError", gxTv_SdtLiquidacionLegajo_Liqlegerror);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqPeriodo", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNombrePDF", gxTv_SdtLiquidacionLegajo_Liqnombrepdf);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNombrePDFVertical", gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCod", gxTv_SdtLiquidacionLegajo_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegHorasSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqleghorassem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegAuxEstado", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegauxestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegErrorAux", gxTv_SdtLiquidacionLegajo_Liqlegerroraux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecegr), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecegr), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecegr), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqLegFecEgr", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecing), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecing), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecing), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqLegFecIng", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegCatCodigo", gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegConvenio", gxTv_SdtLiquidacionLegajo_Liqlegconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegSueldo", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegsueldo, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegPDFEstado", gxTv_SdtLiquidacionLegajo_Liqlegpdfestado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegProcesado", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegprocesado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegNivLiq", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegnivliq, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegHtml", gxTv_SdtLiquidacionLegajo_Liqleghtml);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegLSD", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqleglsd, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegDaemonUUID", gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfechor), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfechor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfechor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLiquidacionLegajo_Liqlegfechor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLiquidacionLegajo_Liqlegfechor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLiquidacionLegajo_Liqlegfechor), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqLegFecHor", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLiquidacionLegajo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtLiquidacionLegajo_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqNro_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqnro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegNumero_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Legnumero_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotal_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSecCodigo_Z", gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSecDescrip_Z", gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegReciboNro_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_Z", gxTv_SdtLiquidacionLegajo_Legid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegLiqDatosHis_Z", gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotBruto_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotBruSinSAC_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegCntConc_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotRemu_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotNoRemu_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotDescu_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpContr_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpCosto_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpOtrDescu_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpDescuNeg_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotRetGan_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpPagosACuen_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpTotBruProm_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegImpBasico_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegGNSI_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRutaPDF_Z", gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRutaPDFVertical_Z", gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LIqLegIteraciones_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegSegundos_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z, 10, 6)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegSegIns_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z, 10, 6)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LieqLegSegUpd_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z, 10, 6)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegError_Z", gxTv_SdtLiquidacionLegajo_Liqlegerror_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPeriodo_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqNombrePDF_Z", gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqNombrePDFVertical_Z", gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_Z", gxTv_SdtLiquidacionLegajo_Tliqcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegHorasSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegAuxEstado_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegErrorAux_Z", gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqLegFecEgr_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqLegFecIng_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegCatCodigo_Z", gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegConvenio_Z", gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegSueldo_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegPDFEstado_Z", gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegProcesado_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegNivLiq_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegLSD_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqleglsd_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegDaemonUUID_Z", gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqLegFecHor_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSecCodigo_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqseccodigo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegId_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Legid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Tliqcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegPDFEstado_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegDaemonUUID_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtLiquidacionLegajo_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLiquidacionLegajo_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtLiquidacionLegajo_Empnom, false, includeNonInitialized);
      AddObjectProperty("LiqNro", gxTv_SdtLiquidacionLegajo_Liqnro, false, includeNonInitialized);
      AddObjectProperty("LegNumero", gxTv_SdtLiquidacionLegajo_Legnumero, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotal", gxTv_SdtLiquidacionLegajo_Liqlegimptotal, false, includeNonInitialized);
      AddObjectProperty("LiqSecCodigo", gxTv_SdtLiquidacionLegajo_Liqseccodigo, false, includeNonInitialized);
      AddObjectProperty("LiqSecCodigo_N", gxTv_SdtLiquidacionLegajo_Liqseccodigo_N, false, includeNonInitialized);
      AddObjectProperty("LiqSecDescrip", gxTv_SdtLiquidacionLegajo_Liqsecdescrip, false, includeNonInitialized);
      AddObjectProperty("LiqLegReciboNro", gxTv_SdtLiquidacionLegajo_Liqlegrecibonro, false, includeNonInitialized);
      AddObjectProperty("LegId", gxTv_SdtLiquidacionLegajo_Legid, false, includeNonInitialized);
      AddObjectProperty("LegId_N", gxTv_SdtLiquidacionLegajo_Legid_N, false, includeNonInitialized);
      AddObjectProperty("LegLiqDatosHis", gxTv_SdtLiquidacionLegajo_Legliqdatoshis, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotBruto", gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotBruSinSAC", gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac, false, includeNonInitialized);
      AddObjectProperty("LiqLegCntConc", gxTv_SdtLiquidacionLegajo_Liqlegcntconc, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotRemu", gxTv_SdtLiquidacionLegajo_Liqlegimptotremu, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotNoRemu", gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotDescu", gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpContr", gxTv_SdtLiquidacionLegajo_Liqlegimpcontr, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpCosto", gxTv_SdtLiquidacionLegajo_Liqlegimpcosto, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpOtrDescu", gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpDescuNeg", gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotRetGan", gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpPagosACuen", gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpTotBruProm", gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom, false, includeNonInitialized);
      AddObjectProperty("LiqLegImpBasico", gxTv_SdtLiquidacionLegajo_Liqlegimpbasico, false, includeNonInitialized);
      AddObjectProperty("LiqLegGNSI", gxTv_SdtLiquidacionLegajo_Liqleggnsi, false, includeNonInitialized);
      AddObjectProperty("LiqRutaPDF", gxTv_SdtLiquidacionLegajo_Liqrutapdf, false, includeNonInitialized);
      AddObjectProperty("LiqRutaPDFVertical", gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical, false, includeNonInitialized);
      AddObjectProperty("LIqLegIteraciones", gxTv_SdtLiquidacionLegajo_Liqlegiteraciones, false, includeNonInitialized);
      AddObjectProperty("LiqLegSegundos", gxTv_SdtLiquidacionLegajo_Liqlegsegundos, false, includeNonInitialized);
      AddObjectProperty("LiqLegSegIns", gxTv_SdtLiquidacionLegajo_Liqlegsegins, false, includeNonInitialized);
      AddObjectProperty("LieqLegSegUpd", gxTv_SdtLiquidacionLegajo_Lieqlegsegupd, false, includeNonInitialized);
      AddObjectProperty("LiqLegError", gxTv_SdtLiquidacionLegajo_Liqlegerror, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPeriodo", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqNombrePDF", gxTv_SdtLiquidacionLegajo_Liqnombrepdf, false, includeNonInitialized);
      AddObjectProperty("LiqNombrePDFVertical", gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical, false, includeNonInitialized);
      AddObjectProperty("TLiqCod", gxTv_SdtLiquidacionLegajo_Tliqcod, false, includeNonInitialized);
      AddObjectProperty("TLiqCod_N", gxTv_SdtLiquidacionLegajo_Tliqcod_N, false, includeNonInitialized);
      AddObjectProperty("LiqLegHorasSem", gxTv_SdtLiquidacionLegajo_Liqleghorassem, false, includeNonInitialized);
      AddObjectProperty("LiqLegAuxEstado", gxTv_SdtLiquidacionLegajo_Liqlegauxestado, false, includeNonInitialized);
      AddObjectProperty("LiqLegErrorAux", gxTv_SdtLiquidacionLegajo_Liqlegerroraux, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecegr), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecegr), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecegr), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqLegFecEgr", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecing), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecing), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecing), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqLegFecIng", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqLegCatCodigo", gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo, false, includeNonInitialized);
      AddObjectProperty("LiqLegConvenio", gxTv_SdtLiquidacionLegajo_Liqlegconvenio, false, includeNonInitialized);
      AddObjectProperty("LiqLegSueldo", gxTv_SdtLiquidacionLegajo_Liqlegsueldo, false, includeNonInitialized);
      AddObjectProperty("LiqLegPDFEstado", gxTv_SdtLiquidacionLegajo_Liqlegpdfestado, false, includeNonInitialized);
      AddObjectProperty("LiqLegPDFEstado_N", gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N, false, includeNonInitialized);
      AddObjectProperty("LiqLegProcesado", gxTv_SdtLiquidacionLegajo_Liqlegprocesado, false, includeNonInitialized);
      AddObjectProperty("LiqLegNivLiq", gxTv_SdtLiquidacionLegajo_Liqlegnivliq, false, includeNonInitialized);
      AddObjectProperty("LiqLegHtml", gxTv_SdtLiquidacionLegajo_Liqleghtml, false, includeNonInitialized);
      AddObjectProperty("LiqLegLSD", gxTv_SdtLiquidacionLegajo_Liqleglsd, false, includeNonInitialized);
      AddObjectProperty("LiqLegDaemonUUID", gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid, false, includeNonInitialized);
      AddObjectProperty("LiqLegDaemonUUID_N", gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtLiquidacionLegajo_Liqlegfechor ;
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
      AddObjectProperty("LiqLegFecHor", sDateCnv, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLiquidacionLegajo_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLiquidacionLegajo_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLiquidacionLegajo_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLiquidacionLegajo_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtLiquidacionLegajo_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("LiqNro_Z", gxTv_SdtLiquidacionLegajo_Liqnro_Z, false, includeNonInitialized);
         AddObjectProperty("LegNumero_Z", gxTv_SdtLiquidacionLegajo_Legnumero_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotal_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z, false, includeNonInitialized);
         AddObjectProperty("LiqSecCodigo_Z", gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LiqSecDescrip_Z", gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegReciboNro_Z", gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z, false, includeNonInitialized);
         AddObjectProperty("LegId_Z", gxTv_SdtLiquidacionLegajo_Legid_Z, false, includeNonInitialized);
         AddObjectProperty("LegLiqDatosHis_Z", gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotBruto_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotBruSinSAC_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegCntConc_Z", gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotRemu_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotNoRemu_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotDescu_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpContr_Z", gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpCosto_Z", gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpOtrDescu_Z", gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpDescuNeg_Z", gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotRetGan_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpPagosACuen_Z", gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpTotBruProm_Z", gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegImpBasico_Z", gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegGNSI_Z", gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z, false, includeNonInitialized);
         AddObjectProperty("LiqRutaPDF_Z", gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z, false, includeNonInitialized);
         AddObjectProperty("LiqRutaPDFVertical_Z", gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z, false, includeNonInitialized);
         AddObjectProperty("LIqLegIteraciones_Z", gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegSegundos_Z", gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegSegIns_Z", gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z, false, includeNonInitialized);
         AddObjectProperty("LieqLegSegUpd_Z", gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegError_Z", gxTv_SdtLiquidacionLegajo_Liqlegerror_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqPeriodo_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqNombrePDF_Z", gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z, false, includeNonInitialized);
         AddObjectProperty("LiqNombrePDFVertical_Z", gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_Z", gxTv_SdtLiquidacionLegajo_Tliqcod_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegHorasSem_Z", gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegAuxEstado_Z", gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegErrorAux_Z", gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqLegFecEgr_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqLegFecIng_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqLegCatCodigo_Z", gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegConvenio_Z", gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegSueldo_Z", gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegPDFEstado_Z", gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegProcesado_Z", gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegNivLiq_Z", gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegLSD_Z", gxTv_SdtLiquidacionLegajo_Liqleglsd_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegDaemonUUID_Z", gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z ;
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
         AddObjectProperty("LiqLegFecHor_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqSecCodigo_N", gxTv_SdtLiquidacionLegajo_Liqseccodigo_N, false, includeNonInitialized);
         AddObjectProperty("LegId_N", gxTv_SdtLiquidacionLegajo_Legid_N, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_N", gxTv_SdtLiquidacionLegajo_Tliqcod_N, false, includeNonInitialized);
         AddObjectProperty("LiqLegPDFEstado_N", gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N, false, includeNonInitialized);
         AddObjectProperty("LiqLegDaemonUUID_N", gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLiquidacionLegajo sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Clicod = sdt.getgxTv_SdtLiquidacionLegajo_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Empcod = sdt.getgxTv_SdtLiquidacionLegajo_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Empnom = sdt.getgxTv_SdtLiquidacionLegajo_Empnom() ;
      }
      if ( sdt.IsDirty("LiqNro") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqnro = sdt.getgxTv_SdtLiquidacionLegajo_Liqnro() ;
      }
      if ( sdt.IsDirty("LegNumero") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Legnumero = sdt.getgxTv_SdtLiquidacionLegajo_Legnumero() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotal") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotal = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotal() ;
      }
      if ( sdt.IsDirty("LiqSecCodigo") )
      {
         gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = sdt.getgxTv_SdtLiquidacionLegajo_Liqseccodigo_N() ;
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqseccodigo = sdt.getgxTv_SdtLiquidacionLegajo_Liqseccodigo() ;
      }
      if ( sdt.IsDirty("LiqSecDescrip") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqsecdescrip = sdt.getgxTv_SdtLiquidacionLegajo_Liqsecdescrip() ;
      }
      if ( sdt.IsDirty("LiqLegReciboNro") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegrecibonro = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro() ;
      }
      if ( sdt.IsDirty("LegId") )
      {
         gxTv_SdtLiquidacionLegajo_Legid_N = sdt.getgxTv_SdtLiquidacionLegajo_Legid_N() ;
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Legid = sdt.getgxTv_SdtLiquidacionLegajo_Legid() ;
      }
      if ( sdt.IsDirty("LegLiqDatosHis") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Legliqdatoshis = sdt.getgxTv_SdtLiquidacionLegajo_Legliqdatoshis() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotBruto") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotBruSinSAC") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac() ;
      }
      if ( sdt.IsDirty("LiqLegCntConc") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegcntconc = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegcntconc() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotRemu") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotremu = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotNoRemu") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotDescu") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu() ;
      }
      if ( sdt.IsDirty("LiqLegImpContr") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimpcontr = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr() ;
      }
      if ( sdt.IsDirty("LiqLegImpCosto") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimpcosto = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto() ;
      }
      if ( sdt.IsDirty("LiqLegImpOtrDescu") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu() ;
      }
      if ( sdt.IsDirty("LiqLegImpDescuNeg") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotRetGan") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan() ;
      }
      if ( sdt.IsDirty("LiqLegImpPagosACuen") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen() ;
      }
      if ( sdt.IsDirty("LiqLegImpTotBruProm") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom() ;
      }
      if ( sdt.IsDirty("LiqLegImpBasico") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegimpbasico = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico() ;
      }
      if ( sdt.IsDirty("LiqLegGNSI") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqleggnsi = sdt.getgxTv_SdtLiquidacionLegajo_Liqleggnsi() ;
      }
      if ( sdt.IsDirty("LiqRutaPDF") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqrutapdf = sdt.getgxTv_SdtLiquidacionLegajo_Liqrutapdf() ;
      }
      if ( sdt.IsDirty("LiqRutaPDFVertical") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical = sdt.getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical() ;
      }
      if ( sdt.IsDirty("LIqLegIteraciones") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegiteraciones = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones() ;
      }
      if ( sdt.IsDirty("LiqLegSegundos") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegsegundos = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegsegundos() ;
      }
      if ( sdt.IsDirty("LiqLegSegIns") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegsegins = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegsegins() ;
      }
      if ( sdt.IsDirty("LieqLegSegUpd") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Lieqlegsegupd = sdt.getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd() ;
      }
      if ( sdt.IsDirty("LiqLegError") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegerror = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegerror() ;
      }
      if ( sdt.IsDirty("LiqPeriodo") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqperiodo = sdt.getgxTv_SdtLiquidacionLegajo_Liqperiodo() ;
      }
      if ( sdt.IsDirty("LiqNombrePDF") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqnombrepdf = sdt.getgxTv_SdtLiquidacionLegajo_Liqnombrepdf() ;
      }
      if ( sdt.IsDirty("LiqNombrePDFVertical") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical = sdt.getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical() ;
      }
      if ( sdt.IsDirty("TLiqCod") )
      {
         gxTv_SdtLiquidacionLegajo_Tliqcod_N = sdt.getgxTv_SdtLiquidacionLegajo_Tliqcod_N() ;
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Tliqcod = sdt.getgxTv_SdtLiquidacionLegajo_Tliqcod() ;
      }
      if ( sdt.IsDirty("LiqLegHorasSem") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqleghorassem = sdt.getgxTv_SdtLiquidacionLegajo_Liqleghorassem() ;
      }
      if ( sdt.IsDirty("LiqLegAuxEstado") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegauxestado = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegauxestado() ;
      }
      if ( sdt.IsDirty("LiqLegErrorAux") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegerroraux = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegerroraux() ;
      }
      if ( sdt.IsDirty("LiqLegFecEgr") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegfecegr = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegfecegr() ;
      }
      if ( sdt.IsDirty("LiqLegFecIng") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegfecing = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegfecing() ;
      }
      if ( sdt.IsDirty("LiqLegCatCodigo") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo() ;
      }
      if ( sdt.IsDirty("LiqLegConvenio") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegconvenio = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegconvenio() ;
      }
      if ( sdt.IsDirty("LiqLegSueldo") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegsueldo = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegsueldo() ;
      }
      if ( sdt.IsDirty("LiqLegPDFEstado") )
      {
         gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N() ;
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado() ;
      }
      if ( sdt.IsDirty("LiqLegProcesado") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegprocesado = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegprocesado() ;
      }
      if ( sdt.IsDirty("LiqLegNivLiq") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegnivliq = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegnivliq() ;
      }
      if ( sdt.IsDirty("LiqLegHtml") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqleghtml = sdt.getgxTv_SdtLiquidacionLegajo_Liqleghtml() ;
      }
      if ( sdt.IsDirty("LiqLegLSD") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqleglsd = sdt.getgxTv_SdtLiquidacionLegajo_Liqleglsd() ;
      }
      if ( sdt.IsDirty("LiqLegDaemonUUID") )
      {
         gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N() ;
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid() ;
      }
      if ( sdt.IsDirty("LiqLegFecHor") )
      {
         gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
         gxTv_SdtLiquidacionLegajo_Liqlegfechor = sdt.getgxTv_SdtLiquidacionLegajo_Liqlegfechor() ;
      }
   }

   public int getgxTv_SdtLiquidacionLegajo_Clicod( )
   {
      return gxTv_SdtLiquidacionLegajo_Clicod ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Clicod( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacionLegajo_Clicod != value )
      {
         gxTv_SdtLiquidacionLegajo_Mode = "INS" ;
         this.setgxTv_SdtLiquidacionLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtLiquidacionLegajo_Clicod = value ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Empcod( )
   {
      return gxTv_SdtLiquidacionLegajo_Empcod ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Empcod( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacionLegajo_Empcod != value )
      {
         gxTv_SdtLiquidacionLegajo_Mode = "INS" ;
         this.setgxTv_SdtLiquidacionLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtLiquidacionLegajo_Empcod = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Empnom( )
   {
      return gxTv_SdtLiquidacionLegajo_Empnom ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Empnom( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtLiquidacionLegajo_Empnom = value ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Liqnro( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnro ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnro( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacionLegajo_Liqnro != value )
      {
         gxTv_SdtLiquidacionLegajo_Mode = "INS" ;
         this.setgxTv_SdtLiquidacionLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z_SetNull( );
      }
      SetDirty("Liqnro");
      gxTv_SdtLiquidacionLegajo_Liqnro = value ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Legnumero( )
   {
      return gxTv_SdtLiquidacionLegajo_Legnumero ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legnumero( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacionLegajo_Legnumero != value )
      {
         gxTv_SdtLiquidacionLegajo_Mode = "INS" ;
         this.setgxTv_SdtLiquidacionLegajo_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legnumero_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z_SetNull( );
         this.setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z_SetNull( );
      }
      SetDirty("Legnumero");
      gxTv_SdtLiquidacionLegajo_Legnumero = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotal( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotal ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotal( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotal");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqseccodigo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqseccodigo ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqseccodigo( String value )
   {
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqseccodigo");
      gxTv_SdtLiquidacionLegajo_Liqseccodigo = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqseccodigo_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo = "" ;
      SetDirty("Liqseccodigo");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqseccodigo_IsNull( )
   {
      return (gxTv_SdtLiquidacionLegajo_Liqseccodigo_N==1) ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqsecdescrip( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqsecdescrip ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqsecdescrip( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqsecdescrip");
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip = value ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegrecibonro ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegrecibonro");
      gxTv_SdtLiquidacionLegajo_Liqlegrecibonro = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Legid( )
   {
      return gxTv_SdtLiquidacionLegajo_Legid ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legid( String value )
   {
      gxTv_SdtLiquidacionLegajo_Legid_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Legid");
      gxTv_SdtLiquidacionLegajo_Legid = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legid_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Legid_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Legid = "" ;
      SetDirty("Legid");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Legid_IsNull( )
   {
      return (gxTv_SdtLiquidacionLegajo_Legid_N==1) ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Legliqdatoshis( )
   {
      return gxTv_SdtLiquidacionLegajo_Legliqdatoshis ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legliqdatoshis( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Legliqdatoshis");
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotbruto");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotbrusinsac");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac = value ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Liqlegcntconc( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcntconc ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegcntconc( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegcntconc");
      gxTv_SdtLiquidacionLegajo_Liqlegcntconc = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotremu ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotremu");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotnoremu");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotdescu");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcontr ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpcontr");
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcosto ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpcosto");
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpotrdescu");
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpdescuneg");
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotretgan");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimppagosacuen");
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotbruprom");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpbasico ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpbasico");
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqleggnsi( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleggnsi ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleggnsi( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleggnsi");
      gxTv_SdtLiquidacionLegajo_Liqleggnsi = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqrutapdf( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdf ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqrutapdf( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqrutapdf");
      gxTv_SdtLiquidacionLegajo_Liqrutapdf = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqrutapdfvertical");
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical = value ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegiteraciones ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegiteraciones");
      gxTv_SdtLiquidacionLegajo_Liqlegiteraciones = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegsegundos( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegundos ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsegundos( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegsegundos");
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegsegins( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegins ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsegins( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegsegins");
      gxTv_SdtLiquidacionLegajo_Liqlegsegins = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd( )
   {
      return gxTv_SdtLiquidacionLegajo_Lieqlegsegupd ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Lieqlegsegupd");
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegerror( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerror ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegerror( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegerror");
      gxTv_SdtLiquidacionLegajo_Liqlegerror = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqperiodo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqperiodo ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqperiodo( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqperiodo");
      gxTv_SdtLiquidacionLegajo_Liqperiodo = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqnombrepdf( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdf ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnombrepdf( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqnombrepdf");
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqnombrepdfvertical");
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Tliqcod( )
   {
      return gxTv_SdtLiquidacionLegajo_Tliqcod ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Tliqcod( String value )
   {
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Tliqcod");
      gxTv_SdtLiquidacionLegajo_Tliqcod = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Tliqcod_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Tliqcod = "" ;
      SetDirty("Tliqcod");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Tliqcod_IsNull( )
   {
      return (gxTv_SdtLiquidacionLegajo_Tliqcod_N==1) ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqleghorassem( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleghorassem ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleghorassem( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleghorassem");
      gxTv_SdtLiquidacionLegajo_Liqleghorassem = value ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegauxestado( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegauxestado ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegauxestado( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegauxestado");
      gxTv_SdtLiquidacionLegajo_Liqlegauxestado = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegerroraux( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerroraux ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegerroraux( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegerroraux");
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqlegfecegr( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecegr ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfecegr( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegfecegr");
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqlegfecing( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecing ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfecing( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegfecing");
      gxTv_SdtLiquidacionLegajo_Liqlegfecing = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegcatcodigo");
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegconvenio( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegconvenio ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegconvenio( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegconvenio");
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegsueldo( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsueldo ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsueldo( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegsueldo");
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegpdfestado ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado( String value )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegpdfestado");
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = "" ;
      SetDirty("Liqlegpdfestado");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_IsNull( )
   {
      return (gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N==1) ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegprocesado( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegprocesado ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegprocesado( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegprocesado");
      gxTv_SdtLiquidacionLegajo_Liqlegprocesado = value ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegnivliq( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegnivliq ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegnivliq( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegnivliq");
      gxTv_SdtLiquidacionLegajo_Liqlegnivliq = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqleghtml( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleghtml ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleghtml( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleghtml");
      gxTv_SdtLiquidacionLegajo_Liqleghtml = value ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqleglsd( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleglsd ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleglsd( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleglsd");
      gxTv_SdtLiquidacionLegajo_Liqleglsd = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid( String value )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = (byte)(0) ;
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegdaemonuuid");
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = "" ;
      SetDirty("Liqlegdaemonuuid");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_IsNull( )
   {
      return (gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N==1) ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqlegfechor( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfechor ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfechor( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegfechor");
      gxTv_SdtLiquidacionLegajo_Liqlegfechor = value ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Mode( )
   {
      return gxTv_SdtLiquidacionLegajo_Mode ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Mode( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLiquidacionLegajo_Mode = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Mode_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Initialized( )
   {
      return gxTv_SdtLiquidacionLegajo_Initialized ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Initialized( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLiquidacionLegajo_Initialized = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Initialized_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Clicod_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Clicod_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Clicod_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLiquidacionLegajo_Clicod_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Clicod_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Empcod_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Empcod_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Empcod_Z( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLiquidacionLegajo_Empcod_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Empcod_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Empnom_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Empnom_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Empnom_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtLiquidacionLegajo_Empnom_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Empnom_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Liqnro_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnro_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnro_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqnro_Z");
      gxTv_SdtLiquidacionLegajo_Liqnro_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnro_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqnro_Z = 0 ;
      SetDirty("Liqnro_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqnro_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Legnumero_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Legnumero_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legnumero_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Legnumero_Z");
      gxTv_SdtLiquidacionLegajo_Legnumero_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legnumero_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Legnumero_Z = 0 ;
      SetDirty("Legnumero_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Legnumero_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotal_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotal_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqseccodigo_Z");
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z = "" ;
      SetDirty("Liqseccodigo_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqsecdescrip_Z");
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z = "" ;
      SetDirty("Liqsecdescrip_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z( int value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegrecibonro_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z = 0 ;
      SetDirty("Liqlegrecibonro_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Legid_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Legid_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legid_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Legid_Z");
      gxTv_SdtLiquidacionLegajo_Legid_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legid_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Legid_Z = "" ;
      SetDirty("Legid_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Legid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Legliqdatoshis_Z");
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z = "" ;
      SetDirty("Legliqdatoshis_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotbruto_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotbruto_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotbrusinsac_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotbrusinsac_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegcntconc_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z = (short)(0) ;
      SetDirty("Liqlegcntconc_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotremu_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotremu_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotnoremu_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotnoremu_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotdescu_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotdescu_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpcontr_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimpcontr_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpcosto_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimpcosto_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpotrdescu_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimpotrdescu_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpdescuneg_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimpdescuneg_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotretgan_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotretgan_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimppagosacuen_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimppagosacuen_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimptotbruprom_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimptotbruprom_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegimpbasico_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegimpbasico_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleggnsi_Z");
      gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z = DecimalUtil.ZERO ;
      SetDirty("Liqleggnsi_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqrutapdf_Z");
      gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z = "" ;
      SetDirty("Liqrutapdf_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqrutapdfvertical_Z");
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z = "" ;
      SetDirty("Liqrutapdfvertical_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z( short value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegiteraciones_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z = (short)(0) ;
      SetDirty("Liqlegiteraciones_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegsegundos_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegsegundos_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegsegins_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegsegins_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Lieqlegsegupd_Z");
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z = DecimalUtil.ZERO ;
      SetDirty("Lieqlegsegupd_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegerror_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerror_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegerror_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegerror_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegerror_Z = "" ;
      SetDirty("Liqlegerror_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegerror_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqperiodo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqperiodo_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqperiodo_Z");
      gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = GXutil.nullDate() ;
      SetDirty("Liqperiodo_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqperiodo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqnombrepdf_Z");
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z = "" ;
      SetDirty("Liqnombrepdf_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqnombrepdfvertical_Z");
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z = "" ;
      SetDirty("Liqnombrepdfvertical_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Tliqcod_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Tliqcod_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Tliqcod_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Tliqcod_Z");
      gxTv_SdtLiquidacionLegajo_Tliqcod_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Tliqcod_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Tliqcod_Z = "" ;
      SetDirty("Tliqcod_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Tliqcod_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleghorassem_Z");
      gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z = DecimalUtil.ZERO ;
      SetDirty("Liqleghorassem_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegauxestado_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z = (byte)(0) ;
      SetDirty("Liqlegauxestado_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegerroraux_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z = "" ;
      SetDirty("Liqlegerroraux_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegfecegr_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = GXutil.nullDate() ;
      SetDirty("Liqlegfecegr_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegfecing_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = GXutil.nullDate() ;
      SetDirty("Liqlegfecing_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegcatcodigo_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z = "" ;
      SetDirty("Liqlegcatcodigo_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegconvenio_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z = "" ;
      SetDirty("Liqlegconvenio_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegsueldo_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z = DecimalUtil.ZERO ;
      SetDirty("Liqlegsueldo_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegpdfestado_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z = "" ;
      SetDirty("Liqlegpdfestado_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegprocesado_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z = (byte)(0) ;
      SetDirty("Liqlegprocesado_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegnivliq_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z = (byte)(0) ;
      SetDirty("Liqlegnivliq_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqleglsd_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqleglsd_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqleglsd_Z");
      gxTv_SdtLiquidacionLegajo_Liqleglsd_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqleglsd_Z = (byte)(0) ;
      SetDirty("Liqleglsd_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqleglsd_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z( String value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegdaemonuuid_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z = "" ;
      SetDirty("Liqlegdaemonuuid_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegfechor_Z");
      gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Liqlegfechor_Z");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqseccodigo_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqseccodigo_N ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqseccodigo_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqseccodigo_N");
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqseccodigo_N_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_N = (byte)(0) ;
      SetDirty("Liqseccodigo_N");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqseccodigo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Legid_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Legid_N ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legid_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Legid_N");
      gxTv_SdtLiquidacionLegajo_Legid_N = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Legid_N_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Legid_N = (byte)(0) ;
      SetDirty("Legid_N");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Legid_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Tliqcod_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Tliqcod_N ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Tliqcod_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Tliqcod_N");
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Tliqcod_N_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Tliqcod_N = (byte)(0) ;
      SetDirty("Tliqcod_N");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Tliqcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegpdfestado_N");
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N = (byte)(0) ;
      SetDirty("Liqlegpdfestado_N");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N( )
   {
      return gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N( byte value )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(0) ;
      SetDirty("Liqlegdaemonuuid_N");
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = value ;
   }

   public void setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N_SetNull( )
   {
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N = (byte)(0) ;
      SetDirty("Liqlegdaemonuuid_N");
   }

   public boolean getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.liquidacionlegajo_bc obj;
      obj = new web.liquidacionlegajo_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLiquidacionLegajo_N = (byte)(1) ;
      gxTv_SdtLiquidacionLegajo_Empnom = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo = "" ;
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip = "" ;
      gxTv_SdtLiquidacionLegajo_Legid = "" ;
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqleggnsi = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdf = "" ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegins = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegerror = "" ;
      gxTv_SdtLiquidacionLegajo_Liqperiodo = GXutil.nullDate() ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf = "" ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical = "" ;
      gxTv_SdtLiquidacionLegajo_Tliqcod = "" ;
      gxTv_SdtLiquidacionLegajo_Liqleghorassem = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr = GXutil.nullDate() ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecing = GXutil.nullDate() ;
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado = "" ;
      gxTv_SdtLiquidacionLegajo_Liqleghtml = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfechor = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLiquidacionLegajo_Mode = "" ;
      gxTv_SdtLiquidacionLegajo_Empnom_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Legid_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegerror_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqperiodo_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Tliqcod_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z = "" ;
      gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z = GXutil.resetTime( GXutil.nullDate() );
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtLiquidacionLegajo_N ;
   }

   public web.SdtLiquidacionLegajo Clone( )
   {
      web.SdtLiquidacionLegajo sdt;
      web.liquidacionlegajo_bc obj;
      sdt = (web.SdtLiquidacionLegajo)(clone()) ;
      obj = (web.liquidacionlegajo_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLiquidacionLegajo struct )
   {
      setgxTv_SdtLiquidacionLegajo_Clicod(struct.getClicod());
      setgxTv_SdtLiquidacionLegajo_Empcod(struct.getEmpcod());
      setgxTv_SdtLiquidacionLegajo_Empnom(struct.getEmpnom());
      setgxTv_SdtLiquidacionLegajo_Liqnro(struct.getLiqnro());
      setgxTv_SdtLiquidacionLegajo_Legnumero(struct.getLegnumero());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotal(struct.getLiqlegimptotal());
      setgxTv_SdtLiquidacionLegajo_Liqseccodigo(struct.getLiqseccodigo());
      setgxTv_SdtLiquidacionLegajo_Liqsecdescrip(struct.getLiqsecdescrip());
      setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro(struct.getLiqlegrecibonro());
      setgxTv_SdtLiquidacionLegajo_Legid(struct.getLegid());
      setgxTv_SdtLiquidacionLegajo_Legliqdatoshis(struct.getLegliqdatoshis());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto(struct.getLiqlegimptotbruto());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac(struct.getLiqlegimptotbrusinsac());
      setgxTv_SdtLiquidacionLegajo_Liqlegcntconc(struct.getLiqlegcntconc());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu(struct.getLiqlegimptotremu());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu(struct.getLiqlegimptotnoremu());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu(struct.getLiqlegimptotdescu());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr(struct.getLiqlegimpcontr());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto(struct.getLiqlegimpcosto());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu(struct.getLiqlegimpotrdescu());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg(struct.getLiqlegimpdescuneg());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan(struct.getLiqlegimptotretgan());
      setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen(struct.getLiqlegimppagosacuen());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom(struct.getLiqlegimptotbruprom());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico(struct.getLiqlegimpbasico());
      setgxTv_SdtLiquidacionLegajo_Liqleggnsi(struct.getLiqleggnsi());
      setgxTv_SdtLiquidacionLegajo_Liqrutapdf(struct.getLiqrutapdf());
      setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical(struct.getLiqrutapdfvertical());
      setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones(struct.getLiqlegiteraciones());
      setgxTv_SdtLiquidacionLegajo_Liqlegsegundos(struct.getLiqlegsegundos());
      setgxTv_SdtLiquidacionLegajo_Liqlegsegins(struct.getLiqlegsegins());
      setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd(struct.getLieqlegsegupd());
      setgxTv_SdtLiquidacionLegajo_Liqlegerror(struct.getLiqlegerror());
      setgxTv_SdtLiquidacionLegajo_Liqperiodo(struct.getLiqperiodo());
      setgxTv_SdtLiquidacionLegajo_Liqnombrepdf(struct.getLiqnombrepdf());
      setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical(struct.getLiqnombrepdfvertical());
      setgxTv_SdtLiquidacionLegajo_Tliqcod(struct.getTliqcod());
      setgxTv_SdtLiquidacionLegajo_Liqleghorassem(struct.getLiqleghorassem());
      setgxTv_SdtLiquidacionLegajo_Liqlegauxestado(struct.getLiqlegauxestado());
      setgxTv_SdtLiquidacionLegajo_Liqlegerroraux(struct.getLiqlegerroraux());
      setgxTv_SdtLiquidacionLegajo_Liqlegfecegr(struct.getLiqlegfecegr());
      setgxTv_SdtLiquidacionLegajo_Liqlegfecing(struct.getLiqlegfecing());
      setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo(struct.getLiqlegcatcodigo());
      setgxTv_SdtLiquidacionLegajo_Liqlegconvenio(struct.getLiqlegconvenio());
      setgxTv_SdtLiquidacionLegajo_Liqlegsueldo(struct.getLiqlegsueldo());
      setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado(struct.getLiqlegpdfestado());
      setgxTv_SdtLiquidacionLegajo_Liqlegprocesado(struct.getLiqlegprocesado());
      setgxTv_SdtLiquidacionLegajo_Liqlegnivliq(struct.getLiqlegnivliq());
      setgxTv_SdtLiquidacionLegajo_Liqleghtml(struct.getLiqleghtml());
      setgxTv_SdtLiquidacionLegajo_Liqleglsd(struct.getLiqleglsd());
      setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid(struct.getLiqlegdaemonuuid());
      setgxTv_SdtLiquidacionLegajo_Liqlegfechor(struct.getLiqlegfechor());
      setgxTv_SdtLiquidacionLegajo_Mode(struct.getMode());
      setgxTv_SdtLiquidacionLegajo_Initialized(struct.getInitialized());
      setgxTv_SdtLiquidacionLegajo_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLiquidacionLegajo_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLiquidacionLegajo_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtLiquidacionLegajo_Liqnro_Z(struct.getLiqnro_Z());
      setgxTv_SdtLiquidacionLegajo_Legnumero_Z(struct.getLegnumero_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z(struct.getLiqlegimptotal_Z());
      setgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z(struct.getLiqseccodigo_Z());
      setgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z(struct.getLiqsecdescrip_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z(struct.getLiqlegrecibonro_Z());
      setgxTv_SdtLiquidacionLegajo_Legid_Z(struct.getLegid_Z());
      setgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z(struct.getLegliqdatoshis_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z(struct.getLiqlegimptotbruto_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z(struct.getLiqlegimptotbrusinsac_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z(struct.getLiqlegcntconc_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z(struct.getLiqlegimptotremu_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z(struct.getLiqlegimptotnoremu_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z(struct.getLiqlegimptotdescu_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z(struct.getLiqlegimpcontr_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z(struct.getLiqlegimpcosto_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z(struct.getLiqlegimpotrdescu_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z(struct.getLiqlegimpdescuneg_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z(struct.getLiqlegimptotretgan_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z(struct.getLiqlegimppagosacuen_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z(struct.getLiqlegimptotbruprom_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z(struct.getLiqlegimpbasico_Z());
      setgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z(struct.getLiqleggnsi_Z());
      setgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z(struct.getLiqrutapdf_Z());
      setgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z(struct.getLiqrutapdfvertical_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z(struct.getLiqlegiteraciones_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z(struct.getLiqlegsegundos_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z(struct.getLiqlegsegins_Z());
      setgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z(struct.getLieqlegsegupd_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegerror_Z(struct.getLiqlegerror_Z());
      setgxTv_SdtLiquidacionLegajo_Liqperiodo_Z(struct.getLiqperiodo_Z());
      setgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z(struct.getLiqnombrepdf_Z());
      setgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z(struct.getLiqnombrepdfvertical_Z());
      setgxTv_SdtLiquidacionLegajo_Tliqcod_Z(struct.getTliqcod_Z());
      setgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z(struct.getLiqleghorassem_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z(struct.getLiqlegauxestado_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z(struct.getLiqlegerroraux_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z(struct.getLiqlegfecegr_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z(struct.getLiqlegfecing_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z(struct.getLiqlegcatcodigo_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z(struct.getLiqlegconvenio_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z(struct.getLiqlegsueldo_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z(struct.getLiqlegpdfestado_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z(struct.getLiqlegprocesado_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z(struct.getLiqlegnivliq_Z());
      setgxTv_SdtLiquidacionLegajo_Liqleglsd_Z(struct.getLiqleglsd_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z(struct.getLiqlegdaemonuuid_Z());
      setgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z(struct.getLiqlegfechor_Z());
      setgxTv_SdtLiquidacionLegajo_Liqseccodigo_N(struct.getLiqseccodigo_N());
      setgxTv_SdtLiquidacionLegajo_Legid_N(struct.getLegid_N());
      setgxTv_SdtLiquidacionLegajo_Tliqcod_N(struct.getTliqcod_N());
      setgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N(struct.getLiqlegpdfestado_N());
      setgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N(struct.getLiqlegdaemonuuid_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLiquidacionLegajo getStruct( )
   {
      web.StructSdtLiquidacionLegajo struct = new web.StructSdtLiquidacionLegajo ();
      struct.setClicod(getgxTv_SdtLiquidacionLegajo_Clicod());
      struct.setEmpcod(getgxTv_SdtLiquidacionLegajo_Empcod());
      struct.setEmpnom(getgxTv_SdtLiquidacionLegajo_Empnom());
      struct.setLiqnro(getgxTv_SdtLiquidacionLegajo_Liqnro());
      struct.setLegnumero(getgxTv_SdtLiquidacionLegajo_Legnumero());
      struct.setLiqlegimptotal(getgxTv_SdtLiquidacionLegajo_Liqlegimptotal());
      struct.setLiqseccodigo(getgxTv_SdtLiquidacionLegajo_Liqseccodigo());
      struct.setLiqsecdescrip(getgxTv_SdtLiquidacionLegajo_Liqsecdescrip());
      struct.setLiqlegrecibonro(getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro());
      struct.setLegid(getgxTv_SdtLiquidacionLegajo_Legid());
      struct.setLegliqdatoshis(getgxTv_SdtLiquidacionLegajo_Legliqdatoshis());
      struct.setLiqlegimptotbruto(getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto());
      struct.setLiqlegimptotbrusinsac(getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac());
      struct.setLiqlegcntconc(getgxTv_SdtLiquidacionLegajo_Liqlegcntconc());
      struct.setLiqlegimptotremu(getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu());
      struct.setLiqlegimptotnoremu(getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu());
      struct.setLiqlegimptotdescu(getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu());
      struct.setLiqlegimpcontr(getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr());
      struct.setLiqlegimpcosto(getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto());
      struct.setLiqlegimpotrdescu(getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu());
      struct.setLiqlegimpdescuneg(getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg());
      struct.setLiqlegimptotretgan(getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan());
      struct.setLiqlegimppagosacuen(getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen());
      struct.setLiqlegimptotbruprom(getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom());
      struct.setLiqlegimpbasico(getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico());
      struct.setLiqleggnsi(getgxTv_SdtLiquidacionLegajo_Liqleggnsi());
      struct.setLiqrutapdf(getgxTv_SdtLiquidacionLegajo_Liqrutapdf());
      struct.setLiqrutapdfvertical(getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical());
      struct.setLiqlegiteraciones(getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones());
      struct.setLiqlegsegundos(getgxTv_SdtLiquidacionLegajo_Liqlegsegundos());
      struct.setLiqlegsegins(getgxTv_SdtLiquidacionLegajo_Liqlegsegins());
      struct.setLieqlegsegupd(getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd());
      struct.setLiqlegerror(getgxTv_SdtLiquidacionLegajo_Liqlegerror());
      struct.setLiqperiodo(getgxTv_SdtLiquidacionLegajo_Liqperiodo());
      struct.setLiqnombrepdf(getgxTv_SdtLiquidacionLegajo_Liqnombrepdf());
      struct.setLiqnombrepdfvertical(getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical());
      struct.setTliqcod(getgxTv_SdtLiquidacionLegajo_Tliqcod());
      struct.setLiqleghorassem(getgxTv_SdtLiquidacionLegajo_Liqleghorassem());
      struct.setLiqlegauxestado(getgxTv_SdtLiquidacionLegajo_Liqlegauxestado());
      struct.setLiqlegerroraux(getgxTv_SdtLiquidacionLegajo_Liqlegerroraux());
      struct.setLiqlegfecegr(getgxTv_SdtLiquidacionLegajo_Liqlegfecegr());
      struct.setLiqlegfecing(getgxTv_SdtLiquidacionLegajo_Liqlegfecing());
      struct.setLiqlegcatcodigo(getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo());
      struct.setLiqlegconvenio(getgxTv_SdtLiquidacionLegajo_Liqlegconvenio());
      struct.setLiqlegsueldo(getgxTv_SdtLiquidacionLegajo_Liqlegsueldo());
      struct.setLiqlegpdfestado(getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado());
      struct.setLiqlegprocesado(getgxTv_SdtLiquidacionLegajo_Liqlegprocesado());
      struct.setLiqlegnivliq(getgxTv_SdtLiquidacionLegajo_Liqlegnivliq());
      struct.setLiqleghtml(getgxTv_SdtLiquidacionLegajo_Liqleghtml());
      struct.setLiqleglsd(getgxTv_SdtLiquidacionLegajo_Liqleglsd());
      struct.setLiqlegdaemonuuid(getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid());
      struct.setLiqlegfechor(getgxTv_SdtLiquidacionLegajo_Liqlegfechor());
      struct.setMode(getgxTv_SdtLiquidacionLegajo_Mode());
      struct.setInitialized(getgxTv_SdtLiquidacionLegajo_Initialized());
      struct.setClicod_Z(getgxTv_SdtLiquidacionLegajo_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLiquidacionLegajo_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtLiquidacionLegajo_Empnom_Z());
      struct.setLiqnro_Z(getgxTv_SdtLiquidacionLegajo_Liqnro_Z());
      struct.setLegnumero_Z(getgxTv_SdtLiquidacionLegajo_Legnumero_Z());
      struct.setLiqlegimptotal_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z());
      struct.setLiqseccodigo_Z(getgxTv_SdtLiquidacionLegajo_Liqseccodigo_Z());
      struct.setLiqsecdescrip_Z(getgxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z());
      struct.setLiqlegrecibonro_Z(getgxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z());
      struct.setLegid_Z(getgxTv_SdtLiquidacionLegajo_Legid_Z());
      struct.setLegliqdatoshis_Z(getgxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z());
      struct.setLiqlegimptotbruto_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z());
      struct.setLiqlegimptotbrusinsac_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z());
      struct.setLiqlegcntconc_Z(getgxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z());
      struct.setLiqlegimptotremu_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z());
      struct.setLiqlegimptotnoremu_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z());
      struct.setLiqlegimptotdescu_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z());
      struct.setLiqlegimpcontr_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z());
      struct.setLiqlegimpcosto_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z());
      struct.setLiqlegimpotrdescu_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z());
      struct.setLiqlegimpdescuneg_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z());
      struct.setLiqlegimptotretgan_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z());
      struct.setLiqlegimppagosacuen_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z());
      struct.setLiqlegimptotbruprom_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z());
      struct.setLiqlegimpbasico_Z(getgxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z());
      struct.setLiqleggnsi_Z(getgxTv_SdtLiquidacionLegajo_Liqleggnsi_Z());
      struct.setLiqrutapdf_Z(getgxTv_SdtLiquidacionLegajo_Liqrutapdf_Z());
      struct.setLiqrutapdfvertical_Z(getgxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z());
      struct.setLiqlegiteraciones_Z(getgxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z());
      struct.setLiqlegsegundos_Z(getgxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z());
      struct.setLiqlegsegins_Z(getgxTv_SdtLiquidacionLegajo_Liqlegsegins_Z());
      struct.setLieqlegsegupd_Z(getgxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z());
      struct.setLiqlegerror_Z(getgxTv_SdtLiquidacionLegajo_Liqlegerror_Z());
      struct.setLiqperiodo_Z(getgxTv_SdtLiquidacionLegajo_Liqperiodo_Z());
      struct.setLiqnombrepdf_Z(getgxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z());
      struct.setLiqnombrepdfvertical_Z(getgxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z());
      struct.setTliqcod_Z(getgxTv_SdtLiquidacionLegajo_Tliqcod_Z());
      struct.setLiqleghorassem_Z(getgxTv_SdtLiquidacionLegajo_Liqleghorassem_Z());
      struct.setLiqlegauxestado_Z(getgxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z());
      struct.setLiqlegerroraux_Z(getgxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z());
      struct.setLiqlegfecegr_Z(getgxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z());
      struct.setLiqlegfecing_Z(getgxTv_SdtLiquidacionLegajo_Liqlegfecing_Z());
      struct.setLiqlegcatcodigo_Z(getgxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z());
      struct.setLiqlegconvenio_Z(getgxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z());
      struct.setLiqlegsueldo_Z(getgxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z());
      struct.setLiqlegpdfestado_Z(getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z());
      struct.setLiqlegprocesado_Z(getgxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z());
      struct.setLiqlegnivliq_Z(getgxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z());
      struct.setLiqleglsd_Z(getgxTv_SdtLiquidacionLegajo_Liqleglsd_Z());
      struct.setLiqlegdaemonuuid_Z(getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z());
      struct.setLiqlegfechor_Z(getgxTv_SdtLiquidacionLegajo_Liqlegfechor_Z());
      struct.setLiqseccodigo_N(getgxTv_SdtLiquidacionLegajo_Liqseccodigo_N());
      struct.setLegid_N(getgxTv_SdtLiquidacionLegajo_Legid_N());
      struct.setTliqcod_N(getgxTv_SdtLiquidacionLegajo_Tliqcod_N());
      struct.setLiqlegpdfestado_N(getgxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N());
      struct.setLiqlegdaemonuuid_N(getgxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N());
      return struct ;
   }

   private byte gxTv_SdtLiquidacionLegajo_N ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegauxestado ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegprocesado ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegnivliq ;
   private byte gxTv_SdtLiquidacionLegajo_Liqleglsd ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegauxestado_Z ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegprocesado_Z ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegnivliq_Z ;
   private byte gxTv_SdtLiquidacionLegajo_Liqleglsd_Z ;
   private byte gxTv_SdtLiquidacionLegajo_Liqseccodigo_N ;
   private byte gxTv_SdtLiquidacionLegajo_Legid_N ;
   private byte gxTv_SdtLiquidacionLegajo_Tliqcod_N ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_N ;
   private byte gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_N ;
   private short gxTv_SdtLiquidacionLegajo_Empcod ;
   private short gxTv_SdtLiquidacionLegajo_Liqlegcntconc ;
   private short gxTv_SdtLiquidacionLegajo_Liqlegiteraciones ;
   private short gxTv_SdtLiquidacionLegajo_Initialized ;
   private short gxTv_SdtLiquidacionLegajo_Empcod_Z ;
   private short gxTv_SdtLiquidacionLegajo_Liqlegcntconc_Z ;
   private short gxTv_SdtLiquidacionLegajo_Liqlegiteraciones_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLiquidacionLegajo_Clicod ;
   private int gxTv_SdtLiquidacionLegajo_Liqnro ;
   private int gxTv_SdtLiquidacionLegajo_Legnumero ;
   private int gxTv_SdtLiquidacionLegajo_Liqlegrecibonro ;
   private int gxTv_SdtLiquidacionLegajo_Clicod_Z ;
   private int gxTv_SdtLiquidacionLegajo_Liqnro_Z ;
   private int gxTv_SdtLiquidacionLegajo_Legnumero_Z ;
   private int gxTv_SdtLiquidacionLegajo_Liqlegrecibonro_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotal ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotremu ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcontr ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcosto ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpbasico ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleggnsi ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegundos ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegins ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Lieqlegsegupd ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleghorassem ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsueldo ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotal_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruto_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbrusinsac_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotremu_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotnoremu_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotdescu_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcontr_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpcosto_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpotrdescu_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpdescuneg_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotretgan_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimppagosacuen_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimptotbruprom_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegimpbasico_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleggnsi_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegundos_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsegins_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Lieqlegsegupd_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqleghorassem_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacionLegajo_Liqlegsueldo_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqseccodigo ;
   private String gxTv_SdtLiquidacionLegajo_Legid ;
   private String gxTv_SdtLiquidacionLegajo_Liqnombrepdf ;
   private String gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical ;
   private String gxTv_SdtLiquidacionLegajo_Tliqcod ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegconvenio ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegpdfestado ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid ;
   private String gxTv_SdtLiquidacionLegajo_Mode ;
   private String gxTv_SdtLiquidacionLegajo_Liqseccodigo_Z ;
   private String gxTv_SdtLiquidacionLegajo_Legid_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqnombrepdf_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqnombrepdfvertical_Z ;
   private String gxTv_SdtLiquidacionLegajo_Tliqcod_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegcatcodigo_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegconvenio_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegpdfestado_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegdaemonuuid_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfechor ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfechor_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqperiodo ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecegr ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecing ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqperiodo_Z ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecegr_Z ;
   private java.util.Date gxTv_SdtLiquidacionLegajo_Liqlegfecing_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLiquidacionLegajo_Liqleghtml ;
   private String gxTv_SdtLiquidacionLegajo_Empnom ;
   private String gxTv_SdtLiquidacionLegajo_Liqsecdescrip ;
   private String gxTv_SdtLiquidacionLegajo_Legliqdatoshis ;
   private String gxTv_SdtLiquidacionLegajo_Liqrutapdf ;
   private String gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegerror ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegerroraux ;
   private String gxTv_SdtLiquidacionLegajo_Empnom_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqsecdescrip_Z ;
   private String gxTv_SdtLiquidacionLegajo_Legliqdatoshis_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqrutapdf_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqrutapdfvertical_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegerror_Z ;
   private String gxTv_SdtLiquidacionLegajo_Liqlegerroraux_Z ;
}

