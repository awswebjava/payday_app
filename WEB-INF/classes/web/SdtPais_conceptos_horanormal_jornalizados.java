package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_conceptos_horanormal_jornalizados extends GxSilentTrnSdt
{
   public SdtPais_conceptos_horanormal_jornalizados( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_conceptos_horanormal_jornalizados.class));
   }

   public SdtPais_conceptos_horanormal_jornalizados( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_conceptos_horanormal_jornalizados");
      initialize( remoteHandle) ;
   }

   public SdtPais_conceptos_horanormal_jornalizados( int remoteHandle ,
                                                     StructSdtPais_conceptos_horanormal_jornalizados struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_conceptos_horanormal_jornalizados( )
   {
      super( new ModelContext(SdtPais_conceptos_horanormal_jornalizados.class), "SdtPais_conceptos_horanormal_jornalizados");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiJorCliCod", int.class}, new Object[]{"PaiJorConCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "conceptos_horanormal_jornalizados");
      metadata.set("BT", "Paisconceptos_horanormal_jornalizados");
      metadata.set("PK", "[ \"PaiJorCliCod\",\"PaiJorConCodigo\" ]");
      metadata.set("PKAssigned", "[ \"PaiJorCliCod\",\"PaiJorConCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"PaiJorCliCod-CliCod\",\"PaiJorConCodigo-ConCodigo\" ] },{ \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiJorCliCod") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiJorConCodigo") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiJorHabitual") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiJorCliCod_Z") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiJorConCodigo_Z") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiJorHabitual_Z") )
            {
               gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Pais.conceptos_horanormal_jornalizados" ;
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
      oWriter.writeElement("PaiJorCliCod", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiJorConCodigo", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiJorHabitual", GXutil.booltostr( gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiJorCliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiJorConCodigo_Z", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiJorHabitual_Z", GXutil.booltostr( gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z));
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
      AddObjectProperty("PaiJorCliCod", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod, false, includeNonInitialized);
      AddObjectProperty("PaiJorConCodigo", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo, false, includeNonInitialized);
      AddObjectProperty("PaiJorHabitual", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiJorCliCod_Z", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiJorConCodigo_Z", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("PaiJorHabitual_Z", gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_conceptos_horanormal_jornalizados sdt )
   {
      if ( sdt.IsDirty("PaiJorCliCod") )
      {
         gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
         gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod = sdt.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod() ;
      }
      if ( sdt.IsDirty("PaiJorConCodigo") )
      {
         gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
         gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo = sdt.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo() ;
      }
      if ( sdt.IsDirty("PaiJorHabitual") )
      {
         gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
         gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual = sdt.getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual() ;
      }
   }

   public int getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Paijorclicod");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod = value ;
   }

   public String getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Paijorconcodigo");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo = value ;
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Paijorhabitual");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual = value ;
   }

   public String getgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Paijorclicod_Z");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z = 0 ;
      SetDirty("Paijorclicod_Z");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Paijorconcodigo_Z");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z = "" ;
      SetDirty("Paijorconcodigo_Z");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified = (short)(1) ;
      SetDirty("Paijorhabitual_Z");
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z = false ;
      SetDirty("Paijorhabitual_Z");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_conceptos_horanormal_jornalizados_N = (byte)(1) ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo = "" ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode = "" ;
      gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_conceptos_horanormal_jornalizados_N ;
   }

   public web.SdtPais_conceptos_horanormal_jornalizados Clone( )
   {
      return (web.SdtPais_conceptos_horanormal_jornalizados)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_conceptos_horanormal_jornalizados struct )
   {
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod(struct.getPaijorclicod());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo(struct.getPaijorconcodigo());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual(struct.getPaijorhabitual());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode(struct.getMode());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified(struct.getModified());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized(struct.getInitialized());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z(struct.getPaijorclicod_Z());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z(struct.getPaijorconcodigo_Z());
      setgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z(struct.getPaijorhabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_conceptos_horanormal_jornalizados getStruct( )
   {
      web.StructSdtPais_conceptos_horanormal_jornalizados struct = new web.StructSdtPais_conceptos_horanormal_jornalizados ();
      struct.setPaijorclicod(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod());
      struct.setPaijorconcodigo(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo());
      struct.setPaijorhabitual(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual());
      struct.setMode(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Mode());
      struct.setModified(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Modified());
      struct.setInitialized(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized());
      struct.setPaijorclicod_Z(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z());
      struct.setPaijorconcodigo_Z(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z());
      struct.setPaijorhabitual_Z(getgxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_conceptos_horanormal_jornalizados_N ;
   private short gxTv_SdtPais_conceptos_horanormal_jornalizados_Modified ;
   private short gxTv_SdtPais_conceptos_horanormal_jornalizados_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod ;
   private int gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorclicod_Z ;
   private String gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo ;
   private String gxTv_SdtPais_conceptos_horanormal_jornalizados_Mode ;
   private String gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorconcodigo_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual ;
   private boolean gxTv_SdtPais_conceptos_horanormal_jornalizados_Paijorhabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

