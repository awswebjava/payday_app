package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEscolaridad extends GxSilentTrnSdt
{
   public SdtEscolaridad( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEscolaridad.class));
   }

   public SdtEscolaridad( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtEscolaridad");
      initialize( remoteHandle) ;
   }

   public SdtEscolaridad( int remoteHandle ,
                          StructSdtEscolaridad struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     String AV49EscCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV49EscCod});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EscCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Escolaridad");
      metadata.set("BT", "Escolaridad");
      metadata.set("PK", "[ \"CliCod\",\"EscCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtEscolaridad_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscCod") )
            {
               gxTv_SdtEscolaridad_Esccod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscDescrip") )
            {
               gxTv_SdtEscolaridad_Escdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscHabilitada") )
            {
               gxTv_SdtEscolaridad_Eschabilitada = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscRes551") )
            {
               gxTv_SdtEscolaridad_Escres551 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEscolaridad_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEscolaridad_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtEscolaridad_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscCod_Z") )
            {
               gxTv_SdtEscolaridad_Esccod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscDescrip_Z") )
            {
               gxTv_SdtEscolaridad_Escdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscHabilitada_Z") )
            {
               gxTv_SdtEscolaridad_Eschabilitada_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EscRes551_Z") )
            {
               gxTv_SdtEscolaridad_Escres551_Z = oReader.getValue() ;
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
         sName = "Escolaridad" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtEscolaridad_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscCod", gxTv_SdtEscolaridad_Esccod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscDescrip", gxTv_SdtEscolaridad_Escdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscHabilitada", GXutil.booltostr( gxTv_SdtEscolaridad_Eschabilitada));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EscRes551", gxTv_SdtEscolaridad_Escres551);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEscolaridad_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEscolaridad_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtEscolaridad_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EscCod_Z", gxTv_SdtEscolaridad_Esccod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EscDescrip_Z", gxTv_SdtEscolaridad_Escdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EscHabilitada_Z", GXutil.booltostr( gxTv_SdtEscolaridad_Eschabilitada_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EscRes551_Z", gxTv_SdtEscolaridad_Escres551_Z);
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
      AddObjectProperty("CliCod", gxTv_SdtEscolaridad_Clicod, false, includeNonInitialized);
      AddObjectProperty("EscCod", gxTv_SdtEscolaridad_Esccod, false, includeNonInitialized);
      AddObjectProperty("EscDescrip", gxTv_SdtEscolaridad_Escdescrip, false, includeNonInitialized);
      AddObjectProperty("EscHabilitada", gxTv_SdtEscolaridad_Eschabilitada, false, includeNonInitialized);
      AddObjectProperty("EscRes551", gxTv_SdtEscolaridad_Escres551, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEscolaridad_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEscolaridad_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtEscolaridad_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EscCod_Z", gxTv_SdtEscolaridad_Esccod_Z, false, includeNonInitialized);
         AddObjectProperty("EscDescrip_Z", gxTv_SdtEscolaridad_Escdescrip_Z, false, includeNonInitialized);
         AddObjectProperty("EscHabilitada_Z", gxTv_SdtEscolaridad_Eschabilitada_Z, false, includeNonInitialized);
         AddObjectProperty("EscRes551_Z", gxTv_SdtEscolaridad_Escres551_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEscolaridad sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtEscolaridad_N = (byte)(0) ;
         gxTv_SdtEscolaridad_Clicod = sdt.getgxTv_SdtEscolaridad_Clicod() ;
      }
      if ( sdt.IsDirty("EscCod") )
      {
         gxTv_SdtEscolaridad_N = (byte)(0) ;
         gxTv_SdtEscolaridad_Esccod = sdt.getgxTv_SdtEscolaridad_Esccod() ;
      }
      if ( sdt.IsDirty("EscDescrip") )
      {
         gxTv_SdtEscolaridad_N = (byte)(0) ;
         gxTv_SdtEscolaridad_Escdescrip = sdt.getgxTv_SdtEscolaridad_Escdescrip() ;
      }
      if ( sdt.IsDirty("EscHabilitada") )
      {
         gxTv_SdtEscolaridad_N = (byte)(0) ;
         gxTv_SdtEscolaridad_Eschabilitada = sdt.getgxTv_SdtEscolaridad_Eschabilitada() ;
      }
      if ( sdt.IsDirty("EscRes551") )
      {
         gxTv_SdtEscolaridad_N = (byte)(0) ;
         gxTv_SdtEscolaridad_Escres551 = sdt.getgxTv_SdtEscolaridad_Escres551() ;
      }
   }

   public int getgxTv_SdtEscolaridad_Clicod( )
   {
      return gxTv_SdtEscolaridad_Clicod ;
   }

   public void setgxTv_SdtEscolaridad_Clicod( int value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      if ( gxTv_SdtEscolaridad_Clicod != value )
      {
         gxTv_SdtEscolaridad_Mode = "INS" ;
         this.setgxTv_SdtEscolaridad_Clicod_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Esccod_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Escdescrip_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Eschabilitada_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Escres551_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtEscolaridad_Clicod = value ;
   }

   public String getgxTv_SdtEscolaridad_Esccod( )
   {
      return gxTv_SdtEscolaridad_Esccod ;
   }

   public void setgxTv_SdtEscolaridad_Esccod( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtEscolaridad_Esccod, value) != 0 )
      {
         gxTv_SdtEscolaridad_Mode = "INS" ;
         this.setgxTv_SdtEscolaridad_Clicod_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Esccod_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Escdescrip_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Eschabilitada_Z_SetNull( );
         this.setgxTv_SdtEscolaridad_Escres551_Z_SetNull( );
      }
      SetDirty("Esccod");
      gxTv_SdtEscolaridad_Esccod = value ;
   }

   public String getgxTv_SdtEscolaridad_Escdescrip( )
   {
      return gxTv_SdtEscolaridad_Escdescrip ;
   }

   public void setgxTv_SdtEscolaridad_Escdescrip( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Escdescrip");
      gxTv_SdtEscolaridad_Escdescrip = value ;
   }

   public boolean getgxTv_SdtEscolaridad_Eschabilitada( )
   {
      return gxTv_SdtEscolaridad_Eschabilitada ;
   }

   public void setgxTv_SdtEscolaridad_Eschabilitada( boolean value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Eschabilitada");
      gxTv_SdtEscolaridad_Eschabilitada = value ;
   }

   public String getgxTv_SdtEscolaridad_Escres551( )
   {
      return gxTv_SdtEscolaridad_Escres551 ;
   }

   public void setgxTv_SdtEscolaridad_Escres551( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Escres551");
      gxTv_SdtEscolaridad_Escres551 = value ;
   }

   public String getgxTv_SdtEscolaridad_Mode( )
   {
      return gxTv_SdtEscolaridad_Mode ;
   }

   public void setgxTv_SdtEscolaridad_Mode( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEscolaridad_Mode = value ;
   }

   public void setgxTv_SdtEscolaridad_Mode_SetNull( )
   {
      gxTv_SdtEscolaridad_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEscolaridad_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEscolaridad_Initialized( )
   {
      return gxTv_SdtEscolaridad_Initialized ;
   }

   public void setgxTv_SdtEscolaridad_Initialized( short value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtEscolaridad_Initialized = value ;
   }

   public void setgxTv_SdtEscolaridad_Initialized_SetNull( )
   {
      gxTv_SdtEscolaridad_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEscolaridad_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtEscolaridad_Clicod_Z( )
   {
      return gxTv_SdtEscolaridad_Clicod_Z ;
   }

   public void setgxTv_SdtEscolaridad_Clicod_Z( int value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtEscolaridad_Clicod_Z = value ;
   }

   public void setgxTv_SdtEscolaridad_Clicod_Z_SetNull( )
   {
      gxTv_SdtEscolaridad_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtEscolaridad_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEscolaridad_Esccod_Z( )
   {
      return gxTv_SdtEscolaridad_Esccod_Z ;
   }

   public void setgxTv_SdtEscolaridad_Esccod_Z( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Esccod_Z");
      gxTv_SdtEscolaridad_Esccod_Z = value ;
   }

   public void setgxTv_SdtEscolaridad_Esccod_Z_SetNull( )
   {
      gxTv_SdtEscolaridad_Esccod_Z = "" ;
      SetDirty("Esccod_Z");
   }

   public boolean getgxTv_SdtEscolaridad_Esccod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEscolaridad_Escdescrip_Z( )
   {
      return gxTv_SdtEscolaridad_Escdescrip_Z ;
   }

   public void setgxTv_SdtEscolaridad_Escdescrip_Z( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Escdescrip_Z");
      gxTv_SdtEscolaridad_Escdescrip_Z = value ;
   }

   public void setgxTv_SdtEscolaridad_Escdescrip_Z_SetNull( )
   {
      gxTv_SdtEscolaridad_Escdescrip_Z = "" ;
      SetDirty("Escdescrip_Z");
   }

   public boolean getgxTv_SdtEscolaridad_Escdescrip_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtEscolaridad_Eschabilitada_Z( )
   {
      return gxTv_SdtEscolaridad_Eschabilitada_Z ;
   }

   public void setgxTv_SdtEscolaridad_Eschabilitada_Z( boolean value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Eschabilitada_Z");
      gxTv_SdtEscolaridad_Eschabilitada_Z = value ;
   }

   public void setgxTv_SdtEscolaridad_Eschabilitada_Z_SetNull( )
   {
      gxTv_SdtEscolaridad_Eschabilitada_Z = false ;
      SetDirty("Eschabilitada_Z");
   }

   public boolean getgxTv_SdtEscolaridad_Eschabilitada_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEscolaridad_Escres551_Z( )
   {
      return gxTv_SdtEscolaridad_Escres551_Z ;
   }

   public void setgxTv_SdtEscolaridad_Escres551_Z( String value )
   {
      gxTv_SdtEscolaridad_N = (byte)(0) ;
      SetDirty("Escres551_Z");
      gxTv_SdtEscolaridad_Escres551_Z = value ;
   }

   public void setgxTv_SdtEscolaridad_Escres551_Z_SetNull( )
   {
      gxTv_SdtEscolaridad_Escres551_Z = "" ;
      SetDirty("Escres551_Z");
   }

   public boolean getgxTv_SdtEscolaridad_Escres551_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.escolaridad_bc obj;
      obj = new web.escolaridad_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtEscolaridad_N = (byte)(1) ;
      gxTv_SdtEscolaridad_Esccod = "" ;
      gxTv_SdtEscolaridad_Escdescrip = "" ;
      gxTv_SdtEscolaridad_Escres551 = "" ;
      gxTv_SdtEscolaridad_Mode = "" ;
      gxTv_SdtEscolaridad_Esccod_Z = "" ;
      gxTv_SdtEscolaridad_Escdescrip_Z = "" ;
      gxTv_SdtEscolaridad_Escres551_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEscolaridad_N ;
   }

   public web.SdtEscolaridad Clone( )
   {
      web.SdtEscolaridad sdt;
      web.escolaridad_bc obj;
      sdt = (web.SdtEscolaridad)(clone()) ;
      obj = (web.escolaridad_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtEscolaridad struct )
   {
      setgxTv_SdtEscolaridad_Clicod(struct.getClicod());
      setgxTv_SdtEscolaridad_Esccod(struct.getEsccod());
      setgxTv_SdtEscolaridad_Escdescrip(struct.getEscdescrip());
      setgxTv_SdtEscolaridad_Eschabilitada(struct.getEschabilitada());
      setgxTv_SdtEscolaridad_Escres551(struct.getEscres551());
      setgxTv_SdtEscolaridad_Mode(struct.getMode());
      setgxTv_SdtEscolaridad_Initialized(struct.getInitialized());
      setgxTv_SdtEscolaridad_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtEscolaridad_Esccod_Z(struct.getEsccod_Z());
      setgxTv_SdtEscolaridad_Escdescrip_Z(struct.getEscdescrip_Z());
      setgxTv_SdtEscolaridad_Eschabilitada_Z(struct.getEschabilitada_Z());
      setgxTv_SdtEscolaridad_Escres551_Z(struct.getEscres551_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEscolaridad getStruct( )
   {
      web.StructSdtEscolaridad struct = new web.StructSdtEscolaridad ();
      struct.setClicod(getgxTv_SdtEscolaridad_Clicod());
      struct.setEsccod(getgxTv_SdtEscolaridad_Esccod());
      struct.setEscdescrip(getgxTv_SdtEscolaridad_Escdescrip());
      struct.setEschabilitada(getgxTv_SdtEscolaridad_Eschabilitada());
      struct.setEscres551(getgxTv_SdtEscolaridad_Escres551());
      struct.setMode(getgxTv_SdtEscolaridad_Mode());
      struct.setInitialized(getgxTv_SdtEscolaridad_Initialized());
      struct.setClicod_Z(getgxTv_SdtEscolaridad_Clicod_Z());
      struct.setEsccod_Z(getgxTv_SdtEscolaridad_Esccod_Z());
      struct.setEscdescrip_Z(getgxTv_SdtEscolaridad_Escdescrip_Z());
      struct.setEschabilitada_Z(getgxTv_SdtEscolaridad_Eschabilitada_Z());
      struct.setEscres551_Z(getgxTv_SdtEscolaridad_Escres551_Z());
      return struct ;
   }

   private byte gxTv_SdtEscolaridad_N ;
   private short gxTv_SdtEscolaridad_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtEscolaridad_Clicod ;
   private int gxTv_SdtEscolaridad_Clicod_Z ;
   private String gxTv_SdtEscolaridad_Esccod ;
   private String gxTv_SdtEscolaridad_Mode ;
   private String gxTv_SdtEscolaridad_Esccod_Z ;
   private String sTagName ;
   private boolean gxTv_SdtEscolaridad_Eschabilitada ;
   private boolean gxTv_SdtEscolaridad_Eschabilitada_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtEscolaridad_Escdescrip ;
   private String gxTv_SdtEscolaridad_Escres551 ;
   private String gxTv_SdtEscolaridad_Escdescrip_Z ;
   private String gxTv_SdtEscolaridad_Escres551_Z ;
}

