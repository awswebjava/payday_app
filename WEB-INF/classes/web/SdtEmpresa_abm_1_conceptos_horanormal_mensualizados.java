package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1_conceptos_horanormal_mensualizados extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1_conceptos_horanormal_mensualizados( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1_conceptos_horanormal_mensualizados.class));
   }

   public SdtEmpresa_abm_1_conceptos_horanormal_mensualizados( int remoteHandle ,
                                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1_conceptos_horanormal_mensualizados");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1_conceptos_horanormal_mensualizados( int remoteHandle ,
                                                               StructSdtEmpresa_abm_1_conceptos_horanormal_mensualizados struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_abm_1_conceptos_horanormal_mensualizados( )
   {
      super( new ModelContext(SdtEmpresa_abm_1_conceptos_horanormal_mensualizados.class), "SdtEmpresa_abm_1_conceptos_horanormal_mensualizados");
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
      return (Object[][])(new Object[][]{new Object[]{"EmpMenConCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "conceptos_horanormal_mensualizados");
      metadata.set("BT", "Empresaconceptos_horanormal_mensualizado");
      metadata.set("PK", "[ \"EmpMenConCodigo\" ]");
      metadata.set("PKAssigned", "[ \"EmpMenConCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"EmpMenConCodigo-ConCodigo\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMenConCodigo") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMenHabitual") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMenConCodigo_Z") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpMenHabitual_Z") )
            {
               gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Empresa_abm_1.conceptos_horanormal_mensualizados" ;
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
      oWriter.writeElement("EmpMenConCodigo", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpMenHabitual", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpMenConCodigo_Z", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpMenHabitual_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z));
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
      AddObjectProperty("EmpMenConCodigo", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo, false, includeNonInitialized);
      AddObjectProperty("EmpMenHabitual", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpMenConCodigo_Z", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("EmpMenHabitual_Z", gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados sdt )
   {
      if ( sdt.IsDirty("EmpMenConCodigo") )
      {
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo = sdt.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo() ;
      }
      if ( sdt.IsDirty("EmpMenHabitual") )
      {
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual = sdt.getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual() ;
      }
   }

   public String getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo( String value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Empmenconcodigo");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Empmenhabitual");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified( short value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Empmenconcodigo_Z");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z = "" ;
      SetDirty("Empmenconcodigo_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Empmenhabitual_Z");
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z = false ;
      SetDirty("Empmenhabitual_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo = "" ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N ;
   }

   public web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados Clone( )
   {
      return (web.SdtEmpresa_abm_1_conceptos_horanormal_mensualizados)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1_conceptos_horanormal_mensualizados struct )
   {
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo(struct.getEmpmenconcodigo());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual(struct.getEmpmenhabitual());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified(struct.getModified());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z(struct.getEmpmenconcodigo_Z());
      setgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z(struct.getEmpmenhabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1_conceptos_horanormal_mensualizados getStruct( )
   {
      web.StructSdtEmpresa_abm_1_conceptos_horanormal_mensualizados struct = new web.StructSdtEmpresa_abm_1_conceptos_horanormal_mensualizados ();
      struct.setEmpmenconcodigo(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo());
      struct.setEmpmenhabitual(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode());
      struct.setModified(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized());
      struct.setEmpmenconcodigo_Z(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z());
      struct.setEmpmenhabitual_Z(getgxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_N ;
   private short gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Modified ;
   private short gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo ;
   private String gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Mode ;
   private String gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenconcodigo_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual ;
   private boolean gxTv_SdtEmpresa_abm_1_conceptos_horanormal_mensualizados_Empmenhabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

