package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_promedio_horanormal_mensualizados extends GxSilentTrnSdt
{
   public SdtPais_promedio_horanormal_mensualizados( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_promedio_horanormal_mensualizados.class));
   }

   public SdtPais_promedio_horanormal_mensualizados( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_promedio_horanormal_mensualizados");
      initialize( remoteHandle) ;
   }

   public SdtPais_promedio_horanormal_mensualizados( int remoteHandle ,
                                                     StructSdtPais_promedio_horanormal_mensualizados struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_promedio_horanormal_mensualizados( )
   {
      super( new ModelContext(SdtPais_promedio_horanormal_mensualizados.class), "SdtPais_promedio_horanormal_mensualizados");
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
      return (Object[][])(new Object[][]{new Object[]{"TipoConCod", String.class}, new Object[]{"PaiPromFijVar", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "promedio_horanormal_mensualizados");
      metadata.set("BT", "Paispromedio_horanormal_mensualizados");
      metadata.set("PK", "[ \"TipoConCod\",\"PaiPromFijVar\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoConCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoConCod") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromFijVar") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromHabitual") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoConCod_Z") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromFijVar_Z") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPromHabitual_Z") )
            {
               gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Pais.promedio_horanormal_mensualizados" ;
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
      oWriter.writeElement("TipoConCod", gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPromFijVar", gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPromHabitual", GXutil.booltostr( gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_promedio_horanormal_mensualizados_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_promedio_horanormal_mensualizados_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoConCod_Z", gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPromFijVar_Z", gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPromHabitual_Z", GXutil.booltostr( gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z));
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
      AddObjectProperty("TipoConCod", gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod, false, includeNonInitialized);
      AddObjectProperty("PaiPromFijVar", gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar, false, includeNonInitialized);
      AddObjectProperty("PaiPromHabitual", gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_promedio_horanormal_mensualizados_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_promedio_horanormal_mensualizados_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized, false, includeNonInitialized);
         AddObjectProperty("TipoConCod_Z", gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPromFijVar_Z", gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPromHabitual_Z", gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_promedio_horanormal_mensualizados sdt )
   {
      if ( sdt.IsDirty("TipoConCod") )
      {
         gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod = sdt.getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod() ;
      }
      if ( sdt.IsDirty("PaiPromFijVar") )
      {
         gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar = sdt.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar() ;
      }
      if ( sdt.IsDirty("PaiPromHabitual") )
      {
         gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual = sdt.getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual() ;
      }
   }

   public String getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod( String value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Tipoconcod");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod = value ;
   }

   public String getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar( String value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paipromfijvar");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar = value ;
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual( boolean value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paipromhabitual");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual = value ;
   }

   public String getgxTv_SdtPais_promedio_horanormal_mensualizados_Mode( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Mode ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode( String value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Mode = value ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode_SetNull( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_promedio_horanormal_mensualizados_Modified( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Modified ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified( short value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = value ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified_SetNull( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_promedio_horanormal_mensualizados_Initialized( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Initialized( short value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized = value ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Initialized_SetNull( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z( String value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Tipoconcod_Z");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z = value ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z_SetNull( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z = "" ;
      SetDirty("Tipoconcod_Z");
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z( String value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paipromfijvar_Z");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z = value ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z_SetNull( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z = "" ;
      SetDirty("Paipromfijvar_Z");
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z( boolean value )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paipromhabitual_Z");
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z = value ;
   }

   public void setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z_SetNull( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z = false ;
      SetDirty("Paipromhabitual_Z");
   }

   public boolean getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod = "" ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_N = (byte)(1) ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar = "" ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Mode = "" ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z = "" ;
      gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_promedio_horanormal_mensualizados_N ;
   }

   public web.SdtPais_promedio_horanormal_mensualizados Clone( )
   {
      return (web.SdtPais_promedio_horanormal_mensualizados)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_promedio_horanormal_mensualizados struct )
   {
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod(struct.getTipoconcod());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar(struct.getPaipromfijvar());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual(struct.getPaipromhabitual());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Mode(struct.getMode());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Modified(struct.getModified());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Initialized(struct.getInitialized());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z(struct.getTipoconcod_Z());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z(struct.getPaipromfijvar_Z());
      setgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z(struct.getPaipromhabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_promedio_horanormal_mensualizados getStruct( )
   {
      web.StructSdtPais_promedio_horanormal_mensualizados struct = new web.StructSdtPais_promedio_horanormal_mensualizados ();
      struct.setTipoconcod(getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod());
      struct.setPaipromfijvar(getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar());
      struct.setPaipromhabitual(getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual());
      struct.setMode(getgxTv_SdtPais_promedio_horanormal_mensualizados_Mode());
      struct.setModified(getgxTv_SdtPais_promedio_horanormal_mensualizados_Modified());
      struct.setInitialized(getgxTv_SdtPais_promedio_horanormal_mensualizados_Initialized());
      struct.setTipoconcod_Z(getgxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z());
      struct.setPaipromfijvar_Z(getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z());
      struct.setPaipromhabitual_Z(getgxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_promedio_horanormal_mensualizados_N ;
   private short gxTv_SdtPais_promedio_horanormal_mensualizados_Modified ;
   private short gxTv_SdtPais_promedio_horanormal_mensualizados_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod ;
   private String gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar ;
   private String gxTv_SdtPais_promedio_horanormal_mensualizados_Mode ;
   private String gxTv_SdtPais_promedio_horanormal_mensualizados_Tipoconcod_Z ;
   private String gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromfijvar_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual ;
   private boolean gxTv_SdtPais_promedio_horanormal_mensualizados_Paipromhabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

