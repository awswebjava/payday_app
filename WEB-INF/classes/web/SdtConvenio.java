package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConvenio extends GxSilentTrnSdt
{
   public SdtConvenio( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConvenio.class));
   }

   public SdtConvenio( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtConvenio");
      initialize( remoteHandle) ;
   }

   public SdtConvenio( int remoteHandle ,
                       StructSdtConvenio struct )
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

   public void Load( short AV46PaiCod ,
                     String AV9ConveCodigo )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV46PaiCod),AV9ConveCodigo});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaiCod", short.class}, new Object[]{"ConveCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Convenio");
      metadata.set("BT", "Convenio");
      metadata.set("PK", "[ \"PaiCod\",\"ConveCodigo\" ]");
      metadata.set("Levels", "[ \"PropiedadesAdicionales\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"SinCod\" ],\"FKMap\":[ \"ConveSinCod-SinCod\" ] } ]");
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
               gxTv_SdtConvenio_Paicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveCodigo") )
            {
               gxTv_SdtConvenio_Convecodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDescri") )
            {
               gxTv_SdtConvenio_Convedescri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHabilitada") )
            {
               gxTv_SdtConvenio_Convehabilitada = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDescriSinAc") )
            {
               gxTv_SdtConvenio_Convedescrisinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveSinCod") )
            {
               gxTv_SdtConvenio_Convesincod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveSinDesc") )
            {
               gxTv_SdtConvenio_Convesindesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBusGoogle") )
            {
               gxTv_SdtConvenio_Convbusgoogle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBusWeb") )
            {
               gxTv_SdtConvenio_Convbusweb = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBaseURL") )
            {
               gxTv_SdtConvenio_Convbaseurl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvScrapTipo") )
            {
               gxTv_SdtConvenio_Convscraptipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvScrapTDoc") )
            {
               gxTv_SdtConvenio_Convscraptdoc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveEscFrecAct") )
            {
               gxTv_SdtConvenio_Conveescfrecact = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveEsquemaEs") )
            {
               gxTv_SdtConvenio_Conveesquemaes = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PropiedadesAdicionales") )
            {
               if ( gxTv_SdtConvenio_Propiedadesadicionales == null )
               {
                  gxTv_SdtConvenio_Propiedadesadicionales = new GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales>(web.SdtConvenio_PropiedadesAdicionales.class, "Convenio.PropiedadesAdicionales", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtConvenio_Propiedadesadicionales.readxml(oReader, "PropiedadesAdicionales") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "PropiedadesAdicionales") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConvenio_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConvenio_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod_Z") )
            {
               gxTv_SdtConvenio_Paicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveCodigo_Z") )
            {
               gxTv_SdtConvenio_Convecodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDescri_Z") )
            {
               gxTv_SdtConvenio_Convedescri_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHabilitada_Z") )
            {
               gxTv_SdtConvenio_Convehabilitada_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDescriSinAc_Z") )
            {
               gxTv_SdtConvenio_Convedescrisinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveSinCod_Z") )
            {
               gxTv_SdtConvenio_Convesincod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveSinDesc_Z") )
            {
               gxTv_SdtConvenio_Convesindesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBusGoogle_Z") )
            {
               gxTv_SdtConvenio_Convbusgoogle_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBusWeb_Z") )
            {
               gxTv_SdtConvenio_Convbusweb_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBaseURL_Z") )
            {
               gxTv_SdtConvenio_Convbaseurl_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvScrapTipo_Z") )
            {
               gxTv_SdtConvenio_Convscraptipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvScrapTDoc_Z") )
            {
               gxTv_SdtConvenio_Convscraptdoc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveEscFrecAct_Z") )
            {
               gxTv_SdtConvenio_Conveescfrecact_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveEsquemaEs_Z") )
            {
               gxTv_SdtConvenio_Conveesquemaes_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveSinCod_N") )
            {
               gxTv_SdtConvenio_Convesincod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBusGoogle_N") )
            {
               gxTv_SdtConvenio_Convbusgoogle_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBusWeb_N") )
            {
               gxTv_SdtConvenio_Convbusweb_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvBaseURL_N") )
            {
               gxTv_SdtConvenio_Convbaseurl_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvScrapTipo_N") )
            {
               gxTv_SdtConvenio_Convscraptipo_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvScrapTDoc_N") )
            {
               gxTv_SdtConvenio_Convscraptdoc_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Convenio" ;
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
      oWriter.writeElement("PaiCod", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Paicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveCodigo", gxTv_SdtConvenio_Convecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDescri", gxTv_SdtConvenio_Convedescri);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHabilitada", GXutil.booltostr( gxTv_SdtConvenio_Convehabilitada));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDescriSinAc", gxTv_SdtConvenio_Convedescrisinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveSinCod", gxTv_SdtConvenio_Convesincod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveSinDesc", gxTv_SdtConvenio_Convesindesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvBusGoogle", gxTv_SdtConvenio_Convbusgoogle);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvBusWeb", gxTv_SdtConvenio_Convbusweb);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvBaseURL", gxTv_SdtConvenio_Convbaseurl);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvScrapTipo", gxTv_SdtConvenio_Convscraptipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvScrapTDoc", gxTv_SdtConvenio_Convscraptdoc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveEscFrecAct", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Conveescfrecact, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveEsquemaEs", GXutil.booltostr( gxTv_SdtConvenio_Conveesquemaes));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_SdtConvenio_Propiedadesadicionales != null )
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
         gxTv_SdtConvenio_Propiedadesadicionales.writexml(oWriter, "PropiedadesAdicionales", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtConvenio_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Paicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveCodigo_Z", gxTv_SdtConvenio_Convecodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveDescri_Z", gxTv_SdtConvenio_Convedescri_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveHabilitada_Z", GXutil.booltostr( gxTv_SdtConvenio_Convehabilitada_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveDescriSinAc_Z", gxTv_SdtConvenio_Convedescrisinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveSinCod_Z", gxTv_SdtConvenio_Convesincod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveSinDesc_Z", gxTv_SdtConvenio_Convesindesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvBusGoogle_Z", gxTv_SdtConvenio_Convbusgoogle_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvBusWeb_Z", gxTv_SdtConvenio_Convbusweb_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvBaseURL_Z", gxTv_SdtConvenio_Convbaseurl_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvScrapTipo_Z", gxTv_SdtConvenio_Convscraptipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvScrapTDoc_Z", gxTv_SdtConvenio_Convscraptdoc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveEscFrecAct_Z", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Conveescfrecact_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveEsquemaEs_Z", GXutil.booltostr( gxTv_SdtConvenio_Conveesquemaes_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConveSinCod_N", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Convesincod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvBusGoogle_N", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Convbusgoogle_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvBusWeb_N", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Convbusweb_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvBaseURL_N", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Convbaseurl_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvScrapTipo_N", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Convscraptipo_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvScrapTDoc_N", GXutil.trim( GXutil.str( gxTv_SdtConvenio_Convscraptdoc_N, 1, 0)));
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
      AddObjectProperty("PaiCod", gxTv_SdtConvenio_Paicod, false, includeNonInitialized);
      AddObjectProperty("ConveCodigo", gxTv_SdtConvenio_Convecodigo, false, includeNonInitialized);
      AddObjectProperty("ConveDescri", gxTv_SdtConvenio_Convedescri, false, includeNonInitialized);
      AddObjectProperty("ConveHabilitada", gxTv_SdtConvenio_Convehabilitada, false, includeNonInitialized);
      AddObjectProperty("ConveDescriSinAc", gxTv_SdtConvenio_Convedescrisinac, false, includeNonInitialized);
      AddObjectProperty("ConveSinCod", gxTv_SdtConvenio_Convesincod, false, includeNonInitialized);
      AddObjectProperty("ConveSinCod_N", gxTv_SdtConvenio_Convesincod_N, false, includeNonInitialized);
      AddObjectProperty("ConveSinDesc", gxTv_SdtConvenio_Convesindesc, false, includeNonInitialized);
      AddObjectProperty("ConvBusGoogle", gxTv_SdtConvenio_Convbusgoogle, false, includeNonInitialized);
      AddObjectProperty("ConvBusGoogle_N", gxTv_SdtConvenio_Convbusgoogle_N, false, includeNonInitialized);
      AddObjectProperty("ConvBusWeb", gxTv_SdtConvenio_Convbusweb, false, includeNonInitialized);
      AddObjectProperty("ConvBusWeb_N", gxTv_SdtConvenio_Convbusweb_N, false, includeNonInitialized);
      AddObjectProperty("ConvBaseURL", gxTv_SdtConvenio_Convbaseurl, false, includeNonInitialized);
      AddObjectProperty("ConvBaseURL_N", gxTv_SdtConvenio_Convbaseurl_N, false, includeNonInitialized);
      AddObjectProperty("ConvScrapTipo", gxTv_SdtConvenio_Convscraptipo, false, includeNonInitialized);
      AddObjectProperty("ConvScrapTipo_N", gxTv_SdtConvenio_Convscraptipo_N, false, includeNonInitialized);
      AddObjectProperty("ConvScrapTDoc", gxTv_SdtConvenio_Convscraptdoc, false, includeNonInitialized);
      AddObjectProperty("ConvScrapTDoc_N", gxTv_SdtConvenio_Convscraptdoc_N, false, includeNonInitialized);
      AddObjectProperty("ConveEscFrecAct", gxTv_SdtConvenio_Conveescfrecact, false, includeNonInitialized);
      AddObjectProperty("ConveEsquemaEs", gxTv_SdtConvenio_Conveesquemaes, false, includeNonInitialized);
      if ( gxTv_SdtConvenio_Propiedadesadicionales != null )
      {
         AddObjectProperty("PropiedadesAdicionales", gxTv_SdtConvenio_Propiedadesadicionales, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConvenio_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConvenio_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiCod_Z", gxTv_SdtConvenio_Paicod_Z, false, includeNonInitialized);
         AddObjectProperty("ConveCodigo_Z", gxTv_SdtConvenio_Convecodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConveDescri_Z", gxTv_SdtConvenio_Convedescri_Z, false, includeNonInitialized);
         AddObjectProperty("ConveHabilitada_Z", gxTv_SdtConvenio_Convehabilitada_Z, false, includeNonInitialized);
         AddObjectProperty("ConveDescriSinAc_Z", gxTv_SdtConvenio_Convedescrisinac_Z, false, includeNonInitialized);
         AddObjectProperty("ConveSinCod_Z", gxTv_SdtConvenio_Convesincod_Z, false, includeNonInitialized);
         AddObjectProperty("ConveSinDesc_Z", gxTv_SdtConvenio_Convesindesc_Z, false, includeNonInitialized);
         AddObjectProperty("ConvBusGoogle_Z", gxTv_SdtConvenio_Convbusgoogle_Z, false, includeNonInitialized);
         AddObjectProperty("ConvBusWeb_Z", gxTv_SdtConvenio_Convbusweb_Z, false, includeNonInitialized);
         AddObjectProperty("ConvBaseURL_Z", gxTv_SdtConvenio_Convbaseurl_Z, false, includeNonInitialized);
         AddObjectProperty("ConvScrapTipo_Z", gxTv_SdtConvenio_Convscraptipo_Z, false, includeNonInitialized);
         AddObjectProperty("ConvScrapTDoc_Z", gxTv_SdtConvenio_Convscraptdoc_Z, false, includeNonInitialized);
         AddObjectProperty("ConveEscFrecAct_Z", gxTv_SdtConvenio_Conveescfrecact_Z, false, includeNonInitialized);
         AddObjectProperty("ConveEsquemaEs_Z", gxTv_SdtConvenio_Conveesquemaes_Z, false, includeNonInitialized);
         AddObjectProperty("ConveSinCod_N", gxTv_SdtConvenio_Convesincod_N, false, includeNonInitialized);
         AddObjectProperty("ConvBusGoogle_N", gxTv_SdtConvenio_Convbusgoogle_N, false, includeNonInitialized);
         AddObjectProperty("ConvBusWeb_N", gxTv_SdtConvenio_Convbusweb_N, false, includeNonInitialized);
         AddObjectProperty("ConvBaseURL_N", gxTv_SdtConvenio_Convbaseurl_N, false, includeNonInitialized);
         AddObjectProperty("ConvScrapTipo_N", gxTv_SdtConvenio_Convscraptipo_N, false, includeNonInitialized);
         AddObjectProperty("ConvScrapTDoc_N", gxTv_SdtConvenio_Convscraptdoc_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtConvenio sdt )
   {
      if ( sdt.IsDirty("PaiCod") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Paicod = sdt.getgxTv_SdtConvenio_Paicod() ;
      }
      if ( sdt.IsDirty("ConveCodigo") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convecodigo = sdt.getgxTv_SdtConvenio_Convecodigo() ;
      }
      if ( sdt.IsDirty("ConveDescri") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convedescri = sdt.getgxTv_SdtConvenio_Convedescri() ;
      }
      if ( sdt.IsDirty("ConveHabilitada") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convehabilitada = sdt.getgxTv_SdtConvenio_Convehabilitada() ;
      }
      if ( sdt.IsDirty("ConveDescriSinAc") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convedescrisinac = sdt.getgxTv_SdtConvenio_Convedescrisinac() ;
      }
      if ( sdt.IsDirty("ConveSinCod") )
      {
         gxTv_SdtConvenio_Convesincod_N = sdt.getgxTv_SdtConvenio_Convesincod_N() ;
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convesincod = sdt.getgxTv_SdtConvenio_Convesincod() ;
      }
      if ( sdt.IsDirty("ConveSinDesc") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convesindesc = sdt.getgxTv_SdtConvenio_Convesindesc() ;
      }
      if ( sdt.IsDirty("ConvBusGoogle") )
      {
         gxTv_SdtConvenio_Convbusgoogle_N = sdt.getgxTv_SdtConvenio_Convbusgoogle_N() ;
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convbusgoogle = sdt.getgxTv_SdtConvenio_Convbusgoogle() ;
      }
      if ( sdt.IsDirty("ConvBusWeb") )
      {
         gxTv_SdtConvenio_Convbusweb_N = sdt.getgxTv_SdtConvenio_Convbusweb_N() ;
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convbusweb = sdt.getgxTv_SdtConvenio_Convbusweb() ;
      }
      if ( sdt.IsDirty("ConvBaseURL") )
      {
         gxTv_SdtConvenio_Convbaseurl_N = sdt.getgxTv_SdtConvenio_Convbaseurl_N() ;
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convbaseurl = sdt.getgxTv_SdtConvenio_Convbaseurl() ;
      }
      if ( sdt.IsDirty("ConvScrapTipo") )
      {
         gxTv_SdtConvenio_Convscraptipo_N = sdt.getgxTv_SdtConvenio_Convscraptipo_N() ;
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convscraptipo = sdt.getgxTv_SdtConvenio_Convscraptipo() ;
      }
      if ( sdt.IsDirty("ConvScrapTDoc") )
      {
         gxTv_SdtConvenio_Convscraptdoc_N = sdt.getgxTv_SdtConvenio_Convscraptdoc_N() ;
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Convscraptdoc = sdt.getgxTv_SdtConvenio_Convscraptdoc() ;
      }
      if ( sdt.IsDirty("ConveEscFrecAct") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Conveescfrecact = sdt.getgxTv_SdtConvenio_Conveescfrecact() ;
      }
      if ( sdt.IsDirty("ConveEsquemaEs") )
      {
         gxTv_SdtConvenio_N = (byte)(0) ;
         gxTv_SdtConvenio_Conveesquemaes = sdt.getgxTv_SdtConvenio_Conveesquemaes() ;
      }
      if ( gxTv_SdtConvenio_Propiedadesadicionales != null )
      {
         GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> newCollectionPropiedadesadicionales = sdt.getgxTv_SdtConvenio_Propiedadesadicionales();
         web.SdtConvenio_PropiedadesAdicionales currItemPropiedadesadicionales;
         web.SdtConvenio_PropiedadesAdicionales newItemPropiedadesadicionales;
         short idx = 1;
         while ( idx <= newCollectionPropiedadesadicionales.size() )
         {
            newItemPropiedadesadicionales = (web.SdtConvenio_PropiedadesAdicionales)((web.SdtConvenio_PropiedadesAdicionales)newCollectionPropiedadesadicionales.elementAt(-1+idx));
            currItemPropiedadesadicionales = (web.SdtConvenio_PropiedadesAdicionales)gxTv_SdtConvenio_Propiedadesadicionales.getByKey(newItemPropiedadesadicionales.getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod());
            if ( GXutil.strcmp(currItemPropiedadesadicionales.getgxTv_SdtConvenio_PropiedadesAdicionales_Mode(), "UPD") == 0 )
            {
               currItemPropiedadesadicionales.updateDirties(newItemPropiedadesadicionales);
               if ( GXutil.strcmp(newItemPropiedadesadicionales.getgxTv_SdtConvenio_PropiedadesAdicionales_Mode(), "DLT") == 0 )
               {
                  currItemPropiedadesadicionales.setgxTv_SdtConvenio_PropiedadesAdicionales_Mode( "DLT" );
               }
               currItemPropiedadesadicionales.setgxTv_SdtConvenio_PropiedadesAdicionales_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtConvenio_Propiedadesadicionales.add(newItemPropiedadesadicionales, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtConvenio_Paicod( )
   {
      return gxTv_SdtConvenio_Paicod ;
   }

   public void setgxTv_SdtConvenio_Paicod( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      if ( gxTv_SdtConvenio_Paicod != value )
      {
         gxTv_SdtConvenio_Mode = "INS" ;
         this.setgxTv_SdtConvenio_Paicod_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convecodigo_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convedescri_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convehabilitada_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convedescrisinac_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convesincod_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convesindesc_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convbusgoogle_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convbusweb_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convbaseurl_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convscraptipo_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convscraptdoc_Z_SetNull( );
         this.setgxTv_SdtConvenio_Conveescfrecact_Z_SetNull( );
         this.setgxTv_SdtConvenio_Conveesquemaes_Z_SetNull( );
         if ( gxTv_SdtConvenio_Propiedadesadicionales != null )
         {
            GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> collectionPropiedadesadicionales = gxTv_SdtConvenio_Propiedadesadicionales;
            web.SdtConvenio_PropiedadesAdicionales currItemPropiedadesadicionales;
            short idx = 1;
            while ( idx <= collectionPropiedadesadicionales.size() )
            {
               currItemPropiedadesadicionales = (web.SdtConvenio_PropiedadesAdicionales)((web.SdtConvenio_PropiedadesAdicionales)collectionPropiedadesadicionales.elementAt(-1+idx));
               currItemPropiedadesadicionales.setgxTv_SdtConvenio_PropiedadesAdicionales_Mode( "INS" );
               currItemPropiedadesadicionales.setgxTv_SdtConvenio_PropiedadesAdicionales_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Paicod");
      gxTv_SdtConvenio_Paicod = value ;
   }

   public String getgxTv_SdtConvenio_Convecodigo( )
   {
      return gxTv_SdtConvenio_Convecodigo ;
   }

   public void setgxTv_SdtConvenio_Convecodigo( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtConvenio_Convecodigo, value) != 0 )
      {
         gxTv_SdtConvenio_Mode = "INS" ;
         this.setgxTv_SdtConvenio_Paicod_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convecodigo_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convedescri_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convehabilitada_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convedescrisinac_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convesincod_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convesindesc_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convbusgoogle_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convbusweb_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convbaseurl_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convscraptipo_Z_SetNull( );
         this.setgxTv_SdtConvenio_Convscraptdoc_Z_SetNull( );
         this.setgxTv_SdtConvenio_Conveescfrecact_Z_SetNull( );
         this.setgxTv_SdtConvenio_Conveesquemaes_Z_SetNull( );
         if ( gxTv_SdtConvenio_Propiedadesadicionales != null )
         {
            GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> collectionPropiedadesadicionales = gxTv_SdtConvenio_Propiedadesadicionales;
            web.SdtConvenio_PropiedadesAdicionales currItemPropiedadesadicionales;
            short idx = 1;
            while ( idx <= collectionPropiedadesadicionales.size() )
            {
               currItemPropiedadesadicionales = (web.SdtConvenio_PropiedadesAdicionales)((web.SdtConvenio_PropiedadesAdicionales)collectionPropiedadesadicionales.elementAt(-1+idx));
               currItemPropiedadesadicionales.setgxTv_SdtConvenio_PropiedadesAdicionales_Mode( "INS" );
               currItemPropiedadesadicionales.setgxTv_SdtConvenio_PropiedadesAdicionales_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Convecodigo");
      gxTv_SdtConvenio_Convecodigo = value ;
   }

   public String getgxTv_SdtConvenio_Convedescri( )
   {
      return gxTv_SdtConvenio_Convedescri ;
   }

   public void setgxTv_SdtConvenio_Convedescri( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convedescri");
      gxTv_SdtConvenio_Convedescri = value ;
   }

   public boolean getgxTv_SdtConvenio_Convehabilitada( )
   {
      return gxTv_SdtConvenio_Convehabilitada ;
   }

   public void setgxTv_SdtConvenio_Convehabilitada( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convehabilitada");
      gxTv_SdtConvenio_Convehabilitada = value ;
   }

   public String getgxTv_SdtConvenio_Convedescrisinac( )
   {
      return gxTv_SdtConvenio_Convedescrisinac ;
   }

   public void setgxTv_SdtConvenio_Convedescrisinac( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convedescrisinac");
      gxTv_SdtConvenio_Convedescrisinac = value ;
   }

   public String getgxTv_SdtConvenio_Convesincod( )
   {
      return gxTv_SdtConvenio_Convesincod ;
   }

   public void setgxTv_SdtConvenio_Convesincod( String value )
   {
      gxTv_SdtConvenio_Convesincod_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convesincod");
      gxTv_SdtConvenio_Convesincod = value ;
   }

   public void setgxTv_SdtConvenio_Convesincod_SetNull( )
   {
      gxTv_SdtConvenio_Convesincod_N = (byte)(1) ;
      gxTv_SdtConvenio_Convesincod = "" ;
      SetDirty("Convesincod");
   }

   public boolean getgxTv_SdtConvenio_Convesincod_IsNull( )
   {
      return (gxTv_SdtConvenio_Convesincod_N==1) ;
   }

   public String getgxTv_SdtConvenio_Convesindesc( )
   {
      return gxTv_SdtConvenio_Convesindesc ;
   }

   public void setgxTv_SdtConvenio_Convesindesc( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convesindesc");
      gxTv_SdtConvenio_Convesindesc = value ;
   }

   public String getgxTv_SdtConvenio_Convbusgoogle( )
   {
      return gxTv_SdtConvenio_Convbusgoogle ;
   }

   public void setgxTv_SdtConvenio_Convbusgoogle( String value )
   {
      gxTv_SdtConvenio_Convbusgoogle_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbusgoogle");
      gxTv_SdtConvenio_Convbusgoogle = value ;
   }

   public void setgxTv_SdtConvenio_Convbusgoogle_SetNull( )
   {
      gxTv_SdtConvenio_Convbusgoogle_N = (byte)(1) ;
      gxTv_SdtConvenio_Convbusgoogle = "" ;
      SetDirty("Convbusgoogle");
   }

   public boolean getgxTv_SdtConvenio_Convbusgoogle_IsNull( )
   {
      return (gxTv_SdtConvenio_Convbusgoogle_N==1) ;
   }

   public String getgxTv_SdtConvenio_Convbusweb( )
   {
      return gxTv_SdtConvenio_Convbusweb ;
   }

   public void setgxTv_SdtConvenio_Convbusweb( String value )
   {
      gxTv_SdtConvenio_Convbusweb_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbusweb");
      gxTv_SdtConvenio_Convbusweb = value ;
   }

   public void setgxTv_SdtConvenio_Convbusweb_SetNull( )
   {
      gxTv_SdtConvenio_Convbusweb_N = (byte)(1) ;
      gxTv_SdtConvenio_Convbusweb = "" ;
      SetDirty("Convbusweb");
   }

   public boolean getgxTv_SdtConvenio_Convbusweb_IsNull( )
   {
      return (gxTv_SdtConvenio_Convbusweb_N==1) ;
   }

   public String getgxTv_SdtConvenio_Convbaseurl( )
   {
      return gxTv_SdtConvenio_Convbaseurl ;
   }

   public void setgxTv_SdtConvenio_Convbaseurl( String value )
   {
      gxTv_SdtConvenio_Convbaseurl_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbaseurl");
      gxTv_SdtConvenio_Convbaseurl = value ;
   }

   public void setgxTv_SdtConvenio_Convbaseurl_SetNull( )
   {
      gxTv_SdtConvenio_Convbaseurl_N = (byte)(1) ;
      gxTv_SdtConvenio_Convbaseurl = "" ;
      SetDirty("Convbaseurl");
   }

   public boolean getgxTv_SdtConvenio_Convbaseurl_IsNull( )
   {
      return (gxTv_SdtConvenio_Convbaseurl_N==1) ;
   }

   public String getgxTv_SdtConvenio_Convscraptipo( )
   {
      return gxTv_SdtConvenio_Convscraptipo ;
   }

   public void setgxTv_SdtConvenio_Convscraptipo( String value )
   {
      gxTv_SdtConvenio_Convscraptipo_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convscraptipo");
      gxTv_SdtConvenio_Convscraptipo = value ;
   }

   public void setgxTv_SdtConvenio_Convscraptipo_SetNull( )
   {
      gxTv_SdtConvenio_Convscraptipo_N = (byte)(1) ;
      gxTv_SdtConvenio_Convscraptipo = "" ;
      SetDirty("Convscraptipo");
   }

   public boolean getgxTv_SdtConvenio_Convscraptipo_IsNull( )
   {
      return (gxTv_SdtConvenio_Convscraptipo_N==1) ;
   }

   public String getgxTv_SdtConvenio_Convscraptdoc( )
   {
      return gxTv_SdtConvenio_Convscraptdoc ;
   }

   public void setgxTv_SdtConvenio_Convscraptdoc( String value )
   {
      gxTv_SdtConvenio_Convscraptdoc_N = (byte)(0) ;
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convscraptdoc");
      gxTv_SdtConvenio_Convscraptdoc = value ;
   }

   public void setgxTv_SdtConvenio_Convscraptdoc_SetNull( )
   {
      gxTv_SdtConvenio_Convscraptdoc_N = (byte)(1) ;
      gxTv_SdtConvenio_Convscraptdoc = "" ;
      SetDirty("Convscraptdoc");
   }

   public boolean getgxTv_SdtConvenio_Convscraptdoc_IsNull( )
   {
      return (gxTv_SdtConvenio_Convscraptdoc_N==1) ;
   }

   public short getgxTv_SdtConvenio_Conveescfrecact( )
   {
      return gxTv_SdtConvenio_Conveescfrecact ;
   }

   public void setgxTv_SdtConvenio_Conveescfrecact( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Conveescfrecact");
      gxTv_SdtConvenio_Conveescfrecact = value ;
   }

   public boolean getgxTv_SdtConvenio_Conveesquemaes( )
   {
      return gxTv_SdtConvenio_Conveesquemaes ;
   }

   public void setgxTv_SdtConvenio_Conveesquemaes( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Conveesquemaes");
      gxTv_SdtConvenio_Conveesquemaes = value ;
   }

   public GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> getgxTv_SdtConvenio_Propiedadesadicionales( )
   {
      if ( gxTv_SdtConvenio_Propiedadesadicionales == null )
      {
         gxTv_SdtConvenio_Propiedadesadicionales = new GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales>(web.SdtConvenio_PropiedadesAdicionales.class, "Convenio.PropiedadesAdicionales", "PayDay", remoteHandle);
      }
      gxTv_SdtConvenio_N = (byte)(0) ;
      return gxTv_SdtConvenio_Propiedadesadicionales ;
   }

   public void setgxTv_SdtConvenio_Propiedadesadicionales( GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Propiedadesadicionales");
      gxTv_SdtConvenio_Propiedadesadicionales = value ;
   }

   public void setgxTv_SdtConvenio_Propiedadesadicionales_SetNull( )
   {
      gxTv_SdtConvenio_Propiedadesadicionales = null ;
      SetDirty("Propiedadesadicionales");
   }

   public boolean getgxTv_SdtConvenio_Propiedadesadicionales_IsNull( )
   {
      if ( gxTv_SdtConvenio_Propiedadesadicionales == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtConvenio_Mode( )
   {
      return gxTv_SdtConvenio_Mode ;
   }

   public void setgxTv_SdtConvenio_Mode( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConvenio_Mode = value ;
   }

   public void setgxTv_SdtConvenio_Mode_SetNull( )
   {
      gxTv_SdtConvenio_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtConvenio_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConvenio_Initialized( )
   {
      return gxTv_SdtConvenio_Initialized ;
   }

   public void setgxTv_SdtConvenio_Initialized( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtConvenio_Initialized = value ;
   }

   public void setgxTv_SdtConvenio_Initialized_SetNull( )
   {
      gxTv_SdtConvenio_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtConvenio_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConvenio_Paicod_Z( )
   {
      return gxTv_SdtConvenio_Paicod_Z ;
   }

   public void setgxTv_SdtConvenio_Paicod_Z( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Paicod_Z");
      gxTv_SdtConvenio_Paicod_Z = value ;
   }

   public void setgxTv_SdtConvenio_Paicod_Z_SetNull( )
   {
      gxTv_SdtConvenio_Paicod_Z = (short)(0) ;
      SetDirty("Paicod_Z");
   }

   public boolean getgxTv_SdtConvenio_Paicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convecodigo_Z( )
   {
      return gxTv_SdtConvenio_Convecodigo_Z ;
   }

   public void setgxTv_SdtConvenio_Convecodigo_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convecodigo_Z");
      gxTv_SdtConvenio_Convecodigo_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convecodigo_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convecodigo_Z = "" ;
      SetDirty("Convecodigo_Z");
   }

   public boolean getgxTv_SdtConvenio_Convecodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convedescri_Z( )
   {
      return gxTv_SdtConvenio_Convedescri_Z ;
   }

   public void setgxTv_SdtConvenio_Convedescri_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convedescri_Z");
      gxTv_SdtConvenio_Convedescri_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convedescri_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convedescri_Z = "" ;
      SetDirty("Convedescri_Z");
   }

   public boolean getgxTv_SdtConvenio_Convedescri_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConvenio_Convehabilitada_Z( )
   {
      return gxTv_SdtConvenio_Convehabilitada_Z ;
   }

   public void setgxTv_SdtConvenio_Convehabilitada_Z( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convehabilitada_Z");
      gxTv_SdtConvenio_Convehabilitada_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convehabilitada_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convehabilitada_Z = false ;
      SetDirty("Convehabilitada_Z");
   }

   public boolean getgxTv_SdtConvenio_Convehabilitada_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convedescrisinac_Z( )
   {
      return gxTv_SdtConvenio_Convedescrisinac_Z ;
   }

   public void setgxTv_SdtConvenio_Convedescrisinac_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convedescrisinac_Z");
      gxTv_SdtConvenio_Convedescrisinac_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convedescrisinac_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convedescrisinac_Z = "" ;
      SetDirty("Convedescrisinac_Z");
   }

   public boolean getgxTv_SdtConvenio_Convedescrisinac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convesincod_Z( )
   {
      return gxTv_SdtConvenio_Convesincod_Z ;
   }

   public void setgxTv_SdtConvenio_Convesincod_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convesincod_Z");
      gxTv_SdtConvenio_Convesincod_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convesincod_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convesincod_Z = "" ;
      SetDirty("Convesincod_Z");
   }

   public boolean getgxTv_SdtConvenio_Convesincod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convesindesc_Z( )
   {
      return gxTv_SdtConvenio_Convesindesc_Z ;
   }

   public void setgxTv_SdtConvenio_Convesindesc_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convesindesc_Z");
      gxTv_SdtConvenio_Convesindesc_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convesindesc_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convesindesc_Z = "" ;
      SetDirty("Convesindesc_Z");
   }

   public boolean getgxTv_SdtConvenio_Convesindesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convbusgoogle_Z( )
   {
      return gxTv_SdtConvenio_Convbusgoogle_Z ;
   }

   public void setgxTv_SdtConvenio_Convbusgoogle_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbusgoogle_Z");
      gxTv_SdtConvenio_Convbusgoogle_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convbusgoogle_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convbusgoogle_Z = "" ;
      SetDirty("Convbusgoogle_Z");
   }

   public boolean getgxTv_SdtConvenio_Convbusgoogle_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convbusweb_Z( )
   {
      return gxTv_SdtConvenio_Convbusweb_Z ;
   }

   public void setgxTv_SdtConvenio_Convbusweb_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbusweb_Z");
      gxTv_SdtConvenio_Convbusweb_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convbusweb_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convbusweb_Z = "" ;
      SetDirty("Convbusweb_Z");
   }

   public boolean getgxTv_SdtConvenio_Convbusweb_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convbaseurl_Z( )
   {
      return gxTv_SdtConvenio_Convbaseurl_Z ;
   }

   public void setgxTv_SdtConvenio_Convbaseurl_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbaseurl_Z");
      gxTv_SdtConvenio_Convbaseurl_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convbaseurl_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convbaseurl_Z = "" ;
      SetDirty("Convbaseurl_Z");
   }

   public boolean getgxTv_SdtConvenio_Convbaseurl_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convscraptipo_Z( )
   {
      return gxTv_SdtConvenio_Convscraptipo_Z ;
   }

   public void setgxTv_SdtConvenio_Convscraptipo_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convscraptipo_Z");
      gxTv_SdtConvenio_Convscraptipo_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convscraptipo_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convscraptipo_Z = "" ;
      SetDirty("Convscraptipo_Z");
   }

   public boolean getgxTv_SdtConvenio_Convscraptipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_Convscraptdoc_Z( )
   {
      return gxTv_SdtConvenio_Convscraptdoc_Z ;
   }

   public void setgxTv_SdtConvenio_Convscraptdoc_Z( String value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convscraptdoc_Z");
      gxTv_SdtConvenio_Convscraptdoc_Z = value ;
   }

   public void setgxTv_SdtConvenio_Convscraptdoc_Z_SetNull( )
   {
      gxTv_SdtConvenio_Convscraptdoc_Z = "" ;
      SetDirty("Convscraptdoc_Z");
   }

   public boolean getgxTv_SdtConvenio_Convscraptdoc_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConvenio_Conveescfrecact_Z( )
   {
      return gxTv_SdtConvenio_Conveescfrecact_Z ;
   }

   public void setgxTv_SdtConvenio_Conveescfrecact_Z( short value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Conveescfrecact_Z");
      gxTv_SdtConvenio_Conveescfrecact_Z = value ;
   }

   public void setgxTv_SdtConvenio_Conveescfrecact_Z_SetNull( )
   {
      gxTv_SdtConvenio_Conveescfrecact_Z = (short)(0) ;
      SetDirty("Conveescfrecact_Z");
   }

   public boolean getgxTv_SdtConvenio_Conveescfrecact_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConvenio_Conveesquemaes_Z( )
   {
      return gxTv_SdtConvenio_Conveesquemaes_Z ;
   }

   public void setgxTv_SdtConvenio_Conveesquemaes_Z( boolean value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Conveesquemaes_Z");
      gxTv_SdtConvenio_Conveesquemaes_Z = value ;
   }

   public void setgxTv_SdtConvenio_Conveesquemaes_Z_SetNull( )
   {
      gxTv_SdtConvenio_Conveesquemaes_Z = false ;
      SetDirty("Conveesquemaes_Z");
   }

   public boolean getgxTv_SdtConvenio_Conveesquemaes_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConvenio_Convesincod_N( )
   {
      return gxTv_SdtConvenio_Convesincod_N ;
   }

   public void setgxTv_SdtConvenio_Convesincod_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convesincod_N");
      gxTv_SdtConvenio_Convesincod_N = value ;
   }

   public void setgxTv_SdtConvenio_Convesincod_N_SetNull( )
   {
      gxTv_SdtConvenio_Convesincod_N = (byte)(0) ;
      SetDirty("Convesincod_N");
   }

   public boolean getgxTv_SdtConvenio_Convesincod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConvenio_Convbusgoogle_N( )
   {
      return gxTv_SdtConvenio_Convbusgoogle_N ;
   }

   public void setgxTv_SdtConvenio_Convbusgoogle_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbusgoogle_N");
      gxTv_SdtConvenio_Convbusgoogle_N = value ;
   }

   public void setgxTv_SdtConvenio_Convbusgoogle_N_SetNull( )
   {
      gxTv_SdtConvenio_Convbusgoogle_N = (byte)(0) ;
      SetDirty("Convbusgoogle_N");
   }

   public boolean getgxTv_SdtConvenio_Convbusgoogle_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConvenio_Convbusweb_N( )
   {
      return gxTv_SdtConvenio_Convbusweb_N ;
   }

   public void setgxTv_SdtConvenio_Convbusweb_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbusweb_N");
      gxTv_SdtConvenio_Convbusweb_N = value ;
   }

   public void setgxTv_SdtConvenio_Convbusweb_N_SetNull( )
   {
      gxTv_SdtConvenio_Convbusweb_N = (byte)(0) ;
      SetDirty("Convbusweb_N");
   }

   public boolean getgxTv_SdtConvenio_Convbusweb_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConvenio_Convbaseurl_N( )
   {
      return gxTv_SdtConvenio_Convbaseurl_N ;
   }

   public void setgxTv_SdtConvenio_Convbaseurl_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convbaseurl_N");
      gxTv_SdtConvenio_Convbaseurl_N = value ;
   }

   public void setgxTv_SdtConvenio_Convbaseurl_N_SetNull( )
   {
      gxTv_SdtConvenio_Convbaseurl_N = (byte)(0) ;
      SetDirty("Convbaseurl_N");
   }

   public boolean getgxTv_SdtConvenio_Convbaseurl_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConvenio_Convscraptipo_N( )
   {
      return gxTv_SdtConvenio_Convscraptipo_N ;
   }

   public void setgxTv_SdtConvenio_Convscraptipo_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convscraptipo_N");
      gxTv_SdtConvenio_Convscraptipo_N = value ;
   }

   public void setgxTv_SdtConvenio_Convscraptipo_N_SetNull( )
   {
      gxTv_SdtConvenio_Convscraptipo_N = (byte)(0) ;
      SetDirty("Convscraptipo_N");
   }

   public boolean getgxTv_SdtConvenio_Convscraptipo_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConvenio_Convscraptdoc_N( )
   {
      return gxTv_SdtConvenio_Convscraptdoc_N ;
   }

   public void setgxTv_SdtConvenio_Convscraptdoc_N( byte value )
   {
      gxTv_SdtConvenio_N = (byte)(0) ;
      SetDirty("Convscraptdoc_N");
      gxTv_SdtConvenio_Convscraptdoc_N = value ;
   }

   public void setgxTv_SdtConvenio_Convscraptdoc_N_SetNull( )
   {
      gxTv_SdtConvenio_Convscraptdoc_N = (byte)(0) ;
      SetDirty("Convscraptdoc_N");
   }

   public boolean getgxTv_SdtConvenio_Convscraptdoc_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.convenio_bc obj;
      obj = new web.convenio_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtConvenio_N = (byte)(1) ;
      gxTv_SdtConvenio_Convecodigo = "" ;
      gxTv_SdtConvenio_Convedescri = "" ;
      gxTv_SdtConvenio_Convedescrisinac = "" ;
      gxTv_SdtConvenio_Convesincod = "" ;
      gxTv_SdtConvenio_Convesindesc = "" ;
      gxTv_SdtConvenio_Convbusgoogle = "" ;
      gxTv_SdtConvenio_Convbusweb = "" ;
      gxTv_SdtConvenio_Convbaseurl = "" ;
      gxTv_SdtConvenio_Convscraptipo = "" ;
      gxTv_SdtConvenio_Convscraptdoc = "" ;
      gxTv_SdtConvenio_Mode = "" ;
      gxTv_SdtConvenio_Convecodigo_Z = "" ;
      gxTv_SdtConvenio_Convedescri_Z = "" ;
      gxTv_SdtConvenio_Convedescrisinac_Z = "" ;
      gxTv_SdtConvenio_Convesincod_Z = "" ;
      gxTv_SdtConvenio_Convesindesc_Z = "" ;
      gxTv_SdtConvenio_Convbusgoogle_Z = "" ;
      gxTv_SdtConvenio_Convbusweb_Z = "" ;
      gxTv_SdtConvenio_Convbaseurl_Z = "" ;
      gxTv_SdtConvenio_Convscraptipo_Z = "" ;
      gxTv_SdtConvenio_Convscraptdoc_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConvenio_N ;
   }

   public web.SdtConvenio Clone( )
   {
      web.SdtConvenio sdt;
      web.convenio_bc obj;
      sdt = (web.SdtConvenio)(clone()) ;
      obj = (web.convenio_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtConvenio struct )
   {
      setgxTv_SdtConvenio_Paicod(struct.getPaicod());
      setgxTv_SdtConvenio_Convecodigo(struct.getConvecodigo());
      setgxTv_SdtConvenio_Convedescri(struct.getConvedescri());
      setgxTv_SdtConvenio_Convehabilitada(struct.getConvehabilitada());
      setgxTv_SdtConvenio_Convedescrisinac(struct.getConvedescrisinac());
      setgxTv_SdtConvenio_Convesincod(struct.getConvesincod());
      setgxTv_SdtConvenio_Convesindesc(struct.getConvesindesc());
      setgxTv_SdtConvenio_Convbusgoogle(struct.getConvbusgoogle());
      setgxTv_SdtConvenio_Convbusweb(struct.getConvbusweb());
      setgxTv_SdtConvenio_Convbaseurl(struct.getConvbaseurl());
      setgxTv_SdtConvenio_Convscraptipo(struct.getConvscraptipo());
      setgxTv_SdtConvenio_Convscraptdoc(struct.getConvscraptdoc());
      setgxTv_SdtConvenio_Conveescfrecact(struct.getConveescfrecact());
      setgxTv_SdtConvenio_Conveesquemaes(struct.getConveesquemaes());
      GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> gxTv_SdtConvenio_Propiedadesadicionales_aux = new GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales>(web.SdtConvenio_PropiedadesAdicionales.class, "Convenio.PropiedadesAdicionales", "PayDay", remoteHandle);
      Vector<web.StructSdtConvenio_PropiedadesAdicionales> gxTv_SdtConvenio_Propiedadesadicionales_aux1 = struct.getPropiedadesadicionales();
      if (gxTv_SdtConvenio_Propiedadesadicionales_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtConvenio_Propiedadesadicionales_aux1.size(); i++)
         {
            gxTv_SdtConvenio_Propiedadesadicionales_aux.add(new web.SdtConvenio_PropiedadesAdicionales(remoteHandle, gxTv_SdtConvenio_Propiedadesadicionales_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtConvenio_Propiedadesadicionales(gxTv_SdtConvenio_Propiedadesadicionales_aux);
      setgxTv_SdtConvenio_Mode(struct.getMode());
      setgxTv_SdtConvenio_Initialized(struct.getInitialized());
      setgxTv_SdtConvenio_Paicod_Z(struct.getPaicod_Z());
      setgxTv_SdtConvenio_Convecodigo_Z(struct.getConvecodigo_Z());
      setgxTv_SdtConvenio_Convedescri_Z(struct.getConvedescri_Z());
      setgxTv_SdtConvenio_Convehabilitada_Z(struct.getConvehabilitada_Z());
      setgxTv_SdtConvenio_Convedescrisinac_Z(struct.getConvedescrisinac_Z());
      setgxTv_SdtConvenio_Convesincod_Z(struct.getConvesincod_Z());
      setgxTv_SdtConvenio_Convesindesc_Z(struct.getConvesindesc_Z());
      setgxTv_SdtConvenio_Convbusgoogle_Z(struct.getConvbusgoogle_Z());
      setgxTv_SdtConvenio_Convbusweb_Z(struct.getConvbusweb_Z());
      setgxTv_SdtConvenio_Convbaseurl_Z(struct.getConvbaseurl_Z());
      setgxTv_SdtConvenio_Convscraptipo_Z(struct.getConvscraptipo_Z());
      setgxTv_SdtConvenio_Convscraptdoc_Z(struct.getConvscraptdoc_Z());
      setgxTv_SdtConvenio_Conveescfrecact_Z(struct.getConveescfrecact_Z());
      setgxTv_SdtConvenio_Conveesquemaes_Z(struct.getConveesquemaes_Z());
      setgxTv_SdtConvenio_Convesincod_N(struct.getConvesincod_N());
      setgxTv_SdtConvenio_Convbusgoogle_N(struct.getConvbusgoogle_N());
      setgxTv_SdtConvenio_Convbusweb_N(struct.getConvbusweb_N());
      setgxTv_SdtConvenio_Convbaseurl_N(struct.getConvbaseurl_N());
      setgxTv_SdtConvenio_Convscraptipo_N(struct.getConvscraptipo_N());
      setgxTv_SdtConvenio_Convscraptdoc_N(struct.getConvscraptdoc_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConvenio getStruct( )
   {
      web.StructSdtConvenio struct = new web.StructSdtConvenio ();
      struct.setPaicod(getgxTv_SdtConvenio_Paicod());
      struct.setConvecodigo(getgxTv_SdtConvenio_Convecodigo());
      struct.setConvedescri(getgxTv_SdtConvenio_Convedescri());
      struct.setConvehabilitada(getgxTv_SdtConvenio_Convehabilitada());
      struct.setConvedescrisinac(getgxTv_SdtConvenio_Convedescrisinac());
      struct.setConvesincod(getgxTv_SdtConvenio_Convesincod());
      struct.setConvesindesc(getgxTv_SdtConvenio_Convesindesc());
      struct.setConvbusgoogle(getgxTv_SdtConvenio_Convbusgoogle());
      struct.setConvbusweb(getgxTv_SdtConvenio_Convbusweb());
      struct.setConvbaseurl(getgxTv_SdtConvenio_Convbaseurl());
      struct.setConvscraptipo(getgxTv_SdtConvenio_Convscraptipo());
      struct.setConvscraptdoc(getgxTv_SdtConvenio_Convscraptdoc());
      struct.setConveescfrecact(getgxTv_SdtConvenio_Conveescfrecact());
      struct.setConveesquemaes(getgxTv_SdtConvenio_Conveesquemaes());
      struct.setPropiedadesadicionales(getgxTv_SdtConvenio_Propiedadesadicionales().getStruct());
      struct.setMode(getgxTv_SdtConvenio_Mode());
      struct.setInitialized(getgxTv_SdtConvenio_Initialized());
      struct.setPaicod_Z(getgxTv_SdtConvenio_Paicod_Z());
      struct.setConvecodigo_Z(getgxTv_SdtConvenio_Convecodigo_Z());
      struct.setConvedescri_Z(getgxTv_SdtConvenio_Convedescri_Z());
      struct.setConvehabilitada_Z(getgxTv_SdtConvenio_Convehabilitada_Z());
      struct.setConvedescrisinac_Z(getgxTv_SdtConvenio_Convedescrisinac_Z());
      struct.setConvesincod_Z(getgxTv_SdtConvenio_Convesincod_Z());
      struct.setConvesindesc_Z(getgxTv_SdtConvenio_Convesindesc_Z());
      struct.setConvbusgoogle_Z(getgxTv_SdtConvenio_Convbusgoogle_Z());
      struct.setConvbusweb_Z(getgxTv_SdtConvenio_Convbusweb_Z());
      struct.setConvbaseurl_Z(getgxTv_SdtConvenio_Convbaseurl_Z());
      struct.setConvscraptipo_Z(getgxTv_SdtConvenio_Convscraptipo_Z());
      struct.setConvscraptdoc_Z(getgxTv_SdtConvenio_Convscraptdoc_Z());
      struct.setConveescfrecact_Z(getgxTv_SdtConvenio_Conveescfrecact_Z());
      struct.setConveesquemaes_Z(getgxTv_SdtConvenio_Conveesquemaes_Z());
      struct.setConvesincod_N(getgxTv_SdtConvenio_Convesincod_N());
      struct.setConvbusgoogle_N(getgxTv_SdtConvenio_Convbusgoogle_N());
      struct.setConvbusweb_N(getgxTv_SdtConvenio_Convbusweb_N());
      struct.setConvbaseurl_N(getgxTv_SdtConvenio_Convbaseurl_N());
      struct.setConvscraptipo_N(getgxTv_SdtConvenio_Convscraptipo_N());
      struct.setConvscraptdoc_N(getgxTv_SdtConvenio_Convscraptdoc_N());
      return struct ;
   }

   private byte gxTv_SdtConvenio_N ;
   private byte gxTv_SdtConvenio_Convesincod_N ;
   private byte gxTv_SdtConvenio_Convbusgoogle_N ;
   private byte gxTv_SdtConvenio_Convbusweb_N ;
   private byte gxTv_SdtConvenio_Convbaseurl_N ;
   private byte gxTv_SdtConvenio_Convscraptipo_N ;
   private byte gxTv_SdtConvenio_Convscraptdoc_N ;
   private short gxTv_SdtConvenio_Paicod ;
   private short gxTv_SdtConvenio_Conveescfrecact ;
   private short gxTv_SdtConvenio_Initialized ;
   private short gxTv_SdtConvenio_Paicod_Z ;
   private short gxTv_SdtConvenio_Conveescfrecact_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtConvenio_Convecodigo ;
   private String gxTv_SdtConvenio_Convesincod ;
   private String gxTv_SdtConvenio_Convscraptipo ;
   private String gxTv_SdtConvenio_Convscraptdoc ;
   private String gxTv_SdtConvenio_Mode ;
   private String gxTv_SdtConvenio_Convecodigo_Z ;
   private String gxTv_SdtConvenio_Convesincod_Z ;
   private String gxTv_SdtConvenio_Convscraptipo_Z ;
   private String gxTv_SdtConvenio_Convscraptdoc_Z ;
   private String sTagName ;
   private boolean gxTv_SdtConvenio_Convehabilitada ;
   private boolean gxTv_SdtConvenio_Conveesquemaes ;
   private boolean gxTv_SdtConvenio_Convehabilitada_Z ;
   private boolean gxTv_SdtConvenio_Conveesquemaes_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtConvenio_Convedescri ;
   private String gxTv_SdtConvenio_Convedescrisinac ;
   private String gxTv_SdtConvenio_Convesindesc ;
   private String gxTv_SdtConvenio_Convbusgoogle ;
   private String gxTv_SdtConvenio_Convbusweb ;
   private String gxTv_SdtConvenio_Convbaseurl ;
   private String gxTv_SdtConvenio_Convedescri_Z ;
   private String gxTv_SdtConvenio_Convedescrisinac_Z ;
   private String gxTv_SdtConvenio_Convesindesc_Z ;
   private String gxTv_SdtConvenio_Convbusgoogle_Z ;
   private String gxTv_SdtConvenio_Convbusweb_Z ;
   private String gxTv_SdtConvenio_Convbaseurl_Z ;
   private GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> gxTv_SdtConvenio_Propiedadesadicionales_aux ;
   private GXBCLevelCollection<web.SdtConvenio_PropiedadesAdicionales> gxTv_SdtConvenio_Propiedadesadicionales=null ;
}

