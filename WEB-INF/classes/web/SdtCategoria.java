package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCategoria extends GxSilentTrnSdt
{
   public SdtCategoria( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCategoria.class));
   }

   public SdtCategoria( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle, context, "SdtCategoria");
      initialize( remoteHandle) ;
   }

   public SdtCategoria( int remoteHandle ,
                        StructSdtCategoria struct )
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
                     String AV8CatCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1564CliPaiConve),AV1565CliConvenio,AV8CatCodigo});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"CliPaiConve", short.class}, new Object[]{"CliConvenio", String.class}, new Object[]{"CatCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Categoria");
      metadata.set("BT", "Categoria1");
      metadata.set("PK", "[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"CatCodigo\" ]");
      metadata.set("PKAssigned", "[ \"CliConvenio\",\"CliPaiConve\" ]");
      metadata.set("Levels", "[ \"Provincias\",\"valores\" ]");
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
               gxTv_SdtCategoria_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve") )
            {
               gxTv_SdtCategoria_Clipaiconve = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio") )
            {
               gxTv_SdtCategoria_Cliconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatCodigo") )
            {
               gxTv_SdtCategoria_Catcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatDescrip") )
            {
               gxTv_SdtCategoria_Catdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatDescripSinAc") )
            {
               gxTv_SdtCategoria_Catdescripsinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatClase") )
            {
               gxTv_SdtCategoria_Catclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatTipoTarifa") )
            {
               gxTv_SdtCategoria_Cattipotarifa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatFrecAct") )
            {
               gxTv_SdtCategoria_Catfrecact = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatRelSec") )
            {
               gxTv_SdtCategoria_Catrelsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatRelRef") )
            {
               gxTv_SdtCategoria_Catrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatOld") )
            {
               gxTv_SdtCategoria_Catold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAfipCod") )
            {
               gxTv_SdtCategoria_Catafipcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Provincias") )
            {
               if ( gxTv_SdtCategoria_Provincias == null )
               {
                  gxTv_SdtCategoria_Provincias = new GXBCLevelCollection<web.SdtCategoria_Provincias>(web.SdtCategoria_Provincias.class, "Categoria.Provincias", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtCategoria_Provincias.readxml(oReader, "Provincias") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Provincias") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "valores") )
            {
               if ( gxTv_SdtCategoria_Valores == null )
               {
                  gxTv_SdtCategoria_Valores = new GXBCLevelCollection<web.SdtCategoria_valores>(web.SdtCategoria_valores.class, "Categoria.valores", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtCategoria_Valores.readxml(oReader, "valores") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "valores") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCategoria_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCategoria_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtCategoria_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliPaiConve_Z") )
            {
               gxTv_SdtCategoria_Clipaiconve_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliConvenio_Z") )
            {
               gxTv_SdtCategoria_Cliconvenio_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatCodigo_Z") )
            {
               gxTv_SdtCategoria_Catcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatDescrip_Z") )
            {
               gxTv_SdtCategoria_Catdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatDescripSinAc_Z") )
            {
               gxTv_SdtCategoria_Catdescripsinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatClase_Z") )
            {
               gxTv_SdtCategoria_Catclase_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatTipoTarifa_Z") )
            {
               gxTv_SdtCategoria_Cattipotarifa_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatFrecAct_Z") )
            {
               gxTv_SdtCategoria_Catfrecact_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatRelSec_Z") )
            {
               gxTv_SdtCategoria_Catrelsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatRelRef_Z") )
            {
               gxTv_SdtCategoria_Catrelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAfipCod_Z") )
            {
               gxTv_SdtCategoria_Catafipcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatRelSec_N") )
            {
               gxTv_SdtCategoria_Catrelsec_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatAfipCod_N") )
            {
               gxTv_SdtCategoria_Catafipcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Categoria" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliPaiConve", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Clipaiconve, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliConvenio", gxTv_SdtCategoria_Cliconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatCodigo", gxTv_SdtCategoria_Catcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatDescrip", gxTv_SdtCategoria_Catdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatDescripSinAc", gxTv_SdtCategoria_Catdescripsinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatClase", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatTipoTarifa", gxTv_SdtCategoria_Cattipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatFrecAct", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catfrecact, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatRelSec", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catrelsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatRelRef", gxTv_SdtCategoria_Catrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatOld", gxTv_SdtCategoria_Catold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatAfipCod", gxTv_SdtCategoria_Catafipcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtCategoria_Provincias != null )
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
         gxTv_SdtCategoria_Provincias.writexml(oWriter, "Provincias", sNameSpace1, sIncludeState);
      }
      if ( gxTv_SdtCategoria_Valores != null )
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
         gxTv_SdtCategoria_Valores.writexml(oWriter, "valores", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtCategoria_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliPaiConve_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Clipaiconve_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliConvenio_Z", gxTv_SdtCategoria_Cliconvenio_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatCodigo_Z", gxTv_SdtCategoria_Catcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatDescrip_Z", gxTv_SdtCategoria_Catdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatDescripSinAc_Z", gxTv_SdtCategoria_Catdescripsinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatClase_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catclase_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatTipoTarifa_Z", gxTv_SdtCategoria_Cattipotarifa_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatFrecAct_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catfrecact_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catrelsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatRelRef_Z", gxTv_SdtCategoria_Catrelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatAfipCod_Z", gxTv_SdtCategoria_Catafipcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatRelSec_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catrelsec_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatAfipCod_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Catafipcod_N, 1, 0)));
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
      AddObjectProperty("CliCod", gxTv_SdtCategoria_Clicod, false, includeNonInitialized);
      AddObjectProperty("CliPaiConve", gxTv_SdtCategoria_Clipaiconve, false, includeNonInitialized);
      AddObjectProperty("CliConvenio", gxTv_SdtCategoria_Cliconvenio, false, includeNonInitialized);
      AddObjectProperty("CatCodigo", gxTv_SdtCategoria_Catcodigo, false, includeNonInitialized);
      AddObjectProperty("CatDescrip", gxTv_SdtCategoria_Catdescrip, false, includeNonInitialized);
      AddObjectProperty("CatDescripSinAc", gxTv_SdtCategoria_Catdescripsinac, false, includeNonInitialized);
      AddObjectProperty("CatClase", gxTv_SdtCategoria_Catclase, false, includeNonInitialized);
      AddObjectProperty("CatTipoTarifa", gxTv_SdtCategoria_Cattipotarifa, false, includeNonInitialized);
      AddObjectProperty("CatFrecAct", gxTv_SdtCategoria_Catfrecact, false, includeNonInitialized);
      AddObjectProperty("CatRelSec", gxTv_SdtCategoria_Catrelsec, false, includeNonInitialized);
      AddObjectProperty("CatRelSec_N", gxTv_SdtCategoria_Catrelsec_N, false, includeNonInitialized);
      AddObjectProperty("CatRelRef", gxTv_SdtCategoria_Catrelref, false, includeNonInitialized);
      AddObjectProperty("CatOld", gxTv_SdtCategoria_Catold, false, includeNonInitialized);
      AddObjectProperty("CatAfipCod", gxTv_SdtCategoria_Catafipcod, false, includeNonInitialized);
      AddObjectProperty("CatAfipCod_N", gxTv_SdtCategoria_Catafipcod_N, false, includeNonInitialized);
      if ( gxTv_SdtCategoria_Provincias != null )
      {
         AddObjectProperty("Provincias", gxTv_SdtCategoria_Provincias, includeState, includeNonInitialized);
      }
      if ( gxTv_SdtCategoria_Valores != null )
      {
         AddObjectProperty("valores", gxTv_SdtCategoria_Valores, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCategoria_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCategoria_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtCategoria_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("CliPaiConve_Z", gxTv_SdtCategoria_Clipaiconve_Z, false, includeNonInitialized);
         AddObjectProperty("CliConvenio_Z", gxTv_SdtCategoria_Cliconvenio_Z, false, includeNonInitialized);
         AddObjectProperty("CatCodigo_Z", gxTv_SdtCategoria_Catcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("CatDescrip_Z", gxTv_SdtCategoria_Catdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("CatDescripSinAc_Z", gxTv_SdtCategoria_Catdescripsinac_Z, false, includeNonInitialized);
         AddObjectProperty("CatClase_Z", gxTv_SdtCategoria_Catclase_Z, false, includeNonInitialized);
         AddObjectProperty("CatTipoTarifa_Z", gxTv_SdtCategoria_Cattipotarifa_Z, false, includeNonInitialized);
         AddObjectProperty("CatFrecAct_Z", gxTv_SdtCategoria_Catfrecact_Z, false, includeNonInitialized);
         AddObjectProperty("CatRelSec_Z", gxTv_SdtCategoria_Catrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("CatRelRef_Z", gxTv_SdtCategoria_Catrelref_Z, false, includeNonInitialized);
         AddObjectProperty("CatAfipCod_Z", gxTv_SdtCategoria_Catafipcod_Z, false, includeNonInitialized);
         AddObjectProperty("CatRelSec_N", gxTv_SdtCategoria_Catrelsec_N, false, includeNonInitialized);
         AddObjectProperty("CatAfipCod_N", gxTv_SdtCategoria_Catafipcod_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtCategoria sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Clicod = sdt.getgxTv_SdtCategoria_Clicod() ;
      }
      if ( sdt.IsDirty("CliPaiConve") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Clipaiconve = sdt.getgxTv_SdtCategoria_Clipaiconve() ;
      }
      if ( sdt.IsDirty("CliConvenio") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Cliconvenio = sdt.getgxTv_SdtCategoria_Cliconvenio() ;
      }
      if ( sdt.IsDirty("CatCodigo") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catcodigo = sdt.getgxTv_SdtCategoria_Catcodigo() ;
      }
      if ( sdt.IsDirty("CatDescrip") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catdescrip = sdt.getgxTv_SdtCategoria_Catdescrip() ;
      }
      if ( sdt.IsDirty("CatDescripSinAc") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catdescripsinac = sdt.getgxTv_SdtCategoria_Catdescripsinac() ;
      }
      if ( sdt.IsDirty("CatClase") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catclase = sdt.getgxTv_SdtCategoria_Catclase() ;
      }
      if ( sdt.IsDirty("CatTipoTarifa") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Cattipotarifa = sdt.getgxTv_SdtCategoria_Cattipotarifa() ;
      }
      if ( sdt.IsDirty("CatFrecAct") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catfrecact = sdt.getgxTv_SdtCategoria_Catfrecact() ;
      }
      if ( sdt.IsDirty("CatRelSec") )
      {
         gxTv_SdtCategoria_Catrelsec_N = sdt.getgxTv_SdtCategoria_Catrelsec_N() ;
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catrelsec = sdt.getgxTv_SdtCategoria_Catrelsec() ;
      }
      if ( sdt.IsDirty("CatRelRef") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catrelref = sdt.getgxTv_SdtCategoria_Catrelref() ;
      }
      if ( sdt.IsDirty("CatOld") )
      {
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catold = sdt.getgxTv_SdtCategoria_Catold() ;
      }
      if ( sdt.IsDirty("CatAfipCod") )
      {
         gxTv_SdtCategoria_Catafipcod_N = sdt.getgxTv_SdtCategoria_Catafipcod_N() ;
         gxTv_SdtCategoria_N = (byte)(0) ;
         gxTv_SdtCategoria_Catafipcod = sdt.getgxTv_SdtCategoria_Catafipcod() ;
      }
      if ( gxTv_SdtCategoria_Provincias != null )
      {
         GXBCLevelCollection<web.SdtCategoria_Provincias> newCollectionProvincias = sdt.getgxTv_SdtCategoria_Provincias();
         web.SdtCategoria_Provincias currItemProvincias;
         web.SdtCategoria_Provincias newItemProvincias;
         short idx = 1;
         while ( idx <= newCollectionProvincias.size() )
         {
            newItemProvincias = (web.SdtCategoria_Provincias)((web.SdtCategoria_Provincias)newCollectionProvincias.elementAt(-1+idx));
            currItemProvincias = (web.SdtCategoria_Provincias)gxTv_SdtCategoria_Provincias.getByKey(newItemProvincias.getgxTv_SdtCategoria_Provincias_Catpaicod(), newItemProvincias.getgxTv_SdtCategoria_Provincias_Catprovcod());
            if ( GXutil.strcmp(currItemProvincias.getgxTv_SdtCategoria_Provincias_Mode(), "UPD") == 0 )
            {
               currItemProvincias.updateDirties(newItemProvincias);
               if ( GXutil.strcmp(newItemProvincias.getgxTv_SdtCategoria_Provincias_Mode(), "DLT") == 0 )
               {
                  currItemProvincias.setgxTv_SdtCategoria_Provincias_Mode( "DLT" );
               }
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtCategoria_Provincias.add(newItemProvincias, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
      if ( gxTv_SdtCategoria_Valores != null )
      {
         GXBCLevelCollection<web.SdtCategoria_valores> newCollectionValores = sdt.getgxTv_SdtCategoria_Valores();
         web.SdtCategoria_valores currItemValores;
         web.SdtCategoria_valores newItemValores;
         short idx = 1;
         while ( idx <= newCollectionValores.size() )
         {
            newItemValores = (web.SdtCategoria_valores)((web.SdtCategoria_valores)newCollectionValores.elementAt(-1+idx));
            currItemValores = (web.SdtCategoria_valores)gxTv_SdtCategoria_Valores.getByKey(newItemValores.getgxTv_SdtCategoria_valores_Catvigencia());
            if ( GXutil.strcmp(currItemValores.getgxTv_SdtCategoria_valores_Mode(), "UPD") == 0 )
            {
               currItemValores.updateDirties(newItemValores);
               if ( GXutil.strcmp(newItemValores.getgxTv_SdtCategoria_valores_Mode(), "DLT") == 0 )
               {
                  currItemValores.setgxTv_SdtCategoria_valores_Mode( "DLT" );
               }
               currItemValores.setgxTv_SdtCategoria_valores_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtCategoria_Valores.add(newItemValores, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public int getgxTv_SdtCategoria_Clicod( )
   {
      return gxTv_SdtCategoria_Clicod ;
   }

   public void setgxTv_SdtCategoria_Clicod( int value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      if ( gxTv_SdtCategoria_Clicod != value )
      {
         gxTv_SdtCategoria_Mode = "INS" ;
         this.setgxTv_SdtCategoria_Clicod_Z_SetNull( );
         this.setgxTv_SdtCategoria_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catcodigo_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescrip_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescripsinac_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catclase_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cattipotarifa_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catfrecact_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelsec_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelref_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catafipcod_Z_SetNull( );
         if ( gxTv_SdtCategoria_Provincias != null )
         {
            GXBCLevelCollection<web.SdtCategoria_Provincias> collectionProvincias = gxTv_SdtCategoria_Provincias;
            web.SdtCategoria_Provincias currItemProvincias;
            short idx = 1;
            while ( idx <= collectionProvincias.size() )
            {
               currItemProvincias = (web.SdtCategoria_Provincias)((web.SdtCategoria_Provincias)collectionProvincias.elementAt(-1+idx));
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Mode( "INS" );
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtCategoria_Valores != null )
         {
            GXBCLevelCollection<web.SdtCategoria_valores> collectionValores = gxTv_SdtCategoria_Valores;
            web.SdtCategoria_valores currItemValores;
            short idx = 1;
            while ( idx <= collectionValores.size() )
            {
               currItemValores = (web.SdtCategoria_valores)((web.SdtCategoria_valores)collectionValores.elementAt(-1+idx));
               currItemValores.setgxTv_SdtCategoria_valores_Mode( "INS" );
               currItemValores.setgxTv_SdtCategoria_valores_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clicod");
      gxTv_SdtCategoria_Clicod = value ;
   }

   public short getgxTv_SdtCategoria_Clipaiconve( )
   {
      return gxTv_SdtCategoria_Clipaiconve ;
   }

   public void setgxTv_SdtCategoria_Clipaiconve( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      if ( gxTv_SdtCategoria_Clipaiconve != value )
      {
         gxTv_SdtCategoria_Mode = "INS" ;
         this.setgxTv_SdtCategoria_Clicod_Z_SetNull( );
         this.setgxTv_SdtCategoria_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catcodigo_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescrip_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescripsinac_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catclase_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cattipotarifa_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catfrecact_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelsec_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelref_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catafipcod_Z_SetNull( );
         if ( gxTv_SdtCategoria_Provincias != null )
         {
            GXBCLevelCollection<web.SdtCategoria_Provincias> collectionProvincias = gxTv_SdtCategoria_Provincias;
            web.SdtCategoria_Provincias currItemProvincias;
            short idx = 1;
            while ( idx <= collectionProvincias.size() )
            {
               currItemProvincias = (web.SdtCategoria_Provincias)((web.SdtCategoria_Provincias)collectionProvincias.elementAt(-1+idx));
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Mode( "INS" );
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtCategoria_Valores != null )
         {
            GXBCLevelCollection<web.SdtCategoria_valores> collectionValores = gxTv_SdtCategoria_Valores;
            web.SdtCategoria_valores currItemValores;
            short idx = 1;
            while ( idx <= collectionValores.size() )
            {
               currItemValores = (web.SdtCategoria_valores)((web.SdtCategoria_valores)collectionValores.elementAt(-1+idx));
               currItemValores.setgxTv_SdtCategoria_valores_Mode( "INS" );
               currItemValores.setgxTv_SdtCategoria_valores_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Clipaiconve");
      gxTv_SdtCategoria_Clipaiconve = value ;
   }

   public String getgxTv_SdtCategoria_Cliconvenio( )
   {
      return gxTv_SdtCategoria_Cliconvenio ;
   }

   public void setgxTv_SdtCategoria_Cliconvenio( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtCategoria_Cliconvenio, value) != 0 )
      {
         gxTv_SdtCategoria_Mode = "INS" ;
         this.setgxTv_SdtCategoria_Clicod_Z_SetNull( );
         this.setgxTv_SdtCategoria_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catcodigo_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescrip_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescripsinac_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catclase_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cattipotarifa_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catfrecact_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelsec_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelref_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catafipcod_Z_SetNull( );
         if ( gxTv_SdtCategoria_Provincias != null )
         {
            GXBCLevelCollection<web.SdtCategoria_Provincias> collectionProvincias = gxTv_SdtCategoria_Provincias;
            web.SdtCategoria_Provincias currItemProvincias;
            short idx = 1;
            while ( idx <= collectionProvincias.size() )
            {
               currItemProvincias = (web.SdtCategoria_Provincias)((web.SdtCategoria_Provincias)collectionProvincias.elementAt(-1+idx));
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Mode( "INS" );
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtCategoria_Valores != null )
         {
            GXBCLevelCollection<web.SdtCategoria_valores> collectionValores = gxTv_SdtCategoria_Valores;
            web.SdtCategoria_valores currItemValores;
            short idx = 1;
            while ( idx <= collectionValores.size() )
            {
               currItemValores = (web.SdtCategoria_valores)((web.SdtCategoria_valores)collectionValores.elementAt(-1+idx));
               currItemValores.setgxTv_SdtCategoria_valores_Mode( "INS" );
               currItemValores.setgxTv_SdtCategoria_valores_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Cliconvenio");
      gxTv_SdtCategoria_Cliconvenio = value ;
   }

   public String getgxTv_SdtCategoria_Catcodigo( )
   {
      return gxTv_SdtCategoria_Catcodigo ;
   }

   public void setgxTv_SdtCategoria_Catcodigo( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtCategoria_Catcodigo, value) != 0 )
      {
         gxTv_SdtCategoria_Mode = "INS" ;
         this.setgxTv_SdtCategoria_Clicod_Z_SetNull( );
         this.setgxTv_SdtCategoria_Clipaiconve_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cliconvenio_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catcodigo_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescrip_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catdescripsinac_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catclase_Z_SetNull( );
         this.setgxTv_SdtCategoria_Cattipotarifa_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catfrecact_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelsec_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catrelref_Z_SetNull( );
         this.setgxTv_SdtCategoria_Catafipcod_Z_SetNull( );
         if ( gxTv_SdtCategoria_Provincias != null )
         {
            GXBCLevelCollection<web.SdtCategoria_Provincias> collectionProvincias = gxTv_SdtCategoria_Provincias;
            web.SdtCategoria_Provincias currItemProvincias;
            short idx = 1;
            while ( idx <= collectionProvincias.size() )
            {
               currItemProvincias = (web.SdtCategoria_Provincias)((web.SdtCategoria_Provincias)collectionProvincias.elementAt(-1+idx));
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Mode( "INS" );
               currItemProvincias.setgxTv_SdtCategoria_Provincias_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
         if ( gxTv_SdtCategoria_Valores != null )
         {
            GXBCLevelCollection<web.SdtCategoria_valores> collectionValores = gxTv_SdtCategoria_Valores;
            web.SdtCategoria_valores currItemValores;
            short idx = 1;
            while ( idx <= collectionValores.size() )
            {
               currItemValores = (web.SdtCategoria_valores)((web.SdtCategoria_valores)collectionValores.elementAt(-1+idx));
               currItemValores.setgxTv_SdtCategoria_valores_Mode( "INS" );
               currItemValores.setgxTv_SdtCategoria_valores_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Catcodigo");
      gxTv_SdtCategoria_Catcodigo = value ;
   }

   public String getgxTv_SdtCategoria_Catdescrip( )
   {
      return gxTv_SdtCategoria_Catdescrip ;
   }

   public void setgxTv_SdtCategoria_Catdescrip( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catdescrip");
      gxTv_SdtCategoria_Catdescrip = value ;
   }

   public String getgxTv_SdtCategoria_Catdescripsinac( )
   {
      return gxTv_SdtCategoria_Catdescripsinac ;
   }

   public void setgxTv_SdtCategoria_Catdescripsinac( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catdescripsinac");
      gxTv_SdtCategoria_Catdescripsinac = value ;
   }

   public byte getgxTv_SdtCategoria_Catclase( )
   {
      return gxTv_SdtCategoria_Catclase ;
   }

   public void setgxTv_SdtCategoria_Catclase( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catclase");
      gxTv_SdtCategoria_Catclase = value ;
   }

   public String getgxTv_SdtCategoria_Cattipotarifa( )
   {
      return gxTv_SdtCategoria_Cattipotarifa ;
   }

   public void setgxTv_SdtCategoria_Cattipotarifa( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Cattipotarifa");
      gxTv_SdtCategoria_Cattipotarifa = value ;
   }

   public byte getgxTv_SdtCategoria_Catfrecact( )
   {
      return gxTv_SdtCategoria_Catfrecact ;
   }

   public void setgxTv_SdtCategoria_Catfrecact( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catfrecact");
      gxTv_SdtCategoria_Catfrecact = value ;
   }

   public short getgxTv_SdtCategoria_Catrelsec( )
   {
      return gxTv_SdtCategoria_Catrelsec ;
   }

   public void setgxTv_SdtCategoria_Catrelsec( short value )
   {
      gxTv_SdtCategoria_Catrelsec_N = (byte)(0) ;
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catrelsec");
      gxTv_SdtCategoria_Catrelsec = value ;
   }

   public void setgxTv_SdtCategoria_Catrelsec_SetNull( )
   {
      gxTv_SdtCategoria_Catrelsec_N = (byte)(1) ;
      gxTv_SdtCategoria_Catrelsec = (short)(0) ;
      SetDirty("Catrelsec");
   }

   public boolean getgxTv_SdtCategoria_Catrelsec_IsNull( )
   {
      return (gxTv_SdtCategoria_Catrelsec_N==1) ;
   }

   public String getgxTv_SdtCategoria_Catrelref( )
   {
      return gxTv_SdtCategoria_Catrelref ;
   }

   public void setgxTv_SdtCategoria_Catrelref( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catrelref");
      gxTv_SdtCategoria_Catrelref = value ;
   }

   public String getgxTv_SdtCategoria_Catold( )
   {
      return gxTv_SdtCategoria_Catold ;
   }

   public void setgxTv_SdtCategoria_Catold( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catold");
      gxTv_SdtCategoria_Catold = value ;
   }

   public String getgxTv_SdtCategoria_Catafipcod( )
   {
      return gxTv_SdtCategoria_Catafipcod ;
   }

   public void setgxTv_SdtCategoria_Catafipcod( String value )
   {
      gxTv_SdtCategoria_Catafipcod_N = (byte)(0) ;
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catafipcod");
      gxTv_SdtCategoria_Catafipcod = value ;
   }

   public void setgxTv_SdtCategoria_Catafipcod_SetNull( )
   {
      gxTv_SdtCategoria_Catafipcod_N = (byte)(1) ;
      gxTv_SdtCategoria_Catafipcod = "" ;
      SetDirty("Catafipcod");
   }

   public boolean getgxTv_SdtCategoria_Catafipcod_IsNull( )
   {
      return (gxTv_SdtCategoria_Catafipcod_N==1) ;
   }

   public GXBCLevelCollection<web.SdtCategoria_Provincias> getgxTv_SdtCategoria_Provincias( )
   {
      if ( gxTv_SdtCategoria_Provincias == null )
      {
         gxTv_SdtCategoria_Provincias = new GXBCLevelCollection<web.SdtCategoria_Provincias>(web.SdtCategoria_Provincias.class, "Categoria.Provincias", "PayDay", remoteHandle);
      }
      gxTv_SdtCategoria_N = (byte)(0) ;
      return gxTv_SdtCategoria_Provincias ;
   }

   public void setgxTv_SdtCategoria_Provincias( GXBCLevelCollection<web.SdtCategoria_Provincias> value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Provincias");
      gxTv_SdtCategoria_Provincias = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_SetNull( )
   {
      gxTv_SdtCategoria_Provincias = null ;
      SetDirty("Provincias");
   }

   public boolean getgxTv_SdtCategoria_Provincias_IsNull( )
   {
      if ( gxTv_SdtCategoria_Provincias == null )
      {
         return true ;
      }
      return false ;
   }

   public GXBCLevelCollection<web.SdtCategoria_valores> getgxTv_SdtCategoria_Valores( )
   {
      if ( gxTv_SdtCategoria_Valores == null )
      {
         gxTv_SdtCategoria_Valores = new GXBCLevelCollection<web.SdtCategoria_valores>(web.SdtCategoria_valores.class, "Categoria.valores", "PayDay", remoteHandle);
      }
      gxTv_SdtCategoria_N = (byte)(0) ;
      return gxTv_SdtCategoria_Valores ;
   }

   public void setgxTv_SdtCategoria_Valores( GXBCLevelCollection<web.SdtCategoria_valores> value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Valores");
      gxTv_SdtCategoria_Valores = value ;
   }

   public void setgxTv_SdtCategoria_Valores_SetNull( )
   {
      gxTv_SdtCategoria_Valores = null ;
      SetDirty("Valores");
   }

   public boolean getgxTv_SdtCategoria_Valores_IsNull( )
   {
      if ( gxTv_SdtCategoria_Valores == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtCategoria_Mode( )
   {
      return gxTv_SdtCategoria_Mode ;
   }

   public void setgxTv_SdtCategoria_Mode( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCategoria_Mode = value ;
   }

   public void setgxTv_SdtCategoria_Mode_SetNull( )
   {
      gxTv_SdtCategoria_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtCategoria_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Initialized( )
   {
      return gxTv_SdtCategoria_Initialized ;
   }

   public void setgxTv_SdtCategoria_Initialized( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCategoria_Initialized = value ;
   }

   public void setgxTv_SdtCategoria_Initialized_SetNull( )
   {
      gxTv_SdtCategoria_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtCategoria_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCategoria_Clicod_Z( )
   {
      return gxTv_SdtCategoria_Clicod_Z ;
   }

   public void setgxTv_SdtCategoria_Clicod_Z( int value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtCategoria_Clicod_Z = value ;
   }

   public void setgxTv_SdtCategoria_Clicod_Z_SetNull( )
   {
      gxTv_SdtCategoria_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtCategoria_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Clipaiconve_Z( )
   {
      return gxTv_SdtCategoria_Clipaiconve_Z ;
   }

   public void setgxTv_SdtCategoria_Clipaiconve_Z( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Clipaiconve_Z");
      gxTv_SdtCategoria_Clipaiconve_Z = value ;
   }

   public void setgxTv_SdtCategoria_Clipaiconve_Z_SetNull( )
   {
      gxTv_SdtCategoria_Clipaiconve_Z = (short)(0) ;
      SetDirty("Clipaiconve_Z");
   }

   public boolean getgxTv_SdtCategoria_Clipaiconve_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Cliconvenio_Z( )
   {
      return gxTv_SdtCategoria_Cliconvenio_Z ;
   }

   public void setgxTv_SdtCategoria_Cliconvenio_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Cliconvenio_Z");
      gxTv_SdtCategoria_Cliconvenio_Z = value ;
   }

   public void setgxTv_SdtCategoria_Cliconvenio_Z_SetNull( )
   {
      gxTv_SdtCategoria_Cliconvenio_Z = "" ;
      SetDirty("Cliconvenio_Z");
   }

   public boolean getgxTv_SdtCategoria_Cliconvenio_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Catcodigo_Z( )
   {
      return gxTv_SdtCategoria_Catcodigo_Z ;
   }

   public void setgxTv_SdtCategoria_Catcodigo_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catcodigo_Z");
      gxTv_SdtCategoria_Catcodigo_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catcodigo_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catcodigo_Z = "" ;
      SetDirty("Catcodigo_Z");
   }

   public boolean getgxTv_SdtCategoria_Catcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Catdescrip_Z( )
   {
      return gxTv_SdtCategoria_Catdescrip_Z ;
   }

   public void setgxTv_SdtCategoria_Catdescrip_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catdescrip_Z");
      gxTv_SdtCategoria_Catdescrip_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catdescrip_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catdescrip_Z = "" ;
      SetDirty("Catdescrip_Z");
   }

   public boolean getgxTv_SdtCategoria_Catdescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Catdescripsinac_Z( )
   {
      return gxTv_SdtCategoria_Catdescripsinac_Z ;
   }

   public void setgxTv_SdtCategoria_Catdescripsinac_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catdescripsinac_Z");
      gxTv_SdtCategoria_Catdescripsinac_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catdescripsinac_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catdescripsinac_Z = "" ;
      SetDirty("Catdescripsinac_Z");
   }

   public boolean getgxTv_SdtCategoria_Catdescripsinac_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Catclase_Z( )
   {
      return gxTv_SdtCategoria_Catclase_Z ;
   }

   public void setgxTv_SdtCategoria_Catclase_Z( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catclase_Z");
      gxTv_SdtCategoria_Catclase_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catclase_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catclase_Z = (byte)(0) ;
      SetDirty("Catclase_Z");
   }

   public boolean getgxTv_SdtCategoria_Catclase_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Cattipotarifa_Z( )
   {
      return gxTv_SdtCategoria_Cattipotarifa_Z ;
   }

   public void setgxTv_SdtCategoria_Cattipotarifa_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Cattipotarifa_Z");
      gxTv_SdtCategoria_Cattipotarifa_Z = value ;
   }

   public void setgxTv_SdtCategoria_Cattipotarifa_Z_SetNull( )
   {
      gxTv_SdtCategoria_Cattipotarifa_Z = "" ;
      SetDirty("Cattipotarifa_Z");
   }

   public boolean getgxTv_SdtCategoria_Cattipotarifa_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Catfrecact_Z( )
   {
      return gxTv_SdtCategoria_Catfrecact_Z ;
   }

   public void setgxTv_SdtCategoria_Catfrecact_Z( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catfrecact_Z");
      gxTv_SdtCategoria_Catfrecact_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catfrecact_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catfrecact_Z = (byte)(0) ;
      SetDirty("Catfrecact_Z");
   }

   public boolean getgxTv_SdtCategoria_Catfrecact_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Catrelsec_Z( )
   {
      return gxTv_SdtCategoria_Catrelsec_Z ;
   }

   public void setgxTv_SdtCategoria_Catrelsec_Z( short value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catrelsec_Z");
      gxTv_SdtCategoria_Catrelsec_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catrelsec_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catrelsec_Z = (short)(0) ;
      SetDirty("Catrelsec_Z");
   }

   public boolean getgxTv_SdtCategoria_Catrelsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Catrelref_Z( )
   {
      return gxTv_SdtCategoria_Catrelref_Z ;
   }

   public void setgxTv_SdtCategoria_Catrelref_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catrelref_Z");
      gxTv_SdtCategoria_Catrelref_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catrelref_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catrelref_Z = "" ;
      SetDirty("Catrelref_Z");
   }

   public boolean getgxTv_SdtCategoria_Catrelref_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Catafipcod_Z( )
   {
      return gxTv_SdtCategoria_Catafipcod_Z ;
   }

   public void setgxTv_SdtCategoria_Catafipcod_Z( String value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catafipcod_Z");
      gxTv_SdtCategoria_Catafipcod_Z = value ;
   }

   public void setgxTv_SdtCategoria_Catafipcod_Z_SetNull( )
   {
      gxTv_SdtCategoria_Catafipcod_Z = "" ;
      SetDirty("Catafipcod_Z");
   }

   public boolean getgxTv_SdtCategoria_Catafipcod_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Catrelsec_N( )
   {
      return gxTv_SdtCategoria_Catrelsec_N ;
   }

   public void setgxTv_SdtCategoria_Catrelsec_N( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catrelsec_N");
      gxTv_SdtCategoria_Catrelsec_N = value ;
   }

   public void setgxTv_SdtCategoria_Catrelsec_N_SetNull( )
   {
      gxTv_SdtCategoria_Catrelsec_N = (byte)(0) ;
      SetDirty("Catrelsec_N");
   }

   public boolean getgxTv_SdtCategoria_Catrelsec_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Catafipcod_N( )
   {
      return gxTv_SdtCategoria_Catafipcod_N ;
   }

   public void setgxTv_SdtCategoria_Catafipcod_N( byte value )
   {
      gxTv_SdtCategoria_N = (byte)(0) ;
      SetDirty("Catafipcod_N");
      gxTv_SdtCategoria_Catafipcod_N = value ;
   }

   public void setgxTv_SdtCategoria_Catafipcod_N_SetNull( )
   {
      gxTv_SdtCategoria_Catafipcod_N = (byte)(0) ;
      SetDirty("Catafipcod_N");
   }

   public boolean getgxTv_SdtCategoria_Catafipcod_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.categoria_bc obj;
      obj = new web.categoria_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCategoria_N = (byte)(1) ;
      gxTv_SdtCategoria_Cliconvenio = "" ;
      gxTv_SdtCategoria_Catcodigo = "" ;
      gxTv_SdtCategoria_Catdescrip = "" ;
      gxTv_SdtCategoria_Catdescripsinac = "" ;
      gxTv_SdtCategoria_Cattipotarifa = "" ;
      gxTv_SdtCategoria_Catrelref = "" ;
      gxTv_SdtCategoria_Catold = "" ;
      gxTv_SdtCategoria_Catafipcod = "" ;
      gxTv_SdtCategoria_Mode = "" ;
      gxTv_SdtCategoria_Cliconvenio_Z = "" ;
      gxTv_SdtCategoria_Catcodigo_Z = "" ;
      gxTv_SdtCategoria_Catdescrip_Z = "" ;
      gxTv_SdtCategoria_Catdescripsinac_Z = "" ;
      gxTv_SdtCategoria_Cattipotarifa_Z = "" ;
      gxTv_SdtCategoria_Catrelref_Z = "" ;
      gxTv_SdtCategoria_Catafipcod_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCategoria_N ;
   }

   public web.SdtCategoria Clone( )
   {
      web.SdtCategoria sdt;
      web.categoria_bc obj;
      sdt = (web.SdtCategoria)(clone()) ;
      obj = (web.categoria_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtCategoria struct )
   {
      setgxTv_SdtCategoria_Clicod(struct.getClicod());
      setgxTv_SdtCategoria_Clipaiconve(struct.getClipaiconve());
      setgxTv_SdtCategoria_Cliconvenio(struct.getCliconvenio());
      setgxTv_SdtCategoria_Catcodigo(struct.getCatcodigo());
      setgxTv_SdtCategoria_Catdescrip(struct.getCatdescrip());
      setgxTv_SdtCategoria_Catdescripsinac(struct.getCatdescripsinac());
      setgxTv_SdtCategoria_Catclase(struct.getCatclase());
      setgxTv_SdtCategoria_Cattipotarifa(struct.getCattipotarifa());
      setgxTv_SdtCategoria_Catfrecact(struct.getCatfrecact());
      setgxTv_SdtCategoria_Catrelsec(struct.getCatrelsec());
      setgxTv_SdtCategoria_Catrelref(struct.getCatrelref());
      setgxTv_SdtCategoria_Catold(struct.getCatold());
      setgxTv_SdtCategoria_Catafipcod(struct.getCatafipcod());
      GXBCLevelCollection<web.SdtCategoria_Provincias> gxTv_SdtCategoria_Provincias_aux = new GXBCLevelCollection<web.SdtCategoria_Provincias>(web.SdtCategoria_Provincias.class, "Categoria.Provincias", "PayDay", remoteHandle);
      Vector<web.StructSdtCategoria_Provincias> gxTv_SdtCategoria_Provincias_aux1 = struct.getProvincias();
      if (gxTv_SdtCategoria_Provincias_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtCategoria_Provincias_aux1.size(); i++)
         {
            gxTv_SdtCategoria_Provincias_aux.add(new web.SdtCategoria_Provincias(remoteHandle, gxTv_SdtCategoria_Provincias_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtCategoria_Provincias(gxTv_SdtCategoria_Provincias_aux);
      GXBCLevelCollection<web.SdtCategoria_valores> gxTv_SdtCategoria_Valores_aux = new GXBCLevelCollection<web.SdtCategoria_valores>(web.SdtCategoria_valores.class, "Categoria.valores", "PayDay", remoteHandle);
      Vector<web.StructSdtCategoria_valores> gxTv_SdtCategoria_Valores_aux1 = struct.getValores();
      if (gxTv_SdtCategoria_Valores_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtCategoria_Valores_aux1.size(); i++)
         {
            gxTv_SdtCategoria_Valores_aux.add(new web.SdtCategoria_valores(remoteHandle, gxTv_SdtCategoria_Valores_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtCategoria_Valores(gxTv_SdtCategoria_Valores_aux);
      setgxTv_SdtCategoria_Mode(struct.getMode());
      setgxTv_SdtCategoria_Initialized(struct.getInitialized());
      setgxTv_SdtCategoria_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtCategoria_Clipaiconve_Z(struct.getClipaiconve_Z());
      setgxTv_SdtCategoria_Cliconvenio_Z(struct.getCliconvenio_Z());
      setgxTv_SdtCategoria_Catcodigo_Z(struct.getCatcodigo_Z());
      setgxTv_SdtCategoria_Catdescrip_Z(struct.getCatdescrip_Z());
      setgxTv_SdtCategoria_Catdescripsinac_Z(struct.getCatdescripsinac_Z());
      setgxTv_SdtCategoria_Catclase_Z(struct.getCatclase_Z());
      setgxTv_SdtCategoria_Cattipotarifa_Z(struct.getCattipotarifa_Z());
      setgxTv_SdtCategoria_Catfrecact_Z(struct.getCatfrecact_Z());
      setgxTv_SdtCategoria_Catrelsec_Z(struct.getCatrelsec_Z());
      setgxTv_SdtCategoria_Catrelref_Z(struct.getCatrelref_Z());
      setgxTv_SdtCategoria_Catafipcod_Z(struct.getCatafipcod_Z());
      setgxTv_SdtCategoria_Catrelsec_N(struct.getCatrelsec_N());
      setgxTv_SdtCategoria_Catafipcod_N(struct.getCatafipcod_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtCategoria getStruct( )
   {
      web.StructSdtCategoria struct = new web.StructSdtCategoria ();
      struct.setClicod(getgxTv_SdtCategoria_Clicod());
      struct.setClipaiconve(getgxTv_SdtCategoria_Clipaiconve());
      struct.setCliconvenio(getgxTv_SdtCategoria_Cliconvenio());
      struct.setCatcodigo(getgxTv_SdtCategoria_Catcodigo());
      struct.setCatdescrip(getgxTv_SdtCategoria_Catdescrip());
      struct.setCatdescripsinac(getgxTv_SdtCategoria_Catdescripsinac());
      struct.setCatclase(getgxTv_SdtCategoria_Catclase());
      struct.setCattipotarifa(getgxTv_SdtCategoria_Cattipotarifa());
      struct.setCatfrecact(getgxTv_SdtCategoria_Catfrecact());
      struct.setCatrelsec(getgxTv_SdtCategoria_Catrelsec());
      struct.setCatrelref(getgxTv_SdtCategoria_Catrelref());
      struct.setCatold(getgxTv_SdtCategoria_Catold());
      struct.setCatafipcod(getgxTv_SdtCategoria_Catafipcod());
      struct.setProvincias(getgxTv_SdtCategoria_Provincias().getStruct());
      struct.setValores(getgxTv_SdtCategoria_Valores().getStruct());
      struct.setMode(getgxTv_SdtCategoria_Mode());
      struct.setInitialized(getgxTv_SdtCategoria_Initialized());
      struct.setClicod_Z(getgxTv_SdtCategoria_Clicod_Z());
      struct.setClipaiconve_Z(getgxTv_SdtCategoria_Clipaiconve_Z());
      struct.setCliconvenio_Z(getgxTv_SdtCategoria_Cliconvenio_Z());
      struct.setCatcodigo_Z(getgxTv_SdtCategoria_Catcodigo_Z());
      struct.setCatdescrip_Z(getgxTv_SdtCategoria_Catdescrip_Z());
      struct.setCatdescripsinac_Z(getgxTv_SdtCategoria_Catdescripsinac_Z());
      struct.setCatclase_Z(getgxTv_SdtCategoria_Catclase_Z());
      struct.setCattipotarifa_Z(getgxTv_SdtCategoria_Cattipotarifa_Z());
      struct.setCatfrecact_Z(getgxTv_SdtCategoria_Catfrecact_Z());
      struct.setCatrelsec_Z(getgxTv_SdtCategoria_Catrelsec_Z());
      struct.setCatrelref_Z(getgxTv_SdtCategoria_Catrelref_Z());
      struct.setCatafipcod_Z(getgxTv_SdtCategoria_Catafipcod_Z());
      struct.setCatrelsec_N(getgxTv_SdtCategoria_Catrelsec_N());
      struct.setCatafipcod_N(getgxTv_SdtCategoria_Catafipcod_N());
      return struct ;
   }

   private byte gxTv_SdtCategoria_N ;
   private byte gxTv_SdtCategoria_Catclase ;
   private byte gxTv_SdtCategoria_Catfrecact ;
   private byte gxTv_SdtCategoria_Catclase_Z ;
   private byte gxTv_SdtCategoria_Catfrecact_Z ;
   private byte gxTv_SdtCategoria_Catrelsec_N ;
   private byte gxTv_SdtCategoria_Catafipcod_N ;
   private short gxTv_SdtCategoria_Clipaiconve ;
   private short gxTv_SdtCategoria_Catrelsec ;
   private short gxTv_SdtCategoria_Initialized ;
   private short gxTv_SdtCategoria_Clipaiconve_Z ;
   private short gxTv_SdtCategoria_Catrelsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtCategoria_Clicod ;
   private int gxTv_SdtCategoria_Clicod_Z ;
   private String gxTv_SdtCategoria_Cliconvenio ;
   private String gxTv_SdtCategoria_Catcodigo ;
   private String gxTv_SdtCategoria_Cattipotarifa ;
   private String gxTv_SdtCategoria_Catafipcod ;
   private String gxTv_SdtCategoria_Mode ;
   private String gxTv_SdtCategoria_Cliconvenio_Z ;
   private String gxTv_SdtCategoria_Catcodigo_Z ;
   private String gxTv_SdtCategoria_Cattipotarifa_Z ;
   private String gxTv_SdtCategoria_Catafipcod_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCategoria_Catold ;
   private String gxTv_SdtCategoria_Catdescrip ;
   private String gxTv_SdtCategoria_Catdescripsinac ;
   private String gxTv_SdtCategoria_Catrelref ;
   private String gxTv_SdtCategoria_Catdescrip_Z ;
   private String gxTv_SdtCategoria_Catdescripsinac_Z ;
   private String gxTv_SdtCategoria_Catrelref_Z ;
   private GXBCLevelCollection<web.SdtCategoria_Provincias> gxTv_SdtCategoria_Provincias_aux ;
   private GXBCLevelCollection<web.SdtCategoria_valores> gxTv_SdtCategoria_Valores_aux ;
   private GXBCLevelCollection<web.SdtCategoria_Provincias> gxTv_SdtCategoria_Provincias=null ;
   private GXBCLevelCollection<web.SdtCategoria_valores> gxTv_SdtCategoria_Valores=null ;
}

