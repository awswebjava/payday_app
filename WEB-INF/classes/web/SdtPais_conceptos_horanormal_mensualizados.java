package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_conceptos_horanormal_mensualizados extends GxSilentTrnSdt
{
   public SdtPais_conceptos_horanormal_mensualizados( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_conceptos_horanormal_mensualizados.class));
   }

   public SdtPais_conceptos_horanormal_mensualizados( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_conceptos_horanormal_mensualizados");
      initialize( remoteHandle) ;
   }

   public SdtPais_conceptos_horanormal_mensualizados( int remoteHandle ,
                                                      StructSdtPais_conceptos_horanormal_mensualizados struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_conceptos_horanormal_mensualizados( )
   {
      super( new ModelContext(SdtPais_conceptos_horanormal_mensualizados.class), "SdtPais_conceptos_horanormal_mensualizados");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiMenCliCod", int.class}, new Object[]{"PaiMesConCodigo", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "conceptos_horanormal_mensualizados");
      metadata.set("BT", "Paisconceptos_horanormal_mensualizados");
      metadata.set("PK", "[ \"PaiMenCliCod\",\"PaiMesConCodigo\" ]");
      metadata.set("PKAssigned", "[ \"PaiMenCliCod\",\"PaiMesConCodigo\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[ \"PaiMenCliCod-CliCod\",\"PaiMesConCodigo-ConCodigo\" ] },{ \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMenCliCod") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMesConCodigo") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMesHabitual") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMenCliCod_Z") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMesConCodigo_Z") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiMesHabitual_Z") )
            {
               gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "Pais.conceptos_horanormal_mensualizados" ;
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
      oWriter.writeElement("PaiMenCliCod", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiMesConCodigo", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiMesHabitual", GXutil.booltostr( gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiMenCliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiMesConCodigo_Z", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiMesHabitual_Z", GXutil.booltostr( gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z));
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
      AddObjectProperty("PaiMenCliCod", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod, false, includeNonInitialized);
      AddObjectProperty("PaiMesConCodigo", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo, false, includeNonInitialized);
      AddObjectProperty("PaiMesHabitual", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiMenCliCod_Z", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z, false, includeNonInitialized);
         AddObjectProperty("PaiMesConCodigo_Z", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("PaiMesHabitual_Z", gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_conceptos_horanormal_mensualizados sdt )
   {
      if ( sdt.IsDirty("PaiMenCliCod") )
      {
         gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod = sdt.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod() ;
      }
      if ( sdt.IsDirty("PaiMesConCodigo") )
      {
         gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo = sdt.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo() ;
      }
      if ( sdt.IsDirty("PaiMesHabitual") )
      {
         gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
         gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual = sdt.getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual() ;
      }
   }

   public int getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paimenclicod");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod = value ;
   }

   public String getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paimesconcodigo");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo = value ;
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paimeshabitual");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual = value ;
   }

   public String getgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized( short value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z( int value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paimenclicod_Z");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z = 0 ;
      SetDirty("Paimenclicod_Z");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z( String value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paimesconcodigo_Z");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z = "" ;
      SetDirty("Paimesconcodigo_Z");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z( boolean value )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(0) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified = (short)(1) ;
      SetDirty("Paimeshabitual_Z");
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z = value ;
   }

   public void setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z_SetNull( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z = false ;
      SetDirty("Paimeshabitual_Z");
   }

   public boolean getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_conceptos_horanormal_mensualizados_N = (byte)(1) ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo = "" ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode = "" ;
      gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_conceptos_horanormal_mensualizados_N ;
   }

   public web.SdtPais_conceptos_horanormal_mensualizados Clone( )
   {
      return (web.SdtPais_conceptos_horanormal_mensualizados)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_conceptos_horanormal_mensualizados struct )
   {
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod(struct.getPaimenclicod());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo(struct.getPaimesconcodigo());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual(struct.getPaimeshabitual());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode(struct.getMode());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified(struct.getModified());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized(struct.getInitialized());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z(struct.getPaimenclicod_Z());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z(struct.getPaimesconcodigo_Z());
      setgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z(struct.getPaimeshabitual_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_conceptos_horanormal_mensualizados getStruct( )
   {
      web.StructSdtPais_conceptos_horanormal_mensualizados struct = new web.StructSdtPais_conceptos_horanormal_mensualizados ();
      struct.setPaimenclicod(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod());
      struct.setPaimesconcodigo(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo());
      struct.setPaimeshabitual(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual());
      struct.setMode(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Mode());
      struct.setModified(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Modified());
      struct.setInitialized(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized());
      struct.setPaimenclicod_Z(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z());
      struct.setPaimesconcodigo_Z(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z());
      struct.setPaimeshabitual_Z(getgxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_conceptos_horanormal_mensualizados_N ;
   private short gxTv_SdtPais_conceptos_horanormal_mensualizados_Modified ;
   private short gxTv_SdtPais_conceptos_horanormal_mensualizados_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod ;
   private int gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimenclicod_Z ;
   private String gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo ;
   private String gxTv_SdtPais_conceptos_horanormal_mensualizados_Mode ;
   private String gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimesconcodigo_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual ;
   private boolean gxTv_SdtPais_conceptos_horanormal_mensualizados_Paimeshabitual_Z ;
   private boolean readElement ;
   private boolean formatError ;
}

