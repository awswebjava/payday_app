package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1_promedio_horanormal_mensualizados extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1_promedio_horanormal_mensualizados( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1_promedio_horanormal_mensualizados.class));
   }

   public SdtEmpresa_abm_1_promedio_horanormal_mensualizados( int remoteHandle ,
                                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1_promedio_horanormal_mensualizados");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1_promedio_horanormal_mensualizados( int remoteHandle ,
                                                              StructSdtEmpresa_abm_1_promedio_horanormal_mensualizados struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_abm_1_promedio_horanormal_mensualizados( )
   {
      super( new ModelContext(SdtEmpresa_abm_1_promedio_horanormal_mensualizados.class), "SdtEmpresa_abm_1_promedio_horanormal_mensualizados");
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
      return (Object[][])(new Object[][]{new Object[]{"TipoConCod", String.class}, new Object[]{"EmpPromFijVar", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "promedio_horanormal_mensualizados");
      metadata.set("BT", "Empresapromedio_horanormal_mensualizados");
      metadata.set("PK", "[ \"TipoConCod\",\"EmpPromFijVar\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoConCod\" ],\"FKMap\":[  ] } ]");
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
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPromFijVar") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPromHabitual") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoConCod_Z") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPromFijVar_Z") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpPromHabitual_Z") )
            {
               gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Empresa_abm_1.promedio_horanormal_mensualizados" ;
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
      oWriter.writeElement("TipoConCod", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpPromFijVar", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpPromHabitual", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TipoConCod_Z", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpPromFijVar_Z", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpPromHabitual_Z", GXutil.booltostr( gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z));
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
      AddObjectProperty("TipoConCod", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod, false, includeNonInitialized);
      AddObjectProperty("EmpPromFijVar", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar, false, includeNonInitialized);
      AddObjectProperty("EmpPromHabitual", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized, false, includeNonInitialized);
         AddObjectProperty("TipoConCod_Z", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpPromFijVar_Z", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z, false, includeNonInitialized);
         AddObjectProperty("EmpPromHabitual_Z", gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados sdt )
   {
      if ( sdt.IsDirty("TipoConCod") )
      {
         gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod = sdt.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod() ;
      }
      if ( sdt.IsDirty("EmpPromFijVar") )
      {
         gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar = sdt.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar() ;
      }
      if ( sdt.IsDirty("EmpPromHabitual") )
      {
         gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual = sdt.getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual() ;
      }
   }

   public String getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod( String value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Tipoconcod");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar( String value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Emppromfijvar");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar = value ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Emppromhabitual");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified( short value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Tipoconcod_Z");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z = "" ;
      SetDirty("Tipoconcod_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Emppromfijvar_Z");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z = "" ;
      SetDirty("Emppromfijvar_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z( boolean value )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Emppromhabitual_Z");
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z = false ;
      SetDirty("Emppromhabitual_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod = "" ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar = "" ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z = "" ;
      gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N ;
   }

   public web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados Clone( )
   {
      return (web.SdtEmpresa_abm_1_promedio_horanormal_mensualizados)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1_promedio_horanormal_mensualizados struct )
   {
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod(struct.getTipoconcod());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar(struct.getEmppromfijvar());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual(struct.getEmppromhabitual());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified(struct.getModified());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z(struct.getTipoconcod_Z());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z(struct.getEmppromfijvar_Z());
      setgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z(struct.getEmppromhabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1_promedio_horanormal_mensualizados getStruct( )
   {
      web.StructSdtEmpresa_abm_1_promedio_horanormal_mensualizados struct = new web.StructSdtEmpresa_abm_1_promedio_horanormal_mensualizados ();
      struct.setTipoconcod(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod());
      struct.setEmppromfijvar(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar());
      struct.setEmppromhabitual(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode());
      struct.setModified(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized());
      struct.setTipoconcod_Z(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z());
      struct.setEmppromfijvar_Z(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z());
      struct.setEmppromhabitual_Z(getgxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_N ;
   private short gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Modified ;
   private short gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod ;
   private String gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar ;
   private String gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Mode ;
   private String gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Tipoconcod_Z ;
   private String gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromfijvar_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual ;
   private boolean gxTv_SdtEmpresa_abm_1_promedio_horanormal_mensualizados_Emppromhabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

