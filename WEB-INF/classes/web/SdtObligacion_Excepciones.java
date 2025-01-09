package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtObligacion_Excepciones extends GxSilentTrnSdt
{
   public SdtObligacion_Excepciones( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtObligacion_Excepciones.class));
   }

   public SdtObligacion_Excepciones( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtObligacion_Excepciones");
      initialize( remoteHandle) ;
   }

   public SdtObligacion_Excepciones( int remoteHandle ,
                                     StructSdtObligacion_Excepciones struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtObligacion_Excepciones( )
   {
      super( new ModelContext(SdtObligacion_Excepciones.class), "SdtObligacion_Excepciones");
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
      return (Object[][])(new Object[][]{new Object[]{"OblExcConCOdigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Excepciones");
      metadata.set("BT", "ObligacionExcepciones");
      metadata.set("PK", "[ \"OblExcConCOdigo\" ]");
      metadata.set("PKAssigned", "[ \"OblExcConCOdigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"OblExcConCOdigo-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\",\"OblSecuencial\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblExcConCOdigo") )
            {
               gxTv_SdtObligacion_Excepciones_Oblexcconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblExcTipo") )
            {
               gxTv_SdtObligacion_Excepciones_Oblexctipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtObligacion_Excepciones_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtObligacion_Excepciones_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtObligacion_Excepciones_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblExcConCOdigo_Z") )
            {
               gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OblExcTipo_Z") )
            {
               gxTv_SdtObligacion_Excepciones_Oblexctipo_Z = oReader.getValue() ;
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
         sName = "Obligacion.Excepciones" ;
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
      oWriter.writeElement("OblExcConCOdigo", gxTv_SdtObligacion_Excepciones_Oblexcconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("OblExcTipo", gxTv_SdtObligacion_Excepciones_Oblexctipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtObligacion_Excepciones_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Excepciones_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtObligacion_Excepciones_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblExcConCOdigo_Z", gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("OblExcTipo_Z", gxTv_SdtObligacion_Excepciones_Oblexctipo_Z);
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
      AddObjectProperty("OblExcConCOdigo", gxTv_SdtObligacion_Excepciones_Oblexcconcodigo, false, includeNonInitialized);
      AddObjectProperty("OblExcTipo", gxTv_SdtObligacion_Excepciones_Oblexctipo, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtObligacion_Excepciones_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtObligacion_Excepciones_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtObligacion_Excepciones_Initialized, false, includeNonInitialized);
         AddObjectProperty("OblExcConCOdigo_Z", gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("OblExcTipo_Z", gxTv_SdtObligacion_Excepciones_Oblexctipo_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtObligacion_Excepciones sdt )
   {
      if ( sdt.IsDirty("OblExcConCOdigo") )
      {
         gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
         gxTv_SdtObligacion_Excepciones_Oblexcconcodigo = sdt.getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo() ;
      }
      if ( sdt.IsDirty("OblExcTipo") )
      {
         gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
         gxTv_SdtObligacion_Excepciones_Oblexctipo = sdt.getgxTv_SdtObligacion_Excepciones_Oblexctipo() ;
      }
   }

   public String getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexcconcodigo ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Modified = (short)(1) ;
      SetDirty("Oblexcconcodigo");
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo = value ;
   }

   public String getgxTv_SdtObligacion_Excepciones_Oblexctipo( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexctipo ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Oblexctipo( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Modified = (short)(1) ;
      SetDirty("Oblexctipo");
      gxTv_SdtObligacion_Excepciones_Oblexctipo = value ;
   }

   public String getgxTv_SdtObligacion_Excepciones_Mode( )
   {
      return gxTv_SdtObligacion_Excepciones_Mode ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Mode( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtObligacion_Excepciones_Mode = value ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Mode_SetNull( )
   {
      gxTv_SdtObligacion_Excepciones_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtObligacion_Excepciones_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Excepciones_Modified( )
   {
      return gxTv_SdtObligacion_Excepciones_Modified ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Modified( short value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtObligacion_Excepciones_Modified = value ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Modified_SetNull( )
   {
      gxTv_SdtObligacion_Excepciones_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtObligacion_Excepciones_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtObligacion_Excepciones_Initialized( )
   {
      return gxTv_SdtObligacion_Excepciones_Initialized ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Initialized( short value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtObligacion_Excepciones_Initialized = value ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Initialized_SetNull( )
   {
      gxTv_SdtObligacion_Excepciones_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtObligacion_Excepciones_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Modified = (short)(1) ;
      SetDirty("Oblexcconcodigo_Z");
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z = value ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z_SetNull( )
   {
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z = "" ;
      SetDirty("Oblexcconcodigo_Z");
   }

   public boolean getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtObligacion_Excepciones_Oblexctipo_Z( )
   {
      return gxTv_SdtObligacion_Excepciones_Oblexctipo_Z ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Oblexctipo_Z( String value )
   {
      gxTv_SdtObligacion_Excepciones_N = (byte)(0) ;
      gxTv_SdtObligacion_Excepciones_Modified = (short)(1) ;
      SetDirty("Oblexctipo_Z");
      gxTv_SdtObligacion_Excepciones_Oblexctipo_Z = value ;
   }

   public void setgxTv_SdtObligacion_Excepciones_Oblexctipo_Z_SetNull( )
   {
      gxTv_SdtObligacion_Excepciones_Oblexctipo_Z = "" ;
      SetDirty("Oblexctipo_Z");
   }

   public boolean getgxTv_SdtObligacion_Excepciones_Oblexctipo_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo = "" ;
      gxTv_SdtObligacion_Excepciones_N = (byte)(1) ;
      gxTv_SdtObligacion_Excepciones_Oblexctipo = "" ;
      gxTv_SdtObligacion_Excepciones_Mode = "" ;
      gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z = "" ;
      gxTv_SdtObligacion_Excepciones_Oblexctipo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtObligacion_Excepciones_N ;
   }

   public web.SdtObligacion_Excepciones Clone( )
   {
      return (web.SdtObligacion_Excepciones)(clone()) ;
   }

   public void setStruct( web.StructSdtObligacion_Excepciones struct )
   {
      setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo(struct.getOblexcconcodigo());
      setgxTv_SdtObligacion_Excepciones_Oblexctipo(struct.getOblexctipo());
      setgxTv_SdtObligacion_Excepciones_Mode(struct.getMode());
      setgxTv_SdtObligacion_Excepciones_Modified(struct.getModified());
      setgxTv_SdtObligacion_Excepciones_Initialized(struct.getInitialized());
      setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z(struct.getOblexcconcodigo_Z());
      setgxTv_SdtObligacion_Excepciones_Oblexctipo_Z(struct.getOblexctipo_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtObligacion_Excepciones getStruct( )
   {
      web.StructSdtObligacion_Excepciones struct = new web.StructSdtObligacion_Excepciones ();
      struct.setOblexcconcodigo(getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo());
      struct.setOblexctipo(getgxTv_SdtObligacion_Excepciones_Oblexctipo());
      struct.setMode(getgxTv_SdtObligacion_Excepciones_Mode());
      struct.setModified(getgxTv_SdtObligacion_Excepciones_Modified());
      struct.setInitialized(getgxTv_SdtObligacion_Excepciones_Initialized());
      struct.setOblexcconcodigo_Z(getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z());
      struct.setOblexctipo_Z(getgxTv_SdtObligacion_Excepciones_Oblexctipo_Z());
      return struct ;
   }

   private byte gxTv_SdtObligacion_Excepciones_N ;
   private short gxTv_SdtObligacion_Excepciones_Modified ;
   private short gxTv_SdtObligacion_Excepciones_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtObligacion_Excepciones_Oblexcconcodigo ;
   private String gxTv_SdtObligacion_Excepciones_Oblexctipo ;
   private String gxTv_SdtObligacion_Excepciones_Mode ;
   private String gxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z ;
   private String gxTv_SdtObligacion_Excepciones_Oblexctipo_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

