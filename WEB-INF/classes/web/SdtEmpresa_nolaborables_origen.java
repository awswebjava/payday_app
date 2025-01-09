package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_nolaborables_origen extends GxSilentTrnSdt
{
   public SdtEmpresa_nolaborables_origen( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_nolaborables_origen.class));
   }

   public SdtEmpresa_nolaborables_origen( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_nolaborables_origen");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_nolaborables_origen( int remoteHandle ,
                                          StructSdtEmpresa_nolaborables_origen struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_nolaborables_origen( )
   {
      super( new ModelContext(SdtEmpresa_nolaborables_origen.class), "SdtEmpresa_nolaborables_origen");
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
      return (Object[][])(new Object[][]{new Object[]{"EmpOrigen", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "nolaborables_origen");
      metadata.set("BT", "Empresanolaborables_origen");
      metadata.set("PK", "[ \"EmpOrigen\" ]");
      metadata.set("PKAssigned", "[ \"EmpOrigen\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"OrigId\" ],\"FKMap\":[ \"EmpOrigen-OrigId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOrigen") )
            {
               gxTv_SdtEmpresa_nolaborables_origen_Emporigen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_nolaborables_origen_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_nolaborables_origen_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_nolaborables_origen_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpOrigen_Z") )
            {
               gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z = oReader.getValue() ;
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
         sName = "Empresa.nolaborables_origen" ;
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
      oWriter.writeElement("EmpOrigen", gxTv_SdtEmpresa_nolaborables_origen_Emporigen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_nolaborables_origen_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_nolaborables_origen_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_nolaborables_origen_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpOrigen_Z", gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z);
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
      AddObjectProperty("EmpOrigen", gxTv_SdtEmpresa_nolaborables_origen_Emporigen, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_nolaborables_origen_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_nolaborables_origen_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_nolaborables_origen_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpOrigen_Z", gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_nolaborables_origen sdt )
   {
      if ( sdt.IsDirty("EmpOrigen") )
      {
         gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(0) ;
         gxTv_SdtEmpresa_nolaborables_origen_Emporigen = sdt.getgxTv_SdtEmpresa_nolaborables_origen_Emporigen() ;
      }
   }

   public String getgxTv_SdtEmpresa_nolaborables_origen_Emporigen( )
   {
      return gxTv_SdtEmpresa_nolaborables_origen_Emporigen ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Emporigen( String value )
   {
      gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_origen_Modified = (short)(1) ;
      SetDirty("Emporigen");
      gxTv_SdtEmpresa_nolaborables_origen_Emporigen = value ;
   }

   public String getgxTv_SdtEmpresa_nolaborables_origen_Mode( )
   {
      return gxTv_SdtEmpresa_nolaborables_origen_Mode ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Mode( String value )
   {
      gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_nolaborables_origen_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_nolaborables_origen_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_nolaborables_origen_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_nolaborables_origen_Modified( )
   {
      return gxTv_SdtEmpresa_nolaborables_origen_Modified ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Modified( short value )
   {
      gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_nolaborables_origen_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_nolaborables_origen_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_nolaborables_origen_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_nolaborables_origen_Initialized( )
   {
      return gxTv_SdtEmpresa_nolaborables_origen_Initialized ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Initialized( short value )
   {
      gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_origen_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_nolaborables_origen_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_nolaborables_origen_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_nolaborables_origen_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z( )
   {
      return gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z( String value )
   {
      gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(0) ;
      gxTv_SdtEmpresa_nolaborables_origen_Modified = (short)(1) ;
      SetDirty("Emporigen_Z");
      gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z = value ;
   }

   public void setgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z_SetNull( )
   {
      gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z = "" ;
      SetDirty("Emporigen_Z");
   }

   public boolean getgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_nolaborables_origen_Emporigen = "" ;
      gxTv_SdtEmpresa_nolaborables_origen_N = (byte)(1) ;
      gxTv_SdtEmpresa_nolaborables_origen_Mode = "" ;
      gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_nolaborables_origen_N ;
   }

   public web.SdtEmpresa_nolaborables_origen Clone( )
   {
      return (web.SdtEmpresa_nolaborables_origen)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_nolaborables_origen struct )
   {
      setgxTv_SdtEmpresa_nolaborables_origen_Emporigen(struct.getEmporigen());
      setgxTv_SdtEmpresa_nolaborables_origen_Mode(struct.getMode());
      setgxTv_SdtEmpresa_nolaborables_origen_Modified(struct.getModified());
      setgxTv_SdtEmpresa_nolaborables_origen_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z(struct.getEmporigen_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_nolaborables_origen getStruct( )
   {
      web.StructSdtEmpresa_nolaborables_origen struct = new web.StructSdtEmpresa_nolaborables_origen ();
      struct.setEmporigen(getgxTv_SdtEmpresa_nolaborables_origen_Emporigen());
      struct.setMode(getgxTv_SdtEmpresa_nolaborables_origen_Mode());
      struct.setModified(getgxTv_SdtEmpresa_nolaborables_origen_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_nolaborables_origen_Initialized());
      struct.setEmporigen_Z(getgxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_nolaborables_origen_N ;
   private short gxTv_SdtEmpresa_nolaborables_origen_Modified ;
   private short gxTv_SdtEmpresa_nolaborables_origen_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEmpresa_nolaborables_origen_Emporigen ;
   private String gxTv_SdtEmpresa_nolaborables_origen_Mode ;
   private String gxTv_SdtEmpresa_nolaborables_origen_Emporigen_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

