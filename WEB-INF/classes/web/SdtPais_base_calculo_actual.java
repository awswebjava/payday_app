package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_base_calculo_actual extends GxSilentTrnSdt
{
   public SdtPais_base_calculo_actual( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_base_calculo_actual.class));
   }

   public SdtPais_base_calculo_actual( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_base_calculo_actual");
      initialize( remoteHandle) ;
   }

   public SdtPais_base_calculo_actual( int remoteHandle ,
                                       StructSdtPais_base_calculo_actual struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_base_calculo_actual( )
   {
      super( new ModelContext(SdtPais_base_calculo_actual.class), "SdtPais_base_calculo_actual");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiBaseCliCod", int.class}, new Object[]{"PaiBaseConCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "actual");
      metadata.set("BT", "Paisbase_calculoactual");
      metadata.set("PK", "[ \"PaiBaseCliCod\",\"PaiBaseConCodigo\" ]");
      metadata.set("PKAssigned", "[ \"PaiBaseCliCod\",\"PaiBaseConCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"PaiBaseCliCod-CliCod\",\"PaiBaseConCodigo-ConCodigo\" ] },{ \"FK\":[ \"PaiCod\",\"PaiBaseClaseLeg\",\"PaiBaseTipo\",\"PaiBaseCod1\",\"PaiBaseCod2\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseCliCod") )
            {
               gxTv_SdtPais_base_calculo_actual_Paibaseclicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseConCodigo") )
            {
               gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseConHabitual") )
            {
               gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_base_calculo_actual_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_base_calculo_actual_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_base_calculo_actual_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseCliCod_Z") )
            {
               gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseConCodigo_Z") )
            {
               gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiBaseConHabitual_Z") )
            {
               gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Pais.base_calculo.actual" ;
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
      oWriter.writeElement("PaiBaseCliCod", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_actual_Paibaseclicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBaseConCodigo", gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiBaseConHabitual", GXutil.booltostr( gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_base_calculo_actual_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_actual_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_actual_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseCliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseConCodigo_Z", gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiBaseConHabitual_Z", GXutil.booltostr( gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z));
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
      AddObjectProperty("PaiBaseCliCod", gxTv_SdtPais_base_calculo_actual_Paibaseclicod, false, includeNonInitialized);
      AddObjectProperty("PaiBaseConCodigo", gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo, false, includeNonInitialized);
      AddObjectProperty("PaiBaseConHabitual", gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_base_calculo_actual_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_base_calculo_actual_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_base_calculo_actual_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiBaseCliCod_Z", gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBaseConCodigo_Z", gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("PaiBaseConHabitual_Z", gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_base_calculo_actual sdt )
   {
      if ( sdt.IsDirty("PaiBaseCliCod") )
      {
         gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_actual_Paibaseclicod = sdt.getgxTv_SdtPais_base_calculo_actual_Paibaseclicod() ;
      }
      if ( sdt.IsDirty("PaiBaseConCodigo") )
      {
         gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo = sdt.getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo() ;
      }
      if ( sdt.IsDirty("PaiBaseConHabitual") )
      {
         gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
         gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual = sdt.getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual() ;
      }
   }

   public int getgxTv_SdtPais_base_calculo_actual_Paibaseclicod( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseclicod ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseclicod( int value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Paibaseclicod");
      gxTv_SdtPais_base_calculo_actual_Paibaseclicod = value ;
   }

   public String getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo( String value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Paibaseconcodigo");
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo = value ;
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual( boolean value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Paibaseconhabitual");
      gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual = value ;
   }

   public String getgxTv_SdtPais_base_calculo_actual_Mode( )
   {
      return gxTv_SdtPais_base_calculo_actual_Mode ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Mode( String value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_base_calculo_actual_Mode = value ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Mode_SetNull( )
   {
      gxTv_SdtPais_base_calculo_actual_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_actual_Modified( )
   {
      return gxTv_SdtPais_base_calculo_actual_Modified ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Modified( short value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_base_calculo_actual_Modified = value ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Modified_SetNull( )
   {
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_base_calculo_actual_Initialized( )
   {
      return gxTv_SdtPais_base_calculo_actual_Initialized ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Initialized( short value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_base_calculo_actual_Initialized = value ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Initialized_SetNull( )
   {
      gxTv_SdtPais_base_calculo_actual_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z( int value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Paibaseclicod_Z");
      gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z = 0 ;
      SetDirty("Paibaseclicod_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z( String value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Paibaseconcodigo_Z");
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z = "" ;
      SetDirty("Paibaseconcodigo_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z( )
   {
      return gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z( boolean value )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(0) ;
      gxTv_SdtPais_base_calculo_actual_Modified = (short)(1) ;
      SetDirty("Paibaseconhabitual_Z");
      gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z = value ;
   }

   public void setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z_SetNull( )
   {
      gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z = false ;
      SetDirty("Paibaseconhabitual_Z");
   }

   public boolean getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_base_calculo_actual_N = (byte)(1) ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo = "" ;
      gxTv_SdtPais_base_calculo_actual_Mode = "" ;
      gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_base_calculo_actual_N ;
   }

   public web.SdtPais_base_calculo_actual Clone( )
   {
      return (web.SdtPais_base_calculo_actual)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_base_calculo_actual struct )
   {
      setgxTv_SdtPais_base_calculo_actual_Paibaseclicod(struct.getPaibaseclicod());
      setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo(struct.getPaibaseconcodigo());
      setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual(struct.getPaibaseconhabitual());
      setgxTv_SdtPais_base_calculo_actual_Mode(struct.getMode());
      setgxTv_SdtPais_base_calculo_actual_Modified(struct.getModified());
      setgxTv_SdtPais_base_calculo_actual_Initialized(struct.getInitialized());
      setgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z(struct.getPaibaseclicod_Z());
      setgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z(struct.getPaibaseconcodigo_Z());
      setgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z(struct.getPaibaseconhabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_base_calculo_actual getStruct( )
   {
      web.StructSdtPais_base_calculo_actual struct = new web.StructSdtPais_base_calculo_actual ();
      struct.setPaibaseclicod(getgxTv_SdtPais_base_calculo_actual_Paibaseclicod());
      struct.setPaibaseconcodigo(getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo());
      struct.setPaibaseconhabitual(getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual());
      struct.setMode(getgxTv_SdtPais_base_calculo_actual_Mode());
      struct.setModified(getgxTv_SdtPais_base_calculo_actual_Modified());
      struct.setInitialized(getgxTv_SdtPais_base_calculo_actual_Initialized());
      struct.setPaibaseclicod_Z(getgxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z());
      struct.setPaibaseconcodigo_Z(getgxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z());
      struct.setPaibaseconhabitual_Z(getgxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_base_calculo_actual_N ;
   private short gxTv_SdtPais_base_calculo_actual_Modified ;
   private short gxTv_SdtPais_base_calculo_actual_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtPais_base_calculo_actual_Paibaseclicod ;
   private int gxTv_SdtPais_base_calculo_actual_Paibaseclicod_Z ;
   private String gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo ;
   private String gxTv_SdtPais_base_calculo_actual_Mode ;
   private String gxTv_SdtPais_base_calculo_actual_Paibaseconcodigo_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual ;
   private boolean gxTv_SdtPais_base_calculo_actual_Paibaseconhabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

