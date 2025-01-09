package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1_nolaborables_convenio extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1_nolaborables_convenio( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1_nolaborables_convenio.class));
   }

   public SdtEmpresa_abm_1_nolaborables_convenio( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1_nolaborables_convenio");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1_nolaborables_convenio( int remoteHandle ,
                                                  StructSdtEmpresa_abm_1_nolaborables_convenio struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_abm_1_nolaborables_convenio( )
   {
      super( new ModelContext(SdtEmpresa_abm_1_nolaborables_convenio.class), "SdtEmpresa_abm_1_nolaborables_convenio");
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
      return (Object[][])(new Object[][]{new Object[]{"EmpConvenio", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "nolaborables_convenio");
      metadata.set("BT", "Empresanolaborables_convenio");
      metadata.set("PK", "[ \"EmpConvenio\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpConvenio") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpConvenio_Z") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z = oReader.getValue() ;
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
         sName = "Empresa_abm_1.nolaborables_convenio" ;
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
      oWriter.writeElement("EmpConvenio", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpConvenio_Z", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z);
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
      AddObjectProperty("EmpConvenio", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpConvenio_Z", gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1_nolaborables_convenio sdt )
   {
      if ( sdt.IsDirty("EmpConvenio") )
      {
         gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio = sdt.getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio() ;
      }
   }

   public String getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified = (short)(1) ;
      SetDirty("Empconvenio");
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified = (short)(1) ;
      SetDirty("Empconvenio_Z");
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z = "" ;
      SetDirty("Empconvenio_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N ;
   }

   public web.SdtEmpresa_abm_1_nolaborables_convenio Clone( )
   {
      return (web.SdtEmpresa_abm_1_nolaborables_convenio)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1_nolaborables_convenio struct )
   {
      setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio(struct.getEmpconvenio());
      setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified(struct.getModified());
      setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z(struct.getEmpconvenio_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1_nolaborables_convenio getStruct( )
   {
      web.StructSdtEmpresa_abm_1_nolaborables_convenio struct = new web.StructSdtEmpresa_abm_1_nolaborables_convenio ();
      struct.setEmpconvenio(getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode());
      struct.setModified(getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized());
      struct.setEmpconvenio_Z(getgxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_nolaborables_convenio_N ;
   private short gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Modified ;
   private short gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio ;
   private String gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Mode ;
   private String gxTv_SdtEmpresa_abm_1_nolaborables_convenio_Empconvenio_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

