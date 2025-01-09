package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_base_calculo_promedio extends GxSilentTrnSdt
{
   public SdtPais_base_calculo_promedio( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_base_calculo_promedio.class));
   }

   public SdtPais_base_calculo_promedio( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_base_calculo_promedio");
      initialize( remoteHandle) ;
   }

   public SdtPais_base_calculo_promedio( int remoteHandle ,
                                         StructSdtPais_base_calculo_promedio struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_base_calculo_promedio( )
   {
      super( new ModelContext(SdtPais_base_calculo_promedio.class), "SdtPais_base_calculo_promedio");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiBasePromCTipo", String.class}, new Object[]{"PaiBasePromFijVar", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "promedio");
      metadata.set("BT", "Paisbase_calculopromedio");
      metadata.set("PK", "[ \"PaiBasePromCTipo\",\"PaiBasePromFijVar\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\",\"PaiBaseClaseLeg\",\"PaiBaseTipo\",\"PaiBaseCod1\",\"PaiBaseCod2\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCTipo") )
            {
               gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromFijVar") )
            {
               gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromHab") )
            {
               gxTv_SdtPais_base_calculo_promedio_Paibasepromhab = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_base_calculo_promedio_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_base_calculo_promedio_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_base_calculo_promedio_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromCTipo_Z") )
            {
               gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromFijVar_Z") )
            {
               gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBasePromHab_Z") )
            {
               gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Pais.base_calculo.promedio" ;
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
      oWriter.writeElement("PaiBasePromCTipo", gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromFijVar", gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBasePromHab", GXutil.booltostr( gxTv_SdtPais_base_calculo_promedio_Paibasepromhab));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_base_calculo_promedio_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_promedio_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_promedio_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePromCTipo_Z", gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePromFijVar_Z", gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBasePromHab_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z));
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
      AddObjectProperty("PaiBasePromCTipo", gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo, false, includeNonInitialized);
      AddObjectProperty("PaiBasePromFijVar", gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar, false, includeNonInitialized);
      AddObjectProperty("PaiBasePromHab", gxTv_SdtPais_base_calculo_promedio_Paibasepromhab, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_base_calculo_promedio_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_base_calculo_promedio_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_base_calculo_promedio_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiBasePromCTipo_Z", gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBasePromFijVar_Z", gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBasePromHab_Z", gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_base_calculo_promedio sdt )
   {
      if ( sdt.IsDirty("PaiBasePromCTipo") )
      {
         gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo = sdt.getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo() ;
      }
      if ( sdt.IsDirty("PaiBasePromFijVar") )
      {
         gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar = sdt.getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar() ;
      }
      if ( sdt.IsDirty("PaiBasePromHab") )
      {
         gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_promedio_Paibasepromhab = sdt.getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab() ;
      }
   }

   public String getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Paibasepromctipo");
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo = value ;
   }

   public String getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Paibasepromfijvar");
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromhab ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab( boolean value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Paibasepromhab");
      gxTv_SdtPais_base_calculo_promedio_Paibasepromhab = value ;
   }

   public String getgxTv_SdtPais_base_calculo_promedio_Mode( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Mode ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Mode( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_base_calculo_promedio_Mode = value ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Mode_SetNull( )
   {
      gxTv_SdtPais_base_calculo_promedio_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_promedio_Modified( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Modified ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Modified( short value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_base_calculo_promedio_Modified = value ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Modified_SetNull( )
   {
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_promedio_Initialized( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Initialized ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Initialized( short value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_base_calculo_promedio_Initialized = value ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Initialized_SetNull( )
   {
      gxTv_SdtPais_base_calculo_promedio_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Paibasepromctipo_Z");
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z = "" ;
      SetDirty("Paibasepromctipo_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z( String value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Paibasepromfijvar_Z");
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z = "" ;
      SetDirty("Paibasepromfijvar_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z( )
   {
      return gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_promedio_Modified = (short)(1) ;
      SetDirty("Paibasepromhab_Z");
      gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z = false ;
      SetDirty("Paibasepromhab_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo = "" ;
      gxTv_SdtPais_base_calculo_promedio_N = (byte)(1) ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar = "" ;
      gxTv_SdtPais_base_calculo_promedio_Mode = "" ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z = "" ;
      gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_base_calculo_promedio_N ;
   }

   public web.SdtPais_base_calculo_promedio Clone( )
   {
      return (web.SdtPais_base_calculo_promedio)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_base_calculo_promedio struct )
   {
      setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo(struct.getPaibasepromctipo());
      setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar(struct.getPaibasepromfijvar());
      setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab(struct.getPaibasepromhab());
      setgxTv_SdtPais_base_calculo_promedio_Mode(struct.getMode());
      setgxTv_SdtPais_base_calculo_promedio_Modified(struct.getModified());
      setgxTv_SdtPais_base_calculo_promedio_Initialized(struct.getInitialized());
      setgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z(struct.getPaibasepromctipo_Z());
      setgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z(struct.getPaibasepromfijvar_Z());
      setgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z(struct.getPaibasepromhab_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_base_calculo_promedio getStruct( )
   {
      web.StructSdtPais_base_calculo_promedio struct = new web.StructSdtPais_base_calculo_promedio ();
      struct.setPaibasepromctipo(getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo());
      struct.setPaibasepromfijvar(getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar());
      struct.setPaibasepromhab(getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab());
      struct.setMode(getgxTv_SdtPais_base_calculo_promedio_Mode());
      struct.setModified(getgxTv_SdtPais_base_calculo_promedio_Modified());
      struct.setInitialized(getgxTv_SdtPais_base_calculo_promedio_Initialized());
      struct.setPaibasepromctipo_Z(getgxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z());
      struct.setPaibasepromfijvar_Z(getgxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z());
      struct.setPaibasepromhab_Z(getgxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_base_calculo_promedio_N ;
   private short gxTv_SdtPais_base_calculo_promedio_Modified ;
   private short gxTv_SdtPais_base_calculo_promedio_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo ;
   private String gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar ;
   private String gxTv_SdtPais_base_calculo_promedio_Mode ;
   private String gxTv_SdtPais_base_calculo_promedio_Paibasepromctipo_Z ;
   private String gxTv_SdtPais_base_calculo_promedio_Paibasepromfijvar_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_base_calculo_promedio_Paibasepromhab ;
   private boolean gxTv_SdtPais_base_calculo_promedio_Paibasepromhab_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

