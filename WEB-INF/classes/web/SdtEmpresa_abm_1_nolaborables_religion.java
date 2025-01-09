package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1_nolaborables_religion extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1_nolaborables_religion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1_nolaborables_religion.class));
   }

   public SdtEmpresa_abm_1_nolaborables_religion( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1_nolaborables_religion");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1_nolaborables_religion( int remoteHandle ,
                                                  StructSdtEmpresa_abm_1_nolaborables_religion struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_abm_1_nolaborables_religion( )
   {
      super( new ModelContext(SdtEmpresa_abm_1_nolaborables_religion.class), "SdtEmpresa_abm_1_nolaborables_religion");
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
      return (Object[][])(new Object[][]{new Object[]{"EmpReligion", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "nolaborables_religion");
      metadata.set("BT", "Empresanolaborables_religion");
      metadata.set("PK", "[ \"EmpReligion\" ]");
      metadata.set("PKAssigned", "[ \"EmpReligion\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"ReligId\" ],\"FKMap\":[ \"EmpReligion-ReligId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReligion") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpReligion_Z") )
            {
               gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z = oReader.getValue() ;
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
         sName = "Empresa_abm_1.nolaborables_religion" ;
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
      oWriter.writeElement("EmpReligion", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpReligion_Z", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z);
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
      AddObjectProperty("EmpReligion", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpReligion_Z", gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1_nolaborables_religion sdt )
   {
      if ( sdt.IsDirty("EmpReligion") )
      {
         gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion = sdt.getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion() ;
      }
   }

   public String getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = (short)(1) ;
      SetDirty("Empreligion");
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified = (short)(1) ;
      SetDirty("Empreligion_Z");
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z = "" ;
      SetDirty("Empreligion_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_nolaborables_religion_N ;
   }

   public web.SdtEmpresa_abm_1_nolaborables_religion Clone( )
   {
      return (web.SdtEmpresa_abm_1_nolaborables_religion)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1_nolaborables_religion struct )
   {
      setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion(struct.getEmpreligion());
      setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified(struct.getModified());
      setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z(struct.getEmpreligion_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1_nolaborables_religion getStruct( )
   {
      web.StructSdtEmpresa_abm_1_nolaborables_religion struct = new web.StructSdtEmpresa_abm_1_nolaborables_religion ();
      struct.setEmpreligion(getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode());
      struct.setModified(getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized());
      struct.setEmpreligion_Z(getgxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_nolaborables_religion_N ;
   private short gxTv_SdtEmpresa_abm_1_nolaborables_religion_Modified ;
   private short gxTv_SdtEmpresa_abm_1_nolaborables_religion_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion ;
   private String gxTv_SdtEmpresa_abm_1_nolaborables_religion_Mode ;
   private String gxTv_SdtEmpresa_abm_1_nolaborables_religion_Empreligion_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

