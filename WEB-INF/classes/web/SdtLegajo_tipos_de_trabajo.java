package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLegajo_tipos_de_trabajo extends GxSilentTrnSdt
{
   public SdtLegajo_tipos_de_trabajo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLegajo_tipos_de_trabajo.class));
   }

   public SdtLegajo_tipos_de_trabajo( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtLegajo_tipos_de_trabajo");
      initialize( remoteHandle) ;
   }

   public SdtLegajo_tipos_de_trabajo( int remoteHandle ,
                                      StructSdtLegajo_tipos_de_trabajo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtLegajo_tipos_de_trabajo( )
   {
      super( new ModelContext(SdtLegajo_tipos_de_trabajo.class), "SdtLegajo_tipos_de_trabajo");
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
      return (Object[][])(new Object[][]{new Object[]{"LegTipoTra", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "tipos_de_trabajo");
      metadata.set("BT", "Legajotipos_de_trabajo");
      metadata.set("PK", "[ \"LegTipoTra\" ]");
      metadata.set("PKAssigned", "[ \"LegTipoTra\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LegNumero\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoTraId\" ],\"FKMap\":[ \"LegTipoTra-TipoTraId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTipoTra") )
            {
               gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLegajo_tipos_de_trabajo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtLegajo_tipos_de_trabajo_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLegajo_tipos_de_trabajo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegTipoTra_Z") )
            {
               gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z = oReader.getValue() ;
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
         sName = "Legajo.tipos_de_trabajo" ;
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
      oWriter.writeElement("LegTipoTra", gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLegajo_tipos_de_trabajo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtLegajo_tipos_de_trabajo_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLegajo_tipos_de_trabajo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegTipoTra_Z", gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z);
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
      AddObjectProperty("LegTipoTra", gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLegajo_tipos_de_trabajo_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtLegajo_tipos_de_trabajo_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLegajo_tipos_de_trabajo_Initialized, false, includeNonInitialized);
         AddObjectProperty("LegTipoTra_Z", gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLegajo_tipos_de_trabajo sdt )
   {
      if ( sdt.IsDirty("LegTipoTra") )
      {
         gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
         gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra = sdt.getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra() ;
      }
   }

   public String getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra( String value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Modified = (short)(1) ;
      SetDirty("Legtipotra");
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra = value ;
   }

   public String getgxTv_SdtLegajo_tipos_de_trabajo_Mode( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Mode ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Mode( String value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLegajo_tipos_de_trabajo_Mode = value ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Mode_SetNull( )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLegajo_tipos_de_trabajo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_tipos_de_trabajo_Modified( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Modified ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Modified( short value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtLegajo_tipos_de_trabajo_Modified = value ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Modified_SetNull( )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtLegajo_tipos_de_trabajo_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLegajo_tipos_de_trabajo_Initialized( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Initialized ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Initialized( short value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtLegajo_tipos_de_trabajo_Initialized = value ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Initialized_SetNull( )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLegajo_tipos_de_trabajo_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z( String value )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(0) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Modified = (short)(1) ;
      SetDirty("Legtipotra_Z");
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z = value ;
   }

   public void setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z_SetNull( )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z = "" ;
      SetDirty("Legtipotra_Z");
   }

   public boolean getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra = "" ;
      gxTv_SdtLegajo_tipos_de_trabajo_N = (byte)(1) ;
      gxTv_SdtLegajo_tipos_de_trabajo_Mode = "" ;
      gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtLegajo_tipos_de_trabajo_N ;
   }

   public web.SdtLegajo_tipos_de_trabajo Clone( )
   {
      return (web.SdtLegajo_tipos_de_trabajo)(clone()) ;
   }

   public void setStruct( web.StructSdtLegajo_tipos_de_trabajo struct )
   {
      setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra(struct.getLegtipotra());
      setgxTv_SdtLegajo_tipos_de_trabajo_Mode(struct.getMode());
      setgxTv_SdtLegajo_tipos_de_trabajo_Modified(struct.getModified());
      setgxTv_SdtLegajo_tipos_de_trabajo_Initialized(struct.getInitialized());
      setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z(struct.getLegtipotra_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLegajo_tipos_de_trabajo getStruct( )
   {
      web.StructSdtLegajo_tipos_de_trabajo struct = new web.StructSdtLegajo_tipos_de_trabajo ();
      struct.setLegtipotra(getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra());
      struct.setMode(getgxTv_SdtLegajo_tipos_de_trabajo_Mode());
      struct.setModified(getgxTv_SdtLegajo_tipos_de_trabajo_Modified());
      struct.setInitialized(getgxTv_SdtLegajo_tipos_de_trabajo_Initialized());
      struct.setLegtipotra_Z(getgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z());
      return struct ;
   }

   private byte gxTv_SdtLegajo_tipos_de_trabajo_N ;
   private short gxTv_SdtLegajo_tipos_de_trabajo_Modified ;
   private short gxTv_SdtLegajo_tipos_de_trabajo_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra ;
   private String gxTv_SdtLegajo_tipos_de_trabajo_Mode ;
   private String gxTv_SdtLegajo_tipos_de_trabajo_Legtipotra_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

