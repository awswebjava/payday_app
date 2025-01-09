package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem extends GxUserType
{
   public Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem( )
   {
      this(  new ModelContext(Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem.class));
   }

   public Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem( ModelContext context )
   {
      super( context, "Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem( int remoteHandle ,
                                                       ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem( StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegCodigo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegPreaTipo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegMeses") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegDura") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegPropor") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "sdt_concepto.sdt_conceptoItem.MotEgrItem" ;
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
      oWriter.writeElement("MegCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegPreaTipo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegMeses", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegDura", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegPropor", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("MegCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo, false, false);
      AddObjectProperty("MegPreaTipo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo, false, false);
      AddObjectProperty("ConMegMeses", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses, false, false);
      AddObjectProperty("ConMegDura", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura, false, false);
      AddObjectProperty("ConMegPropor", gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor, false, false);
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N ;
   }

   public web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem Clone( )
   {
      return (web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem struct )
   {
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo(struct.getMegcodigo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo(struct.getMegpreatipo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses(struct.getConmegmeses());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura(struct.getConmegdura());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor(struct.getConmegpropor());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem getStruct( )
   {
      web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem struct = new web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem ();
      struct.setMegcodigo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo());
      struct.setMegpreatipo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo());
      struct.setConmegmeses(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses());
      struct.setConmegdura(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura());
      struct.setConmegpropor(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegmeses ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegpropor ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megcodigo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Megpreatipo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem_Conmegdura ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

