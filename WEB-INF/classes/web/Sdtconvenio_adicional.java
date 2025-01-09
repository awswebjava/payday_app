package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtconvenio_adicional extends GxSilentTrnSdt
{
   public Sdtconvenio_adicional( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(Sdtconvenio_adicional.class));
   }

   public Sdtconvenio_adicional( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle, context, "Sdtconvenio_adicional");
      initialize( remoteHandle) ;
   }

   public Sdtconvenio_adicional( int remoteHandle ,
                                 StructSdtconvenio_adicional struct )
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
                     String AV996ConveAdicod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1564CliPaiConve),AV1565CliConvenio,AV996ConveAdicod});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"CliPaiConve", short.class}, new Object[]{"CliConvenio", String.class}, new Object[]{"ConveAdicod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "convenio_adicional");
      metadata.set("BT", "convenio_adicional");
      metadata.set("PK", "[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"ConveAdicod\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("Levels", "[ \"Cancela\",\"alicuotas\",\"importes\" ]");
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
               gxTv_Sdtconvenio_adicional_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_Sdtconvenio_adicional_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_Sdtconvenio_adicional_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod") )
            {
               gxTv_Sdtconvenio_adicional_Conveadicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiDescri") )
            {
               gxTv_Sdtconvenio_adicional_Conveadidescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiAli") )
            {
               gxTv_Sdtconvenio_adicional_Conveadiali = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiInfo") )
            {
               gxTv_Sdtconvenio_adicional_Conveadiinfo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiTipo") )
            {
               gxTv_Sdtconvenio_adicional_Conveaditipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiRelSec") )
            {
               gxTv_Sdtconvenio_adicional_Conveadirelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiRelRef") )
            {
               gxTv_Sdtconvenio_adicional_Conveadirelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiOld") )
            {
               gxTv_Sdtconvenio_adicional_Conveadiold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Cancela") )
            {
               if ( gxTv_Sdtconvenio_adicional_Cancela == null )
               {
                  gxTv_Sdtconvenio_adicional_Cancela = new GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela>(web.Sdtconvenio_adicional_Cancela.class, "convenio_adicional.Cancela", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_Sdtconvenio_adicional_Cancela.readxml(oReader, "Cancela") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Cancela") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "importes") )
            {
               if ( gxTv_Sdtconvenio_adicional_Importes == null )
               {
                  gxTv_Sdtconvenio_adicional_Importes = new GXBCLevelCollection<web.Sdtconvenio_adicional_importes>(web.Sdtconvenio_adicional_importes.class, "convenio_adicional.importes", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_Sdtconvenio_adicional_Importes.readxml(oReader, "importes") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "importes") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "alicuotas") )
            {
               if ( gxTv_Sdtconvenio_adicional_Alicuotas == null )
               {
                  gxTv_Sdtconvenio_adicional_Alicuotas = new GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas>(web.Sdtconvenio_adicional_alicuotas.class, "convenio_adicional.alicuotas", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_Sdtconvenio_adicional_Alicuotas.readxml(oReader, "alicuotas") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "alicuotas") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_Sdtconvenio_adicional_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_Sdtconvenio_adicional_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_Sdtconvenio_adicional_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve_Z") )
            {
               gxTv_Sdtconvenio_adicional_Clipaiconve_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio_Z") )
            {
               gxTv_Sdtconvenio_adicional_Cliconvenio_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod_Z") )
            {
               gxTv_Sdtconvenio_adicional_Conveadicod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiDescri_Z") )
            {
               gxTv_Sdtconvenio_adicional_Conveadidescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiAli_Z") )
            {
               gxTv_Sdtconvenio_adicional_Conveadiali_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiTipo_Z") )
            {
               gxTv_Sdtconvenio_adicional_Conveaditipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiRelSec_Z") )
            {
               gxTv_Sdtconvenio_adicional_Conveadirelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiRelRef_Z") )
            {
               gxTv_Sdtconvenio_adicional_Conveadirelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiInfo_N") )
            {
               gxTv_Sdtconvenio_adicional_Conveadiinfo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiRelSec_N") )
            {
               gxTv_Sdtconvenio_adicional_Conveadirelsec_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "convenio_adicional" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_Sdtconvenio_adicional_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdicod", gxTv_Sdtconvenio_adicional_Conveadicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiDescri", gxTv_Sdtconvenio_adicional_Conveadidescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiAli", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_adicional_Conveadiali, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiInfo", gxTv_Sdtconvenio_adicional_Conveadiinfo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiTipo", gxTv_Sdtconvenio_adicional_Conveaditipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiRelSec", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Conveadirelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiRelRef", gxTv_Sdtconvenio_adicional_Conveadirelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiOld", gxTv_Sdtconvenio_adicional_Conveadiold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtconvenio_adicional_Cancela != null )
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
         gxTv_Sdtconvenio_adicional_Cancela.writexml(oWriter, "Cancela", sNameSpace1, sIncludeState);
      }
      if ( gxTv_Sdtconvenio_adicional_Importes != null )
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
         gxTv_Sdtconvenio_adicional_Importes.writexml(oWriter, "importes", sNameSpace1, sIncludeState);
      }
      if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
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
         gxTv_Sdtconvenio_adicional_Alicuotas.writexml(oWriter, "alicuotas", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_Sdtconvenio_adicional_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliPaiConve_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Clipaiconve_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliConvenio_Z", gxTv_Sdtconvenio_adicional_Cliconvenio_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdicod_Z", gxTv_Sdtconvenio_adicional_Conveadicod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiDescri_Z", gxTv_Sdtconvenio_adicional_Conveadidescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiAli_Z", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_adicional_Conveadiali_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiTipo_Z", gxTv_Sdtconvenio_adicional_Conveaditipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiRelSec_Z", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Conveadirelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiRelRef_Z", gxTv_Sdtconvenio_adicional_Conveadirelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiInfo_N", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Conveadiinfo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveAdiRelSec_N", GXutil.trim( GXutil.str( gxTv_Sdtconvenio_adicional_Conveadirelsec_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_Sdtconvenio_adicional_Clicod, false, includeNonInitialized);
      AddObjectProperty("CliPaiConve", gxTv_Sdtconvenio_adicional_Clipaiconve, false, includeNonInitialized);
      AddObjectProperty("CliConvenio", gxTv_Sdtconvenio_adicional_Cliconvenio, false, includeNonInitialized);
      AddObjectProperty("ConveAdicod", gxTv_Sdtconvenio_adicional_Conveadicod, false, includeNonInitialized);
      AddObjectProperty("ConveAdiDescri", gxTv_Sdtconvenio_adicional_Conveadidescri, false, includeNonInitialized);
      AddObjectProperty("ConveAdiAli", gxTv_Sdtconvenio_adicional_Conveadiali, false, includeNonInitialized);
      AddObjectProperty("ConveAdiInfo", gxTv_Sdtconvenio_adicional_Conveadiinfo, false, includeNonInitialized);
      AddObjectProperty("ConveAdiInfo_N", gxTv_Sdtconvenio_adicional_Conveadiinfo_N, false, includeNonInitialized);
      AddObjectProperty("ConveAdiTipo", gxTv_Sdtconvenio_adicional_Conveaditipo, false, includeNonInitialized);
      AddObjectProperty("ConveAdiRelSec", gxTv_Sdtconvenio_adicional_Conveadirelsec, false, includeNonInitialized);
      AddObjectProperty("ConveAdiRelSec_N", gxTv_Sdtconvenio_adicional_Conveadirelsec_N, false, includeNonInitialized);
      AddObjectProperty("ConveAdiRelRef", gxTv_Sdtconvenio_adicional_Conveadirelref, false, includeNonInitialized);
      AddObjectProperty("ConveAdiOld", gxTv_Sdtconvenio_adicional_Conveadiold, false, includeNonInitialized);
      if ( gxTv_Sdtconvenio_adicional_Cancela != null )
      {
         AddObjectProperty("Cancela", gxTv_Sdtconvenio_adicional_Cancela, includeState, includeNonInitialized);
      }
      if ( gxTv_Sdtconvenio_adicional_Importes != null )
      {
         AddObjectProperty("importes", gxTv_Sdtconvenio_adicional_Importes, includeState, includeNonInitialized);
      }
      if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
      {
         AddObjectProperty("alicuotas", gxTv_Sdtconvenio_adicional_Alicuotas, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_Sdtconvenio_adicional_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_Sdtconvenio_adicional_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_Sdtconvenio_adicional_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("CliPaiConve_Z", gxTv_Sdtconvenio_adicional_Clipaiconve_Z, false, includeNonInitialized);
         AddObjectProperty("CliConvenio_Z", gxTv_Sdtconvenio_adicional_Cliconvenio_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdicod_Z", gxTv_Sdtconvenio_adicional_Conveadicod_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiDescri_Z", gxTv_Sdtconvenio_adicional_Conveadidescri_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiAli_Z", gxTv_Sdtconvenio_adicional_Conveadiali_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiTipo_Z", gxTv_Sdtconvenio_adicional_Conveaditipo_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiRelSec_Z", gxTv_Sdtconvenio_adicional_Conveadirelsec_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiRelRef_Z", gxTv_Sdtconvenio_adicional_Conveadirelref_Z, false, includeNonInitialized);
         AddObjectProperty("ConveAdiInfo_N", gxTv_Sdtconvenio_adicional_Conveadiinfo_N, false, includeNonInitialized);
         AddObjectProperty("ConveAdiRelSec_N", gxTv_Sdtconvenio_adicional_Conveadirelsec_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.Sdtconvenio_adicional sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Clicod = sdt.getgxTv_Sdtconvenio_adicional_Clicod() ;
      }
      if ( sdt.IsDirty("CliPaiConve") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Clipaiconve = sdt.getgxTv_Sdtconvenio_adicional_Clipaiconve() ;
      }
      if ( sdt.IsDirty("CliConvenio") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Cliconvenio = sdt.getgxTv_Sdtconvenio_adicional_Cliconvenio() ;
      }
      if ( sdt.IsDirty("ConveAdicod") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadicod = sdt.getgxTv_Sdtconvenio_adicional_Conveadicod() ;
      }
      if ( sdt.IsDirty("ConveAdiDescri") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadidescri = sdt.getgxTv_Sdtconvenio_adicional_Conveadidescri() ;
      }
      if ( sdt.IsDirty("ConveAdiAli") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadiali = sdt.getgxTv_Sdtconvenio_adicional_Conveadiali() ;
      }
      if ( sdt.IsDirty("ConveAdiInfo") )
      {
         gxTv_Sdtconvenio_adicional_Conveadiinfo_N = sdt.getgxTv_Sdtconvenio_adicional_Conveadiinfo_N() ;
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadiinfo = sdt.getgxTv_Sdtconvenio_adicional_Conveadiinfo() ;
      }
      if ( sdt.IsDirty("ConveAdiTipo") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveaditipo = sdt.getgxTv_Sdtconvenio_adicional_Conveaditipo() ;
      }
      if ( sdt.IsDirty("ConveAdiRelSec") )
      {
         gxTv_Sdtconvenio_adicional_Conveadirelsec_N = sdt.getgxTv_Sdtconvenio_adicional_Conveadirelsec_N() ;
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadirelsec = sdt.getgxTv_Sdtconvenio_adicional_Conveadirelsec() ;
      }
      if ( sdt.IsDirty("ConveAdiRelRef") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadirelref = sdt.getgxTv_Sdtconvenio_adicional_Conveadirelref() ;
      }
      if ( sdt.IsDirty("ConveAdiOld") )
      {
         gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
         gxTv_Sdtconvenio_adicional_Conveadiold = sdt.getgxTv_Sdtconvenio_adicional_Conveadiold() ;
      }
      if ( gxTv_Sdtconvenio_adicional_Cancela != null )
      {
         GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> newCollectionCancela = sdt.getgxTv_Sdtconvenio_adicional_Cancela();
         web.Sdtconvenio_adicional_Cancela currItemCancela;
         web.Sdtconvenio_adicional_Cancela newItemCancela;
         short idx = 1;
         while ( idx <= newCollectionCancela.size() )
         {
            newItemCancela = (web.Sdtconvenio_adicional_Cancela)((web.Sdtconvenio_adicional_Cancela)newCollectionCancela.elementAt(-1+idx));
            currItemCancela = (web.Sdtconvenio_adicional_Cancela)gxTv_Sdtconvenio_adicional_Cancela.getByKey(newItemCancela.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela());
            if ( GXutil.strcmp(currItemCancela.getgxTv_Sdtconvenio_adicional_Cancela_Mode(), "UPD") == 0 )
            {
               currItemCancela.updateDirties(newItemCancela);
               if ( GXutil.strcmp(newItemCancela.getgxTv_Sdtconvenio_adicional_Cancela_Mode(), "DLT") == 0 )
               {
                  currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Mode( "DLT" );
               }
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Modified( (short)(1) );
            }
            else
            {
               gxTv_Sdtconvenio_adicional_Cancela.add(newItemCancela, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_Sdtconvenio_adicional_Importes != null )
      {
         GXBCLevelCollection<web.Sdtconvenio_adicional_importes> newCollectionImportes = sdt.getgxTv_Sdtconvenio_adicional_Importes();
         web.Sdtconvenio_adicional_importes currItemImportes;
         web.Sdtconvenio_adicional_importes newItemImportes;
         short idx = 1;
         while ( idx <= newCollectionImportes.size() )
         {
            newItemImportes = (web.Sdtconvenio_adicional_importes)((web.Sdtconvenio_adicional_importes)newCollectionImportes.elementAt(-1+idx));
            currItemImportes = (web.Sdtconvenio_adicional_importes)gxTv_Sdtconvenio_adicional_Importes.getByKey(newItemImportes.getgxTv_Sdtconvenio_adicional_importes_Conveadivig());
            if ( GXutil.strcmp(currItemImportes.getgxTv_Sdtconvenio_adicional_importes_Mode(), "UPD") == 0 )
            {
               currItemImportes.updateDirties(newItemImportes);
               if ( GXutil.strcmp(newItemImportes.getgxTv_Sdtconvenio_adicional_importes_Mode(), "DLT") == 0 )
               {
                  currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Mode( "DLT" );
               }
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Modified( (short)(1) );
            }
            else
            {
               gxTv_Sdtconvenio_adicional_Importes.add(newItemImportes, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
      {
         GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> newCollectionAlicuotas = sdt.getgxTv_Sdtconvenio_adicional_Alicuotas();
         web.Sdtconvenio_adicional_alicuotas currItemAlicuotas;
         web.Sdtconvenio_adicional_alicuotas newItemAlicuotas;
         short idx = 1;
         while ( idx <= newCollectionAlicuotas.size() )
         {
            newItemAlicuotas = (web.Sdtconvenio_adicional_alicuotas)((web.Sdtconvenio_adicional_alicuotas)newCollectionAlicuotas.elementAt(-1+idx));
            currItemAlicuotas = (web.Sdtconvenio_adicional_alicuotas)gxTv_Sdtconvenio_adicional_Alicuotas.getByKey(newItemAlicuotas.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod());
            if ( GXutil.strcmp(currItemAlicuotas.getgxTv_Sdtconvenio_adicional_alicuotas_Mode(), "UPD") == 0 )
            {
               currItemAlicuotas.updateDirties(newItemAlicuotas);
               if ( GXutil.strcmp(newItemAlicuotas.getgxTv_Sdtconvenio_adicional_alicuotas_Mode(), "DLT") == 0 )
               {
                  currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( "DLT" );
               }
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( (short)(1) );
            }
            else
            {
               gxTv_Sdtconvenio_adicional_Alicuotas.add(newItemAlicuotas, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_Sdtconvenio_adicional_Clicod( )
   {
      return gxTv_Sdtconvenio_adicional_Clicod ;
   }

   public void setgxTv_Sdtconvenio_adicional_Clicod( int value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      if ( gxTv_Sdtconvenio_adicional_Clicod != value )
      {
         gxTv_Sdtconvenio_adicional_Mode = "INS" ;
         this.setgxTv_Sdtconvenio_adicional_Clicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Clipaiconve_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Cliconvenio_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadidescri_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadiali_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveaditipo_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelref_Z_SetNull( );
         if ( gxTv_Sdtconvenio_adicional_Cancela != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> collectionCancela = gxTv_Sdtconvenio_adicional_Cancela;
            web.Sdtconvenio_adicional_Cancela currItemCancela;
            short idx = 1;
            while ( idx <= collectionCancela.size() )
            {
               currItemCancela = (web.Sdtconvenio_adicional_Cancela)((web.Sdtconvenio_adicional_Cancela)collectionCancela.elementAt(-1+idx));
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Mode( "INS" );
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Importes != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_importes> collectionImportes = gxTv_Sdtconvenio_adicional_Importes;
            web.Sdtconvenio_adicional_importes currItemImportes;
            short idx = 1;
            while ( idx <= collectionImportes.size() )
            {
               currItemImportes = (web.Sdtconvenio_adicional_importes)((web.Sdtconvenio_adicional_importes)collectionImportes.elementAt(-1+idx));
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Mode( "INS" );
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> collectionAlicuotas = gxTv_Sdtconvenio_adicional_Alicuotas;
            web.Sdtconvenio_adicional_alicuotas currItemAlicuotas;
            short idx = 1;
            while ( idx <= collectionAlicuotas.size() )
            {
               currItemAlicuotas = (web.Sdtconvenio_adicional_alicuotas)((web.Sdtconvenio_adicional_alicuotas)collectionAlicuotas.elementAt(-1+idx));
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( "INS" );
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_Sdtconvenio_adicional_Clicod = value ;
   }

   public short getgxTv_Sdtconvenio_adicional_Clipaiconve( )
   {
      return gxTv_Sdtconvenio_adicional_Clipaiconve ;
   }

   public void setgxTv_Sdtconvenio_adicional_Clipaiconve( short value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      if ( gxTv_Sdtconvenio_adicional_Clipaiconve != value )
      {
         gxTv_Sdtconvenio_adicional_Mode = "INS" ;
         this.setgxTv_Sdtconvenio_adicional_Clicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Clipaiconve_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Cliconvenio_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadidescri_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadiali_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveaditipo_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelref_Z_SetNull( );
         if ( gxTv_Sdtconvenio_adicional_Cancela != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> collectionCancela = gxTv_Sdtconvenio_adicional_Cancela;
            web.Sdtconvenio_adicional_Cancela currItemCancela;
            short idx = 1;
            while ( idx <= collectionCancela.size() )
            {
               currItemCancela = (web.Sdtconvenio_adicional_Cancela)((web.Sdtconvenio_adicional_Cancela)collectionCancela.elementAt(-1+idx));
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Mode( "INS" );
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Importes != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_importes> collectionImportes = gxTv_Sdtconvenio_adicional_Importes;
            web.Sdtconvenio_adicional_importes currItemImportes;
            short idx = 1;
            while ( idx <= collectionImportes.size() )
            {
               currItemImportes = (web.Sdtconvenio_adicional_importes)((web.Sdtconvenio_adicional_importes)collectionImportes.elementAt(-1+idx));
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Mode( "INS" );
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> collectionAlicuotas = gxTv_Sdtconvenio_adicional_Alicuotas;
            web.Sdtconvenio_adicional_alicuotas currItemAlicuotas;
            short idx = 1;
            while ( idx <= collectionAlicuotas.size() )
            {
               currItemAlicuotas = (web.Sdtconvenio_adicional_alicuotas)((web.Sdtconvenio_adicional_alicuotas)collectionAlicuotas.elementAt(-1+idx));
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( "INS" );
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clipaiconve");
      gxTv_Sdtconvenio_adicional_Clipaiconve = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Cliconvenio( )
   {
      return gxTv_Sdtconvenio_adicional_Cliconvenio ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cliconvenio( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_Sdtconvenio_adicional_Cliconvenio, value) != 0 )
      {
         gxTv_Sdtconvenio_adicional_Mode = "INS" ;
         this.setgxTv_Sdtconvenio_adicional_Clicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Clipaiconve_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Cliconvenio_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadidescri_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadiali_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveaditipo_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelref_Z_SetNull( );
         if ( gxTv_Sdtconvenio_adicional_Cancela != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> collectionCancela = gxTv_Sdtconvenio_adicional_Cancela;
            web.Sdtconvenio_adicional_Cancela currItemCancela;
            short idx = 1;
            while ( idx <= collectionCancela.size() )
            {
               currItemCancela = (web.Sdtconvenio_adicional_Cancela)((web.Sdtconvenio_adicional_Cancela)collectionCancela.elementAt(-1+idx));
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Mode( "INS" );
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Importes != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_importes> collectionImportes = gxTv_Sdtconvenio_adicional_Importes;
            web.Sdtconvenio_adicional_importes currItemImportes;
            short idx = 1;
            while ( idx <= collectionImportes.size() )
            {
               currItemImportes = (web.Sdtconvenio_adicional_importes)((web.Sdtconvenio_adicional_importes)collectionImportes.elementAt(-1+idx));
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Mode( "INS" );
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> collectionAlicuotas = gxTv_Sdtconvenio_adicional_Alicuotas;
            web.Sdtconvenio_adicional_alicuotas currItemAlicuotas;
            short idx = 1;
            while ( idx <= collectionAlicuotas.size() )
            {
               currItemAlicuotas = (web.Sdtconvenio_adicional_alicuotas)((web.Sdtconvenio_adicional_alicuotas)collectionAlicuotas.elementAt(-1+idx));
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( "INS" );
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Cliconvenio");
      gxTv_Sdtconvenio_adicional_Cliconvenio = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadicod( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadicod ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadicod( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_Sdtconvenio_adicional_Conveadicod, value) != 0 )
      {
         gxTv_Sdtconvenio_adicional_Mode = "INS" ;
         this.setgxTv_Sdtconvenio_adicional_Clicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Clipaiconve_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Cliconvenio_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadicod_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadidescri_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadiali_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveaditipo_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z_SetNull( );
         this.setgxTv_Sdtconvenio_adicional_Conveadirelref_Z_SetNull( );
         if ( gxTv_Sdtconvenio_adicional_Cancela != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> collectionCancela = gxTv_Sdtconvenio_adicional_Cancela;
            web.Sdtconvenio_adicional_Cancela currItemCancela;
            short idx = 1;
            while ( idx <= collectionCancela.size() )
            {
               currItemCancela = (web.Sdtconvenio_adicional_Cancela)((web.Sdtconvenio_adicional_Cancela)collectionCancela.elementAt(-1+idx));
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Mode( "INS" );
               currItemCancela.setgxTv_Sdtconvenio_adicional_Cancela_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Importes != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_importes> collectionImportes = gxTv_Sdtconvenio_adicional_Importes;
            web.Sdtconvenio_adicional_importes currItemImportes;
            short idx = 1;
            while ( idx <= collectionImportes.size() )
            {
               currItemImportes = (web.Sdtconvenio_adicional_importes)((web.Sdtconvenio_adicional_importes)collectionImportes.elementAt(-1+idx));
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Mode( "INS" );
               currItemImportes.setgxTv_Sdtconvenio_adicional_importes_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_Sdtconvenio_adicional_Alicuotas != null )
         {
            GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> collectionAlicuotas = gxTv_Sdtconvenio_adicional_Alicuotas;
            web.Sdtconvenio_adicional_alicuotas currItemAlicuotas;
            short idx = 1;
            while ( idx <= collectionAlicuotas.size() )
            {
               currItemAlicuotas = (web.Sdtconvenio_adicional_alicuotas)((web.Sdtconvenio_adicional_alicuotas)collectionAlicuotas.elementAt(-1+idx));
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( "INS" );
               currItemAlicuotas.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Conveadicod");
      gxTv_Sdtconvenio_adicional_Conveadicod = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadidescri( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadidescri ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadidescri( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadidescri");
      gxTv_Sdtconvenio_adicional_Conveadidescri = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_adicional_Conveadiali( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiali ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiali( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadiali");
      gxTv_Sdtconvenio_adicional_Conveadiali = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadiinfo( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiinfo ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiinfo( String value )
   {
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadiinfo");
      gxTv_Sdtconvenio_adicional_Conveadiinfo = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiinfo_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_Conveadiinfo = "" ;
      SetDirty("Conveadiinfo");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadiinfo_IsNull( )
   {
      return (gxTv_Sdtconvenio_adicional_Conveadiinfo_N==1) ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveaditipo( )
   {
      return gxTv_Sdtconvenio_adicional_Conveaditipo ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveaditipo( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveaditipo");
      gxTv_Sdtconvenio_adicional_Conveaditipo = value ;
   }

   public int getgxTv_Sdtconvenio_adicional_Conveadirelsec( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelsec ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelsec( int value )
   {
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = (byte)(0) ;
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadirelsec");
      gxTv_Sdtconvenio_adicional_Conveadirelsec = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelsec_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_Conveadirelsec = 0 ;
      SetDirty("Conveadirelsec");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadirelsec_IsNull( )
   {
      return (gxTv_Sdtconvenio_adicional_Conveadirelsec_N==1) ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadirelref( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelref ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelref( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadirelref");
      gxTv_Sdtconvenio_adicional_Conveadirelref = value ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadiold( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiold ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiold( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadiold");
      gxTv_Sdtconvenio_adicional_Conveadiold = value ;
   }

   public GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> getgxTv_Sdtconvenio_adicional_Cancela( )
   {
      if ( gxTv_Sdtconvenio_adicional_Cancela == null )
      {
         gxTv_Sdtconvenio_adicional_Cancela = new GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela>(web.Sdtconvenio_adicional_Cancela.class, "convenio_adicional.Cancela", "PayDay", remoteHandle);
      }
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      return gxTv_Sdtconvenio_adicional_Cancela ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela( GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Cancela");
      gxTv_Sdtconvenio_adicional_Cancela = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cancela_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cancela = null ;
      SetDirty("Cancela");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cancela_IsNull( )
   {
      if ( gxTv_Sdtconvenio_adicional_Cancela == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.Sdtconvenio_adicional_importes> getgxTv_Sdtconvenio_adicional_Importes( )
   {
      if ( gxTv_Sdtconvenio_adicional_Importes == null )
      {
         gxTv_Sdtconvenio_adicional_Importes = new GXBCLevelCollection<web.Sdtconvenio_adicional_importes>(web.Sdtconvenio_adicional_importes.class, "convenio_adicional.importes", "PayDay", remoteHandle);
      }
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      return gxTv_Sdtconvenio_adicional_Importes ;
   }

   public void setgxTv_Sdtconvenio_adicional_Importes( GXBCLevelCollection<web.Sdtconvenio_adicional_importes> value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Importes");
      gxTv_Sdtconvenio_adicional_Importes = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Importes_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Importes = null ;
      SetDirty("Importes");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Importes_IsNull( )
   {
      if ( gxTv_Sdtconvenio_adicional_Importes == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> getgxTv_Sdtconvenio_adicional_Alicuotas( )
   {
      if ( gxTv_Sdtconvenio_adicional_Alicuotas == null )
      {
         gxTv_Sdtconvenio_adicional_Alicuotas = new GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas>(web.Sdtconvenio_adicional_alicuotas.class, "convenio_adicional.alicuotas", "PayDay", remoteHandle);
      }
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      return gxTv_Sdtconvenio_adicional_Alicuotas ;
   }

   public void setgxTv_Sdtconvenio_adicional_Alicuotas( GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Alicuotas");
      gxTv_Sdtconvenio_adicional_Alicuotas = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Alicuotas_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Alicuotas = null ;
      SetDirty("Alicuotas");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Alicuotas_IsNull( )
   {
      if ( gxTv_Sdtconvenio_adicional_Alicuotas == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Mode( )
   {
      return gxTv_Sdtconvenio_adicional_Mode ;
   }

   public void setgxTv_Sdtconvenio_adicional_Mode( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_Sdtconvenio_adicional_Mode = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Mode_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_Initialized( )
   {
      return gxTv_Sdtconvenio_adicional_Initialized ;
   }

   public void setgxTv_Sdtconvenio_adicional_Initialized( short value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_Sdtconvenio_adicional_Initialized = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Initialized_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtconvenio_adicional_Clicod_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Clicod_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Clicod_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_Sdtconvenio_adicional_Clicod_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Clicod_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_Sdtconvenio_adicional_Clipaiconve_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Clipaiconve_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Clipaiconve_Z( short value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Clipaiconve_Z");
      gxTv_Sdtconvenio_adicional_Clipaiconve_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Clipaiconve_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Clipaiconve_Z = (short)(0) ;
      SetDirty("Clipaiconve_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Clipaiconve_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Cliconvenio_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Cliconvenio_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cliconvenio_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Cliconvenio_Z");
      gxTv_Sdtconvenio_adicional_Cliconvenio_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Cliconvenio_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Cliconvenio_Z = "" ;
      SetDirty("Cliconvenio_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Cliconvenio_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadicod_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadicod_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadicod_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadicod_Z");
      gxTv_Sdtconvenio_adicional_Conveadicod_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadicod_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadicod_Z = "" ;
      SetDirty("Conveadicod_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadidescri_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadidescri_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadidescri_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadidescri_Z");
      gxTv_Sdtconvenio_adicional_Conveadidescri_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadidescri_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadidescri_Z = "" ;
      SetDirty("Conveadidescri_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadidescri_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_adicional_Conveadiali_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiali_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiali_Z( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadiali_Z");
      gxTv_Sdtconvenio_adicional_Conveadiali_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiali_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadiali_Z = DecimalUtil.ZERO ;
      SetDirty("Conveadiali_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadiali_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveaditipo_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveaditipo_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveaditipo_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveaditipo_Z");
      gxTv_Sdtconvenio_adicional_Conveaditipo_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveaditipo_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveaditipo_Z = "" ;
      SetDirty("Conveaditipo_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveaditipo_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_Sdtconvenio_adicional_Conveadirelsec_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelsec_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z( int value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadirelsec_Z");
      gxTv_Sdtconvenio_adicional_Conveadirelsec_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadirelsec_Z = 0 ;
      SetDirty("Conveadirelsec_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadirelsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_Sdtconvenio_adicional_Conveadirelref_Z( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelref_Z ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelref_Z( String value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadirelref_Z");
      gxTv_Sdtconvenio_adicional_Conveadirelref_Z = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelref_Z_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadirelref_Z = "" ;
      SetDirty("Conveadirelref_Z");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadirelref_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtconvenio_adicional_Conveadiinfo_N( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadiinfo_N ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiinfo_N( byte value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadiinfo_N");
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadiinfo_N_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadiinfo_N = (byte)(0) ;
      SetDirty("Conveadiinfo_N");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadiinfo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_Sdtconvenio_adicional_Conveadirelsec_N( )
   {
      return gxTv_Sdtconvenio_adicional_Conveadirelsec_N ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelsec_N( byte value )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(0) ;
      SetDirty("Conveadirelsec_N");
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = value ;
   }

   public void setgxTv_Sdtconvenio_adicional_Conveadirelsec_N_SetNull( )
   {
      gxTv_Sdtconvenio_adicional_Conveadirelsec_N = (byte)(0) ;
      SetDirty("Conveadirelsec_N");
   }

   public boolean getgxTv_Sdtconvenio_adicional_Conveadirelsec_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.convenio_adicional_bc obj;
      obj = new web.convenio_adicional_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_Sdtconvenio_adicional_N = (byte)(1) ;
      gxTv_Sdtconvenio_adicional_Cliconvenio = "" ;
      gxTv_Sdtconvenio_adicional_Conveadicod = "" ;
      gxTv_Sdtconvenio_adicional_Conveadidescri = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiali = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_adicional_Conveadiinfo = "" ;
      gxTv_Sdtconvenio_adicional_Conveaditipo = "" ;
      gxTv_Sdtconvenio_adicional_Conveadirelref = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiold = "" ;
      gxTv_Sdtconvenio_adicional_Mode = "" ;
      gxTv_Sdtconvenio_adicional_Cliconvenio_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadicod_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadidescri_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadiali_Z = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_adicional_Conveaditipo_Z = "" ;
      gxTv_Sdtconvenio_adicional_Conveadirelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtconvenio_adicional_N ;
   }

   public web.Sdtconvenio_adicional Clone( )
   {
      web.Sdtconvenio_adicional sdt;
      web.convenio_adicional_bc obj;
      sdt = (web.Sdtconvenio_adicional)(clone()) ;
      obj = (web.convenio_adicional_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtconvenio_adicional struct )
   {
      setgxTv_Sdtconvenio_adicional_Clicod(struct.getClicod());
      setgxTv_Sdtconvenio_adicional_Clipaiconve(struct.getClipaiconve());
      setgxTv_Sdtconvenio_adicional_Cliconvenio(struct.getCliconvenio());
      setgxTv_Sdtconvenio_adicional_Conveadicod(struct.getConveadicod());
      setgxTv_Sdtconvenio_adicional_Conveadidescri(struct.getConveadidescri());
      setgxTv_Sdtconvenio_adicional_Conveadiali(struct.getConveadiali());
      setgxTv_Sdtconvenio_adicional_Conveadiinfo(struct.getConveadiinfo());
      setgxTv_Sdtconvenio_adicional_Conveaditipo(struct.getConveaditipo());
      setgxTv_Sdtconvenio_adicional_Conveadirelsec(struct.getConveadirelsec());
      setgxTv_Sdtconvenio_adicional_Conveadirelref(struct.getConveadirelref());
      setgxTv_Sdtconvenio_adicional_Conveadiold(struct.getConveadiold());
      GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> gxTv_Sdtconvenio_adicional_Cancela_aux = new GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela>(web.Sdtconvenio_adicional_Cancela.class, "convenio_adicional.Cancela", "PayDay", remoteHandle);
      Vector<web.StructSdtconvenio_adicional_Cancela> gxTv_Sdtconvenio_adicional_Cancela_aux1 = struct.getCancela();
      if (gxTv_Sdtconvenio_adicional_Cancela_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtconvenio_adicional_Cancela_aux1.size(); i++)
         {
            gxTv_Sdtconvenio_adicional_Cancela_aux.add(new web.Sdtconvenio_adicional_Cancela(remoteHandle, gxTv_Sdtconvenio_adicional_Cancela_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtconvenio_adicional_Cancela(gxTv_Sdtconvenio_adicional_Cancela_aux);
      GXBCLevelCollection<web.Sdtconvenio_adicional_importes> gxTv_Sdtconvenio_adicional_Importes_aux = new GXBCLevelCollection<web.Sdtconvenio_adicional_importes>(web.Sdtconvenio_adicional_importes.class, "convenio_adicional.importes", "PayDay", remoteHandle);
      Vector<web.StructSdtconvenio_adicional_importes> gxTv_Sdtconvenio_adicional_Importes_aux1 = struct.getImportes();
      if (gxTv_Sdtconvenio_adicional_Importes_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtconvenio_adicional_Importes_aux1.size(); i++)
         {
            gxTv_Sdtconvenio_adicional_Importes_aux.add(new web.Sdtconvenio_adicional_importes(remoteHandle, gxTv_Sdtconvenio_adicional_Importes_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtconvenio_adicional_Importes(gxTv_Sdtconvenio_adicional_Importes_aux);
      GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> gxTv_Sdtconvenio_adicional_Alicuotas_aux = new GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas>(web.Sdtconvenio_adicional_alicuotas.class, "convenio_adicional.alicuotas", "PayDay", remoteHandle);
      Vector<web.StructSdtconvenio_adicional_alicuotas> gxTv_Sdtconvenio_adicional_Alicuotas_aux1 = struct.getAlicuotas();
      if (gxTv_Sdtconvenio_adicional_Alicuotas_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtconvenio_adicional_Alicuotas_aux1.size(); i++)
         {
            gxTv_Sdtconvenio_adicional_Alicuotas_aux.add(new web.Sdtconvenio_adicional_alicuotas(remoteHandle, gxTv_Sdtconvenio_adicional_Alicuotas_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtconvenio_adicional_Alicuotas(gxTv_Sdtconvenio_adicional_Alicuotas_aux);
      setgxTv_Sdtconvenio_adicional_Mode(struct.getMode());
      setgxTv_Sdtconvenio_adicional_Initialized(struct.getInitialized());
      setgxTv_Sdtconvenio_adicional_Clicod_Z(struct.getClicod_Z());
      setgxTv_Sdtconvenio_adicional_Clipaiconve_Z(struct.getClipaiconve_Z());
      setgxTv_Sdtconvenio_adicional_Cliconvenio_Z(struct.getCliconvenio_Z());
      setgxTv_Sdtconvenio_adicional_Conveadicod_Z(struct.getConveadicod_Z());
      setgxTv_Sdtconvenio_adicional_Conveadidescri_Z(struct.getConveadidescri_Z());
      setgxTv_Sdtconvenio_adicional_Conveadiali_Z(struct.getConveadiali_Z());
      setgxTv_Sdtconvenio_adicional_Conveaditipo_Z(struct.getConveaditipo_Z());
      setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z(struct.getConveadirelsec_Z());
      setgxTv_Sdtconvenio_adicional_Conveadirelref_Z(struct.getConveadirelref_Z());
      setgxTv_Sdtconvenio_adicional_Conveadiinfo_N(struct.getConveadiinfo_N());
      setgxTv_Sdtconvenio_adicional_Conveadirelsec_N(struct.getConveadirelsec_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtconvenio_adicional getStruct( )
   {
      web.StructSdtconvenio_adicional struct = new web.StructSdtconvenio_adicional ();
      struct.setClicod(getgxTv_Sdtconvenio_adicional_Clicod());
      struct.setClipaiconve(getgxTv_Sdtconvenio_adicional_Clipaiconve());
      struct.setCliconvenio(getgxTv_Sdtconvenio_adicional_Cliconvenio());
      struct.setConveadicod(getgxTv_Sdtconvenio_adicional_Conveadicod());
      struct.setConveadidescri(getgxTv_Sdtconvenio_adicional_Conveadidescri());
      struct.setConveadiali(getgxTv_Sdtconvenio_adicional_Conveadiali());
      struct.setConveadiinfo(getgxTv_Sdtconvenio_adicional_Conveadiinfo());
      struct.setConveaditipo(getgxTv_Sdtconvenio_adicional_Conveaditipo());
      struct.setConveadirelsec(getgxTv_Sdtconvenio_adicional_Conveadirelsec());
      struct.setConveadirelref(getgxTv_Sdtconvenio_adicional_Conveadirelref());
      struct.setConveadiold(getgxTv_Sdtconvenio_adicional_Conveadiold());
      struct.setCancela(getgxTv_Sdtconvenio_adicional_Cancela().getStruct());
      struct.setImportes(getgxTv_Sdtconvenio_adicional_Importes().getStruct());
      struct.setAlicuotas(getgxTv_Sdtconvenio_adicional_Alicuotas().getStruct());
      struct.setMode(getgxTv_Sdtconvenio_adicional_Mode());
      struct.setInitialized(getgxTv_Sdtconvenio_adicional_Initialized());
      struct.setClicod_Z(getgxTv_Sdtconvenio_adicional_Clicod_Z());
      struct.setClipaiconve_Z(getgxTv_Sdtconvenio_adicional_Clipaiconve_Z());
      struct.setCliconvenio_Z(getgxTv_Sdtconvenio_adicional_Cliconvenio_Z());
      struct.setConveadicod_Z(getgxTv_Sdtconvenio_adicional_Conveadicod_Z());
      struct.setConveadidescri_Z(getgxTv_Sdtconvenio_adicional_Conveadidescri_Z());
      struct.setConveadiali_Z(getgxTv_Sdtconvenio_adicional_Conveadiali_Z());
      struct.setConveaditipo_Z(getgxTv_Sdtconvenio_adicional_Conveaditipo_Z());
      struct.setConveadirelsec_Z(getgxTv_Sdtconvenio_adicional_Conveadirelsec_Z());
      struct.setConveadirelref_Z(getgxTv_Sdtconvenio_adicional_Conveadirelref_Z());
      struct.setConveadiinfo_N(getgxTv_Sdtconvenio_adicional_Conveadiinfo_N());
      struct.setConveadirelsec_N(getgxTv_Sdtconvenio_adicional_Conveadirelsec_N());
      return struct ;
   }

   private byte gxTv_Sdtconvenio_adicional_N ;
   private byte gxTv_Sdtconvenio_adicional_Conveadiinfo_N ;
   private byte gxTv_Sdtconvenio_adicional_Conveadirelsec_N ;
   private short gxTv_Sdtconvenio_adicional_Clipaiconve ;
   private short gxTv_Sdtconvenio_adicional_Initialized ;
   private short gxTv_Sdtconvenio_adicional_Clipaiconve_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_Sdtconvenio_adicional_Clicod ;
   private int gxTv_Sdtconvenio_adicional_Conveadirelsec ;
   private int gxTv_Sdtconvenio_adicional_Clicod_Z ;
   private int gxTv_Sdtconvenio_adicional_Conveadirelsec_Z ;
   private java.math.BigDecimal gxTv_Sdtconvenio_adicional_Conveadiali ;
   private java.math.BigDecimal gxTv_Sdtconvenio_adicional_Conveadiali_Z ;
   private String gxTv_Sdtconvenio_adicional_Cliconvenio ;
   private String gxTv_Sdtconvenio_adicional_Conveadicod ;
   private String gxTv_Sdtconvenio_adicional_Conveaditipo ;
   private String gxTv_Sdtconvenio_adicional_Mode ;
   private String gxTv_Sdtconvenio_adicional_Cliconvenio_Z ;
   private String gxTv_Sdtconvenio_adicional_Conveadicod_Z ;
   private String gxTv_Sdtconvenio_adicional_Conveaditipo_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_Sdtconvenio_adicional_Conveadiinfo ;
   private String gxTv_Sdtconvenio_adicional_Conveadiold ;
   private String gxTv_Sdtconvenio_adicional_Conveadidescri ;
   private String gxTv_Sdtconvenio_adicional_Conveadirelref ;
   private String gxTv_Sdtconvenio_adicional_Conveadidescri_Z ;
   private String gxTv_Sdtconvenio_adicional_Conveadirelref_Z ;
   private GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> gxTv_Sdtconvenio_adicional_Cancela_aux ;
   private GXBCLevelCollection<web.Sdtconvenio_adicional_importes> gxTv_Sdtconvenio_adicional_Importes_aux ;
   private GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> gxTv_Sdtconvenio_adicional_Alicuotas_aux ;
   private GXBCLevelCollection<web.Sdtconvenio_adicional_Cancela> gxTv_Sdtconvenio_adicional_Cancela=null ;
   private GXBCLevelCollection<web.Sdtconvenio_adicional_importes> gxTv_Sdtconvenio_adicional_Importes=null ;
   private GXBCLevelCollection<web.Sdtconvenio_adicional_alicuotas> gxTv_Sdtconvenio_adicional_Alicuotas=null ;
}

