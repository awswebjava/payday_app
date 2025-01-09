package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtParentesco extends GxSilentTrnSdt
{
   public SdtParentesco( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtParentesco.class));
   }

   public SdtParentesco( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtParentesco");
      initialize( remoteHandle) ;
   }

   public SdtParentesco( int remoteHandle ,
                         StructSdtParentesco struct )
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
                     String AV30ParCod )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),AV30ParCod});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"ParCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Parentesco");
      metadata.set("BT", "Parentesco");
      metadata.set("PK", "[ \"CliCod\",\"ParCod\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
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
               gxTv_SdtParentesco_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod") )
            {
               gxTv_SdtParentesco_Parcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParDescrip") )
            {
               gxTv_SdtParentesco_Pardescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParRes551") )
            {
               gxTv_SdtParentesco_Parres551 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParHabilitado") )
            {
               gxTv_SdtParentesco_Parhabilitado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParDescripSinAc") )
            {
               gxTv_SdtParentesco_Pardescripsinac = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParenTipo") )
            {
               gxTv_SdtParentesco_Parentipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtParentesco_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtParentesco_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtParentesco_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParCod_Z") )
            {
               gxTv_SdtParentesco_Parcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParDescrip_Z") )
            {
               gxTv_SdtParentesco_Pardescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParRes551_Z") )
            {
               gxTv_SdtParentesco_Parres551_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParHabilitado_Z") )
            {
               gxTv_SdtParentesco_Parhabilitado_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParDescripSinAc_Z") )
            {
               gxTv_SdtParentesco_Pardescripsinac_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ParenTipo_Z") )
            {
               gxTv_SdtParentesco_Parentipo_Z = oReader.getValue() ;
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
         sName = "Parentesco" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtParentesco_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParCod", gxTv_SdtParentesco_Parcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParDescrip", gxTv_SdtParentesco_Pardescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParRes551", gxTv_SdtParentesco_Parres551);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParHabilitado", GXutil.booltostr( gxTv_SdtParentesco_Parhabilitado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParDescripSinAc", gxTv_SdtParentesco_Pardescripsinac);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ParenTipo", gxTv_SdtParentesco_Parentipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtParentesco_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtParentesco_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtParentesco_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParCod_Z", gxTv_SdtParentesco_Parcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParDescrip_Z", gxTv_SdtParentesco_Pardescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParRes551_Z", gxTv_SdtParentesco_Parres551_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParHabilitado_Z", GXutil.booltostr( gxTv_SdtParentesco_Parhabilitado_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParDescripSinAc_Z", gxTv_SdtParentesco_Pardescripsinac_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ParenTipo_Z", gxTv_SdtParentesco_Parentipo_Z);
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
      AddObjectProperty("CliCod", gxTv_SdtParentesco_Clicod, false, includeNonInitialized);
      AddObjectProperty("ParCod", gxTv_SdtParentesco_Parcod, false, includeNonInitialized);
      AddObjectProperty("ParDescrip", gxTv_SdtParentesco_Pardescrip, false, includeNonInitialized);
      AddObjectProperty("ParRes551", gxTv_SdtParentesco_Parres551, false, includeNonInitialized);
      AddObjectProperty("ParHabilitado", gxTv_SdtParentesco_Parhabilitado, false, includeNonInitialized);
      AddObjectProperty("ParDescripSinAc", gxTv_SdtParentesco_Pardescripsinac, false, includeNonInitialized);
      AddObjectProperty("ParenTipo", gxTv_SdtParentesco_Parentipo, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtParentesco_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtParentesco_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtParentesco_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("ParCod_Z", gxTv_SdtParentesco_Parcod_Z, false, includeNonInitialized);
         AddObjectProperty("ParDescrip_Z", gxTv_SdtParentesco_Pardescrip_Z, false, includeNonInitialized);
         AddObjectProperty("ParRes551_Z", gxTv_SdtParentesco_Parres551_Z, false, includeNonInitialized);
         AddObjectProperty("ParHabilitado_Z", gxTv_SdtParentesco_Parhabilitado_Z, false, includeNonInitialized);
         AddObjectProperty("ParDescripSinAc_Z", gxTv_SdtParentesco_Pardescripsinac_Z, false, includeNonInitialized);
         AddObjectProperty("ParenTipo_Z", gxTv_SdtParentesco_Parentipo_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtParentesco sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Clicod = sdt.getgxTv_SdtParentesco_Clicod() ;
      }
      if ( sdt.IsDirty("ParCod") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Parcod = sdt.getgxTv_SdtParentesco_Parcod() ;
      }
      if ( sdt.IsDirty("ParDescrip") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Pardescrip = sdt.getgxTv_SdtParentesco_Pardescrip() ;
      }
      if ( sdt.IsDirty("ParRes551") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Parres551 = sdt.getgxTv_SdtParentesco_Parres551() ;
      }
      if ( sdt.IsDirty("ParHabilitado") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Parhabilitado = sdt.getgxTv_SdtParentesco_Parhabilitado() ;
      }
      if ( sdt.IsDirty("ParDescripSinAc") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Pardescripsinac = sdt.getgxTv_SdtParentesco_Pardescripsinac() ;
      }
      if ( sdt.IsDirty("ParenTipo") )
      {
         gxTv_SdtParentesco_N = (byte)(0) ;
         gxTv_SdtParentesco_Parentipo = sdt.getgxTv_SdtParentesco_Parentipo() ;
      }
   }

   public int getgxTv_SdtParentesco_Clicod( )
   {
      return gxTv_SdtParentesco_Clicod ;
   }

   public void setgxTv_SdtParentesco_Clicod( int value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      if ( gxTv_SdtParentesco_Clicod != value )
      {
         gxTv_SdtParentesco_Mode = "INS" ;
         this.setgxTv_SdtParentesco_Clicod_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parcod_Z_SetNull( );
         this.setgxTv_SdtParentesco_Pardescrip_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parres551_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parhabilitado_Z_SetNull( );
         this.setgxTv_SdtParentesco_Pardescripsinac_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parentipo_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtParentesco_Clicod = value ;
   }

   public String getgxTv_SdtParentesco_Parcod( )
   {
      return gxTv_SdtParentesco_Parcod ;
   }

   public void setgxTv_SdtParentesco_Parcod( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtParentesco_Parcod, value) != 0 )
      {
         gxTv_SdtParentesco_Mode = "INS" ;
         this.setgxTv_SdtParentesco_Clicod_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parcod_Z_SetNull( );
         this.setgxTv_SdtParentesco_Pardescrip_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parres551_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parhabilitado_Z_SetNull( );
         this.setgxTv_SdtParentesco_Pardescripsinac_Z_SetNull( );
         this.setgxTv_SdtParentesco_Parentipo_Z_SetNull( );
      }
      SetDirty("Parcod");
      gxTv_SdtParentesco_Parcod = value ;
   }

   public String getgxTv_SdtParentesco_Pardescrip( )
   {
      return gxTv_SdtParentesco_Pardescrip ;
   }

   public void setgxTv_SdtParentesco_Pardescrip( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Pardescrip");
      gxTv_SdtParentesco_Pardescrip = value ;
   }

   public String getgxTv_SdtParentesco_Parres551( )
   {
      return gxTv_SdtParentesco_Parres551 ;
   }

   public void setgxTv_SdtParentesco_Parres551( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parres551");
      gxTv_SdtParentesco_Parres551 = value ;
   }

   public boolean getgxTv_SdtParentesco_Parhabilitado( )
   {
      return gxTv_SdtParentesco_Parhabilitado ;
   }

   public void setgxTv_SdtParentesco_Parhabilitado( boolean value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parhabilitado");
      gxTv_SdtParentesco_Parhabilitado = value ;
   }

   public String getgxTv_SdtParentesco_Pardescripsinac( )
   {
      return gxTv_SdtParentesco_Pardescripsinac ;
   }

   public void setgxTv_SdtParentesco_Pardescripsinac( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Pardescripsinac");
      gxTv_SdtParentesco_Pardescripsinac = value ;
   }

   public String getgxTv_SdtParentesco_Parentipo( )
   {
      return gxTv_SdtParentesco_Parentipo ;
   }

   public void setgxTv_SdtParentesco_Parentipo( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parentipo");
      gxTv_SdtParentesco_Parentipo = value ;
   }

   public String getgxTv_SdtParentesco_Mode( )
   {
      return gxTv_SdtParentesco_Mode ;
   }

   public void setgxTv_SdtParentesco_Mode( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtParentesco_Mode = value ;
   }

   public void setgxTv_SdtParentesco_Mode_SetNull( )
   {
      gxTv_SdtParentesco_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtParentesco_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtParentesco_Initialized( )
   {
      return gxTv_SdtParentesco_Initialized ;
   }

   public void setgxTv_SdtParentesco_Initialized( short value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtParentesco_Initialized = value ;
   }

   public void setgxTv_SdtParentesco_Initialized_SetNull( )
   {
      gxTv_SdtParentesco_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtParentesco_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtParentesco_Clicod_Z( )
   {
      return gxTv_SdtParentesco_Clicod_Z ;
   }

   public void setgxTv_SdtParentesco_Clicod_Z( int value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtParentesco_Clicod_Z = value ;
   }

   public void setgxTv_SdtParentesco_Clicod_Z_SetNull( )
   {
      gxTv_SdtParentesco_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtParentesco_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtParentesco_Parcod_Z( )
   {
      return gxTv_SdtParentesco_Parcod_Z ;
   }

   public void setgxTv_SdtParentesco_Parcod_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parcod_Z");
      gxTv_SdtParentesco_Parcod_Z = value ;
   }

   public void setgxTv_SdtParentesco_Parcod_Z_SetNull( )
   {
      gxTv_SdtParentesco_Parcod_Z = "" ;
      SetDirty("Parcod_Z");
   }

   public boolean getgxTv_SdtParentesco_Parcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtParentesco_Pardescrip_Z( )
   {
      return gxTv_SdtParentesco_Pardescrip_Z ;
   }

   public void setgxTv_SdtParentesco_Pardescrip_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Pardescrip_Z");
      gxTv_SdtParentesco_Pardescrip_Z = value ;
   }

   public void setgxTv_SdtParentesco_Pardescrip_Z_SetNull( )
   {
      gxTv_SdtParentesco_Pardescrip_Z = "" ;
      SetDirty("Pardescrip_Z");
   }

   public boolean getgxTv_SdtParentesco_Pardescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtParentesco_Parres551_Z( )
   {
      return gxTv_SdtParentesco_Parres551_Z ;
   }

   public void setgxTv_SdtParentesco_Parres551_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parres551_Z");
      gxTv_SdtParentesco_Parres551_Z = value ;
   }

   public void setgxTv_SdtParentesco_Parres551_Z_SetNull( )
   {
      gxTv_SdtParentesco_Parres551_Z = "" ;
      SetDirty("Parres551_Z");
   }

   public boolean getgxTv_SdtParentesco_Parres551_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtParentesco_Parhabilitado_Z( )
   {
      return gxTv_SdtParentesco_Parhabilitado_Z ;
   }

   public void setgxTv_SdtParentesco_Parhabilitado_Z( boolean value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parhabilitado_Z");
      gxTv_SdtParentesco_Parhabilitado_Z = value ;
   }

   public void setgxTv_SdtParentesco_Parhabilitado_Z_SetNull( )
   {
      gxTv_SdtParentesco_Parhabilitado_Z = false ;
      SetDirty("Parhabilitado_Z");
   }

   public boolean getgxTv_SdtParentesco_Parhabilitado_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtParentesco_Pardescripsinac_Z( )
   {
      return gxTv_SdtParentesco_Pardescripsinac_Z ;
   }

   public void setgxTv_SdtParentesco_Pardescripsinac_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Pardescripsinac_Z");
      gxTv_SdtParentesco_Pardescripsinac_Z = value ;
   }

   public void setgxTv_SdtParentesco_Pardescripsinac_Z_SetNull( )
   {
      gxTv_SdtParentesco_Pardescripsinac_Z = "" ;
      SetDirty("Pardescripsinac_Z");
   }

   public boolean getgxTv_SdtParentesco_Pardescripsinac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtParentesco_Parentipo_Z( )
   {
      return gxTv_SdtParentesco_Parentipo_Z ;
   }

   public void setgxTv_SdtParentesco_Parentipo_Z( String value )
   {
      gxTv_SdtParentesco_N = (byte)(0) ;
      SetDirty("Parentipo_Z");
      gxTv_SdtParentesco_Parentipo_Z = value ;
   }

   public void setgxTv_SdtParentesco_Parentipo_Z_SetNull( )
   {
      gxTv_SdtParentesco_Parentipo_Z = "" ;
      SetDirty("Parentipo_Z");
   }

   public boolean getgxTv_SdtParentesco_Parentipo_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.parentesco_bc obj;
      obj = new web.parentesco_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtParentesco_N = (byte)(1) ;
      gxTv_SdtParentesco_Parcod = "" ;
      gxTv_SdtParentesco_Pardescrip = "" ;
      gxTv_SdtParentesco_Parres551 = "" ;
      gxTv_SdtParentesco_Pardescripsinac = "" ;
      gxTv_SdtParentesco_Parentipo = "" ;
      gxTv_SdtParentesco_Mode = "" ;
      gxTv_SdtParentesco_Parcod_Z = "" ;
      gxTv_SdtParentesco_Pardescrip_Z = "" ;
      gxTv_SdtParentesco_Parres551_Z = "" ;
      gxTv_SdtParentesco_Pardescripsinac_Z = "" ;
      gxTv_SdtParentesco_Parentipo_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtParentesco_N ;
   }

   public web.SdtParentesco Clone( )
   {
      web.SdtParentesco sdt;
      web.parentesco_bc obj;
      sdt = (web.SdtParentesco)(clone()) ;
      obj = (web.parentesco_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtParentesco struct )
   {
      setgxTv_SdtParentesco_Clicod(struct.getClicod());
      setgxTv_SdtParentesco_Parcod(struct.getParcod());
      setgxTv_SdtParentesco_Pardescrip(struct.getPardescrip());
      setgxTv_SdtParentesco_Parres551(struct.getParres551());
      setgxTv_SdtParentesco_Parhabilitado(struct.getParhabilitado());
      setgxTv_SdtParentesco_Pardescripsinac(struct.getPardescripsinac());
      setgxTv_SdtParentesco_Parentipo(struct.getParentipo());
      setgxTv_SdtParentesco_Mode(struct.getMode());
      setgxTv_SdtParentesco_Initialized(struct.getInitialized());
      setgxTv_SdtParentesco_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtParentesco_Parcod_Z(struct.getParcod_Z());
      setgxTv_SdtParentesco_Pardescrip_Z(struct.getPardescrip_Z());
      setgxTv_SdtParentesco_Parres551_Z(struct.getParres551_Z());
      setgxTv_SdtParentesco_Parhabilitado_Z(struct.getParhabilitado_Z());
      setgxTv_SdtParentesco_Pardescripsinac_Z(struct.getPardescripsinac_Z());
      setgxTv_SdtParentesco_Parentipo_Z(struct.getParentipo_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtParentesco getStruct( )
   {
      web.StructSdtParentesco struct = new web.StructSdtParentesco ();
      struct.setClicod(getgxTv_SdtParentesco_Clicod());
      struct.setParcod(getgxTv_SdtParentesco_Parcod());
      struct.setPardescrip(getgxTv_SdtParentesco_Pardescrip());
      struct.setParres551(getgxTv_SdtParentesco_Parres551());
      struct.setParhabilitado(getgxTv_SdtParentesco_Parhabilitado());
      struct.setPardescripsinac(getgxTv_SdtParentesco_Pardescripsinac());
      struct.setParentipo(getgxTv_SdtParentesco_Parentipo());
      struct.setMode(getgxTv_SdtParentesco_Mode());
      struct.setInitialized(getgxTv_SdtParentesco_Initialized());
      struct.setClicod_Z(getgxTv_SdtParentesco_Clicod_Z());
      struct.setParcod_Z(getgxTv_SdtParentesco_Parcod_Z());
      struct.setPardescrip_Z(getgxTv_SdtParentesco_Pardescrip_Z());
      struct.setParres551_Z(getgxTv_SdtParentesco_Parres551_Z());
      struct.setParhabilitado_Z(getgxTv_SdtParentesco_Parhabilitado_Z());
      struct.setPardescripsinac_Z(getgxTv_SdtParentesco_Pardescripsinac_Z());
      struct.setParentipo_Z(getgxTv_SdtParentesco_Parentipo_Z());
      return struct ;
   }

   private byte gxTv_SdtParentesco_N ;
   private short gxTv_SdtParentesco_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtParentesco_Clicod ;
   private int gxTv_SdtParentesco_Clicod_Z ;
   private String gxTv_SdtParentesco_Parcod ;
   private String gxTv_SdtParentesco_Parentipo ;
   private String gxTv_SdtParentesco_Mode ;
   private String gxTv_SdtParentesco_Parcod_Z ;
   private String gxTv_SdtParentesco_Parentipo_Z ;
   private String sTagName ;
   private boolean gxTv_SdtParentesco_Parhabilitado ;
   private boolean gxTv_SdtParentesco_Parhabilitado_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtParentesco_Pardescrip ;
   private String gxTv_SdtParentesco_Parres551 ;
   private String gxTv_SdtParentesco_Pardescripsinac ;
   private String gxTv_SdtParentesco_Pardescrip_Z ;
   private String gxTv_SdtParentesco_Parres551_Z ;
   private String gxTv_SdtParentesco_Pardescripsinac_Z ;
}

