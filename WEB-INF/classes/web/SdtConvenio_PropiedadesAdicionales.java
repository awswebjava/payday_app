package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConvenio_PropiedadesAdicionales extends GxSilentTrnSdt
{
   public SdtConvenio_PropiedadesAdicionales( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConvenio_PropiedadesAdicionales.class));
   }

   public SdtConvenio_PropiedadesAdicionales( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtConvenio_PropiedadesAdicionales");
      initialize( remoteHandle) ;
   }

   public SdtConvenio_PropiedadesAdicionales( int remoteHandle ,
                                              StructSdtConvenio_PropiedadesAdicionales struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtConvenio_PropiedadesAdicionales( )
   {
      super( new ModelContext(SdtConvenio_PropiedadesAdicionales.class), "SdtConvenio_PropiedadesAdicionales");
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
      return (Object[][])(new Object[][]{new Object[]{"propCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "PropiedadesAdicionales");
      metadata.set("BT", "ConvenioPropiedadesAdicionales");
      metadata.set("PK", "[ \"propCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"PaiCod\",\"ConveCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"propCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "propCod") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Propcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "propDesc") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "propTipoDato") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvePropPredet") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "propCod_Z") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "propDesc_Z") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "propTipoDato_Z") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConvePropPredet_Z") )
            {
               gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z = oReader.getValue() ;
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
         sName = "Convenio.PropiedadesAdicionales" ;
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
      oWriter.writeElement("propCod", gxTv_SdtConvenio_PropiedadesAdicionales_Propcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("propDesc", gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("propTipoDato", gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConvePropPredet", gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtConvenio_PropiedadesAdicionales_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtConvenio_PropiedadesAdicionales_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConvenio_PropiedadesAdicionales_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("propCod_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("propDesc_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("propTipoDato_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConvePropPredet_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z);
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
      AddObjectProperty("propCod", gxTv_SdtConvenio_PropiedadesAdicionales_Propcod, false, includeNonInitialized);
      AddObjectProperty("propDesc", gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc, false, includeNonInitialized);
      AddObjectProperty("propTipoDato", gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato, false, includeNonInitialized);
      AddObjectProperty("ConvePropPredet", gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConvenio_PropiedadesAdicionales_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtConvenio_PropiedadesAdicionales_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConvenio_PropiedadesAdicionales_Initialized, false, includeNonInitialized);
         AddObjectProperty("propCod_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z, false, includeNonInitialized);
         AddObjectProperty("propDesc_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z, false, includeNonInitialized);
         AddObjectProperty("propTipoDato_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z, false, includeNonInitialized);
         AddObjectProperty("ConvePropPredet_Z", gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtConvenio_PropiedadesAdicionales sdt )
   {
      if ( sdt.IsDirty("propCod") )
      {
         gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
         gxTv_SdtConvenio_PropiedadesAdicionales_Propcod = sdt.getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod() ;
      }
      if ( sdt.IsDirty("propDesc") )
      {
         gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
         gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc = sdt.getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc() ;
      }
      if ( sdt.IsDirty("propTipoDato") )
      {
         gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
         gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato = sdt.getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato() ;
      }
      if ( sdt.IsDirty("ConvePropPredet") )
      {
         gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
         gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet = sdt.getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet() ;
      }
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Propcod ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Propcod");
      gxTv_SdtConvenio_PropiedadesAdicionales_Propcod = value ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Propdesc");
      gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc = value ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Proptipodato");
      gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato = value ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Conveproppredet");
      gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet = value ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Mode( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Mode ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Mode( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConvenio_PropiedadesAdicionales_Mode = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Mode_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConvenio_PropiedadesAdicionales_Modified( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Modified ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Modified( short value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Modified_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConvenio_PropiedadesAdicionales_Initialized( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Initialized ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Initialized( short value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtConvenio_PropiedadesAdicionales_Initialized = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Initialized_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Propcod_Z");
      gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z = "" ;
      SetDirty("Propcod_Z");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Propdesc_Z");
      gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z = "" ;
      SetDirty("Propdesc_Z");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Proptipodato_Z");
      gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z = "" ;
      SetDirty("Proptipodato_Z");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z( String value )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(0) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Modified = (short)(1) ;
      SetDirty("Conveproppredet_Z");
      gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z = value ;
   }

   public void setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z_SetNull( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z = "" ;
      SetDirty("Conveproppredet_Z");
   }

   public boolean getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConvenio_PropiedadesAdicionales_Propcod = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_N = (byte)(1) ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Mode = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z = "" ;
      gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConvenio_PropiedadesAdicionales_N ;
   }

   public web.SdtConvenio_PropiedadesAdicionales Clone( )
   {
      return (web.SdtConvenio_PropiedadesAdicionales)(clone()) ;
   }

   public void setStruct( web.StructSdtConvenio_PropiedadesAdicionales struct )
   {
      setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod(struct.getPropcod());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc(struct.getPropdesc());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato(struct.getProptipodato());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet(struct.getConveproppredet());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Mode(struct.getMode());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Modified(struct.getModified());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Initialized(struct.getInitialized());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z(struct.getPropcod_Z());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z(struct.getPropdesc_Z());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z(struct.getProptipodato_Z());
      setgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z(struct.getConveproppredet_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConvenio_PropiedadesAdicionales getStruct( )
   {
      web.StructSdtConvenio_PropiedadesAdicionales struct = new web.StructSdtConvenio_PropiedadesAdicionales ();
      struct.setPropcod(getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod());
      struct.setPropdesc(getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc());
      struct.setProptipodato(getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato());
      struct.setConveproppredet(getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet());
      struct.setMode(getgxTv_SdtConvenio_PropiedadesAdicionales_Mode());
      struct.setModified(getgxTv_SdtConvenio_PropiedadesAdicionales_Modified());
      struct.setInitialized(getgxTv_SdtConvenio_PropiedadesAdicionales_Initialized());
      struct.setPropcod_Z(getgxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z());
      struct.setPropdesc_Z(getgxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z());
      struct.setProptipodato_Z(getgxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z());
      struct.setConveproppredet_Z(getgxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z());
      return struct ;
   }

   private byte gxTv_SdtConvenio_PropiedadesAdicionales_N ;
   private short gxTv_SdtConvenio_PropiedadesAdicionales_Modified ;
   private short gxTv_SdtConvenio_PropiedadesAdicionales_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Propcod ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Mode ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Propcod_Z ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Proptipodato_Z ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Conveproppredet_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc ;
   private String gxTv_SdtConvenio_PropiedadesAdicionales_Propdesc_Z ;
}

