package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCategoria_Provincias extends GxSilentTrnSdt
{
   public SdtCategoria_Provincias( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCategoria_Provincias.class));
   }

   public SdtCategoria_Provincias( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtCategoria_Provincias");
      initialize( remoteHandle) ;
   }

   public SdtCategoria_Provincias( int remoteHandle ,
                                   StructSdtCategoria_Provincias struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtCategoria_Provincias( )
   {
      super( new ModelContext(SdtCategoria_Provincias.class), "SdtCategoria_Provincias");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CatPaiCod", short.class}, new Object[]{"CatProvCod", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Provincias");
      metadata.set("BT", "CategoriaProvincias");
      metadata.set("PK", "[ \"CatPaiCod\",\"CatProvCod\" ]");
      metadata.set("PKAssigned", "[ \"CatPaiCod\",\"CatProvCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"CliPaiConve\",\"CliConvenio\",\"CatCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliPaiConve\",\"CliConvenio\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ProvCod\" ],\"FKMap\":[ \"CatPaiCod-PaiCod\",\"CatProvCod-ProvCod\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatPaiCod") )
            {
               gxTv_SdtCategoria_Provincias_Catpaicod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvCod") )
            {
               gxTv_SdtCategoria_Provincias_Catprovcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvRelSec") )
            {
               gxTv_SdtCategoria_Provincias_Catprovrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvRelRef") )
            {
               gxTv_SdtCategoria_Provincias_Catprovrelref = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvOld") )
            {
               gxTv_SdtCategoria_Provincias_Catprovold = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCategoria_Provincias_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtCategoria_Provincias_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCategoria_Provincias_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatPaiCod_Z") )
            {
               gxTv_SdtCategoria_Provincias_Catpaicod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvCod_Z") )
            {
               gxTv_SdtCategoria_Provincias_Catprovcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvRelSec_Z") )
            {
               gxTv_SdtCategoria_Provincias_Catprovrelsec_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvRelRef_Z") )
            {
               gxTv_SdtCategoria_Provincias_Catprovrelref_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvRelSec_N") )
            {
               gxTv_SdtCategoria_Provincias_Catprovrelsec_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvRelRef_N") )
            {
               gxTv_SdtCategoria_Provincias_Catprovrelref_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatProvOld_N") )
            {
               gxTv_SdtCategoria_Provincias_Catprovold_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Categoria.Provincias" ;
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
      oWriter.writeElement("CatPaiCod", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catpaicod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatProvCod", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatProvRelSec", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatProvRelRef", gxTv_SdtCategoria_Provincias_Catprovrelref);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CatProvOld", gxTv_SdtCategoria_Provincias_Catprovold);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtCategoria_Provincias_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatPaiCod_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catpaicod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatProvCod_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatProvRelSec_Z", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovrelsec_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatProvRelRef_Z", gxTv_SdtCategoria_Provincias_Catprovrelref_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatProvRelSec_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovrelsec_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatProvRelRef_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovrelref_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CatProvOld_N", GXutil.trim( GXutil.str( gxTv_SdtCategoria_Provincias_Catprovold_N, 1, 0)));
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
      AddObjectProperty("CatPaiCod", gxTv_SdtCategoria_Provincias_Catpaicod, false, includeNonInitialized);
      AddObjectProperty("CatProvCod", gxTv_SdtCategoria_Provincias_Catprovcod, false, includeNonInitialized);
      AddObjectProperty("CatProvRelSec", gxTv_SdtCategoria_Provincias_Catprovrelsec, false, includeNonInitialized);
      AddObjectProperty("CatProvRelSec_N", gxTv_SdtCategoria_Provincias_Catprovrelsec_N, false, includeNonInitialized);
      AddObjectProperty("CatProvRelRef", gxTv_SdtCategoria_Provincias_Catprovrelref, false, includeNonInitialized);
      AddObjectProperty("CatProvRelRef_N", gxTv_SdtCategoria_Provincias_Catprovrelref_N, false, includeNonInitialized);
      AddObjectProperty("CatProvOld", gxTv_SdtCategoria_Provincias_Catprovold, false, includeNonInitialized);
      AddObjectProperty("CatProvOld_N", gxTv_SdtCategoria_Provincias_Catprovold_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCategoria_Provincias_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtCategoria_Provincias_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCategoria_Provincias_Initialized, false, includeNonInitialized);
         AddObjectProperty("CatPaiCod_Z", gxTv_SdtCategoria_Provincias_Catpaicod_Z, false, includeNonInitialized);
         AddObjectProperty("CatProvCod_Z", gxTv_SdtCategoria_Provincias_Catprovcod_Z, false, includeNonInitialized);
         AddObjectProperty("CatProvRelSec_Z", gxTv_SdtCategoria_Provincias_Catprovrelsec_Z, false, includeNonInitialized);
         AddObjectProperty("CatProvRelRef_Z", gxTv_SdtCategoria_Provincias_Catprovrelref_Z, false, includeNonInitialized);
         AddObjectProperty("CatProvRelSec_N", gxTv_SdtCategoria_Provincias_Catprovrelsec_N, false, includeNonInitialized);
         AddObjectProperty("CatProvRelRef_N", gxTv_SdtCategoria_Provincias_Catprovrelref_N, false, includeNonInitialized);
         AddObjectProperty("CatProvOld_N", gxTv_SdtCategoria_Provincias_Catprovold_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtCategoria_Provincias sdt )
   {
      if ( sdt.IsDirty("CatPaiCod") )
      {
         gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
         gxTv_SdtCategoria_Provincias_Catpaicod = sdt.getgxTv_SdtCategoria_Provincias_Catpaicod() ;
      }
      if ( sdt.IsDirty("CatProvCod") )
      {
         gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
         gxTv_SdtCategoria_Provincias_Catprovcod = sdt.getgxTv_SdtCategoria_Provincias_Catprovcod() ;
      }
      if ( sdt.IsDirty("CatProvRelSec") )
      {
         gxTv_SdtCategoria_Provincias_Catprovrelsec_N = sdt.getgxTv_SdtCategoria_Provincias_Catprovrelsec_N() ;
         gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
         gxTv_SdtCategoria_Provincias_Catprovrelsec = sdt.getgxTv_SdtCategoria_Provincias_Catprovrelsec() ;
      }
      if ( sdt.IsDirty("CatProvRelRef") )
      {
         gxTv_SdtCategoria_Provincias_Catprovrelref_N = sdt.getgxTv_SdtCategoria_Provincias_Catprovrelref_N() ;
         gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
         gxTv_SdtCategoria_Provincias_Catprovrelref = sdt.getgxTv_SdtCategoria_Provincias_Catprovrelref() ;
      }
      if ( sdt.IsDirty("CatProvOld") )
      {
         gxTv_SdtCategoria_Provincias_Catprovold_N = sdt.getgxTv_SdtCategoria_Provincias_Catprovold_N() ;
         gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
         gxTv_SdtCategoria_Provincias_Catprovold = sdt.getgxTv_SdtCategoria_Provincias_Catprovold() ;
      }
   }

   public short getgxTv_SdtCategoria_Provincias_Catpaicod( )
   {
      return gxTv_SdtCategoria_Provincias_Catpaicod ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catpaicod( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catpaicod");
      gxTv_SdtCategoria_Provincias_Catpaicod = value ;
   }

   public short getgxTv_SdtCategoria_Provincias_Catprovcod( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovcod ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovcod( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovcod");
      gxTv_SdtCategoria_Provincias_Catprovcod = value ;
   }

   public int getgxTv_SdtCategoria_Provincias_Catprovrelsec( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelsec ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelsec( int value )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovrelsec");
      gxTv_SdtCategoria_Provincias_Catprovrelsec = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelsec_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = (byte)(1) ;
      gxTv_SdtCategoria_Provincias_Catprovrelsec = 0 ;
      SetDirty("Catprovrelsec");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovrelsec_IsNull( )
   {
      return (gxTv_SdtCategoria_Provincias_Catprovrelsec_N==1) ;
   }

   public String getgxTv_SdtCategoria_Provincias_Catprovrelref( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelref ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelref( String value )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovrelref");
      gxTv_SdtCategoria_Provincias_Catprovrelref = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelref_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = (byte)(1) ;
      gxTv_SdtCategoria_Provincias_Catprovrelref = "" ;
      SetDirty("Catprovrelref");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovrelref_IsNull( )
   {
      return (gxTv_SdtCategoria_Provincias_Catprovrelref_N==1) ;
   }

   public String getgxTv_SdtCategoria_Provincias_Catprovold( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovold ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovold( String value )
   {
      gxTv_SdtCategoria_Provincias_Catprovold_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovold");
      gxTv_SdtCategoria_Provincias_Catprovold = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovold_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovold_N = (byte)(1) ;
      gxTv_SdtCategoria_Provincias_Catprovold = "" ;
      SetDirty("Catprovold");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovold_IsNull( )
   {
      return (gxTv_SdtCategoria_Provincias_Catprovold_N==1) ;
   }

   public String getgxTv_SdtCategoria_Provincias_Mode( )
   {
      return gxTv_SdtCategoria_Provincias_Mode ;
   }

   public void setgxTv_SdtCategoria_Provincias_Mode( String value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCategoria_Provincias_Mode = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Mode_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Provincias_Modified( )
   {
      return gxTv_SdtCategoria_Provincias_Modified ;
   }

   public void setgxTv_SdtCategoria_Provincias_Modified( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtCategoria_Provincias_Modified = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Modified_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Provincias_Initialized( )
   {
      return gxTv_SdtCategoria_Provincias_Initialized ;
   }

   public void setgxTv_SdtCategoria_Provincias_Initialized( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtCategoria_Provincias_Initialized = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Initialized_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Provincias_Catpaicod_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catpaicod_Z ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catpaicod_Z( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catpaicod_Z");
      gxTv_SdtCategoria_Provincias_Catpaicod_Z = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catpaicod_Z_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catpaicod_Z = (short)(0) ;
      SetDirty("Catpaicod_Z");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catpaicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCategoria_Provincias_Catprovcod_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovcod_Z ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovcod_Z( short value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovcod_Z");
      gxTv_SdtCategoria_Provincias_Catprovcod_Z = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovcod_Z_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovcod_Z = (short)(0) ;
      SetDirty("Catprovcod_Z");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovcod_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtCategoria_Provincias_Catprovrelsec_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelsec_Z ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelsec_Z( int value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovrelsec_Z");
      gxTv_SdtCategoria_Provincias_Catprovrelsec_Z = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelsec_Z_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelsec_Z = 0 ;
      SetDirty("Catprovrelsec_Z");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovrelsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCategoria_Provincias_Catprovrelref_Z( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelref_Z ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelref_Z( String value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovrelref_Z");
      gxTv_SdtCategoria_Provincias_Catprovrelref_Z = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelref_Z_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelref_Z = "" ;
      SetDirty("Catprovrelref_Z");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovrelref_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Provincias_Catprovrelsec_N( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelsec_N ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelsec_N( byte value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovrelsec_N");
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelsec_N_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelsec_N = (byte)(0) ;
      SetDirty("Catprovrelsec_N");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovrelsec_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Provincias_Catprovrelref_N( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovrelref_N ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelref_N( byte value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovrelref_N");
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovrelref_N_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovrelref_N = (byte)(0) ;
      SetDirty("Catprovrelref_N");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovrelref_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtCategoria_Provincias_Catprovold_N( )
   {
      return gxTv_SdtCategoria_Provincias_Catprovold_N ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovold_N( byte value )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(0) ;
      gxTv_SdtCategoria_Provincias_Modified = (short)(1) ;
      SetDirty("Catprovold_N");
      gxTv_SdtCategoria_Provincias_Catprovold_N = value ;
   }

   public void setgxTv_SdtCategoria_Provincias_Catprovold_N_SetNull( )
   {
      gxTv_SdtCategoria_Provincias_Catprovold_N = (byte)(0) ;
      SetDirty("Catprovold_N");
   }

   public boolean getgxTv_SdtCategoria_Provincias_Catprovold_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCategoria_Provincias_N = (byte)(1) ;
      gxTv_SdtCategoria_Provincias_Catprovrelref = "" ;
      gxTv_SdtCategoria_Provincias_Catprovold = "" ;
      gxTv_SdtCategoria_Provincias_Mode = "" ;
      gxTv_SdtCategoria_Provincias_Catprovrelref_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCategoria_Provincias_N ;
   }

   public web.SdtCategoria_Provincias Clone( )
   {
      return (web.SdtCategoria_Provincias)(clone()) ;
   }

   public void setStruct( web.StructSdtCategoria_Provincias struct )
   {
      setgxTv_SdtCategoria_Provincias_Catpaicod(struct.getCatpaicod());
      setgxTv_SdtCategoria_Provincias_Catprovcod(struct.getCatprovcod());
      setgxTv_SdtCategoria_Provincias_Catprovrelsec(struct.getCatprovrelsec());
      setgxTv_SdtCategoria_Provincias_Catprovrelref(struct.getCatprovrelref());
      setgxTv_SdtCategoria_Provincias_Catprovold(struct.getCatprovold());
      setgxTv_SdtCategoria_Provincias_Mode(struct.getMode());
      setgxTv_SdtCategoria_Provincias_Modified(struct.getModified());
      setgxTv_SdtCategoria_Provincias_Initialized(struct.getInitialized());
      setgxTv_SdtCategoria_Provincias_Catpaicod_Z(struct.getCatpaicod_Z());
      setgxTv_SdtCategoria_Provincias_Catprovcod_Z(struct.getCatprovcod_Z());
      setgxTv_SdtCategoria_Provincias_Catprovrelsec_Z(struct.getCatprovrelsec_Z());
      setgxTv_SdtCategoria_Provincias_Catprovrelref_Z(struct.getCatprovrelref_Z());
      setgxTv_SdtCategoria_Provincias_Catprovrelsec_N(struct.getCatprovrelsec_N());
      setgxTv_SdtCategoria_Provincias_Catprovrelref_N(struct.getCatprovrelref_N());
      setgxTv_SdtCategoria_Provincias_Catprovold_N(struct.getCatprovold_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtCategoria_Provincias getStruct( )
   {
      web.StructSdtCategoria_Provincias struct = new web.StructSdtCategoria_Provincias ();
      struct.setCatpaicod(getgxTv_SdtCategoria_Provincias_Catpaicod());
      struct.setCatprovcod(getgxTv_SdtCategoria_Provincias_Catprovcod());
      struct.setCatprovrelsec(getgxTv_SdtCategoria_Provincias_Catprovrelsec());
      struct.setCatprovrelref(getgxTv_SdtCategoria_Provincias_Catprovrelref());
      struct.setCatprovold(getgxTv_SdtCategoria_Provincias_Catprovold());
      struct.setMode(getgxTv_SdtCategoria_Provincias_Mode());
      struct.setModified(getgxTv_SdtCategoria_Provincias_Modified());
      struct.setInitialized(getgxTv_SdtCategoria_Provincias_Initialized());
      struct.setCatpaicod_Z(getgxTv_SdtCategoria_Provincias_Catpaicod_Z());
      struct.setCatprovcod_Z(getgxTv_SdtCategoria_Provincias_Catprovcod_Z());
      struct.setCatprovrelsec_Z(getgxTv_SdtCategoria_Provincias_Catprovrelsec_Z());
      struct.setCatprovrelref_Z(getgxTv_SdtCategoria_Provincias_Catprovrelref_Z());
      struct.setCatprovrelsec_N(getgxTv_SdtCategoria_Provincias_Catprovrelsec_N());
      struct.setCatprovrelref_N(getgxTv_SdtCategoria_Provincias_Catprovrelref_N());
      struct.setCatprovold_N(getgxTv_SdtCategoria_Provincias_Catprovold_N());
      return struct ;
   }

   private byte gxTv_SdtCategoria_Provincias_N ;
   private byte gxTv_SdtCategoria_Provincias_Catprovrelsec_N ;
   private byte gxTv_SdtCategoria_Provincias_Catprovrelref_N ;
   private byte gxTv_SdtCategoria_Provincias_Catprovold_N ;
   private short gxTv_SdtCategoria_Provincias_Catpaicod ;
   private short gxTv_SdtCategoria_Provincias_Catprovcod ;
   private short gxTv_SdtCategoria_Provincias_Modified ;
   private short gxTv_SdtCategoria_Provincias_Initialized ;
   private short gxTv_SdtCategoria_Provincias_Catpaicod_Z ;
   private short gxTv_SdtCategoria_Provincias_Catprovcod_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtCategoria_Provincias_Catprovrelsec ;
   private int gxTv_SdtCategoria_Provincias_Catprovrelsec_Z ;
   private String gxTv_SdtCategoria_Provincias_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCategoria_Provincias_Catprovold ;
   private String gxTv_SdtCategoria_Provincias_Catprovrelref ;
   private String gxTv_SdtCategoria_Provincias_Catprovrelref_Z ;
}

