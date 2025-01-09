package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtClienteConvenio_Particularidades extends GxSilentTrnSdt
{
   public SdtClienteConvenio_Particularidades( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtClienteConvenio_Particularidades.class));
   }

   public SdtClienteConvenio_Particularidades( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtClienteConvenio_Particularidades");
      initialize( remoteHandle) ;
   }

   public SdtClienteConvenio_Particularidades( int remoteHandle ,
                                               StructSdtClienteConvenio_Particularidades struct )
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
                     short AV1564CliPaiConve ,
                     String AV1565CliConvenio ,
                     java.util.Date AV1575CliConveVig )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1564CliPaiConve),AV1565CliConvenio,AV1575CliConveVig});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"CliPaiConve", short.class}, new Object[]{"CliConvenio", String.class}, new Object[]{"CliConveVig", java.util.Date.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "ClienteConvenio_Particularidades");
      metadata.set("BT", "ClienteConvenio_Particularidades");
      metadata.set("PK", "[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"CliConveVig\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"Vacaciones\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtClienteConvenio_Particularidades_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVig") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtClienteConvenio_Particularidades_Cliconvevig = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtClienteConvenio_Particularidades_Cliconvevig = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDefault") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convedefault = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveInterDiasJor") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDiasAcuVac") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveMinMesesVac") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveMesHsPExt") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convemeshspext = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDiaHsPExt") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convediahspext = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveFondoCese") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convefondocese = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMin") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMax") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveRelSec") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Converelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveRelRef") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Converelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvePartOld") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convepartold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Vacaciones") )
            {
               if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones == null )
               {
                  gxTv_SdtClienteConvenio_Particularidades_Vacaciones = new GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones>(web.SdtClienteConvenio_Particularidades_Vacaciones.class, "ClienteConvenio_Particularidades.Vacaciones", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtClienteConvenio_Particularidades_Vacaciones.readxml(oReader, "Vacaciones") ;
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
               gxTv_SdtClienteConvenio_Particularidades_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConveVig_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDefault_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveInterDiasJor_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDiasAcuVac_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveMinMesesVac_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveMesHsPExt_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDiaHsPExt_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveFondoCese_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMin_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMax_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveRelSec_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveRelRef_Z") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Converelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDiaHsPExt_N") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMin_N") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveGuarEdadMax_N") )
            {
               gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "ClienteConvenio_Particularidades" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtClienteConvenio_Particularidades_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("CliConveVig", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDefault", GXutil.booltostr( gxTv_SdtClienteConvenio_Particularidades_Convedefault));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveInterDiasJor", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor, 3, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDiasAcuVac", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveMinMesesVac", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveMesHsPExt", GXutil.trim( GXutil.strNoRound( gxTv_SdtClienteConvenio_Particularidades_Convemeshspext, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDiaHsPExt", gxTv_SdtClienteConvenio_Particularidades_Convediahspext);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveFondoCese", GXutil.booltostr( gxTv_SdtClienteConvenio_Particularidades_Convefondocese));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveGuarEdadMin", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveGuarEdadMax", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveRelSec", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Converelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveRelRef", gxTv_SdtClienteConvenio_Particularidades_Converelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvePartOld", gxTv_SdtClienteConvenio_Particularidades_Convepartold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
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
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones.writexml(oWriter, "Vacaciones", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtClienteConvenio_Particularidades_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliPaiConve_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliConvenio_Z", gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("CliConveVig_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveDefault_Z", GXutil.booltostr( gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveInterDiasJor_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z, 3, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveDiasAcuVac_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveMinMesesVac_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveMesHsPExt_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z, 5, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveDiaHsPExt_Z", gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveFondoCese_Z", GXutil.booltostr( gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveGuarEdadMin_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveGuarEdadMax_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveRelRef_Z", gxTv_SdtClienteConvenio_Particularidades_Converelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveDiaHsPExt_N", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveGuarEdadMin_N", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveGuarEdadMax_N", GXutil.trim( GXutil.str( gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtClienteConvenio_Particularidades_Clicod, false, includeNonInitialized);
      AddObjectProperty("CliPaiConve", gxTv_SdtClienteConvenio_Particularidades_Clipaiconve, false, includeNonInitialized);
      AddObjectProperty("CliConvenio", gxTv_SdtClienteConvenio_Particularidades_Cliconvenio, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("CliConveVig", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("ConveDefault", gxTv_SdtClienteConvenio_Particularidades_Convedefault, false, includeNonInitialized);
      AddObjectProperty("ConveInterDiasJor", gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor, false, includeNonInitialized);
      AddObjectProperty("ConveDiasAcuVac", gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac, false, includeNonInitialized);
      AddObjectProperty("ConveMinMesesVac", gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac, false, includeNonInitialized);
      AddObjectProperty("ConveMesHsPExt", gxTv_SdtClienteConvenio_Particularidades_Convemeshspext, false, includeNonInitialized);
      AddObjectProperty("ConveDiaHsPExt", gxTv_SdtClienteConvenio_Particularidades_Convediahspext, false, includeNonInitialized);
      AddObjectProperty("ConveDiaHsPExt_N", gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N, false, includeNonInitialized);
      AddObjectProperty("ConveFondoCese", gxTv_SdtClienteConvenio_Particularidades_Convefondocese, false, includeNonInitialized);
      AddObjectProperty("ConveGuarEdadMin", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin, false, includeNonInitialized);
      AddObjectProperty("ConveGuarEdadMin_N", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N, false, includeNonInitialized);
      AddObjectProperty("ConveGuarEdadMax", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax, false, includeNonInitialized);
      AddObjectProperty("ConveGuarEdadMax_N", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N, false, includeNonInitialized);
      AddObjectProperty("ConveRelSec", gxTv_SdtClienteConvenio_Particularidades_Converelsec, false, includeNonInitialized);
      AddObjectProperty("ConveRelRef", gxTv_SdtClienteConvenio_Particularidades_Converelref, false, includeNonInitialized);
      AddObjectProperty("ConvePartOld", gxTv_SdtClienteConvenio_Particularidades_Convepartold, false, includeNonInitialized);
      if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
      {
         AddObjectProperty("Vacaciones", gxTv_SdtClienteConvenio_Particularidades_Vacaciones, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtClienteConvenio_Particularidades_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtClienteConvenio_Particularidades_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtClienteConvenio_Particularidades_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("CliPaiConve_Z", gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z, false, includeNonInitialized);
         AddObjectProperty("CliConvenio_Z", gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("CliConveVig_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("ConveDefault_Z", gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z, false, includeNonInitialized);
         AddObjectProperty("ConveInterDiasJor_Z", gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z, false, includeNonInitialized);
         AddObjectProperty("ConveDiasAcuVac_Z", gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z, false, includeNonInitialized);
         AddObjectProperty("ConveMinMesesVac_Z", gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z, false, includeNonInitialized);
         AddObjectProperty("ConveMesHsPExt_Z", gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z, false, includeNonInitialized);
         AddObjectProperty("ConveDiaHsPExt_Z", gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z, false, includeNonInitialized);
         AddObjectProperty("ConveFondoCese_Z", gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z, false, includeNonInitialized);
         AddObjectProperty("ConveGuarEdadMin_Z", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z, false, includeNonInitialized);
         AddObjectProperty("ConveGuarEdadMax_Z", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z, false, includeNonInitialized);
         AddObjectProperty("ConveRelSec_Z", gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z, false, includeNonInitialized);
         AddObjectProperty("ConveRelRef_Z", gxTv_SdtClienteConvenio_Particularidades_Converelref_Z, false, includeNonInitialized);
         AddObjectProperty("ConveDiaHsPExt_N", gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N, false, includeNonInitialized);
         AddObjectProperty("ConveGuarEdadMin_N", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N, false, includeNonInitialized);
         AddObjectProperty("ConveGuarEdadMax_N", gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtClienteConvenio_Particularidades sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Clicod = sdt.getgxTv_SdtClienteConvenio_Particularidades_Clicod() ;
      }
      if ( sdt.IsDirty("CliPaiConve") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Clipaiconve = sdt.getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve() ;
      }
      if ( sdt.IsDirty("CliConvenio") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Cliconvenio = sdt.getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio() ;
      }
      if ( sdt.IsDirty("CliConveVig") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Cliconvevig = sdt.getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig() ;
      }
      if ( sdt.IsDirty("ConveDefault") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Convedefault = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convedefault() ;
      }
      if ( sdt.IsDirty("ConveInterDiasJor") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor = sdt.getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor() ;
      }
      if ( sdt.IsDirty("ConveDiasAcuVac") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac() ;
      }
      if ( sdt.IsDirty("ConveMinMesesVac") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac = sdt.getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac() ;
      }
      if ( sdt.IsDirty("ConveMesHsPExt") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Convemeshspext = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext() ;
      }
      if ( sdt.IsDirty("ConveDiaHsPExt") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N() ;
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Convediahspext = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convediahspext() ;
      }
      if ( sdt.IsDirty("ConveFondoCese") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Convefondocese = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convefondocese() ;
      }
      if ( sdt.IsDirty("ConveGuarEdadMin") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N = sdt.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N() ;
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin = sdt.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin() ;
      }
      if ( sdt.IsDirty("ConveGuarEdadMax") )
      {
         gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N = sdt.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N() ;
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax = sdt.getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax() ;
      }
      if ( sdt.IsDirty("ConveRelSec") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Converelsec = sdt.getgxTv_SdtClienteConvenio_Particularidades_Converelsec() ;
      }
      if ( sdt.IsDirty("ConveRelRef") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Converelref = sdt.getgxTv_SdtClienteConvenio_Particularidades_Converelref() ;
      }
      if ( sdt.IsDirty("ConvePartOld") )
      {
         gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
         gxTv_SdtClienteConvenio_Particularidades_Convepartold = sdt.getgxTv_SdtClienteConvenio_Particularidades_Convepartold() ;
      }
      if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
      {
         GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> newCollectionVacaciones = sdt.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones();
         web.SdtClienteConvenio_Particularidades_Vacaciones currItemVacaciones;
         web.SdtClienteConvenio_Particularidades_Vacaciones newItemVacaciones;
         short idx = 1;
         while ( idx <= newCollectionVacaciones.size() )
         {
            newItemVacaciones = (web.SdtClienteConvenio_Particularidades_Vacaciones)((web.SdtClienteConvenio_Particularidades_Vacaciones)newCollectionVacaciones.elementAt(-1+idx));
            currItemVacaciones = (web.SdtClienteConvenio_Particularidades_Vacaciones)gxTv_SdtClienteConvenio_Particularidades_Vacaciones.getByKey(newItemVacaciones.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Cliconvevacdesant());
            if ( GXutil.strcmp(currItemVacaciones.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode(), "UPD") == 0 )
            {
               currItemVacaciones.updateDirties(newItemVacaciones);
               if ( GXutil.strcmp(newItemVacaciones.getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode(), "DLT") == 0 )
               {
                  currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( "DLT" );
               }
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtClienteConvenio_Particularidades_Vacaciones.add(newItemVacaciones, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtClienteConvenio_Particularidades_Clicod( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Clicod ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Clicod( int value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      if ( gxTv_SdtClienteConvenio_Particularidades_Clicod != value )
      {
         gxTv_SdtClienteConvenio_Particularidades_Mode = "INS" ;
         this.setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z_SetNull( );
         if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
         {
            GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> collectionVacaciones = gxTv_SdtClienteConvenio_Particularidades_Vacaciones;
            web.SdtClienteConvenio_Particularidades_Vacaciones currItemVacaciones;
            short idx = 1;
            while ( idx <= collectionVacaciones.size() )
            {
               currItemVacaciones = (web.SdtClienteConvenio_Particularidades_Vacaciones)((web.SdtClienteConvenio_Particularidades_Vacaciones)collectionVacaciones.elementAt(-1+idx));
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( "INS" );
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtClienteConvenio_Particularidades_Clicod = value ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Clipaiconve ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      if ( gxTv_SdtClienteConvenio_Particularidades_Clipaiconve != value )
      {
         gxTv_SdtClienteConvenio_Particularidades_Mode = "INS" ;
         this.setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z_SetNull( );
         if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
         {
            GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> collectionVacaciones = gxTv_SdtClienteConvenio_Particularidades_Vacaciones;
            web.SdtClienteConvenio_Particularidades_Vacaciones currItemVacaciones;
            short idx = 1;
            while ( idx <= collectionVacaciones.size() )
            {
               currItemVacaciones = (web.SdtClienteConvenio_Particularidades_Vacaciones)((web.SdtClienteConvenio_Particularidades_Vacaciones)collectionVacaciones.elementAt(-1+idx));
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( "INS" );
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clipaiconve");
      gxTv_SdtClienteConvenio_Particularidades_Clipaiconve = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Cliconvenio ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtClienteConvenio_Particularidades_Cliconvenio, value) != 0 )
      {
         gxTv_SdtClienteConvenio_Particularidades_Mode = "INS" ;
         this.setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z_SetNull( );
         if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
         {
            GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> collectionVacaciones = gxTv_SdtClienteConvenio_Particularidades_Vacaciones;
            web.SdtClienteConvenio_Particularidades_Vacaciones currItemVacaciones;
            short idx = 1;
            while ( idx <= collectionVacaciones.size() )
            {
               currItemVacaciones = (web.SdtClienteConvenio_Particularidades_Vacaciones)((web.SdtClienteConvenio_Particularidades_Vacaciones)collectionVacaciones.elementAt(-1+idx));
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( "INS" );
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Cliconvenio");
      gxTv_SdtClienteConvenio_Particularidades_Cliconvenio = value ;
   }

   public java.util.Date getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Cliconvevig ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig( java.util.Date value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      if ( !( GXutil.dateCompare(GXutil.resetTime(gxTv_SdtClienteConvenio_Particularidades_Cliconvevig), GXutil.resetTime(value)) ) )
      {
         gxTv_SdtClienteConvenio_Particularidades_Mode = "INS" ;
         this.setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z_SetNull( );
         this.setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z_SetNull( );
         if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones != null )
         {
            GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> collectionVacaciones = gxTv_SdtClienteConvenio_Particularidades_Vacaciones;
            web.SdtClienteConvenio_Particularidades_Vacaciones currItemVacaciones;
            short idx = 1;
            while ( idx <= collectionVacaciones.size() )
            {
               currItemVacaciones = (web.SdtClienteConvenio_Particularidades_Vacaciones)((web.SdtClienteConvenio_Particularidades_Vacaciones)collectionVacaciones.elementAt(-1+idx));
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Mode( "INS" );
               currItemVacaciones.setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Cliconvevig");
      gxTv_SdtClienteConvenio_Particularidades_Cliconvevig = value ;
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convedefault( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convedefault ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convedefault( boolean value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convedefault");
      gxTv_SdtClienteConvenio_Particularidades_Convedefault = value ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveinterdiasjor");
      gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor = value ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convediasacuvac");
      gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac = value ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveminmesesvac");
      gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac = value ;
   }

   public java.math.BigDecimal getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convemeshspext ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext( java.math.BigDecimal value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convemeshspext");
      gxTv_SdtClienteConvenio_Particularidades_Convemeshspext = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Convediahspext( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convediahspext ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediahspext( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convediahspext");
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N = (byte)(1) ;
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext = "" ;
      SetDirty("Convediahspext");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_IsNull( )
   {
      return (gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N==1) ;
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convefondocese( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convefondocese ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convefondocese( boolean value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convefondocese");
      gxTv_SdtClienteConvenio_Particularidades_Convefondocese = value ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveguaredadmin");
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N = (byte)(1) ;
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin = (byte)(0) ;
      SetDirty("Conveguaredadmin");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_IsNull( )
   {
      return (gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N==1) ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N = (byte)(0) ;
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveguaredadmax");
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N = (byte)(1) ;
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax = (byte)(0) ;
      SetDirty("Conveguaredadmax");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_IsNull( )
   {
      return (gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N==1) ;
   }

   public int getgxTv_SdtClienteConvenio_Particularidades_Converelsec( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Converelsec ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Converelsec( int value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Converelsec");
      gxTv_SdtClienteConvenio_Particularidades_Converelsec = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Converelref( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Converelref ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Converelref( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Converelref");
      gxTv_SdtClienteConvenio_Particularidades_Converelref = value ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Convepartold( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convepartold ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convepartold( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convepartold");
      gxTv_SdtClienteConvenio_Particularidades_Convepartold = value ;
   }

   public GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> getgxTv_SdtClienteConvenio_Particularidades_Vacaciones( )
   {
      if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones == null )
      {
         gxTv_SdtClienteConvenio_Particularidades_Vacaciones = new GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones>(web.SdtClienteConvenio_Particularidades_Vacaciones.class, "ClienteConvenio_Particularidades.Vacaciones", "PayDay", remoteHandle);
      }
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      return gxTv_SdtClienteConvenio_Particularidades_Vacaciones ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones( GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Vacaciones");
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Vacaciones_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Vacaciones = null ;
      SetDirty("Vacaciones");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Vacaciones_IsNull( )
   {
      if ( gxTv_SdtClienteConvenio_Particularidades_Vacaciones == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Mode( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Mode ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Mode( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtClienteConvenio_Particularidades_Mode = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Mode_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Initialized( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Initialized ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Initialized( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtClienteConvenio_Particularidades_Initialized = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Initialized_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtClienteConvenio_Particularidades_Clicod_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Clicod_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z( int value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtClienteConvenio_Particularidades_Clicod_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Clipaiconve_Z");
      gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z = (short)(0) ;
      SetDirty("Clipaiconve_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Cliconvenio_Z");
      gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z = "" ;
      SetDirty("Cliconvenio_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z( java.util.Date value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Cliconvevig_Z");
      gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z = GXutil.nullDate() ;
      SetDirty("Cliconvevig_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z( boolean value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convedefault_Z");
      gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z = false ;
      SetDirty("Convedefault_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z( short value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveinterdiasjor_Z");
      gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z = (short)(0) ;
      SetDirty("Conveinterdiasjor_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convediasacuvac_Z");
      gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z = (byte)(0) ;
      SetDirty("Convediasacuvac_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveminmesesvac_Z");
      gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z = (byte)(0) ;
      SetDirty("Conveminmesesvac_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z( java.math.BigDecimal value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convemeshspext_Z");
      gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z = DecimalUtil.ZERO ;
      SetDirty("Convemeshspext_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convediahspext_Z");
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z = "" ;
      SetDirty("Convediahspext_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z( boolean value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convefondocese_Z");
      gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z = false ;
      SetDirty("Convefondocese_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveguaredadmin_Z");
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z = (byte)(0) ;
      SetDirty("Conveguaredadmin_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveguaredadmax_Z");
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z = (byte)(0) ;
      SetDirty("Conveguaredadmax_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z( int value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Converelsec_Z");
      gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z = 0 ;
      SetDirty("Converelsec_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtClienteConvenio_Particularidades_Converelref_Z( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Converelref_Z ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z( String value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Converelref_Z");
      gxTv_SdtClienteConvenio_Particularidades_Converelref_Z = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Converelref_Z = "" ;
      SetDirty("Converelref_Z");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Converelref_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Convediahspext_N");
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N = (byte)(0) ;
      SetDirty("Convediahspext_N");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveguaredadmin_N");
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N = (byte)(0) ;
      SetDirty("Conveguaredadmin_N");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N( byte value )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(0) ;
      SetDirty("Conveguaredadmax_N");
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N = value ;
   }

   public void setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N_SetNull( )
   {
      gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N = (byte)(0) ;
      SetDirty("Conveguaredadmax_N");
   }

   public boolean getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.clienteconvenio_particularidades_bc obj;
      obj = new web.clienteconvenio_particularidades_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtClienteConvenio_Particularidades_N = (byte)(1) ;
      gxTv_SdtClienteConvenio_Particularidades_Cliconvenio = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Cliconvevig = GXutil.nullDate() ;
      gxTv_SdtClienteConvenio_Particularidades_Convemeshspext = DecimalUtil.ZERO ;
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Converelref = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Convepartold = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Mode = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z = GXutil.nullDate() ;
      gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z = DecimalUtil.ZERO ;
      gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z = "" ;
      gxTv_SdtClienteConvenio_Particularidades_Converelref_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtClienteConvenio_Particularidades_N ;
   }

   public web.SdtClienteConvenio_Particularidades Clone( )
   {
      web.SdtClienteConvenio_Particularidades sdt;
      web.clienteconvenio_particularidades_bc obj;
      sdt = (web.SdtClienteConvenio_Particularidades)(clone()) ;
      obj = (web.clienteconvenio_particularidades_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtClienteConvenio_Particularidades struct )
   {
      setgxTv_SdtClienteConvenio_Particularidades_Clicod(struct.getClicod());
      setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig(struct.getCliconvevig());
      setgxTv_SdtClienteConvenio_Particularidades_Convedefault(struct.getConvedefault());
      setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor(struct.getConveinterdiasjor());
      setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac(struct.getConvediasacuvac());
      setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac(struct.getConveminmesesvac());
      setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext(struct.getConvemeshspext());
      setgxTv_SdtClienteConvenio_Particularidades_Convediahspext(struct.getConvediahspext());
      setgxTv_SdtClienteConvenio_Particularidades_Convefondocese(struct.getConvefondocese());
      setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin(struct.getConveguaredadmin());
      setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax(struct.getConveguaredadmax());
      setgxTv_SdtClienteConvenio_Particularidades_Converelsec(struct.getConverelsec());
      setgxTv_SdtClienteConvenio_Particularidades_Converelref(struct.getConverelref());
      setgxTv_SdtClienteConvenio_Particularidades_Convepartold(struct.getConvepartold());
      GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux = new GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones>(web.SdtClienteConvenio_Particularidades_Vacaciones.class, "ClienteConvenio_Particularidades.Vacaciones", "PayDay", remoteHandle);
      Vector<web.StructSdtClienteConvenio_Particularidades_Vacaciones> gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux1 = struct.getVacaciones();
      if (gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux1.size(); i++)
         {
            gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux.add(new web.SdtClienteConvenio_Particularidades_Vacaciones(remoteHandle, gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtClienteConvenio_Particularidades_Vacaciones(gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux);
      setgxTv_SdtClienteConvenio_Particularidades_Mode(struct.getMode());
      setgxTv_SdtClienteConvenio_Particularidades_Initialized(struct.getInitialized());
      setgxTv_SdtClienteConvenio_Particularidades_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z(struct.getClipaiconve_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z(struct.getCliconvenio_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z(struct.getCliconvevig_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z(struct.getConvedefault_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z(struct.getConveinterdiasjor_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z(struct.getConvediasacuvac_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z(struct.getConveminmesesvac_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z(struct.getConvemeshspext_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z(struct.getConvediahspext_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z(struct.getConvefondocese_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z(struct.getConveguaredadmin_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z(struct.getConveguaredadmax_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z(struct.getConverelsec_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Converelref_Z(struct.getConverelref_Z());
      setgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N(struct.getConvediahspext_N());
      setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N(struct.getConveguaredadmin_N());
      setgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N(struct.getConveguaredadmax_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtClienteConvenio_Particularidades getStruct( )
   {
      web.StructSdtClienteConvenio_Particularidades struct = new web.StructSdtClienteConvenio_Particularidades ();
      struct.setClicod(getgxTv_SdtClienteConvenio_Particularidades_Clicod());
      struct.setClipaiconve(getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio());
      struct.setCliconvevig(getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig());
      struct.setConvedefault(getgxTv_SdtClienteConvenio_Particularidades_Convedefault());
      struct.setConveinterdiasjor(getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor());
      struct.setConvediasacuvac(getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac());
      struct.setConveminmesesvac(getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac());
      struct.setConvemeshspext(getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext());
      struct.setConvediahspext(getgxTv_SdtClienteConvenio_Particularidades_Convediahspext());
      struct.setConvefondocese(getgxTv_SdtClienteConvenio_Particularidades_Convefondocese());
      struct.setConveguaredadmin(getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin());
      struct.setConveguaredadmax(getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax());
      struct.setConverelsec(getgxTv_SdtClienteConvenio_Particularidades_Converelsec());
      struct.setConverelref(getgxTv_SdtClienteConvenio_Particularidades_Converelref());
      struct.setConvepartold(getgxTv_SdtClienteConvenio_Particularidades_Convepartold());
      struct.setVacaciones(getgxTv_SdtClienteConvenio_Particularidades_Vacaciones().getStruct());
      struct.setMode(getgxTv_SdtClienteConvenio_Particularidades_Mode());
      struct.setInitialized(getgxTv_SdtClienteConvenio_Particularidades_Initialized());
      struct.setClicod_Z(getgxTv_SdtClienteConvenio_Particularidades_Clicod_Z());
      struct.setClipaiconve_Z(getgxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z());
      struct.setCliconvenio_Z(getgxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z());
      struct.setCliconvevig_Z(getgxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z());
      struct.setConvedefault_Z(getgxTv_SdtClienteConvenio_Particularidades_Convedefault_Z());
      struct.setConveinterdiasjor_Z(getgxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z());
      struct.setConvediasacuvac_Z(getgxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z());
      struct.setConveminmesesvac_Z(getgxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z());
      struct.setConvemeshspext_Z(getgxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z());
      struct.setConvediahspext_Z(getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z());
      struct.setConvefondocese_Z(getgxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z());
      struct.setConveguaredadmin_Z(getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z());
      struct.setConveguaredadmax_Z(getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z());
      struct.setConverelsec_Z(getgxTv_SdtClienteConvenio_Particularidades_Converelsec_Z());
      struct.setConverelref_Z(getgxTv_SdtClienteConvenio_Particularidades_Converelref_Z());
      struct.setConvediahspext_N(getgxTv_SdtClienteConvenio_Particularidades_Convediahspext_N());
      struct.setConveguaredadmin_N(getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N());
      struct.setConveguaredadmax_N(getgxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N());
      return struct ;
   }

   private byte gxTv_SdtClienteConvenio_Particularidades_N ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Convediasacuvac_Z ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveminmesesvac_Z ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_Z ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_Z ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Convediahspext_N ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmin_N ;
   private byte gxTv_SdtClienteConvenio_Particularidades_Conveguaredadmax_N ;
   private short gxTv_SdtClienteConvenio_Particularidades_Clipaiconve ;
   private short gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor ;
   private short gxTv_SdtClienteConvenio_Particularidades_Initialized ;
   private short gxTv_SdtClienteConvenio_Particularidades_Clipaiconve_Z ;
   private short gxTv_SdtClienteConvenio_Particularidades_Conveinterdiasjor_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtClienteConvenio_Particularidades_Clicod ;
   private int gxTv_SdtClienteConvenio_Particularidades_Converelsec ;
   private int gxTv_SdtClienteConvenio_Particularidades_Clicod_Z ;
   private int gxTv_SdtClienteConvenio_Particularidades_Converelsec_Z ;
   private java.math.BigDecimal gxTv_SdtClienteConvenio_Particularidades_Convemeshspext ;
   private java.math.BigDecimal gxTv_SdtClienteConvenio_Particularidades_Convemeshspext_Z ;
   private String gxTv_SdtClienteConvenio_Particularidades_Cliconvenio ;
   private String gxTv_SdtClienteConvenio_Particularidades_Convediahspext ;
   private String gxTv_SdtClienteConvenio_Particularidades_Mode ;
   private String gxTv_SdtClienteConvenio_Particularidades_Cliconvenio_Z ;
   private String gxTv_SdtClienteConvenio_Particularidades_Convediahspext_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtClienteConvenio_Particularidades_Cliconvevig ;
   private java.util.Date gxTv_SdtClienteConvenio_Particularidades_Cliconvevig_Z ;
   private boolean gxTv_SdtClienteConvenio_Particularidades_Convedefault ;
   private boolean gxTv_SdtClienteConvenio_Particularidades_Convefondocese ;
   private boolean gxTv_SdtClienteConvenio_Particularidades_Convedefault_Z ;
   private boolean gxTv_SdtClienteConvenio_Particularidades_Convefondocese_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtClienteConvenio_Particularidades_Convepartold ;
   private String gxTv_SdtClienteConvenio_Particularidades_Converelref ;
   private String gxTv_SdtClienteConvenio_Particularidades_Converelref_Z ;
   private GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> gxTv_SdtClienteConvenio_Particularidades_Vacaciones_aux ;
   private GXBCLevelCollection<web.SdtClienteConvenio_Particularidades_Vacaciones> gxTv_SdtClienteConvenio_Particularidades_Vacaciones=null ;
}

