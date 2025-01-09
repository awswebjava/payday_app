package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_datos_sec extends GxUserType
{
   public Sdtsdt_datos_sec( )
   {
      this(  new ModelContext(Sdtsdt_datos_sec.class));
   }

   public Sdtsdt_datos_sec( ModelContext context )
   {
      super( context, "Sdtsdt_datos_sec");
   }

   public Sdtsdt_datos_sec( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_datos_sec");
   }

   public Sdtsdt_datos_sec( StructSdtsdt_datos_sec struct )
   {
      this();
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
               gxTv_Sdtsdt_datos_sec_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtsdt_datos_sec_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtsdt_datos_sec_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "clientId") )
            {
               gxTv_Sdtsdt_datos_sec_Clientid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLote") )
            {
               gxTv_Sdtsdt_datos_sec_Liqlote = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "env") )
            {
               gxTv_Sdtsdt_datos_sec_Env = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ejecutarSolo") )
            {
               gxTv_Sdtsdt_datos_sec_Ejecutarsolo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               if ( gxTv_Sdtsdt_datos_sec_Legnumero == null )
               {
                  gxTv_Sdtsdt_datos_sec_Legnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtsdt_datos_sec_Legnumero.readxmlcollection(oReader, "LegNumero", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "sdt_datos_sec" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_sec_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_sec_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_sec_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("clientId", gxTv_Sdtsdt_datos_sec_Clientid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLote", gxTv_Sdtsdt_datos_sec_Liqlote);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("env", gxTv_Sdtsdt_datos_sec_Env);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ejecutarSolo", gxTv_Sdtsdt_datos_sec_Ejecutarsolo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtsdt_datos_sec_Legnumero != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtsdt_datos_sec_Legnumero.writexmlcollection(oWriter, "LegNumero", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("CliCod", gxTv_Sdtsdt_datos_sec_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtsdt_datos_sec_Empcod, false, false);
      AddObjectProperty("LiqNro", gxTv_Sdtsdt_datos_sec_Liqnro, false, false);
      AddObjectProperty("clientId", gxTv_Sdtsdt_datos_sec_Clientid, false, false);
      AddObjectProperty("LiqLote", gxTv_Sdtsdt_datos_sec_Liqlote, false, false);
      AddObjectProperty("env", gxTv_Sdtsdt_datos_sec_Env, false, false);
      AddObjectProperty("ejecutarSolo", gxTv_Sdtsdt_datos_sec_Ejecutarsolo, false, false);
      if ( gxTv_Sdtsdt_datos_sec_Legnumero != null )
      {
         AddObjectProperty("LegNumero", gxTv_Sdtsdt_datos_sec_Legnumero, false, false);
      }
   }

   public int getgxTv_Sdtsdt_datos_sec_Clicod( )
   {
      return gxTv_Sdtsdt_datos_sec_Clicod ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Clicod( int value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Clicod = value ;
   }

   public short getgxTv_Sdtsdt_datos_sec_Empcod( )
   {
      return gxTv_Sdtsdt_datos_sec_Empcod ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Empcod( short value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Empcod = value ;
   }

   public int getgxTv_Sdtsdt_datos_sec_Liqnro( )
   {
      return gxTv_Sdtsdt_datos_sec_Liqnro ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Liqnro( int value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Liqnro = value ;
   }

   public String getgxTv_Sdtsdt_datos_sec_Clientid( )
   {
      return gxTv_Sdtsdt_datos_sec_Clientid ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Clientid( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Clientid = value ;
   }

   public String getgxTv_Sdtsdt_datos_sec_Liqlote( )
   {
      return gxTv_Sdtsdt_datos_sec_Liqlote ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Liqlote( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Liqlote = value ;
   }

   public String getgxTv_Sdtsdt_datos_sec_Env( )
   {
      return gxTv_Sdtsdt_datos_sec_Env ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Env( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Env = value ;
   }

   public String getgxTv_Sdtsdt_datos_sec_Ejecutarsolo( )
   {
      return gxTv_Sdtsdt_datos_sec_Ejecutarsolo ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Ejecutarsolo( String value )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Ejecutarsolo = value ;
   }

   public GXSimpleCollection<Integer> getgxTv_Sdtsdt_datos_sec_Legnumero( )
   {
      if ( gxTv_Sdtsdt_datos_sec_Legnumero == null )
      {
         gxTv_Sdtsdt_datos_sec_Legnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      }
      gxTv_Sdtsdt_datos_sec_Legnumero_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      return gxTv_Sdtsdt_datos_sec_Legnumero ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Legnumero( GXSimpleCollection<Integer> value )
   {
      gxTv_Sdtsdt_datos_sec_Legnumero_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_sec_Legnumero = value ;
   }

   public void setgxTv_Sdtsdt_datos_sec_Legnumero_SetNull( )
   {
      gxTv_Sdtsdt_datos_sec_Legnumero_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_sec_Legnumero = null ;
   }

   public boolean getgxTv_Sdtsdt_datos_sec_Legnumero_IsNull( )
   {
      if ( gxTv_Sdtsdt_datos_sec_Legnumero == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtsdt_datos_sec_Legnumero_N( )
   {
      return gxTv_Sdtsdt_datos_sec_Legnumero_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_datos_sec_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_sec_Clientid = "" ;
      gxTv_Sdtsdt_datos_sec_Liqlote = "" ;
      gxTv_Sdtsdt_datos_sec_Env = "" ;
      gxTv_Sdtsdt_datos_sec_Ejecutarsolo = "" ;
      gxTv_Sdtsdt_datos_sec_Legnumero_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_datos_sec_N ;
   }

   public web.Sdtsdt_datos_sec Clone( )
   {
      return (web.Sdtsdt_datos_sec)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_datos_sec struct )
   {
      setgxTv_Sdtsdt_datos_sec_Clicod(struct.getClicod());
      setgxTv_Sdtsdt_datos_sec_Empcod(struct.getEmpcod());
      setgxTv_Sdtsdt_datos_sec_Liqnro(struct.getLiqnro());
      setgxTv_Sdtsdt_datos_sec_Clientid(struct.getClientid());
      setgxTv_Sdtsdt_datos_sec_Liqlote(struct.getLiqlote());
      setgxTv_Sdtsdt_datos_sec_Env(struct.getEnv());
      setgxTv_Sdtsdt_datos_sec_Ejecutarsolo(struct.getEjecutarsolo());
      setgxTv_Sdtsdt_datos_sec_Legnumero(new GXSimpleCollection<Integer>(Integer.class, "internal", "", struct.getLegnumero()));
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_datos_sec getStruct( )
   {
      web.StructSdtsdt_datos_sec struct = new web.StructSdtsdt_datos_sec ();
      struct.setClicod(getgxTv_Sdtsdt_datos_sec_Clicod());
      struct.setEmpcod(getgxTv_Sdtsdt_datos_sec_Empcod());
      struct.setLiqnro(getgxTv_Sdtsdt_datos_sec_Liqnro());
      struct.setClientid(getgxTv_Sdtsdt_datos_sec_Clientid());
      struct.setLiqlote(getgxTv_Sdtsdt_datos_sec_Liqlote());
      struct.setEnv(getgxTv_Sdtsdt_datos_sec_Env());
      struct.setEjecutarsolo(getgxTv_Sdtsdt_datos_sec_Ejecutarsolo());
      struct.setLegnumero(getgxTv_Sdtsdt_datos_sec_Legnumero().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_datos_sec_N ;
   protected byte gxTv_Sdtsdt_datos_sec_Legnumero_N ;
   protected short gxTv_Sdtsdt_datos_sec_Empcod ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_datos_sec_Clicod ;
   protected int gxTv_Sdtsdt_datos_sec_Liqnro ;
   protected String gxTv_Sdtsdt_datos_sec_Env ;
   protected String gxTv_Sdtsdt_datos_sec_Ejecutarsolo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_datos_sec_Clientid ;
   protected String gxTv_Sdtsdt_datos_sec_Liqlote ;
   protected GXSimpleCollection<Integer> gxTv_Sdtsdt_datos_sec_Legnumero=null ;
}

