package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1_conceptos_horanormal_jornalizados extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1_conceptos_horanormal_jornalizados( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1_conceptos_horanormal_jornalizados.class));
   }

   public SdtEmpresa_abm_1_conceptos_horanormal_jornalizados( int remoteHandle ,
                                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1_conceptos_horanormal_jornalizados");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1_conceptos_horanormal_jornalizados( int remoteHandle ,
                                                              StructSdtEmpresa_abm_1_conceptos_horanormal_jornalizados struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_abm_1_conceptos_horanormal_jornalizados( )
   {
      super( new ModelContext(SdtEmpresa_abm_1_conceptos_horanormal_jornalizados.class), "SdtEmpresa_abm_1_conceptos_horanormal_jornalizados");
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
      return (Object[][])(new Object[][]{new Object[]{"EmpJorConCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "conceptos_horanormal_jornalizados");
      metadata.set("BT", "Empresaconceptos_horanormal_jornalizados");
      metadata.set("PK", "[ \"EmpJorConCodigo\" ]");
      metadata.set("PKAssigned", "[ \"EmpJorConCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"EmpJorConCodigo-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpJorConCodigo") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpJorHabitual") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpJorConCodigo_Z") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpJorHabitual_Z") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Empresa_abm_1.conceptos_horanormal_jornalizados" ;
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
      oWriter.writeElement("EmpJorConCodigo", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpJorHabitual", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpJorConCodigo_Z", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpJorHabitual_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z));
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
      AddObjectProperty("EmpJorConCodigo", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo, false, includeNonInitialized);
      AddObjectProperty("EmpJorHabitual", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpJorConCodigo_Z", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("EmpJorHabitual_Z", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados sdt )
   {
      if ( sdt.IsDirty("EmpJorConCodigo") )
      {
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo = sdt.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo() ;
      }
      if ( sdt.IsDirty("EmpJorHabitual") )
      {
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual = sdt.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual() ;
      }
   }

   public String getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo( String value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Empjorconcodigo");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Empjorhabitual");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified( short value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Empjorconcodigo_Z");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z = "" ;
      SetDirty("Empjorconcodigo_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Empjorhabitual_Z");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z = false ;
      SetDirty("Empjorhabitual_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo = "" ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N ;
   }

   public web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados Clone( )
   {
      return (web.SdtEmpresa_abm_1_conceptos_horanormal_jornalizados)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1_conceptos_horanormal_jornalizados struct )
   {
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo(struct.getEmpjorconcodigo());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual(struct.getEmpjorhabitual());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified(struct.getModified());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z(struct.getEmpjorconcodigo_Z());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z(struct.getEmpjorhabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1_conceptos_horanormal_jornalizados getStruct( )
   {
      web.StructSdtEmpresa_abm_1_conceptos_horanormal_jornalizados struct = new web.StructSdtEmpresa_abm_1_conceptos_horanormal_jornalizados ();
      struct.setEmpjorconcodigo(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo());
      struct.setEmpjorhabitual(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode());
      struct.setModified(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized());
      struct.setEmpjorconcodigo_Z(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z());
      struct.setEmpjorhabitual_Z(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_N ;
   private short gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Modified ;
   private short gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo ;
   private String gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Mode ;
   private String gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorconcodigo_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual ;
   private boolean gxTv_SdtEmpresa_abm_1_conceptos_horanormal_jornalizados_Empjorhabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

